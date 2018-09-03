package cn.cgg.server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DiskFile {
	public static String findSource(String url) {
		String rs="";
		String classPath=DiskFile.class.getResource("").getPath();
		if(url.equals("/"))url="/index.html";
		String location=classPath+url.subSequence(1, url.length());
		System.out.println("找到所请求资源路径为："+location);
		
		BufferedInputStream inputStream=null;
		try {
			byte[] buff=new byte[1024];
			inputStream=new BufferedInputStream(new FileInputStream(new File(location)));
			inputStream.read(buff);
			rs=new String(buff);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				inputStream.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		return rs;
	}
	public static void main(String[] args) {
		String s=DiskFile.findSource("/");
		System.out.println(s);
	}
}	
