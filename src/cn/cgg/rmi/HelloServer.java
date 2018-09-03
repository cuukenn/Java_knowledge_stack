package cn.cgg.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
	public static void main(String[] args) throws MalformedURLException, RemoteException, AlreadyBoundException {
		HelloImpl obj=new HelloImpl();
		LocateRegistry.createRegistry(12312); 
		Naming.bind("rmi://192.168.58.164:12312/Hello", obj);
		System.out.println("rmi server Æô¶¯³É¹¦");
	}
}
