package application;
/**
 * Class IllegalPizza extends Exception(to be used as an exception)
 * This class represents an illegal pizza exception, which is an exception thrown by the class Pizza if it is supplied with illegal parameters
 * @author 16ajjf
 * @version 1
 */
public class IllegalPizza extends Exception{
	private static final long serialVersionUID = 2551114365193707563L;
	//default constructor, creates message for exception
	public IllegalPizza() {
		super("Illegal parameter provided to Pizza or LineItem Object.");
	}
}
