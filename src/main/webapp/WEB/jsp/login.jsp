<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
	<div class="my-container">
		<h1>Autenticar</h1>
		<form:form action="/login" method="post">
			<div class="form-group">
				<label for="email">Correo electrónico:</label>
				<input path="email" type="email" id="email" name="username"
						required="required"/>
			</div>
			<div class="form-group">
				<label for="password">Contraseña:</label>
				<input path="password" type="password" id="password" name="password" required="required"/>
			</div>
			<button class="btn-login" type="submit">Ingresar</button>
		</form:form>
	</div>
</body>
</html>