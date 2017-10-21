package volume1.chapter11.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;

public class SocketHandlerServer {
	private static final int PORT_NUM = 8099;

	public static void main(String args[]) {
		ServerSocketFactory serverSocketFactory = ServerSocketFactory
				.getDefault();
		ServerSocket serverSocket = null;
		try {
			serverSocket = serverSocketFactory.createServerSocket(PORT_NUM);
		} catch (IOException ignored) {
			System.err.println("无法创建服务");
			System.exit(-1);
		}
		System.out.printf("LogServer 运行端口: %s%n", PORT_NUM);
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println("---"+line);
				}
			} catch (IOException exception) {
				// 处理下在个请求.
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException ignored) {
					}
				}
			}
		}
	}
}


