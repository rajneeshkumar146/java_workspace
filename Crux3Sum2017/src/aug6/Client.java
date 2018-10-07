package aug6;

public class Client {

	public static void main(String[] args) throws Exception {
//		LinkedList<String> list = new LinkedList<>();
//		
//		list.addLast("Hi");
//		list.addLast("Bye");
//
//		list.addLast("ABCD");
//		list.addLast("DEDFG");
//		
//		list.display();
		
		HashMap<String, Integer> popmap = new HashMap<>();
		
		popmap.put("India", 120);
		popmap.put("China", 200);
		popmap.put("Pak", 80);
		popmap.put("US", 25);
		popmap.put("UK", 20);
		popmap.put("Nigeria", 50);
		
		popmap.display();
		
		popmap.put("India", 125);
		popmap.display();
		
		popmap.put("Uganda", 15);
		popmap.put("Rwanda", 10);
		popmap.display();
		
		popmap.put("South Africa", 30);
		popmap.display();
		
		System.out.println(popmap.containsKey("Nigeria"));
		System.out.println(popmap.remove("Nigeria"));
		System.out.println(popmap.containsKey("Nigeria"));
		
		System.out.println(popmap.keyset());
		
	}

}
