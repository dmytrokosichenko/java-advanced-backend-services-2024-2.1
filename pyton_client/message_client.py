from __future__ import print_function

import logging

import grpc
import message_pb2
import message_pb2_grpc


def run():
    print("Send 10 messages to gRPC server localhost:50052 ...")
    with grpc.insecure_channel("localhost:50052") as channel:
        stub = message_pb2_grpc.PingServiceStub(channel)
        for i in range(10):
            response = stub.sendPing(message_pb2.PingMessage(id=i, message="ping"))
            print("Server response '" + response.message + "' for message with ID: ", response.pingId);
            print("Response message ID " , response.id);


if __name__ == "__main__":
    logging.basicConfig()
    run()
