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
<link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
<body>

<div class="my-container">
    <a href="/" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ml-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white" >
        <svg class="w-3 h-3" aria-hidden="false" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
        </svg>
        <span class="sr-only" >Close modal</span>
    </a>
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
        <button class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="submit">Registrar</button>
    </form:form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>