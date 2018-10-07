package june29;

public class A2Q10 {

	public static void main(String[] args) {
		int n = 5;

		int row = 1;
		int a = 0, b = 1;
		int c = 0;
		
		while (row <= n) {
			int col = 1;

			while (col <= row) {
				System.out.print(a + "\t");
				
				c = a + b;
				a = b;
				b = c;
				
				col++;
			}

			System.out.println();
			row++;
		}
	}

}
