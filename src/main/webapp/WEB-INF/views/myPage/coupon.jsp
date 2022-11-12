<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<main>
	<div class="myPage_component">
		<div class="myPage_title">마이페이지</div>
		<div class="myPage_kinds_box aice jcsb">
			<a href="${cpath }/myPage?category=orderList" class="myPage_orderList myPage_kind jcce aice">주문내역</a>
			<a href="${cpath }/myPage?category=point" class="myPage_point myPage_kind jcce aice">포인트</a>
			<a href="${cpath }/myPage?category=coupon" class="myPage_coupon myPage_kind jcce aice">쿠폰</a>
			<a href="${cpath }/myPage?category=board" class="myPage_board myPage_kind jcce aice">게시글</a>
			<a href="${cpath }/myPage?category=like" class="myPage_like myPage_kind jcce aice">좋아요 상품</a>
			<a href="${cpath }/myPage?category=member_info" class="myPage_member_info myPage_kind jcce aice">회원정보 관리</a>
			<a href="${cpath }/myPage?category=myQuestion" class="myPage_question myPage_kind jcce aice">문의내역</a>
		</div>
		
		
		<div class="myPage_coupon_title">쿠폰</div>
		<div class="myPage_coupon_box">
			<div class="myPage_coupon_info df">
				<div class="myPage_coupon_name jcce aice">쿠폰명</div>
				<div class="myPage_coupon_benefit jcce aice">사용혜택</div>
				<div class="myPage_coupon_condition jcce aice">사용조건</div>
				<div class="myPage_coupon_date jcce aice">유효기간</div>
			</div>
		</div>
	</div>
</main>
<script>
	const link =  'myPage_' + document.location.href.split("/").reverse()[0];
	const myPage_category = '${category}'
	const class_category = document.querySelector('.myPage_' + myPage_category)
	class_category.style.color = 'black'
	class_category.style.fontWeight = '700'
</script>
<%@ include file="../footer.jsp" %>