<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->									
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->									
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>									
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->									
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/spring/resources/common.css" >
</head>
<body>
<form action="/spring/guest/write" method = "post">

<textarea rows = "3" name = 'btext'></textarea>
 
 <a href="${cp}/guest/write">새글 쓰기</a>

</form>
</body>
</html>