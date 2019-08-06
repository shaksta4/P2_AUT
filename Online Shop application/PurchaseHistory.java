/**
 * 
 * This class holds the purchase history of previous customers in an arraylist. It holds a constructor initialising it
 * with starting values and a single function which gets these products in an arraylist.
 * @author Shakeel Khan
 * Date:31/06/2016
 */

import java.util.*;

public class PurchaseHistory {
	
	private ArrayList<Product> products;
	
	//Default Constructor
	public PurchaseHistory(ArrayList<Product> products)
	{
		this.products = products;
	}

	/**
	 * This method gets the values in the Arraylist. It returns an arraylist.
	 * @return
	 */
	public ArrayList<Product> getProducts() 
	{
		return this.products;
	}

}
