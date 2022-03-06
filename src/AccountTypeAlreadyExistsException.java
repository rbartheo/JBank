
public class AccountTypeAlreadyExistsException extends Exception {

	private String acctType;
	
	public AccountTypeAlreadyExistsException(String acctType) {
		this.acctType = acctType;
		
		
	}
	
	@Override
	public String getMessage() {
		String msg = "";
		switch(acctType) {
		case "S":
			return msg = "Savings already exist";
		case "I":
			return msg = "Investment already exist";
		case "L":
			return msg = "Line of Credit already exist";
		case "O": 
			return msg = "Overdraft Protection already exist";	
		}
		return msg;
	}
	
	
}


