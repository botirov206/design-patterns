import enums.Methods;

public class Main {
    public static void main(String[] args) throws Exception {

        // http googleRequest = http.builder()
        // .method(Methods.GET)
        // .url("https://www.google.com")
        // .headers("Content-Type: application/json")
        // .body("{\n\t'name': 'John',\n\t'age': 30\n\t}")
        // .secure(true)
        // .build();

        http request = http.builder()
                .method(Methods.GET)
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        // http request2 = http.builder()
        // .method(Methods.GET)
        // .url("https://jsonplaceholder.typicode.com/posts/2")
        // .build();

        System.out.println(request.send());
        // System.out.println(request2.send());

    }
}
