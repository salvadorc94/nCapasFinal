<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">

<style>
	.center{
		width: 70%;
		margin-left: auto;
  		margin-right: auto;
	}
</style>

			
<title>Historial</title>
</head>
<body>
<img src="https://i.ibb.co/jVz3XpC/bannerHi.png" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
	<h2 id="prueba"><font color="#84C0CD" size="7"><b> &nbsp &nbsp Historial de transacciones</b></font>.</h2>
	<br>
	<form  action="${pageContext.request.contextPath}/filtro?cu=${usuario.pkidusuario}" method="POST">
		
				
		<label><font color="#84C0CD" size="5"><b> &nbsp &nbsp &nbsp &nbsp &nbsp Fecha Inicio: &nbsp &nbsp</b></font></label>
		<input id="fechaI" type="date" name="fechaI" required/><br>
		
		<label><font color="#84C0CD" size="5"><b>&nbsp &nbsp &nbsp &nbsp &nbsp Fecha Fin: &nbsp &nbsp &nbsp &nbsp</b></font></label>
		<input id="fechaF" type="date" name="fechaF" required/><br>
				
		<br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="submit" value="&nbsp &nbsp Buscar &nbsp &nbsp" class="btn btn-success"><br> 
	</form><br>
	<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
        			<th><font color="#84C0CD" size="5"><b>Acción</b></font></th>
        			<th><font color="#84C0CD" size="5"><b>Número Transacción</b></font></th>
        			<th><font color="#84C0CD" size="5"><b>Fecha Transacción</b></font></th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${historial}" var="historial">
        			<tr>
        			<td>
  						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${historial.pkidhistorial}">Ver Detalle</button>
        				</td>	
        				<td><font color="#84C0CD" size="5"><b>${historial.delegateid}</b></font></td>
        				<td><font color="#84C0CD" size="5"><b>${historial.reserva.fechareserva}</b></font></td>
        			</tr>
        			
        			
        			<div class="modal fade" id="${historial.pkidhistorial}" role="dialog" aria-hidden="true" tabindex="-1">
        			<br><br><br><br><br><br><br><br><br><br>
        					<div class="modal-dialog" role="document">
        						<div class="modal-content">
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        								<span aria-hidden="true">&times;</span>
        							</button>
        							<div class="card">
									<div class="center">
									<h1>Detalle</h1>
        							<label>Nombre pelicula: ${historial.reserva.funcion.pelicula.nombre}</label><br>
									<label>Horario elegido: ${historial.reserva.funcion.horariof.horario} </label><br>
									<label>Asientos: ${historial.reserva.nasientosreserva} </label><br> 
									<label>Tipo de pelicula: ${historial.reserva.funcion.tipof.tipo} </label><br> 
									<label>Saldo utilizado: ${historial.reserva.saldoutilizar} </label><br><br>
									</div>
									</div>
								</div>
							</div>
						</div>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div>
  	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 </div>					
</body>
</html>