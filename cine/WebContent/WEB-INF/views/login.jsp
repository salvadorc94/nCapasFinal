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

<title>Bienvenido</title>
</head>
<body>
<img src="https://i.ibb.co/VCmYCVj/banner.png" alt="banner" border="0" width=100% height=200>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE>
<div style="background-image: url(https://i.ibb.co/FD777nK/fondo.png); height: 100%; width: 100%;">
<br><br>
<div class="card">
<div class="center"><br>

<FONT FACE="Impact" size="7">

INGRESA TUS CREDENCIALES

</FONT>
<br><br>
<MARQUEE SCROLLDELAY = 100 BGCOLOR="#84C0CD" BEHAVIOR=ALTERNATE>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</MARQUEE><br>
<br><br>
<form:form  action="${pageContext.request.contextPath}/login" method="POST" modelAttribute="usuario">
		<FONT size="4">
		<label>Ingresa tu usuario: &nbsp &nbsp &nbsp &nbsp &nbsp</label>
		<form:input type="text" path="nombreusuario"/><br>
		</FONT>
		<form:errors path="nombreusuario" cssStyle="color: #ff0000;"/><br>
		<FONT size="4">
		<label>Ingresa tu contrase&ntildea: &nbsp &nbsp</label>
		<form:input type="password" path="contraseniausuario"/><br>
		</FONT>
		<form:errors path="contraseniausuario" cssStyle="color: #ff0000;"/><br>
		<br><br>
		<input type="submit" value="&nbsp &nbsp &nbsp Entrar &nbsp &nbsp &nbsp  " class="btn btn-primary"> &nbsp &nbsp &nbsp &nbsp
		<input type="button" class="btn btn-info" value="Crear Usuario" onclick="location.href='${pageContext.request.contextPath}/edit'"><br>
		<label><p>${mal}</p></label>
	</form:form>
</div>
</div>
<br><br><br>
<MARQUEE height=175 SCROLLDELAY = 100 BGCOLOR="000000">
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/GWKWH0y/P1.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/3cjrMsp/P3.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/Qr5h9HY/P2.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/gMfVXCN/P4.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/FYBhxjd/P5.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/GWKWH0y/P1.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/3cjrMsp/P3.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/Qr5h9HY/P2.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/gMfVXCN/P4.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/FYBhxjd/P5.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/GWKWH0y/P1.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/3cjrMsp/P3.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/Qr5h9HY/P2.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/gMfVXCN/P4.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/VW855Nj/PROXI.png" alt="banner" border="0" height=175>
<img src="https://i.ibb.co/FYBhxjd/P5.png" alt="banner" border="0" height=175>
</MARQUEE>
<br><br><br><br><br>
</div>
</body>
</html>
