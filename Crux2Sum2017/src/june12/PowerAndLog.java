package june12;

public class PowerAndLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Log(243, 3));
	}
	
	public static int Power(int x, int n){
		int rv = 1;
		
		int counter = 1;
		while(counter <= n){
			rv = rv * x;
			counter++;
		}
		
		return rv;
	}

	public static int Log(int x, int n){
		int rv = 1;
		
		int counter = 0;
		while(true){
			int pow = Power(n, counter);
			
			if(pow == x){
				break;
			}
			
			counter++;
		}
		
		rv = counter;
		
		return rv;
	}
}
