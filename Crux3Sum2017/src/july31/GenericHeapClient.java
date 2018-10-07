package july31;

public class GenericHeapClient {

	public static void main(String[] args) {
		Car[] cars = new Car[7];
		cars[0] = new Car("Audi", 100, 1000);
		cars[1] = new Car("BMW", 200, 1500);
		cars[2] = new Car("Porsche", 150, 800);
		cars[3] = new Car("Merc", 140, 900);
		cars[4] = new Car("Lambor", 160, 1400);
		cars[5] = new Car("ABC", 190, 1900);
		cars[6] = new Car("DEF", 210, 2100);
		
		GenericHeap<Car> heap = new GenericHeap<>(Car.namerevctor);
		for(Car car: cars){
			heap.add(car);
		}
		heap.display();
		
		while(heap.size() != 0){
			System.out.println(heap.removeHP());
		}
	}

}
