<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="StyleSheet" href="../CSS/cssIniciarSesion.css" TYPE="text/css">
<title>Login Usuario</title>

</head>
<body background="../image/login.png" >

	<header>
        <a href="index.html" title="Ir a la Pagina principal"> <img src="../image/Logo2.png" alt="Logo" id="leftFloat" width="100px" height="100px"> </a>
 	</header>
 	
 	<section class= "cuadrado">

    <form id="formulario01" method="post" action="/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/InicioSesion">

        <label for="correo"> <h2>Correo electr�nico </h2></label>
        <input type="text" id="correo" name="correo" value="" placeholder="Ingrese el correo ..." />
        <br>
        <label for="contrasena"><h2>Constrase�a</h2></label>
        <input type="password" id="contrasena" name="contrasena" value="" placeholder="Ingrese su contrase�a ..." />
        <br>
        <input class="boton" type="submit" id="login" name="login" value="Iniciar Sesi�n" />
    </form>
 	
 	</section>


    
</body>
</html>