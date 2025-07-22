# Modules

This repository contains multiple Spring Boot services that together form a simple microservice setup. Each service lives in its own directory and can be built independently.

## Services

- **apigateway** – central gateway for routing client requests.
- **authmicroservice** – handles user authentication.
- **kommentarservice** – comment management service.
- **serviceregistry** – Eureka based service registry.
- **zelkulonmicroservice** – blog and blog list service.

## Building the project

The project uses Maven as a build system and is configured as a multi-module build. To build all services at once run:

```sh
./mvnw clean package
```

# Blog and BlogList Service Documentation

[API](#api)  
[Payload](#payload)  
[Examples](#examples)  

Eingabeformat JSON Ausgabeformat  
---

# API

## Blog Endpoints

| Endpoint      | HTTP Method | Status Codes                                       |
| ------------- | ----------- | -------------------------------------------------- |
| `/blogs/`     | GET         | 200 (OK), 404 (NoBlogFoundException)               |
| `/blogs/{id}` | GET         | 200 (OK), 404 (ResourceNotFoundException)          |
| `/blogs/`     | POST        | 201 (Created), 400 (BadRequest)                    |
| `/blogs/{id}` | PUT         | 204 (No Content), 400 (BadRequest), 404 (NotFound) |
| `/blogs/{id}` | DELETE      | 204 (No Content), 404 (NotFound)                   |

## BlogList Endpoints

| Endpoint          | HTTP Method | Status Codes                                       |
| ----------------- | ----------- | -------------------------------------------------- |
| `/blogLists/`     | GET         | 200 (OK), 404 (NoBlogListFoundException)           |
| `/blogLists/{id}` | GET         | 200 (OK), 404 (ResourceNotFoundException)          |
| `/blogLists/`     | POST        | 201 (Created), 400 (BadRequest)                    |
| `/blogLists/{id}` | PUT         | 204 (No Content), 400 (BadRequest), 404 (NotFound) |
| `/blogLists/{id}` | DELETE      | 204 (No Content), 404 (NotFound)                   |

---

## Blogs

The following table lists the endpoints for the Blog API:  
**Basepath**: `blogMS/rest/blogs`

| HTTP Method | Path  | Param | @PathParam | @QueryParam | Beschreibung |
| :---------: | :---: | :---: | :--------: | :---------: | :----------- |
|    POST     |   /   | Blog  |     -      |      -      | Blog posten  |
|     GET     |   /   |   -   |    {id}    |      -      | Best. Blog   |
|     PUT     |   /   | Blog  |    {id}    |      -      | Update Blog  |
|   DELETE    |   /   |   -   |    {id}    |      -      | Lösche Blog  |

## BlogLists

The following table lists the endpoints for the BlogList API:  
**Basepath**: `blogMS/rest/blogLists`

| HTTP Method | Path  |  Param   | @PathParam | @QueryParam | Description             |
| :---------: | :---: | :------: | :--------: | :---------: | :---------------------- |
|     GET     |   /   |    -     |  {listId}  |      -      | Blogliste nach ID       |
|    POST     |   /   | BlogList |     -      |      -      | Blogliste erstellen     |
|     PUT     |   /   | BlogList |     -      |      -      | Blogliste aktualisieren |
|   DELETE    |   /   |    -     |  {listId}  |      -      | Lösche Blogliste        |

---

# Payload

## Blog Param

|   Field   |   Datatype    | Required |       Values       | Description          |
| :-------: | :-----------: | :------- | :----------------: | :------------------- |
|    id     |    Integer    | true     |         1          | ID eines Blogs       |
|   title   |    String     | true     |    "Blog Title"    | Titel des Blogs      |
|  artist   |    String     | true     |   "Author Name"    | Name des Autors      |
| location  |    String     | true     |      "Berlin"      | Ort des Blogs        |
| timestamp | LocalDateTime | true     | "2024-12-13T10:00" | Erstellungszeitpunkt |

## Blog JSON

```json
{
  "id": 1,
  "title": "Exploring Java",
  "artist": "John Doe",
  "location": "Berlin",
  "timestamp": "2024-12-13T10:00"
}
```

## BlogList Param

|   Field   | Datatype  | Required |        Values        | Description              |
| :-------: | :-------: | :------- | :------------------: | :----------------------- |
| isPrivate |  Boolean  | true     |      true/false      | Private/Public BlogListe |
|  ownerId  |  String   | true     |     "OwnerID123"     | ID des Besitzers         |
|   name    |  String   | true     |  "Meine Blogliste"   | Name der BlogListe       |
| blogList  | Set<Blog> | true     | Eine Menge von Blogs | Blogs in der Liste       |

## BlogList JSON

```json
{
  "id": 1,
  "isPrivate": false,
  "ownerId": "owner123",
  "name": "My Blog List",
  "blogList": [
    {
      "id": 1,
      "title": "Exploring Java",
      "artist": "John Doe",
      "location": "Berlin",
      "timestamp": "2024-12-13T10:00"
    },
    {
      "id": 2,
      "title": "Spring Boot Essentials",
      "artist": "Jane Smith",
      "location": "Munich",
      "timestamp": "2024-11-01T14:00"
    }
  ]
}
```

---

# Examples

## GET Blog by ID
### Status 200 Blog by ID

#### URL: `/blogs/1`

#### Request:

```sh
curl -X GET \
-H "Content-Type: application/json" \
-v "http://localhost:8080/rest/blogs/1"
```

#### Status 200 Response:

```json
{
  "id": 1,
  "title": "Exploring Java",
  "artist": "John Doe",
  "location": "Berlin",
  "timestamp": "2024-12-13T10:00"
}
```

---

## POST BlogList
### Status 201 BlogList Created

#### URL: `/blogLists`

#### Request:

```sh
curl -X POST \
-H "Content-Type: application/json" \
-d '{
  "isPrivate": false,
  "ownerId": "owner123",
  "name": "Tech Blogs",
  "blogList": [
    {
      "id": 1
    },
    {
      "id": 2
    }
  ]
}' \
-v "http://localhost:8080/rest/blogLists"
```

#### Status 201 Response:

```json
{
  "id": 1,
  "isPrivate": false,
  "ownerId": "owner123",
  "name": "Tech Blogs",
  "blogList": [
    {
      "id": 1,
      "title": "Exploring Java",
      "artist": "John Doe",
      "location": "Berlin",
      "timestamp": "2024-12-13T10:00"
    },
    {
      "id": 2,
      "title": "Spring Boot Essentials",
      "artist": "Jane Smith",
      "location": "Munich",
      "timestamp": "2024-11-01T14:00"
    }
  ]
}
```
