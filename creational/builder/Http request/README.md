# Builder Pattern — HTTP Request

Advanced Programming example that assembles an HTTP request with a **fluent Builder**. Callers chain method, URL, headers, body, and a secure flag, then `build()` returns an immutable `HttpRequest`. Sending is separate: a mock sender prints the request, and a real sender performs the HTTP call.

## What it demonstrates

- **Product** — `HttpRequest` stores the method, URL, headers, body, and whether the request is treated as secure. Its constructor is package-private, so requests are created through the builder.
- **Fluent builder** — `HttpRequestBuilder` returns `this` from every setter, so the parts can be set in any order. `HttpRequest.builder()` is the entry point. `build()` rejects a missing method or URL, a body on GET or DELETE, and `secure(true)` with a non-https URL.
- **Method enum** — `HttpMethod` lists `GET`, `POST`, `PUT`, and `DELETE`.
- **Sender** — `HttpSender` is the shared contract. `MockHttpSender` returns the request text and does not touch the network. `RealHttpSender` uses `java.net.http.HttpClient` and applies the method, header, and body.

`Main` builds one secure GET for a [JSONPlaceholder](https://jsonplaceholder.typicode.com) post, prints the mock request, then prints the real response body.

## Project layout

```
src/http/
  Main.java                     entry point
  HttpRequest.java              product
  HttpRequestBuilder.java       fluent builder
  HttpMethod.java               GET, POST, PUT, DELETE
  HttpSender.java               send contract
  mock/
    MockHttpSender.java         prints the request
  real/
    RealHttpSender.java         performs the HTTP call
```

## Requirements

Java 17 or newer (`toString` uses a text block and `String.formatted`; the real sender uses `java.net.http.HttpClient`).

## Run

From this directory:

```bash
javac -d out src/http/*.java src/http/mock/*.java src/http/real/*.java
java -cp out http.Main
```

`Main` prints the mock request, then the JSON body of post 1.

## Fluent example

```java
HttpRequest request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .url("https://jsonplaceholder.typicode.com/posts/1")
        .headers("Accept: application/json")
        .secure(true)
        .build();

System.out.println(new MockHttpSender().send(request));
System.out.println(new RealHttpSender().send(request));
```
