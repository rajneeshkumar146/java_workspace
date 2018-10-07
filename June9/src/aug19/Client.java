package aug19;

public class Client {

	public static void main(String[] args) {
		int[] arr = {2, 0, -1, 3, 8, -4, -2, 3};
		
		ISegmentOperator op = new SumOperator();
		SegmentTree st = new SegmentTree(arr, op);
		st.display();
		
		FenwickTree ft = new FenwickTree(arr);
		
		System.out.println(st.query(3, 5));
		System.out.println(ft.query(3, 5));
		st.update(4, 10);
		ft.update(4, 10 - 8);
		System.out.println(st.query(3, 5));
		System.out.println(ft.query(3, 5));
	}

	public static void floydWarshall(Integer[][] graph){
		for(int i = 0; i < graph.length; i++){
			for(int s = 0; s < graph.length; s++){
				for(int d = 0; d < graph.length; d++){
					if(i == s || i == d){
						continue;
					} else if(graph[s][i] == null || graph[i][d] == null){
						continue;
					} else if(graph[s][d] == null){
						graph[s][d] = graph[s][i] + graph[i][d];
					} else {
						graph[s][d] = Math.min(graph[s][d], 
									  graph[s][i] + graph[i][d]);
					}
				}
			}
		}
	}
}
