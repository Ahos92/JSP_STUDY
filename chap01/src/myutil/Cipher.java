package myutil;

		// �߻� Ŭ���� : Ŭ���� ���ο� �߻� �޼��带 ���� Ŭ����
public abstract class Cipher {
	
	// # �߻� �޼��� abstract
	//	- �Լ��� ���¸� ���س��� �ڽ� Ŭ�������� �����ϰ�(�������̵�) �����.
	//	- �ڽ� Ŭ�������� �������̵� ���� ������ ������ �߻� (������ ȿ��)
	//	- �ڽ� Ŭ������ ���� ������ �ش� �޼��尡 100% ����
	// 	- ��ĳ���� ���� �� �ڽ� Ŭ�������� ������ �ڵ带 ����ϰ� �ȴ�.
	
	// �ڽ� Ŭ�������� ���¸� �̸� ������ �� 
	// �ڽ� Ŭ�������� �޼��带 �������̵� �Ͽ� ����ϰ� �����.
	abstract public String encryption(String plain);
	
	abstract public String decryption(String crypto);
	
}

// ex >
class MyAlgo extends Cipher {

	@Override
	public String encryption(String plain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decryption(String crypto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}