package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {

		byte[] segment = new byte[128];
		byte[] data;
		data = message.getData();
		// Done

		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer

		segment[0] = (byte) data.length;
		System.arraycopy(data, 0, segment, 1, data.length);

		return segment;

	}

	public static Message decapsulate(byte[] segment) {

		Message message;
		byte[] data = new byte[0];

		// Done
		// decapsulate segment and put received data into a message

		int size = segment[0];
		data = new byte[size];
		System.arraycopy(segment, 1, data, 0, data.length);
		message = new Message(data);

		return message;

	}

}
