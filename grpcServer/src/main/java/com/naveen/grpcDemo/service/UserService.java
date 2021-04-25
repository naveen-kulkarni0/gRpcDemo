package com.naveen.grpcDemo.service;

import com.naveen.grpcDemo.User.APIResponse;
import com.naveen.grpcDemo.User.EmptyRequest;
import com.naveen.grpcDemo.User.LoginRequest;
import com.naveen.grpcDemo.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

/*gRPC creates the API using the proto object, we just need to write the business logic using service by extending the <serviceName>ImplBase which would be
created in the <serviceName>gRPC file */
public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside login() ");
		String username = request.getUsername();
		String password = request.getPassword();
		
		//Creating the response builder to set the response
		APIResponse.Builder apiResponse = APIResponse.newBuilder();
		if(!username.isEmpty() && !password.isEmpty()) {
			apiResponse.setResponseCode(0);
			apiResponse.setResponseMessage("Login Successful");
		}
		else {
			apiResponse.setResponseCode(16);
			apiResponse.setResponseMessage("Login Failed");
		}
		//ResponseObserver is used to send back the response. The onNext will set the response and onCompleted will close the connection
		responseObserver.onNext(apiResponse.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(EmptyRequest request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}
