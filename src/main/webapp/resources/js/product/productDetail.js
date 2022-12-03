// color 선택 함수입니다
function colorOnClick(event) {
	colors.forEach(color => {
		color.style.backgroundColor = '#F9F9F9'
		color.style.color = 'black'
	})
	event.target.style.backgroundColor = '#333'
	event.target.style.color = 'white'
}
// size 선택 함수입니다
function sizeOnClick(event) {
	sizes.forEach(size => {
		size.style.backgroundColor = '#F9F9F9'
		size.style.color = 'black'
	})
	event.target.style.backgroundColor = '#333'
	event.target.style.color = 'white'
}
// 상품정보 클릭시 드롭박스 띄우기 함수입니다
function infoOnClick(event) {
	const info_dropbox = document.querySelector(".productDetail_info_dropbox")
	const info_box = document.querySelector(".productDetail_product_info_box")
	if(info_box == event.target) {
		if(info_dropbox.classList.contains('hidden') == false ) {
			info_dropbox.classList.add('hidden')
			event.target.style.height = 'auto'
		}
		else {
			info_dropbox.classList.remove('hidden')
			event.target.style.height = '150px'
		}
	}
}