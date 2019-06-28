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
		$("#userListTbody").on("click",".userTr", function(){
			var userId = $(this).find(".userId").text();
			$('#userId').val(userId);
			
			$('#frm').submit();
		});
		
		//첫번째 페이지의 사용자 정보를 요청
// 		userPagingListAjax(1,10);
		userPagingListAjaxHtml(1,10);
	});
	
	//데이터 응답을 html로 받는 경우
	function userPagingListAjaxHtml(page,pageSize){
		$.ajax({
			url : "/user/pagingListAjaxHtml",
			method : "post",
			data : "page=" + page + "&pageSize"+ pageSize,
			success : function(data){
				//html이 온다!
				var html = data.split("SEPERATORSEPERATOR");
				$("#userListTbody").html(html[0]);
				$(".pagination").html(html[1]);
			}
		});
	}
	
	//테이터 응답을 json으로 받는 경우
	function userPagingListAjax(page,pageSize){
		$.ajax({
			url : "/user/pagingListAjax",
			method : "post",
			data : "page=" + page + "&pageSize"+ pageSize,
			success : function(data){
				
				//사용자 리스트
				var html ="";
				data.data.userList.forEach(function(user){
				//html생성
				html += "<tr class='userTr' data-userid='"+ user.userId + "'>";	
				html += "	<td class='userId'>"+ user.userId + "</td>";	
				html += "	<td>" + user.name + "</td>";	
				html += "	<td>" + user.alias + "</td>";	
				html += "	<td></td>";	
				html += "</tr>";	
				});
				
				//페이지네이션 생성
				var pHtml = "";
				var pageVo = data.pageVo
				
				if(pageVo.page==1)
					pHtml += "<li class='disabled'><span>«<span></li>";
				else
					pHtml += "<li><a href='javascript:userPagingListAjax("+(pageVo.page-1)+", "+pageVo.pageSize+");'>«</a></li>";
				
				for(var i =1; i <=data.data.pagenationSize; i++){
					if(pageVo.page==i)
						pHtml += "<li class='active'><span>" + i + "</span></li>";
					else
						pHtml += "<li><a href='javascript:userPagingListAjax("+ i + ", " + pageVo.pageSize+");'>"+i+"</a></li>";
				}
				
				if(pageVo.page == data.data.pagenationSize)
					pHtml += "<li class='disabled'><span>»<span></li>";
				else
					pHtml += "<li><a href='javascript:userPagingListAjax("+(pageVo.page+1)+", "+pageVo.pageSize+");'>»</a></li>";
				
				console.log("html : ", html);
				$("#userListTbody").html(html);
				$(".pagination").html(pHtml);
				
			}
		});	
	}

</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">UserList(ajax)</h2>

		<!-- 사용자 상세조회 : userId필요 -->
		<form id="frm" action="${cp }/user/user" method="get">
			<input type="hidden" id="userId" name="userId">
		</form>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
				<tr>
					<th>사용자 아이디)(el)</th>
					<th>사용자 이름(el)</th>
					<th>사용자 별명(el)</th>
					<th>등록일시</th>
				</tr>
				</thead>
				
				<tbody id="userListTbody">
				</tbody>
				
			</table>
		</div>

		<div class="text-center">
			<ul class="pagination"></ul>
		</div>
	</div>
</div>

