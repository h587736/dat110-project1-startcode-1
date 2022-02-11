package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		if(data.length <= 127 && data != null) {
			this.data = data;
		}
		else {
			this.data = null;
		}
	}

	public byte[] getData() {
		return this.data; 
	}

}