package Dec16_to_20_Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import Dec16_to_20_Graphs.GenericHeap;

public class Graph {

	protected class Vertex {
		protected HashMap<String, Integer> nbrs = new HashMap<String, Integer>();
	}

	protected HashMap<String, Vertex> vces = new HashMap<>();

	public int numVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {

		return vces.containsKey(vname);

	}

	public void addVertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}

		Vertex nv = new Vertex();
		this.vces.put(vname, nv);
	}

	public void removeVertex(String vname) {
		Vertex vtx = vces.get(vname);
		ArrayList<String> vtxs = new ArrayList<>(vtx.nbrs.keySet());
		for (String str : vtxs) {
			Vertex search = vces.get(str);
			if (search.nbrs.containsKey(vname)) {
				search.nbrs.remove(vname);
			}
		}

		vces.remove(vname);

	}

	public int numEdge() {

		int size = 0;
		ArrayList<String> vnames = new ArrayList<>(this.vces.keySet());
		for (String vname : vnames) {
			size += vces.get(vname).nbrs.size();
		}
		return size / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		Vertex vtx1 = this.vces.get(v1name);
		Vertex vtx2 = this.vces.get(v2name);
		if (vtx1 == null || vtx2 == null) {
			return false;
		}

		return vtx1.nbrs.containsKey(v2name);

	}

	public void addEdge(String v1name, String v2name, int weight) {
		Vertex vtx1 = this.vces.get(v1name);
		Vertex vtx2 = this.vces.get(v2name);
		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.nbrs.put(v2name, weight);
		vtx2.nbrs.put(v1name, weight);

	}

	public void removeEdge(String v1name, String v2name) {

		Vertex vtx1 = this.vces.get(v1name);
		Vertex vtx2 = this.vces.get(v2name);
		if (vtx1 == null || vtx2 == null) {
			return;
		}
		vtx1.nbrs.remove(v2name);
		vtx2.nbrs.remove(v1name);
	}

	public void display() {
		ArrayList<String> key = new ArrayList<>(this.vces.keySet());

		String ans = "";
		for (String keys : key) {
			ans = keys + "=>";
			Vertex nbrname = vces.get(keys);
			ArrayList<String> nbs = new ArrayList<>(nbrname.nbrs.keySet());
			for (String nb : nbs) {
				ans += nb + (nbrname.nbrs.get(nb)) + ",";
			}

			ans += ".";
			System.out.println(ans);

		}
	}

	public boolean hasPath(String v1name, String v2name) {
		return hasPath(v1name, v2name, new HashMap<String, Boolean>());
	}

	private boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> isdone) {
		if (isdone.containsKey(v1name)) {
			return false;
		}
		isdone.put(v1name, true);
		if (this.containsEdge(v1name, v2name)) {
			return true;
		}

		Vertex vtx = this.vces.get(v1name);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			boolean result = hasPath(key, v2name, isdone);
			if (result == true) {
				return true;
			}

		}

		return false;
	}

	public void haspathDisplay(String v1name, String v2name) {
		haspathDisplay(v1name, v2name, new HashMap<String, Boolean>(), v1name);
		System.out.println();
	}

	private boolean haspathDisplay(String v1name, String v2name, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(v1name)) {
			return false;
		}
		isdone.put(v1name, true);
		if (this.containsEdge(v1name, v2name)) {
			System.out.println(psf + "=>" + v2name);
			return true;
		}

		Vertex vtx = this.vces.get(v1name);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			boolean result = haspathDisplay(key, v2name, isdone, psf + "=>" + key);
			if (result == true) {
				return true;
			}

		}
		return false;
	}

	public void haspathDisplayall(String v1name, String v2name) {
		haspathDisplayall(v1name, v2name, new HashMap<String, Boolean>(), v1name);
		System.out.println();
	}

	private void haspathDisplayall(String v1name, String v2name, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(v1name)) {
			return;
		}
		isdone.put(v1name, true);
		if (v1name.equals(v2name)) {
			System.out.println(psf);
			isdone.remove(v2name);
			return;
		}

		Vertex vtx = this.vces.get(v1name);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			haspathDisplayall(key, v2name, isdone, psf + "=>" + key);
		}

		isdone.remove(v1name);
	}

	public void preOderDisplay(String vname) {
		preOderDisplay(vname, new HashMap<String, Boolean>(), vname);
		System.out.println();
	}

	private void preOderDisplay(String vname, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(vname)) {
			return;
		}

		isdone.put(vname, true);
		System.out.println(vname + "via" + psf);

		Vertex vtx = this.vces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			preOderDisplay(key, isdone, psf + key);

		}

		isdone.remove(vname);

	}

	public void postOderDisplay(String vname) {
		postOderDisplay(vname, new HashMap<String, Boolean>(), vname);
		System.out.println();
	}

	private void postOderDisplay(String vname, HashMap<String, Boolean> isdone, String psf) {
		if (isdone.containsKey(vname)) {
			return;
		}

		isdone.put(vname, true);

		Vertex vtx = this.vces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) {
			postOderDisplay(key, isdone, psf + key);

		}
		isdone.remove(vname);
		System.out.println(vname + "via" + psf);

	}

	private class pair {
		private String vname;
		private String psf;

		pair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}

		pair() {

		}
	}

	public boolean BFSIrr(String v1name, String v2name) {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<pair> que = new LinkedList<Graph.pair>();
		pair rp = new pair(); // removed_Pair.
		rp.vname = v1name;
		rp.psf = v1name;
		que.addLast(rp);

		while (!que.isEmpty()) {

			// dequeue_and_Marked.
			pair process = que.removeFirst();

			isdone.put(process.vname, true);

			// Search.
			Vertex vtx = this.vces.get(process.vname);
			System.out.println(process.vname + " via " + process.psf);
			if (this.containsEdge(process.vname, v2name)) {
				return true;
			}

			ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

			for (String key : keys) {
				// Checked_marked_or_not_and_enqueue.
				if (!isdone.containsKey(key)) {
					pair nbrp = new pair(); // nbr_pair
					nbrp.vname = key;
					nbrp.psf = process.psf + key;
					que.addLast(nbrp);
				}
			}
		}
		return false;

	}

	public boolean DFSIrr(String v1name, String v2name) {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<pair> stack = new LinkedList<Graph.pair>();
		pair rp = new pair(); // removed_Pair.
		rp.vname = v1name;
		rp.psf = v1name;
		stack.addFirst(rp);

		while (!stack.isEmpty()) {

			// dequeue_and_Marked.
			pair process = stack.removeFirst();
			isdone.put(process.vname, true);

			// Search.
			Vertex vtx = this.vces.get(process.vname);
			System.out.println(process.vname + " via " + process.psf);
			if (this.containsEdge(process.vname, v2name)) {
				return true;
			}

			ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

			for (String key : keys) {
				// Checked_marked_or_not_and_enqueue.
				if (!isdone.containsKey(key)) {
					pair nbrp = new pair(); // nbr_pair
					nbrp.vname = key;
					nbrp.psf = process.psf + key;
					stack.addFirst(nbrp);
				}
			}
		}
		return false;
	}

	public void BFT() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<pair> que = new LinkedList<Graph.pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			pair rp = new pair();
			rp.vname = vname;
			rp.psf = vname;
			que.addLast(rp);
			while (!que.isEmpty()) {
				pair proccess = que.removeFirst();
				isdone.put(proccess.vname, true);

				Vertex vtx = this.vces.get(proccess.vname);
				System.out.println(proccess.vname + " via " + proccess.psf);
				ArrayList<String> keys = new ArrayList<String>(vtx.nbrs.keySet());
				for (String key : keys) {
					if (!isdone.containsKey(key)) {
						pair nbrp = new pair(); // nbr_pair
						nbrp.vname = key;
						nbrp.psf = proccess.psf + key;
						que.addLast(nbrp);

					}

				}
			}
		}

	}

	public void DFT() {
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<pair> stack = new LinkedList<Graph.pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			pair rp = new pair();
			rp.vname = vname;
			rp.psf = vname;
			stack.addFirst(rp);
			while (!stack.isEmpty()) {
				pair proccess = stack.removeFirst();
				isdone.put(proccess.vname, true);

				Vertex vtx = this.vces.get(proccess.vname);
				System.out.println(proccess.vname + " via " + proccess.psf);
				ArrayList<String> keys = new ArrayList<String>(vtx.nbrs.keySet());
				for (String key : keys) {
					if (!isdone.containsKey(key)) {
						pair nbrp = new pair(); // nbr_pair
						nbrp.vname = key;
						nbrp.psf = proccess.psf + key;
						stack.addFirst(nbrp);

					}

				}
			}
		}

	}

	public boolean IsConnected() {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		int count = 0;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (proccesed.containsKey(vname)) {
				continue;
			}
			count++;
			pair rootpair = new pair(vname, vname);
			queue.addLast(rootpair);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst(); // removePair

				if (proccesed.containsKey(rp.vname)) {
					continue;
				}
				proccesed.put(rp.vname, true);

				System.out.println(rp.vname + " Via " + rp.psf);

				ArrayList<String> nbrnames = new ArrayList<>(this.vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!proccesed.containsKey(nbrname)) {
						pair ap = new pair(nbrname, rp.psf + nbrname);
						queue.addLast(ap);
					}
				}

			}

		}

		return count > 1;

	}

	public boolean IsCyclic() {
		HashMap<String, Boolean> isdone = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			pair rootpair = new pair(vname, vname);
			queue.addLast(rootpair);
			while (!queue.isEmpty()) {
				pair rp = queue.removeFirst(); // removePair

				if (isdone.containsKey(rp.vname)) {
					return true;
				}
				isdone.put(rp.vname, true);

				System.out.println(rp.vname + " Via " + rp.psf);

				ArrayList<String> nbrnames = new ArrayList<>(this.vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!isdone.containsKey(nbrname)) {
						pair ap = new pair(nbrname, rp.psf + nbrname);
						queue.addLast(ap);
					}
				}

			}
		}

		return true;

	}

	public boolean IsTree() {
		if (IsConnected() == true && IsCyclic() == false) {
			return true;
		}
		return false;
	}

	private class paibip {

		private String vname;
		private String color;

		public paibip(String vname, String color) {
			this.vname = vname;
			this.color = color;
		}

	}

	public boolean bipartite() {

		HashMap<String, String> isdone = new HashMap<String, String>();
		LinkedList<paibip> que = new LinkedList<Graph.paibip>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			paibip rp = new paibip(vname, "R");
			que.addLast(rp); // enqueue.

			while (!que.isEmpty()) {

				paibip proccess = que.removeFirst();
				if (isdone.containsKey(proccess.vname)) {
					String prevColor = isdone.get(proccess.vname);
					String currColor = proccess.color;
					if (!prevColor.equals(currColor)) {
						return false;
					}
					continue;
				}

				isdone.put(proccess.vname, proccess.color); // Marking.

				ArrayList<String> nbrnames = new ArrayList<>(this.vces.get(proccess.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!isdone.containsKey(nbrname)) {
						if (proccess.color.equals("R")) {
							paibip np = new paibip(nbrname, "G");
							que.addLast(np);
						} else {
							paibip np = new paibip(nbrname, "R");
							que.addLast(np);
						}
					}
				}

			}

		}
		return true;
	}

	public void GCC() { // Get_Connected_components.
		HashMap<String, Boolean> isdone = new HashMap<String, Boolean>();
		LinkedList<pair> que = new LinkedList<Graph.pair>();
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		ArrayList<String> ans = new ArrayList<String>();

		for (String vname : vnames) {
			if (isdone.containsKey(vname)) {
				continue;
			}

			String str = new String();

			pair rp = new pair(); // removed_Pair.
			rp.vname = vname;
			que.addLast(rp);

			while (!que.isEmpty()) {

				// dequeue_and_Marked.
				pair process = que.removeFirst();

				if (isdone.containsKey(process.vname)) {
					continue;
				}
				isdone.put(process.vname, true);

				str += process.vname;

				Vertex vtx = this.vces.get(process.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					// Checked_marked_or_not_and_enqueue.
					if (!isdone.containsKey(key)) {
						pair nbrp = new pair(); // nbr_pair
						nbrp.vname = key;
						que.addLast(nbrp);
					}
				}
			}

			ans.add(str);

		}
		System.out.println(ans);

	}

	// Dijkstra---------------------------------------------------------------------------------------------------------------------------

	private class DijkstraPair implements Comparable<DijkstraPair> {
		private String vname;
		private String psf;
		private int csf;

		@Override
		public int compareTo(DijkstraPair o) {

			return this.csf - o.csf;
		}

		@Override
		public String toString() {
			return "[" + psf + "@" + csf + "]";
		}

	}

	public HashMap<String, DijkstraPair> DijkstraPair(String srcvname) {
		HashMap<String, DijkstraPair> map = new HashMap<String, DijkstraPair>();
		PriorityQueue<DijkstraPair> heap = new PriorityQueue<DijkstraPair>();

		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());

		for (String vname : vnames) {
			DijkstraPair rp = new DijkstraPair();
			rp.vname = vname;
			rp.psf = "";
			rp.csf = Integer.MAX_VALUE;
			if (vname.equals(srcvname)) {
				rp.vname = srcvname;
				rp.csf = 0;
				rp.psf = srcvname;
			}

			heap.add(rp);
			map.put(vname, rp);
		}

		while (!heap.isEmpty()) {
			DijkstraPair proccess = heap.remove();

			ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
			for (String key : keys) {
				DijkstraPair np = map.get(key);
				int oldcost = np.csf;
				int newcost = proccess.csf + this.vces.get(key).nbrs.get(proccess.vname);

				if (newcost < oldcost) {
					np.vname = key;
					np.psf = proccess.psf + key;
					np.csf = newcost;
					heap.remove(np);
					heap.add(np);
				}

			}
		}

		return map;
	}

	// Prims---------------------------------------------------------------------------------------------------------------------------

	public static class PrimsPair {

		private String vname = "";
		private String avname = null;
		private int csf = Integer.MAX_VALUE;

		private static final PrimsPairComarator ctor = new PrimsPairComarator();

		private static class PrimsPairComarator implements Comparator<PrimsPair> {

			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				return o2.csf - o1.csf;
			}

		}

	}

	public Graph PrimsMST(String srcvname) throws Exception {
		Graph gp = new Graph();
		HashMap<String, PrimsPair> map = new HashMap<String, PrimsPair>();
		GenericHeap<PrimsPair> heap = new GenericHeap<Graph.PrimsPair>(PrimsPair.ctor);

		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());

		for (String vname : vnames) {
			PrimsPair rp = new PrimsPair();
			rp.vname = vname;

			heap.add(rp);
			map.put(vname, rp);
		}

		while (!heap.isEmpty()) {
			PrimsPair proccess = heap.remove();

			gp.addVertex(proccess.vname);
			if (proccess.avname != null) {
				gp.addEdge(proccess.vname, proccess.avname, proccess.csf);
			}

			ArrayList<String> keys = new ArrayList<String>(this.vces.get(proccess.vname).nbrs.keySet());
			for (String key : keys) {
				if (gp.containsVertex(key)) {
					continue;
				}
				PrimsPair np = map.get(key);
				int oldcost = np.csf;
				int newcost = this.vces.get(key).nbrs.get(proccess.vname);

				if (newcost < oldcost) {
					np.vname = key;
					np.avname = proccess.vname;
					np.csf = newcost;
					heap.update(np);
				}

			}
		}

		return gp;
	}

	// Kruskal---------------------------------------------------------------------------------------------------------------------------

	private class Cluster {
		private String vname;
		private Cluster parent;
		private int size;

		Cluster(String vname) {
			this.vname = vname;
			this.parent = this;
			this.size = 1;
		}

		public Cluster find() {
			if (this.parent != this) {
				return this.parent.find();
			} else {
				return this;
			}
		}

		public void merge(Cluster other) {
			if (this.size < other.size) {
				this.parent = other;
				other.size += this.size;
			} else {
				other.parent = this;
				this.size+=other.size;
			}

		}

	}

	private static class KruskalPair {
		private String v1name;
		private String v2name;;
		private int cost;

		private static final KruskalPairComparator ctor = new KruskalPairComparator();

		private static class KruskalPairComparator implements Comparator<KruskalPair> {

			@Override
			public int compare(KruskalPair o1, KruskalPair o2) {
				return o2.cost - o1.cost;
			}

		}
	}

	public Graph Kruskal() throws Exception {
		Graph gp = new Graph();
		HashMap<String, Cluster> partition = new HashMap<String, Graph.Cluster>();
		GenericHeap<KruskalPair> heap = new GenericHeap<KruskalPair>(KruskalPair.ctor);
		ArrayList<String> vnames = new ArrayList<String>(this.vces.keySet());
		for (String vname : vnames) {
			Cluster cluster = new Cluster(vname);
			partition.put(vname, cluster);
			ArrayList<String> keys = new ArrayList<String>(this.vces.get(vname).nbrs.keySet());
			for (String key : keys) {
				if (partition.containsKey(key)) {
					continue;
				}

				KruskalPair kp = new KruskalPair();
				kp.v1name = vname;
				kp.v2name = key;
				kp.cost = this.vces.get(vname).nbrs.get(key);
				heap.add(kp);
			}
		}

		while (gp.numEdge() != this.numVertices() - 1) {

			KruskalPair rp = heap.remove();
			Cluster c1 = partition.get(rp.v1name);
			Cluster c2 = partition.get(rp.v2name);

			Cluster c1Leader = c1.find();
			Cluster c2Leader = c2.find();
			if (c1Leader != c2Leader) {
				c1Leader.merge(c2Leader);
				gp.addVertex(rp.v1name);
				gp.addVertex(rp.v2name);
				gp.addEdge(rp.v1name, rp.v2name, rp.cost);
			}
		}

		return gp;
	}

}
