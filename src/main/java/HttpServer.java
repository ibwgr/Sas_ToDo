import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;
import spark.Service;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class HttpServer {

    private final String httpPort;
    private Service server;

    public HttpServer(String httpPort) {
        this.httpPort = httpPort;
    }

    public void start() {
        server = Service.ignite();
        server.port(Integer.parseInt(httpPort));
//        server.before((Request request, Response response) -> {
//            if(request.headers("Accept").contains("application/json")){
//                server.halt(HttpStatus.NOT_ACCEPTABLE_406, "Wrong, no Json");
//            }

        new ItemController().createRoutes(server);


        server.awaitInitialization();
    }

    public void stop() {
        server.stop();
        server.awaitStop();
    }
}