
public class EmailException extends Exception {
	private String email;
	EmailException(String email){
		this.email = email;
	}
	@Override
	public String getMessage() {
		return "Email doesn't contain @ sign";
	}
}
