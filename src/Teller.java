import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

public class Teller {

	public static void main(String[] args) throws ParseException, AccountTypeAlreadyExistsException {

		JFrame atmgui = new ATMGUI();
		atmgui.setVisible(true);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Customer c = new Customer("Andrzej", "Kowalski", sdf.parse("17.12.1995"));
		c.setAddress("15-445", "Opole", "Kosciuszki");
		c.setEmail("andrzej@gmail.com");
		c.setPhone("998765432");
		c.addAccount(new Savings(c, 5000));
		Bank.addCustomer(c);
		Customer c2 = new Customer("Maciek", "Nowak", sdf.parse("12.7.1969"));
		c2.setAddress("45-340 ", "Wroc³aw", "Miodowa 2");
		c2.setEmail("zzzzzz@gmail.com");
		c2.setPhone("997999998");
		Savings s = new Savings(c2, 3500);
		c2.addAccount(s);
		c2.addAccount(new OverdraftProtection(c2, 4302, s));
		Bank.addCustomer(c2);
		Customer c3 = new Customer("Ann", "Jason", sdf.parse("05.7.1950"));
		c3.setAddress("420 pogchamp Street", "New York", "420 pogchamp Street");
		c3.setEmail("yyuio@gmail.com");
		c3.setPhone("876412309");
		Savings s2 = new Savings(c2, 3500);
		c3.addAccount(s);
		c3.addAccount(new OverdraftProtection(c2, 4302, s2));
		Bank.addCustomer(c3);
		JFrame list = new ListOfCustomersGui();
		for(int i=4;i<20;i++)
			Bank.addCustomer(c);
		atmgui.setVisible(true);
		list.setVisible(true);
		Bank.clearList();		
	}

}
