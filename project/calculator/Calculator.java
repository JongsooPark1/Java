import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
	
	public static String[] getString() {
		System.out.println("숫자와 기호 사이에 띄어쓰기(space bar)를 입력해주세요/종료시 q 입력");
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		String[] valueArr = value.split(" ");
		return valueArr;
	}
	
	public static int calculate(String[] inputArr) {
		int a;
		for (int i = 1; i < inputArr.length; i = i + 2) {
			if (inputArr[i].equals("+")) {
				a = Integer.parseInt(inputArr[i - 1]) + Integer.parseInt(inputArr[i + 1]);
				inputArr[i + 1] = Integer.toString(a);
			} else if (inputArr[i].equals("*")) {
				a = Integer.parseInt(inputArr[i - 1]) * Integer.parseInt(inputArr[i + 1]);
				inputArr[i + 1] = Integer.toString(a);
			} else if (inputArr[i].equals("-")) {
				a = Integer.parseInt(inputArr[i - 1]) - Integer.parseInt(inputArr[i + 1]);
				inputArr[i + 1] = Integer.toString(a);
			} else if (inputArr[i].equals("/")) {
				a = Integer.parseInt(inputArr[i - 1]) / Integer.parseInt(inputArr[i + 1]);
				inputArr[i + 1] = Integer.toString(a);
			}
		}
		int result = Integer.parseInt(inputArr[inputArr.length - 1]);
		return result;
	}
	
	public static void print(int inputNum) {
		System.out.println(inputNum);
	}
	
	public static void main(String[] args) {
		while(true) {
			String[] a = getString();
			if (a[0].equals("q")) {
				break;
			}
			print(calculate(a));
		}
	}
}
