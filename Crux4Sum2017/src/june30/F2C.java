package june30;

public class F2C {

	public static void main(String[] args) {
		int minF = 0;
		int maxF = 300;
		int step = 20;
		
		int tempF = minF, tempC = 0;
		while(tempF <= maxF){
			tempC = (int)(5.0 / 9 * (tempF - 32));
			System.out.println(tempF + " " + tempC);
			tempF = tempF + step;
		}
	}

}
