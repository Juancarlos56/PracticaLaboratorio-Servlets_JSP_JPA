<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="ec.edu.ups.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Pedido</title>
<script src="js/modificarPedido.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
<script></script>
</head>
<body background="image/regPedido.png">
<section class="cuadrado" >

		<% 
	 	Usuario usuario= (Usuario)request.getAttribute("usuario");
	 	Empresa empresa = usuario.getEmpresa();
	 	%>
	 	
		<h1> Modificar Pedidos de la Empresa<%=empresa.getNombre()%> </h1>
		
                    <br>
                    <br>
                    
                    
                <label id="nomProducto" for="nomProducto" style="margin-right: 50px;" >Listar Pedidos</label>
				<input type="button" id="listaPed" name="listarPed" value="Listar" onclick="listarPedido(<%=empresa.getCod_emp()%>,<%=usuario.getCod_usu() %>);" />            
		        <div class="separador"> </div>
		        <div id="informacion"><b>Lista de Pedidos</b></div>
						<br>
						<br>
						
                   		 <form id="formularioModificarPedido" method="POST" action=" ">
                        <label for="idpedido" id="idpedido" name="idpedido">ID Pedido</label>
                        <input class="sepBot" type="text" id="idTextpedido" name="idTextpedido" value="id pedido" readonly/>
                        <br>
                        <br>
                        <label for="nomPro" id="nomPro" name="nomPro">Nombre Producto</label>
                        <input class="sepBot" type="text" id="nomTextPro" name="nomTextPro" value="aqui va el nombre" readonly />
                        <br>
                        <br>
                        <label for="estadoPedido" id="estadoPedido" name="estadoPedido">Estado Pedido</label>
                        <input class="sepBot" type="text" id="estadoTextPed" name="estadoTextPed" value="aqui va estado" readonly />
                        <br>
                        <br>
                        <label for="cantidadPedido" id="cantidadPedido" name="cantidadPedido">Cantidad Pedido </label>
                        <input class="sepBot" type="number" id="numCantidadPed" name="numCantidadPed" value="" />
                        <br>
                        <br>
                        <label for="precio" id="precio" name="precio">Precio</label>
                        <input class="sepBot" type="number" id="precioPro" name="precioPro" value="0" readonly />
                        <br>
                        <br>
                        <label for="ivaLabel" id="ivaLabel"> IVA:  </label>
	            		<input type="text" id="iva" name="iva" value="" placeholder="Porcentaje de IVA..." readonly/>
			            <br>
                        <br>
                        <label for="totalPedido" id="totalPedido" name="totalPedido">Total</label>
                        <input class="sepBot" type="number" id="total" name="total" value="0" readonly />
                        <input class="boton" type="button" id="totalPed" name="totalPed" value="Calcular Total" onclick="calcularTotal()" />
                        <br>
                        <br>
                        <input class="boton" type="button" id="requerModificado" name="requerimientoModificado" value="Guardar Modificacion" onclick="actualizarPedido()" />
                        <input class="boton" type="button" id="eliminarPed" name="eliminarPed" value="Cancelar Pedido" onclick="eliminarPedido(<%=usuario.getCod_usu()%>)"/>
						 
						 <div id="informacion2"><b>Verificacion</b></div>
                        
                    </form>
                </section>

</body>
</html>