# 🎬 Spring REST API - Prueba Técnica

Aplicación RESTful desarrollada en Java con Spring Boot 3.2. Incluye CRUD completo para la entidad `Person`, con la posibilidad de asociar películas favoritas (`Movie`). Los datos se almacenan en memoria, cumpliendo los requisitos de la prueba técnica.

---

## 🛠️ Tecnologías utilizadas

- Java 21 (JDK 21.0.7)
- Spring Boot 3.2.x
- Maven
- Postman (para pruebas de endpoints)

---

## 📁 Estructura del proyecto
```
spring-rest-api-test/
├── src/
│ └── main/
│ └── java/
│ └── com.example.springrestapitest
│ ├── model/
│ │ ├── Person.java
│ │ └── Movie.java
│ ├── service/
│ │ └── PersonService.java
│ ├── controller/
│ │ └── PersonController.java
│ └── SpringRestApiTestApplication.java
└── pom.xml
```

---

## 🚀 Cómo ejecutar el proyecto

1. Cloná o descargá el proyecto.
2. Abrilo con IntelliJ IDEA.
3. Asegurate de tener configurado el **JDK 21**.
4. Ejecutá la clase principal:
---
SpringRestApiTestApplication.java

El servidor arrancará en:  
http://localhost:8080


---

## 📬 Endpoints principales

### Personas
| Método | Endpoint                          | Descripción                          |
|--------|-----------------------------------|--------------------------------------|
| GET    | `/api/persons`                   | Listar todas las personas            |
| GET    | `/api/persons/{id}`              | Buscar persona por ID                |
| GET    | `/api/persons/search?name=...`   | Buscar por nombre                    |
| POST   | `/api/persons`                   | Crear persona                        |
| PATCH  | `/api/persons/{id}`              | Editar persona parcialmente          |
| DELETE | `/api/persons/{id}`              | Eliminar persona                     |

### Películas favoritas
| Método | Endpoint                                 | Descripción                                |
|--------|------------------------------------------|--------------------------------------------|
| GET    | `/api/persons/{id}/movies`              | Ver películas favoritas                    |
| POST   | `/api/persons/{id}/movies`              | Agregar película (máx. 5 por persona)      |
| DELETE | `/api/persons/{id}/movies?title=...`    | Eliminar película por título               |

---

## 🧪 Pruebas

Los endpoints fueron testeados usando **Postman Desktop**. Se puede importar una colección personalizada si se solicita.

---

## 📌 Notas

- No se utiliza base de datos, los datos son temporales (almacenados en memoria).
- Las personas se ordenan automáticamente por `lastName` y `firstName`.
- Las películas se limitan a un máximo de 5 por persona.

---

## 👩‍💻 Desarrollado por

**Marianela Purretta**  
_Prueba Tecnica //UTEAM//_  
GitHub: [(https://github.com/MarianelaPurretta/spring-rest-api-test)]


