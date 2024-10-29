<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Usuario</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/panel.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/responsive.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/rol.css">
</head>
<body>
<div class="main-container">

<div class="main">
		
		
		<div class="form-container">
			
			
			<form:form method="POST" action="/saveUsuario" modelAttribute="usuario">
				<h2>Crear Usuario</h2>
			
			<div class="form-group">
			 	<label for="nombre">Nombre</label>
			 	<form:input type="text" name="nombre" required="required"/>
			</div>
			
			<div class="form-group">
			 	<label for="celular">Celular</label>
			 	<form:input type="tel" name="celular" required="required"/>
			</div>
			
			<div class="form-group">
			 	<label for="email">Email</label>
			 	<form:input type="email" name="email" required="required"/>
			</div>
			<div class="form-group">
			 	<label for="password">Password</label>
			 	<form:input type="password" name="password" required="required"/>
			</div>
	 	
		 	<Button type="submit" >
		 		
		 		Crear
		 	</Button>
		 </form:form>
		 
		</div>
		</div>
	</div>
</body>
</html>