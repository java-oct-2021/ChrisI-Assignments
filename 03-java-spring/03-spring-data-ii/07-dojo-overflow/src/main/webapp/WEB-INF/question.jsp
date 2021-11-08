<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<div class="row">
	<h1><c:out value="${question.question}"></c:out></h1>
	</div>
	<div class="row">
	<div class="col">
		<span class="fs-3">Tags:</span>
		<c:forEach items="${question.tags}" var="tag">
			<span class="border border-dark rounded shadow-sm ms-2 py-1 px-2">
				<c:out value="${tag.subject }"></c:out>
			</span>
		</c:forEach>
	</div>
	</div>
	<div class="row">
		<div class="col-md-6">
		<table class="table">
		<thead><tr>
			<th scope="col">Answers</th>
		</tr></thead>
		<tbody>
			<c:forEach items="${question.answers}" var="answer">
				<tr>
					<td>
						<c:out value="${answer.answer} "></c:out>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
		<form:form class="col-md-6" action="/questions/${question.id}/answer" method="POST" modelAttribute="answerForm">
			<div class="mb-3">
				<form:label class="form-label" path="answer" for="answer">Answer: </form:label>
				<form:textarea class="form-control" path="answer" id="answer" rows="5"></form:textarea>
				<form:errors path="answer" class="text-danger"></form:errors>
			</div>
			<input type="submit" value="Answer it!" class="btn btn-primary" />
		</form:form>
	</div>
	</div>
</body>
</html>