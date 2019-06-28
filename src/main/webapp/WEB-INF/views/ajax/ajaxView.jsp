<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	

<script>
	$(document).ready(function() {
		/* 옵션값 url, method */

		//requestData 클릭시 이벤트 핸들러
		$("#requestData").on('click', function() {
			$.ajax({
				
				url : "/ajax/requestData",
				method : "post",
				//success 응답상태가 정상일때 함수를 호출!
				success : function(data) {
					
					//pageVo.page, pageVo.pageSize
					$("#page").text(data.pageVo.page);
					$("#pageSize").text(data.pageVo.pageSize);
				}
			});
		});
		
		//user 클릭시 이벤트 핸들러
		$("#user").on('click',function(){
			$.ajax({
				url : "/ajax/user",
				method : "post",
				data : "userId="+$("#userId").val(),
				success : function(data){
// 				name : <input type="text" id="name" readonly/>
// 				alias : <input type="text" id="alias" readonly/>
// 				birth : <input type="text" id="birth" readonly/>
				var html = "";
				html += "name : <input type=\"text\" id=\"name\" readonly value=\"" + data.userVo.name+"\"/> <br>";		
				html += "alias : <input type=\"text\" id=\"alias\" readonly value=\"" + data.userVo.alias+"\"/> <br>";		
				html += "birth : <input type=\"text\" id=\"birth\" readonly value=\"" + data.userVo.birth+"\"/> <br>";		
				
				$("#userJsonInfo").html(html);
				
				}
			});
		})
		//userHtml 클릭시 이벤트 핸들러
		$("#userHtml").on('click',function(){
			$.ajax({
				url : "/ajax/userHtml",
				method : "post",
				data : $("#frm").serialize(), //파라미터 보내는방법!(여러개일 수록 유리해!)
				success : function(data){
					$("#userInfo").html(data);
				
				}
			});
		})
		
	});
</script>

<h2>ajax json 데이터 요청</h2>
<a id="requestData">데이터 가져오기</a><br>
page :<span id="page"></span>
<br>
pageSize :<span id="pageSize"></span>

<h2>ajax json 데이터 요청(user)</h2>
<a id="user">데이터 가져오기</a><br>
userId : <input type="text" id="userId" value="brown"/><br><br>
<div id="userJsonInfo"></div>

<h2>ajax html 데이터 요청(user)</h2>
<a id="userHtml">데이터 가져오기</a><br>
<form id="frm">
userId : <input type="text" id="userIdHtml" value="brown" name="userId"/>
</form>
<div id="userInfo"></div>




