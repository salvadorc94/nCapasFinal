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

<title>Create Employee</title>
</head>
<body>
<img src="https://i.ibb.co/G2ZCTTL/bannerU.png" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
<div class="card">
<div class="center"><br>
<h1>Crear Usuario</h1><br>

<form:form  action="${pageContext.request.contextPath}/saveU?cu=${cuser.pkidusuario}" method="POST" modelAttribute="usuario">
		<form:input type="hidden" name="cod" path="pkidusuario"/>
		
		<label>Nombre: &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="text"  path="nombre"/><br>
		<form:errors path="nombre" cssStyle="color: #ff0000;"/><br>
		
		<label>Apellido: &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="text" path="apellido"/><br>
		<form:errors path="apellido" cssStyle="color: #ff0000;"/><br>
		
		<label>Fecha: &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="date"  path="fecha"/><br>
		<form:errors path="fecha" cssStyle="color: #ff0000;"/><br>
		
		<label>Direccion: &nbsp &nbsp &nbsp</label>
		<form:input type="text"  path="direccion"/><br>
		<form:errors path="direccion" cssStyle="color: #ff0000;"/><br>
		
		<label>Apodo: &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="text"  path="nombreusuario"/><br>
		<form:errors path="nombreusuario" cssStyle="color: #ff0000;"/><br>
		
		<label>Clave: &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="password"  path="contraseniausuario"/><br>
		<form:errors path="contraseniausuario" cssStyle="color: #ff0000;"/><br>
		
		<label>Saldo: &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="number"  path="saldo"/><br>
		<form:errors path="saldo" cssStyle="color: #ff0000;"/><br>
		
		<c:set var = "id" value = "${usuario.tipo.pkidtipo}"/>
		<c:choose>
		<c:when test="${id==1}">
			<label>Rango: </label>
			<input type="radio" name="tipo" value="Admin" checked> Administrador<br>
  			<input type="radio" name="tipo" value="Cliente">Cliente<br><br>
		</c:when>
		<c:otherwise>
			<label>Rango: &nbsp &nbsp &nbsp</label>
			<input type="radio" name="tipo" value="Admin" > Administrador<br>
  			&nbsp &nbsp &nbsp<input type="radio" name="tipo" value="Cliente" checked>Cliente<br><br>
		</c:otherwise>
		</c:choose>
		<label>Estado: &nbsp &nbsp </label>
		<form:radiobutton name="estado" value="true" path="estado"/> Activo<br>
  		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
  		<form:radiobutton name="estado" value="false" path="estado"/>Inactivo<br>
		<br>
		<label>Motivo:</label>
		<form:input type="text" name="motivo" path="descripcion"/><br>
		<br>
		<label>Pais: &nbsp </label>
		<c:set var = "paisU" value = "${usuario.pais.pkidpais}"/>
		<select id="pais" name="pais" onchange="myFunction();">
			<option value="#">Seleccionar Pais</option>
			<c:forEach items="${listaPais}" var="paises">
				<c:choose>
					<c:when test="${paisU == paises.pkidpais}">
						<option value="${paises.pkidpais}" selected>${paises.pais}</option>
					</c:when>
					<c:otherwise>
						<option value="${paises.pkidpais}">${paises.pais}</option>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</select><br><br>
		<c:set var = "depaU" value = "${usuario.departamento.pkiddepartamento}"/>
		<select id="depa" name="depa">
		<option value="1">Seleccionar Departamento</option>
			<c:forEach items="${listaDepa}" var="depas">
				<c:choose>
					<c:when test="${depaU == depas.pkiddepartamento}">
						<option value="${depas.pkiddepartamento}" selected>${depas.departamento}</option>
					</c:when>
					<c:otherwise>
						<option value="${depas.pkiddepartamento}">${depas.departamento}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br><br>
		<c:set var = "muniU" value = "${usuario.municipio.pkidmunicipio}"/>
		<select id="muni" name="muni">
		<option value="1">Seleccionar Municipio</option>
		
			<c:forEach items="${listaMuni}" var="munis">
				<c:choose>
					<c:when test="${muniU == munis.pkidmunicipio}">
						<option value="${munis.pkidmunicipio}" selected>${munis.municipio}</option>
					</c:when>
					<c:otherwise>
						<option value="${munis.pkidmunicipio}">${munis.municipio}</option>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</select><br>
		
		
		<br><input type="submit" value="&nbsp &nbsp Save &nbsp &nbsp" class="btn btn-success"><br><br> 
	</form:form>
</div>
</div><br><br><br><br><br><br>
</div>
<script>
function myFunction() {
  var x = document.getElementById("pais").value;
  if(x != 54){
	  document.getElementById("depa").style.display = 'none';
	  document.getElementById("muni").style.display = 'none';
  }else{
	  <c:set var = "id" value = "${usuario.tipo.pkidtipo}"/>
	  document.getElementById("depa").style.display = 'inline';
	  document.getElementById("muni").style.display = 'inline';
  }
}
</script>


</body>
</html>