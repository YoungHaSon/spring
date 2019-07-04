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
		
		//(@ResponseBody 어노테이션을 이용한 데이터 요청)
		$("#requestDataResponseBody").on('click', function() {
			$.ajax({
				
				url : "/ajax/requestDataResponseBody",
				method : "post",
				success : function(data) {
					//data.pageVo : {pageVo : {page : 5, pageSize:10}}
					$("#pageResponseBody").text(data.page);
					$("#pageSizeResponseBody").text(data.pageSize);
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
		
		//전송할 json객체를 준비! (익명객체!)
		var user = {userId:"brown",pass :"brown1234"};
		//JSON.stringify(user) --> 자바스크립트 객체를 json 문자열로 생성
		//JSON.parse("json문자열") --> json문자열을 자바스크립트 객체로 변경
		$('#userFormString').text("userId=borwn&pass=brown1234");
		$('#userJsonString').text(JSON.stringify(user));
		
		$("#userJsonStringBtn").on('click',function(){
			$.ajax({
				url :"/ajax/requestBody",
				method :"post",
				//ajax를 통해서 보내는 데이터 형식이 json임을 알려준다?				
				contentType : "application/json", 
				dataType : "json", //받는 파일 형식을 지정 할수 있다?
// 				dataType : "xml", //받는 파일 형식을 지정 할수 있다?
				data : JSON.stringify(user),
				success : function(data){
					console.log(data);
						$(".userId").text(data.userId);
						$(".pass").text(data.pass);
						//xml로 하려면!
// 						$(".userId").text(data.getElementsByTagName("userId")[0].textContent);
// 						$(".pass").text(data.getElementsByTagName("pass")[0].textContent);
				}
			});
		});
		//get방식일때는 requestBody가 읎다?
	});
</script>

<h2>ajax json 데이터 요청</h2>
<a id="requestData">데이터 가져오기</a><br>
page :<span id="page"></span>
<br>
pageSize :<span id="pageSize"></span>

<h2>ajax json 데이터 요청(@ResponseBody 어노테이션을 이용한 데이터 요청)</h2>
<a id="requestDataResponseBody">데이터 가져오기</a><br>
page :<span id="pageResponseBody"></span>
<br>
pageSize :<span id="pageSizeResponseBody"></span>

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

<h2>ajax json 데이터 보내기!</h2>
<a id="userJsonStringBtn">데이터 보내기!</a>
요청 보내는 데이터!(기존) : <div id="userFormString"></div>
요청 보내는 데이터! : <div id="userJsonString"></div>
받는 데이터! : 
<div id="userJsonResult">
	userId : <span class="userId"></span><br>
	pass : <span class="pass"></span>
</div>



