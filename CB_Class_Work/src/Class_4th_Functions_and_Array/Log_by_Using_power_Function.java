package Class_4th_Functions_and_Array;

public class Log_by_Using_power_Function {

	public static void main(String[] args) {
		System.out.println(log(243, 3));
	}

	public static int power(int x, int n) {
		int pow = 1;
		for (int i = 1; i <= n; i++) {
			pow = pow * x;
		}
		return pow;
	}

	public static int log(int x, int b) {
		int i = 0;
		while (true) {
			if (x == power(b, i)) {
				break;
			}
			i++;
		}
		return i;
	}
}