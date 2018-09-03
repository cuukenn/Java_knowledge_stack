package cn.cgg.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler implements Runnable {
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("--request handler-");
			StringBuilder stringBuffer = new StringBuilder();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String string = bufferedReader.readLine();
			while (string != null && string.equals("") == false) {
				stringBuffer.append(string);
				stringBuffer.append("&");
				string = bufferedReader.readLine();
			}
			System.out.println("------读取完成------");
			System.out.println(stringBuffer.toString());

			RequestResolver requestResolver = new RequestResolver(stringBuffer.toString());
			HTTPRequestMessage httpRequestMessage = requestResolver.resolveRequest();

			String response = DiskFile.findSource(httpRequestMessage.getUrl());
			HTTPResponseMessage httpResponseMessage = new HTTPResponseMessage();
			httpResponseMessage.setCode(200);
			httpResponseMessage.setCodeDs("ok");
			httpResponseMessage.setProtal(httpRequestMessage.getProtal());
			httpResponseMessage.setResponseBody(response);
			httpResponseMessage.setMap(httpRequestMessage.getMap());

			// System.out.println(httpResponseMessage.getResponseBody());
			response = ResponseParser.parse2ResponseMessage(httpResponseMessage);

			BufferedWriter writer = new BufferedWriter(new PrintWriter(socket.getOutputStream()));
			writer.write(response);
			writer.flush();
			System.out.println("------响应浏览器请求------");
			bufferedReader.close();
			writer.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
