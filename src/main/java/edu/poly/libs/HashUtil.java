package edu.poly.libs;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
	//mã hóa password trc khi lưu vào db (giúp pass ko bị lộ)
	public static String hash(String plaintext) {
		return BCrypt.hashpw(plaintext, BCrypt.gensalt());
	}
	
	// kiểm tra 2 chuỗi ng dùng gửi lên vs chuỗi db có khớp ko
	public static boolean verify(String plaintext, String hashed) {
		return BCrypt.checkpw(plaintext, hashed);
	}
}
