# API de Gestión de Franquicias

Este proyecto implementa una API RESTful para la gestión de franquicias, sucursales y productos, utilizando Spring Boot.

## Descripción

La API permite la gestión de una jerarquía de entidades:

* **Franquicia:** Entidad principal que representa una franquicia, con un nombre y una lista de sucursales.
* **Sucursal:** Entidad que pertenece a una franquicia, con un nombre y una lista de productos ofertados.
* **Producto:** Entidad que se vende en una sucursal, con un nombre y una cantidad de stock.

## Funcionalidades (Criterios de Aceptación)

* [x] Agregar una nueva franquicia.
* [x] Agregar una nueva sucursal a una franquicia existente.
* [x] Agregar un nuevo producto a una sucursal existente.
* [x] Eliminar un producto de una sucursal.
* [x] Modificar el stock de un producto.
* [x] Mostrar el producto con mayor stock por sucursal para una franquicia específica. Retorna un listado de productos con la sucursal a la que pertenecen.

## Funcionalidades Extra

* [x] Empaquetado con Docker.
* [x] Actualizar el nombre de una franquicia.
* [x] Actualizar el nombre de una sucursal.
* [x] Actualizar el nombre de un producto.

## Tecnologías Utilizadas

* Java
* Spring Boot
* Postgres
* Lombok
* Docker
* Docker Compose
* Swagger
* JUnit
* Mockito

## Configuración

### Configuración de la Base de Datos

1.  Se debe crear una base de datos en postgres con el nombre franquicias_db, la creacion de las tablas las realiza Spring Boot.
2.  **Sobrescribir la configuración con `.env` (Recomendado para desarrollo y entornos locales):**

    Puedes personalizar la conexión a la base de datos modificando el archivo `.env` en la raíz del proyecto. Define las siguientes variables de entorno en este archivo para sobrescribir la configuración predeterminada:

    ```
    DATABASE_URL=jdbc:postgresql://<host>:<port>/<database>
    DATABASE_USER=<usuario>
    DATABASE_PASSWORD=<contraseña>
    ```

    Docker Compose leerá automáticamente estas variables al ejecutarse.

### Ejecución

#### Ejecución Local (Sin Docker)

1.  Asegúrate de tener Java y Maven instalados.
2.  Navega al directorio raíz del proyecto en tu terminal.
3.  Ejecuta la aplicación utilizando Maven:

    ```bash
    ./mvnw spring-boot:run
    ```

    o

    ```bash
    mvn spring-boot:run
    ```

#### Ejecución con Docker Compose

1.  Asegúrate de tener Docker y Docker Compose instalados en tu sistema.
2.  Navega al directorio raíz del proyecto en tu terminal.
3.  Ejecuta el siguiente comando para construir la imagen (si es necesario) e iniciar la aplicación utilizando Docker Compose. Este comando también leerá la configuración definida en el archivo `.env`:

    ```bash
    docker-compose up --build -d
    ```

    La aplicación estará accesible en `http://localhost:8083`. Podrás acceder a la documentación de la API utilizando Swagger en la siguiente URL: `http://localhost:8083/swagger-ui/index.html`.

4.  Para detener la aplicación, ejecuta:

    ```bash
    docker-compose down
    ```

## Endpoints de la API

Ejemplo:

* **`POST /franquicia`**: Crea una nueva franquicia.
* **`PATCH /franquicia/{idFranquicia}/nombre`**: Actualiza el nombre de una franquicia.
* **`POST /sucursal`**: Crea una nueva sucursal.
* **`PATCH /sucursal/{idSucursal}/nombre`**: Actualiza el nombre de una sucursal..
* **`POST /producto`**: Crea un nuevo producto.
* **`DELETE /producto/{idProducto}`**: Elimina un producto por id.
* **`PATCH /producto/{idProducto}/stock`**: Modifica el stock.
* **`GET /producto/{idFranquicia}/productos-con-mas-stock`**: Retorna los productos con mas stock a partir de idFranquicia.
* **`PATCH /producto/{idProducto}/nombre`**: Actualiza el nombre de un producto.
