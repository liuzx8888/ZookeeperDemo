package com.liuzx.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClientDemo1 {
	public static void main(String[] args) {
		StringBuffer stringBuffer =null;
		try {
			Socket socket = new Socket("127.0.0.1", 28982);
/*			System.out.println(socket.isConnected());*/
			InputStream inputStream = socket.getInputStream();
			stringBuffer= new StringBuffer();
			int temp;
			while ((temp = inputStream.read()) != -1) {
				stringBuffer.append((char)temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stringBuffer);
	}

}
