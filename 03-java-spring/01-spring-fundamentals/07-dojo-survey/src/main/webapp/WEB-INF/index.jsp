<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container-md">
		<div class="row justify-content-center">
			<form class="col col-md-6 mt-5" action="/submit" method="post">
				<div class="mb-3">
					<label for="name" class="form-label">Name</label>
					<input type="text" class="form-control" name="name" id="name" />
				</div>
				<div class="mb-3">
					<label for="location" class="form-label">Location</label>
					<select name="location"  class="form-select" id="location">
						<option value="narnia">Narnia</option>
						<option value="middleearth">Middle Earth</option>
						<option value="oz">Oz</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="language" class="form-label">Language</label>
					<select name="language" class="form-select" id="language">
						<option value="lolcode">LOLCODE</option>
						<option value="whitespace">White Space</option>
						<option value="malbolge">Malbolge</option>
						<option value="java">Java</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="comment" class="form-label">Comment</label>
					<textarea name="comment" class="form-control" id="comment" cols="30" rows="6"></textarea>
				</div>
				<div class="mb-3">
					<input class="btn btn-primary" type="submit" value="Submit"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>