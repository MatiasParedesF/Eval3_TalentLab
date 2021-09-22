<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
    <div>
        <form:form action="/usuario/crear" method="post" modelAttribute="usuario">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/><br>
           
            <form:label path="apellido">Apellido:</form:label>
            <form:input type="text" path="apellido"/><br>
           
            <form:label path="email">Email:</form:label>
            <form:input type="text" path="email"/><br>
           
            <form:label path="edad">Edad:</form:label>
            <form:input type="text" path="edad"/><br>
           

            <input type="submit" value="Crear usuario">
        </form:form>
        
    </div>
</body>
</html>