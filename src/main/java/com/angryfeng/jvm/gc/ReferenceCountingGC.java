package com.angryfeng.jvm.gc;

/**
 * @ClassName: ReferenceCountingGC
 * @Description: 校验gc是否虚拟机程序计数法
 * @author: angryfeng
 * @date: 2018-11-14
 * @version: V1.0 JVM args :-verbose:gc -XX:+PrintHeapAtGC
 */
public class ReferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	/**
	 * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
	 */
	private byte[] bigSize = new byte[2 * _1MB];

	public static void testGC() {
		ReferenceCountingGC countingGC1 = new ReferenceCountingGC();
		ReferenceCountingGC countingGC2 = new ReferenceCountingGC();
		countingGC1.instance = countingGC2;
		countingGC2.instance = countingGC1;
		countingGC1 = null;
		countingGC2 = null;
		// 假设在这行发生GC，objA和objB是否能被回收？
		System.gc();
	}

	public static void main(String[] args) {
		testGC();
	}
}