<h1>Microservicio de Mensajeria</h1>

<img src="https://img.shields.io/badge/%E2%98%95%20Java-%23c98524.svg?style=logoColor=white" alt="Logo Java" />
<img src="https://img.shields.io/badge/Swagger-%2385EA2D.svg?&style=flat-square&logo=swagger&logoColor=blue" alt="Logo Swagger" />
<img src="https://img.shields.io/badge/Spring%20Security-%23569A31.svg?&style=flat-square&logo=spring&logoColor=white" alt="Logo Spring Security" />
<img src="https://img.shields.io/badge/Twilio-%23F22F46.svg?&style=flat-square&logo=twilio&logoColor=white" alt="Logo Twilio" />

## Descripcion

Este microservicio proporciona funcionalidad para enviar notificaciones a los clientes mediante la API de SMS de Twilio. 
Está construido con Spring Security, Spring Boot y Swagger para la documentación de la API.

## Integracion con Twilio

El servicio de mensajería utiliza el software/API de Twilio para enviar mensajes de texto (SMS). La integración con Twilio permite enviar notificaciones, 
alertas o cualquier tipo de mensaje de texto a los destinatarios especificados.

Solo se pueden enviar a un número de teléfono verificado, cuando envíe un SMS desde su número de teléfono de prueba gratuito, comenzará con "Sent from your Twilio trial account -".<br>

La longitud de los mensajes SMS está limitada a 160 caracteres, Cuando se envía un mensaje SMS que excede el límite de caracteres, Twilio automáticamente dividirá el mensaje en segmentos 
y los enviará de manera concatenada. Sin embargo, ten en cuenta que cada segmento se contará y cobrará por separado como un mensaje individual. Además, algunos caracteres especiales y emojis 
pueden ocupar más espacio en un segmento y reducir aún más la cantidad de caracteres disponibles.

## Requisitos previos

<ul>
    <li>Java 8 o superior</li>
    <li>Gradle - Groovy</li>
    <li>Credenciales de la cuenta de Twilio</li>
</ul>

## 🛠️ Abre y ejecuta el proyecto

<ol>
    <li>Configure las credenciales de Twilio: </li><br>
En el archivo application.properties, proporcione las siguientes propiedades:
    
    twilio.account.sid= "your-twilio-account-sid"
    twilio.auth.token= "your-twilio-auth-token" 
    twilio.phone.from= "your-twilio-phone-number-from" 

<li>Accede a la documentación de la API:</li><br>
Abra su navegador web y vaya a <a href="http://localhost:9280/swagger-ui.html">http://localhost:9280/swagger-ui.html</a> para ver e interactuar con la API mediante Swagger.
</ol>

## API Endpoints

### Notificar que el pedido está listo

<ul>
    <li>URL: '/messenger-service/notify'</li>
    <li>Metodo: POST</li>
    <li>Rol Requerido: EMPLEADO</li>
    <li>Cuerpo de la solicitud: </li>

    {
      "orderPin" : 11111
      "restaurantName": "nombre del restaurante",
      "customerName": "John Doe",
      "customerCellPhone": "+573983458212"
    }


<li>Respuesta de la solicitud: </li>

    {
      "status": "QUEUED",
      "errorCode": "null",
      "errorMessage": "null",
      "direction": "OUTBOUND_API",
      "dateCreated": "2023-06-21",
      "dateUpdated": "2023-06-21"
    }
</ul>

## Spring Security

La API está protegida mediante Spring Security y el control de acceso basado en roles. Solo los usuarios con el rol EMPLEADO pueden acceder al endpoint <strong>/messenger-service/notify.</strong>

### Configuracion
<ul>
    <li>server.port: Puerto en el que se ejecuta el microservicio (default: 9280)</li>
    <li>access.token.secret: Clave secreta para la desencriptación del token de acceso</li>
</ul>