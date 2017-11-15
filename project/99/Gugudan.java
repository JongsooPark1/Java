import java.util.Scanner;

public class Gugudan {
	public static int[] calculate(int times) {
		int[] result = new int[times];
		for (int i = 0; i < result.length; i++) {
			// 계산 결과를 배열에 저장
			result[i] = times * (i + 1);
		}
		return result;
	}
	
	public static void print(int num1, int[] result) {
		for (int i = 0; i < result.length; i++) {
			// 계산 결과를 화면에 출력
			System.out.println(num1 + " X " +  (i + 1) + " = " + (num1 * (i + 1)));
		}
	}
	
	public static void main(String[] args) {
		System.out.println("두 가지 숫자를 괄호와 같은 형태로 입력해주세요.(2,7)");
		Scanner scanner = new Scanner(System.in);
		String val = scanner.nextLine();
		String[] splittedVal = val.split(",");
		int firstVal = Integer.parseInt(splittedVal[0]);
		int secondVal = Integer.parseInt(splittedVal[1]);
		
		for (int i = 2; i <= firstVal; i++) {
			// calculate와 print 메소드 활용해 구구단 구현하기
			System.out.println(i + "단");
			print(i, calculate(secondVal));
		}
	}
}


