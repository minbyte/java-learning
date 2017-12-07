package com.mindasoft._01_data_type;

import org.junit.Test;

/**
 * Byte Short Integer Long Float Double Character Boolean
 * BigInteger BigDecimal
 * equals()  和 ==
 */
public class _03_WrapperDataType {

	/**
	 * Byte Short Integer Long 都一样
	 * 这些包装类都存在一个缓存数组，-128 到 127
	 *
	 */
	@Test
	public void integer01(){
		Integer i1 = 1;
		Integer i2 = 1;
		System.out.println(i1 == i2);       // true 比较的是地址，1自动装箱,Integer缓存了-128 至 127
		System.out.println(i1.equals(i2));  // true 比较的是数值

		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4);       // false 比较的是地址，1自动装箱,Integer缓存了-128 至 127
		System.out.println(i3.equals(i4));  // true 比较的是数值

		Integer i5 = new Integer("1");
		Integer i6 = new Integer("1");
		System.out.println(i5 == i6);    	// false new出来的都是一个新的对象
		System.out.println(i5.equals(i6));  // true

		Integer i7 = Integer.valueOf("1");
		Integer i8 = Integer.valueOf("1");
		System.out.println(i7 == i8);    	// true Integer.valueOf走的是Integer的缓存
		System.out.println(i7.equals(i8));  // true
		System.out.println(i1 == i8); 		// true

		Integer i9 =Integer.decode("1");
		System.out.println(i9 == i7);  // true decode底层走 valueOf ,也就是缓存，所以相等

		int i10 = Integer.parseInt("1");
		int i11 = Integer.parseInt("1",10);

//		Integer i12 = Integer.getInteger("1");
	}

	@Test
	public void double02(){


	}

	@Test
	public void boolean03(){
		Boolean b1 = true;
		Boolean b2 = true;
		System.out.println(b1 == b2); //true

		Boolean b3 = new Boolean(true);
		Boolean b4 = new Boolean(true);
		System.out.println(b3 == b4); // false

		Boolean b5 = Boolean.valueOf(true);
		Boolean b6 = Boolean.valueOf(true);
		System.out.println(b5 == b6); //true

	}

	@Test
	public void character04(){


	}

}
