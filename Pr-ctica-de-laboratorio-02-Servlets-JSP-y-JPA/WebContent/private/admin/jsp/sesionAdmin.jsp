<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="ec.edu.ups.entidades.Empresa"%>
<%@page import="ec.edu.ups.entidades.Administrador"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="StyleSheet" href="CSS/cssSesionUsuario.css" TYPE="text/css">
    <script src="./js/funAdmin.js" type="text/javascript"></script>
	<title>SesionUsuario</title>
</head>
<body  background="image/sesionUsu.png">
	<c:set var="pro" scope="request" value="${producto}" />

		<%
			HttpSession login = request.getSession();
			Administrador adm = null;
			Empresa empresa = null;
			if (login.getAttribute("admin") != null){
				String autentificacion = login.getAttribute("admin").toString();
				if (autentificacion.equals("admin") == false){
					session.invalidate();
				    response.sendRedirect("publico/index.html");
				    return;
				}else{
					adm = (Administrador)request.getAttribute("admin");
					empresa = adm.getEmpresa();
				}
				
			}else{
				response.sendRedirect("publico/index.html");
			}
		%>
		
	<header>

            <div class="encabezado">

                <div class="encabezado1">
                    <a href="publico/index.html" title="Ir a la Pagina principal"> <img src="image/Logo2.png" width="200px" height="175px" alt="Logo"> </a>
                </div>

                <div class="encabezado2">

       				 <div id="menu" class="menu">
                        <h1 style="background-color: cadetblue;">Bienvenido <% 
					                        try{
                        						if (adm != null) {
                            						out.println(adm.getNombre()); 
                            					}	
                        					}catch(NullPointerException e){
                        						response.sendRedirect("publico/index.html");
                        					}
                        						
                        					
                        					%>  
                        </h1>
        				 <h2>Administracion de la empresa <% 
               					try{
               						if (adm != null) {
                   						out.println(empresa.getNombre()); 
                   					}	
               					}catch(NullPointerException e){
               						response.sendRedirect("publico/index.html");
               					}			
               					
                        	%>  
                        
                        </h2>
                        
                    </div>
                </div>

                <div class="encabezado3">
                    <div class="ingreUsuEncabezado3">
                        <a href="publico/index.html"> <img src="https://image.flaticon.com/icons/png/512/64/64572.png" width="50px" height="50px" alt="Acceder a la cuenta"></a>
                        <h5>Salir</h5>
                    </div>

             

            </div>

        </header>


       <div class="cuadrado">
         
         
         <nav>
         	
         		 <li style="border-bottom-style: inset;">
          			 <% String url = "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/EnvioDatos2?idAdmin=" + adm.getAdm_id() +"&idEmp="+empresa.getCod_emp()+"&pagina=RegistrarPro.jsp";%>
           			 <a href="<%=url%>"><h2>Registrar Productos</h2></a>
            	</li>
             	<li style="border-bottom-style: inset;">
             		 <% String url2 = "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/EnvioDatos2?idAdmin=" + adm.getAdm_id() +"&idEmp="+empresa.getCod_emp()+"&pagina=modificarPro.jsp";%>
             		<a href="<%=url2%>"><h2>Modificar Producto</h2></a>
              	</li>
              	
              	<li style="border-bottom-style: inset;">
             		 <% String url3 = "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/EnvioDatos2?idAdmin=" + adm.getAdm_id() +"&idEmp="+empresa.getCod_emp()+"&pagina=listarPro.jsp";%>
             		<a href="<%=url3%>"><h2>Listar Productos</h2></a>
              	</li>
              
              	<li style="border-bottom-style: inset;"> 

              		<% String url4 = "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/EnvioDatos2?idAdmin=" + adm.getAdm_id() +"&idEmp="+empresa.getCod_emp()+"&pagina=aprobarPed.jsp";%>
             		<a href="<%=url4%>"><h2>Aprobar Pedidos</h2></a>
              	</li>
              	
              	
              	<li style="border-bottom-style: inset;">
             		 <% String url5 = "/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/EnvioDatos2?idAdmin=" + adm.getAdm_id() +"&idEmp="+empresa.getCod_emp()+"&pagina=listarPed.jsp";%>
             		<a href="<%=url5%>"><h2>Listar Pedidos</h2></a>
              	</li>
          </nav>

       </div>
		
</body>
</html>