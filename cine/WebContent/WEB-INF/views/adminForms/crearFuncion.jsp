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
  width: 50%;
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

<title>Crear Funci�n</title>
</head>
<body>
<img src="https://i.ibb.co/3hfMC6z/bannerF.png" alt="bannerF"" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
<div class="card">
<div class="center"><br>
<h1>Crear Funci�n</h1><br>

<form:form  action="${pageContext.request.contextPath}/saveF?cu=${usuario.pkidusuario}" method="POST" modelAttribute="funcion">
		<form:input type="hidden" name="cod" path="pkidfuncion"/>
		<form:input type="hidden"  path="usuariocreacion"/>
		<form:input type="hidden"  path="usuariomodificacion"/>
		<form:input type="hidden" path="fechacreacion"/>
		<input type="hidden" name="usuarioC" value="${usuario.nombreusuario}"/>
		<label>N�mero de asientos: &nbsp </label>
		<form:input type="number"  path="asientos"/><br>
		<form:errors path="asientos" cssStyle="color: #ff0000;"/><br>
		
		<label>Seleccionar pelicula: &nbsp</label>
		<select id="pelis" name="pelis">
			<c:forEach items="${pelis}" var="peliculas">
				<c:choose>
					<c:when test="${funcion.pelicula.pkidpelicula == peliculas.pkidpelicula}">
						<option value="${peliculas.pkidpelicula}" selected>${peliculas.nombre}</option>
					</c:when>
					<c:otherwise>
						<option value="${peliculas.pkidpelicula}">${peliculas.nombre}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br><br>
		
		<label>Seleccionar horario: &nbsp</label>
		<select id="horas" name="horas">
			<c:forEach items="${horarios}" var="horarios">
				<c:choose>
					<c:when test="${funcion.horariof.pkidhorariof == horarios.pkidhorariof}">
						<option value="${horarios.pkidhorariof}" selected>${horarios.horario}</option>
					</c:when>
					<c:otherwise>
						<option value="${horarios.pkidhorariof}">${horarios.horario}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br><br>
		
		<label>Seleccionar tipo: &nbsp</label>
		<select id="tipo" name="tipo">
			<c:forEach items="${tipos}" var="tipos">
				<c:choose>
					<c:when test="${funcion.tipof.pkidtipof == tipos.pkidtipof}">
						<option value="${tipos.pkidtipof}" selected>${tipos.tipo}</option>
					</c:when>
					<c:otherwise>
						<option value="${tipos.pkidtipof}">${tipos.tipo}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br><br>
		
		
		
		<label>Estado: &nbsp &nbsp</label>
		<form:radiobutton name="estado" value="true" path="estado"/> Activo<br>
  		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
  		<form:radiobutton name="estado" value="false" path="estado"/>Inactivo<br>
		<br>
	
		<br><input type="submit" value=" &nbsp &nbsp Save &nbsp &nbsp" class="btn btn-success"><br><br> 
	</form:form>
</div>
</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>