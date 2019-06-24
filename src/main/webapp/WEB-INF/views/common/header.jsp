<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<!-- 정상적으로 로그인 했을 경우 USER_INFO 에 있는 name 속성 출력 
			사용자가 로그인하지 않고 main.jsp로 직접 접속했을 경우 (local/jsp/main.jsp) "접속하지 않은 사용자 입니다 라는 문구 표시!"  -->
			<a class="navbar-brand" href="#">JSP/SPRING
				<c:choose>
					<c:when test="${empty USER_INFO }"> <!--USER_INFO==null  -->
						"접속하지 않은 사용자 입니다"
					</c:when>
					<c:otherwise>
						${USER_INFO.name }
					</c:otherwise>
				</c:choose>
			</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">DashBoard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>

				<li><a href="${cp}/logout">Logout</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>

