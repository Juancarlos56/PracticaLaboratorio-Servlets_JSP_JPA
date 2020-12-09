/**
 * 
 */

/**
 * 
 */


function EnviarDatos(idUsuario,idEmpresa,pagina) {   
	if (window.XMLHttpRequest) {
	    // code for IE7+, Firefox, Chrome, Opera, Safari
	    xmlhttp = new XMLHttpRequest();
	} else {
	    // code for IE6, IE5
	    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	        //alert("llegue");
	        document.getElementById("informacion").innerHTML = this.responseText;
	    }
	};
	console.log("Estamos al final idUsuario:"+idUsuario+" idEmp: "+idEmpresa+" pagina "+pagina);
	xmlhttp.open("GET", "/Practica_de_laboratorio_02_Servlets_JSP_y_JPA/EnvioDatos?idUsuario=" + idUsuario +"&idEmp="+idEmpresa+"&pagina="+pagina, true);
	xmlhttp.send();
    return false;

}

function buscarProducto(idEmp) {
	
    var nomPro = document.getElementById("nomPro").value;
	console.log("Estamos al final nomPro:"+nomPro+" idEmp: "+idEmp);
	
    if (nomPro == "") {
        document.getElementById("informacion").innerHTML = "";
    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };
        console.log("Estamos al final nomPro:"+nomPro+" idEmp: "+idEmp);
        xmlhttp.open("GET", "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/BuscarProducto?nomPro=" + nomPro +"&idEmp="+idEmp, true);
	    xmlhttp.send();
    }
    return false;
}




function mostrarProductos(codPro, nomPro, PrecioPro, iva) {
    console.log("ivaaaaaa: "+iva);
	document.getElementById("codPro").value = codPro;
	document.getElementById("nombreProducto").value = nomPro;
	document.getElementById("precioPr").value = PrecioPro;
	document.getElementById("iva").value = iva;	
}



function calcularTotal() {		
	var precio = document.getElementById("precioPr").value;
	var cantidad = document.getElementById("cantidadPro").value;
	var iva = document.getElementById("iva").value;	
	var calIva = ((precio*cantidad)*iva)/100;
	var total = (precio*cantidad)+calIva
	document.getElementById("mostrarTotalPed").value = total;

}

function realizarPedido(idUsu) {
	
	var idUsuario = idUsu;		
	console.log("Este es el usuario: "+idUsu);
	var codPro = document.getElementById("codPro").value;
	var cantidad = document.getElementById("cantidadPro").value;
	var total = document.getElementById("mostrarTotalPed").value
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
	xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue");
            document.getElementById("informacion2").innerHTML = this.responseText;
        }
    };
    
	xmlhttp.open("GET", "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/NuevoPedido?idUsuario="+idUsuario+"&cantidad="+cantidad+"&total="+total+"&codPro="+codPro, true);
	xmlhttp.send();
		
}



function buscarPorCorreo() {
    var correo = document.getElementById("correo").value;
    if (correo == "") {
        document.getElementById("informacion").innerHTML = "";
    } else {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET", "../../controladores/listarTelefonosCorreo.php?correo=" + correo, true);
        xmlhttp.send();
    }
    return false;
}
