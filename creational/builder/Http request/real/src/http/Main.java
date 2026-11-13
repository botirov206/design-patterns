package http;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.builder()
                .method(HttpMethod.GET)
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .headers("Accept: application/json")
                .secure(true)
                .build();

        System.out.println(new RealHttpSender().send(request));
    }
}
