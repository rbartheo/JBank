
public class AmountOverDrawnException extends Exception {

	private Account acct;
	
	public AmountOverDrawnException(Account acct) {
		this.acct = acct;
	}
	
	@Override
	public String getMessage() {
		String msg = "";
		if(acct instanceof Savings) {
			msg = "insufficient amount in savings account";
			
		}
		if(acct instanceof Investment) {
			msg = "insufficient amount in Investment account";
			
		}
		if(acct instanceof LineOfCredit) {
			msg = "insufficient amount in Line of Credit account";
			
		}
		if(acct instanceof OverdraftProtection) {
			msg = "insufficient amount in Overdraft Protection account";
			
		}
		return msg;
	}
	
}
