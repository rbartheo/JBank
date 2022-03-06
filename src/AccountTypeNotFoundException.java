
public class AccountTypeNotFoundException extends Exception {

	private String acctType;

	public AccountTypeNotFoundException(String acctType) {
		this.acctType = acctType;

	}

	@Override
	public String getMessage() {
		String msg = "";
		switch (acctType) {
		case "S":
			return msg = "Can't find Savings account";
		case "I":
			return msg = "Can't find Investment account";
		case "L":
			return msg = "Can't find Line of Credit account";
		case "O":
			return msg = "Can't find Overdraft Protection account";
		}
		return msg;
	}
}
