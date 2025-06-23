# Microservicio_de_Venta

Proyecto en Java Spring Boot. Microservicio para la gestión de ventas.

Conexión a base de datos en una instancia AWS con MySQL Server.


---

## Requisitos

- Java 17 o superior
- Maven
- MySQL (AWS RDS o local)
- IDE recomendado: IntelliJ IDEA o VS Code
- (opcional)Postman
- microservicio de cliente (para metodo "Factura") https://github.com/YerkoNavarro/Microservicio_De_Usuario.git

---

## Métodos utilizados

- **crearVenta**: Crea una venta en la base de datos.  
- **traerVenta**: Muestra una venta que se encuentra en la base de datos.  
- **eliminarVenta**: Elimina la venta de la base de datos, se debe proporcionar el ID.  
- **Factura**: Se conecta con un microservicio externo de usuarios para traer los datos de usuario y mostrarlos en formato `String`.

---

## Conexión a base de datos

Para hacer la conexión a la base de datos se debe crear un archivo `.env` en la raíz principal con el siguiente formato:

```env
ENV_USER=usuarioDeEjemplo
ENV_PASS=contraseñaDeEjemplo
ENV_SERVER=(server ip o localhost)
ENV_PORT=3306(para Mysql)
ENV_DBNAME=nombreBaseDeDatos
```
---
## Formato de ingreso de datos

Los parámetros se deben enviar en formato JSON.

### Ejemplo de solicitud

**Método:** `POST`  
**Endpoint:** `/api/v1/ventas/`

**Cuerpo de la solicitud:**
```json
{
  "idVenta": 0,
  "idUsuario": 0,
  "idProductos": [
    0
  ]
}
```
## Pruebas de los Endpoints

Puedes probar todos los métodos disponibles del microservicio utilizando Swagger UI.

### Accede desde el navegador:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Desde esta interfaz podrás realizar solicitudes `POST`, `GET`, `DELETE`, y visualizar la documentación generada automáticamente por Spring Boot.








