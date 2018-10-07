package june16;

public class CharDemo {

	public static void main(String[] args) {
		char ch1 = 'a';
		int in = ch1;
		
		System.out.println(ch1);
		System.out.println(in);
		
		ch1 = 97;
//		ch1 = 66000;

		char ch2 = (char)(ch1 + 1);
		System.out.println(ch2);
		
		System.out.println(10 + ' ' + 20);
		System.out.println(10 + " " + 20);
		System.out.println(10 + 20 + "Hello" + 30 + 40);
		
	}

}
