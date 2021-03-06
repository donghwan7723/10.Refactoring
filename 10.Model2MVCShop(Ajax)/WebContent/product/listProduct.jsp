<%@ page contentType="text/html; charset=EUC-KR" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html>

<head>
<title>상품 목록조회</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

<%--	// 검색 / page 두가지 경우 모두 Form 전송을 위해 JavaScrpt 이용  
	function fncGetList(currentPage) {
		document.getElementById("currentPage").value = currentPage;
	   	document.detailForm.submit();		
	}--%>
	
	function fncGetList(currentPage){
		//var menu = ${param.menu};
		//console.log(menu);
		$("#currentPage").val(currentPage)
		$("form").attr("method", "POST").attr("action", "/product/listProduct?menu=${param.menu}").submit();

		
	}
			
	$(function() {

		
			$(".manage").bind("click",function(){
				 var prodNo =  $(this).data("param1");
			
				 self.location="/product/updateProductView?prodNo="+prodNo+"&menu=manage"				 
			});
			
			//getProduct 실행
			$(".trancode").bind("click",function(){
				 var brandId = $(this).data("brandName");
				 console.log(brandId);
				 var prodNo = $(this).data("param2");
				 console.log(prodNo);
				 self.location="/product/getProduct?prodNo="+prodNo+"&menu=search&brandId="+brandId
			});
			
			//배송하기 event
			$("#transfer").bind("click",function(){
				 var prodNo = $(this).data("param3");
				 self.location="/purchase/updateTranCodeByProd?prodNo="+prodNo+"&tranCode=2"
			});
			 
			$(".searchfor").bind("click",function(){
				 self.location = "javascript:fncGetList('1')";
			})
			 
			//리스트 색상 입히기
			$(".ct_list_pop:nth-child(4n+6)" ).css("background-color" , "whitesmoke");

			//상품명 색상 입히기
			$( ".ct_list_pop td:nth-child(3)" ).css("color" , "red");
			$("h7").css("color" , "red");

	});	


		
</script>

</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm">

<input type="hidden" name="prodNo" value="${param.menu}"/>

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">

			
				<tr>
				<c:if test="${param.menu=='manage'}">						
					<td width="93%" class="ct_ttl01">상품 관리</td>
				</c:if>			
	   			<c:if test="${param.menu=='search'}">		
	   				<td width="93%" class="ct_ttl01">상품 목록조회</td>
	   			</c:if>	
	   			</tr>	
			
			</table>
		</td>
		

		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0" ${!empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>상품번호</option>
				<option value="1" ${!empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>상품명</option>
				<option value="2" ${!empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>상품가격</option>	
			</select>
			<input type="text" name="searchKeyword" value="${search.searchKeyword}"
							 class="ct_input_g" style="width:200px; height:19px" />
		</td>
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
				<!--  		<a href="javascript:fncGetList('1');">검색</a>    -->
					<span class = "searchfor">검색</span>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

	<select name="sortCondition" class="ct_input_g" style="width:80px" onchange="javascript:fncGetList('1');">
		<option value=null>가격순 </option>
		<option value="desc" ${!empty search.sortCondition && search.sortCondition=='desc' ? "selected" : "" }>높은가격순</option>
		<option value="asc" ${!empty search.sortCondition && search.sortCondition=='asc' ? "selected" : "" }>낮은가격순</option>	
	</select>   			


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >
			전체 ${resultPage.totalCount} 건수, 현재 ${resultPage.currentPage} 페이지</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">브랜드</td>
		<td class="ct_line02"></td>		
		<td class="ct_list_b" width="150">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">가격</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">등록일</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">현재상태</td>	
		<td class="ct_line02"></td>
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	
	<c:set var="i" value="0"/>
	<c:forEach var="product" items="${list}">
	   <c:set var="trimTranCode" value="${fn:trim(product.proTranCode)}"/> 
 	   <c:set var="i" value="${i+1}" /> 
	   <tr class="ct_list_pop" data-param="${product.prodNo}" >
		<td align="center">${i}</td>
		<td></td>
		<td align="left" data-brandName="${product.brandIden.brandName}">
		${product.brandIden.brandName}
		<td></td>
		<td align="left" >
		<c:if test="${param.menu=='manage'}">
	     <!--  	<a href = "/product/updateProductView?prodNo=${product.prodNo}&menu=manage">${product.prodName}</a>  -->
		<span class="manage" data-param1="${product.prodNo}"> ${product.prodName}</span>
		</c:if>
		<c:if test="${param.menu=='search'}">
			<c:if test="${!(trimTranCode=='0')}">
			<span>${product.prodName}</span>
			</c:if>
			<c:if test="${trimTranCode=='0'}">
		 <!--	<a href = "/product/getProduct?prodNo=${product.prodNo}&menu=search">${product.prodName}</a>   -->
		 <span class="trancode" data-param2="${product.prodNo}"> ${product.prodName}</span>
			</c:if>
		</c:if>
		</td>
		<td></td>
		<td align="left">${product.price}</td>
		<td></td>
		<td align="left">${product.regDate}</td>
		<td></td>
		<td align="left">
 			

		<c:if test="${user==null && param.menu=='search'}">
			${trimTranCode=='0' ? '판매중' : '재고없음'}		 
		</c:if>
		 
		<c:if test="${! (user==null)}">
			<c:if test="${param.menu=='search'}">
				<c:if test="${user.role=='admin'}">

					<c:if test="${trimTranCode=='0'}">
						판매중
					</c:if>
		
					<c:if test="${trimTranCode=='1'}">
						구매완료
					</c:if>

					<c:if test="${trimTranCode=='2'}">
						배송중
					</c:if>

					<c:if test="${trimTranCode=='3'}">
						배송완료
					</c:if>			
		 	    </c:if>
		 	    
		     <c:if test="${user.role=='user'}">
		  	 	${trimTranCode=='0'? '판매중' : '재고없음'}
		  	 </c:if>
		 </c:if>
		 <c:if test="${param.menu=='manage'}">
		
			   <c:if test="${trimTranCode=='0'}">
		  	   		판매중
		  	   </c:if>
		  	   
		  	   <c:if test="${trimTranCode=='1'}">
		  	<!--     		구매완료<a href ="/purchase/updateTranCodeByProd?prodNo=${product.prodNo}&tranCode=2">배송하기</a>  -->
		  		구매완료 <span id="transfer" data-param3="${product.prodNo}" >배송하기</span>
		  	   </c:if>
		  	   
		  	   <c:if test="${trimTranCode=='2'}">
		  	   		배송중
		  	   </c:if>
		  	   
		  	   <c:if test="${trimTranCode=='3'}">
		  	   		배송완료   		
		  	   </c:if>
		 </c:if>
	</c:if>		

		</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	</c:forEach>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
			<input type="hidden" id="currentPage" name="currentPage" value=""/>

				<jsp:include page="../common/pageNavigator.jsp"/>
   
    	</td>
	</tr>
	
</table>
<!--  페이지 Navigator 끝 -->

</form>

</div>
</body>
</html>
