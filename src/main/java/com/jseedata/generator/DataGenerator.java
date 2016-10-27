package com.jseedata.generator;

import java.math.BigDecimal;
import java.util.Random;

public class DataGenerator {

	public static String getFirstName() {
		int rnd = new Random().nextInt(DataLibrary.FIRST_NAME_ARRAY.length);
		return DataLibrary.FIRST_NAME_ARRAY[rnd];

	}

	public static String getLastName() {
		int rnd = new Random().nextInt(DataLibrary.LAST_NAME_ARRAY.length);
		return DataLibrary.LAST_NAME_ARRAY[rnd];
	}

	public static String getName() {
		return getFirstName() + " " + getLastName();
	}

	public static BigDecimal getAmount(BigDecimal min, BigDecimal max) {
		BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
		return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
