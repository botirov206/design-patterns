# Builder Pattern — HTTP Request

Advanced Programming example that assembles an HTTP request with a **fluent Builder**. Callers chain method, URL, headers, body, and a secure flag, then `build()` returns an immutable `http` object.

## What it demonstrates

- **Product** — `http` stores the method, URL, headers, body, and whether the request is treated as secure. Its constructor is package-private, so requests are created through the builder.
- **Fluent builder** — `HTTPBuilder` returns `this` from every setter, so the parts can be set in any order. `http.builder()` is the entry point.
- **Method enum** — `Methods` lists `GET`, `POST`, `PUT`, and `DELETE`.

`Main` builds one GET request for the [JSONPlaceholder](https://jsonplaceholder.typicode.com) posts collection and prints the response body.

`send()` currently issues a GET to the URL stored on the request. The method, headers, body, and secure flag are kept on the object and shown by `toString()`; they are not applied when the request is sent.

## Project layout

```
src/
  Main.java            entry point
  http.java            product
  HTTPBuilder.java     fluent builder
  enums/
    Methods.java       GET, POST, PUT, DELETE
```

## Requirements

Java 17 or newer (`toString` uses a text block and `String.formatted`; `send` uses `java.net.http.HttpClient`).

## Run

From this directory:

```bash
javac -d out src/enums/Methods.java src/HTTPBuilder.java src/http.java src/Main.java
java -cp out Main
```

`Main` fetches the posts collection and prints the JSON body.

## Fluent example

```java
http request = http.builder()
        .method(Methods.GET)
        .url("https://jsonplaceholder.typicode.com/posts/1")
        .headers("Accept: application/json")
        .secure(true)
        .build();

System.out.println(request);
System.out.println(request.send());
```
