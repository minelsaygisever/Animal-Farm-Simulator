//Minel SAYGISEVER 150116028
//This program is a simple animal farm simulator. We can add and remove animals,
//Sort them, do some calculations about population, print some texts etc.

import java.io.*;
import java.util.*;

public class AnimalFarm {
	private ArrayList<Animal> animalList = new ArrayList<Animal>(); //it keeps animals
	private ArrayList<String> animalNames = new ArrayList<String>(); //it keeps animal names
	private final int CAPACITY;
	private static int numberOfAnimals = 0;

	public AnimalFarm(int capacity){
		this.CAPACITY = capacity;
	}

	public int getNumberOfAnimals(){
		return numberOfAnimals;
	}

	public boolean addAnimal(Animal animal) throws IllegalNameException {
		if (animalNames.contains(animal.getName())) { //we cannot create two animals with the same name
			throw new IllegalNameException(animal.getName()); //throws an exception
		}

		//we can create an animal if there is capacity for it
		if (numberOfAnimals < CAPACITY && !animalNames.contains(animal.getName())) {
			//numberOfAnimals++;
			animalList.add(animal);
			animalNames.add(animal.getName());
			numberOfAnimals++; //counts number of animals
			System.out.println(animal.getName() + " is successfully added to the farm!");
			return true;
		}
		else
			System.out.println("There is no capacity for " + animal.getName() + "!");
			return false;
	}


	public boolean removeAnimal(String name){
		if (animalNames.contains(name)){ //we cannot remove an animal that is not at the farm

			for(int i = 0; i < animalList.size(); i++){
				if(animalList.get(i).getName().equals(name)){ //searching for its name

					//we should decrement the count of this animals type
					//so we will look for every type of animal and decrement the count
					if (animalList.get(i) instanceof Chicken){
						Chicken.decrementCount();
					}
					else if (animalList.get(i) instanceof Raven){
						Raven.decrementCount();
					}
					else if (animalList.get(i) instanceof Donkey){
						Donkey.decrementCount();
					}
					else if (animalList.get(i) instanceof Horse){
						Horse.decrementCount();
					}
					else if (animalList.get(i) instanceof Pig){
						Pig.decrementCount();
					}
					else if (animalList.get(i) instanceof Sheep){
						Sheep.decrementCount();
					}

					animalList.remove(i); //remove animal from animalList
				}
			}

			animalNames.remove(name); //remove animal's name from animalNames
			numberOfAnimals--; //total animals

			return true;
		}
		else
			return false;

	}

	public void printAllAnimalGreetings(){
		for(int i = 0; i < animalList.size(); i++ ){
			printOneAnimalGreeting(animalList.get(i));
		}
	}

	public void printOneAnimalGreeting(Animal animal){
		animal.sayGreeting();
	}

	public void printAllAnimalNames(){
		for(int i = 0; i < animalList.size(); i++ ){
			printOneAnimalName(animalList.get(i));
		}
	}

	public void printOneAnimalName(Animal animal){
		System.out.println(animal.getName());
	}

	public void printAllAnimals(){
		for(int i = 0; i < animalNames.size(); i++ ){
			animalList.get(i).toString();
		}
	}

	public int nextYearPopulationForecast(){
		int forecast = 0;

		//we will look for each animal, multiply its number of offsprings and pregnancy per year
		//and add the result to forecast variable
		for(int i = 0; i < animalList.size(); i++ ){
			forecast += animalList.get(i).getNumberOfOffsprings() * animalList.get(i).getPregnancyPerYear();
		}

		return forecast;
	}

