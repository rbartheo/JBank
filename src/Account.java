
public abstract class Account {

	protected double balance;
	protected String id;
	protected String acctType;

	/*
	 * public Account(Customer cust, String acctType, double balance) {
	 * this.acctType = acctType; this.balance = balance; id =
	 * Integer.toString(cust.getCustID());
	 * 
	 * }
	 */

	public String getID() {
		return id;
	}

	/*
	 * public void setType(String acctType) { this.acctType = acctType; }
	 */

	public String getAcctType() {
		return acctType;
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public double getBalance() {
		return balance;
	}

	public abstract void withdraw (double amount) throws AmountOverDrawnException;

	public boolean deposit(double amount) {
		if (amount < 0) {
			return false;
		} else {
			balance += amount;
			return true;
		}

	}

	@Override
	public String toString() {
		return id;
	}

}
