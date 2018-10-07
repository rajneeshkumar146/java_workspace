package june29;

public class Inverse {

	public static void main(String[] args) {
		int n = 463215;
		int ans = 0;
		
		int pos = 1;
		while(n != 0){
			int rem = n % 10;
			n = n / 10;

			ans = ans + pos * (int)Math.pow(10, rem - 1);
			
			pos++;
		}
		
		System.out.println(ans);
	}

}
