package com.device.test;

import java.nio.CharBuffer;

/**
 * 
 * The class BufferFillDrain.
 *
 * Description:填充释放缓冲区
 *
 * @author: zengbo
 * @since: 2016年5月11日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class BufferFillDrain {

	private static int index = 0;
	private static String[] strings = { "A random string value",
			"The product of an infinite number of monkeys", "Hey hey we're the Monkees",
			"Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly", // Sorry Jimi ;-) "Help Me! Help Me!",
	};

	public static void main(String[] args) {

		//分配字符缓冲区
		CharBuffer buffer = CharBuffer.allocate(100);

		/*
		 * 1、将字符数组中的字符串一个一个放进去
		 * 2、放进去一个字符串，反转一次，输出
		 * 3、清空缓冲区
		 */
		while (fillBuffer(buffer)) {
			buffer.flip();
			drainBuffer(buffer);
			buffer.clear();
		}
	}

	private static void drainBuffer(CharBuffer buffer) {
		//当前位置和限制之间是否有元素
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}
		System.out.println("");
	}

	private static boolean fillBuffer(CharBuffer buffer) {
		//已经把整个字符串放进去了
		if (index >= strings.length) {
			return false;
		}
		//把整个字符串数组中一个一个字符串放到缓冲区中
		String string = strings[index++];
		for (int i = 0; i < string.length(); i++) {
			buffer.put(string.charAt(i));
		}
		return true;

	}
}
