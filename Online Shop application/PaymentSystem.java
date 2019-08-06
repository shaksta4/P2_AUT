/**
 * This is the payment system interface. It lists the method signatures which will be overridden
 * by any class which implements this interface
 * 
 * @author Shakeel Khan
 * Date: 31/06/2016
 */
public interface PaymentSystem {

	public Double amountOwing();
	public void completeTransaction();
}
