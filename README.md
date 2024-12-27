# API de Gestión de Franquicias

Este proyecto implementa una API RESTful para la gestión de franquicias, sucursales y productos, utilizando Spring Boot.

## Descripción

La API permite la gestión de una jerarquía de entidades:

*   **Franquicia:** Entidad principal que representa una franquicia, con un nombre y una lista de sucursales.
*   **Sucursal:** Entidad que pertenece a una franquicia, con un nombre y una lista de productos ofertados.
*   **Producto:** Entidad que se vende en una sucursal, con un nombre y una cantidad de stock.

## Funcionalidades (Criterios de Aceptación)

*   [x] Agregar una nueva franquicia.
*   [x] Agregar una nueva sucursal a una franquicia existente.
*   [x] Agregar un nuevo producto a una sucursal existente.
*   [x] Eliminar un producto de una sucursal.
*   [x] Modificar el stock de un producto.
*   [x] Mostrar el producto con mayor stock por sucursal para una franquicia específica. Retorna un listado de productos con la sucursal a la que pertenecen.

## Funcionalidades Extra (Puntos Extra)

*   [ ] Empaquetado con Docker.
*   [x] Programación funcional/reactiva.
*   [x] Actualizar el nombre de una franquicia.
*   [x] Actualizar el nombre de una sucursal.
*   [x] Actualizar el nombre de un producto.
*   [ ] Aprovisionamiento de la persistencia con Infraestructura como Código (Terraform, CloudFormation, etc.).
*   [ ] Despliegue en la nube.

## Tecnologías Utilizadas

*   Java
*   Spring Boot
*   Postgres

## Configuración

1.  Configurar la base de datos:

    *   La base de datos se encuentra en RDS.
    *   url=jdbc:postgresql://database-1.cdwqeoasy4ic.us-east-2.rds.amazonaws.com/franquicias_db
    *   username=postgres
    *  password=bOKN7Wfr6jPDNiEB4Hgb

2.  Ejecutar la aplicación:

    ```bash
    ./mvnw spring-boot:run
    ```

    o

    ```bash
    mvn spring-boot:run
    ```

## Endpoints

Se agrega collecion postman el la carputa resources (src/main/resources/Franquicias.postman_collection.json)

Ejemplo:

*   **`POST /franquicias`**: Crea una nueva franquicia.

    ```json
    {
      "nombre": "Nombre de la franquicia"
    }
    ```

    Respuesta (201 Created):

    ```json
    {
      "id": 1,
      "nombre": "Nombre de la franquicia"
    }
    ```
