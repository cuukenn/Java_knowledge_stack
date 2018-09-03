package cn.cgg.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5166881518511080548L;

	protected HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String name)  throws RemoteException {
		return "hello "+name;
	}

}
