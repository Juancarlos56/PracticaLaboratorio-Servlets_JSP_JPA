
<%@page import="ec.edu.ups.entidades.Pedido"%>
<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="ec.edu.ups.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="js/listarPedido.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
<title>Listar Pedidos</title>
</head>
<body background="image/regPedido.png">
	<section class="cuadrado">
		<% 
	 	Usuario usuario= (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = usuario.getEmpresa();
	 	%>
	 	
		<h1> Listar Pedidos de <%=usuario.getNombre()%> para la Empresa <%=empresa.getNombre()%> </h1>
		
                    <br>
                    <br>
                    
                    
                <label id="nomProducto" for="nomProducto" style="margin-right: 50px;" >Listar Pedidos</label>
				<input type="button" id="listarPedidos" name="listarPedidos" value="Listar" onclick="listarPedido(<%=empresa.getCod_emp()%>,<%=usuario.getCod_usu() %>);" />            
		        <div class="separador"> </div>
		        <div id="informacion"><b>Lista de Pedidos</b></div>
						<br>
						
				
		</section>



<h1></h1>
</body>
</html>