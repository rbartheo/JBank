import java.util.*;

public class Customer {

	private String postalCode;
	private String cityName;
	private String address;
	private final int custID;
	private String firstName;
	private String lastName;
	private int numOfAccounts;
	private final Date DOB;
	private String emailAddress;
	private String phoneNumber;
	private Account[] accounts = new Account[4];

	public Customer(String lastName, String firstName, Date DOB) {

		this.DOB = DOB;
		this.lastName = lastName;
		this.firstName = firstName;
		custID = Bank.getNextID();

	}

	public Customer(String lastName, String firstName) {

		this(lastName, firstName, null);

	}

	public Date getDOB() {
		return DOB;
	}

	public void setEmail(String email) {
		this.emailAddress = email;
	}

	public String getEmail() {
		return emailAddress;
	}

	public void setName(String lname, String fname) {
		this.lastName = lname;
		this.firstName = fname;
	}

	public String getLastName() {
		return  lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	

	public void setAddress(String city, String address, String postalCode) {
		this.cityName = city;
		this.address = address;
		this.postalCode = postalCode;

	}
	
	public String getCity() {
		return cityName;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public String getAddress() {
		return   address;
	}

	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public boolean addAccount(Account acct) throws AccountTypeAlreadyExistsException {
		boolean accountAdded = true;
		if (numOfAccounts > 4) {
			accountAdded = false;
		} else {
			int notUsed = -1;
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i] == null && notUsed == -1) {
					notUsed = i;
				} else {
					if (accounts[i] != null) {
						if (accounts[i].getAcctType() == acct.getAcctType()) {
							accountAdded = false;
						}
					}
				}
			}
			if (notUsed != -1 && accountAdded) {
				accounts[notUsed] = acct;
				accountAdded = true;
				++numOfAccounts;
			}
		}
		return accountAdded;
	}

	public Account getAccount(String acctType) {
		Account acct = null;
		for (int i = 0; i < accounts.length; i++) {
			Account a = accounts[i];

			switch (acctType) {
			case "S":
				if (accounts[i] instanceof Savings) {
					acct = accounts[i];

				}
				break;
			case "L":

				if (accounts[i] instanceof LineOfCredit) {
					acct = accounts[i];

				}
				break;

			case "O":

				if (accounts[i] instanceof OverdraftProtection) {
					acct = accounts[i];

				}
				break;

			case "I":

				if (accounts[i] instanceof Investment) {
					acct = accounts[i];

				}
				break;

			}

		}
		return acct;
	}

	public boolean removeAccount(String acctType) {
		boolean remove = false;

		for (int i = 0; i < accounts.length; i++) {

			switch (acctType) {
			case "S":
				if (accounts[i] instanceof Savings) {
					accounts[i] = null;
					remove = true;

				}
				break;
			case "L":

				if (accounts[i] instanceof LineOfCredit) {
					accounts[i] = null;
					remove = true;

				}
				break;

			case "O":

				if (accounts[i] instanceof OverdraftProtection) {
					accounts[i] = null;
					remove = true;

				}
				break;

			case "I":

				if (accounts[i] instanceof Investment) {
					accounts[i] = null;
					remove = true;

				}
				break;

			}

		}
		return remove;
	}

	public int getCustID() {
		return custID;
	}

	public int getNumOfAccounts() {
		return numOfAccounts;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName + " " + custID;
	}

}
