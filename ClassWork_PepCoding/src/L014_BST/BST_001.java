package L014_BST;

public class BST_001 {
	// public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		// 1.1 Context & examples - rule, recursion difference, O(h)
		// 1.2 ctor, find, max, min
		// 1.3 printrange, replaceWithSumOfLarger
		// 1.4 pairTargetSum (BT vs BST)
		// 1.4.1 fill arraylist via heapmover, sort (?), and do left right
		// 1.4.2 fill hashmap via heapmover, and find complements
		// 1.4.3 traverse and call find on complement from every spot
		// 1.5 lca (BT vs BST) - place where paths diverge
		// 1.5.1 rootToNodePaths
		// Last common element in the two rootToNode arraylists.
		// 1.5.2 startTime & endtime list -> heapMover [list of pair of
		// starttime and endtimes]
		// What? -> Last node with startime smaller than both and endtime larger
		// than both
		// How? -> traverse the list of pairs and find last such node
		// Why? -> Last node ensures the lowest in ancestry
		// 1.5.3 bst -> first node while going down with value between d1 and d2
		// 1.6 addNode, removeNode
		// 1.7 AVL
		// 1.7.1 Balanced -> O(h) to O(logn)
		// 1.7.2 Node - height, add & remove
		// 1.7.3 right rotation, left rotation
		// 1.7.4 left left, left right, right right, right left

		solve();
	}

	public static void solve() throws Exception {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		BST bt = new BST(arr);
//		bt.replaceGreaterSum();
//		System.out.println(bt);
		
//		System.out.println(bt.max());
		bt.removeNode(30);
		System.out.println(bt);
		bt.addNode(30);
		System.out.println(bt);
		
		
		
		
	}

	private static class BST {
		private class Node {
			private int data;
			private Node left;
			private Node right;

			public String toString() {
				StringBuilder sb = new StringBuilder();

				sb.append(left != null ? left.data : -1);
				sb.append(" -> " + data + " <- ");
				sb.append(right != null ? right.data : -1);
				sb.append("\n");

				if (left != null) {
					sb.append(left);
				}
				if (right != null) {
					sb.append(right);
				}

				return sb.toString();

			}

		}

		private Node root;

		public String toString() {
			return root.toString();
		}

		// Constructor.===========================================================================================

		public BST(int[] sa) {
			this.root = constructor(sa, 0, sa.length - 1);

		}

		public Node constructor(int[] sa, int i, int j) {
			if (i > j) {
				return null;
			}

			int mid = (i + j) >> 1;
			Node node = new Node();
			node.data = sa[mid];

			node.left = constructor(sa, i, mid - 1);
			node.right = constructor(sa, mid + 1, j);

			return node;
		}

		// Functions.========================================================================================================

		public boolean find(int data) {
			return find(this.root, data);

		}

		private boolean find(Node node, int data) {
			if (node == null) {
				return false;
			}

			if (node.data == data) {
				return true;
			} else if (node.data < data) {
				return find(node.right, data);
			} else {
				return find(node.left, data);
			}
		}

		public int max() {
			return max(this.root);
		}

		public int max(Node node) {
			Node traverse = node.right != null ? node.right : node;

			while (traverse.right != null) {
				traverse = traverse.right;
			}
			return traverse.data;
		}

		public int min() {
			return min(this.root);
		}

		private int min(Node node) {
			Node traverse = node.left != null ? node.left : node;

			while (traverse.left != null) {
				traverse = traverse.left;
			}
			return traverse.data;
		}

		public void PrintInRange(int lo, int hi) {

			PrintInRange(root, lo, hi);
		}

		private void PrintInRange(Node node, int lo, int hi) {

			if (lo > node.data && hi < node.data) {
				System.out.println(node.data);
			} else if (lo > node.data) {
				PrintInRange(node.right, lo, hi);
			} else if (hi < node.data) {
				PrintInRange(node.left, lo, hi);
			} else if (lo < node.data && hi > node.data) {
				PrintInRange(node.left, lo, hi);
				PrintInRange(node.right, lo, hi);
			}

		}

		private class pair {
			int sum = 0;
		}

		public void replaceGreaterSum() {
			pair p = new pair();
			replaceGreaterSum(root, p);
		}

		private void replaceGreaterSum(Node node, pair p) {
			if (node == null) {
				return;
			}

			replaceGreaterSum(node.right, p);
			p.sum += node.data;
			node.data = p.sum;
			replaceGreaterSum(node.left, p);

		}

		public void addNode(int data) {
			this.root = addNodeReturnType(this.root, data);
		}

		private Node addNodeReturnType(Node node, int data) {
			if (node == null) {
				Node nnode = new Node();
				nnode.data = data;
				return nnode;
			}
			if (data > node.data) {
				node.right = addNodeReturnType(node.right, data);
			} else if (data < node.data) {
				node.left = addNodeReturnType(node.left, data);
			}

			return node;
		}

		public void removeNode(int data) {
			if (!find(data)) {
				return;
			}

			this.root = removeNode(this.root, data);
		}

		private Node removeNode(Node node, int data) {
			if (node.data > data) {
				node.left = removeNode(node.left, data);
			} else if (node.data < data) {
				node.right = removeNode(node.right, data);
			} else {
				if (node.left == null && node.right == null) {
					return null;
				} else if (node.left == null || node.right == null) {
					return node.left == null ? node.right : node.left;
				} else {

					int max = max(node.left);
					node.data = max;
					node.left = removeNode(node.left, max);
				}
			}
			return node;
		}

	}

}
