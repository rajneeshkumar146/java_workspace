package Class_29th_Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import Class_26th_Generics_Overloading_HuffmenEncoder.GenericHeap;

public class Graphs {

	private class vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private static final String Djicompatator = null;

	HashMap<String, vertex> vces = new HashMap<>();

	public int numvertex() {
		return vces.size();
	}

	public boolean containVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addvertex(String vname) {
		if (vces.containsKey(vname)) {
			return;
		}

		vertex nnbrs = new vertex(); // nnbrs=new_nbrs
		vces.put(vname, nnbrs);

	}

	public void removeVertex(String vname) {
		if (!this.containVertex(vname)) {
			return;
		}
		vertex vtx = vces.get(vname);
		ArrayList<String> nbrnames = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbrname : nbrnames) {
			vertex nbrvtx = vces.get(nbrname);
			nbrvtx.nbrs.remove(vname);
		}

		vces.remove(vname);

	}

	public int numEdge() {

		int rv = 0;

		ArrayList<String> key = new ArrayList<>(vces.keySet());

		for (String keys : key) {
			rv += vces.get(keys).nbrs.size();
		}

		return rv / 2;

	}

	public boolean containsEdge(String v1name, String v2name) {
		vertex v1 = vces.get(v1name);
		vertex v2 = vces.get(v2name);

		if (v1 == null || v2 == null || v1.nbrs.containsKey(v2name) == false) {
			return false;
		}

		return true;

	}

	public void addEdge(String v1name, String v2name, int weight) {
		vertex v1 = vces.get(v1name);
		vertex v2 = vces.get(v2name);

		if (v1 == null || v2 == null) {
			return;
		}

		v1.nbrs.put(v2name, weight);
		v2.nbrs.put(v1name, weight);
	}

	public void removeEdge(String v1name, String v2name) {
		vertex v1 = vces.get(v1name);
		vertex v2 = vces.get(v2name);

		if (v1 == null || v2 == null) {
			return;
		}

		v1.nbrs.remove(v2name);
		v2.nbrs.remove(v1name);
	}

	public void display() {
		ArrayList<String> key = new ArrayList<>(this.vces.keySet());

		String ans = "";
		for (String keys : key) {
			ans = keys + "=>";
			vertex nbrname = vces.get(keys);
			ArrayList<String> nbs = new ArrayList<>(nbrname.nbrs.keySet());
			for (String nb : nbs) {
				ans += nb + (nbrname.nbrs.get(nb)) + ",";
			}

			ans += ".";
			System.out.println(ans);

		}

	}

	public boolean haspath(String v1name, String v2name) {
		return helper(v1name, v2name, new HashMap<>());

	}

	private boolean helper(String v1name, String v2name, HashMap<String, Boolean> proccesed) {
		if (proccesed.containsKey(v1name)) {
			return false;
		}

		proccesed.put(v1name, true);

		if (this.containsEdge(v1name, v2name)) {
			return true;
		}

		vertex vtx = vces.get(v1name);
		ArrayList<String> nbrnames = new ArrayList<>(vtx.nbrs.keySet());
		for (String nbrname : nbrnames) {
			if (helper(nbrname, v2name, proccesed) == true)
				return true;
		}

		return false;
	}

	public boolean bfs(String v1name, String v2name) {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair rootpair = new Pair(v1name, vces.get(v1name), v1name);
		queue.addLast(rootpair);

		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst(); // removePair

			if (proccesed.containsKey(rp.vname)) {
				continue;
			}
			proccesed.put(rp.vname, true);

			System.out.println(rp.vname + " Via " + rp.psf);
			if (containsEdge(rp.vname, v2name)) {
				return true;
			}

			ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!proccesed.containsKey(nbrname)) {
					Pair ap = new Pair(nbrname, vces.get(nbrname), rp.psf + nbrname);
					queue.addLast(ap);
				}
			}

		}

		return false;

	}

	public boolean dfs(String v1name, String v2name) {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair rootpair = new Pair(v1name, vces.get(v1name), v1name);
		stack.addFirst(rootpair);

		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst(); // removePair

			if (proccesed.containsKey(rp.vname)) {
				continue;
			}
			proccesed.put(rp.vname, true);

			System.out.println(rp.vname + " Via " + rp.psf);
			if (containsEdge(rp.vname, v2name)) {
				return true;
			}

			ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (!proccesed.containsKey(nbrname)) {
					Pair ap = new Pair(nbrname, vces.get(nbrname), rp.psf + nbrname);
					stack.addFirst(ap);
				}
			}

		}

		return false;

	}

	public void dft() {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (proccesed.containsKey(vname)) {
				continue;
			}

			Pair rootpair = new Pair(vname, vces.get(vname), vname);
			stack.addFirst(rootpair);
			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst(); // removePair

				if (proccesed.containsKey(rp.vname)) {
					continue;
				}
				proccesed.put(rp.vname, true);

				System.out.println(rp.vname + " Via " + rp.psf);

				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!proccesed.containsKey(nbrname)) {
						Pair ap = new Pair(nbrname, vces.get(nbrname), rp.psf + nbrname);
						stack.addFirst(ap);
					}
				}

			}
		}

	}

	public void bft() {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (proccesed.containsKey(vname)) {
				continue;
			}

			Pair rootpair = new Pair(vname, vces.get(vname), vname);
			queue.addLast(rootpair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst(); // removePair

				if (proccesed.containsKey(rp.vname)) {
					continue;
				}
				proccesed.put(rp.vname, true);

				System.out.println(rp.vname + " Via " + rp.psf);

				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!proccesed.containsKey(nbrname)) {
						Pair ap = new Pair(nbrname, vces.get(nbrname), rp.psf + nbrname);
						queue.addLast(ap);
					}
				}

			}
		}

	}

	private class Pair {
		private String vname;
		private vertex vtx;
		private String psf;

		Pair(String vname, vertex vtx, String psf) {
			this.vname = vname;
			this.vtx = vtx;
			this.psf = psf;

		}
	}

	public boolean IsConnected() {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		int count = 0;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (proccesed.containsKey(vname)) {
				continue;
			}
			count++;
			Pair rootpair = new Pair(vname, vces.get(vname), vname);
			queue.addLast(rootpair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst(); // removePair

				if (proccesed.containsKey(rp.vname)) {
					continue;
				}
				proccesed.put(rp.vname, true);

				System.out.println(rp.vname + " Via " + rp.psf);

				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!proccesed.containsKey(nbrname)) {
						Pair ap = new Pair(nbrname, vces.get(nbrname), rp.psf + nbrname);
						queue.addLast(ap);
					}
				}

			}

		}

		return count > 1;

	}

	public boolean IsCyclic() {
		HashMap<String, Boolean> proccesed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (proccesed.containsKey(vname)) {
				continue;
			}

			Pair rootpair = new Pair(vname, vces.get(vname), vname);
			queue.addLast(rootpair);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst(); // removePair

				if (proccesed.containsKey(rp.vname)) {
					return true;
				}
				proccesed.put(rp.vname, true);

				System.out.println(rp.vname + " Via " + rp.psf);

				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!proccesed.containsKey(nbrname)) {
						Pair ap = new Pair(nbrname, vces.get(nbrname), rp.psf + nbrname);
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

	public HashMap<String, DjikstraPair> djikstra(String src) { // src=source
		HashMap<String, DjikstraPair> map = new HashMap<>();
		GenericHeap<DjikstraPair> heap = new GenericHeap<>(DjikstraPair.ctor);

		ArrayList<String> keys = new ArrayList<>(this.vces.keySet());
		for (String key : keys) {
			DjikstraPair ip = new DjikstraPair(key, "", Integer.MAX_VALUE); // ip=intialPair
			if (src.equals(key)) {
				ip.psf = key;
				ip.csf = 0;
			}

			heap.add(ip);
			map.put(key, ip);
		}

		while (heap.size() != 0) {
			DjikstraPair rp = heap.removeHP();
			ArrayList<String> nbrnames = new ArrayList<>(this.vces.get(rp.vname).nbrs.keySet());
			for (String nbrname : nbrnames) {
				int newcost = rp.csf + this.vces.get(rp.vname).nbrs.get(nbrname);
				int oldcost = map.get(nbrname).csf;
				if (newcost < oldcost) {
					DjikstraPair np = map.get(nbrname);
					np.csf = newcost;
					np.psf = rp.psf + nbrname;
					heap.updatePriority(np);
				}

			}
		}

		return map;
	}

	private static class DjikstraPair {
		private String vname;
		private String psf;
		private int csf;

		private static final Djicompatator ctor = new Djicompatator();

		private static class Djicompatator implements Comparator<DjikstraPair> {
			@Override
			public int compare(DjikstraPair o1, DjikstraPair o2) {
				// TODO Auto-generated method stub
				return o2.csf - o1.csf;
			}
		}

		private DjikstraPair(String vname, String psf, int csf) {
			this.vname = vname;
			this.psf = psf;
			this.csf = csf;
		}

		@Override
		public String toString() {
			return this.psf + "@" + this.csf;

		}

	}

	public Graphs PrimsPair(String src) { // src=source
		Graphs gp = new Graphs();
		HashMap<String, PrimsPair> map = new HashMap<>();
		GenericHeap<PrimsPair> heap = new GenericHeap<>(PrimsPair.ctor);

		ArrayList<String> keys = new ArrayList<>(this.vces.keySet());
		for (String key : keys) {

			PrimsPair ip = new PrimsPair(key, null, Integer.MAX_VALUE); // ip=intialPair
			heap.add(ip);
			map.put(key, ip);
		}

		while (heap.size() != 0) {
			PrimsPair rp = heap.removeHP();

			if (rp.avname == null) {
				gp.addvertex(rp.vname);
			} else {
				gp.addvertex(rp.vname);
				gp.addEdge(rp.vname, rp.avname, rp.csf);
			}

			ArrayList<String> nbrnames = new ArrayList<>(this.vces.get(rp.vname).nbrs.keySet());
			for (String nbrname : nbrnames) {
				if (gp.containVertex(nbrname)) {
					continue;
				}

				int newcost = this.vces.get(rp.vname).nbrs.get(nbrname);
				int oldcost = map.get(nbrname).csf;
				if (newcost < oldcost) {
					PrimsPair np = map.get(nbrname);
					np.csf = newcost;
					np.avname = rp.vname;
					heap.updatePriority(np);

				}

			}
		}

		return gp;
	}

	private static class PrimsPair {
		private String vname;
		private String avname; // accuaringVertexNAme
		private int csf;

		private static final PrimsPaircompatator ctor = new PrimsPaircompatator();

		private static class PrimsPaircompatator implements Comparator<PrimsPair> {
			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				// TODO Auto-generated method stub
				return o2.csf - o1.csf;
			}
		}

		private PrimsPair(String vname, String avname, int csf) {
			this.vname = vname;
			this.avname = avname;
			this.csf = csf;
		}

	}

	private class PairBip {
		private String vname;
		private vertex vtx;
		private String color;

		PairBip(String vname, vertex vtx) {
			this.vname = vname;
			this.vtx = vtx;

		}
	}

	public boolean Isbipartite() {
		HashMap<String, String> proccesed = new HashMap<>();
		LinkedList<PairBip> stack = new LinkedList<>();
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		for (String vname : vnames) {
			if (proccesed.containsKey(vname)) {
				continue;
			}

			PairBip rootpair = new PairBip(vname, vces.get(vname));
			rootpair.color = "red";
			stack.addFirst(rootpair);

			while (!stack.isEmpty()) {
				PairBip rp = stack.removeFirst(); // removePair

				if (proccesed.containsKey(rp.vname)) {
					String oldcolor = proccesed.get(vname);
					String newcolor = rp.color;
					if (!oldcolor.equals(newcolor)) {
						return false;
					}
					continue;
				}
				proccesed.put(rp.vname, rp.color);

				ArrayList<String> nbrnames = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbrname : nbrnames) {
					if (!proccesed.containsKey(nbrname)) {
						String tobemark = "";
						PairBip ap = new PairBip(nbrname, vces.get(nbrname)); // addPair
						if (rp.color.equals("red")) {
							ap.color = "green";

						} else {
							ap.color = "red";
						}
						stack.addFirst(ap);
					}
				}

			}
		}
		return true;

	}

	
	
}
