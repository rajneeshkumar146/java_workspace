package july31;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String name;
	private int marks;
	private int rank;
	public static final StudentMarksComparator MarksComparator = new StudentMarksComparator();
	public static final StudentRanksComparator RanksComparator = new StudentRanksComparator();
	public static final StudentNameComparator NameComparator = new StudentNameComparator();
	
	public Student(String name, int marks, int rank){
		this.name = name;
		this.marks = marks;
		this.rank = rank;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString(){
		return "[" + name + " => " + marks + "@" + rank + "]";
	}

	private static class StudentMarksComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.marks - o2.marks;
		}
	}
	
	private static class StudentRanksComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o2.rank - o1.rank;
		}
	}
	
	private static class StudentNameComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o2.name.compareTo(o1.name);
		}
	}
	
}
