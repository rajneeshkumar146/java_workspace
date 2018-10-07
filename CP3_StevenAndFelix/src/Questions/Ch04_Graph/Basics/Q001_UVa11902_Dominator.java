package Questions.Ch04_Graph.Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] adjacencyList;
	public static int [] adjacencyListCount;
	
	public static boolean reachable (int id, int target, int exclude) {
		boolean [] travelled=new boolean [adjacencyListCount.length];
		if (exclude!=-1) {
			travelled[exclude]=true;
		}
		if (id==-1) {
			boolean flag=false;
			if (!travelled[0]) {
				travelled[0]=true;
				LinkedList<Integer> queue=new LinkedList<>();
				queue.add(0);
				while (queue.size()>0) {
					int currId=queue.removeFirst();
					if (currId==target) {
						flag=true;
						break;
					} else {
						for (int i=0;i<adjacencyListCount[currId];i++) {
							int nextId=adjacencyList[currId][i];
							if (!travelled[nextId]) {
								queue.addLast(nextId);
								travelled[nextId]=true;
							}

						}
					}
				}
			}
			return flag;
		} else {
			boolean flag=false;
			travelled[id]=true;
			LinkedList<Integer> queue=new LinkedList<>();
			queue.add(id);
			while (queue.size()>0) {
				int currId=queue.removeFirst();
				if (currId==target) {
					flag=true;
					break;
				} else {
					for (int i=0;i<adjacencyListCount[currId];i++) {
						int nextId=adjacencyList[currId][i];
						if (!travelled[nextId]) {
							queue.addLast(nextId);
							travelled[nextId]=true;
						}
					}
				}
			}
			return flag;
		}
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			
			adjacencyList=new int [n][n];
			adjacencyListCount=new int [n];
			for (int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<n;i2++) {
					if (st.nextToken().equals("1")) {
						adjacencyList[i][adjacencyListCount[i]++]=i2;
					}
				}
			}
			
			boolean [][] flag=new boolean [n][n];
			
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<n;i2++) {
					boolean initial=reachable(-1,i2,-1);
					if (initial) {
						flag[i][i2]=!reachable(-1,i2,i);
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("Case ");
			sb.append(testCase);
			sb.append(":\n");
			for (int i=0;i<n;i++) {
				sb.append('+');
				for (int i2=2*n-1;i2>0;i2--) {
					sb.append('-');
				}
				sb.append("+\n|");
				
				for (int i2=0;i2<n;i2++) {
					if (flag[i][i2]) {
						sb.append('Y');
					} else {
						sb.append('N');
					}
					sb.append('|');
				}
				sb.append('\n');
			}
			sb.append('+');
			for (int i=2*n-1;i>0;i--) {
				sb.append('-');
			}
			sb.append("+\n");
			
			System.out.print(sb.toString());
		}
	}
}