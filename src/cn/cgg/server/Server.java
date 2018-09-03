package cn.cgg.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private boolean isRunning;
	public void startServer() {
		try {
			serverSocket=new ServerSocket(3000);
			System.out.println("开始监听");
			isRunning=true;
			while(isRunning) {
				Socket socket = serverSocket.accept();
				System.out.println("--接受请求--");
				ThreadPool.getIntance().addThread(new RequestHandler(socket));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
