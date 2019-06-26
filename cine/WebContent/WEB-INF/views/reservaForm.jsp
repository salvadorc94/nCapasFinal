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

<title>Formulario de reservacion</title>
</head>
<body>

<div class="card">
<div class="center">
<h1>Reserva</h1>

<form:form  action="${pageContext.request.contextPath}/reservaResumen" method="POST" modelAttribute="reserva">
		
		<label>Asientos disponibles: </label><br>
		<label>Tipo de pelicula: </label>
		<label>Horario elegido: </label>
		
		<label>Número de asientos: </label>
		<form:input type="text"  path="nasientosreserva"/><br>
		<form:errors path="nasientosreserva" cssStyle="color: #ff0000;"/><br>
		
		<label>Pago con saldo:  </label>
		<!-- CHECKBOX -->
		<form:input type="number"  path="saldoutilizar"/><br>
		<form:errors path="saldoutilizar" cssStyle="color: #ff0000;"/><br>
		
		
		<label>Direccion: </label>
		<form:input type="text"  path="direccion"/><br>
		<form:errors path="direccion" cssStyle="color: #ff0000;"/><br>
		
		<label>Nombre de Usuario: </label>
		<form:input type="text"  path="nombreusuario"/><br>
		<form:errors path="nombreusuario" cssStyle="color: #ff0000;"/><br>
		
		<label>Contrasenia: </label>
		<form:input type="password"  path="contraseniausuario"/><br>
		<form:errors path="contraseniausuario" cssStyle="color: #ff0000;"/><br>
		
		<label>Pais: </label>
		<select id="pais" name="pais" onchange="myFunction();">
			<option value="#">Seleccionar Pais</option>
			<c:forEach items="${listaPais}" var="paises">
				<option value="${paises.pkidpais}">${paises.pais}</option>
			</c:forEach>
		</select><br>
		<select id="depa" name="depa" style="display:none">
			<c:forEach items="${listaDepa}" var="depas">
				<option value="${depas.pkiddepartamento}">${depas.departamento}</option>
			</c:forEach>
		</select><br>
		<select id="muni" name="muni" style="display:none">
			<c:forEach items="${listaMuni}" var="munis">
				<option value="${munis.pkidmunicipio}">${munis.municipio}</option>
			</c:forEach>
		</select><br>
		
		<input type="submit" value="Save" class="btn btn-success"><br> 
	</form:form>
</div>
</div>

<script>
function myFunction() {
  var x = document.getElementById("pais").value;
  if(x != 54){
	  document.getElementById("depa").style.display = 'none';
	  document.getElementById("muni").style.display = 'none';
  }else{
	  document.getElementById("depa").style.display = 'inline';
	  document.getElementById("muni").style.display = 'inline';
  }
}
</script>


</body>
</html>