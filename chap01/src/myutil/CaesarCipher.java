package myutil;

import java.util.Arrays;

public class CaesarCipher extends Cipher {

	// # ��ȣ��?
	// 	- ��� �޼����� �ְ�ޱ� ���� ��
	//	- ��ȣȭ(Encryption) : ��(�Ϲ� �޼���)�� ��ȣ��(��� �޼���)�� �ٲٴ°�
	//	- ��ȣȭ(Decryption) : ��ȣ���� ������ �ǵ����� ��
	//	- Ű(key) : ��ȣȭ�� ��ȣȭ�� ���Ǵ� ��� ��

	// # ����(ī�̻縣) ��ȣ
	//	- ���ĺ��� Ű(Key)�� ��ŭ ���������� �̵���Ű�� ��ȣ ���
	//	- ��ȣȭ : ���� Ű �� ��ŭ ���������� �̵���Ų��.
	//	- ��ȣȭ : ��ȣ���� Ű �� ��ŭ �������� �̵���Ų��.

	// ex>
	// ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcef....
	//	# Key���� 3�� ��� ��ȣȭ (+3)
	//	"Hello, Wordl!"	=> "Khoorc#Zruog$"
	//	# Key���� 3�� ��� ��ȣȭ (-3)
	//	"Khoorc#Zruog$" => "Hello, Wordl!"

	int key;
	char[] pwd = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuvwxyz").toCharArray();

	public CaesarCipher(int key) {
		// this.key = key;
		this.key = key % pwd.length;
	}

	public int indexOf(char ch) {
		for(int i = 0; i < pwd.length; ++i) {
			if (ch == pwd[i]) {
				return i;
			}
		}
		return -1;
	}
	public String encryption(String plain_text) {
		// �Ű������� ���� ���� ��ȣȭ �Ͽ� �����ϴ� �Լ� 
		StringBuilder encryp = new StringBuilder();	
		for(int i = 0; i < plain_text.length(); ++i) {
			char ch = plain_text.charAt(i);
			int index = indexOf(ch);
			
			if(index != -1) {
				encryp.append(pwd[(index + key) % pwd.length]);
			}else {
				// pwd�� ���� ���ڴ� �״�� ����.
				encryp.append(ch);
			}
		}
		return encryp.toString();
	}

	public String decryption(String crypto_text) {
		// �Ű������� ���� ��ȣ���� ��ȣȭ �Ͽ� �����ϴ� �Լ�
		StringBuilder decryp = new StringBuilder();	
		for(int i = 0; i < crypto_text.length(); ++i) {
			char ch = crypto_text.charAt(i);
			int index = indexOf(ch);
			
			if(index != -1) {
				int plain_index = index - key;
				plain_index = plain_index < 0 ?
						plain_index + pwd.length : plain_index;
				
				decryp.append(pwd[plain_index]);
			}else {
				// pwd�� ���� ���ڴ� �״�� ����.
				decryp.append(ch);
			}
		}

		return decryp.toString();
	}

	public static void main(String[] args) {

		String a = new CaesarCipher(100).encryption("qwerasdf");
		System.out.println(a);
		
		String b = new CaesarCipher(100).decryption(a);
		System.out.println(b);
	}

}
