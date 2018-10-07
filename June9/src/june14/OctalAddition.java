package june14;

public class OctalAddition {

	public static void main(String[] args) {
		int n1 = 757;
		int n2 = 7765;
		
		int carry = 0;
		int sum = 0;
		int mult = 1;
		
		while(n1 != 0 || n2 != 0 || carry != 0){
			int r1 = n1 % 10;
			int r2 = n2 % 10;
			n1 = n1 / 10;
			n2 = n2 / 10;
			
			int dig = r1 + r2 + carry;
			
			carry = dig / 8;
			dig = dig % 8;
			
			sum = sum + dig * mult;
			mult = mult * 10;
		}
		
		System.out.println(sum);
	}

}
