package june15;

public class PrintArmstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PrintArmstrongBetweeen(100, 999);
		System.out.println(Power(3, 5));
		System.out.println(Log(243, 3));
	}

	public static boolean IsArmStrong(int n) {
		int temp = n, sum = 0;
		while (n != 0) {
			int dig = n % 10;
			n = n / 10;
			sum = sum + dig * dig * dig;
		}

		if (temp == sum) {
			return true;
		} else {
			return false;
		}
	}

	public static void PrintArmstrongBetweeen(int n1, int n2) {
		for(int i = n1; i <= n2; i++){
			boolean isarm = IsArmStrong(i);
			if(isarm){
				System.out.println(i);
			}
		}
	}

	// x ^ n
	public static int Power(int x, int n) {
		int count = 1;
		int val = 1;
		
		while(count <= n){
			val = val * x;
			count++;
		}
		
		return val;
	}

	// Log(x) to the base n
	public static int Log(int x, int n) {
		int count = 0;
		int pow = 0;
		
		while(pow != x){
			pow = Power(n, count);
			count++;
		}
		
		return count - 1;
	}
}
