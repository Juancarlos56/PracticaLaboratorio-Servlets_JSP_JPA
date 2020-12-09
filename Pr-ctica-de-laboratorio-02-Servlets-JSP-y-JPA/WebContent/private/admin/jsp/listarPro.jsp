<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="ec.edu.ups.entidades.Administrador"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/funAdmin.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
<title>Listar Producto</title>
</head>
<body background="image/regPedido.png">
	<section class="cuadrado">
		<% 
		Administrador admin = (Administrador)request.getAttribute("admin");
	 	Empresa empresa = admin.getAdm_empresa();
	 	%>
	 	
		<h1> Listar Productos de <%=admin.getNombre()%> para la Empresa <%=empresa.getNombre()%> </h1>
		
                    <br>
                    <br>
                    
                    
                <label id="nomProducto" for="nomProducto" style="margin-right: 50px;" >Listar Productos</label>
				<input type="button" id="listarPro" name="listarPro" value="Listar" onclick="listarProAdmin(<%=empresa.getCod_emp()%>,<%=admin.getAdm_id()%>);" />            
		        <div class="separador"> </div>
		        <div id="informacion"><b>Lista de Productos</b></div>
				<br>
						
				
		</section>



<h1></h1>
</body>
</html>