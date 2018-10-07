package aug12;

public class CompressionClient {

	public static void main(String[] args) {
		HEncoder hen = new HEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(hen.compress("abaacdc"));
		System.out.println(hen.decompress("10111001000001"));
	}

}
