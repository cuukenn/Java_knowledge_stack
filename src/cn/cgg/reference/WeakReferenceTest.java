package cn.cgg.reference;

import java.lang.ref.WeakReference;
/**
 * <pre>
 * ���������ڵڶ�����������ʱ���գ���ʱ����ͨ��������ȡ��Ӧ�����ݣ�����ȡ������ִ�й��ڶ�����������ʱ��������null��
��������Ҫ���ڼ�ض����Ƿ��Ѿ����������������Ϊ�������յ�����������ͨ�������õ�isEnQueued�������ض����Ƿ�������������ǡ�
 * </pre>
 * @author admin
 *
 */
public class WeakReferenceTest {
	public static void main(String[] args) {
		Object o=new Object();
		WeakReference<Object> reference = new WeakReference<Object>(o);
		o=null;
		System.out.println(reference.get());
		System.out.println(reference.isEnqueued());
	}
}
