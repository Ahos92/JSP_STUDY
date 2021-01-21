package util.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MemberPasswordImpl implements MemberPassword {

	// 싱글톤 패턴
	//	- 생성자를 private으로 만들어서 다른 곳에서 새로운 인스턴스를 생성할 수 없게 잠그는 패턴
	//	- 하나의 인스턴스만 가지고 있다는 것이 보장된다.
	private static MemberPasswordImpl instance = new MemberPasswordImpl();

	private MemberPasswordImpl() {}

	public static MemberPasswordImpl getInstance() {
		return instance;
	}
	// <-----

	public static int SALT_SIZE = 16;

	/* */
	@Override
	public byte[] getSalt() {
		byte[] salt = new byte[SALT_SIZE];

		try {
			SecureRandom.getInstance("SHA1PRNG").nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {}

		return salt;
	}

	@Override
	public String digestPassword(String password, byte[] salt) {
		try {
			// SHA-256, SHA-512, MD5 등이 있음
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 

			// 소금값 먼저 반영한 후 비밀번호 반영 ( # 소금값은 회원정보에 함꼐 저장되어야 한다 )
			sh.update(salt);
			sh.update(password.getBytes());

			// 결과 생성
			byte[] byteData = sh.digest(); // 해쉬코드 반환

			// 결과를 DB에 저장할 수 있는 형태로 변환
			return String.format("%064X", new BigInteger(1, byteData));	

		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace(); 
			return null; 
		}
	}
}
