//Minel SAYGISEVER 150116028
//This program is a simple animal farm simulator. We can add and remove animals,
//Sort them, do some calculations about population, print some texts etc.

import java.util.*;

public class Test {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		System.out.print("Welcome to Animal Farm simulation program!" +
						"\nPlease enter the capacity of the animal farm: ");
		int capacity = input.nextInt();

		AnimalFarm farm = new AnimalFarm(capacity);

		int choice;

		//this do/while loop iterates if choice is not 0

		do {
		System.out.print("\n0 - Exit the program" +
						  "\n1 - Add animal"
						+ "\n2 - Remove animal"
						+ "\n3 - Search animal"
						+ "\n4 - Sort animals"
						+ "\n5 - Calculate the next year's population estimate"
						+ "\n6 - Print all animal's movements"
						+ "\n7 - Print all animal's eating habits"
						+ "\n8 - Print report"
						+ "\nPlease enter your choice: ");
		choice = input.nextInt();

		if(choice == 0){ //EXIT THE PROGRAM
			System.out.println("\nBYE BYE!");
			System.exit(0);
		}

		else if(choice == 1){ //ADD ANIMAL
			Animal a = null;
			System.out.print("\n1 - Chicken"
					+ "\n2 - Donkey"
					+ "\n3 - Horse"
					+ "\n4 - Pig"
					+ "\n5 - Raven"
					+ "\n6 - Sheep"
					+ "\nSelect animal type: ");
				int animalType = input.nextInt();
				System.out.print("Enter the name: ");
				String animalName = input.next();
				System.out.print("Enter the age: ");
				int animalAge = input.nextInt();

				if(animalType == 1){ //chicken
					a = new Chicken(animalName, animalAge);
					try{
						farm.addAnimal(a);
					}
					catch(IllegalNameException ex) {
						System.out.println(ex);
					}
				}
				else if(animalType == 2){ //donkey
					a = new Donkey(animalName, animalAge);
					try{
						farm.addAnimal(a);
					}
					catch(IllegalNameException ex) {
						System.out.println(ex);
					}
				}
				else if(animalType == 3){ //horse
					a = new Horse(animalName, animalAge);
					try{
						farm.addAnimal(a);
					}
					catch(IllegalNameException ex) {
						System.out.println(ex);
					}
				}
				else if(animalType == 4){ //pig
					a = new Pig(animalName, animalAge);
					try{
						farm.addAnimal(a);
					}
					catch(IllegalNameException ex) {
						System.out.println(ex);
					}
				}
				else if(animalType == 5){ //raven
					a = new Raven(animalName, animalAge);
					try{
						farm.addAnimal(a);
					}
					catch(IllegalNameException ex) {
						System.out.println(ex);
					}
				}
				else if(animalType == 6){ //sheep
					a = new Sheep(animalName, animalAge);
					try{
						farm.addAnimal(a);
					}
					catch(IllegalNameException ex) {
						System.out.println(ex);
					}
				}
				else
					System.out.println("Invalid input.");

		}


		else if (choice == 2){ //REMOVE ANIMAL
			System.out.print("Enter the name of the animal you want to remove: ");
			String removedAnimal = input.next();
			farm.removeAnimal(removedAnimal);
		}


		else if (choice == 3){ //SEARCH ANIMAL
			System.out.print("\n1 - Search based on name"
					+ "\n2 - Search based on age"
					+ "\nPlease enter your choice: ");
			int searchChoice = input.nextInt();

			if (searchChoice == 1){ //based on name
				System.out.print("Enter name: ");
				String searchName = input.next();

				farm.searchBasedOnName(searchName);
			}

			else if (searchChoice == 2){ //based on age
				System.out.print("Enter age: ");
				int searchAge = input.nextInt();

				farm.searchBasedOnAge(searchAge);
			}
			else
				System.out.println("Invalid input.");
		}


		else if (choice == 4){ //SORT ANIMALS
			System.out.print("\n1 - Sort based on name"
					+ "\n2 - Sort based on leg number"
					+ "\n3 - Sort based on age"
					+ "\n4 - Sort based on addition date"
					+ "\nPlease enter your choice: ");
			int sortChoice = input.nextInt();

			if(sortChoice == 1){  //based on name
				farm.sortAlphabetically();
			}
			else if(sortChoice == 2){ //based on leg number
				farm.sortBasedOnLegNumber();
			}
			else if(sortChoice == 3){ //based on age
				farm.sortBasedOnAge();
			}
			else if(sortChoice == 4){ //base on addþtþon date
				farm.sortBasedOnDate();
			}
			else
				System.out.println("Invalid input.");
		}


		else if (choice == 5){ //CALCULATE THE NEXT YEAR'S POPULATION ESTIMATE
			System.out.println(farm.nextYearPopulationForecast());
		}


		else if (choice == 6){ //PRINT ALL ANIMAL'S MOVEMENTS
			farm.animalMovements();
		}


		else if (choice == 7){ //PRINT ALL ANIMAL'S EATING HABITS
			farm.eatingHabits();
		}


		else if (choice == 8){ //PRINT REPORT
			System.out.println("Ener filename: ");
			String fileName = input.next();

			farm.printReport(fileName);
		}

		else
			System.out.println("Unvalid input!");

		} while(choice != 0);

	}

}
