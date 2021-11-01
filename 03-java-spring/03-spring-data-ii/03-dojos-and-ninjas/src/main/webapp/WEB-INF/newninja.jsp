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
			<form:form action="/ninjas/new" method="POST" class="col" modelAttribute="ninja">
				<div class="mb-3">
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName"></form:input>
					<form:errors path="firstName" class="text-danger"></form:errors>
				</div>
				<div class="mb-3">
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName"></form:input>
					<form:errors path="lastName" class="text-danger"></form:errors>
				</div>
				<div class="mb-3">
					<form:label path="age">Age</form:label>
					<form:input path="age"></form:input>
					<form:errors path="age" class="text-danger"></form:errors>
				</div>
				<div class="mb-3">
					<form:label path="dojo">Dojo</form:label>
					<form:select path="dojo">
						<c:forEach var="dojo" items="${dojos}">
						<option value="${dojo.id}"> <c:out value="${dojo.name}"></c:out> </option>	
						</c:forEach>
					</form:select>
					<form:errors path="dojo" class="text-danger"></form:errors>
				</div>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>