
public class OverdraftProtection extends Checking {

	private Savings savingsAccount;

	public OverdraftProtection(Customer cust, double amount, Savings savingsAccount) {
		super();
		id = Integer.toString(cust.getCustID());
		balance = amount;
		this.savingsAccount = savingsAccount;
		acctType = "O";

	}

	@Override
	public void feeAssessment() {
		monthlyFee += 3;
		balance -= 3;
	}

	@Override
	public void withdraw(double amount) throws AmountOverDrawnException {
		if (amount > balance + savingsAccount.getBalance() - 10) {
			throw new AmountOverDrawnException(this);
		} else if (amount > balance) {
			savingsAccount.withdraw(amount - balance);
			balance = 0;
			feeAssessment();

		} else {
			balance -= amount;

		}

	}

}
