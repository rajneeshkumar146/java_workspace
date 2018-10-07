package july27;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
//		int[] arr = {2, 17, 9, 1, 87, 3};
//		Arrays.sort(arr);
//		
//		for(int val: arr){
//			System.out.print(val + " ");
//		}
//		System.out.println(".");
//		
//		String[] sarr = {"hi", "bye", "hello", "universe", "world"};
//		Arrays.sort(sarr);
//		
//		for(String val: sarr){
//			System.out.print(val + " ");
//		}
//		System.out.println(".");
//		
//		
//		int i = 10;
//		int j = 20;
//		if(i < j){
//			System.out.println(i + " is smaller");
//		}
		
//		Car[] cars = new Car[5];
//		cars[0] = new Car(100, 20, "A");
//		cars[1] = new Car(200, 15, "G");
//		cars[2] = new Car(150, 25, "C");
//		cars[3] = new Car(50, 50, "H");
//		cars[4] = new Car(75, 21, "B");
//		
//		Arrays.sort(cars);
//		for(Car car: cars){
//			car.display();
//		}
		
		MedianPQ mpq = new MedianPQ();
		mpq.add(10);
		mpq.add(20);
		mpq.add(5);
		mpq.add(2);
		mpq.add(3);
		
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		System.out.println(mpq.remove());
		
		
		
	}
	
	private static class Car implements Comparable<Car> {
		int speed;
		int price;
		String name;
		
		Car(int speed, int price, String name){
			this.speed = speed;
			this.price = price;
			this.name = name;
		}
		
		public void display(){
			System.out.println("Speed = " + this.speed + ", Price = " + this.price + ", Name = " + this.name);
		}

		@Override
		public int compareTo(Car o) {
//			return o.price - this.price;
			return this.name.compareTo(o.name);
		}
	}
}
