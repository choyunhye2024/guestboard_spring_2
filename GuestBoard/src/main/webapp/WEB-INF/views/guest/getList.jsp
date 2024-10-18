<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->									
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->									
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>									
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->									
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
<%@page import="com.peisia.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 - 글 목록</title>
<link rel="stylesheet" href="/spring/resources/common.css" >
</head>
<body>
<h1>방명록</h1>
<h2>글목록</h2>
<table>
	<tr>
		<td>번호</td>
		<td>내용</td>
	</tr>
	
<%
	Object o = request.getAttribute("list");
	List<GuestDto> list = (List<GuestDto>)o; 
	for(int i=0;i<list.size();i++){
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
%>	
	<tr>
		<td><%=bno %></td>
		<td><a href="/spring/guest/read?bno=<%=bno%>"> <%=btext %> </a></td>
	<tr>
<%		
	}
%>
</table>

<br><br>

<!-- [ ] 글쓰기 페이지로 이동 -->
<a href="/spring/guest/write">새글 쓰기</a>

</body>
</html>