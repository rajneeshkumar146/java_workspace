package aug1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

import july6.P;

public class Graph {
	private HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (containsVertex(vname)) {
			return;
		}

		vces.put(vname, new HashMap<>());
	}

	public void removeVertex(String vname) {
		if (!containsVertex(vname)) {
			return;
		}

		for (String nbrname : vces.get(vname).keySet()) {
			vces.get(nbrname).remove(vname);
		}
		vces.remove(vname);
	}

	public int countEdges() {
		int edges = 0;

		for (String vname : vces.keySet()) {
			edges += vces.get(vname).size();
		}

		return edges / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		if (!containsVertex(v1name) || !containsVertex(v2name)) {
			return false;
		}

		return vces.get(v1name).containsKey(v2name) && vces.get(v2name).containsKey(v1name);
	}

	public void addEdge(String v1name, String v2name, int weight) {
		if (containsEdge(v1name, v2name)) {
			return;
		}

		vces.get(v1name).put(v2name, weight);
		vces.get(v2name).put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		if (!containsEdge(v1name, v2name)) {
			return;
		}

		vces.get(v1name).remove(v2name);
		vces.get(v2name).remove(v1name);
	}

	public void display() {
		for (String vname : vces.keySet()) {
			System.out.println(vname + " -> " + vces.get(vname));
		}
	}

	public boolean hasPath(String src, String dest) {
		return hasPathHelper(src, dest, new HashSet<>());
	}

	private boolean hasPathHelper(String src, String dest, HashSet<String> visited) {
		if (containsEdge(src, dest)) {
			return true;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				boolean hpfn2d = hasPathHelper(nbr, dest, visited);
				if (hpfn2d) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPaths(String src, String dest) {
		printAllPaths(src, dest, src, new HashSet<>());
	}

	private void printAllPaths(String src, String dest, String psf, HashSet<String> visited) {
		if (src.equals(dest)) {
			System.out.println(psf);
			return;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				printAllPaths(nbr, dest, psf + nbr, visited);
			}
		}

		visited.remove(src);
	}

	public void printShortestPath1(String src, String dest) {
		// printShortestPath1(src, dest, new HashSet<>(), src, 0);
		// System.out.println(sp + "@" + spc);
		Pair mp = getShortestPath(src, dest, new HashSet<>());
		System.out.println(mp.path + "@" + mp.cost);
	}

	static String sp = "";
	static int spc = Integer.MAX_VALUE;

	private void printShortestPath1(String src, String dest, HashSet<String> visited, String psf, int csf) {
		if (src.equals(dest)) {
			if (csf < spc) {
				sp = psf;
				spc = csf;
			}
			return;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				printShortestPath1(nbr, dest, visited, psf + nbr, csf + vces.get(src).get(nbr));
			}
		}

		visited.remove(src);
	}

	class Pair implements Comparable<Pair> {
		int cost = Integer.MAX_VALUE;
		String path = "";

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	private Pair getShortestPath(String src, String dest, HashSet<String> visited) {
		if (src.equals(dest)) {
			Pair bp = new Pair();

			bp.cost = 0;
			bp.path = dest;

			return bp;
		}

		Pair mp = new Pair();
		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (!visited.contains(nbr)) {
				Pair np = getShortestPath(nbr, dest, visited);

				if (np.path.length() > 0 && vces.get(src).get(nbr) + np.cost < mp.cost) {
					mp.cost = vces.get(src).get(nbr) + np.cost;
					mp.path = src + np.path;
				}
			}
		}

		visited.remove(src);
		return mp;
	}

	// shortest, largest, just larger, kth largest
	class HeapMover {
		String sp = null;
		int spc = Integer.MAX_VALUE;
		String lp = null;
		int lpc = Integer.MIN_VALUE;
		String jlp = null;
		int jlc = Integer.MAX_VALUE;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
	}

	public void multisolver(String src, String dest, int k, int jlw) {
		HeapMover mover = new HeapMover();
		multisolver(src, dest, k, jlw, src, 0, new HashSet<>(), mover);

		System.out.println(mover.sp + "@" + mover.spc);
		System.out.println(mover.lp + "@" + mover.lpc);
		System.out.println(mover.jlp + "@" + mover.jlc);
		System.out.println(mover.pq.peek().path + "@" + mover.pq.peek().cost);
	}

	private void multisolver(String src, String dest, int k, int jlw, String psf, int csf, HashSet<String> visited,
			HeapMover mover) {
		if (src.equals(dest)) {
			System.out.println("Debug. " + psf + "@" + csf);
			if (csf < mover.spc) {
				mover.spc = csf;
				mover.sp = psf;
			}

			if (csf > mover.lpc) {
				mover.lpc = csf;
				mover.lp = psf;
			}

			if (csf > jlw) {
				if (csf < mover.jlc) {
					mover.jlc = csf;
					mover.jlp = psf;
				}
			}

			if (mover.pq.size() < k) {
				Pair p = new Pair();
				p.path = psf;
				p.cost = csf;
				mover.pq.add(p);
			} else if (csf > mover.pq.peek().cost) {
				mover.pq.remove();
				Pair p = new Pair();
				p.path = psf;
				p.cost = csf;
				mover.pq.add(p);
			}

			return;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				multisolver(nbr, dest, k, jlw, psf + nbr, csf + vces.get(src).get(nbr), visited, mover);
			}
		}

		visited.remove(src);
	}

	private class TPair {
		String vname;
		String psf;
		String color;

		public TPair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}

		public TPair(String vname, String psf, String color) {
			this(vname, psf);
			this.color = color;
		}
	}

	public boolean bfs(String src, String dest) {
		LinkedList<TPair> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();

		queue.addLast(new TPair(src, src));

		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2'. check in visited
			visited.add(rp.vname);

			// 2. work
			System.out.println(rp.vname + " " + rp.psf);
			if (rp.vname.equals(dest)) {
				return true;
			}

			// 3. add unvisited neighbors
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return false;
	}

	public boolean dfs(String src, String dest) {
		LinkedList<TPair> stack = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();

		stack.addFirst(new TPair(src, src));

		while (stack.size() > 0) {
			// 1. remove
			TPair rp = stack.removeFirst();

			// 2'. check in visited
			visited.add(rp.vname);

			// 2. work
			System.out.println(rp.vname + " " + rp.psf);
			if (rp.vname.equals(dest)) {
				return true;
			}

			// 3. add unvisited neighbors
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					stack.addFirst(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return false;
	}

	public void bft() {
		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				bftComponent(vname, visited);
			}
		}
	}

	public void bftComponent(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();

		queue.add(new TPair(src, src));
		System.out.println("Component for " + src);
		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. check and mark visited
			if (visited.contains(rp.vname)) {
				continue;
			}
			visited.add(rp.vname);

			// 2`. work - print
			System.out.println(rp.vname + " via " + rp.psf);

			// 3. add unvisited nbrs
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}
	}

	public void dft() {
		HashSet<String> visited = new HashSet<>();
		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				dftComponent(vname, vname, visited);
			}
		}
	}

	private void dftComponent(String src, String psf, HashSet<String> visited) {
		visited.add(src);
		System.out.println(src + " " + psf);
		for (String nbr : vces.get(src).keySet()) {
			if (visited.contains(nbr) == false) {
				dftComponent(nbr, psf + nbr, visited);
			}
		}
		// visited.remove(src);
	}

	public boolean IsConnected() {
		HashSet<String> visited = new HashSet<>();
		ArrayList<String> vtxes = new ArrayList<>(vces.keySet());
		bftComponent(vtxes.get(0), visited);
		return visited.size() == vces.size();
	}

	public boolean IsCyclic() {
		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				boolean res = IsCyclic(vname, visited);
				if (res == true) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean IsCyclic(String src, HashSet<String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();

		queue.add(new TPair(src, src));
		// System.out.println("Component for " + src);
		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. check and mark visited
			if (visited.contains(rp.vname)) {
				return true;
			}
			visited.add(rp.vname);

			// 2`. work - print
			// System.out.println(rp.vname + " via " + rp.psf);

			// 3. add unvisited nbrs
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return false;
	}

	public ArrayList<String> gcc() {
		ArrayList<String> components = new ArrayList<>();

		HashSet<String> visited = new HashSet<>();

		for (String vname : vces.keySet()) {
			if (visited.contains(vname) == false) {
				String comp = gccComponent(vname, visited);
				components.add(comp);
			}
		}

		return components;
	}

	private String gccComponent(String src, HashSet<String> visited) {
		String comp = "";

		LinkedList<TPair> queue = new LinkedList<>();

		queue.add(new TPair(src, src));
		// System.out.println("Component for " + src);
		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. check and mark visited
			if (visited.contains(rp.vname)) {
				continue;
			}
			visited.add(rp.vname);

			// 2`. work - print
			// System.out.println(rp.vname + " via " + rp.psf);
			comp += rp.vname;

			// 3. add unvisited nbrs
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (visited.contains(nbr) == false) {
					queue.addLast(new TPair(nbr, rp.psf + nbr));
				}
			}
		}

		return comp;
	}

	// is tree => isconnected == true && iscyclic == false

	public boolean IsBipartite() {
		HashMap<String, String> visited = new HashMap<>();

		for (String vname : vces.keySet()) {
			if (visited.containsKey(vname) == false) {
				boolean isbipartite = IsBipartiteComponent(vname, visited);
				if (isbipartite == false) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean IsBipartiteComponent(String src, HashMap<String, String> visited) {
		LinkedList<TPair> queue = new LinkedList<>();

		queue.addLast(new TPair(src, src, "red"));
		while (queue.size() > 0) {
			// 1. remove
			TPair rp = queue.removeFirst();

			// 2. visited
			if (visited.containsKey(rp.vname)) {
				String oldcolor = visited.get(rp.vname);
				String newcolor = rp.color;

				if (!newcolor.equals(oldcolor)) {
					return false;
				}
			}
			visited.put(rp.vname, rp.color);

			// 4. nbrs
			for (String nbr : vces.get(rp.vname).keySet()) {
				if (!visited.containsKey(nbr)) {
					queue.addLast(new TPair(nbr, rp.psf + nbr, rp.color.equals("red") ? "green" : "red"));
				}
			}
		}

		return true;
	}

	public void djikstra(String src) {
		PriorityQueue<DPair> pq = new PriorityQueue<>(Collections.reverseOrder());
		HashMap<String, DPair> res = new HashMap<>();
		HashSet<String> visited = new HashSet<>();

		DPair srcp = new DPair(src, src, 0);
		pq.add(srcp);
		res.put(src, srcp);

		for (String vname : vces.keySet()) {
			if (!src.equals(vname)) {
				DPair p = new DPair(vname, "", Integer.MAX_VALUE);
				res.put(vname, p);
			}
		}

		while (pq.size() > 0) {
			// 1. remove
			DPair rp = pq.remove();

			// 2. handle visited
			if (visited.contains(rp.vname)) {
				continue;
			}
			visited.add(rp.vname);

			// 3. univisted nbrs
			for (String nbrname : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbrname)) {
					int nbrcost = rp.csf + vces.get(rp.vname).get(nbrname);
					String nbrpsf = rp.psf + nbrname;

					int oldnbrcost = res.get(nbrname).csf;
					if (nbrcost < oldnbrcost) {
						DPair np = new DPair(nbrname, nbrpsf, nbrcost);
						res.put(nbrname, np);
						pq.add(np);
					}
				}
			}
		}

		System.out.println(res);
	}

	private static class DPair implements Comparable<DPair> {
		String vname;
		String psf;
		int csf;

		DPair(String vname, String psf, int csf) {
			this.vname = vname;
			this.psf = psf;
			this.csf = csf;
		}

		@Override
		public int compareTo(DPair o) {
			return o.csf - this.csf;
		}

		public String toString() {
			return this.vname + "@" + this.psf + "_" + this.csf;
		}
	}

	public Graph prims() {
		Graph mst = new Graph();

		PriorityQueue<PPair> pq = new PriorityQueue<>(Collections.reverseOrder());
		HashMap<String, PPair> res = new HashMap<>();
		HashSet<String> visited = new HashSet<>();

		String src = vces.keySet().iterator().next();

		PPair srcp = new PPair(src, null, 0);
		pq.add(srcp);
		res.put(src, srcp);

		for (String vname : vces.keySet()) {
			if (!src.equals(vname)) {
				PPair p = new PPair(vname, "", Integer.MAX_VALUE);
				res.put(vname, p);
			}
		}

		while (pq.size() > 0) {
			// 1. remove
			PPair rp = pq.remove();

			// 2. handle visited
			if (visited.contains(rp.vname)) {
				continue;
			}
			visited.add(rp.vname);

			// 2`. work
			mst.addVertex(rp.vname);
			if (rp.pname != null) {
				mst.addVertex(rp.pname);
				mst.addEdge(rp.vname, rp.pname, rp.csf);
			}

			// 3. univisted nbrs
			for (String nbrname : vces.get(rp.vname).keySet()) {
				if (!visited.contains(nbrname)) {
					int nbrcost = vces.get(rp.vname).get(nbrname);
					String pname = rp.vname;

					int oldnbrcost = res.get(nbrname).csf;
					if (nbrcost < oldnbrcost) {
						PPair np = new PPair(nbrname, pname, nbrcost);
						res.put(nbrname, np);
						pq.add(np);
					}
				}
			}
		}

		return mst;
	}

	private static class PPair implements Comparable<PPair> {
		String vname;
		String pname;
		int csf;

		PPair(String vname, String pname, int csf) {
			this.vname = vname;
			this.pname = pname;
			this.csf = csf;
		}

		@Override
		public int compareTo(PPair o) {
			return o.csf - this.csf;
		}

		public String toString() {
			return this.vname + "@" + this.pname + "_" + this.csf;
		}
	}
}