package com.pomaden.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.pomaden.model.ProductDAO;
import com.pomaden.model.ProductDTO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO dao;
	private final String serverIP = "192.168.1.100";
	private int serverPort = 22;
	private final String serverUser = "root";
	private final String serverPass = "1";
	private ChannelSftp chSftp = null;

	public int insert(ProductDTO dto) throws Exception {
		File dest1 = null;
		if (dto.getProduct_upload() != null) {
			MultipartFile file = dto.getProduct_upload();
			dest1 = new File(file.getOriginalFilename());
			file.transferTo(dest1);
		}
		// 웹서버에 생성된 임시파일을 파일서버에 전송
		Session sess = null;
		Channel channel = null;
		JSch jsch = new JSch();

		sess = jsch.getSession(serverUser, serverIP, serverPort);
		sess.setPassword(serverPass);
		sess.setConfig("StrictHostKeyChecking", "no");
		sess.connect();
		System.out.println("sftp > connected");
		channel = sess.openChannel("sftp");
		channel.connect();

		chSftp = (ChannelSftp) channel;

		FileInputStream fis = new FileInputStream(dest1);
		chSftp.cd("/var/www/html/product");
		chSftp.put(fis, dest1.getName());
		System.out.println("sftp> transfer complete");

		fis.close();
		chSftp.exit();

		String uploadFilePath = "";
		uploadFilePath += "http://";
		uploadFilePath += serverIP;
		uploadFilePath += ":80"; // 기본 포트는 80이며 작성필요없으나, 서비스가 중복된다면 별도로 지정
		uploadFilePath += "/product/" + dto.getProduct_upload().getOriginalFilename();

		dto.setProduct_img(uploadFilePath);

		return dao.insert(dto);
	}

	public List<ProductDTO> selectAll() {
		return dao.selectAll();
	}

}
