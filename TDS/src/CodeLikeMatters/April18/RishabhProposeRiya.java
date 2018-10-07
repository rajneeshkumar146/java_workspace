package CodeLikeMatters.April18;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class RishabhProposeRiya {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();
	private static long m;

	public static void main(String[] args) throws Exception {
		long[] c=new long[2];
		long[] p=new long[2];
		m=scn.scanLong();
		for(int i=0;i<2;i++){
			long h=scn.scanLong();
			long a=scn.scanLong();
			long x=scn.scanLong();
			long y=scn.scanLong();
		
			c[i]=iter(h,a,x,y);
			p[i]=iter((x*a+y)%m,a,x,y)+1;
		}
		if(((!~*c||!~c[1])&&cout<<"-1\n")||
		   (*c==c[1]&&cout<<*c<<'\n')||
		   (!*p&&!p[1]&&cout<<"-1\n"))
			return 0;
		if(!*p) swap(*c,c[1]),swap(*p,p[1]);
		f(x,m){
			LL t=*p*x+*c;
			if(t>=c[1]&&(p[1]||t==c[1])&&(!p[1]||!((t-c[1])%p[1]))){
				cout<<t<<'\n';
				return 0;
			}
		}
		cout<<"-1\n";LL c[2],p[2];
		cin>>m;
		f(i,2){
			LL h,a,x,y;
			cin>>h>>a>>x>>y;
			c[i]=iter(h,a,x,y);
			p[i]=iter((x*a+y)%m,a,x,y)+1;
		}
		if(((!~*c||!~c[1])&&cout<<"-1\n")||
		   (*c==c[1]&&cout<<*c<<'\n')||
		   (!*p&&!p[1]&&cout<<"-1\n"))
			return 0;
		if(!*p) swap(*c,c[1]),swap(*p,p[1]);
		f(x,m){
			LL t=*p*x+*c;
			if(t>=c[1]&&(p[1]||t==c[1])&&(!p[1]||!((t-c[1])%p[1]))){
				cout<<t<<'\n';
				return 0;
			}
		}
		cout<<"-1\n";
	}

	private static long iter(long h, long a, long x, long y) {

		long r = 0;
		while (h != a) {
			h = (x * h + y) % m;
			if (++r > m)
				return -1;
		}
		return r;

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
