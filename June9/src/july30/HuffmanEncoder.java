package july30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	private class Node implements Comparable<Node> {
		char data;
		int freq;
		Node left;
		Node right;
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}
	}
	
	public HuffmanEncoder(String feeder){
		// step 1 -> feeder to fmap
		HashMap<Character, Integer> fmap = new HashMap<>();
		for(int i = 0; i < feeder.length(); i++){
			char ch = feeder.charAt(i);
			fmap.put(ch, fmap.containsKey(ch) == false? 1: fmap.get(ch) + 1);
		}
		
		// step 2 -> fmap to pq
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		for(Character key: keys){
			Node node = new Node();
			node.data = key;
			node.freq = fmap.get(key);
			pq.add(node);
		}
		
		// while pq.size is 1, remove two, merge and put back
		while(pq.size() > 1){
			Node one = pq.remove();
			Node two = pq.remove();
			
			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one;
			merged.right = two;
			
			pq.add(merged);
		}
		
		// retrieve last node, travel it and fill encoder and decoder
		Node root = pq.remove();
		traverse(root, "");
		System.out.println(encoder);
	}
	
	private void traverse(Node node, String psf){
		if(node.left == null && node.right == null){
			encoder.put(node.data, psf);
			decoder.put(psf, node.data);
			return;
		}
		
		traverse(node.left, psf + "0");
		traverse(node.right, psf + "1");
	}
	
	// abcd - 110011101
	public String encode(String str) {
		String coded = "";
		
		for(int i = 0; i < str.length(); i++){
			coded += encoder.get(str.charAt(i));
		}
		
		return coded;
	}

	// 110011101 - abcd
	public String decode(String str) {
		String decoded = "";
		
		String prefix = "";
		for(int i = 0; i < str.length(); i++){
			prefix += str.charAt(i);
			if(decoder.containsKey(prefix)){
				decoded += decoder.get(prefix);
				prefix = "";
			}
		}
		
		return decoded;
	}
}






