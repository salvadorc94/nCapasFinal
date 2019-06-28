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
	<h2 id="prueba">Historial de transacciones.</h2>
	<br>
	<form  action="${pageContext.request.contextPath}/filtro?cu=${usuario.pkidusuario}" method="POST">
		
				
		<label>Fecha Inicio: </label>
		<input id="fechaI" type="date" name="fechaI" required/><br>
		
		<label>Fecha Fin: </label>
		<input id="fechaF" type="date" name="fechaF" required/><br>
				
		<input type="submit" value="Buscar" class="btn btn-success"><br> 
	</form>
	<div class="table-responsive center">          
  		<table class="table table-hover">
    		<thead>
      			<tr>
        			<th>Acción</th>
        			<th>Número Transacción</th>
        			<th>Fecha Transacción</th>
      			</tr>
    		</thead>
    	<tbody>
        		<c:forEach items="${historial}" var="historial">
        			<tr>
        			<td>
  						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${historial.pkidhistorial}">Ver Detalle</button>
        				</td>	
        				<td>${historial.delegateid}</td>
        				<td>${historial.reserva.fechareserva}</td>
        			</tr>
        			
        			
        			<div class="modal fade" id="${historial.pkidhistorial}" role="dialog" aria-hidden="true" tabindex="-1">
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
									<label>Saldo utilizado: ${historial.reserva.saldoutilizar} </label><br> 
									</div>
									</div>
								</div>
							</div>
						</div>
        		</c:forEach>
    	</tbody>
  		</table>
  	</div>
  	
  						
</body>
</html>