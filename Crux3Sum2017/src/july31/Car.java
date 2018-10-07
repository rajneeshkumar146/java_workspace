package july31;

import java.util.Comparator;

public class Car implements Comparable<Car>{
	private String name;
	private int speed;
	private int price;
	public static final CarSpeedComparator speedctor = new CarSpeedComparator();
	public static final CarReverseSpeedComparator speedrevctor = new CarReverseSpeedComparator();
	public static final CarPriceComparator pricector = new CarPriceComparator();
	public static final CarReversePriceComparator pricerevctor = new CarReversePriceComparator();
	public static final CarNameComparator namector = new CarNameComparator();
	public static final CarReverseNameComparator namerevctor = new CarReverseNameComparator();
	
	public Car(String name, int speed, int price){
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public int compareTo(Car o) {
//		return this.speed - o.speed;
//		return o.price - this.price;
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString(){
		return "[" + this.name + "_s" + this.speed + "_p" + this.price + "]";
	}

	private static class CarSpeedComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o1.speed - o2.speed;
		}
	}
	
	private static class CarReverseSpeedComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o2.speed - o1.speed;
		}
	}
	
	private static class CarPriceComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o2.price - o1.price;
		}
	}
	
	private static class CarReversePriceComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o1.price - o2.price;
		}
	}
	
	private static class CarNameComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o1.name.compareTo(o2.name);
		}
	}
	
	private static class CarReverseNameComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			return o2.name.compareTo(o1.name);
		}
	}
}
