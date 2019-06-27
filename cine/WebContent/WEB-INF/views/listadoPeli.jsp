<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">

<style>
	.center{
		width: 70%;
		margin-left: auto;
  		margin-right: auto;
	}
</style>

			
<title>Peliculas</title>
</head>
<body>
	<h2 id="prueba">Listado de Peliculas.</h2>
	<input type="button" class="btn btn-primary" value="Ver historial" onclick="location.href='${pageContext.request.contextPath}/historial?cu=${usuario.pkidusuario}'"/>
	<input type="button" class="btn btn-danger" value="Salir" onclick="location.href='${pageContext.request.contextPath}/Salir'"/>
	<br>
	<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
        			<th>Action</th>
        			<th>Nombre</th>
        			<th>Imagen</th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${peliculas}" var="peliculas">
        		<c:set var ="estado" value="${peliculas.estado}"/>
        		<c:if test = "${estado == true}">
        			<tr>
        			<td>
  						<input type="button" class="btn btn-primary" value="Ver funciones" onclick="location.href='${pageContext.request.contextPath}/view?cp=${peliculas.pkidpelicula}&cu=${usuario.pkidusuario}'"/>
        				</td>	
        				<td>${peliculas.nombre}</td>
        				<td><img height="300px" width="200px" src="data:image/jpeg;base64,${peliculas.imgDelegate}" /></td>
        			</tr>
        			</c:if>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div>
</body>
</html>