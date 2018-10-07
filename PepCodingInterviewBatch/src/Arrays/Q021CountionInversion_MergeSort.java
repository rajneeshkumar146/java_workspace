package Arrays;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Q021CountionInversion_MergeSort {
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {

		int n = scn.scanInt();
		int[] arr = Takeinput1DArray(n);

		int[] temparr = new int[n];

		int ans=MergeSort(arr, temparr, 0, n - 1);
		pnter.print(ans+"");
		pnter.close();

	}

	private static int MergeSort(int[] arr, int[] temparr, int left, int right) {

		if (left >= right) {
			return 0;
		}

		int mid = (left + right) >> 1;
		int inversion = 0;

		inversion += MergeSort(arr, temparr, left, mid);
		inversion += MergeSort(arr, temparr, mid + 1, right);

		inversion += Merge(arr, temparr, left, mid + 1, right);

		return inversion;

	}

	private static int Merge(int[] arr, int[] temparr, int left, int mid, int right) {
		int inversion = 0;

		int i = left;
		int j = mid;
		int k = left;

		while (i <= mid - 1 && j <= right) { // Counting_Inversion_and_Store_sorted_number_in_tempArray.
			if (arr[i] <= arr[j]) {

				temparr[k] = arr[i];
				k++;
				i++;

			} else {

				temparr[k] = arr[j];
				j++;
				k++;
				inversion += mid - i;
			}
		}

		while (i <= mid - 1) { //Copy_rest_element_of_left_arrray_to_merge_array.
			temparr[k] = arr[i];
			k++;
			i++;
		}

		while (j <= right) {  //Copy_rest_element_of_right_array_to_merge_array.
			temparr[k] = arr[j];
			j++;
			k++;
		}
		
		while(k-->0){ //Copy_back_the_mergeed_element_to_merge_array.
			arr[k]=temparr[k];
		}

		return inversion;
	}

	// -----------------------------------------------------------------------------------------

	private static int NumberLength(int n) {
		int length = 0;
		while (n != 0) {
			length++;
			n = n / 10;
		}

		return length;
	}

	private static void ReverseArray(int[] arr, int st, int en) {
		for (int i = st; st <= en; st++, en--) {
			swap(arr, st, en);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private static int[] PrifixSumArray(int le, int ri, int[] arr) {
		for (int i = le + 1; i < ri; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}

	private static int[] Takeinput1DArray(int n) throws IOException {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.scanInt();
		}
		return arr;
	}

	private static void display(int le, int ri, int[] arr) throws IOException {
		for (int i = le; i <= ri; i++) {
			pnter.print(arr[i] + " ");
		}
		pnter.printLine("");
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
