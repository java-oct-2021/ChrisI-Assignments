<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					<th>Name</th>
					<th>Creator</th>
					<th>Current Version</th>
					<th>Action</th>
				</tr></thead>
				<tbody>
					<c:forEach var="language" items="${languages}">
						<tr>
							<td>
								<a href="/languages/${language.id}"><c:out value="${language.name}"></c:out></a>
							</td>
							<td>
								<c:out value="${language.creator}"></c:out>
							</td>
							<td>
								<c:out value="${language.currentVersion}"></c:out>
							</td>
							<td>
								<form action="/languages/${language.id}" method="POST">
									<a href="/languages/${language.id}/edit">edit</a>
									<input type="hidden" name="_method" value="DELETE" />
									<input class="btn btn-link text-danger" type="submit" value="delete" />
								</form>
							</td>
						</tr>		
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<form:form action="/languages" method="POST" class="col" modelAttribute="lang">
			<div class="mb-3">
				<form:label path="name">Name</form:label>
				<form:input path="name"></form:input>
				<form:errors path="name" class="text-danger"></form:errors>
			</div>
			<div class="mb-3">
				<form:label path="creator">Creator</form:label>
				<form:input path="creator"></form:input>
				<form:errors path="creator"  class="text-danger"></form:errors>
			</div>
			<div class="mb-3">
				<form:label path="currentVersion">Current Version</form:label>
				<form:input path="currentVersion"></form:input>
				<form:errors path="currentVersion"  class="text-danger"></form:errors>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	</div>
</body>
</html>