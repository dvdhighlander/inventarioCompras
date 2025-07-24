<h1> SERVICIOS PRODUCTOS E INVENTARIO </h1> 
<h2> CONECCION A URL </h2> 
Las URL con los servicios desplegados son </br> 
<h4> ENDPOINT PRODUCTOS: https://products-250024265632.us-central1.run.app </h4>  
<h4> ENDPOINT INVENTARIOS: https://inventory-250024265632.us-central1.run.app </h4> 
<h3> SWAGGER</h3>
Productos: https://productos-250024265632.us-central1.run.app/swagger-ui/index.html</br> 
Inventarios: https://inventario-250024265632.us-central1.run.app/swagger-ui/index.html</br> </br> 
El servicio Productos esta confugurado para el puerto 8080 y el servicio Inventario para el puerto 8081</br> 
Ambos servicios necesitan una api key para poder funcionar, la cual se envia en un header</br> 
nombre header: VENTAS-API-KEY</br> 
valor: 14DFB1BA-063C-43D9-8D5C-3020B1D9782D
</br>
Se crearon 2 servicios, un servicio para manejar los Productos, y un servicio para manejar los Inventarios que conecta con el servicio de Productos para traer los datos de estos.</br>
<h3> ENDPOINTS DISPONIBLES SERVICIO PRODUCTOS </h3> 
<h4>- Listar todos los productos. </h4> 
<b>METODO:</b> GET</br>
<b>URL:</b> https://productos-250024265632.us-central1.run.app/Productos?page=0&pageSize=10</br>
<b>NOTAS:</b> Debe recibir dos parametros para el páginador: page y pageSize. </br>Page se usa para indicar que página traer, siendo el valor 0 la primera página. <br>PageSize es la cántidad de datos que se traeran
<h4>- Obtener un producto específico por ID. </h4> 
<b>METODO:</b> GET</br>
<b>URL:</b> https://productos-250024265632.us-central1.run.app/Productos/{id}</br>
<b>NOTAS:</b> El símbolo {id} en la url debe cambiarse por la id del producto que se va a buscar
<h4>-Crear un nuevo producto. </h4> 
<b>METODO:</b> POST</br>
<b>URL:</b> https://productos-250024265632.us-central1.run.app/Productos</br>
<b>NOTAS:</b> EL JSON necesario puede verse en la documentación swagger.
<h4>-Actualizar un producto por ID. </h4> 
<b>METODO:</b> PUT</br>
<b>URL:</b> https://productos-250024265632.us-central1.run.app/Productos/{id}</br>
<b>NOTAS:</b> El símbolo {id} en la url debe cambiarse por la id del producto que se va a actualizar. </br>
El JSON del body puede verse en la documentación swagger.
<h4>-Eliminar un producto por ID. </h4> 
<b>METODO:</b> DELETE</br>
<b>URL:</b> https://productos-250024265632.us-central1.run.app/Productos/{id}</br>
<b>NOTAS:</b> El símbolo {id} en la url debe cambiarse por la id del producto que se va a borrar
<h3> ENDPOINTS DISPONIBLES SERVICIO INVENTARIOS </h3> 
<h4>- Listar todos los inventarios </h4> 
<b>METODO:</b> GET</br>
<b>URL:</b> https://inventario-250024265632.us-central1.run.app/Inventario/?page=0&pageSize=10</br>
<b>NOTAS:</b> Debe recibir dos parametros para el páginador: page y pageSize. </br>Page se usa para indicar que página traer, siendo el valor 0 la primera página. <br>PageSize es la cántidad de datos que se traeran
<h4>- Consultar la cantidad disponible de un producto específico por ID </h4> 
<b>METODO:</b> GET</br>
<b>URL:</b> https://inventario-250024265632.us-central1.run.app/Inventario/{id}</br>
<b>NOTAS:</b>  El símbolo {id} en la url debe cambiarse por la id del producto que se va a buscar
<h4>- Crear un nuevo inventario para un producto </h4> 
<b>METODO:</b> POST</br>
<b>URL:</b> https://inventario-250024265632.us-central1.run.app/Inventario</br>
<b>NOTAS:</b>   EL JSON necesario puede verse en la documentación swagger.
<h4>- Actualizar la cantidad disponible de un producto </h4> 
<b>METODO:</b> PUT</br>
<b>URL:</b> https://inventario-250024265632.us-central1.run.app/Inventario</br>
<b>NOTAS:</b> El json usado esta en el swagger. El id del producto y la nueva cantidadd van en el json del body. </br>
El JSON del body puede verse en la documentación swagger.

<h4>- Endpoint de Compras </h4> 
<b>METODO:</b> PUT</br>
<b>URL:</b> https://inventario-250024265632.us-central1.run.app/Inventario/RegistrarCompra</br>
<b>NOTAS:</b> El json usado esta en el swagger.
</br>Se creo el servicio de compras en el proyecto de Inventarios porque en la tabla de inventarios es donde se guarda la cantidad de producto. En el servicio de compras se debe obtener y cambiar ese dato, 
por lo que se puede reutilizar el codigo fuente ya utilziado en otros servicios, además se evita crear otro webclient.
</br>
El JSON del body puede verse en la documentación swagger.


<h2> CONECCION A BASE DE DATOS </h2> 
La base de datos utilizada fue MySQL para poder utilizar las llaves foraneas y porque es mas sencillo para el manejo de entidades</br>
Los scripts para la creación de las tablas son:</br>
CREATE TABLE `productos` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(200) NOT NULL,
  `precio` DOUBLE NULL DEFAULT 0,
  `descripcion` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));</br>
  
CREATE TABLE `inventario` (
  `producto_id` INT NOT NULL,
  `cantidad` INT NULL DEFAULT 0,
  INDEX `productosFK_idx` (`producto_id` ASC) VISIBLE,
  CONSTRAINT `productosFK`
    FOREIGN KEY (`producto_id`)
    REFERENCES `productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);</br>
<h2> CONFIGURACIONES NECESARIAS </h2> 
<b>Para correr el código fuente se necesita:</br></b>
     - JAVA 17</br>
     - Maven
     - SpringBoot 3.4.5</br>
     - MySQL 8</br>
  </br>   
- Por motivos de seguridad en Github <b> no se subieron los datos de conección a la Base de Datos </b> al repositorio, por lo que hay que ajustarlos</br>
- En ambos proyectos si se va a cambiar la BD se debe ajustar los datos de conexion a la BD en el archivo: application.properties.</br>
  Se debe cambiar la URL, el Usuario y la Clave.</br>
- Si se queire correr los servicios en local, en el proyecto par el servicio de Inventarios, en la clase InventoryConstants, se debe ajustar la variable BASE_URL_PRODUCTS y colocarle el valor de la URL base de donde se desplegó el servicio de Productos, por ejemplo : http://localhost:8080
