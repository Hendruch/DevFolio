<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Registro</title>
</head>
<link rel="stylesheet"
      href="<%=request.getContextPath()%>/css/login.css">
<body>

<div class="my-container">
    <h1>Registrar</h1>
    <form:form action="/saveUsuario" method="post" modelAttribute="usuario">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <form:input type="text" id="nombre" name="nombre" path="nombre" required="required"/>
        </div>
        <div class="form-group">
            <label for="correo">Correo electrónico:</label>
            <form:input type="email" id="correo" name="correo" path="email" required="required"/>
        </div>
        <div class="form-group">
            <label for="password">Contraseña:</label>
            <form:input type="password" id="password" name="password" path="password" required="required"/>
        </div>
        <div class="form-group">
            <label for="celular">Celular:</label>
            <form:input type="number" id="celular" name="celular" path="celular" required="required"/>
        </div>
        <div>
            <form:hidden path="id" class="form-control input-sm" />
        </div>
        <button class="btn-login" type="submit">Registrar</button>
    </form:form>
</div>

</body>
</html>