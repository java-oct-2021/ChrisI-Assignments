<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row">
	<h1>What is your question?</h1>
	</div>
	<div class="row">
		<form:form class="col" action="/questions/new" method="POST" modelAttribute="questionForm">
			<div class="mb-3">
				<form:label class="form-label" path="question" for="question">Question: </form:label>
				<form:textarea class="form-control" path="question" id="question" rows="3"></form:textarea>
				<form:errors path="question" class="text-danger"></form:errors>
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="tagtext" for="tagtext">Tags: </form:label>
				<form:input class="form-control" path="tagtext" id="tagtext" type="text"></form:input>
				<form:errors path="tagtext" class="text-danger"></form:errors>
				<p class="text-danger"><c:out value="${errors}"></c:out></p>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
	</div>
</body>
</html>