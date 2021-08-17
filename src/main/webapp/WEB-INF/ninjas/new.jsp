<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<p>
			<label for="dojo_id">Dojo</label> <select name="dojo_id" id="dojo_id">
				<c:forEach items="${dojos}" var="dojo">
					<option value="${dojo.id}">
						<c:out value="${dojo.name}"></c:out>
					</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" />
			<form:errors path="firstName" />
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" />
			<form:errors path="lastName" />
		</p>
		<p>
			<form:label path="age">Age</form:label>
			<form:input path="age" />
			<form:errors type="number" min="1" value="1" path="age" />
		</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>