package com.device.test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * 
 * The class BufferCharView.
 *
 * Description:字节缓冲区和字符缓冲区的转换
 *
 * @author: zengbo
 * @since: 2016年5月11日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class BufferCharView {

	public static void main(String[] args) {
		//修改缓冲区的字节顺序（大端模式）
		ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
		CharBuffer charBuffer = byteBuffer.asCharBuffer();
		byteBuffer.put(0, (byte) 0);
		byteBuffer.put(1, (byte) 'H');
		byteBuffer.put(2, (byte) 0);
		byteBuffer.put(3, (byte) 'i');
		byteBuffer.put(4, (byte) 0);
		byteBuffer.put(5, (byte) '!');
		byteBuffer.put(6, (byte) 0);
		println(byteBuffer);
		println(charBuffer);

	}

	private static void println(Buffer buffer) {
		System.out.println("pos=" + buffer.position() + ", limit=" + buffer.limit() + ", capacity="
				+ buffer.capacity() + ": '" + buffer.toString() + "'");
	}

}
