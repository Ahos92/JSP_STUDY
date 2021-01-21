package util.hash;

public interface MemberPassword {

	public static MemberPassword getInstance() {
		return null;
	}
	
	/** return - digest or null */
	String digestPassword(String password, byte[] salt);
	
	/**  */
	public byte[] getSalt();
	
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
}
