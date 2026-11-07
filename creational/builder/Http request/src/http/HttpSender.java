package http;

import java.io.IOException;

public interface HttpSender {
    String send(HttpRequest request) throws IOException, InterruptedException;
}
