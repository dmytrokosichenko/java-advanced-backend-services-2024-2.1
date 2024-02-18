package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.java.Log;
import main.proto.PingMessage;
import main.proto.PingServiceGrpc;
import main.proto.PongMessage;

@Log
public class Main {

    private final static String SERVER = "localhost";
    private final static String PORT = "50052";

    public static void main(String[] args) {
        log.info("Client sends ping to server");
        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget(SERVER + ":" + PORT)
                .usePlaintext().build();

        PingServiceGrpc.PingServiceBlockingStub blockingStub = PingServiceGrpc.newBlockingStub(managedChannel);

        for (int i = 0; i < 10; i++) {
            PingMessage pingMessage = PingMessage.newBuilder()
                    .setMessage("Ping")
                    .setId(i)
                    .build();

            PongMessage response = blockingStub.sendPing(pingMessage);
            log.info("Client sends ping to server ID: " + i);

            log.info("Message ID: " + pingMessage.getId());
            log.info("Server answer '" + response.getMessage() + "' for message with ID: " + response.getPingId());
            log.info("Response message ID " + response.getId());
        }
    }

}