# Aprendiendo Spring Boot 🍃

### Configurar las variables del properties con utf-8:

@PropertySource(value="classpath:values.properties", encoding = "UTF-8")

### Diferencias entre forward y redirect para cambiar rutas en los controladores:

FORWARD: Mantiene dentro de la misma petición http, y no pierde los parametro que tiene dentro del request, tampoco cambia la ruta url, ya que no hace un refresh, sino que despacha a otra acción del controlador sin recargar la página

REDIRECT: Cambia la ruta url, reinicia el request y refresca el navegador, además que todos los parametros del request que teniamos antes del redirect se pierden en este nuevo request.

### Crear el deploy con mvnw desde VSCODE:

extension maven de java