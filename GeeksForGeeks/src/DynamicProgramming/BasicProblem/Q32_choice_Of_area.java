package DynamicProgramming.BasicProblem;

public class Q32_choice_Of_area {

	public static void main(String[] args) {
		System.out.println(choiceArea(20, 8, 0));
	}

	public static int choiceArea(int m, int n, int num) {
		if (m <= 0 || n <= 0) {
			return 0;
		}

		int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
		num = num % 3;
		switch (num) {
		case 1:
			a = choiceArea(m + 3, n + 2, num + 1);
			b = choiceArea(m - 5, n - 10, num + 1);
			c = choiceArea(m - 20, n + 5, num + 1);
			break;

		case 2:

			b = choiceArea(m - 5, n - 10, num + 1);
			c = choiceArea(m - 20, n + 5, num + 1);
			a = choiceArea(m + 3, n + 2, num + 1);
			break;

		case 3:
			c = choiceArea(m - 20, n + 5, num + 1);
			a = choiceArea(m + 3, n + 2, num + 1);
			b = choiceArea(m - 5, n - 10, num + 1);

			break;
		}

		return Math.max(a, Math.max(c, b)) + 1;
	}

}
