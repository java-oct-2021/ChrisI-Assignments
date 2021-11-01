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
				<thead><tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr></thead>
				<tbody>
					<c:forEach var="ninja" items="${dojo.ninjas}">
						<tr>
							<td>
								<c:out value="${ninja.firstName}"></c:out>
							</td>
							<td>
								<c:out value="${ninja.lastName}"></c:out>
							</td>
							<td>
								<c:out value="${ninja.age}"></c:out>
							</td>
						</tr>		
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</body>
</html>