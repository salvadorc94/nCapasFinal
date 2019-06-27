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

<form:form  action="${pageContext.request.contextPath}/guardarReserva?cp=${pelicula.pkidpelicula}&cu=${usuario.pkidusuario}&fu=${funcion.pkidfuncion}" method="POST" modelAttribute="reserva">
		
		<label>Nombre pelicula: ${pelicula.nombre}</label><br>
		<label>Horario elegido: ${funcion.horariof.horario} </label><br>
		<label>Asientos: ${reserva.nasientosreserva} </label><br>
		<label>Tipo de pelicula: ${funcion.tipof.tipo} </label><br>
		<label>Saldo a utilizar: ${reserva.saldoutilizar} </label><br>
		<label>Saldo remanente: ${reserva.saldorestante}</label><br>
		<label>Gran total: ${granTotal}</label><br>
		<input type="submit" value="Finalizar transacción" class="btn btn-success"><br> 
	</form:form>
</div>
</div>

</body>
</html>