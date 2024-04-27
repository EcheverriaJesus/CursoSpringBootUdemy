# Aprendiendo Spring Boot 🍃

> 🧑‍🚀 **Curso Spring Boot Udemy** Jesus Echeverria!

### Configurar las variables del properties con utf-8:

@PropertySource(value="classpath:values.properties", encoding = "UTF-8")

### Diferencias entre forward y redirect para cambiar rutas en los controladores:

FORWARD: Mantiene dentro de la misma petición http, y no pierde los parametro que tiene dentro del request, tampoco cambia la ruta url, ya que no hace un refresh, sino que despacha a otra acción del controlador sin recargar la página

REDIRECT: Cambia la ruta url, reinicia el request y refresca el navegador, además que todos los parametros del request que teniamos antes del redirect se pierden en este nuevo request.

### Crear el deploy con mvnw desde VSCODE:

extension maven de java

## Seccion 9:

* Realizaciòn de un CRUD
* @Query("Consulta")
* Como realizar consultas personalizadas como UPPER, LOWER, CONCAT, ORDER, COUNT, MIN, MAX, LONG, SUM, AVG.

## Seccion 10:

* Columnas Created & Updatad en la tabla
* Notacion @Embeddeble
* Trabajando con CleanCode en los metodos Created y Updated

## Seccion 11:

* Conexion a Base de Datos, configuracion para crear automaticamente la tabla desde el entity
* JPA
* Hibernate
* Relaciones en tablas: ManyToMany, ManyToOne, OneToOne, OneToMany
* Creacion de tablas pibotes automaticas y personalizadas
* Creacion de llaves foraneas automaticas y personalizadas @Join Column
* Eliminación de datos relacionados entre tablas
* Relaciones Bidirecionales

## Seccion 12:

> 🦾 **CREACIÓN DE UN CRUD** jpa

> 🤺 **NOTACIONES PARA VALIDAR CAMPOS DE LA TABLA** @Notaciones

* Validar cuando es nulo el valor
* Parametros donde se puede configurar el minimo de caracteres en String
* @NotEmpty
* @Size(min=3, max=20)
* Expresiones regulares @pattern
* Validar el tamaño de una columna Integer @Min(500)

> ❌ **PERSONALIZAR LOS ERRORES 1** BidingResult

* BidingResult: personalización de errores sin menmsajes, solo con status

> ⚠️ **PERSONALIZAR LOS EMNSAJES** Errores

* Creacion de mensajes en el properties
* Importar archivos properties en AppConfig
* Configuracion de las properties en las notaciones requeridas como el @NotNull @NotEmpty

> ⚠️ **PERSONALIZAR LOS ERRORES** Mediante una clase validation

* No se necesitan variables en el properties

> ⚠️ **PERSONALIZAR LOS EMNSAJES** Por @Notaciones

## Seccion 13:

* Asignar un valor default a una columna en la BD @PrePersist
* Saber si un valor ya existe en la BD

> 🛡️ **SPRING SECURITY** Utilizabdo CRUD de la seccion 12

> 🌐 **JWT** Spring Security

> ♻️ **CEACIÓN Y VIDA DE UN TOKEN** Jwt

> 👤 **ROLES Y PERMISOS** Utilizando clase especifica

> 👤 **ROLES Y PERMISOS** Utilizabdo Notaciones @

* @PreAuthorize

> 🛡️ **CORS** Configuración del Cors

* Cualquier Ruta: @CrossOrigin(OriginPatterns = "*")
* Rutas Especificas: @CrossOrigin(Origins = "Rutas")
* CorsConfigurationSource
* CorsFilter

## Seccion 15: 

> 📦 **CREACION DEL BUILD** Enpaquetado del proyecto

```bash
  ./mvnw clean package
```

> 🌐 **SERVIDOR** Base de dtaos AWS

* Amazón RDS
* Subir Jar en AWS

## Seccion 16: 

> **APACHE TOMCAT** Deploy

## Seccion 17:

> **REACT.JS** Proyecto react.js

* Creacion de proyecto con vite

```bash
  npm create vite@latest
```

* PorpTypes
* CRUD con useState & useEffect
* Estilos con Boostrap 

## seccion 18:

> **BACK END** Pruebas con back end para react.js

* Spring Data Rest CRUD
* HATEOAS -> "Hypermedia As The Engine Of Application State"

Con la dependencia Data Rest se configura un Crud en poco timepo,, se necita la configuracion en el repository.

```bash
  @RepositoryRestResource(path = "NameEntity")
```

## Seccion 19:

> **AXIOS EN REACT.JS** Configuracion de React para consumo de apis

* Instalacion de Axios en react.js
```bash
  npm i axios
```
* Consumo del back de la seccion 18 con react.js y axios para realizar el CRUD

## Seccion 20:

> **ANGULAR** Configuracion de angular para consumo de apis

* Instalar ultima version de angular

```bash
  npm install -g @angular/cli
```
* Crear proyecto en Angular

```bash
  ng create angular-app
```
* Observables: Metodos: Suscribe, Map, Filter, Retry
* Crear componente en Angular

> **COMPONENTE** Crear un componente en angular desde consola

```bash
  ng generate component components/product
``` 

ng --> comando angular
generate --> craer archivo
component --> tipo de archivo (component || service)
components --> carpeta dentro de app
product --> carpeta dentro de components y nombre de archivo

* Validacion con Angular para Formularios

## Seccion 21:

> **CONSUMO APIS** Configuracion para consumir api en angular

# Segundo Curso dentro del mismo -- Spring Boot -- 🍃

## Seccion: 24:

> **CARACTERISTICAS** Thymleaf, @GetMappping, Redirect, Forward

## Seccion 28:

> **INTERCEPTORES** Metodo Handler

## Seccion: 30:

> **ENDPOINTS CRUD** Creacion de los metodos del CRUD

## Seccion 31:

> **LAYOUT** Archivo layout HTML para las vistas en el tamplete

* fragment
* replace

> **ALERTS** Creacion de alertas para las acciones del CRUD

* Configuracion de tipo de alertas y mensaje en el controlador
* Diseño de alertas con Boostrapp 

> **PAGINATION** Creacion de la paginacion

* Configuracion de la paginacion en la carpeta paginator (Pageable, PageRequest)
* Diseño Boostrapp

# Proyecto PosSystem Microservicio con Spring Boot
