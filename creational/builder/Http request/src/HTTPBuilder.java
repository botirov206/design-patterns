import enums.Methods;

public class HTTPBuilder {
    private Methods method;
    private String url;
    private String headers;
    private String body;
    private boolean secure;

    public HTTPBuilder method(Methods method) {
        this.method = method;
        return this;
    };

    public HTTPBuilder url(String url) {
        this.url = url;
        return this;
    };

    public HTTPBuilder headers(String headers) {
        this.headers = headers;
        return this;
    };

    public HTTPBuilder body(String body) {
        this.body = body;
        return this;
    };

    public HTTPBuilder secure(boolean secure) {
        this.secure = secure;
        return this;
    };

    public http build() {
        // if (method == Methods.GET && body != null) {
        // throw new IllegalArgumentException("GET requests must not have a body");
        // }

        return new http(method, url, headers, body, secure);
    };
}
