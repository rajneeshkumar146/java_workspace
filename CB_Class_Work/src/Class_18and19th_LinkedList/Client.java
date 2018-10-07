package Class_18and19th_LinkedList;

public class Client {

	public static void main(String[] args) throws Exception {
		
		LinkedList_simple ll=new LinkedList_simple();
			
		ll.addlast(10);
		ll.addlast(20);
		ll.addlast(30);
		ll.addlast(40);
		ll.addlast(50);
		ll.addlast(60);
		ll.addfirst(90);
		ll.addfirst(100);
		ll.addfirst(110);
		ll.display();
		
//		System.out.println(ll.getAt(3));
//		
//		System.out.println(ll.removeFirst());
//		System.out.println(ll.removeLast());
//		System.out.println(ll.removeAt(3));
//
//		System.out.println();
//		
//		ll.display();
//		
//		System.out.println("_________________________________________");
//		ll.reverseDataIter();
//		ll.reversePointerIter();
//		
//		ll.reversePointerRecur();
//		
//		ll.displayReverse();
//		
//		System.out.println("________________________________________");
//		
//		ll.display();
//		
//		ll.reverseDataRecur();
//		
//		ll.addfirst(30);
//		ll.addfirst(20);
//		ll.addfirst(10);
//		ll.addfirst(10);
//		ll.addfirst(20);
//		ll.addfirst(30);
//		
//		System.out.println(ll.palidromeRecur());
//		
//		
//		ll.fold();
//		
//		LinkedList_simple result= ll.mergedSortLL();
//		
		System.out.println();
		ll.ReverseInKthMultiple(3);
//		
		ll.display();
		
//		System.out.println(ll.Kth_element(2));
		
		
		
		
		
		}

	}

