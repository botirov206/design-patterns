package http;

public class MockHttpSender {
    public String send(HttpRequest request) {
        return request.toString();
    }
}
