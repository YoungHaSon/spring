<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="blog-header">
	<h1 class="blog-title">Main</h1>
	<p class="lead blog-description">Spring</p>
</div>

<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="blog-post">
			<h2 class="blog-post-title">Spring-tiles</h2>
			<p id="p1" class="blog-post-meta">
				<%
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				%>
				<%=sdf.format(date) %>, room 204
				<!-- Date를 el형식으로 어찌 바꾸지??? -->
			</p>

			<p>jsp를 통한 웹 프로그래밍 학습</p>
			<hr>

			<h3>상세내역</h3>
			<p>Spring과정에서는 다음과 같은 내용을 학습한다.</p>
			<ul>
				<li>${userVo}</li>
				<li>jsp와 servlet의 관계</li>
				<li>jsp 스크립틀릿 요소</li>
				<li>jsp action tag (standard)</li>
				<li>jstl</li>
				<li>db pooling</li>
				<li>페이지 모듈화</li>

			</ul>
		</div>
	</div>
</div>

