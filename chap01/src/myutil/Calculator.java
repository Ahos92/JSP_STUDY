package myutil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calculator {

	public static int plus(int a, int b) {
		return a+b;
	}
	
	// 일주일 후의 날짜와 요일을 출력해주는 함수를 작성하고 hellJSP에서 가져다 사용해 보세요.
	public static String nextWeek() {
		return LocalDate.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("MM월 dd일 EE요일"));
	}
	
}
