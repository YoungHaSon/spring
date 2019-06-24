<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${cp}/main.jsp">Main.jsp</a></li>
	
		<li class="active"><a href="${cp}/userList">/user/userList.jsp</a></li>
		
		<!-- a 태그는 기본적으로 get방식을 사용 -->
		<li class="active"><a href="${cp}/userPagingList">/user/pagination.jsp</a></li>
		
		<!-- a 태그는 기본적으로 get방식을 사용 -->
		<li class="active"><a href="${cp}/lprodpagination">Lprod_PageList</a></li>
	</ul>
</div>