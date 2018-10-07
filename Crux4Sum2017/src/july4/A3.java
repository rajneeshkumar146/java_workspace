package july4;

public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// double d = 0.05;
		// d = d + 0.01;
		// System.out.println(d+ "\t" + Math.round(d * 100)/ 100.0);
		sqrt(19, 3);
		
	}

	public static void sqrt(int n, int p) {
		double sqrt = 0;
		double increment = 1;

		for (int i = 0; i <= p; i++) {
			while (sqrt * sqrt <= n) {
				sqrt = sqrt + increment;
			}

			sqrt = sqrt - increment;
			increment *= 0.1;
		}

		System.out.printf("%." + p + "f", sqrt);
	}

}
