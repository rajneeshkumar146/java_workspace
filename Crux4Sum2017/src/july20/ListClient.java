package july20;

public class ListClient {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.display();
		
		list.addFirst(33);
		list.display();
		
		list.addAt(100, 3);

		list.display();
		list.reversePointerRecursive();
		list.display();
		
		System.out.println(list.kthFromLast(3));
		
		list.fold();
		list.display();
//		
//		list.displayReverse();
//		list.display();
		
		LinkedList l1 = new LinkedList();
		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		l1.addLast(40);
		l1.addLast(50);
		
		LinkedList l2 = new LinkedList();
		l2.addLast(11);
		l2.addLast(15);
		l2.addLast(17);
		l2.addLast(19);
		l2.addLast(21);
		
		l1.display();
		l2.display();
		LinkedList l3 = l1.mergedTwoSortedLists(l2);
		l3.display();
		
		l3.fold();
		l3.display();
		l3 = l3.mergeSort();
		l3.display();
	}
	
	

}
