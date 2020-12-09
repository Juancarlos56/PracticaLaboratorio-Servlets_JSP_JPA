/**
 * 
 */

function listarPedido(idEmp, idUsuario) {
	
    var nomPro = document.getElementById("nomPro").value;
	console.log("Estamos al final idUsuario:"+idUsuario+" idEmp: "+idEmp);
	
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
    
        xmlhttp.open("GET", "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/ModificarPedido?idUsuario=" + idUsuario +"&idEmp="+idEmp, true);
	    xmlhttp.send();
    }
    return false;
}


function mostrarPedido(codPedido,proNombre,pedEstado,pedCantidad,iva,proPrecio,total) {
    console.log("Estamos en modificar pedido");
	document.getElementById("idTextpedido").value = codPedido;
	document.getElementById("nomTextPro").value = proNombre;
	document.getElementById("estadoTextPed").value = pedEstado;	
	document.getElementById("numCantidadPed").value = pedCantidad;
	document.getElementById("iva").value = iva;
	document.getElementById("precioPro").value = proPrecio;
	document.getElementById("total").value = total;	
	
}


function calcularTotal() {		
	var precio = document.getElementById("precioPro").value;
	var cantidad = document.getElementById("numCantidadPed").value;
	var iva = document.getElementById("iva").value;	
	var calIva = ((precio*cantidad)*iva)/100;
	var total = (precio*cantidad)+calIva
	document.getElementById("total").value = total;

}

function actualizarPedido() {
	
	var codPedido = document.getElementById("idTextpedido").value;
	var cantidad = document.getElementById("numCantidadPed").value;
	var total = document.getElementById("total").value
	
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
			document.getElementById("idTextpedido").value = "ID del pedido";
			document.getElementById("nomTextPro").value = "Nombre del producto";
			document.getElementById("estadoTextPed").value = "Estado del pedido";
			document.getElementById("numCantidadPed").value = 0;
			document.getElementById("precioPro").value = 0;
			document.getElementById("total").value = 0;
			document.getElementById("iva").value = 0;
        }
    };
    
	xmlhttp.open("GET", "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/ActualizarPedido?codPedido="+codPedido+"&cantidad="+cantidad+"&total="+total, true);
	xmlhttp.send();
		
}


function eliminarPedido() {
	
	var codPedido = document.getElementById("idTextpedido").value;
	
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
			document.getElementById("idTextpedido").value = "ID del pedido";
			document.getElementById("nomTextPro").value = "Nombre del producto";
			document.getElementById("estadoTextPed").value = "Estado del pedido";
			document.getElementById("numCantidadPed").value = 0;
			document.getElementById("precioPro").value = 0;
			document.getElementById("total").value = 0;
        }
    };
    
	xmlhttp.open("GET", "/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA/EliminarPed?codPedido="+codPedido, true);
	xmlhttp.send();
		
}
