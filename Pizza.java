package application;

import java.io.Serializable;
/**
 * Class Pizza 
 * This is a class which describes the behavior and attributes of a pizza order. 
 * <p>The pizza can be size "Small", "Medium or "Large"
 * The pizza can have "Single", "Double" or "Triple" Cheese
 * The pizza can have either "None" or "Single" toppings for pineapple, green pepper, and ham
 * <p>This class implements java.io.Serializable, which is used to save this class to a file inside of a LineItem Object.
 * This  class has a default constructor which creates a small size pizza with ham.
 * This class also has a constructor which takes in arguments for the size, amount of cheese, amount of pineapple, amount of green pepper, and the amount of ham and assigns these values to their attributes after checking that they are valid.
 * <p>This class also includes a getCost method, which calculates the cost of the pizza object.
 * This class also includes overwritten versions of toString, clone, and equals.
 * @author 16ajjf
 * @version 1
 */
public class Pizza implements Serializable{
	private static final long serialVersionUID = 6200112789488936770L;
	//size of pizza
	private String size;
	//amount of cheese on pizza
	private String cheese;
	//amount of pineapple on pizza
	private String pineapple;
	//amount of green pepper on pizza 
	private String greenPepper;
	//amount of ham on pizza
	private String ham;
	//legal size values
	private static final String[] possibleSizes = {"Small", "Medium", "Large"};
	//legal cheese values
	private static final String[] possibleCheeses = {"Single", "Double", "Triple"};
	//legal topping values
	private static final String[] possibleToppings = {"None", "Single"};
	/**
	 * This Constructor takes in arguments for the size, amount of cheese, amount of Pineapple, amount of green pepper and the amount of ham.
	 * If these values are not legal, an IllegalPizza exception will be thrown, if they are legal, then these values are assigned to the attributes of the pizza object
	 * @param sz given size value for constructor
	 * @param amountCheese amount of cheese
	 * @param amountPineapple amount of pineapple
	 * @param amountGreenPepper amount of green pepper
	 * @param amountHam amount of ham
	 * @throws IllegalPizza Exception if values are invalid
	 */
	public Pizza(String sz, String amountCheese, String amountPineapple, String amountGreenPepper, String amountHam) throws IllegalPizza{
		if (areValuesOK(sz, amountCheese, amountPineapple, amountGreenPepper, amountHam)) {
			size = sz;
			cheese = amountCheese;
			pineapple = amountPineapple;
			greenPepper = amountGreenPepper;
			ham = amountHam;
		}
		else {
			throw new IllegalPizza();
		}
	}//end first constructor
	/**
	 * Default Constructor, creates a small size pizza with ham and no other toppings
	 */
	public Pizza() {
		size = "Small";
		cheese = "Single";
		ham = "Single";
		greenPepper = "None";
		pineapple = "None";
		
	}//end default constructor
	/*
	 * This method is used by constructors to check whether the given Strings are legal values for their specific attributes
	 * It returns true if all values are legal and the if there is only green pepper or pineapple if there is ham, else otherwise
	 */
	private static boolean areValuesOK(String sz, String amountCheese, String amountPineapple, String amountGreenPepper, String amountHam) {
		//all variables represent the check of one of the strings, the final representing whether the combination of toppings is legal
		//these values all begin as false, and become true if the condition they represent is found to be legal
		boolean badSizeInput = false;
		boolean badCheeseInput = false;
		boolean badPineappleInput = false;
		boolean badGreenPepperInput = false;
		boolean badHamInput = false;
		boolean badToppingsCombo = false;
		//check if null values provided
		if (sz==null || amountCheese == null || amountPineapple == null|| amountGreenPepper == null|| amountHam == null) {
			return false;
		}
		for (int i = 0; i <3; i++) {
			if(sz.equals(possibleSizes[i])) {
				badSizeInput = true;
			}
			if(amountCheese.equals(possibleCheeses[i])) {
				badCheeseInput = true;
			}
		}
		//Loop to go through possibleToppings and see whether amountPineapple, amountGreenPepper, and amountHam are elements of these arrays

		for(int i = 0; i<2; i++) {
			if(amountHam.equals(possibleToppings[i])) {
				badHamInput = true;
			}
			if(amountPineapple.equals(possibleToppings[i])) {
				badPineappleInput = true;
			}
			if(amountGreenPepper.equals(possibleToppings[i])) {
				badGreenPepperInput = true;
			}
		}
		//check if the toppings combination is legal
		if(!(amountHam.equals("None") && (amountPineapple.equals("Single") || amountGreenPepper.equals("Single"))))
			badToppingsCombo = true;
		//return value, only true if all values are false
		return (badSizeInput && badCheeseInput && badPineappleInput && badGreenPepperInput && badHamInput && badToppingsCombo);
	}//end areValuesOK
	/**
	 * This method calculates the cost of the pizza
	 * A small cheese pizza with single cheese only is $7.00, a medium with cheese only is $9.00 and a large with cheese only is $11.00. Each additional topping costs $1.50 each.
	 * @return Cost of Pizza
	 */
	public double getCost() {
		//cost of the pizza
		double cost = 0;
		//loop to check which size the pizza is and adjust the cost accordingly
		for (int i = 0; i< 3; i++) {
			if (size.equals(possibleSizes[i])) 
				cost = 7.0+2*i;
		}
		//check the amount of cheese and adjust the cost accordingly (3.00 for triple cheese, 1.50 for double cheese
		if (cheese.equals("Triple")) 
			cost += 3.0;
		else if (cheese.equals("Double")) 
			cost += 1.5;
		//check each topping and add 1.50 to the cost for each topping on the pizza
		if (ham.equals("Single")) 
			cost += 1.5;
		if (greenPepper.equals("Single")) 
			cost += 1.5;
		if (pineapple.equals("Single")) 
			cost += 1.5;
		return cost;
	}//end getCost
	/**
	 * ToString Method, converts the pizza object to a string representation
	 * String has form "Medium Pizza, Double cheese, pineapple, green pepper, ham. Cost: $15.00 each."
	 * @return String representation of pizza
	 */
	public String toString() {
		//String of pizza, put in default values
		String pizzaString = size + " pizza, " + cheese+ " cheese";
		//add pineapple, greenPepper, and ham if they are on the pizza
		if (pineapple.equals("Single")) 
			pizzaString = pizzaString + ", pineapple";
		if (greenPepper.equals("Single")) 
			pizzaString = pizzaString + ", green pepper";
		if (ham.equals("Single")) 
			pizzaString = pizzaString + ", ham";
		//add the cost and final bit of formatting
		pizzaString = pizzaString + ". Cost: $"  + String.format("%.2f", getCost()) + " each.";
		return pizzaString;
	}//end toString
	/**
	 * Equals method, compares the current pizza to another pizza object and check if they share the same attributes
	 * @param otherPizza the pizza being compared to
	 * @return boolean value, true if the pizzas share the same size, cheese and toppings
	 */
	public boolean equals(Object other) {
		//boolean to see whether this pizza is equal to otherPizza
		boolean isEquals = true;
		Pizza otherPizza;
		if(other instanceof Pizza) {
			otherPizza = (Pizza)other;
		}
		else {
			return false;
		}
		//check size, then cheese, then pineapple, then green pepper, then ham and set isEquals to false if any of these aren't equal
		if(!(this.size.equals(otherPizza.size)))
			isEquals = false;
		if(!(this.cheese.equals(otherPizza.cheese)))
			isEquals = false;
		if(!(this.pineapple.equals(otherPizza.pineapple)))
			isEquals = false;
		if(!(this.greenPepper.equals(otherPizza.greenPepper)))
			isEquals = false;
		if(!(this.ham.equals(otherPizza.ham)))
			isEquals = false;
		//return whether the pizzas are equal or not
		return isEquals;
	}//end equals
	/**
	 * Clone method, creates a new Pizza object which shares the same size, cheese, pineapple, green pepper, and ham as the current pizza
	 * @return The new pizza 
	 */
	public Pizza clone() {
		//create new Pizza object
		Pizza newPizza = null;
		//create the new Pizza, catch if the constructor throws an exception if it is given an illegal value
		try {
			newPizza = new Pizza(this.size, this.cheese,this.pineapple, this.greenPepper, this.ham);
		}
		//this catch block should not be reached as this pizza should always have legal values
		catch(IllegalPizza e) {
			System.out.println(e.getMessage());
		}
		//return the cloned pizza
		return newPizza;
	}//end clone
}//end Pizza Class
