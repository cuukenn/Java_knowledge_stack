package cn.cgg.jms;

import com.sun.jdmk.comm.*;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Pattern;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class HelloAgent {
	public static void main(String[] args) throws Exception {
		MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();

		String domainName = "MyMBean";
		ObjectName helloName = new ObjectName(domainName + ":name=HelloWorld");
		beanServer.registerMBean(new Hello(), helloName);

		ObjectName adapterName = new ObjectName(domainName+":name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        adapter.start();
        beanServer.registerMBean(adapter,adapterName);
        int rmiPort = 1099;
        Registry registry = LocateRegistry.createRegistry(rmiPort);

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, beanServer);
        jmxConnector.start();
        Pattern p = Pattern.compile("^\\.|^\\@");
	}
}
