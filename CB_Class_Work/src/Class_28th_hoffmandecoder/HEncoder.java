package Class_28th_hoffmandecoder;

import java.util.ArrayList;
import java.util.Comparator;

import Class_26th_Generics_Overloading_HuffmenEncoder.GenericHeap;

public class HEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	private static class Node {
		private Character data;
		private Node left;
		private Node right;
		private int freq;

		private static final NodeComapator ctor = new NodeComapator();

		private static class NodeComapator implements Comparator<Node> {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.freq - o1.freq;
			}

		}

	}

	public HEncoder(String feeder) throws Exception {

		HashMap<Character, Integer> fm = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char ch = feeder.charAt(0);
			if (fm.containskey(ch)) {
				fm.put(ch, fm.get(ch) + 1);
			} else {
				fm.put(ch, 1);
			}
		}

		GenericHeap<Node> heap = new GenericHeap<>(Node.ctor);
		ArrayList<Character> keys = new ArrayList<>(fm.keyset());
		for (Character key : keys) {
			Node node = new Node();
			node.data = key;
			node.freq = fm.get(key);
			node.left = null;
			node.right = null;
			heap.add(node);
		}

		while (heap.size() != 1) {
			Node one = heap.removeHP();
			Node two = heap.removeHP();
			Node mergerNode = new Node();
			mergerNode.freq = one.freq + two.freq;
			mergerNode.left = one;
			mergerNode.right = two;
			heap.add(mergerNode);
		}

		Node finalNode = heap.removeHP();
		fillEncoderDecoder(finalNode, "");

	}

	private void fillEncoderDecoder(Node node, String osf) throws Exception {
		if (node.left == null && node.right == null) {
			encoder.put(node.data, osf);
			decoder.put(osf, node.data);
			return;
		}

		fillEncoderDecoder(node.left, osf + "0");
		fillEncoderDecoder(node.right, osf + "1");

	}

	public String compress(String str) throws Exception {

		String rv = "";
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			String res = encoder.get(ch);
			rv += res;
		}

		return rv;

	}

	public String decompress(String cstr) throws Exception {

		String rv = "";
		String code = "";
		for (int i = 0; i < cstr.length(); i++) {
			code += cstr.charAt(i);

			if (decoder.containskey(code)) {
				rv += decoder.get(code);
				code = "";

			}
		}

		return rv;

	}

}
