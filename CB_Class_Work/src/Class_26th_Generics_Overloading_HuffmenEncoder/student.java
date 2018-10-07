package Class_26th_Generics_Overloading_HuffmenEncoder;

import java.util.Comparator;

public class student implements Comparable<student> {

	private String name;
	private int marks;
	private int rank;

	public static final studentMarksComparator MarksComparator = new studentMarksComparator();
	public static final studentRankComparator RanksComparator = new studentRankComparator();
	public static final studentNameComparator NameComparator = new studentNameComparator();

	public student(String name, int marks, int rank) {
		this.name = name;
		this.marks = marks;
		this.rank = rank;
	}

	@Override
	public int compareTo(student o) {
		// TODO Auto-generated method stub
		return this.marks - o.marks;
	}

	@Override
	public String toString() {

		return "[" + name + "=>" + marks + "and " + rank + "]";
	}

	private static class studentMarksComparator implements Comparator<student> {

		@Override
		public int compare(student o1, student o2) {
			return o2.marks - o1.marks;
		}

	}

	private static class studentRankComparator implements Comparator<student> {

		@Override
		public int compare(student o1, student o2) {
			return o1.rank - o2.rank;

		}

	}

	private static class studentNameComparator implements Comparator<student> {

		@Override
		public int compare(student o1, student o2) {
			return o1.name.compareTo(o2.name);
		}

	}

}
