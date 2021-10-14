<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-center"">
			<div class="col col-md-6 mt-5 border border-secondary">
				<table>
					<tr>
						<td>Name:</td>
						<td><c:out value="${name}"/></td>
					</tr>
					<tr>
						<td>Location:</td>
						<td><c:out value="${location}"/></td>
					</tr>
					<tr>
						<td>Language:</td>
						<td><c:out value="${language}"/></td>
					</tr>
					<tr>
						<td>Comment:</td>
						<td><c:out value="${comment}"/></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>