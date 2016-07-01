package com.yefe.marsrover.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public final class TestUtil {
	private static int count = (int) (System.currentTimeMillis() % 10000);

	public static InputStream createInputStream(String line) {
		return new ByteArrayInputStream(line.getBytes());
	}

	public static PrintStream createPrintStream(ByteArrayOutputStream baos) {
		return new PrintStream(baos);
	}

	public static PrintStream createPrintStream() {
		return createPrintStream(new ByteArrayOutputStream());
	}

	public static String getString() {
		return "String_" + increaseCount();
	}

	private static int increaseCount() {
		count++;
		return count;
	}

	public static int getInteger() {
		return count;
	}

	public static int getRandom(int range) {
		return (int) (Math.random() * range) + 1;
	}
}
