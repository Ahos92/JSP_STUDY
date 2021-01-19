package chap01.datamodel;

import java.util.ArrayList;

public class Student {
	
	private String name;
	private int kor;

	public Student(String name, int kor) {
		this.name = name;
		this.kor = kor;
	}

	public String getName(){
		return this.name;
	}

	public int getKor(){
		return this.kor;
	}
	
	@Override
	public String toString() {
		return "[ " + name + " / " + kor + " ]";
	}
	
}
