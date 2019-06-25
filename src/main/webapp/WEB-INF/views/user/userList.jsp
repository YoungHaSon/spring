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

<title>사용자 리스트</title>

	<!-- LibLib(Css,js) -->
	<%@include file="/WEB-INF/views/common/basicLib.jsp" %>
</head>

<body>
	<!--  header영역 -->
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
		
	<!--  left영역 -->
	<%@include file="/WEB-INF/views/common/left.jsp" %>
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디(el)</th>
									<th>사용자 이름(el)</th>
									<th>사용자 별명(el)</th>
									<th>등록일시</th>
								</tr>

								<!-- for을 돌릴 대상을 items에 넣으면 된다 el로!! user라는 이름에 하나씩 넣어준다. -->
								<!-- userList의 데이터를 한건 조회해서 pageContext.setAttribute("user",vo); -->
								<!-- var="user" userVo타입입니다... -->
								<c:forEach items="${userList }" var="vo" varStatus="status">
									<tr>
									<!-- user.userId / userId는-> userVo 속성명을 가져다 쓴다  -->
										<td>${vo.userId }</td>
										<td>${vo.name }</td>
										<td>${vo.alias }</td>
										<td></td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
							</ul>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
</body>
</html>
