package aug12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vces = new HashMap<>();

	public int numVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (this.containsVertex(vname)) {
			return;
		}

		Vertex vtx = new Vertex();
		vces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		if (!this.containsVertex(vname)) {
			return;
		}

		Vertex vtx = vces.get(vname);
		ArrayList<String> nbrnames = new ArrayList<>(vtx.nbrs.keySet());
		for (String nbrname : nbrnames) {
			Vertex nbrvtx = vces.get(nbrname);
			nbrvtx.nbrs.remove(vname);
		}

		vces.remove(vname);
	}

	public int numEdges() {
		int rv = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			Vertex vtx = vces.get(vname);
			rv += vtx.nbrs.size();
		}

		return rv / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {
		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(v2name) == false) {
			return false;
		}

		return true;
	}

	public void addEdge(String v1name, String v2name, int weight) {
		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.nbrs.put(v2name, weight);
		vtx2.nbrs.put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		Vertex vtx1 = vces.get(v1name);
		Vertex vtx2 = vces.get(v2name);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(v2name) == false) {
			return;
		}

		vtx1.nbrs.remove(v2name);
		vtx2.nbrs.remove(v1name);
	}

	public void display() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			String str = vname + " => ";
			Vertex vtx = vces.get(vname);

			ArrayList<String> nbrnames = new ArrayList<>(vtx.nbrs.keySet());
			for (String nbrname : nbrnames) {
				str += nbrname + "[" + vtx.nbrs.get(nbrname) + "], ";
			}

			System.out.println(str + ".");
		}
	}

	public boolean hasPath(String v1name, String v2name) {
		return hasPathHelper(v1name, v2name, new HashMap<>(), v1name);
	}

	private boolean hasPathHelper(String v1name, String v2name, HashMap<String, Boolean> processed, String psf) {
		if (processed.containsKey(v1name) == true) {
			return false;
		}
		processed.put(v1name, true);

		if (this.containsEdge(v1name, v2name) == true) { // if they are nbrs we
															// found a path
			System.out.println(psf + v2name);
			return true;
		}

		Vertex vtx1 = vces.get(v1name);
		ArrayList<String> nbrnames = new ArrayList<>(vtx1.nbrs.keySet());

		for (String nbrname : nbrnames) {
			if (this.hasPathHelper(nbrname, v2name, processed, psf + nbrname) == true) {
				return true;
			}
		}

		return false;
	}

	public boolean bfs(String v1name, String v2name) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		Pair rootpair = new Pair(v1name, v1name);
		queue.addLast(rootpair);

		while (queue.size() != 0) {
			// 1. removeFirst
			Pair rp = queue.removeFirst();

			// 2. check if processed, mark if not
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			// 3. Check, if an edge is found
			System.out.println(rp.vname + " via " + rp.psf);
			if (this.containsEdge(rp.vname, v2name) == true) {
				return true;
			}

			// 4. Add the unprocessed nbrs back
			ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair np = new Pair(nbrname, rp.psf + nbrname);
					queue.addLast(np);
				}
			}
		}

		return false;
	}

	public boolean dfs(String v1name, String v2name) {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		Pair rootpair = new Pair(v1name, v1name);
		stack.addFirst(rootpair);

		while (stack.size() != 0) {
			// 1. removeFirst
			Pair rp = stack.removeFirst();

			// 2. check if processed, mark if not
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			// 3. Check, if an edge is found
			System.out.println(rp.vname + " via " + rp.psf);
			if (this.containsEdge(rp.vname, v2name) == true) {
				return true;
			}

			// 4. Add the unprocessed nbrs back
			ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair np = new Pair(nbrname, rp.psf + nbrname);
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			
			Pair rootpair = new Pair(vname, vname);
			queue.addLast(rootpair);
			while (queue.size() != 0) {
				// 1. removeFirst
				Pair rp = queue.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// 3. Check, if an edge is found
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. Add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						queue.addLast(np);
					}
				}
			} 
		}
	}

	public void dft() {
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			
			Pair rootpair = new Pair(vname, vname);
			stack.addFirst(rootpair);
			while (stack.size() != 0) {
				// 1. removeFirst
				Pair rp = stack.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// 3. Check, if an edge is found
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. Add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						stack.addFirst(np);
					}
				}
			} 
		}
	}
	
	private class Pair {
		String vname;
		Vertex vtx;
		String psf;

		Pair(String vname, String psf) {
			this.vname = vname;
			this.vtx = vces.get(vname);
			this.psf = psf;
		}
	}

	public boolean IsConnected(){
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		int counter = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			
			counter++;
			Pair rootpair = new Pair(vname, vname);
			queue.addLast(rootpair);
			while (queue.size() != 0) {
				// 1. removeFirst
				Pair rp = queue.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// 3. Check, if an edge is found
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. Add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						queue.addLast(np);
					}
				}
			} 
		}
		
		return counter == 1;
	}

	public boolean IsCyclic(){
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if (processed.containsKey(vname)) {
				continue;
			}
			
			Pair rootpair = new Pair(vname, vname);
			queue.addLast(rootpair);
			while (queue.size() != 0) {
				// 1. removeFirst
				Pair rp = queue.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					System.out.println(rp.vname + " via " + rp.psf);
					return true;
				}
				processed.put(rp.vname, true);

				// 3. Check, if an edge is found
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. Add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						queue.addLast(np);
					}
				}
			} 
		}
		
		return false;
	}

	public boolean IsTree(){
		return this.IsConnected() && !this.IsCyclic();
	}
}
