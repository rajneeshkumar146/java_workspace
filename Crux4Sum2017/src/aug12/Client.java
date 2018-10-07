package aug12;

public class Client {

	public static void main(String[] args) {
		Heap heap = new Heap();
		
		heap.addHP(10);
		heap.addHP(20);
		heap.addHP(30);
		heap.addHP(40);
		heap.addHP(50);
		heap.addHP(60);
		heap.addHP(70);
		
		heap.display();
		heap.addHP(5);
		heap.display();
		System.out.println(heap.removeHP());
		heap.display();
	}

}
