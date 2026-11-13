package http;

public class Main {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.builder()
                .method(HttpMethod.GET)
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .headers("Accept: application/json")
                .secure(true)
                .build();

        System.out.println(new MockHttpSender().send(request));
    }
}
