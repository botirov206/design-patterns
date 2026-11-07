package http;

public final class HttpRequest {
    private final HttpMethod method;
    private final String url;
    private final String headers;
    private final String body;
    private final boolean secure;

    HttpRequest(HttpMethod method, String url, String headers, String body, boolean secure) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.secure = secure;
    }

    public static HttpRequestBuilder builder() {
        return new HttpRequestBuilder();
    }

    public HttpMethod method() {
        return method;
    }

    public String url() {
        return url;
    }

    public String headers() {
        return headers;
    }

    public String body() {
        return body;
    }

    public boolean secure() {
        return secure;
    }

    @Override
    public String toString() {
        return """
                %s Request:
                {
                  "method": "%s",
                  "url": "%s",
                  "headers": "%s",
                  "body": %s,
                  "secure": %s
                }
                """.formatted(
                secure ? "HTTPS" : "HTTP",
                method,
                url,
                headers,
                body == null ? "null" : "\"" + body + "\"",
                secure);
    }
}
