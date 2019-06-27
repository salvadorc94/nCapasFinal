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

<form:form  action="${pageContext.request.contextPath}/reservaResumen?cp=${pelicula.pkidpelicula}&cu=${usuario.pkidusuario}&fu=${funcion.pkidfuncion}" method="POST" modelAttribute="reserva">
		
		<label>Asientos disponibles: ${funcion.asientos} </label><br>
		<label>Tipo de pelicula: ${funcion.tipof.tipo} </label><br>
		<label>Horario elegido: ${funcion.horariof.horario} </label><br>
		
		
		<label>Número de asientos: </label>
		<form:input id="asientos" type="text"  path="nasientosreserva" onchange="verificarAsiento()"/><br>
		<form:errors path="nasientosreserva" cssStyle="color: #ff0000;"/><br>
		
		<label>Total: </label>
		<div id="total">0</div><br>
		
		<label>Saldo disponible: ${usuario.saldo} </label><br>
		<label>Pago con saldo:  </label>
		<input id="pagoS" type="checkbox" name="pago" value="Pagar con Saldo" onClick="myFunction()">
		<input id="flag" type="hidden" value="true"/>
		<form:input value="0" id="saldo" type="number"  path="saldoutilizar"  style="display:none" onchange="verificarSaldo()"/><br>
		<form:errors path="saldoutilizar" cssStyle="color: #ff0000;"/><br>
				
		<input type="submit" value="Reservar" class="btn btn-success"><br> 
	</form:form>
</div>
</div>

<script>
function myFunction() {
	
	if(document.getElementById("flag").value == "false"){
		document.getElementById("flag").value = "true"
		document.getElementById("saldo").value = "";
		document.getElementById("saldo").style.display = 'none';
	}else{
		document.getElementById("flag").value = "false"
		document.getElementById("saldo").value = "";
		document.getElementById("saldo").style.display = 'inline';	
	}	
}

	function verificarAsiento(){
		var x = document.getElementById("asientos").value;
		var y = ${funcion.asientos};
		
		if(x>y){
			alert("No hay suficientes asientos");
			document.getElementById("asientos").value = "";
		}else{
			var t = x*3;
			document.getElementById("total").innerHTML = t;
		}
		
	}
	
	function verificarSaldo(){
		var x= document.getElementById("saldo").value;
		var y = ${usuario.saldo};
		
		if(y<x){
			alert("No hay suficiente saldo");
			document.getElementById("saldo").value = "";
		}
		
	}
</script>


</body>
</html>