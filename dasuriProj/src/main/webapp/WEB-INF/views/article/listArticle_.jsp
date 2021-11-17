<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
		</tr>
		<c:forEach var="article" items="${articlePage.content }" varStatus="stat">
		<tr>
			<td>${article.rnum }</td>
			<td>${article.title }</td>
			<td>${article.writerVO.writerName }</td>
			<td>${article.readCnt }</td>		
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" style="text-algin:center;">
			<c:if test="${articlePage.startPage > 5 }">
			<a href="/article/listArticle?currentPage=${articlePage.startPage - 5}">[이전]</a>
			</c:if>	
			
				<c:forEach var="pNo" begin="${articlePage.startPage }" end="${articlePage.endPage }">
				<a href="/article/listArticle?currentPage=${pNo }">[${pNo }]</a>&nbsp;
				</c:forEach>
			
			<c:if test="${articlePage.endPage > articlePage.totalPages }">			
			<a href="/article/listArticle?currentPage=${articlePage.startPage + 5}">[다음]</a>
			</c:if>
			</td>
		</tr>	
	</table>
</body>
</html>