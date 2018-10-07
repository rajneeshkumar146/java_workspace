package june14;

public class OctalSubtraction {

	public static void main(String[] args) {
		int n1 = 10744;
		int n2 = 757;

		int diff = 0;
		int mult = 1;
		int bor = 0;
		
		while(n1 != 0 || n2 != 0){
			int r1 = n1 % 10 - bor;
			int r2 = n2 % 10;
			n1 = n1 / 10;
			n2 = n2 / 10;
			
			int dig = 0;
			if(r1 >= r2){
				dig = r1 - r2;
				bor = 0;
			} else {
				dig = r1 + 8 - r2;
				bor = 1;
			}
			
			diff = diff + dig * mult;
			mult = mult * 10;
		}
		
		System.out.println(diff);
		
		
		
		
		
	}

}
