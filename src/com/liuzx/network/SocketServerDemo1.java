package com.liuzx.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		String str = "Hello Socket";
		OutputStream outputStream = null;
		PrintStream printStream;

		try {
			serverSocket = new ServerSocket(28982);
			System.out.println("服务已经开启......");
			socket = serverSocket.accept();
			outputStream = socket.getOutputStream();

			printStream = new PrintStream(outputStream);
			printStream.println(str);

			serverSocket.close();
			socket.close();
			outputStream.close();
			printStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
