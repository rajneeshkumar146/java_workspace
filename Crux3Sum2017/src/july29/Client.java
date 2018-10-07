package july29;

public class Client {

	public static void main(String[] args) {
		int[] arr = {100, 200, 500, 300, 150, 10, 250};
		Heap rnklst = new Heap(true, arr);
		
		rnklst.display();
		
		while(rnklst.size() != 0){
			System.out.println(rnklst.removeHP());
		}
	}

}
