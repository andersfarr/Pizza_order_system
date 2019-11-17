package application;

import java.io.Serializable;

/**
 * LineItem class 
 * This class represents an order of a Pizza and the number of those pizzas ordered.
 * There must be between 1 and 100 pizzas ordered.
 * <p>This class implements Serializable, to be saved to a file, and Comparable<LineItem> to create comparability of LineItem Objects for sorting purposes.
 * This class has a constructor which takes a number and a Pizza object, checks that that number is within the range of possible ordered pizzas, throws an IllegalPizza Exception if so and if not creates an order of that type.
 * This class also has a second constructor which defaults to one pizza for the order.
 * <p>This class has full mutability for the number of pizzas being ordered in the getNumber methods, with setNumber throwing an IllegalPizza exception if it gets given an illegal value.
 * The getPizza method returns a Pizza object - the current order.
 * The getCost method computes the cost of the entire order.
 * The toString method converts the lineItem Class to a String representation, and compareTo is used to show the basis for comparison
 * @author 16ajjf
 * @version 1
 */
public class LineItem implements Serializable, Comparable<LineItem>{
	private static final long serialVersionUID = 7154598313531455038L;
	//serial Number
	//Pizza Object which is the order that this LineItem represents
	private Pizza order;
	//number of pizzas
	private int numPizzas;
	/**
	 * Constructor which takes a number and a Pizza object.
	 * It checks that the number is within the range of possible ordered pizzas (1 to 100), throws an IllegalPizza Exception if so and if not creates an order of that type.
	 * @param pizzanumber the number of pizzas being ordered
	 * @param pizza the pizza object being ordered
	 * @throws IllegalPizza
	 */
	public LineItem(int pizzanumber, Pizza pizza) throws IllegalPizza {
		//check for correct pizzanumber values
		if(pizzanumber >100 || pizzanumber < 1 || pizza == null) 
			throw new IllegalPizza();
		else {
			//set attributes
			numPizzas = pizzanumber;
			order =pizza;
		}
		
	}//end first constructor
	/**
	 * Constructor which takes in only a pizza and defaults the number of pizzas to 1.
	 * @param pizza the pizza being ordered
	 */
	public LineItem(Pizza pizza) throws IllegalPizza{
		if(pizza ==  null)
			throw new IllegalPizza();
		else {
			numPizzas = 1;
			order = pizza;
		}
		
	}//end second constructor
	/**
	 * Accessor method for pizza order.
	 * @return the pizza for this LineItem.
	 */
	public Pizza getPizza() {
		return order;
	}//end getPizza
	/**
	 * Accessor method for number of pizzas in this LineItem.
	 * @return number of pizzas.
	 */
	public int getNumber() {
		return numPizzas;
	}//end getNumber
	/**
	 * Mutator Method for number of pizzas in this lineItem.
	 * Throws IllegalPizza Exception if value given is outside of legal range(1-100).
	 * @param n the number of pizzas being set in the order
	 * @throws IllegalPizza
	 */
	public void setNumber(int n) throws IllegalPizza{
		//check if value is illegal
		if(n >100 || n < 1) 
			throw new IllegalPizza();
		else {
			numPizzas = n;
		}
	}//end setNumber
	/**
	 * GetCost Method- generates and then returns a cost for this lineItem.
	 * This method invokes the getCost method of the Pizza class to get the cost of one pizza of this LineItem's type.
	 * It computes the value of the total LineItem order by multiplying the cost of one pizza by the number of Pizzas in this LineItem, and then applies the discount 5% off for orders between 10 and 20 pizzas, and 10% off for orders above 20 pizzas.
	 * @return the cost of the LineItem order.
	 */
	public double getCost() {
		//"Regular" cost
		if (numPizzas <10) 
			return numPizzas*order.getCost();
		//Cost for deal - 5% off between 10 and 20 pizzas
		else if (numPizzas <=20) 
			return 0.95*numPizzas*order.getCost();
		//Cost for deal - 10% off over 20 pizzas
		else 
			return 0.90*numPizzas*order.getCost();
	}//end getCost
	/**
	 * toString method - converts the LineItem object to a string representation by appending the length of the order to the pizza's toString representation.
	 * Adds a space for orders less than 10, to line out when outputted.
	 * @return the string representation of LineItem
	 */
	public String toString() {
		//Check whether there are under 10 pizzas, adjust the length of the string accordingly
		if(numPizzas<10) {
			return " " + numPizzas + " " + order.toString();
		}
		return numPizzas+ " " + order.toString();
	}//end toString
	/**
	 * compareTo method - for use as comparable
	 * Compares this LineItem object to another based on their cost, it returns 0 if the costs are within 1 of eachother, else returns the difference between this LineItem and the other provided as a parameter
	 * @param otherOrder the order order being compared to
	 * @return integer cast difference between this LineItem and otherOrder
	 */
	public int compareTo(LineItem otherOrder) {
		if (Math.abs(this.getCost() - otherOrder.getCost()) <1)
			return 0;
		return (int)(otherOrder.getCost() - this.getCost());
	}//end compareTo	
}//end LineItem
