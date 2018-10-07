package Class_24th_Heap;

public class Client {

	public static void main(String[] args) {
		
		Heap hp=new Heap(true);
		
		hp.add(500);
		hp.add(600);
		hp.add(400);
		hp.add(900);
		hp.add(1000);
		hp.add(100);
		hp.add(50);
		hp.add(20);
		
		hp.display();
		
//		System.out.println();
//		while(hp.size()!=0){
//			System.out.println(hp.removeHP());
//		}
		
		System.out.println();
		hp.display2();
		
		int[] arr={20, 50, 100, 600, 1000, 500, 400, 900};
		
		
		

	}

}
