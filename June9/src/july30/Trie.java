package july30;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private class Node {
		char data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;
	}
	
	Node root;
	int words;
	int nodes;
	
	public Trie(){
		root = new Node();
		root.data = '$';
		nodes = 1;
	}
	
	public boolean searchWord(String word){
		return searchWord(root, word);
	}
	
	private boolean searchWord(Node node, String word){
		if(word.length() == 0){
			return node.eow;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.children.get(ch);
		if(child == null){
			return false;
		} else {
			return searchWord(child, row);
		}
	}
	
	public void addWord(String word){
		if(searchWord(word)){
			return;
		} else {
			addWord(root, word);
		}
	}
	
	public void addWord(Node node, String word){
		if(word.length() == 0){
			node.eow = true;
			words++;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.children.get(ch);
		
		if(child == null){
			child = new Node();
			child.data = ch;
			node.children.put(ch, child);
			addWord(child, row);
			nodes++;
		} else {
			addWord(child, row);
		}
	}
	
	public void removeWord(String word){
		if(!searchWord(word)){
			return;
		} else {
			removeWord(root, word);
		}
	}
	
	private void removeWord(Node node, String word){
		if(word.length() == 0){
			node.eow = false;
			words--;
			return;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.children.get(ch);
		removeWord(child, row);
		
		// neither a word nor part of another
		if(child.eow != true && child.children.size() == 0){
			nodes--;
			node.children.remove(ch);
		}
	}
	
	public void displayWords(){
		displayWords(root, "");
		System.out.println(".");
	}
	
	private void displayWords(Node node, String wsf){
		if(node.eow){
			System.out.print(wsf + " ");
		}
		
		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
		for(Character key: keys){
			Node child = node.children.get(key);
			displayWords(child, wsf + key);
		}
	}
	
	public void displayTrie(){
		displayTrie(root);
	}
	
	public void displayTrie(Node node){
		System.out.println(node.data + " -> " + node.children.keySet());
		
		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
		for(Character key: keys){
			Node child = node.children.get(key);
			displayTrie(child);
		}
	}
}
