<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row"><h1>New Category</h1></div>
	<div class="row">
		<form:form class="col" action="/categories/new" method="POST" modelAttribute="category">
			<div class="mb-3">
				<form:label path="name">Name</form:label>
				<form:input path="name" type="text"></form:input>
				<form:errors path="name" class="text-danger"></form:errors>
				<span class="text-danger"><c:out value="${errors}"></c:out></span>
			</div>
			<input type="submit" value="Create" />
		</form:form>
	</div>
	</div>
</body>
</html>