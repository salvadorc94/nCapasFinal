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
<img src="https://i.ibb.co/3hfMC6z/bannerF.png" alt="bannerF"" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
<div class="card">
<div class="center"><br>
<input type="button" class="btn btn-info" value="Crear Funcion" onclick="location.href='${pageContext.request.contextPath}/createF?cu=${usuario.pkidusuario}'"/>
<div class="btn-group">
<input type="button" class="btn btn-primary" value="Catalogo Usuario" onclick="location.href='${pageContext.request.contextPath}/adminU?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Tipo" onclick="location.href='${pageContext.request.contextPath}/adminT?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Horario" onclick="location.href='${pageContext.request.contextPath}/adminH?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Pelicula" onclick="location.href='${pageContext.request.contextPath}/adminP?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-info" value="Catalogo Función" onclick="location.href='${pageContext.request.contextPath}/adminF?cu=${usuario.pkidusuario}'"/>
<input type="button" class="btn btn-danger" value="Salir" onclick="location.href='${pageContext.request.contextPath}/Salir'"/>
</div><br><br>
<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
      				<th>Acción</th>
        			<th>Número de asientos</th>
        			<th>Pelicula</th>
        			<th>Horario</th>
        			<th>Tipo</th>
        			<th>Estado</th>
        			<th>Fecha Creación</th>
        			<th>Usuario Creación</th>
        			<th>Fecha Modificación</th>
        			<th>Usuario Modificación</th>
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
</div></div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>
</body>
</html>