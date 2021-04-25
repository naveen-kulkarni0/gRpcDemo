

import com.naveen.grpcclient.User.APIResponse;
import com.naveen.grpcclient.User.LoginRequest;
import com.naveen.grpcclient.userGrpc;
import com.naveen.grpcclient.userGrpc.userBlockingStub;
import com.naveen.grpcclient.userGrpc.userStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
	public static void main(String[] args) {	
	
		//Use of a plain-text connection to the server. By default a secure connection mechanism such as TLS will be used.
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 9090).usePlaintext().build();
		
		/*For the consumer to call the gRPCs, one will have to generate the stubs based on the proto file.
		 *The proto file is shared to the consumers and based on the technology the consumer generates stubs
		 *for the respective language they are using.
		 *We have 3 options for creating stubs
		 *newStub() - creates an async style
		 *newBlockingStub() -  creates a sync stub
		 *newFutureStub() - creates a future-style stub
		 */
		
		userBlockingStub blockingStub = userGrpc.newBlockingStub(channel);
		LoginRequest loginrequest = LoginRequest.newBuilder().build();
		APIResponse response = blockingStub.login(loginrequest);
		System.out.println(response.getResponseCode());
		System.out.println(response.getResponseMessage());
		
	}
}
