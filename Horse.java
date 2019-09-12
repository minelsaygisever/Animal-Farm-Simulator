//This class is a subclass of Mammal class

public class Horse extends Mammal{
	private static int count = 0; //it counts total horses

	public Horse(String name, int age) {
		super(name, age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(1);
		count++;
	}

	//Overrides form Animal class
	@Override
	public void sayGreeting(){
		System.out.println("I will work harder!");
	}

	public static int getCount() {
		return count;
	}

	public static void decrementCount(){
		count--;
	}
}
