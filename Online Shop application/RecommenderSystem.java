/**
 * This class is the recommender system for the online shop. It holds a constructor which initialises it with
 * starting values and a single method which returns an arraylist of recommendations for the user.
 * @author Shakeel Khan
 * Date 26/06/2016
 */

import java.util.*;

public class RecommenderSystem {
	
	private ProductDatabase pd;
	private HashSet<PurchaseHistory> purchaseHistory;
	
	//Default Constructor
	public RecommenderSystem(ProductDatabase pd, HashSet<PurchaseHistory> ph)
	{
		this.pd = pd;
		this.purchaseHistory = ph;
	}
	/**
	 * This method holds the algorithm for which the recommended items are based upon.
	 * It searches through the user's cart and checks if items in the cart have also been bought along with
	 * other popular items by other customers and if they have been with a frequence greater than
	 * that specified, it returns these products in an array list.
	 * @param cart
	 * @param freq
	 * @return
	 */
	ArrayList<Product> praAlgorithm(ArrayList<Product> cart, int freq)
	{
		for(int i = 0; i < cart.size(); i++)
		{
			
		}

		return null;
	}
}
