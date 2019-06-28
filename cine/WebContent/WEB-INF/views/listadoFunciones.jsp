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
<img src="https://i.ibb.co/MM72F94/bannerH.png" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
	<h2>
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	<font color="#84C0CD" size="6">Horarios para ${pelicula.nombre}</font></h2>
	<br>
	<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
        			<th><font color="#84C0CD" size="5"><b>Action</b></font></th>
        			<th><font color="#84C0CD" size="5"><b>Numero de asientos</b></font></th>
        			<th><font color="#84C0CD" size="5"><b>Tipo de asiento</b></font></th>
        			<th><font color="#84C0CD" size="5"><b>Horario</b></font></th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${funciones}" var="funciones">
        		<c:set var ="estado" value="${funciones.estado}"/>
        		<c:set var ="estado2" value="${funciones.tipof.estado}"/>
        		<c:if test = "${estado == true}">
        			<c:if test="${estado2 == true}">
        			<tr>
        			<td>
  						<input type="button" class="btn btn-primary" value="Reservar" onclick="location.href='${pageContext.request.contextPath}/reservar?cp=${pelicula.pkidpelicula}&cu=${usuario.pkidusuario}&fu=${funciones.pkidfuncion}'"/>
        				</td>	
        				<td><font color="#84C0CD" size="5"><b>${funciones.asientos}</b></font></td>
        				<td>
        					<p><font color="#84C0CD" size="5"><b>${funciones.tipof.tipo}</b></font></p>
        				</td>
        				<td>
        						<p><font color="#84C0CD" size="5"><b>${funciones.horariof.horario}</b></font></p>
        				
        				</td>
        				
        			
        			</tr>
        			</c:if>
        			</c:if>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>
</body>
</html>