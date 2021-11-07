<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row"><h1><c:out value="${product.name}"></c:out></h1></div>
		<div class="row">
			<div class="col-md-6">
				<h3>Categories:</h3>
				<c:forEach items="${product.categories}" var="category">
					<p><c:out value="${category.name}"></c:out></p>
				</c:forEach>
			</div>
			<form class="col" action="/products/${product.id}" method="POST">
				<div class="mb-3">
					<label for="category" class="form-label">Category</label>
					<select name="catId" class="form-select" id="category">
						<c:forEach items="${unCategories}" var="category">
							<option value="${category.id}"><c:out value="${category.name}"></c:out></option>
						</c:forEach>
					</select>
				</div>
				<div class="mb-3">
				<input type="submit" value="Submit" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>