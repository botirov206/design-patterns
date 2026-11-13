# Builder Pattern — HTTP Request

Two small projects that assemble an HTTP request with a **fluent Builder**. The builder classes are copied into each folder, so you can open one project and read it on its own.

Both build the same secure GET. They differ only in what happens after `build()`.

| Folder | What `send` does |
|---|---|
| `mock` | Prints the request. No network call. |
| `real` | Sends the request with `HttpClient` and prints the response body. |

## What each project contains

- **Product** — `HttpRequest` stores the method, URL, headers, body, and whether the request is treated as secure. Its constructor is package-private, so requests are created through the builder.
- **Fluent builder** — `HttpRequestBuilder` returns `this` from every setter, so the parts can be set in any order. `build()` rejects a missing method or URL, a body on GET or DELETE, and `secure(true)` with a non-https URL.
- **Method enum** — `HttpMethod` lists `GET`, `POST`, `PUT`, and `DELETE`.
- **Sender** — `mock` has `MockHttpSender`. `real` has `RealHttpSender`.

## Requirements

Java 17 or newer.

## Run the mock

From `mock`:

```bash
javac -d out src/http/*.java
java -cp out http.Main
```

Prints the request text.

## Run the real call

From `real`:

```bash
javac -d out src/http/*.java
java -cp out http.Main
```

Prints the JSON body of [JSONPlaceholder](https://jsonplaceholder.typicode.com) post 1.
