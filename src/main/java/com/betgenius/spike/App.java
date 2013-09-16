package com.betgenius.spike;

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


        get(new Route("/subscribe") {

            @Override
            public Object handle(Request request, Response response) {
                String id = request.queryParams("id");

//                Broadcaster broadcaster = broadcasterFactory.lookup(id, true);
//                BCastToken bCastToken = new BCastToken();
//                bCastService.addToken(bCastToken);

                return "Id is " + id;
            }
        });

    }
}
