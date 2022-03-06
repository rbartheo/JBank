
public class BalanceException extends Exception {
	private String balance;
	BalanceException(String balance){
		this.balance = balance;
	}

	@Override
	public String getMessage() {
		return "Illegal character in balance or insufficient ammount(you need to deposid at least 10.00 to make a account)";
	}
}
