package july18;

public class Client {

	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		
		ll.display();
		
		ll.addFirst(100);
		ll.display();
		
				
		ll.addAt(1000, 3);
		ll.addLast(300);
		ll.addLast(400);
		
		
//		ll.display();
//		ll.reverseDataIterative();
//		ll.display();
//		
//		ll.reversePointerIterative();
//		ll.display();
//		
//		ll.reversePointerRecursive();
//		ll.display();
		
//		ll.display();
//		ll.displayReverse();
//		ll.display();
		
		ll.display();
		ll.reverseDataRecursive();
		ll.display();
		ll.fold();
		ll.display();
		
		ll = ll.mergeSort();
		ll.display();
		
		ll.kreverse(3);
		ll.display();
//		
//		System.out.println(ll.midElement());
//		System.out.println(ll.kthFromLast(3));
		
		
		
//		Fun();
		
//		QueueUsingLL q = new QueueUsingLL();
//		
//		q.enqueue(10);
//		q.enqueue(20);
//		q.enqueue(30);
//		q.enqueue(40);
//		q.enqueue(50);
//		
//		q.display();
//		
//		System.out.println(q.dequeue());
//		q.display();
//		
//		System.out.println(q.dequeue());
//		q.display();
//		
//		System.out.println(q.dequeue());
//		q.display();
//		
//		System.out.println(q.dequeue());
//		q.display();
//		
//		System.out.println(q.dequeue());
//		q.display();
//		
//		System.out.println(q.dequeue());
//		q.display();
		
	}
	
	public static void Fun(){
		try {
			LinkedList list = new LinkedList();
			
			list.addLast(10);
			System.out.println(list.getFirst());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Bye");
	}

}
