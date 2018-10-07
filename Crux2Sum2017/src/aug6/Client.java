package aug6;

public class Client {

	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> popmap = new HashMap<>();
		popmap.put("ABC", 200);
		popmap.put("DEF", 120);
		popmap.put("GHI", 2000);
		popmap.put("JKL", 1200);
		popmap.display();
		
		popmap.put("JKL", 1400);
		popmap.display();
		
		popmap.put("ABCD", 2030);
		popmap.put("DEFF", 1220);
		popmap.put("GHIJ", 20100);
		popmap.put("JKLM", 12600);
		popmap.display();
		
		popmap.put("ZXC", 345);
		popmap.display();
		
		System.out.println(popmap.containsKey("ABCD"));
		System.out.println(popmap.remove("ABCD"));
		System.out.println(popmap.containsKey("ABCD"));
		
	}

}
