package aug12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import july31.GenericHeap;

public class HEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();
	
	private static class Node {
		Character data;
		int freq;
		Node left;
		Node right;
		private static final NodeComparator Ctor = new NodeComparator();
		
		private static class NodeComparator implements Comparator<Node>{
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.freq - o1.freq;
			}
			
		}
	}
	
	public HEncoder(String feeder){
		// 1. Freq map
		HashMap<Character, Integer> fm = new HashMap<>();
		for(int i = 0; i < feeder.length(); i++){
			Character ch = feeder.charAt(i);
			
			if(fm.containsKey(ch)){
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, 1);
			}
		}
		
		// 2. Heap creation
		GenericHeap<Node> heap = new GenericHeap<>(Node.Ctor);
		ArrayList<Character> keys = new ArrayList<>(fm.keySet());
		for(Character key: keys){
			Node node = new Node();
			
			node.data = key;
			node.freq = fm.get(key);
			
			heap.add(node);
		}
		
		// 3. Tree creation - remove two, merge, put it back
		while(heap.size() != 1){
			Node one = heap.removeHP();
			Node two = heap.removeHP();
			
			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one;
			merged.right = two;
			
			heap.add(merged);
		}
		
		// 4. Traverse the tree and fill encoder, decoder
		Node finalNode = heap.removeHP();
		fillEncoderDecoder(finalNode, "");
	}
	
	private void fillEncoderDecoder(Node node, String osf){
		if(node.left == null && node.right == null){
			encoder.put(node.data, osf);
			decoder.put(osf, node.data);
			return;
		}
		
		fillEncoderDecoder(node.left, osf + "0");
		fillEncoderDecoder(node.right, osf + "1");
	}

	public String compress(String str){
		String rv = "";
		
		for(int i = 0; i < str.length(); i++){
			Character ch = str.charAt(i);
			String code = encoder.get(ch);
			 rv += code;
		}
		
		return rv;
	}
	
	public String decompress(String cstr){
		String rv = "";
		
		String code = "";
		for(int i = 0; i < cstr.length(); i++){
			Character ch = cstr.charAt(i);
			code += ch;
			
			if(decoder.containsKey(code)){
				rv += decoder.get(code);
				code = "";
			}
		}
		
		return rv;
	}
}
