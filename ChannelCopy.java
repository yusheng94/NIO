package com.device.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 
 * The class ChannelCopy.
 *
 * Description:通道
 *
 * @author: zengbo
 * @since: 2016年5月11日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class ChannelCopy {

	public static void main(String[] args) throws IOException {
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel dest = Channels.newChannel(System.out);
		channelCopy1(source, dest);

		source.close();
		dest.close();
	}

	/**两种复制方法作用一致
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	private static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest)
			throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		//将字节序列从通道中读取到缓冲区
		while (src.read(buffer) != -1) {
			buffer.flip();
			//将字节序列从缓冲区写到此通道中
			dest.write(buffer);
			//压缩缓冲区
			buffer.compact();
		}

		//		buffer.flip();
		//		while (buffer.hasRemaining()) {
		//			dest.write(buffer);
		//		}
	}

	private static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest)
			throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		//将字节序列从通道中读取到缓冲区
		while (src.read(buffer) != -1) {
			buffer.flip();
			while (buffer.hasRemaining()) {
				dest.write(buffer);
				System.out.println("-----");
			}

			buffer.clear();
		}
	}

}
