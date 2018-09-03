package cn.cgg.server;

import java.util.Map;

public class HTTPRequestMessage {
	private String method;
	private String url;
	private String protal;
	private Map map;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProtal() {
		return protal;
	}
	public void setProtal(String protal) {
		this.protal = protal;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	
}
