<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="ec.edu.ups.entidades.Administrador"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/funAdmin.js" type="text/javascript"></script>
<link rel="StyleSheet" href="CSS/buscaPro.css" TYPE="text/css">
</head>



<body background="image/regPedido.png">



 <div class="cuadrado">
				
				<% Administrador admin = (Administrador)request.getAttribute("admin");
			 	Empresa empresa = admin.getAdm_empresa();%>
	 	
				<h1> Modificar Productos de la Empresa <%=empresa.getNombre()%> </h1>
				
				
				<label id="nomProducto" for="nomProducto" style="margin-right: 50px;" >Ingresar Nombre Producto</label>
				<input type="text" id="nomPro" name="nomPro" value="" placeholder="Nombre producto ..." onkeyup="buscarProducto(<%=empresa.getCod_emp()%>);"/>
				<input type="button" id="buscarPro" name="buscarPro" value="Buscar" onclick="buscarProducto(<%=empresa.getCod_emp()%>);" />            
		        <div class="separador"> </div>
		        <div id="informacion"><b>Busqueda de productos</b></div>
				
                <section class="modCom">
                    <h2>Modificar Producto</h2>
                    
                    <br>
                    <label for="MODCodPro" id="MODCodPro">Codigo:</label>
                    <input class="sepBot" type="text" id="codPro" name="codPro" value="" readonly="readonly"/>
                   
                    <br>
                    <label for="MODnombrePro" id="MODnombrePro">Nombre:</label>
                    <input class="sepBot" type="text" id="MODnombreProd" name="MODnombreProd" value="" />
                    <br>

                    <label for="MODlabelpreProd" id="MODlabelpreProd"> Precio:</label>
                    <input class="sepBot" type="number" id="MODprecioPro" name="MODprecioPro" value="" />
                    <br>

                    <label for="MODlabeliva" id="MODlabeliva"> IVA %:</label>
                    <input class="sepBot" type="number" id="MODiva" name="MODiva" value="12" readonly="readonly"/>
                    <br>

                    <label for="MODestadoPro" id="MODestadoPro">Estado Producto:</label>
                    <input class="sepBot" type="text" id="MODestadoProducto" name="MODestadoProducto" value="" />
                    <br>

                    <label for="MODlabelUrlImagen" id="MODlabelUrlImagen">Url Imagen:</label>
                    <input class="sepBot" type="text" id="MODurlImagen" name="MODurlImagen" value="" />

                    <br>
                    <label for="MODlabelDescriPro" id="MODlabelDescriPro">Descripcion:   </label>
                    <input class="sepBot" type="text" id="MODdescriPro" name="MODdescriPro" value="" />
                    <br>

                    <input class="boton" type="button" id="modPro" name="modPro" value="Modificar Producto" onclick="modProducto()"/>
                	<div class="separador"> </div>
		       		<div id="informacion2"><b>Verificacion de modificar producto</b></div>
		       		
		       		<input class="boton" type="button" id="eliminarPro" name="eliminarPro" value="Eliminar Producto" onclick=" eliminarProducto()"/>
                	<div class="separador"> </div>
		       		<div id="informacion2"><b>Eliminar  producto</b></div>
                </section>

            </div>

</body>
</html>