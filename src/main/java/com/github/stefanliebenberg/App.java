package com.github.stefanliebenberg;

//import org.atmosphere.cpr.Broadcaster;
//import org.atmosphere.cpr.BroadcasterFactory;
//import org.atmosphere.cpr.DefaultBroadcasterFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

//        final BroadcasterFactory broadcasterFactory = new DefaultBroadcasterFactory();

//        final BCastService bCastService = new BCastService();

        final Echo echo = new Echo();

        // this url might not match the end-api. we will evolve the url as more
        // information comes in.
        get(new Route("/subscribe/:id") {

            @Override
            public Object handle(Request request, Response response) {
                String id = request.params("id");

//                Broadcaster broadcaster = broadcasterFactory.lookup(id, true);
//                BCastToken bCastToken = new BCastToken();
//                bCastService.addToken(bCastToken);

                return "Subscribed to channel: " + id;
            }
        });

        get(new Route("/unsubscribe/:id") {

            @Override
            public Object handle(Request request, Response response) {
                String id = request.params("id");
                return "Unsubscribed to channel: " + id;
            }
        });



        get(new Route("/publish/:id/:message") {
            public Object handle(Request request, Response response) {
                Message message = new Message(request.params(":message"));
                return "published message.";
            }
        });



        get(new Route("/info") {
            public Object handle(Request request, Response response) {
              return "Info about registered channels";
            }
        });


        get(new Route("/info/:id") {
            public Object handle(Request request, Response response) {
                String id = request.params(":id");
                return "Info about channel " + id;
            }
        });

    }
}
