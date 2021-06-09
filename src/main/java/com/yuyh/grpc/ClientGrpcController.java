package com.yuyh.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.hello.GreeterGrpc;
import io.grpc.examples.hello.HelloReply;
import io.grpc.examples.hello.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientGrpcController {
    @GetMapping("/grpc/{name}")
    public String hello(@PathVariable String name) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("grpcjava", 6565)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();

        HelloReply reply = stub.sayHello(request);

        System.out.println("Reply: " + reply);

        return reply.getMessage();
    }
}
