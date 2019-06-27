<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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

<title>사용자 상세조회</title>

<!-- LibLib(Css,js) -->
<%@include file="/WEB-INF/views/common/basicLib.jsp"%>

<!-- 	<script>
		$(document).ready(function(){
			<c:if test="${msg != null}">
				alert("${msg}");
			</c:if>
		});
	</script>  -->
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
						<h2 class="sub-header">사용자 상세정보</h2>
						
						<form id="frm" class="form-horizontal" role="form" action="${cp }/user/modify" method="get">
							<input value="${userVo.userId }" type="hidden" id="userId" name="userId">
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자 사진&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
								<!-- get방식으로 갑니다잉 -->
									<img src="${cp }/user/profile?userId=${userVo.userId}">
								</div>
							</div>
						
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자아이디&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
									<label class="control-label">${requestScope.userVo.userId }</label>
										<!-- <input type="text" class="form-control" id="userId"
										name="userId" placeholder="사용자 아이디"> -->
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자이름&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
									<label class="control-label">${requestScope.userVo.name }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">별명&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
									<label class="control-label">${requestScope.userVo.alias }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">생일&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
							<fmt:formatDate value="${requestScope.userVo.birth }" var="birth" pattern="yyyy-MM-dd"/>
									<label class="control-label">${birth }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">우편번호&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
									<label class="control-label">${requestScope.userVo.zipcd }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">주소&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
									<label class="control-label">${requestScope.userVo.addr1 }</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">상세주소&nbsp;&nbsp; :  </label>
								<div class="col-sm-10">
									<label class="control-label">${requestScope.userVo.addr2 }</label>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit">정보수정</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
