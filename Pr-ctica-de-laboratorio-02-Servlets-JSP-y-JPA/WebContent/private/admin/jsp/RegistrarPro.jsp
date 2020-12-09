<%@page import="java.util.List"%>
<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="ec.edu.ups.entidades.Categoria"%>
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
<title>Registrar Prod</title>
</head>

<body background="image/regPedido.png">


 <div class="cuadrado">
 
 		<% 
	 	Administrador admin = (Administrador)request.getAttribute("admin");
	 	Empresa empresa = admin.getEmpresa();
	 	List<Categoria> categoria = DAOFactory.getFactory().getCategoriasDAO().findCategoriasEmpresa(empresa.getCod_emp());
	 	%>
	 	
		<h1>Crear Productos en la Empresa <%=empresa.getNombre()%> </h1>
		
    
 
                <h2> Registrar Producto</h2>

                <form class="nuevoPro" id="formularioRegistrarProducto" method="POST" action=" ">

					 <label for="nombreCat" id="nombreCat">Eliga una categoría: </label>
					 <select name="curso" id="categoria" name="categoria"  required >
				     	<option value="" disabled selected>Elige una opción</option>
				     	<% 
				     		for(int i = 0; i<categoria.size(); i++){
				     			out.print("<option value=\""+categoria.get(i).getCodigo_categoria()+"\">"+categoria.get(i).getNombre()+"</option>");
				     		}
				     	
				     	%>
				     </select>
					<br>
                    <label for="nombreP" id="nombreP">Nombre:</label>
                    <input class="sepBot" type="text" id="nombrePro" name="nombrePro" value="" required />
                    <br>

                    <label for="labelpreProd" id="labelpreProd"> Precio:</label>
                    <input class="sepBot" type="number" id="precioPro" name="precioPro" value="" required/>
                    <br>

                    <label for="labeliva" id="labeliva"> IVA %:</label>
                    <input class="sepBot" type="number" id="iva" name="iva" value="12" readonly="readonly" required/>
                    <br>

                    <label for="estadoPro" id="estadoPro">Estado Producto:</label>
                    <input class="sepBot" type="text" id="estadoProducto" name="estadoProducto" value="Activo" readonly  required/>
                    <br>

                    <label for="labelUrlImagen" id="labelUrlImagen">Url Imagen:</label>
                    <input class="sepBot" type="text" id="urlImagen" name="urlImagen" value="" required />

                    <br>
                    <label for="labelDescriPro" id="labelDescriPro">Descripcion:   </label>
                    <input class="sepBot" type="text" id="descriPro" name="descriPro" value="" required />
                    <br>

                    
                
                	<input class="boton" type="button" id="guardarNuevoPro" name="guardarNuevoPro" value="Guadar Producto" onclick="crearProducto()"/>
                	<div class="separador"> </div>
		       		<div id="informacion2"><b>Verificacion de crear producto</b></div>
                
                </form>
            </div>



</body>
</html>