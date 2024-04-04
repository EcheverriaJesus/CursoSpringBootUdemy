# Aprendiendo Spring Boot 🍃

> 🧑‍🚀 **Curso Spring Boot Udemy?** Jesus Echeverria!

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