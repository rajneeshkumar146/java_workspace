package aug12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class Vertex {
		private HashMap<String, Integer> nbrs = new HashMap<>();
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

	public int numEdges() {
		int rv = 0;

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			Vertex vtx = vces.get(vname);
			rv += vtx.nbrs.size();
		}

		return rv / 2;
	}

	// areNbrs(v1, v2)
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

	public void removeVertex(String vname) {
		Vertex v2r = vces.get(vname);

		ArrayList<String> nbrnames = new ArrayList<>(v2r.nbrs.keySet());
		for (String nbrname : nbrnames) {
			Vertex nbrvtx = vces.get(nbrname);
			nbrvtx.nbrs.remove(vname);
		}

		vces.remove(vname);
	}

	public void display() {
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());

		for (String vname : vnames) {
			String str = vname + " -> ";

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

		if (this.containsEdge(v1name, v2name) == true) {
			System.out.println(psf + v2name);
			return true;
		}

		Vertex vtx1 = vces.get(v1name);
		ArrayList<String> nbrnames = new ArrayList<>(vtx1.nbrs.keySet());

		boolean mr = false;
		for (String nbrname : nbrnames) {
			boolean rr = this.hasPathHelper(nbrname, v2name, processed, psf + nbrname);

			if (rr == true) {
				mr = true;
			}
		}

		return mr;
	}

	public boolean bfs(String v1name, String v2name) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Pair p = new Pair(v1name, v1name);
		queue.addLast(p);

		while (queue.size() != 0) {
			// 1. Remove and print
			Pair rp = queue.removeFirst();
			System.out.println(rp.vname + " via " + rp.psf);

			// 2. check if processed, mark if not
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			// 3. check
			if (this.containsEdge(rp.vname, v2name)) {
				return true;
			}

			// 4. add the unprocessed nbrs back
			ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
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
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		Pair p = new Pair(v1name, v1name);
		stack.addFirst(p);

		while (stack.size() != 0) {
			// 1. Remove and print
			Pair rp = stack.removeFirst();
			System.out.println(rp.vname + " via " + rp.psf);

			// 2. check if processed, mark if not
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			// 3. check
			if (this.containsEdge(rp.vname, v2name)) {
				return true;
			}

			// 4. add the unprocessed nbrs back
			ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!processed.containsKey(nbrname)) {
					Pair np = new Pair(nbrname, rp.psf + nbrname);
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public void dft() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if(processed.containsKey(vname)){
				continue;
			}
			
			Pair p = new Pair(vname, vname);
			stack.addFirst(p);
			
			while (stack.size() != 0) {
				// 1. Remove and print
				Pair rp = stack.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						stack.addFirst(np);
					}
				}
			} 
		}
	}
	
	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if(processed.containsKey(vname)){
				continue;
			}
			
			Pair p = new Pair(vname, vname);
			queue.addLast(p);
			
			while (queue.size() != 0) {
				// 1. Remove and print
				Pair rp = queue.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						queue.addLast(np);
					}
				}
			} 
		}
	}
	
	private class Pair {
		String vname;
		String psf;

		Pair(String vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}
	}

	public boolean IsConnected(){
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		int counter = 0;
		
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if(processed.containsKey(vname)){
				continue;
			}
			
			counter++;
			if(counter == 2){
				return false;
			}
			
			Pair p = new Pair(vname, vname);
			queue.addLast(p);
			
			while (queue.size() != 0) {
				// 1. Remove and print
				Pair rp = queue.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						queue.addLast(np);
					}
				}
			} 
		}
		
		return true;
	}
	
	public boolean IsCyclic(){
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if(processed.containsKey(vname)){
				continue;
			}
			
			Pair p = new Pair(vname, vname);
			stack.addFirst(p);
			
			while (stack.size() != 0) {
				// 1. Remove and print
				Pair rp = stack.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " via " + rp.psf);

				// 4. add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						stack.addFirst(np);
					}
				}
			} 
		}
		
		return false;
	}
	
	public boolean IsTree(){
		return this.IsConnected() && this.IsCyclic() == false;
	}
	
	public ArrayList<String> gcc(){
		ArrayList<String> rv = new ArrayList<>();
		
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname: vnames) {
			if(processed.containsKey(vname)){
				continue;
			}
			
			Pair p = new Pair(vname, vname);
			queue.addLast(p);
			
			String comp = "";
			while (queue.size() != 0) {
				// 1. Remove and print
				Pair rp = queue.removeFirst();

				// 2. check if processed, mark if not
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				
				comp += rp.vname;

				// 4. add the unprocessed nbrs back
				ArrayList<String> nbrnames = new ArrayList<>(vces.get(rp.vname).nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!processed.containsKey(nbrname)) {
						Pair np = new Pair(nbrname, rp.psf + nbrname);
						queue.addLast(np);
					}
				}
			}
			
			rv.add(comp);
		}
		
		return rv;
	}
}
