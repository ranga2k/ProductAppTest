package com.productapp.utils;

import java.util.Random;

public class TestUtils {
	
	public static String getRandomValue()
	{
		Random random=new Random();
		int ranNumber=random.nextInt(10000);
		return Integer.toString(ranNumber);
	}

}
