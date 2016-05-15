package com.device.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 
 * The class ChannelTransfer.
 *
 * Description:transferTo
 *
 * @author: zengbo
 * @since: 2016年5月12日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class ChannelTransfer {

	public static void main(String[] args) throws IOException {
		String[] argv = { "E:\\a.txt" };
		if (argv.length == 0) {
			System.err.println("Usage : filename ...");
			return;
		}

		catFiles(Channels.newChannel(System.out), argv);
	}

	/**
	 * 将所有文件通道，复制到控制台通道打印
	 * @param target
	 * @param files
	 * @throws IOException
	 */
	private static void catFiles(WritableByteChannel target, String[] files) throws IOException {
		for (int i = 0; i < files.length; i++) {
			FileInputStream fis = new FileInputStream(files[i]);
			FileChannel channel = fis.getChannel();
			channel.transferTo(0, channel.size(), target);
			channel.close();
			fis.close();
		}
	}
}
