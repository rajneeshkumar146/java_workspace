import java.util.Scanner;

public class Question_05 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Minimum Fahrenheit value");
		int min_f = scn.nextInt();

		System.out.println("Enter Maximum Fahrenheit value");
		int max_f = scn.nextInt();

		System.out.println("Enter Step fahrenheit value");
		int step_f = scn.nextInt();
		
		result(min_f,max_f,step_f);

	}

	public static void result(int min_f, int max_f, int step_f) {
		int celsius = 0;
		for (int i = 0; min_f <= max_f; min_f += step_f) {
			celsius = (int) ((5.0 / 9) * (min_f - 32));
		  System.out.println(min_f + "\t" + celsius);
		}
	}

}
