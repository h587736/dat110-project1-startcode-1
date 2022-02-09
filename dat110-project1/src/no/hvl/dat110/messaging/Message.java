package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		// Done
		
		this.data = data;
			
	}

	public byte[] getData() {
		return this.data; 
	}

}
