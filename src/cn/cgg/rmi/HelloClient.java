package cn.cgg.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Hello hello=(Hello)Naming.lookup("rmi://192.168.58.164:12312/Hello");
		System.out.println(hello.sayHello("cgg"));
	}
}
