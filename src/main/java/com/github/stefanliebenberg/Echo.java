package com.github.stefanliebenberg;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.cpr.AtmosphereResponse;
import org.atmosphere.handler.OnMessage;

@ManagedService(path = "/echo")
public class Echo extends OnMessage<String> {
    @Override
    public void onMessage(AtmosphereResponse res, String m) {
        res.write("Echo: " + m);
    }
}