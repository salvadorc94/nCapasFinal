<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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

<title>Crear Pelicula</title>
</head>
<body>
<img src="https://i.ibb.co/SNbYBmm/bannerP.png" alt="bannerT"" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
<div class="card">
<div class="center"><br>
<h1>Crear Pelicula</h1><br>

<form:form  action="${pageContext.request.contextPath}/saveP?cu=${usuario.pkidusuario}" method="POST" modelAttribute="pelicula">
		<form:input type="hidden" name="cod" path="pkidpelicula"/>
		<form:input type="hidden"  path="usuariocreacion"/>
		<form:input type="hidden"  path="usuariomodificacion"/>
		<form:input type="hidden" path="fechacreacion"/>
		<form:input type="hidden" path="img"/>
		<input type="hidden" name="usuarioC" value="${usuario.nombreusuario}"/>
		<label>Añadir nueva pelicula: &nbsp</label>
		<form:input type="text"  path="nombre"/><br>
		<form:errors path="nombre" cssStyle="color: #ff0000;"/><br>
		
		<label>Estado: &nbsp &nbsp</label>
		<form:radiobutton name="estado" value="true" path="estado"/> Activo<br>
  		&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
  		<form:radiobutton name="estado" value="false" path="estado"/>Inactivo<br>
		<br>
  		
  		<label>Imagen: </label>
  		<input id="xd" name="xd" type="hidden">
  		<img height="300px" width="200px" id="mi_imagen" src="" alt="">
  		<input type="file" onchange="encodeImagetoBase64(this)"/><br><br>
		<input type="submit" value="&nbsp &nbsp Save &nbsp &nbsp" class="btn btn-success"><br> <br>
	</form:form>
</div>
</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<script type="text/javascript">
   function encodeImagetoBase64(element) {
	  var file = element.files[0];
	  var reader = new FileReader();
	  reader.onloadend = function() {
	    $(".link").attr("href",reader.result);
	    $(".link").text(reader.result);
	    $("#mi_imagen").attr("src",reader.result);
	    $("#xd").val(reader.result);
	  }
	  reader.readAsDataURL(file);
	}
</script>
</body>
</html>