import java.text.SimpleDateFormat;
import java.util.*;

public class Bank {

	private static double creditInterestRate;
	private static Date closeTime;
	private static double investmentInterestRate;
	private static int lastCustId;
	private static int nextCustId;
	private static double premiumInterestRate;
	private static Date startTime;
	public static final String BANK_ADDRESS = "1234 JavaStreet, AnyCity, ThisState, 34567";
	public static int MAX_NUM_OF_CUSTOMERS = 20;
	public static final String BANK_NAME = "JBank";
	private static String phone;
	private static String website;
	private static int numOfCurrentCustomers;
	private static Customer[] customers = new Customer[MAX_NUM_OF_CUSTOMERS];

	private Bank() {

	}

	public static boolean addCustomer(Customer customer) {
		for (int ArraySearch = 0; ArraySearch < MAX_NUM_OF_CUSTOMERS; ArraySearch++) {
			if (customers[ArraySearch] == null) {
				customers[ArraySearch] = customer;
				return true;
			}
		}
		return false;
	}
	
	public static Customer[] getCustomers() {
		return customers;
	}

	public static Customer getCustomer(int custID) {
			for (int i = 0; i < numOfCurrentCustomers; i++) {
			if (customers[i].getCustID() == custID) {
				return customers[i];
			}
		}
		return null;
	}
	
	
	public static void removeCustomer(int custId) {
		for (int i = 0; i < numOfCurrentCustomers; i++) {
			if (custId == customers[i].getCustID()) {
				if (numOfCurrentCustomers == i) {
					customers[i] = null;
					numOfCurrentCustomers--;
				}
				else
				{
					customers[i] = null;
					for(int sort=i;sort<numOfCurrentCustomers;sort++) {
						customers[sort] = customers[sort+1];
					}
					numOfCurrentCustomers--;
				}
			}
		}
	}
	
	public static void updateCustomer(Customer c)
	{
		for (int i = 0; i < numOfCurrentCustomers; i++) {
			if (c.getCustID() == customers[i].getCustID())
				customers[i] = c;
		}
	}

	public static int getMaxNumberOfCustomers() {
		return MAX_NUM_OF_CUSTOMERS;

	}

	public static Customer[] customers() {
		return customers;
	}

	public static int getNumOfCurrentCustomers() {
		return numOfCurrentCustomers;
	}

	public static void setCreditRate(double rate) {
		creditInterestRate = rate;
	}

	public double getCreditRate() {
		return creditInterestRate;
	}

	public static void setInvestmentRate(double rate) {
		investmentInterestRate = rate;
	}

	public static double getInvestmentRate() {
		return investmentInterestRate;
	}

	public static void setPremiumRate(double rate) {
		premiumInterestRate = rate;
	}

	public static double getPremiumRate() {
		return premiumInterestRate;
	}

	public static void setWebSite(String site) {
		website = site;
	}

	public static String getWebSite() {
		return website;
	}

	public static void setPhone(String phonenum) {
		phone = phonenum;
	}

	public static String getPhone() {
		return phone;
	}

	public static Date getStartTime() {
		return startTime;
	}

	public static Date getCloseTime() {
		return closeTime;
	}

	public static void setStartTime(Date sTime) {
		startTime = sTime;
	}

	public static void setCloseTime(Date cTime) {
		closeTime = cTime;
	}

	public static String getHoursOfOperation() {
		SimpleDateFormat sdf = new SimpleDateFormat("k:mm");
		return "Hours of operating are form " + sdf.format(startTime) + " to " + sdf.format(closeTime);
	}

	public static int getLastID() {
		return lastCustId;
	}

	public static int getNextID() {
		int return_value = 0;
		if (nextCustId == 0) {
			nextCustId = 1000;
			return_value = nextCustId;
			numOfCurrentCustomers++;
		} else if (numOfCurrentCustomers != MAX_NUM_OF_CUSTOMERS) {
			lastCustId = nextCustId;
			nextCustId++;
			numOfCurrentCustomers++;
			return_value = nextCustId;
		} else {
			return_value = 0;
		}

		return return_value;
	}
	
	public static void clearList() {
		for(int i=19;i>2;i--)
		{
			customers[i] = null;
		}
		numOfCurrentCustomers = 3;
	}

	/*
	 * public static int getMaxCustomers() { return maxNumOfCustomers; }
	 * 
	 * public static String getName() { return bankName; }
	 * 
	 * public static String getAddress() { return bankAddress; }
	 */

}
