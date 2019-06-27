<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">

<style>
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 65%;
  padding: 5px;
  margin-top: 10px;
  margin-left: auto;
  margin-right: auto;
}
/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
 } 
.center{
	  text-align: center;
}
</style>

<title>Administrador</title>
</head>
<body>

<div class="card">
<div class="center">


<h1>Lista de Usuarios</h1>
<input type="button" class="btn btn-primary" value="Crear Nuevo Usuario" onclick="location.href='${pageContext.request.contextPath}/crearU'"/>

<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
      				<th>Acci�n</th>
        			<th>Nombre</th>
        			<th>Apellido</th>
        			<th>Fecha</th>
        			<th>Direccion</th>
        			<th>Estado</th>
        			<th>Nombre Usuario</th>
        			<th>Saldo</th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${usuario}" var="usuario">
        			<tr>
        			<td>
  						<input type="button" class="btn btn-primary" value="Editar" onclick="location.href='${pageContext.request.contextPath}/editU?cu=${usuario.pkidusuario}'"/>
        			</td>	
        			<td>${usuario.nombre}</td>
        			<td>${usuario.apellido}</td>
        			<td>${usuario.fecha}</td>
        			<td>${usuario.direccion}</td>
        			<td>${usuario.estadoDelegate}</td>
        			<td>${usuario.nombreusuario}</td>
        			<td>${usuario.saldo}</td>
        			</tr>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div>

</body>
</html>