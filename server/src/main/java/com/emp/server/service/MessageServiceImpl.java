package com.emp.server.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.java.Log;
import main.proto.PingMessage;
import main.proto.PingServiceGrpc;
import main.proto.PongMessage;
import org.springframework.stereotype.Component;

import java.util.Random;

@Log
@Component
public class MessageServiceImpl extends PingServiceGrpc.PingServiceImplBase {

    @Override
    public void sendPing(PingMessage request, StreamObserver<PongMessage> responseObserver) {
        if ("ping".equalsIgnoreCase(request.getMessage())) {
            log.info("Received ping with ID " + request.getId());
            responseObserver.onNext(PongMessage.newBuilder()
                    .setId(new Random().nextInt())
                    .setMessage("pong")
                    .setPingId(request.getId())
                    .build());
        }
        responseObserver.onCompleted();
    }
}