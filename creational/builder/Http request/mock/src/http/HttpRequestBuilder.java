package http;

public class HttpRequestBuilder {
    private HttpMethod method;
    private String url;
    private String headers;
    private String body;
    private boolean secure;

    public HttpRequestBuilder method(HttpMethod method) {
        this.method = method;
        return this;
    }

    public HttpRequestBuilder url(String url) {
        this.url = url;
        return this;
    }

    public HttpRequestBuilder headers(String headers) {
        this.headers = headers;
        return this;
    }

    public HttpRequestBuilder body(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder secure(boolean secure) {
        this.secure = secure;
        return this;
    }

    public HttpRequest build() {
        if (method == null) {
            throw new IllegalStateException("Method is required");
        }
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("URL is required");
        }
        if ((method == HttpMethod.GET || method == HttpMethod.DELETE) && body != null) {
            throw new IllegalArgumentException(method + " requests must not have a body");
        }
        if (secure && !url.startsWith("https://")) {
            throw new IllegalArgumentException("Secure requests must use an https URL");
        }
        return new HttpRequest(method, url, headers, body, secure);
    }
}
