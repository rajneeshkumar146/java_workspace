package june27;

public class Client {

	public static void main(String[] args) {
		// mazepathdiag(0, 0, 2, 2, "");
		// mazepathdiagwmultimoves(0, 0, 2, 2, "");
		int[][] maze = new int[5][6];
		maze[0][1] = 1;
		maze[0][5] = 1;
		maze[1][3] = 1;
		maze[1][5] = 1;
		maze[2][1] = 1;
		maze[3][1] = 1;
		maze[3][4] = 1;
		maze[4][3] = 1;
		int[][] visited = new int[maze.length][maze[0].length];

		floodfill(0, 0, maze, visited, "");
		System.out.println("Shortes is " + shortestPath);

		// int[] arr = {1, 2, 3, 4};
		// visit(arr, 0);
		// for(int val: arr){
		// System.out.println(val);
		// }
	}

	// public static void visit(int[] arr, int vidx){
	// if(vidx == arr.length){
	// return;
	// }
	//
	// arr[vidx]++;
	// visit(arr, vidx + 1);
	// }

	static int counter = 0;

	private static void mazepathdiag(int sr, int sc, int dr, int dc, String path) {
		if (sr == dr && sc == dc) {
			counter++;
			System.out.println(counter + ". " + path);
			return;
		}

		if (sr < dr) {
			mazepathdiag(sr + 1, sc, dr, dc, path + "V");
		}

		if (sc < dc) {
			mazepathdiag(sr, sc + 1, dr, dc, path + "H");
		}

		if (sr < dr && sc < dc) {
			mazepathdiag(sr + 1, sc + 1, dr, dc, path + "D");
		}
	}

	private static void mazepathdiagwmultimoves(int sr, int sc, int dr, int dc, String path) {
		if (sr == dr && sc == dc) {
			counter++;
			System.out.println(counter + ". " + path);
			return;
		}

		// h choices
		for (int ms = 1; ms <= dc - sc; ms++) {
			mazepathdiagwmultimoves(sr, sc + ms, dr, dc, path + "h" + ms);
		}

		// v choices
		for (int ms = 1; ms <= dr - sr; ms++) {
			mazepathdiagwmultimoves(sr + ms, sc, dr, dc, path + "v" + ms);
		}

		// d choices
		for (int ms = 1; ms <= Math.min(dr - sr, dc - sc); ms++) {
			mazepathdiagwmultimoves(sr + ms, sc + ms, dr, dc, path + "d" + ms);
		}
	}

	static String shortestPath = null;
	private static void floodfill(int sr, int sc, int[][] maze, int[][] visited, String path) {
		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			System.out.println(path);
			
			if(shortestPath == null){
				shortestPath = path;
			} else {
				if(path.length() < shortestPath.length()){
					shortestPath = path;
				}
			}
			
			return;
		}

		if (isThisAnInvalidSpot(sr, sc, maze, visited) == true) {
			return;
		}

		visited[sr][sc] = 1;
		floodfill(sr - 1, sc, maze, visited, path + "T");
		floodfill(sr, sc - 1, maze, visited, path + "L");
		floodfill(sr + 1, sc, maze, visited, path + "D");
		floodfill(sr, sc + 1, maze, visited, path + "R");
		visited[sr][sc] = 0;
	}

	private static boolean isThisAnInvalidSpot(int sr, int sc, int[][] maze, int[][] visited) {
		if (sr < 0) {
			return true;
		} else if (sc < 0) {
			return true;
		} else if (sr >= maze.length) {
			return true;
		} else if (sc >= maze[0].length) {
			return true;
		} else if (maze[sr][sc] == 1) {
			return true;
		} else if (visited[sr][sc] == 1) {
			return true;
		} else {
			return false;
		}
	}
}
