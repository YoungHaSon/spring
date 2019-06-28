<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core라이브러리를 쓸꺼니까! uri 잘 확인 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.userTr:hover {
	cursor: pointer;
}
</style>

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

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">
			<a href="${cp}/user/userListExcel?filename=userList">UserList(tiles)</a>
		</h2>

		<!-- 사용자 상세조회 : userId필요 -->
		<form id="frm" action="${cp }/user/user" method="get">
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
					<tr class="userTr" data-userid="${vo.userId}">
						<td class="userId">${vo.userId }</td>
						<td>${vo.name }</td>
						<td>${vo.alias }</td>
						<td><a
							href="${cp}/user/userListExcel?filename=${vo.userId}&userId=${vo.userId}">excel
								다운</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<a href="${cp}/user/form" class="btn btn-default pull-right">사용자
			등록</a>

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
						<li><a
							href=" ${cp }/user/pagingList?page=${pageVo.page-1}&pageSize=${pageVo.pageSize}">«</a>
						</li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="i" begin="1" end="${paginationSize }">
					<c:choose>
						<c:when test="${pageVo.page eq i}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${cp }/user/pagingList?page=${i}&pageSize=${pageVo.pageSize}">${i}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pageVo.page eq paginationSize }">
						<li class="disabled"><span>»</span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href=" ${cp }/user/pagingList?page=${pageVo.page+1}&pageSize=${pageVo.pageSize}">»</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>

