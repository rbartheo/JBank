import java.util.Calendar;
import java.util.GregorianCalendar;

public class LineOfCredit extends Checking {

	private double creditBalance;
	private double creditLimit;

	public LineOfCredit(Customer cust, double amount, double creditLimit) {
		super();
		id = Integer.toString(cust.getCustID());
		balance = amount;
		this.creditLimit = creditLimit;
		acctType = "L";
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double amount) {
		creditBalance = amount;
	}

	public void setCreditLimit(double amount) {
		creditLimit = amount;
	}

	@Override
	protected void feeAssessment() {
		int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		double deficit = creditLimit - creditBalance;
		double amt = Math.pow(1 + (0.21 / 365), 356 * days);
		amt = amt * deficit;
		monthlyFee = amt - deficit;
	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {

		if (amount > balance + creditBalance) {
			throw new AmountOverDrawnException(this);
		} else if (amount > balance) {
			balance = 0;
			creditBalance -= (amount - balance);

		} else {
			balance = balance - amount;

		}

	}

}