	public void animalMovements(){
		for(int i = 0; i < animalList.size(); i++ ){

			//if the animal is bird, we will call fly method
			//if it's mammal, we will call walk method
			if(animalList.get(i) instanceof Bird) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				Bird a = new Bird("a", 1);  //to call the fly method, i create a bird object
				a.fly();
			}
			if(animalList.get(i) instanceof Mammal) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				Mammal a = new Mammal("a", 1); //to call the walk method, i create a mammal object
				a.walk();
			}
		}
	}

	public void eatingHabits(){
		for(int i = 0; i < animalList.size(); i++ ){

			//if the animal is bird, we will call omnivore method
			//if it's mammal, we will call herbivore method
			if(animalList.get(i) instanceof Bird) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				Bird a = new Bird("a", 1); //to call the omnivore method, i create a bird object
				a.omnivore();
			}
			else if(animalList.get(i) instanceof Mammal) {
				System.out.print("My name is " + animalList.get(i).getName() + " and ");
				Mammal a = new Mammal("a", 1); //to call the herbivore method, i create a mammal object
				a.herbivore();
			}
		}
	}

	public void sortAlphabetically(){
		ArrayList<String> temp = new ArrayList<String>(); //we will add the names to temp array list

		for(int i = 0; i < animalList.size(); i++){
			temp.add(animalList.get(i).getName());
		}

		Collections.sort(temp); //sort method


		for(int i = 0; i < temp.size(); i++){ //print them
			System.out.println(temp.get(i));
		}
	}

	public void sortBasedOnLegNumber(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Animal> temp2 = new ArrayList<Animal>();
		ArrayList<Animal> temp3 = new ArrayList<Animal>();


		for(int i = 0; i < animalList.size(); i++){
			temp.add(animalList.get(i).getLegNumber()); //temp will keep leg numbers
			temp2.add(animalList.get(i)); //temp2 will keep animals, we do not want to lose animalList
		}

		Collections.sort(temp);

		for(int i = 0; i < temp.size(); i++){
			for(int j = 0; j < temp2.size(); j++){
				if(temp2.get(j).getLegNumber() == temp.get(i)){ //we will search for animal names which have the current animal leg
					temp3.add(temp2.get(j));                    //because we want to print their names too
					temp2.remove(j);
					break;
				}
			}
		}


		for(int i = 0; i < temp.size(); i++){
			System.out.println("My name is " + temp3.get(i).getName() + " and I have " + temp.get(i) + " legs!");
		}
	}

	public void sortBasedOnAge(){

		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Animal> temp2 = new ArrayList<Animal>();
		ArrayList<Animal> temp3 = new ArrayList<Animal>();


		for(int i = 0; i < animalList.size(); i++){
			temp.add(animalList.get(i).getAge()); //temp will keep ages
			temp2.add(animalList.get(i)); //temp2 will keep animals, we do not want to lose animalList
		}

		Collections.sort(temp);

		for(int i = 0; i < temp.size(); i++){
			for(int j = 0; j < temp2.size(); j++){
				if(temp2.get(j).getAge() == temp.get(i)){ //we will search for animal names which have the current age
					temp3.add(temp2.get(j));              //because we want to print their names too
					temp2.remove(j);
					break;
				}
			}
		}


		for(int i = 0; i < temp.size(); i++){
			System.out.println("My name is " + temp3.get(i).getName() + " and I am " + temp.get(i) + " years old!");
		}
	}

	public void sortBasedOnDate(){
		ArrayList<Date> temp = new ArrayList<Date>();
		ArrayList<Animal> temp2 = new ArrayList<Animal>();
		ArrayList<Animal> temp3 = new ArrayList<Animal>();


		for(int i = 0; i < animalList.size(); i++){
			temp.add(animalList.get(i).getDate()); //temp will keep creation date
			temp2.add(animalList.get(i)); ////temp2 will keep animals, we do not want to lose animalList
		}

		Collections.sort(temp);

		for(int i = 0; i < temp.size(); i++){
			for(int j = 0; j < temp2.size(); j++){
				if(temp2.get(j).getDate() == temp.get(i)){ //we will search for animal names which have the current date
					temp3.add(temp2.get(j));               //because we want to print their names too
					temp2.remove(j);
					break;
				}
			}
		}


		for(int i = 0; i < temp.size(); i++){
			System.out.println("My name is " + temp3.get(i).getName() + " and I am added at " + temp.get(i) + " !");
		}
	}

	public void searchBasedOnName(String name){
		int a = 0;
		for (int i = 0; i < animalList.size(); i++) {
			if (name.equals(animalList.get(i).getName())){ //if name is equal to animal list's current name
				System.out.println(animalList.get(i).toString() + "\n"); //it will print the name and
				a++; //make a = 1
			}
		}

		if (a == 0) //if a is still 0, it means we couldn't find the name
			System.out.println(name + " couldn't find!");
	}

	public void searchBasedOnAge(int age){
		int a = 0;

		for (int i = 0; i < animalList.size(); i++) {
			if (age == animalList.get(i).getAge()) { //if age is equal to animal list's current age
				System.out.println(animalList.get(i).toString() + "\n"); //it will print the name and
				a++; //make a = 1
			}
		}

		//if a is still 0, it means we couldn't find the age
		if (a == 0)
			System.out.println("There is no animal at age " + age + "!");
	}

	//this method will create a file and write the report in this file
	public void printReport(String fileName) throws FileNotFoundException{
		File file = new File(fileName);

		//we cannot create a file if it's name used before
		if(file.exists()){
			System.out.println("File already exists!");
		}
		else {
			try (PrintWriter output = new PrintWriter(file);) {
			output.println("We have total of " + numberOfAnimals + " animals in the farm.");

			//if animal types' count are not zero we will write their reports

			if(Chicken.getCount() != 0){
				output.println("\t*" + Chicken.getCount() + " of them are Chicken. Those are:");
				output.printf("\n\t\t%-12s%-12s%-12s", "Name" , "Age", "Leg Number");
				for(int i = 0; i < animalList.size(); i++){
					if(animalList.get(i) instanceof Chicken) {
						output.println();
						output.printf("\t\t%-12s%-12s%-12s", animalList.get(i).getName() , animalList.get(i).getAge() , animalList.get(i).getLegNumber());
					}
				}
			}

			if(Raven.getCount() != 0){
				output.println();
				output.println("\t*" + Raven.getCount() + " of them are Raven. Those are:");
				output.printf("\n\t\t%-12s%-12s%-12s", "Name" , "Age", "Leg Number");
				for(int i = 0; i < animalList.size(); i++){
					if(animalList.get(i) instanceof Raven) {
						output.println();
						output.printf("\t\t%-12s%-12s%-12s", animalList.get(i).getName() , animalList.get(i).getAge() , animalList.get(i).getLegNumber());
					}
				}
			}

			if(Donkey.getCount() != 0){
				output.println();
				output.println("\t*" + Donkey.getCount() + " of them are Donkey. Those are:");
				output.printf("\n\t\t%-12s%-12s%-12s", "Name" , "Age", "Leg Number");
				for(int i = 0; i < animalList.size(); i++){
					if(animalList.get(i) instanceof Donkey) {
						output.println();
						output.printf("\t\t%-12s%-12s%-12s", animalList.get(i).getName() , animalList.get(i).getAge() , animalList.get(i).getLegNumber());
					}
				}
			}

			if(Horse.getCount() != 0){
				output.println();
				output.println("\t*" + Horse.getCount() + " of them are Horse. Those are:");
				output.printf("\n\t\t%-12s%-12s%-12s", "Name" , "Age", "Leg Number");
				for(int i = 0; i < animalList.size(); i++){
					if(animalList.get(i) instanceof Horse) {
						output.println();
						output.printf("\t\t%-12s%-12s%-12s", animalList.get(i).getName() , animalList.get(i).getAge() , animalList.get(i).getLegNumber());
					}
				}
			}

			if(Pig.getCount() != 0){
				output.println();
				output.println("\t*" + Pig.getCount() + " of them are Pig. Those are:");
				output.printf("\n\t\t%-12s%-12s%-12s", "Name" , "Age", "Leg Number");
				for(int i = 0; i < animalList.size(); i++){
					if(animalList.get(i) instanceof Pig) {
						output.println();
						output.printf("\t\t%-12s%-12s%-12s", animalList.get(i).getName() , animalList.get(i).getAge() , animalList.get(i).getLegNumber());
					}
				}
			}

			if(Sheep.getCount() != 0){
				output.println();
				output.println("\t*" + Sheep.getCount() + " of them are Sheep. Those are:");
				output.printf("\n\t\t%-12s%-12s%-12s", "Name" , "Age", "Leg Number");
				for(int i = 0; i < animalList.size(); i++){
					if(animalList.get(i) instanceof Sheep) {
						output.println();
						output.printf("\t\t%-12s%-12s%-12s", animalList.get(i).getName() , animalList.get(i).getAge() , animalList.get(i).getLegNumber());
					}
				}
			}

			}
		}
	}
}

//addAnimal method throws it
class IllegalNameException extends Exception {
	private String name;

	public IllegalNameException(String name) {
		super("This name (" + name + ") used before.");
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
