package com.emp.server.server;

import com.emp.server.service.MessageServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
@Log
public class MessageServer {

    private Server server;

    private int port;

    @Autowired
    public MessageServer(@Value("${message.server.port}") int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            this.server = ServerBuilder
                    .forPort(port)
                    .addService(new  MessageServiceImpl())
                    .build()
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Server started on port " + port);
    }

    public void stopServer() {
        if (server != null && !server.isShutdown()) {
            try {
                server.shutdown().awaitTermination(15, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                log.info("Server was shut down");
            }
        }
    }
}