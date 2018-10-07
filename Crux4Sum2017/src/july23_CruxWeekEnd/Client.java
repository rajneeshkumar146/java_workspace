package july23_CruxWeekEnd;

public class Client {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		
		list.addLast(10);
		list.addLast(10);
		list.addLast(10);
		list.addLast(20);
		list.addLast(20);
		list.addLast(20);
		list.addLast(30);
		list.addLast(30);
		list.addLast(30);
		
		list.display();
		list.remmoveDuplicates();
		list.display();
	}

}
