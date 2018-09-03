package cn.cgg.server;

import java.util.Map;

public class HTTPResponseMessage {
	private String protal;
	private int code;
	private String codeDs;
	private Map map;
	private String responseBody;

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public String getProtal() {
		return protal;
	}

	public void setProtal(String protal) {
		this.protal = protal;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCodeDs() {
		return codeDs;
	}

	public void setCodeDs(String codeDs) {
		this.codeDs = codeDs;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}
