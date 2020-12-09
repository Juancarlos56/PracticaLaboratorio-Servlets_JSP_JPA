# Pr-cticaLaboratorio02-Servlets_JSP_JPA
### TÍTULO PRÁCTICA: 
Desarrollo de una aplicación JEE basado en Servlets, JSP y JPA para el intercambio de datos en un modelo de tres capas aplicando los patrones diseño de software MVC y DAO

1.      El sistema debe ser igual al anterior en cuanto a contenido de modelo con sus clases POJO’s , la vista se mantiene con los archivos JSP+ JSTL. Al igual que los controladores DAO’s y Servlets.

2.	La persistencia a la base de datos será a través de JPA, y las consultas SQL a la base de datos deben ser realizadas aplicando Criteria y JPQL.

### 3. Desarrollo de la aplicación con tecnología JEE.
La aplicación web, tiene la siguiente estructura en sus carpetas:

![24JPA](https://user-images.githubusercontent.com/51839660/101503011-a5a97080-393f-11eb-84b7-4a088384c31b.JPG)
![25JPA](https://user-images.githubusercontent.com/51839660/101503025-a93cf780-393f-11eb-9334-d5c0fc767fd4.JPG)

Para esta práctica reutilizamos el código ya creado con anterioridad que no debida ser modificada, en la carpeta WebContent, la información es la misma que en la primera practica presentada. Existe la parte publica y privada del sistema. Al igual que se trabaja con los tipos de usuario que son administrador y usuario normal. 

En caso del paquete SRC las clases POJO’s en este caso están modificadas, anteriormente el paquete se llamaba modelo y ahora este paquete se llama entidades. En el caso de la primera practica las clases dentro del paquete modelo, eran clases de java, que solo tenían meditos de get, set y un public Administrador. En este caso estas clases aumentan un GenerationType.Indentity para que nuestra clase sea una entidad. Como se muestra a continuación 
Administrador de la primera practica


![26JPA](https://user-images.githubusercontent.com/51839660/101503077-b954d700-393f-11eb-8184-665eab87cdc9.JPG)

![27JAP](https://user-images.githubusercontent.com/51839660/101503162-ceca0100-393f-11eb-8cb5-64bdfb988106.JPG)

- De igual forma estas modificaciones se aplicaron a todas nuestras clases en el paquete entidades. 

- En el paquete de jpa en el cual se tiene una factoroia del administrador y un método de control de logeo en el cual se recibe el correo del administrador y la contraseña.  Este paquete reemplaza al paquete anterior conocido como mysql.jdbc siendo el que tiene las consultas a nuestra base de datos. 

![28JPA](https://user-images.githubusercontent.com/51839660/101503232-e1dcd100-393f-11eb-82b0-0ca40183b111.JPG)

### 4. 	En este punto se pretende mostrar el funcionamiento de la aplicación para la segunda practica, debido a que se reutilizo código, las interfaces no tienen ningún cambio. 
Pagina de inicio de sesión con el usuario katerinbarrera21@gmail.com y la contraseña 1234.

![29JPA](https://user-images.githubusercontent.com/51839660/101503289-f15c1a00-393f-11eb-8a89-1f69bcff81e4.JPG)

- Se presenta el menú que manejara como usuario normal y las opciones que puede realizar. 

![30JPA](https://user-images.githubusercontent.com/51839660/101503362-033dbd00-3940-11eb-9d5a-c7c8daf0cd68.JPG)

- Luego como ejemplo realizamos el realizar un pedido a la empresa del usuario que seria en este caso la empresa TIA. 

![nueva](https://user-images.githubusercontent.com/51839660/101503479-24061280-3940-11eb-8ab6-5f38f5ff6f06.JPG)

- El producto que se tomo para el ejemplo es el aceite girasol del cual se pido una cantidad de 20 con un iva del 12% obtenemos un total de 56 dólares. Presentamos un mensaje para indicar el usuario que su pedido fue realizado. En la opción listar pedido existe la opción para que el usuario visualice su propio pedido. 

- Ahora ingresamos sesión como usuario administrador para verificar que el pedido haya sigo registrado y el administrador pueda rechazarlo o aprobarlo.

![31JPA](https://user-images.githubusercontent.com/51839660/101503598-41d37780-3940-11eb-869f-a6dc81e5de3a.JPG)

 Se presta el menú para el administrador de la empresa Tía. 
 
![32JPA](https://user-images.githubusercontent.com/51839660/101503643-4d26a300-3940-11eb-8b46-64928105036b.JPG)


Para visualizar los pedidos podemos listar los pedidos que existen para la empresa o podemos aprobar los pedidos. En este caso aprobaremos el pedido y luego listaremos para observar como se cambia el estado de pendiente a “Aprobado”.

-Se listaron los pedidos recientes con estado pendiente y se aprobó, por lo que en la pantalla se muestra el mensaje de aprobado. Ahora listaremos para observar el cambio de estado. 

![33JPA](https://user-images.githubusercontent.com/51839660/101503680-5879ce80-3940-11eb-8c55-8ad2abdb5eb9.JPG)

### RESULTADO(S) OBTENIDO(S):
•	Maneja diferentes formatos para el intercambio de datos entre aplicaciones.
•	Diseña y desarrolla aplicaciones en capas con nuevas tecnologías.
•	Se logro crear una aplicación con una interfaz de usuario adecuada, además de que es fácil de comprender para los usuarios. 

### CONCLUSIONES:
- En primera instancia la aplicación desarrollada mantuvo las mismas interfaces que la anterior practica por lo que su desarrollo en esa parte fue más rápida, sin embargo al momento de usar JPA, tuvimos ciertas dificultades, sin embargo estas dificultades finalmente fueron solventadas y se pudo lograr crear la aplicación tu pídelo con JPA. 
- Se adquirió un conocimiento más conciso, debido a que las practicas ayudan a la compresión de toda la teoría que se pudo ver en clases y con estos ejemplos que se realizaron logra comprender de manera eficaz el conocimiento impartido durante las clases
