package com.pomaden.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pomaden.model.ProductDTO;
import com.pomaden.service.ProductService;

@Controller
public class ProductController {
	@Autowired private ProductService ps;
	
	@GetMapping("/product/productList")
	public ModelAndView selectCategory(String category, String kind) {
		ModelAndView mav = new  ModelAndView();
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("category", category);
		if(kind.equals("전체") == false) {
			data.put("kind", kind);
		}
		List<ProductDTO> list = ps.selectList(data);
		List<ProductDTO> kindAll = ps.selectKind(category);
		mav.addObject("category", category);
		mav.addObject("kind", kind);
		mav.addObject("kindAll", kindAll);
		mav.addObject("list", list);
		return mav;
	}
}
