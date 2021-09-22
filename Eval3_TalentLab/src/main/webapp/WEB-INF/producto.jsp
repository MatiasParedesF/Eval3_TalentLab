<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos!</title>
</head>
<body>
    <div>
    
        <form:form action="/producto/crear" method="post" modelAttribute="producto">
            <form:label path="nombre">nombre:</form:label>
            <form:input type="text" path="nombre"/><br>
           
            <form:label path="color">Color:</form:label>
            <form:input type="text" path="color"/><br>
           
            <form:label path="marca">Marca:</form:label>
            <form:input type="text" path="marca"/><br>
           
            <form:label path="precio">Precio:</form:label>
            <form:input type="text" path="precio"/><br>
           
            <form:label path="cantidad">Cantidad:</form:label>
            <form:input type="text" path="cantidad"/><br>
           
            <input type="submit" value="Guardar Producto!">
        </form:form>
        <br>
        <h1>Lista Producto</h1>
        <table>
        	<thead>
        		<tr>
        			<th>#</th>
        			<th>Nombre</th>
        			<th>Color</th>
        			<th>Marca</th>
        			<th>Precio</th>
        			<th>Cantidad</th>
        			
        		</tr>
        	</thead>
        	<tbody>
        		<c:forEach var="producto" items="${lista_productos}">
        		<tr>
        			<td><c:out value="${producto.id}"/></td>
        			<td><c:out value="${producto.nombre}"/></td>
        			<td><c:out value="${producto.color}"/></td>
        			<td><c:out value="${producto.marca}"/></td>
        			<td><c:out value="${producto.precio}"/></td>
        			<td><c:out value="${producto.cantidad}"/></td>
        			<td>
        				<form action="/producto/eliminar" method="POST">
						<input type="hidden" name="id" value="<c:out value="${producto.id}"/>" >
						<input type="submit" value="Agregar">
						</form>
						
        			</td>

        		</tr>
        		</c:forEach>
        	</tbody>
        </table>
    </div>
</body>
</html>