<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="ec.edu.ups.entidades.Administrador"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aprobar pedidos</title>
<script src="js/listarPedido.js" type="text/javascript"></script>
<script src="js/funAdmin.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
</head>
<body background="image/regPedido.png">
<div class="cuadrado">
	<% 
	Administrador admin = (Administrador)request.getAttribute("admin");
 	Empresa empresa = admin.getAdm_empresa();
	 	%>
	 	
		<h1>Aceptar Pedidos para la Empresa <%=empresa.getNombre()%> </h1>
		
		<label id="nomProducto" for="nomProducto" style="margin-right: 50px;" >Listar Pedidos</label>
		<input type="button" id="listarPedidos" name="listarPedidos" value="Listar" onclick="listarPedidoParaAprobacion(<%=empresa.getCod_emp()%>,<%=admin.getAdm_id()%>);" />            
		 <div class="separador"> </div>
		 <div id="informacion"><b>Lista de Pedidos</b></div>

		<br>		
		
		<div class="separador"> </div>
        <div id="informacion2"><b>Verificacion de aprobacion del pedido</b></div>



</div>


</body>
</html>