import java.io.*;
import java.net.*;

import com.sun.net.httpserver.*;

public class Http {

  public static void main(String[] args) throws IOException {
    // Heroku gives us a $PORT env variable that tells us where to bind our
    // socket for listening to http traffic.
    Integer port = Integer.parseInt(System.getenv("PORT"));
    InetSocketAddress socket = new InetSocketAddress(port);
    HttpServer server = HttpServer.create(socket, 0);

    server.createContext("/", new RootHandler());
    server.setExecutor(null);
    server.start();
  }

  static class RootHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange req) throws IOException {
      String message = "<!DOCTYPE html>\n"
        + "<html><head><title>Hello world</title></head>"
        + "<body style='text-align:center'><h1>Hello CS1813!</h1>"
        + "<a href='https://en.wikipedia.org/wiki/Mountain_tapir'><img "
        + "src='https://upload.wikimedia.org/wikipedia/commons/thumb/"
        + "2/21/Tapirus_pinchaque_portrait.jpg/"
        + "800px-Tapirus_pinchaque_portrait.jpg' alt='tapir'/></a>"
        + "<p>Image CC BY 2.0 <a href='https://www.flickr.com/photos/dsifry/'"
        + ">David Sifry</a></p></body></html>";

      Headers headers = req.getResponseHeaders();
      headers.add("Content-Type", "text/html; charset=UTF-8");

      req.sendResponseHeaders(200, message.length());

      OutputStream res = req.getResponseBody();
      res.write(message.getBytes());
      res.close();
    }
  }
}
