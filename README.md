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

## Diseño de Despliegue en AWS:

* **Amazon Elastic Container Registry (ECR):** El registro de contenedores Docker administrado para almacenar y gestionar las imágenes Docker de la aplicación.
* **Amazon Elastic Container Service (ECS):** La plataforma de orquestación de contenedores administrada que facilita la ejecución, el escalado y la administración de aplicaciones Dockerizadas. Puede operar con nuestro esquema Fargate (serverless) o nuestras instancias EC2.
* **ECS Task Definition:** La definición de tarea que describe los contenedores a ejecutar en ECS, incluyendo la imagen Docker, los puertos, los recursos y las variables de entorno.
* **ECS Service:** El servicio que mantiene un número específico de instancias de la Task Definition activas y gestiona su escalabilidad y disponibilidad.
* **Application Load Balancer (ALB):** El balanceador de carga de capa 7 que distribuye el tráfico HTTP/HTTPS entrante a las instancias de los contenedores en ECS, sirviendo como nuestro punto de acceso a la aplicación.
* **Amazon Virtual Private Cloud (VPC):** La red virtual aislada en AWS, que provee control sobre el entorno de red para nuestros recursos.
* **Subnets:** Rangos de direcciones IP dentro de nuestra VPC donde se despliegan nuestros recursos de AWS. Es recomendable la distribución en múltiples Availability Zones para alta disponibilidad.
* **Amazon RDS (Relational Database Service):** El servicio de base de datos relacional administrado que simplifica la configuración, operación y escalado de bases de datos en la nube (si la aplicación lo requiere).
