package com.tayo2000.ssm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tool {
	public static String md5(String password) throws NoSuchAlgorithmException{
		MessageDigest md5=MessageDigest.getInstance("MD5");
		md5.update(password.getBytes());
		return new BigInteger(1,md5.digest()).toString(16);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		System.out.println(Tool.md5("123"));
		System.out.println(Tool.md5(Tool.md5("123456")));
	}
}
