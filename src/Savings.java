
public class Savings extends Account {

	protected double interestEarned;

	public Savings(Customer cust, double amount) {
		super();
		id = Integer.toString(cust.getCustID());
		balance = amount;
		acctType = "S";
	}

	public void addDailyInterest(int days) {
		double f = Math.pow((1 + (.03 / 365)), (365 * days));
		f = f * balance;
		interestEarned = f - balance;
		balance = f;

	}

	public double getInterestEarned() {
		return interestEarned;
	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {
		if (balance - amount > 10) {
			balance -= amount;			
		}
		else {
		throw new AmountOverDrawnException(this);
		}
	}

}
