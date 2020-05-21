<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grades</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Grades</h1>
		
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Score</th><th>Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ grade }" var="grade">
				<tr>
					<td><a href="/grade/detail?id=${grade.id}"><c:out value="${grade.name}" /></a></td>
					<td>${grade.score}</td>
					<td>${grade.total}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/grade/add" class="btn btn-secondary">Add Grade</a>
	</div>
</body>
</html>