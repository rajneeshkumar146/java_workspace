package Practice.Graph.TopologicalSort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Stack;

public class Q01_OliverAndGame {
private static int timer = 1;
private static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();

public static void main(String[] args) throws IOException {
  Scan scn = new Scan(System.in);

  int n = scn.scanInt();

  for (int i = 1; i < n; i++) {
    int x = scn.scanInt();
    int y = scn.scanInt();
    if (!graph.containsKey(x)) {
      graph.put(x, new HashSet<Integer>());
    }
    graph.get(x).add(y);
  }

  int[] startTime = new int[n + 1];
  int[] endTime = new int[n + 1];

  MeasureTimeIre(1, startTime, endTime);

  int Q = scn.scanInt();
  Print pnter = new Print();
  for (int i = 0; i < Q; i++) {
    int move = scn.scanInt();
    int x = scn.scanInt();
    int y = scn.scanInt();

    if (move == 0) {
      if (isSubtree(y, x, startTime, endTime)) {
        pnter.printLine("YES");
      } else {
        pnter.printLine("NO");
      }

    } else if (move == 1) {
      if (isSubtree(x, y, startTime, endTime)) {
        pnter.printLine("YES");
      } else {
        pnter.printLine("NO");
      }
    }
  }

  pnter.close();

}

private static void MeasureTime(int vname, int[] startTime, int[] endTime) {

  startTime[vname] = timer++;
  if (graph.containsKey(vname)) {
    ArrayList<Integer> keys = new ArrayList<Integer>(graph.get(vname));
    for (Integer key : keys) {
      MeasureTime(key, startTime, endTime);
    }
  }

  endTime[vname] = timer++;

}

private static void MeasureTimeIre(int vname, int[] startTime, int[] endTime) {
  Stack<pair> stack = new Stack<pair>();
  pair fp = new pair(); // First_Pair.
  fp.vname = vname;
  fp.nocd = graph.get(vname).size();
  stack.add(fp);
  while (!stack.isEmpty()) {
    pair rp = stack.peek();
    if (rp.vparent != null && rp.contribution == false) {
      pair p = rp.vparent;
      p.nocd -= 1;
      rp.contribution = true;
    }

    if (rp.nocd == 0) {
      if (startTime[rp.vname] == 0) {
        startTime[rp.vname] = timer++;
      }
      endTime[rp.vname] = timer++; // post_oder_vala_kaam.
      stack.pop();
      continue;
    }

    startTime[rp.vname] = timer++; // pre_oder_vala_kaam/
    if (graph.containsKey(rp.vname)) {
      ArrayList<Integer> keys = new ArrayList<Integer>(graph.get(rp.vname));
      for (Integer key : keys) {
        pair np = new pair();
        np.vparent = rp;
        np.vname = key;
        if (graph.containsKey(key)) { // Vo_Vertex_Exist_bhi_krti_hai_agar_han_to_uske_children_ka_size_dalo.
          np.nocd = graph.get(key).size();
        }
        stack.add(np);
      }
    }
  }
}

private static class pair {
  private pair vparent = null;
  private int vname;
  private int nocd = 0;// number_of_child_done.
  private boolean contribution;

}

public static boolean isSubtree(int x, int y, int[] startTime, int[] endTime) {
  if ((startTime[x] > startTime[y]) && (endTime[y] > endTime[x])) {
    return true;
  }
  return false;
}

static class Scan {
  private InputStream in;
  private byte[] buf = new byte[1024 * 1024];
  private int index;
  private int total;

  public Scan(InputStream in) {
    this.in = in;
  }

  public int scan() throws IOException {
    if (total < 0)
      throw new InputMismatchException();
    if (index >= total) {
      index = 0;
      total = in.read(buf);
      if (total <= 0)
        return -1;
    }
    return buf[index++];
  }

  public int scanInt() throws IOException {
    int integer = 0;
    int n = scan();
    while (isWhiteSpace(n))
      n = scan();
    int neg = 1;
    if (n == '-') {
      neg = -1;
      n = scan();
    }
    while (!isWhiteSpace(n)) {
      if (n >= '0' && n <= '9') {
        integer *= 10;
        integer += n - '0';
        n = scan();
      } else
        throw new InputMismatchException();
    }
    return neg * integer;
  }

  public long scanLong() throws IOException {
    long integer = 0;
    int n = scan();
    while (isWhiteSpace(n))
      n = scan();
    int neg = 1;
    if (n == '-') {
      neg = -1;
      n = scan();
    }
    while (!isWhiteSpace(n)) {
      if (n >= '0' && n <= '9') {
        integer *= 10;
        integer += n - '0';
        n = scan();
      } else
        throw new InputMismatchException();
    }
    return neg * integer;
  }

  public double scanDouble() throws IOException {
    double doub = 0;
    int n = scan();
    while (isWhiteSpace(n))
      n = scan();
    int neg = 1;
    if (n == '-') {
      neg = -1;
      n = scan();
    }
    while (!isWhiteSpace(n) && n != '.') {
      if (n >= '0' && n <= '9') {
        doub *= 10;
        doub += n - '0';
        n = scan();
      } else
        throw new InputMismatchException();
    }
    if (n == '.') {
      n = scan();
      double temp = 1;
      while (!isWhiteSpace(n)) {
        if (n >= '0' && n <= '9') {
          temp /= 10;
          doub += (n - '0') * temp;
          n = scan();
        } else
          throw new InputMismatchException();
      }
    }
    return doub * neg;
  }

  public String scanString() throws IOException {
    StringBuilder sb = new StringBuilder();
    int n = scan();
    while (isWhiteSpace(n))
      n = scan();
    while (!isWhiteSpace(n)) {
      sb.append((char) n);
      n = scan();
    }
    return sb.toString();
  }

  private boolean isWhiteSpace(int n) {
    if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
      return true;
    return false;
  }
}

static class Print {
  private final BufferedWriter bw;

  public Print() {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public void print(String str) throws IOException {
    bw.append(str);
  }

  public void printLine(String str) throws IOException {
    print(str);
    bw.append("\n");
  }

  public void close() throws IOException {
    bw.close();
  }
}

}
