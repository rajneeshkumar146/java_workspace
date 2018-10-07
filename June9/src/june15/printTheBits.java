package june15;

public class printTheBits {

	public static void main(String[] args) {
		int n = -128;
		
		int k = 31;
		while(k >= 0){
			int mask = 1 << k;
			int test = n & mask;
			
			if(test == mask){
				System.out.print(1);
			} else {
				System.out.print(0);
			}
			
			k--;
		}
	}

}
