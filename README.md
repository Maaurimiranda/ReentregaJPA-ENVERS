## Proyecto de Gestión de Facturas con JPA y Hibernate Envers ##

Descripción
-----------
Este proyecto es una implementación de un sistema de gestión de facturas utilizando JPA (Java Persistence API) con Hibernate como implementación ORM y Hibernate Envers para la auditoría de cambios en las entidades persistentes. Utiliza la base de datos H2 para el almacenamiento en memoria.

El sistema permite registrar clientes, domicilios, artículos, categorías y facturas, además de llevar un registro histórico de los cambios realizados en las entidades.

Características
---------------
- Persistencia de datos con JPA y Hibernate.
- Auditoría de todas las entidades persistentes con Hibernate Envers.
- Base de datos H2 para desarrollo y pruebas en memoria.
- Relaciones entre entidades como Cliente, Domicilio, Factura, Detalle de Factura, Artículo y Categoría.
- Auditoría automática para registrar cambios en las entidades con un identificador de revisión y timestamp.

Estructura de la Base de Datos
------------------------------
El sistema gestiona las siguientes tablas:

- Cliente: Información de los clientes.
- Domicilio: Datos del domicilio asociados a un cliente.
- Factura: Registro de las ventas realizadas, con referencias a los clientes y detalles de los productos vendidos.
- DetalleFactura: Detalles de cada artículo en una factura.
- Artículo: Productos vendidos, incluyendo su cantidad y precio.
- Categoría: Clasificación de los artículos.
- Relaciones: Tablas intermedias como articulo_categoria para relacionar artículos y categorías.

Tecnologías Utilizadas
----------------------
- Java 17.
- Gradle para la gestión de dependencias.
- JPA (Java Persistence API) para la gestión de la persistencia de datos.
- Hibernate como proveedor de JPA.
- Hibernate Envers para auditoría de entidades.
- Base de datos H2 para el almacenamiento en memoria.
