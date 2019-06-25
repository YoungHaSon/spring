<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- core라이브러리를 쓸꺼니까! uri 잘 확인 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<style>
	.userTr:hover{
		cursor : pointer;
	}
</style>

<title>사용자 리스트</title>

<!-- LibLib(Css,js) -->
<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
<script>
	$(document).ready(function(){
		//사용자 tr 태그 이벤트 등록
		$(".userTr").on("click", function(){
			console.log("userTr click");
			//해당 tr을 클릭했을때 어떤 userId인지 받아올라고 userId획득 방법
			//$(this).find(".userId").text();
			//$(this).data("userId");
			
			//사용자 Id를 값으로 설정해주고
			var userId = $(this).find(".userId").text();
			$('#userId').val(userId);
			
			//#frm 을 이용하여 submit();
			$('#frm').submit();
			
		});
	});

</script>
</head>

<body>
	<!--  header영역 -->
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!--  left영역 -->
			<%@include file="/WEB-INF/views/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						
						<!-- 사용자 상세조회 : userId필요 -->
						<form id="frm" action="${cp }/user" method="get">
							<input type="hidden" id="userId" name="userId">
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디)(el)</th>
									<th>사용자 이름(el)</th>
									<th>사용자 별명(el)</th>
									<th>등록일시</th>
								</tr>
 
 								<!-- userList user들을 출력해주는! -->
								<c:forEach items="${userList }" var="vo">
									<!-- data-는 참고로 대문자 안먹어요 -->
									<tr class="userTr" data-userid="${vo.userId} }">
									<td class="userId">${vo.userId }</td>
									<td>${vo.name }</td>
									<td>${vo.alias }</td>
									<td></td>	
									</tr>
								</c:forEach>
							</table>
						</div>

						<a href="${cp}/userForm" class="btn btn-default pull-right">사용자 등록</a>

						<!-- 
							사용자수 : 105건
							페이지네이션 : 11건 
							쿼리문2개! 전체건수 조회, 해당페이지에 대해서 조회하는 쿼리!
						-->

						<div class="text-center">
							<ul class="pagination">
							
							<c:choose>
								<c:when test="${pageVo.page eq 1}">
									<li class="disabled"><span>«</span></li>
								</c:when>
								<c:otherwise>
									<li>
									<a href=" ${cp }/userPagingList?page=${pageVo.page-1}&pageSize=${pageVo.pageSize}">«</a>
									</li>
								</c:otherwise>
							</c:choose>
							
							
					<%-- 	<% PageVo pageVo = (PageVo) request.getAttribute("pageVo");%>  --%>
<%-- 							<%if(pageVo.getPage()==1){ %> --%>
<!-- 								<li class="disabled"><span>«</span></li> -->
<%-- 							<%}else{ %> --%>
<!-- 								<li> -->
<%-- 									<a href=" ${cp }/userPagingList?page=<%=pageVo.getPage()-1%>&pageSize=<%=pageVo.getPageSize()%>">«</a> --%>
<!-- 								</li> -->
<%-- 							<%} %> --%>
							
								<!-- 내가 현재 어떤 Page를 보고있나? 어떻게 알지??? 최대 page수 -->
								
							<%-- <%	int paginationSize = (Integer) request.getAttribute("paginationSize"); %> --%>
								
								<c:forEach var="i" begin="1" end="${paginationSize }">
									<c:choose>
										<c:when test="${pageVo.page eq i}" >
											<li class="active">
												<span>${i}</span>
											</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${cp }/userPagingList?page=${i}&pageSize=${pageVo.pageSize}">${i}</a>
										</li>
									</c:otherwise>	
									</c:choose>
								</c:forEach>
								
								<%-- <% for (int i = 1; i <= paginationSize; i++) {%>

									<%if(pageVo.getPage() == i){ %>
											<li class="active">
												<span><%=i %></span>
											</li>
									<%}else{%>
											<li>
												<a href="${cp }/userPagingList?page=<%=i%>&pageSize=${pageVo.pageSize}"><%=i%></a>
											</li>
										<%} %>
									<%} %> --%>
									
								<c:choose>
								<c:when test="${pageVo.page eq paginationSize }">
									<li class="disabled"><span>»</span></li>
								</c:when>
								<c:otherwise>
									<li>
									<a href=" ${cp }/userPagingList?page=${pageVo.page+1}&pageSize=${pageVo.pageSize}">»</a>
									</li>
								</c:otherwise>
								</c:choose>
								
								<%-- 	<%if(pageVo.getPage()==paginationSize){ %>
								<li class="disabled"><span>»</span></li>
							<%}else{ %>
								<li>
									<a href=" ${cp }/userPagingList?page=<%=pageVo.getPage()+1%>&pageSize=<%=pageVo.getPageSize()%>">»</a>
								
								</li>
							<%} %> --%>
									
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
