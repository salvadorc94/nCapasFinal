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
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 55%;
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
		width: 70%;
		margin-left: auto;
  		margin-right: auto;
	}
</style>

			
<title>Peliculas</title>
</head>
<body>
<img src="https://i.ibb.co/1Z1yTXX/bannerP.png" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br> &nbsp &nbsp &nbsp &nbsp
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
	<input type="button" class="btn btn-primary" value="Ver historial" onclick="location.href='${pageContext.request.contextPath}/historial?cu=${usuario.pkidusuario}'"/>
	&nbsp &nbsp <input type="button" class="btn btn-danger" value="Salir" onclick="location.href='${pageContext.request.contextPath}/Salir'"/><br>
	<br>
	<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
        			<th><font color="#84C0CD" size="5"><b> &nbsp &nbsp Funciones &nbsp &nbsp</b></font></th>
        			<th><font color="#84C0CD" size="5"><b> &nbsp Nombre &nbsp</b></font></th>
        			<th><font color="#84C0CD" size="5"><b>&nbsp Imagen &nbsp</b></font></th>
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
        				<td><font color="#84C0CD" size="5"><b>${peliculas.nombre}</b></font></td>
        				<td><img height="300px" width="200px" src="data:image/jpeg;base64,${peliculas.imgDelegate}" /></td>
        			</tr>
        			</c:if>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div><br><br><br><br>
</div>
</body>
</html>