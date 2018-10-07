package L012_GenericTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;

import javax.print.attribute.standard.MediaSize.Other;

import org.w3c.dom.Node;

public class GenericTree_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 16 GT
		// 1.1 Context - hierarchical
		// 1.2 Node, ctor, data members
		// 1.3 takeInput, size, isEmpty, display
		// 1.4 size2, max, find, height
		// 1.5 preo, posto, areas, iteratives
		// 1.6 levelo, levelolw, levelolwzz
		// 1.7 removeLeaves, mirror, linearize, flatten
		// 1.8 isIsomorphic, isMirrorImage, isSymmetric
		// 1.9 MultiSover (Heapmover) - size, max, min, find, height, pred,
		// succ, justLarger, justSmaller
		// 1.10 kthLargest, kthSmallest

		 solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		// 21 10 20 50 -1 60 -1 70 -1 -1 30 80 -1 90 -1 -1 40 60 -1 70 -1 -1
		int[] arr = ArrayInput(scn.scanInt());
		genericTree gt = new genericTree(arr);

		// pnter.printLine(gt + "");
		// pnter.printLine(gt.sizeRec() + "");
		// pnter.printLine(gt.height() + "");

		// gt.Linearize();

		// gt.levelOder();

		// gt.Flattern();
		// gt.ZigZagLevelOder();
		// pnter.print(gt + "");

		// pnter.printLine(gt.KthLargest(2) + "");

		ArrayList<Integer> serialize = gt.serialize();
		System.out.println(serialize);

	}

	private static int[] ArrayInput(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
		}
		return arr;
	}

	private static class genericTree {

		private class Node {
			private int data;
			private ArrayList<Node> children = new ArrayList<>();

			public Node(int data) {
				this.data = data;
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				sb.append(this.data + " -> ");
				for (int i = 0; i < children.size(); i++) {
					sb.append(children.get(i).data + " ");
				}
				sb.append(".\n");

				for (Node child : children) {
					String cs = child.toString();
					sb.append(cs);
				}

				return sb.toString();
			}

		}

		public String toString() {
			return root.toString();
		}

		private Node root;
		private int size;

		// Constructor.=============================================================================

		public genericTree(int[] arr) {
			root = ArrayConstructor(arr);
		}

		static int vidx = 0;

		private Node ArrayConstructor(int[] arr) {
			if (vidx == arr.length) {
				return null;
			}

			if (arr[vidx] == -1) {
				vidx++;
				return null;
			}

			Node node = new Node(arr[vidx]);
			vidx++;
			this.size++;
			while (true) {
				Node child = ArrayConstructor(arr);
				if (child != null) {
					node.children.add(child);
				} else {
					break;
				}
			}
			return node;
		}

		// GenerallFuctions.=======================================================================

		public int sizeRec() {
			return sizeRec(this.root);
		}

		private int sizeRec(Node node) {
			int size = 0;
			for (Node child : node.children) {
				size += sizeRec(child);
			}
			return size + 1;
		}

		public int height() {
			return height(this.root);

		}

		public int height(Node node) {
			int maxHeight = 0;
			for (Node child : node.children) {
				maxHeight = Math.max(maxHeight, height(child));
			}
			return maxHeight + 1;
		}

		public int MaxEle() {
			return MaxEle(this.root);
		}

		private int MaxEle(Node node) {
			int OverAllMax = node.data;
			for (Node child : node.children) {
				OverAllMax = Math.max(OverAllMax, MaxEle(child));
			}

			return OverAllMax;
		}

		public boolean Find(int data) {
			return Find(this.root, data);
		}

		private boolean Find(Node node, int data) {
			if (node.data == data) {
				return true;
			}

			for (Node child : node.children) {
				boolean res = Find(child, data);
				if (res) {
					return true;
				}
			}

			return false;
		}

		private class Heapmover {
			private int max = Integer.MIN_VALUE;
			private int min = Integer.MAX_VALUE;
			private int height;
			private boolean isFind;
			private Node Succ;
			private Node pred;
			private Node prev;

		}

		// Question.==================================================================================================

		public void MirrorImage() {
			MirrorImage(this.root);
		}

		private void MirrorImage(Node node) {

			int i = 0;
			int j = node.children.size() - 1;
			while (i < j) {
				Node first = node.children.get(i);
				Node second = node.children.get(j);

				node.children.set(i, second);
				node.children.set(j, first);

				i++;
				j--;
			}

			for (Node child : node.children) {
				MirrorImage(child);
			}
		}

		private void removeLeaves() {
			removeLeafs(this.root);
		}

		private void removeLeafs(Node node) {
			// Sirf_usipe_call_lagao_j0Leaf_nahiHai.
			for (int i = node.children.size() - 1; i >= 0; i--) {
				Node child = node.children.get(i);
				if (child.children.size() == 0) {
					node.children.remove(i);
				} else {
					removeLeafs(child);
				}
			}
		}

		public void Linearize() throws IOException {
			Linearize(this.root);
			pnter.printLine(this.root + "");
		}

		private Node Linearize(Node node) {

			if (node.children.size() == 0) {
				return node;
			}

			Node last = node.children.get(node.children.size() - 1);
			Node LastTail = Linearize(last);

			for (int i = node.children.size() - 1; i > 0; i--) {
				Node ithm1 = node.children.get(i - 1); // ith_minus_one
				Node ithm1tail = Linearize(ithm1);

				ithm1tail.children.add(node.children.remove(i));
			}

			return LastTail;

		}

		// Traversal.==============================================================================================

		public void levelOder() throws IOException {
			ArrayDeque<Node> queue = new ArrayDeque<>();
			queue.addLast(this.root);

			while (!queue.isEmpty()) {
				Node rem = queue.removeFirst();
				pnter.print(rem.data + " ");
				for (Node child : rem.children) {
					queue.addLast(child);
				}
			}

		}

		public void levelOderLineWise() throws IOException {
			LinkedList<Node> queue = new LinkedList<>();
			queue.addLast(this.root);
			queue.addLast(null);

			while (queue.size() > 1) {
				Node rem = queue.removeFirst();
				if (rem != null) {
					pnter.print(rem.data + " ");
					for (Node child : rem.children) {
						queue.addLast(child);
					}
				} else {
					if (queue.size() == 1) {
						break;
					}
					queue.removeFirst();
					queue.addLast(null);
					pnter.printLine("");
				}
			}

		}

		public void Flattern() {
			Flattern(this.root);
			System.out.println(this);
		}

		private void Flattern(Node node) {

			ArrayList<Node> childs = new ArrayList<>();
			for (Node child : node.children) {
				Flattern(child);
				childs.add(child);
				for (Node c : child.children) {
					childs.add(c);
				}
				child.children = new ArrayList<>();
			}

			node.children = childs;

		}

		public void ZigZagLevelOder() throws IOException {
			LinkedList<Node> stack1 = new LinkedList<>(); // addFirst,RemoveFirst.
			LinkedList<Node> stack2 = new LinkedList<>();

			stack1.addFirst(this.root);

			boolean flag = false; // false_Means_Left_to_right_correct_oder_mai_addkrdo.
			while (!stack1.isEmpty()) {

				int size = stack1.size();
				while (size-- > 0) {
					Node rem = stack1.removeFirst();
					pnter.print(rem.data + " ");

					if (!flag) {
						for (Node child : rem.children) {
							stack2.addFirst(child);
						}
					} else {
						for (int i = rem.children.size() - 1; i >= 0; i--) {
							Node child = rem.children.get(i);
							stack2.addFirst(child);
						}
					}

					flag = true;
				}

				LinkedList<Node> temp = stack1;
				stack1 = stack2;
				stack2 = temp;

				pnter.printLine("");

			}
		}

		public void MultiSolver(int data) {
			Heapmover mover = new Heapmover();
			MultiSolver(mover, this.root, 0, data);

		}

		private void MultiSolver(Heapmover mover, Node node, int height, int data) {

			mover.max = Math.max(mover.max, node.data);
			mover.min = Math.min(mover.min, node.data);
			mover.isFind = mover.isFind || node.data == data;
			mover.height = Math.max(mover.height, height);

			// Spot_where_prev-is_one_step_behind;
			if (node.data == data) {
				mover.pred = node;
			}

			if (mover.prev.data == data) {
				mover.Succ = node;
			}

			mover.prev = node;

			for (Node child : node.children) {
				MultiSolver(mover, child, height + 1, data);
			}
		}

		public int justLarger(int data) {

		}

		private class KthLargestMover {
			int ele = Integer.MIN_VALUE;
		}

		private void KthLargest(KthLargestMover mover, Node node, int data) {
			if (node.data < data) {
				mover.ele = Math.max(mover.ele, node.data);
			}

			for (Node child : node.children) {
				KthLargest(mover, child, data);
			}

		}

		public int KthLargest(int k) {
			KthLargestMover mover = new KthLargestMover();
			int largest = Integer.MAX_VALUE;
			for (int i = 0; i < k; i++) {
				KthLargest(mover, this.root, largest);
				largest = mover.ele;
				mover.ele = Integer.MIN_VALUE;
			}

			return largest;

		}

		public ArrayList<Integer> serialize() {
			return serialize(this.root);
		}

		private ArrayList<Integer> serialize(Node node) {
			ArrayList<Integer> mr = new ArrayList<>();
			mr.add(node.data);
			for (Node child : node.children) {
				mr.addAll(serialize(child));
			}
			mr.add(-1);

			return mr;
		}

		public boolean isIsomorphic(GenericTree_001.genericTree other) {

			return isIsomorphic(this.root, other.root);

		}

		private boolean isIsomorphic(Node node, Node onode) {
			if (node.children.size() != onode.children.size()) {
				return false;
			}

			for (int i = 0; i < node.children.size(); i++) {
				if (!isIsomorphic(node.children.get(i), onode.children.get(i))) {
					return false;
				}
			}

			return true;
		}

		public boolean isMirrorImage(GenericTree_001.genericTree other) {

			return isMirrorImage(this.root, other.root);

		}

		private boolean isMirrorImage(Node node, Node onode) {
			if (node.children.size() != onode.children.size()) {
				return false;
			}

			for (int i = 0, j = onode.children.size() - 1; i < node.children.size() && j >= 0; i++, j--) {
				if (!isMirrorImage(node.children.get(i), onode.children.get(j))) {
					return false;
				}
			}

			return false;
		}

		public boolean IsFoldable() {
			return isMirrorImage(this.root, this.root);
		}

	}

	
		// ------------------------------------------------------------------------------------------------------------------------

	private static class Scan {
		private InputStream in;
		private byte[] buf = new byte[1024 * 1024];
		private int index;
		private int total;

		public Scan(InputStream in) {
			this.in = in;
		}

		public int scan() throws IOException {
			if (total < 0)
				throw new InputMismatchException();
			if (index >= total) {
				index = 0;
				total = in.read(buf);
				if (total <= 0)
					return -1;
			}
			return buf[index++];
		}

		public int scanInt() throws IOException {
			int integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public long scanLong() throws IOException {
			long integer = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					integer *= 10;
					integer += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			return neg * integer;
		}

		public double scanDouble() throws IOException {
			double doub = 0;
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			int neg = 1;
			if (n == '-') {
				neg = -1;
				n = scan();
			}
			while (!isWhiteSpace(n) && n != '.') {
				if (n >= '0' && n <= '9') {
					doub *= 10;
					doub += n - '0';
					n = scan();
				} else
					throw new InputMismatchException();
			}
			if (n == '.') {
				n = scan();
				double temp = 1;
				while (!isWhiteSpace(n)) {
					if (n >= '0' && n <= '9') {
						temp /= 10;
						doub += (n - '0') * temp;
						n = scan();
					} else
						throw new InputMismatchException();
				}
			}
			return doub * neg;
		}

		public String scanString() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpace(n))
				n = scan();
			while (!isWhiteSpace(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		public String scanStringLine() throws IOException {
			StringBuilder sb = new StringBuilder();
			int n = scan();
			while (isWhiteSpaceModified(n))
				n = scan();
			while (!isWhiteSpaceModified(n)) {
				sb.append((char) n);
				n = scan();
			}
			return sb.toString();
		}

		private boolean isWhiteSpace(int n) {
			if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}

		private boolean isWhiteSpaceModified(int n) {
			if (n == '\n' || n == '\r' || n == '\t' || n == -1)
				return true;
			return false;
		}
	}

	private static class Print {
		private final BufferedWriter bw;

		public Print() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(String str) throws IOException {
			bw.append(str);
		}

		public void printLine(String str) throws IOException {
			print(str);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}

}
