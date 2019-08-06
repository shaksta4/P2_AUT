/**
 * This class is the product database. It saves products in a hashmap, mapping each product to its product code.
 * It holds a contstructor initialising the starting values.
 * It also had method functionality for adding products to the database, getting the database products in an arraylist
 * and a toString method which prints the database in a presentable form.
 * @author Shakeel Khan
 */

import java.util.*;

public class ProductDatabase {
	
	private HashMap<Integer, Product> productMap;
	
	//Default constructor
	public ProductDatabase()
	{
		this.productMap = new HashMap<Integer, Product>();
	}
	/**
	 * This method adds a product to the hashmap, mapping the input product to its hash code.
	 * @param p
	 */
	public void addProduct(Product p)
	{
		this.productMap.put(p.getpCode(), p);
	}
	
	/**
	 * This method saves the database's product values in an array list. It then sorts them according to
	 * price and returns it.
	 * @return
	 */
	public ArrayList<Product> getDatabaseProducts()
	{
		ArrayList<Product> myList = new ArrayList<Product>(this.productMap.values());
		Collections.sort((myList));
		return myList;
	}
	/**
	 * Override for the toString method to print it out in a presentable format.
	 */
	public String toString()
	{ 
		String pDatabase = "";
		int i = 1;
		for(Product p : this.productMap.values())
		{
			pDatabase += i+". "+p.toString()+"\n";
			i++;
		}
		return pDatabase;
	}
}
