package Class_26th_Generics_Overloading_HuffmenEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GenericHeapClient {

	public static void main(String[] args) {

		GenericHeap<student> hp = new GenericHeap<>(student.MarksComparator);

		student[] stu = new student[5];
		stu[0] = new student("puru", -100, -1);
		stu[1] = new student("modi", 100, 1);
		stu[2] = new student("kadi Ninda", 11, 600000);
		stu[3] = new student("AK47", 10, 12564);
		stu[4] = new student("Rahul", 15, 1154);

		hp.add(stu[0]);
		hp.add(stu[1]);
		hp.add(stu[2]);
		hp.add(stu[3]);
		hp.add(stu[4]);

		hp.display();

		System.out.println();
		while (hp.size() != 0) {
			System.out.println(hp.removeHP());
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> zeroth = new ArrayList<>(Arrays.asList(10, 15, 20, 25));
		ArrayList<Integer> oneth = new ArrayList<>(Arrays.asList(8, 9, 14, 28));
		ArrayList<Integer> twoth = new ArrayList<>(Arrays.asList(7, 11, 26, 30));
		ArrayList<Integer> threeth = new ArrayList<>(Arrays.asList(19, 21, 23, 27));

		list.add(zeroth);
		list.add(oneth);
		list.add(twoth);
		list.add(threeth);

		System.out.println(mergesortArrayList(list));

		ArrayList<Integer> listl = new ArrayList<>(Arrays.asList(15, 8, 92, 10, 66, 7, 54, 99));

		System.out.println(kLargeElements(listl, 3));

	}

	// formed new class
	public static ArrayList<Integer> mergesortArrayList(ArrayList<ArrayList<Integer>> list) {
		ArrayList<Integer> rv = new ArrayList<>();
		GenericHeap<Pair> hp = new GenericHeap<>(Pair.DataComparator);

		for (int i = 0; i < list.size(); i++) {
			Pair p = new Pair();
			p.ino = 0;
			p.lno = i;
			p.data = list.get(i).get(0);
			hp.add(p);
		}

		while (!hp.isEmpty()) {
			Pair top = hp.removeHP();
			rv.add(top.data);
			top.ino++;
			if (top.ino < list.get(top.lno).size()) {
				top.data = list.get(top.lno).get(top.ino);
				hp.add(top);
			}
		}
		return rv;

	}

	private static class Pair {
		int data;
		int lno;
		int ino;

		private static final PairComarator DataComparator = new PairComarator();

		private static class PairComarator implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.data - o1.data;
			}

		}

	}

	public static ArrayList<Integer> kLargeElements(ArrayList<Integer> list, int k) {
		ArrayList<Integer> rv = new ArrayList<>();
		GenericHeap<Pairl> hp = new GenericHeap<>(Pairl.DataComparator);

		

		for (int i = 0; i < k; i++) {
			Pairl p = new Pairl();
			p.data = list.get(i);
			hp.add(p);
		}

		for (int i = k; i < list.size(); i++) {

			Pairl c = hp.removeHP();
			if (c.data > list.get(i)) {
				hp.add(c);
			} else {
				c.data = list.get(i);
				hp.add(c);
			}
		}

		while (hp.size() != 0) {
			rv.add(hp.removeHP().data);
		}

		return rv;

	}

	private static class Pairl {
		int data;

		private static final PairComarator DataComparator = new PairComarator();

		private static class PairComarator implements Comparator<Pairl> {

			@Override
			public int compare(Pairl o1, Pairl o2) {
				// TODO Auto-generated method stub
				return o2.data - o1.data;
			}
		}

	}

}
