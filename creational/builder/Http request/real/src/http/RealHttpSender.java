package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class RealHttpSender {
    private final HttpClient client = HttpClient.newHttpClient();

    public String send(HttpRequest request) throws IOException, InterruptedException {
        var call = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(request.url()));

        addHeader(call, request.headers());
        addMethod(call, request);

        HttpResponse<String> response = client.send(call.build(), HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static void addHeader(java.net.http.HttpRequest.Builder call, String headers) {
        if (headers == null || headers.isBlank()) {
            return;
        }
        int colon = headers.indexOf(':');
        if (colon < 1) {
            throw new IllegalArgumentException("Header must look like \"Name: value\"");
        }
        String name = headers.substring(0, colon).trim();
        String value = headers.substring(colon + 1).trim();
        call.header(name, value);
    }

    private static void addMethod(java.net.http.HttpRequest.Builder call, HttpRequest request) {
        switch (request.method()) {
            case GET -> call.GET();
            case DELETE -> call.DELETE();
            case POST -> call.POST(bodyOf(request));
            case PUT -> call.PUT(bodyOf(request));
        }
    }

    private static java.net.http.HttpRequest.BodyPublisher bodyOf(HttpRequest request) {
        if (request.body() == null) {
            return BodyPublishers.noBody();
        }
        return BodyPublishers.ofString(request.body());
    }
}
