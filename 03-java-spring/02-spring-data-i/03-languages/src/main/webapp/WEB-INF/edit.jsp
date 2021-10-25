<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
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
		<form:form action="/languages/${lang.id}" method="POST" class="col" modelAttribute="lang">
			<input type="hidden" name="_method" value="put">
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