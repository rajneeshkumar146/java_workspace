package Class_11th_recursion_3;

public class print_lexico {

	public static void main(String[] args) {
		printlexico(1, 91);

	}

	public static void printlexico(int num, int max) {
		if( num > max) {
			return;
		}
		System.out.println(num);
		if(num<=max/10){
	
		for (int i = 0; i <= 9; i++) {
			printlexico(num * 10+i, max);
		
		}
		}
		if(num<9){
			printlexico(num+1,max);
		}
	}

}
