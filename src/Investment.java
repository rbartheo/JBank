import java.util.*;

public final class Investment extends Savings {

	private Date startDate;
	private Date endDate;
	private int term;
	private double interestRate;

	public Investment(Customer cust, double amount, int terms) {
		super(cust, amount);
		if (terms < 6) {
			terms = 6;
		}
		this.term = terms;
		Calendar s = new GregorianCalendar();
		startDate = s.getTime();
		s.add(Calendar.MONTH, terms);
		endDate = s.getTime();

		if (terms <= 6) {
			interestRate = .05;
		} else if (terms > 6 & terms <= 12) {
			interestRate = .06;
		} else {
			interestRate = .07;
		}
		acctType = "I";

	}

	@Override
	public void addDailyInterest(int days) {
		double f = Math.pow(((1 + (interestRate / 365))), (365 * days));
		f = f * balance;
		interestEarned = f - balance;
		balance = f;
	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {
		if (balance - amount >= 10) {
			if (Calendar.getInstance().before(endDate)) {
				balance -= amount;
				
			} else {
				if (amount < (balance - (0.20 * balance))) {
					balance = balance - (0.2 * balance) - amount;
					
				} else
					throw new AmountOverDrawnException(this);
			}
		} else
			throw new AmountOverDrawnException(this);
	}

}
