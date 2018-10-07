package RandomQuestions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RoadConnectivityProject {

	private static Scanner scn = new Scanner(System.in);

	private static int srcVertex = -1;

	private static class Node {
		int BuildTime = 0;
		int TraverseTime = 0;

		public Node(int BT, int TT) {
			this.BuildTime = BT;
			this.TraverseTime = TT;
		}

	}

	private static void AddJunctions(HashMap<Integer, Integer> Junctions,
			HashMap<Integer, HashMap<Integer, Node>> graph) {
		int id = scn.nextInt();
		int trafficTime = scn.nextInt();

		Junctions.put(id, trafficTime);

		graph.put(id, new HashMap<>());
	}

	private static void AddRoad(HashMap<Integer, HashMap<Integer, Node>> graph) {
		int id1 = scn.nextInt();
		int id2 = scn.nextInt();
		int BuildTime = scn.nextInt();
		int TraverseTime = scn.nextInt();

		Node node = new Node(BuildTime, TraverseTime);

		graph.get(id1).put(id2, node);
		graph.get(id2).put(id1, node);

		if (srcVertex == -1) {
			srcVertex = id1;
		}

	}

	private static void DemolishRoad(HashMap<Integer, HashMap<Integer, Node>> graph) {
		int id1 = scn.nextInt();
		int id2 = scn.nextInt();

		graph.get(id1).remove(id2);
		graph.get(id2).remove(id1);

	}

	private static void Display(HashMap<Integer, HashMap<Integer, Node>> graph, HashSet<Integer> isdone) {

		ArrayList<Integer> vnames = new ArrayList<>(graph.keySet());
		String str = "";
		for (int i : vnames) {
			if (isdone.contains(i)) {
				continue;
			}
			isdone.add(i);

			ArrayList<Integer> keys = new ArrayList<>(graph.get(i).keySet());
			for (int key : keys) {
				if (isdone.contains(key)) {
					continue;
				}
				str += "(" + i + "->" + key + ") @" + "(" + graph.get(i).get(key).BuildTime + ","
						+ graph.get(i).get(key).TraverseTime + ") ";

			}
			System.out.println(str);

		}

	}

	private static void DisplayPath(HashMap<Integer, HashMap<Integer, Node>> graph) {
		Display(graph, new HashSet<>());

	}

	private static class mstRoad implements Comparable<mstRoad> {
		int x;
		int y;
		int value;
		boolean flag = true;

		@Override
		public String toString() {
			return "[" + this.x + " " + this.y + "]";
		}

		@Override
		public int compareTo(mstRoad o) {
			if (flag)
				return this.x - o.x;
			else
				return this.y - o.y;
		}
	}

	private static class DijikstraPair implements Comparable<DijikstraPair> {
		int vertex = -1;
		int csf = 1000000000;
		mstRoad road = new mstRoad();

		@Override
		public int compareTo(DijikstraPair arg0) {

			return this.csf - arg0.csf;
		}

	}

	private static HashMap<Integer, DijikstraPair> dijkstra(HashMap<Integer, HashMap<Integer, Node>> graph,
			int srcVertex) {
		HashMap<Integer, DijikstraPair> map = new HashMap<>();
		PriorityQueue<DijikstraPair> heap = new PriorityQueue<DijikstraPair>();
		ArrayList<Integer> vnames = new ArrayList<Integer>(graph.keySet());

		for (int vname : vnames) {

			DijikstraPair pair = new DijikstraPair();
			pair.vertex = vname;
			if (vname == srcVertex) {
				pair.csf = 0;
			}

			heap.add(pair);
			map.put(vname, pair);

		}

		while (!heap.isEmpty()) {
			DijikstraPair process = heap.remove();
			ArrayList<Integer> keys = new ArrayList<Integer>(graph.get(process.vertex).keySet());
			for (int key : keys) {

				DijikstraPair newpair = map.get(key);
				int oldcost = newpair.csf;
				int newcost = process.csf + graph.get(key).get(process.vertex).BuildTime;

				if (newcost < oldcost) {
					newpair.csf = newcost;
					newpair.vertex = key;

					newpair.road.x = Math.min(process.vertex, key);
					newpair.road.y = Math.max(process.vertex, key);
					newpair.road.value = graph.get(key).get(process.vertex).BuildTime;

					heap.remove(newpair);
					heap.add(newpair);
				}
			}

		}

		return map;
	}

	private static void PrintMST(HashMap<Integer, HashMap<Integer, Node>> graph) {
		HashMap<Integer, DijikstraPair> map = dijkstra(graph, srcVertex);

		ArrayList<Integer> vnames = new ArrayList<Integer>(map.keySet());

		ArrayList<mstRoad> al = new ArrayList<>();

		int maxvalue = 0;
		int roadcount = -1;
		for (int i : vnames) {
			roadcount++;
			maxvalue += map.get(i).road.value;

			if (map.get(i).csf != 0) {
				al.add(map.get(i).road);
			}

			// System.out.println(i + " " + map.get(i).csf + " " +
			// map.get(i).road);
		}

		// System.out.println(al);

		if (al.size() == 0) {
			System.out.println(-1);
			return;
		}

		Collections.sort(al);

		for (int i : vnames) {
			map.get(i).road.flag = false;
		}

		Collections.sort(al);

		String str = (maxvalue + " " + roadcount);

		for (int i = 0; i < al.size(); i++) {
			str += " " + al.get(i).x + " " + al.get(i).y;
		}

		System.out.println(str);

	}

	private static class travel {
		int id;
		int csf = 100000000;
		String psf = "";
		int EdgeVisited = 1;
	}

	private static travel Path(int id1, int id2, HashMap<Integer, Integer> Junctions,
			HashMap<Integer, HashMap<Integer, Node>> graph, HashSet<Integer> isdone) {

		HashMap<Integer, travel> map = new HashMap<>();
		ArrayList<Integer> keys = new ArrayList<>(graph.keySet());
		for (int key : keys) {
			map.put(key, new travel());
		}

		travel pair = new travel();
		pair.csf = 0;
		pair.psf += id1;
		pair.id = id1;

		LinkedList<travel> queue = new LinkedList<>();
		queue.addLast(pair);

		map.put(id1, pair);

		while (!queue.isEmpty()) {
			travel rp = queue.removeFirst();
			if (isdone.contains(rp.id)) {
				continue;
			}

			isdone.add(rp.id);

			ArrayList<Integer> vnames = new ArrayList<>(graph.get(rp.id).keySet());
			for (Integer vname : vnames) {
				if (isdone.contains(vname)) {
					continue;
				}

				int csf = map.get(rp.id).csf;
				String psf = map.get(rp.id).psf;
				int EdgeVisited = map.get(rp.id).EdgeVisited;
				int forward = 0;

				if (vname != id2) {
					int temp = graph.get(rp.id).get(vname).TraverseTime % Junctions.get(vname);
					forward = graph.get(rp.id).get(vname).TraverseTime + (temp == 0 ? 0 : Junctions.get(vname) - temp);
				} else {
					forward = graph.get(rp.id).get(vname).TraverseTime;
				}

				csf += forward;
				psf += " " + vname;
				EdgeVisited += 1;
				travel np = new travel();
				np.id = vname;

				if (csf < map.get(vname).csf) {
					np.csf = csf;
					np.psf = psf;
					np.EdgeVisited = EdgeVisited;
					map.put(vname, np);

				} else {
					np.csf = map.get(vname).csf;
					np.psf = map.get(vname).psf;
					np.EdgeVisited = map.get(vname).EdgeVisited;
					map.put(vname, np);
				}

				queue.addLast(np);

			}
		}

		return map.get(id2);
	}

	private static void quickTravel(HashMap<Integer, HashMap<Integer, Node>> graph,
			HashMap<Integer, Integer> Junctions) {
		int id1 = scn.nextInt();
		int id2 = scn.nextInt();

		travel forward = Path(id1, id2, Junctions, graph, new HashSet<>());
		travel backward = Path(id2, id1, Junctions, graph, new HashSet<>());

		String str = "";

		if (forward.csf <= backward.csf) {
			str += forward.csf + " " + forward.EdgeVisited + " " + forward.psf;

		} else if (forward.csf > backward.csf) {
			str += backward.csf + " " + backward.EdgeVisited + " " + backward.psf;
		}

		System.out.println(str.length() == 0 ? -1 : str);

	}

	public static void main(String[] args) {

		HashMap<Integer, Integer> Junctions = new HashMap<>();
		HashMap<Integer, HashMap<Integer, Node>> graph = new HashMap<>();

		int n = scn.nextInt();
		int m = scn.nextInt();

		for (int i = 0; i < n; i++) { // Prime-Junctions.
			AddJunctions(Junctions, graph);
		}

		for (int i = 0; i < m; i++) {
			AddRoad(graph);
		}

		// DisplayPath(graph);

		int operation = scn.nextInt();

		for (int i = 0; i < operation; i++) {
			int code = scn.nextInt();

			if (code == 1) {
				AddJunctions(Junctions, graph);
			} else if (code == 2) {
				AddRoad(graph);
			} else if (code == 3) {
				DemolishRoad(graph);
			} else if (code == 4) {
				PrintMST(graph);
			} else {
				quickTravel(graph, Junctions);
			}
		}

	}

}
