package ec.edu.ups.controladores;

import ec.edu.ups.dao.AdministradoresDAO;

import ec.edu.ups.dao.CategoriasDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresasDAO;
import ec.edu.ups.dao.PedidosDAO;
import ec.edu.ups.dao.ProductosDAO;
import ec.edu.ups.dao.UsuariosDAO;
import ec.edu.ups.entidades.Administrador;
import ec.edu.ups.entidades.Categoria;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Usuario;

public class CreacionProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//EmpresasDAO emp = DAOFactory.getFactory().getEmpresasDAO();
		//CategoriasDAO cat = DAOFactory.getFactory().getCategoriasDAO();
		//ProductosDAO prod = DAOFactory.getFactory().getProductosDao();
		
		//Con esto creo
		 
		//Empresa empresa = new Empresa(0, "Pizza Hut", "Todos los dias", "Pizza", "oisadvniodsbv");
		//Empresa empresa2 = new Empresa(0, "Tia", "Todos los dias", "Comercial", "oisadvniodsbv");
		//Empresa empresa3 = new Empresa(0, "Floristeria", "Todos los dias", "Flores", "oisadvniodsbv");
		
		 
		
		
		Empresa empresa = new Empresa(1, "Pizza Hut", "Todos los dias", "Pizza", "oisadvniodsbv");
		Empresa empresa2 = new Empresa(2, "Tia", "Todos los dias", "Comercial", "oisadvniodsbv");
		Empresa empresa3 = new Empresa(3, "Floristeria", "Todos los dias", "Flores", "oisadvniodsbv");
		
		//emp.create(empresa);
		//emp.create(empresa2);
		//emp.create(empresa3);	
		
		//Con esto cargo las categorias
		//Categoria c = new Categoria(0,"Pizzas", "https://image.freepik.com/vector-gratis/pizza-soda-icono-aislado-diseno_24877-39289.jpg");		
		//Categoria c2 = new Categoria(0,"Primera necesidad", "https://media.enfasis.com/adjuntos/146/imagenes/000/136/0000136982.jpg");
		//Categoria c3 = new Categoria(0, "Flores", "https://static.dw.com/image/16857974_303.jpg");
		
		//cat.create(c);
		//cat.create(c2);
		//cat.create(c3);
		
		Categoria c = new Categoria(1,"Pizzas", "https://image.freepik.com/vector-gratis/pizza-soda-icono-aislado-diseno_24877-39289.jpg");		
		Categoria c2 = new Categoria(2, "Flores", "https://static.dw.com/image/16857974_303.jpg");
		Categoria c3 = new Categoria(3,"Primera necesidad", "https://media.enfasis.com/adjuntos/146/imagenes/000/136/0000136982.jpg");
		
		//Producto p = new Producto(0, "Paquete de Rosas", 5.0, 12, "https://http2.mlstatic.com/paquetes-de-25-rosas-naturales-de-venta-distribuidor-D_NQ_NP_705608-MEC30007578565_042019-F.jpg", "Paquete de todos los colores", "Activo", c3, empresa3);
		//Producto p2 = new Producto(0, "Paquete de Rosas", 5.0, 12, "https://http2.mlstatic.com/paquetes-de-25-rosas-naturales-de-venta-distribuidor-D_NQ_NP_705608-MEC30007578565_042019-F.jpg", "Paquete solo rojos", "Activo", c3, empresa3);
		//Producto p3 = new Producto(0, "Pizza de peperonni", 12.0, 12, "https://placeralplato.com/files/2016/01/Pizza-con-pepperoni.jpg", "Pizza de peperonni con gaseosa", "Activo", c, empresa);
		//Producto p4 = new Producto(0, "Pizza de hawaiana", 13.0, 12, "https://i.pinimg.com/originals/27/24/4f/27244fdcfca45fcb75a4cdda7e1996f8.jpg", "Pizza de piña con gaseosa", "Activo", c, empresa);
		//Producto p5 = new Producto(0, "Aceite", 2.5, 12, "https://tiaecuador.vteximg.com.br/arquivos/ids/170789-1000-1000/257426000.jpg?v=637348493537970000", "Aceite de cocina", "Activo", c2, empresa2);
		//Producto p6 = new Producto(0, "Atun", 1.5, 12, "https://tiaecuador.vteximg.com.br/arquivos/ids/155881-1000-1000/2000331.jpg?v=636225933159070000", "Atun real ecuador", "Activo", c2, empresa2);
		
		//prod.create(p);
		//prod.create(p2);
		//prod.create(p3);
		//prod.create(p4);
		//prod.create(p5);
		//prod.create(p6);
		
		//AdministradoresDAO admin = DAOFactory.getFactory().getAdministradoresDAO();
		
		//Administrador a = new Administrador(0, "jbarrera1@est.ups.edu.ec", "1234", "Juan Carlos", "Admin",empresa3);
		//Administrador a2 = new Administrador(0, "kbarrera1@est.ups.edu.ec", "1234", "Katherine Barrera", "Admin",empresa2);
		//Administrador a3 = new Administrador(0, "jChiqui@est.ups.edu.ec", "1234", "John Henry", "Admin",empresa);
		
		//admin.create(a);
		//admin.create(a2);
		//admin.create(a3);
		
		
		//UsuariosDAO usu = DAOFactory.getFactory().getUsuariosDAO();
		//Usuario u = new Usuario(0, "barrerajuan930@gmail.com", "1234", "Juan Carlos", "Usuario",empresa3);
		//Usuario u2 = new Usuario(0, "katerinbarrera21@gmail.com", "1234", "Katherine Barrera", "Usuario",empresa2);
		//Usuario u3 = new Usuario(0, "johnhenry@gmail.com", "1234", "John Henry", "Usuario",empresa);
		
		//usu.create(u);
		//usu.create(u2);
		//usu.create(u3);
				
		Usuario u = new Usuario(1, "barrerajuan930@gmail.com", "1234", "Juan Carlos", "Usuario",empresa3);
		//Usuario u2 = new Usuario(2, "katerinbarrera21@gmail.com", "1234", "Katherine Barrera", "Usuario",empresa2);
		//Usuario u3 = new Usuario(3, "johnhenry@gmail.com", "1234", "John Henry", "Usuario",empresa);
				
		//ProductosDAO prod = DAOFactory.getFactory().getProductosDao();
		
		Producto p = new Producto(1, "Paquete de Rosas", 5.0, 12, "https://http2.mlstatic.com/paquetes-de-25-rosas-naturales-de-venta-distribuidor-D_NQ_NP_705608-MEC30007578565_042019-F.jpg", "Paquete de todos los colores", "Activo", c2, empresa2);
		//Producto p2 = new Producto(0, "Paquete de Rosas", 5.0, 12, "https://http2.mlstatic.com/paquetes-de-25-rosas-naturales-de-venta-distribuidor-D_NQ_NP_705608-MEC30007578565_042019-F.jpg", "Paquete solo rojos", "Activo", c2);
		//Producto p3 = new Producto(0, "Pizza de peperonni", 12.0, 12, "https://placeralplato.com/files/2016/01/Pizza-con-pepperoni.jpg", "Pizza de peperonni con gaseosa", "Activo", c);
		//Producto p4 = new Producto(0, "Pizza de hawaiana", 13.0, 12, "https://i.pinimg.com/originals/27/24/4f/27244fdcfca45fcb75a4cdda7e1996f8.jpg", "Pizza de piña con gaseosa", "Activo", c);
		//Producto p5 = new Producto(0, "Aceite", 2.5, 12, "https://tiaecuador.vteximg.com.br/arquivos/ids/170789-1000-1000/257426000.jpg?v=637348493537970000", "Aceite de cocina", "Activo", c3);
		//Producto p6 = new Producto(0, "Atun", 1.5, 12, "https://tiaecuador.vteximg.com.br/arquivos/ids/155881-1000-1000/2000331.jpg?v=636225933159070000", "Atun real ecuador", "Activo", c3);
		
		//prod.create(p);
		//prod.create(p2);
		//prod.create(p3);
		//prod.create(p4);
		//prod.create(p5);
		//prod.create(p6);
		
		PedidosDAO pedi = DAOFactory.getFactory().getPedidosDAO();
		Pedido ped = new Pedido(0, "Pendiente", 10, 50.0, u, p);
		pedi.create(ped);
		
	
	}

}
