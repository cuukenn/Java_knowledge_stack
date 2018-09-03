package cn.cgg.propertise;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiseTest {
	public static void main(String[] args) throws Exception {
		String path = PropertiseTest.class.getResource("").getPath() + "jdbc.properties";
		InputStream inputStream = new BufferedInputStream(new FileInputStream(path));

		Properties properties = new Properties();
		properties.load(inputStream);
		Set<Object> keySet = properties.keySet();
		for (Object s : keySet) {
			String key = (String) s;
			String value = properties.getProperty(key);
			System.out.println(String.format("��Ϊ��%s,ֵΪ��%s", key, value));
		}
		inputStream.close();
	}
}
