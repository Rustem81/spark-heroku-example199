import static spark.Spark.*;

import spark.Request;
import spark.Response;
import spark.Route;

public class Main {
    public static void main(String[] args) {
    	port(getHerokuAssignedPort());
    	
    	get("/hello", new Route() {
			public Object handle(Request req, Response res) throws Exception {
				return "<h1>Привет!</h2>";
			}
		});
    }
    
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}