<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/time.css" media="all" />
<script src="js/time.js"></script>
</head>
<body>
	<div class="container">
		<h3>
			<c:out value="${hour}"/>:
			<c:out value="${minute}"/>
			<c:out value="${ampm}"/>
		</h3>
	</div>
</body>
</html>