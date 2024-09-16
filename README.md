
# CQRS Ebook

Proyecto de Ebook para estudiar CQRS

## Tecnologias

Java, Spring, Spring boot, Mysql, Kafka, Intellij


## Installation

- Clonar el proyecto
- Arrancar Apache Kafka levantando los dos servicios segun este [link](https://geekflare.com/es/download-and-install-apache-kafka/)
- Ejecutar cada proyecto con mvn en la carpeta raiz

 ``` shell
 mvn spring-boot:run
 ```

- Ejecutar el llamado a postman como se muestra en la seccion Usage/Examples 
## Authors

- [@dancourbano](https://www.github.com/dancourbano)


## Usage/Examples

Ejecutar Curl o Postman 

### Agregar Ebook

``` bat
curl --location --request POST 'localhost:9191/ebooks' \
--header 'Content-Type: application/json' \
--data-raw '{
    "type": "CreateEbook",
    "ebook": {
        "nombre": "La Odisea",
        "autor": "Homero",
        "isbn": "1231212e13123123AAA"
    }
}'
```

### Actualizar Ebook

``` bat
curl --location --request PUT 'localhost:9191/ebooks/2' \
--header 'Content-Type: application/json' \
--data-raw '{
   
    "type": "UpdateEbook",
    "ebook": {
        "nombre": "La Odisea",
        "autor": "Homero",
        "isbn": "1231212e13123123AAABBB"
    }
}'
```

### Obtener Ebook

``` bat
curl --location --request GET 'localhost:9292/ebooks' \
--data-raw ''
```


## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

