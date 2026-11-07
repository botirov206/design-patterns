package http.real;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import http.HttpRequest;
import http.HttpSender;

public class RealHttpSender implements HttpSender {
    private final HttpClient client;

    public RealHttpSender() {
        this(HttpClient.newHttpClient());
    }

    public RealHttpSender(HttpClient client) {
        this.client = client;
    }

    @Override
    public String send(HttpRequest request) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder builder = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(request.url()));

        applyHeader(builder, request.headers());
        applyMethod(builder, request);

        HttpResponse<String> response = client.send(builder.build(), HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static void applyHeader(java.net.http.HttpRequest.Builder builder, String headers) {
        if (headers == null || headers.isBlank()) {
            return;
        }
        int colon = headers.indexOf(':');
        if (colon < 1) {
            throw new IllegalArgumentException("Header must look like \"Name: value\"");
        }
        builder.header(headers.substring(0, colon).trim(), headers.substring(colon + 1).trim());
    }

    private static void applyMethod(java.net.http.HttpRequest.Builder builder, HttpRequest request) {
        var publisher = request.body() == null
                ? BodyPublishers.noBody()
                : BodyPublishers.ofString(request.body());

        switch (request.method()) {
            case GET -> builder.GET();
            case POST -> builder.POST(publisher);
            case PUT -> builder.PUT(publisher);
            case DELETE -> builder.DELETE();
        }
    }
}
