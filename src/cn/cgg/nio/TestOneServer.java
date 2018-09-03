package cn.cgg.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import sun.nio.ByteBuffered;
import sun.nio.ch.ServerSocketAdaptor;

public class TestOneServer {
	public static void main(String[] args) throws Exception {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		ServerSocketChannel socketChannel = ServerSocketChannel.open();
		SocketAddress addr = new InetSocketAddress(8080);
		socketChannel.configureBlocking(false);
		socketChannel.bind(addr);
		Selector sel = Selector.open();
		socketChannel.register(sel, SelectionKey.OP_ACCEPT);
		System.out.println("开始监听");
		while (true) {
			int num = sel.select();
			Set<SelectionKey> keys = sel.selectedKeys();
			Iterator<SelectionKey> iterator = keys.iterator();
			while (iterator.hasNext()) {
				SelectionKey next = iterator.next();
				SocketChannel channel = null;
				if (next.isAcceptable()) {
					channel = ((ServerSocketChannel) next.channel()).accept();
					channel.configureBlocking(false);
					channel.register(sel, SelectionKey.OP_READ);
					iterator.remove();
				} else if (next.isReadable()) { 
					channel = (SocketChannel) next.channel();
					while (true) {
						buffer.clear();
						int rs = channel.read(buffer);
						if (rs <= 0) {
							channel.close();
							System.out.println("接受完毕");
							break;
						}
						System.out.println("##" + rs + " " + new String(buffer.array(), 0, buffer.position()));
						buffer.flip();
					}
					iterator.remove();
				} else {
					channel.close();
				}

			}
		}
	}
}
