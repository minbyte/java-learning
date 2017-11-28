package com.mindasoft._01_data_type;

import org.junit.Test;

/**
 * 位："位(bit)"是电子计算机中最小的数据单位。每一位的状态只能是0或1
 * 字节：8个二进制位构成1个"字节(Byte)"，它是存储空间的基本计量单位。
 * KB: 计算机存储空间常用单位。1KB也就是1024个字节
 * 1一个字节(1byte) = 8位(8bit)
 * 基本类型	字节数  二进制位数 	最大值					最小值
 *	byte	1byte	8bit		2^7 - 1					-2^7
 *	short	2byte	16bit		2^15 - 1				-2^15
 *	int		4byte	32bit		2^31 - 1				-2^31
 *	long	8byte	64bit		2^63 - 1				-2^63
 *	float	4byte	32bit		3.4028235E38			1.4E - 45
 *	double	8byte	64bit		1.7976931348623157E308	4.9E - 324
 *	char	2byte	16bit		2^16 - 1				0
 *
 * Created by huangmin on 2017/9/15 16:41.
 */
public class _01_OriginalDataType {
    //   8   16    32   64   32    64   16
    // byte short int long float double char boolean

	/**
	 * 取值范围-128(-1 * 2^7) 至 127(2^7 -1)
	 */
	@Test
	public void byteStart(){
		byte a = 1;
		byte b = 127;
//		byte c = 128;    //会报错，byte取值范围是-128 至 127
		System.out.println("a="+a);
		System.out.println("b="+b);

	}

	/**
	 * -32,768 至 32,767
	 */
	public void shortStart(){
	}

	/**
	 * -2,147,483,648  至 2,147,483,647
	 */
	public void intStart(){

	}

	/*
		复习一下英语
		1,000为“一千”：a thousand
		1,000,000为“一百万”：a million
		1,000,000,000为“十亿”：a billion
		1,000,000,000,000为“万亿” a trillion
	*/
}
