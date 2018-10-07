package june29;

public class Rotate {

	public static void main(String[] args) {
		int n = 42615;
		int r = -338;
		
		int nod = 0;
		int temp = n;
		while(temp != 0){
			temp = temp / 10;
			nod++;
		}
		
		r = r % nod;
		if(r < 0){
			r = r + nod;
		}
		
		int div = (int)Math.pow(10, r);
		int mult = (int)Math.pow(10, nod - r);
		
		int quo = n / div;
		int rem = n % div;
		
		System.out.println(rem * mult + quo);
		
	}

}
