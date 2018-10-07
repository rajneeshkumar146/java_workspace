package aug18;

public class Client {

	public static void main(String[] args) {
		HashMap<String, Integer> pmap = new HashMap<>();
		pmap.put("India", 120);
		pmap.put("UK", 50);
		pmap.put("Nigeria", 60);
		pmap.put("Mexico", 70);
//		pmap.display();
		
		pmap.put("Uganda", 30);
		pmap.put("India", 125);
//		pmap.display();
		
		pmap.put("Aus", 30);
		pmap.put("Sweden", 5);
		pmap.put("Kenya", 25);
		pmap.display();
		
		pmap.put("Greece", 45);
		System.out.println("------------------------------------");
		pmap.display();
		
//		System.out.println(pmap.get("Mexico"));
//		System.out.println(pmap.get("US"));
	}

}
