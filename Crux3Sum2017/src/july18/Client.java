package july18;

public class Client {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		
		list.display();
		
		list.addFirst(100);
		list.display();
		
		list.addAt(35, 3);
		
		
		list.display();
		list.reverseDataRecursive_W();
		list.display();
		list.fold();
		list.display();
		
		list = list.mergeSort();
		list.display();
		
		list.addLast(33);
		list.addLast(44);
		
		list.display();
		list.kreverse(3);
		list.display();
		
//		list.displayReverse();
//		list.display();
	}

}
