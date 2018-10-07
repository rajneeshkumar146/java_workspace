package Practice_Easy;

import java.util.Scanner;

public class Carol_Numbers {

	public static long mod=1000000007;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			int num = scn.nextInt();
			long ans = power(2,num)-1;
			ans=((ans*ans)% mod-2)% mod;
			System.out.println(ans);
		}

	}

	public static long power(int a, int b) {
		if (b == 0) {
			return 1;
		}

		long power = power(a, b / 2)% mod;
		power = (power * power) % mod;
		if(b%2==1){
			power=(power*a)% mod;
		}
		return power;

	}

}
