//This class is a subclass of Mammal class

public class Pig extends Mammal{
	private static int count = 0; //it counts total pigs

	public Pig(String name, int age) {
		super(name, age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(12);
		super.setPregnancyPerYear(2);
		count++;
	}

	//Overrides form Animal class
	@Override
	public void sayGreeting(){
		System.out.println("All animals are equal, but some animals are more equal than others!");
	}

	public static int getCount() {
		return count;
	}

	public static void decrementCount(){
		count--;
	}
}
