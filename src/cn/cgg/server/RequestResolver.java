package cn.cgg.server;

import java.util.HashMap;
import java.util.Map;

public class RequestResolver {
	private String[] request;
	public RequestResolver(String request) {
		this.request=request.split("&");
	}
	
	public HTTPRequestMessage resolveRequest() {
		HTTPRequestMessage requestMessage=new HTTPRequestMessage();
		int len=request.length;
		if(len>0 && isHttpRequest()) {
			String[] headers = request[0].split(" ");
			requestMessage.setMethod(headers[0]);
			requestMessage.setUrl(headers[1]);
			requestMessage.setProtal(headers[2]);
			
			Map<String,String> map=new HashMap<String,String>();
			for(int i=1;i<len;i++) {
				String[] tmp=request[i].split(":");
				map.put(tmp[0], tmp[1]);
			}
			requestMessage.setMap(map);
			System.out.println(requestMessage.getMap().size());
		}
		return requestMessage;
	}
	
	private boolean isHttpRequest() {
		if(request.length>0) {
			String[] split = request[0].split(" ");
			if(split.length==3 && split[2].contains("HTTP"))
				return true;
		}
		return false;
	}
}
