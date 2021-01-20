package myutil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Hash {

	// byte		binary		hex(String)
	// 3		0000 0011		03
	// -84		1010 1100		AC
	// 103		0110 0111		67
	
	// Rainbow Table 공격
	//	- 해쉬 알고리즘을 이용해 저장한 값의 원본을 알아내는 방법
	//	- 자주 사용되는 단어들의 해쉬값들을 미리 계산해둔 리스트를 만들어 단순하게 대입해보는 방법
	//	- 이 공격을 방지하기 위해 무작위로 생성한 값을 더해서 해쉬값을 생성한다. (salt)

	// salt값 생성하기
	//	- SecureRandom : 좀더 완전한 랜덤 값을 생성할 수 있는 클래스
	//	- RNG Document - https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
	//	- ran.nextBytes(salt); : 전달한 byte[]에 랜덤값을 채워 준다.
	
	public String setSHA256(String pwd, byte[] salt){
		try{
			//SecureRandom.getInstance("PKCS11");
			SecureRandom ran = new SecureRandom();
			ran.nextBytes(salt);
			
			// SHA-256, SHA-512, MD5 등이 있음
			MessageDigest sh = MessageDigest.getInstance("SHA-256"); 

			// 소금값 먼저 반영한 후 비밀번호 반영 ( # 소금값은 회원정보에 함꼐 저장되어야 한다 )
			sh.update(salt);
			sh.update(pwd.getBytes());
			
			// 결과 생성
			byte[] byteData = sh.digest(); // 해쉬코드 반환
			
			// 결과를 DB에 저장할 수 있는 형태로 변환
			return String.format("%064x", new BigInteger(1, byteData));
			
			// 어렵게 하기
//			StringBuffer sb = new StringBuffer(); 
//
//			for(int i = 0 ; i < byteData.length ; i++){
//
//				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
//			}
//			
//			SHA = sb.toString();

		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace(); 
			return null; 

		}

	}


//	public static void main(String[] args) {
//		Hash test = new Hash();
//		
//		System.out.println(test.setSHA256("ahos"));
//		
//	}
}
