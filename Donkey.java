//This class is a subclass of Mammal class

public class Donkey extends Mammal{
	private static int count = 0; //it counts total donkeys

	public Donkey(String name, int age) {
		super(name, age);
		super.setLegNumber(4);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(1);
		count++;
	}

	//Overrides form Animal class
	@Override
	public void sayGreeting(){
		System.out.println("Life will go on as it has always gone –that is, badly!");
	}

	public static int getCount() {
		return count;
	}

	public static void decrementCount(){
		count--;
	}
}
