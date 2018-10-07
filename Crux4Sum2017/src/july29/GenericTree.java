package july29;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, 0, scn);
	}

	private Node takeInput(Node parent, int childidx, Scanner scn) {
		// ask the user
		if(parent == null){
			System.out.println("Enter the root");
		} else {
			System.out.println("Enter the data for " + childidx + " of " + parent.data);
		}

		// take input
		int data = scn.nextInt();

		// create node, set data, and increase size
		Node child = new Node();
		child.data = data;
		this.size++;

		// handle the children for the node - ask num gc
		System.out.println("Enter the number of children for " + child.data);
		int numgc = scn.nextInt();

		// handle the children for the node - create and attach gc
		for(int i = 0; i < numgc; i++){
			Node gc = this.takeInput(child, i, scn);
			child.children.add(gc);
		}

		// return
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		System.out.println("--------------------------------------------");
		display(root);
		System.out.println("--------------------------------------------");
	}

	private void display(Node node) {
		System.out.println(getStringForNode(node));
		for (Node child : node.children) {
			display(child);
		}
	}

	private String getStringForNode(Node node) {
		String rv = node.data + " => ";
		for (Node child : node.children) {
			rv += child.data + ", ";
		}
		rv += ".";
		return rv;
	}

	public int size2() {
		return this.size2(root);
	}

	private int size2(Node node) {
		int size = 0;

		for (Node child : node.children) {
			int csize = size2(child);
			size += csize;
		}

		size = size + 1;
		return size;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int cmax = max(child);
			if (cmax > max) {
				max = cmax;
			}
		}

		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int height = -1;
		
		for (Node child : node.children) {
			int cheight = height(child);
			if (cheight > height) {
				height = cheight;
			}
		}

		return height + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if(node.data == data){
			return true;
		}
		
		for(Node child: node.children){
			boolean fic = find(child, data);
			if(fic == true){
				return true;
			}
		}
		
		return false;
	}
	
	public void mirror(){
		mirror(root);
	}
	
	private void mirror(Node node){
		for(Node child: node.children){
			mirror(child);
		}
		
		int li = 0;
		int ri = node.children.size() - 1;
		while(li < ri){
			Node left = node.children.get(li);
			Node right = node.children.get(ri);
			
			node.children.set(li, right);
			node.children.set(ri, left);
			
			li++;
			ri--;
		}
	}
	
	public void printAtDepth(int targetDepth){
		printAtDepth(root, targetDepth, 0);
	}
	
	private void printAtDepth(Node node, int targetDepth, int currentDepth){
		if(currentDepth == targetDepth){
			System.out.println(node.data);
			return;
		}
		
		for(Node child: node.children){
			printAtDepth(child, targetDepth, currentDepth + 1);
		}
	}
	
	public void linear(){
		linear(root);
	}
	
	private void linear(Node node){
		for(Node child: node.children){
			linear(child);
		}
		
		while(node.children.size() > 1){
			Node removed = node.children.remove(1);
			
			Node zerotail = node.children.get(0);
			while(zerotail.children.size() != 0){
				zerotail = zerotail.children.get(0);
			}
			
			zerotail.children.add(removed);
		}
		
		
	}
	
	public void flatten(){
		flatten(root);
	}
	
	private void flatten(Node node){
		for(Node child: node.children){
			flatten(child);
		}
		
		ArrayList<Node> nloc = new ArrayList<>();
		for(Node child: node.children){
			nloc.add(child);
			nloc.addAll(child.children);
			child.children = new ArrayList<>();
		}
		
		node.children = nloc;
	}
	
	public void removeLeaves(){
		removeLeaves(root);
	}
	
	private void removeLeaves(Node node){
		for(int i = 0; i < node.children.size(); i++){
			Node child = node.children.get(i);
			
			if(child.children.size() == 0){
				node.children.remove(i);
				i--;
			}
		}
		
		for(Node child: node.children){
			removeLeaves(child);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
