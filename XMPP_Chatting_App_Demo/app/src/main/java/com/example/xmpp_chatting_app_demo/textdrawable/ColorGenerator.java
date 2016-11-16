package com.example.xmpp_chatting_app_demo.textdrawable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author amulya
 * @datetime 14 Oct 2014, 5:20 PM
 */

public class ColorGenerator {

	public static ColorGenerator MATERIAL;

	static {

		MATERIAL = create(Arrays.asList(0xff016773));
	}

	private final List<Integer> mColors;
	private final Random mRandom;

	public static ColorGenerator create(List<Integer> colorList) {
		return new ColorGenerator(colorList);
	}

	private ColorGenerator(List<Integer> colorList) {
		mColors = colorList;
		mRandom = new Random(System.currentTimeMillis());
	}

	public int getRandomColor() {
		return mColors.get(mRandom.nextInt(mColors.size()));
	}

//	public int getColor(Object key) {
//		return mColors.get(key.hashCode() % mColors.size());
//	}
}
