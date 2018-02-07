package com.soecode.lyf.test.utilTest;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Util 有问题（这个其中包含了base64），（可以加密）
 */
public class MD5Util {
	
	public static String md5(String src){
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] b=md.digest(src.getBytes());

			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(b);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
