package cn.cgg.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ResponseParser {
	public static String parse2ResponseMessage(HTTPResponseMessage httpResponseMessage) {
		StringBuffer sb = new StringBuffer();

		// 响应头
		sb.append(httpResponseMessage.getProtal() + " ");
		sb.append(httpResponseMessage.getCode() + " ");
		sb.append(httpResponseMessage.getCodeDs() + "\r\n");

		// 相依头字段
		Map map = httpResponseMessage.getMap();
		if (map.size() > 0) {
			Iterator<String> iterator = map.keySet().iterator();
			System.out.println(map.size());
			while (iterator.hasNext()) {
				String key = iterator.next();
				sb.append(key + ": " + map.get(key) + "\r\n");
			}
		}

		sb.append("\r\n");
		// 响应正文
		sb.append(httpResponseMessage.getResponseBody());
		return sb.toString();
	}
}
