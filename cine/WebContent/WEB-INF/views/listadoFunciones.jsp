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

			
<title>Horarios</title>
</head>
<body>
	<h2>Horarios para ${pelicula.nombre}</h2>
	<br>
	<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
        			<th>Action</th>
        			<th>Numero de asientos</th>
        			<th>Tipo de asiento</th>
        			<th>Horario</th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${funciones}" var="funciones">
        		<c:set var ="estado" value="${funciones.estado}"/>
        		<c:if test = "${estado == true}">
        			<tr>
        			<td>
  						<input type="button" class="btn btn-primary" value="Reservar" onclick="location.href='${pageContext.request.contextPath}/reservar?cp=${pelicula.pkidpelicula}&cu=${usuario.pkidusuario}&fu=${funciones.pkidfuncion}'"/>
        				</td>	
        				<td>${funciones.asientos}</td>
        				<td>
        					<p>${funciones.tipof.tipo}</p>
        				</td>
        				<td>
        						<p>${funciones.horariof.horario}</p>
        				
        				</td>
        				
        			
        			</tr>
        			</c:if>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div>
</body>
</html>