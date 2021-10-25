<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col">
			<table class="table">
				<tr>
					<td>id</td>
					<td><c:out value="${language.id}"></c:out></td>
				</tr>
				<tr>
					<td>Name</td>
					<td>
						<c:out value="${language.name}"></c:out>
					</td>
				</tr>
				<tr>
					<td>Creator</td>
					<td>
						<c:out value="${language.creator}"></c:out>
					</td>
				</tr>
				<tr>
					<td>Current Version</td>
					<td>
						<c:out value="${language.currentVersion}"></c:out>
					</td>
				</tr>	
			</table>
		</div>
	</div>
	</div>
</body>
</html>