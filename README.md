## APLICACION USANDO SPRING BOOT
Esta es una aplicacion de clientes creando un crud basico con spring boot y thymeleaf
### Requisitos
- Java 8
- Maven
- Spring Boot
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- MySQL Connector
- Lombok
- Springdoc OpenAPI UI

### Instalacion
1. Clonar el repositorio
```bash
git clone https://github.com/JuanjMedina/JavaRest.git 
```


2. Crear la base de datos en MySQL

```mysql
CREATE DATABASE dbclientes;
```

3. Crear la tabla en MYSql y agregar datos
```mysql
CREATE TABLE `db_springboot_dev`.`clientes` (
  `id_cliente` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `fecha_registro` date  NOT NULL,
  PRIMARY KEY (`id_cliente`));
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Joel', 'Jurado', 'juradoec@yahoo.com', '2023-08-01');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Carlos', 'Miranda', 'mirandaTr98@gmail.com', '2023-08-02');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Marcela', 'Sanchez', 'schMarce@itb.com', '2023-08-03');
INSERT INTO clientes (nombre, apellido, correo, fecha_registro) VALUES('Ben', 'Tennyson', 'ben10@cn.com', '2023-08-04');
```

3. Modificar el archivo application.properties
```properties
spring.application.name=ApiRestJava
server.port=8082

# Config Database
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username= username
spring.datasource.password= paswsword
spring.datasource.url=jdbc:mysql://localhost:3306/dbspringboot?useSSL=false&allowPublicKeyRetrieval=true


# Config Hibernate
spring.jpa.database-platform= org.hibernate.dialect.MySQL8Dialect


# Config OpenApi Swagger
springdoc.swagger-ui.path=/swagger-ui-custom.html
```


### ENDPOINTS
La aplicacion cuenta con los siguientes endpoints siguiendo la siguiente estructura


```sh
PORT/api/v1
```

- GET /clientes
- GET /clientes/{id}
- POST /clientes
- PUT /clientes/{id}
- DELETE /clientes/{id}

### Ejecutar la aplicacion
```bash
mvn spring-boot:run
```

### Autor
**Juan Medina**
