//This class is a subclass of Bird class


public class Chicken extends Bird{
	private static int count = 0; //it counts total chickens

	public Chicken(String name, int age) {
		super(name, age);
		super.setLegNumber(2);
		super.setNumberOfOffsprings(1);
		super.setPregnancyPerYear(200);
		count++;
	}

	//Overrides form Animal class
	@Override
	public void sayGreeting(){
		System.out.println("I have nothing to say other than I am against Pigs!");
	}

	public static int getCount() {
		return count;
	}

	public static void decrementCount(){
		count--;
	}
}
