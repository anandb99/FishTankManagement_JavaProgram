package FishManagement;

import java.util.Scanner;


public class fishManagement 
{
	private static Scanner reader;

	public static void main(String[] args) 
	{
		char userChoice;
		reader = new Scanner(System.in);
		int maxRecords = 8;
		int fishIndex = 0;
		int foodIndex = 0;

		Fish[] myFish = new Fish[maxRecords];
		Food[] fishFood = new Food[maxRecords];
		Manager fishManager = new Manager();

		String typeOfFish;
		String typeOfFood; 	// this typeOfFish eats this "typeOfFood"
		int feedTime;		// in hours, after every "feedTime" hours, fish needs to be fed
		int quantity;		// quantity of typeOfFish in tank
		int foodUnit;

		String typeOfFishFood;
		int unitAvailable;

		do
		{
			System.out.println("********** Fish Management Application Menu **********");
			System.out.println("1. Enter fish details.");
			System.out.println("2. Enter food details.");
			System.out.println("3. Manage.");
			System.out.println("4. Print fish information.");
			System.out.println("5. Print food information.");
			System.out.println("9. Exit.");

			userChoice = reader.next().charAt(0);
			System.out.println("You have entered: "+userChoice);

			switch(userChoice)
			{
			case '1':
				// Case 1. Enter fish details.
				typeOfFish = reader.nextLine();
				System.out.println("Enter typeOfFish : ");
				typeOfFish = reader.nextLine();
				System.out.println("Enter fish quantity : ");
				quantity = reader.nextInt();
				typeOfFood = reader.nextLine();
				System.out.println("Enter typeOfFood : ");
				typeOfFood = reader.nextLine();
				System.out.println("Enter feedTime : ");
				feedTime = reader.nextInt();
				System.out.println("Enter food unit : ");
				foodUnit=reader.nextInt();

				//System.out.println("typeOfFish: "+typeOfFish+" typeOfFood: "+typeOfFood+" feedTime: "+feedTime+" quantity: "+quantity+" foodUnit: "+foodUnit);

				Fish fish = new Fish(typeOfFish,typeOfFood,feedTime, quantity, foodUnit);
				myFish[fishIndex] = fish;
				fishIndex++;

				break;

			case '2':
				// Case 2. Enter food details.
				typeOfFishFood = reader.nextLine();
				System.out.println("Enter typeOfFishFood : ");
				typeOfFishFood = reader.nextLine();
				System.out.println("Enter fish food quantity : ");
				unitAvailable = reader.nextInt();

				Food food = new Food(typeOfFishFood,unitAvailable);		
				fishFood[foodIndex] = food;
				foodIndex++;

				break;

			case '3':
				// Case 3. Manage.
				fishManager.printData(myFish, fishFood,fishIndex,foodIndex);
				break;

			case '4':
				// Case 4. Print fish information.
				for (int i=0;i<fishIndex;i++)
				{
					myFish[i].printFish();
				}
				break;

			case '5':
				// Case 5. Print food information.
				for (int i=0;i<foodIndex;i++)
				{
					fishFood[i].printFood();
				}
			}

		}while(userChoice!='9');
	}

}

class Fish
{
	private String typeOfFish;
	private String typeOfFood; 	// this typeOfFish eats this "typeOfFood"
	private int feedTime;		// in hours, after every "feedTime" hours, fish needs to be fed
	private int quantity;		// quantity of typeOfFish in tank
	private int foodUnit;		// at each feedTime, this typeOfFish eats "foodUnit" amout of food

	Fish()
	{
		typeOfFish =  null;
		typeOfFood = null;
		feedTime =0;
		quantity =0;
		foodUnit =0;
	}

	Fish(String givenTypeOfFish,String givenTypeOfFood,int givenFeedTime, int givenQuanity, int givenFoodUnit)
	{
		typeOfFish =  givenTypeOfFish;
		typeOfFood = givenTypeOfFood;
		feedTime =givenFeedTime;
		quantity =givenQuanity;
		foodUnit =givenFoodUnit;
	}

	public String getTypeOfFish()
	{
		return typeOfFish;
	}

	public void setTypeOfFish(String typeOfFish)
	{
		this.typeOfFish = typeOfFish;
	}

	public String getTypeOfFood()
	{
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood)
	{
		this.typeOfFood = typeOfFood;
	}

	public int getFeedTime() 
	{
		return feedTime;
	}

	public void setFeedTime(int feedTime) 
	{
		this.feedTime = feedTime;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public int getFoodUnit() 
	{
		return foodUnit;
	}

	public void setFoodUnit(int foodUnit) 
	{
		this.foodUnit = foodUnit;
	}

	public void printFish()
	{
		System.out.println("\n typeOfFish: "+typeOfFish+", typeOfFood: "+typeOfFood+", feedTime: "+feedTime+", quantity: "+quantity+", foodUnit: "+foodUnit+"\n");
	}
}

class Food
{
	private String typeOfFood;
	private int unitAvailable;

	Food()
	{
		typeOfFood = null;
		unitAvailable = 0;
	}

	public void printFood() 
	{
		System.out.println("\n typeOfFood: "+typeOfFood+", unitAvailable: "+unitAvailable+"\n");	
	}

	Food(String givenTypeOfFood, int givenUnitAvailable)
	{
		typeOfFood = givenTypeOfFood;
		unitAvailable = givenUnitAvailable;
	}

	public String getTypeOfFood() 
	{
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood) 
	{
		this.typeOfFood = typeOfFood;
	}

	public int getUnitAvailable()
	{
		return unitAvailable;
	}

	public void setUnitAvailable(int unitAvailable)
	{
		this.unitAvailable = unitAvailable;
	}
}

class Manager
{
	public void printData(Fish[] myFish, Food[] fishFood, int fishCounter, int foodCounter)
	{
		for (int i=0;i<fishCounter;i++)
		{
			System.out.println("\n "+myFish[i].getTypeOfFish()+" ate " +myFish[i].getFoodUnit()+" units of food on average per day");
			System.out.println("\n "+myFish[i].getTypeOfFish()+" ate " +myFish[i].getFeedTime()+" times on average per day");
		}
	}
}