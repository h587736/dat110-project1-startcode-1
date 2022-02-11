package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		// Done
		// connect using the underlying messaging layer connection
		
		connection = msgclient.connect();
		
	}
	
	public void disconnect() {
		
		// Done
		// disconnect/close the underlying messaging connection
		
		connection.close();
		
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval = null;
		
		// Done
		
		/* 
		Make a remote call on the RPC server by sending an RPC request message
		and receive an RPC reply message
		
		params is the marshalled parameters from the client-stub
				
		The rpcid, params, and return value must be encapsulated/decapsulated
		according to the RPC message format
			
		*/
				
		Message message = new Message(RPCUtils.encapsulate(rpcid, params));
		connection.send(message);
		returnval = RPCUtils.decapsulate(connection.receive().getData());
		
		return returnval;
		
	}

}
