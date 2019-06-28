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
  width: 80%;
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


<h1>Lista Funciones</h1>
<input type="button" class="btn btn-info" value="Crear Funcion" onclick="location.href='${pageContext.request.contextPath}/createF?cu=${usuario.pkidusuario}'"/>
<div class="btn-group">
<input type="button" class="btn btn-primary" value="Catalogo Usuario" onclick="location.href='${pageContext.request.contextPath}/adminU?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Tipo" onclick="location.href='${pageContext.request.contextPath}/adminT?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Horario" onclick="location.href='${pageContext.request.contextPath}/adminH?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Pelicula" onclick="location.href='${pageContext.request.contextPath}/adminP?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Funci�n" onclick="location.href='${pageContext.request.contextPath}/adminF?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-danger" value="Salir" onclick="location.href='${pageContext.request.contextPath}/Salir'"/>
</div>
<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
      				<th>Acci�n</th>
        			<th>N�mero de asientos</th>
        			<th>Pelicula</th>
        			<th>Horario</th>
        			<th>Tipo</th>
        			<th>Estado</th>
        			<th>Fecha Creaci�n</th>
        			<th>Usuario Creaci�n</th>
        			<th>Fecha Modificaci�n</th>
        			<th>Usuario Modificaci�n</th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${funciones}" var="funcion">
        			<tr>
        			<td>
  						<input type="button" class="btn btn-primary" value="Editar" onclick="location.href='${pageContext.request.contextPath}/editF?c=${funcion.pkidfuncion}&cu=${usuario.pkidusuario}'"/>
        			</td>	
        			<td>${funcion.asientos}</td>
        			<td>${funcion.pelicula.nombre}</td>
        			<td>${funcion.horariof.horario}</td>
        			<td>${funcion.tipof.tipo}</td>
        			<td>${funcion.estadoDelegate}</td>
        			<td>${funcion.fechacreacion}</td>
        			<td>${funcion.usuariocreacion}</td>
        			<td>${funcion.fechamodificacion}</td>
        			<td>${funcion.usuariomodificacion}</td>
        			</tr>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div>

</body>
</html>