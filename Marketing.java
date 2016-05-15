package com.device.test;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 
 * The class Marketing.
 *
 * Description:GatheringByteChannel使用
 *
 * @author: zengbo
 * @since: 2016年5月12日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class Marketing {

	private static final String DEMOGRAPHIC = "blahblah.txt";
	private static String[] col1 = { "Aggregate", "Enable", "Leverage", "Facilitate", "Synergize",
			"Repurpose", "Strategize", "Reinvent", "Harness" };
	private static String[] col2 = { "cross-platform", "best-of-breed", "frictionless",
			"ubiquitous", "extensible", "compelling", "mission-critical", "collaborative",
			"integrated" };
	private static String[] col3 = { "methodologies", "infomediaries", "platforms", "schemas",
			"mindshare", "paradigms", "functionalities", "web services", "infrastructures" };

	private static String newline = System.getProperty("line.separator");

	private static Random rand = new Random();

	public static void main(String[] args) throws Exception {
		int reps = 10;
		if (args.length > 0) {
			reps = Integer.parseInt(args[0]);
		}

		FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
		GatheringByteChannel getherChannel = fos.getChannel();

		ByteBuffer[] bs = utterBS(reps);

		while (getherChannel.write(bs) > 0) {

		}

		System.out.println("Mindshare paradigms synergized to " + DEMOGRAPHIC);
		fos.close();
	}

	private static ByteBuffer[] utterBS(int howMany) throws Exception {
		List list = new LinkedList();
		for (int i = 0; i < howMany; i++) {
			list.add(pickRandom(col1, " "));
			list.add(pickRandom(col2, " "));
			list.add(pickRandom(col3, newline));
		}

		ByteBuffer[] bufs = new ByteBuffer[list.size()];
		list.toArray(bufs);

		return bufs;

	}

	private static Object pickRandom(String[] strings, String suffix) throws Exception {
		//在字符串数组中随机选择一个字符串
		String string = strings[rand.nextInt(strings.length)];
		int total = string.length() + suffix.length();
		ByteBuffer buf = ByteBuffer.allocate(total);
		buf.put(string.getBytes("US-ASCII"));
		buf.put(suffix.getBytes("US-ASCII"));

		buf.flip();
		return buf;
	}
}
