package com.soecode.lyf.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author llh @date 2020/3/6
 */
public class stingTest {


	@Test
	public void testCharAndStr() {
		//字符串--》字符
		String str1 = "风云";
		char c1 = str1.charAt(0);//风， 如果要得到云。那么charAt(1);
		System.out.println(c1);
		char[] cs1 = str1.toCharArray();//字符串转字符数组
		System.out.println(Arrays.toString(cs1));

		//字符--》字符串
		char c2 = '明';
		String str2 = String.valueOf(c2);//字符转字符串
		//String str2  = c2+"";  //也可以把字符转换成字符串类型
		System.out.println(str2);
		char[] cs2 = {'明', '月'};
		String str3 = String.copyValueOf(cs2);//字符数组变字符串
		System.out.println(str3);
		String str4 = new String(cs2);//字符数组变字符串
		System.out.println(str4);

	}


	/**
	 * 把阿拉伯数字1，2，3...转化成一，二，三
	 *
	 * @return
	 */
	@Test
	public void convertNum() {

//		String n = String.valueOf(num);
		String n = "23";
		String uppercase = "千百亿千百十万千百十个";
		int nLength = n.length();
		String newStr = "";
		if (uppercase.length() - nLength < 0) {
			System.out.println("数字过长");
		}
		uppercase = uppercase.substring(uppercase.length() - nLength);
		for (int i = 0; i < nLength; i++) {
			newStr += String.valueOf("零一二三四五六七八九".charAt(Integer.valueOf(String.valueOf(n.charAt(i))))) + uppercase.charAt(i);
		}
		;
		newStr = newStr.substring(0, newStr.length() - 1);
		System.out.println(newStr);
//		return newStr;
	}

}
