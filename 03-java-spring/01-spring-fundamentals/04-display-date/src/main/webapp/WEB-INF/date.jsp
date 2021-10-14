<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/date.css" media="all" />
<script src="js/date.js"></script>
</head>
<body>
	<div class="container">
		<h3>
			<c:out value="${dayofweek}"/>, the
			<c:out value="${dayofmonth}"/> of
			<c:out value="${month}"/>, 
			<c:out value="${year}"/>
		</h3>
	</div>
</body>
</html>