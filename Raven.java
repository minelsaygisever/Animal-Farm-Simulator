//This class is a subclass of Bird class

public class Raven extends Bird{
	private static int count = 0; //it counts total ravens

	public Raven(String name, int age) {
		super(name, age);
		super.setLegNumber(2);
		super.setNumberOfOffsprings(5);
		super.setPregnancyPerYear(1);
		count++;
	}

	//Overrides form Animal class
	@Override
	public void sayGreeting(){
		System.out.println("A happy country where we poor animals shall rest forever!");
	}

	public static int getCount() {
		return count;
	}

	public static void decrementCount(){
		count--;
	}

}
