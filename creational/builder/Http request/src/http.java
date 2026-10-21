import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import enums.Methods;

public class http {
    private final Methods method;
    private final String url;
    private final String headers;
    private final String body;
    private final boolean secure;

    http(Methods method, String url, String headers, String body, boolean secure) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.secure = secure;
    }

    public static HTTPBuilder builder() {
        return new HTTPBuilder();
    }

    @Override
    public String toString() {
        return """
                %s Request:
                {
                  "method": "%s"
                  "url": "%s"
                  "headers": "%s"
                  "body": %s
                  "secure": "%s"
                }
                """.formatted(secure ? "HTTPS" : "HTTP", method, url, headers, body, secure ? "true" : "false");
    }

    public String send() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // this.url from the builder
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}