package http;

import http.mock.MockHttpSender;
import http.real.RealHttpSender;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpRequest request = HttpRequest.builder()
                .method(HttpMethod.GET)
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .headers("Accept: application/json")
                .secure(true)
                .build();

        HttpSender mockSender = new MockHttpSender();
        HttpSender realSender = new RealHttpSender();

        System.out.println(mockSender.send(request));
        System.out.println(realSender.send(request));
    }
}
