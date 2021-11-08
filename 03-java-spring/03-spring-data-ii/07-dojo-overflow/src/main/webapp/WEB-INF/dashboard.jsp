<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row"><h1>Questions Dashboard</h1></div>
	<div class="row">
		<table class="table">
		<thead><tr>
			<th scope="col">Question</th>
			<th scope="col">Tags</th>
		</tr></thead>
		<tbody>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}"><c:out value="${question.question}"></c:out></a></td>
					<td>
						<c:forEach items="${question.tags}" var="tag">
							<c:out value="${tag.subject} "></c:out>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<a href="/questions/new">New Question</a>
	</div>
	</div>
</body>
</html>