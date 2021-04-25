import java.io.IOException;

import com.naveen.grpcDemo.service.UserService;

import io.grpc.ServerBuilder;
import io.grpc.Server;
/*
 * To create a server we can use the ServerBuilder provided by gRPC. We will have to use the builder pattern
 * and set the port and bind the services.
 */
public class GRPCServer {
public static void main(String[] args) throws IOException, InterruptedException {
	Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
	server.start();
	System.out.println("Server started");
	server.awaitTermination();
}
}
