//Minel SAYGISEVER 150116028
//This program is a simple animal farm simulator. We can add and remove animals,
//Sort them, do some calculations about population, print some texts etc.


public class Animal {

	private String name;
	private int legNumber;
	private int age;
	private int pregnancyPerYear;
	private int numberOfOffsprings;
	private java.util.Date date;

	public Animal(){ //no-argument constructor

	}

	public Animal(String name, int age) { //constructor with arguments
		this.name = name;
		this.age = age;
		date = new java.util.Date();
	}

	public void sayGreeting() {
		System.out.println("Have nothing to say!");
	}

	public void reproduce() {
		System.out.println("None of your business!!");
	}

	//override from Object class
	@Override
	public String toString(){
		return "\nMy name is " + name + "!\nI am " + age +
				" years old!" + "\nI have " + legNumber + " legs!";
	}

	public String getName(){
		return name;
	}

	public int getLegNumber(){
		return legNumber;
	}

	public int getAge(){
		return age;
	}

	public java.util.Date getDate(){
		return date;
	}

	public int getPregnancyPerYear(){
		return pregnancyPerYear;
	}

	public int getNumberOfOffsprings(){
		return numberOfOffsprings;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setLegNumber(int legNumber){
		this.legNumber = legNumber;
	}

	public void setAge(int age){
		this.age = age;
	}

	public void setPregnancyPerYear(int pregnancyPerYear){
		this.pregnancyPerYear = pregnancyPerYear;
	}

	public void setNumberOfOffsprings(int numberOfOffsprings){
		this.numberOfOffsprings = numberOfOffsprings;
	}
}
