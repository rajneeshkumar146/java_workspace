package july29;

public class Client {

	public static void main(String[] args) {
//		Heap rankList = new Heap(true);
//		
//		rankList.add(300);
//		rankList.add(200);
//		rankList.add(700);
//		rankList.add(600);
//		rankList.add(800);
//		rankList.add(900);
//		rankList.add(100);
//
//		rankList.display();
//		while(!rankList.isEmpty()){
//			System.out.println(rankList.removeHP());
//		}
		
		int[] arr = {10, 20, 5, 18, 9, 17, 6, 20, 4, 26};
		Heap rankList = new Heap(true, arr);
		
		rankList.display();
		while(!rankList.isEmpty()){
			System.out.println(rankList.removeHP());
		}
	}

}
