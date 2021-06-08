package com.yuyh.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.examples.hello.GreeterGrpc;
import io.grpc.examples.hello.HelloReply;
import io.grpc.examples.hello.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcApplication.class, args);
	}

	@GRpcService
	public static class GreeterService extends GreeterGrpc.GreeterImplBase {
		@Override
		public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
			HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
			responseObserver.onNext(reply);
			responseObserver.onCompleted();

		}
	}

}
