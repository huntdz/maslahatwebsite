package com.freelance.maslahat.util;

import java.security.MessageDigest;

public class Md5 {
	
	public static String hash(String pass){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes());
			byte[] byteData = md.digest();
			
			StringBuffer sha1 = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
		         sha1.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		    }
			return sha1.toString();
		}catch (Exception e){
			e.printStackTrace();
			return "Error";
		}
	}
	
	/*public static void main(String[] args){
		String hasil = Md5.hash("Testing1");
		System.out.println("Hash = " + hasil);
	}*/
}
