package july18;

public class A8a {

	public static void main(String[] args) {
		toh(10, "A", "B", "C");
	}
	
	public static void toh(int n, String begin, String end, String help){
		if(n == 0){
			return;
		}
		
		toh(n - 1, begin, help, end);
		System.out.println("Move disc [" + n + "] from " + begin + " to " + end);
		toh(n - 1, help, end, begin);
		
	}

}
