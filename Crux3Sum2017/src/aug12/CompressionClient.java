package aug12;

public class CompressionClient {

	public static void main(String[] args) {
		HEncoder enc = new HEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(enc.compress("aabccd"));
		System.out.println(enc.decompress("1101001001000"));
	}

}
