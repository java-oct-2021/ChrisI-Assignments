<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row"><h1>New Product</h1></div>
	<div class="row">
		<form:form class="col" action="/products/new" method="POST" modelAttribute="product">
			<div class="mb-3">
				<form:label path="name">Name</form:label>
				<form:input path="name" type="text"></form:input>
				<form:errors path="name" class="text-danger"></form:errors>
			</div>
			<div class="mb-3">
				<form:label path="description">Description</form:label>
				<form:textarea path="description"></form:textarea>
				<form:errors path="description" class="text-danger"></form:errors>
			</div>
			<div class="mb-3">
				<form:label path="price">Price</form:label>
				<form:input path="price" type="number" step="0.01"></form:input>
				<form:errors path="price" class="text-danger"></form:errors>
			</div>
			<input type="submit" value="Create" />
		</form:form>
	</div>
	</div>
</body>
</html>