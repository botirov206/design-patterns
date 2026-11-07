package http.mock;

import http.HttpRequest;
import http.HttpSender;

public class MockHttpSender implements HttpSender {
    @Override
    public String send(HttpRequest request) {
        return request.toString();
    }
}
