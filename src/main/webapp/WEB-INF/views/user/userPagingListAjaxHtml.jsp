<%@page import="kr.or.ddit.user.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core라이브러리를 쓸꺼니까! uri 잘 확인 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


				<!-- userList user들을 출력해주는! -->
				<c:forEach items="${data.userList }" var="vo">
					<!-- data-는 참고로 대문자 안먹어요 -->
					<tr class="userTr" data-userid="${vo.userId}">
						<td class="userId">${vo.userId }</td>
						<td>${vo.name }</td>
						<td>${vo.alias }</td>
						<td>
							<a href="${cp}/user/userListExcel?filename=${vo.userId}&userId=${vo.userId}">excel다운</a>
						</td>
					</tr>
				</c:forEach>
				
SEPERATORSEPERATOR			

				<c:choose>
					<c:when test="${pageVo.page eq 1}">
						<li class="disabled"><span>«</span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="javascript:userPagingListAjaxHtml(${pageVo.page-1},${pageVo.pageSize});">«</a>
						</li>
					</c:otherwise>
				</c:choose>

				<c:forEach var="i" begin="1" end="${data.paginationSize }">
					<c:choose>
						<c:when test="${pageVo.page eq i}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="javascript:userPagingListAjaxHtml(${i},${pageVo.pageSize});">${i}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pageVo.page eq data.paginationSize }">
						<li class="disabled"><span>»</span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="javascript:userPagingListAjaxHtml(${pageVo.page+1},${pageVo.pageSize});">»</a>
						</li>
					</c:otherwise>
				</c:choose>

