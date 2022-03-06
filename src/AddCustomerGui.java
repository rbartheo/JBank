import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddCustomerGui extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField cityName;
	private JTextField emailAddress;
	private JTextField postalCode;
	private JTextField streetAddress;
	private JTextField phoneNumber;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField balance;
	private JButton check;
	private JTextField DOB;

	public AddCustomerGui() {
		buildWindow();
	}

	public void buildWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{67, 89, 8, 254, 0};
		gbl_contentPane.rowHeights = new int[]{26, 26, 26, 26, 26, 26, 26, 16, 2, 26, 29, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				
						JLabel lblNewLabel_1 = new JLabel("First Name");
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 1;
						gbc_lblNewLabel_1.gridy = 0;
						contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
								
										firstName = new JTextField();
										GridBagConstraints gbc_firstName = new GridBagConstraints();
										gbc_firstName.fill = GridBagConstraints.BOTH;
										gbc_firstName.insets = new Insets(0, 0, 5, 0);
										gbc_firstName.gridwidth = 2;
										gbc_firstName.gridx = 2;
										gbc_firstName.gridy = 0;
										contentPane.add(firstName, gbc_firstName);
										firstName.setColumns(10);
						
								JLabel lblNewLabel_2 = new JLabel("Last Name");
								GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
								gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_2.gridx = 1;
								gbc_lblNewLabel_2.gridy = 1;
								contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
								
										lastName = new JTextField();
										GridBagConstraints gbc_lastName = new GridBagConstraints();
										gbc_lastName.fill = GridBagConstraints.BOTH;
										gbc_lastName.insets = new Insets(0, 0, 5, 0);
										gbc_lastName.gridwidth = 2;
										gbc_lastName.gridx = 2;
										gbc_lastName.gridy = 1;
										contentPane.add(lastName, gbc_lastName);
										lastName.setColumns(10);
						
								JLabel lblNewLabel_3 = new JLabel("City name");
								GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
								gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
								gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_3.gridx = 1;
								gbc_lblNewLabel_3.gridy = 2;
								contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
				
						cityName = new JTextField();
						GridBagConstraints gbc_cityName = new GridBagConstraints();
						gbc_cityName.fill = GridBagConstraints.BOTH;
						gbc_cityName.insets = new Insets(0, 0, 5, 0);
						gbc_cityName.gridwidth = 2;
						gbc_cityName.gridx = 2;
						gbc_cityName.gridy = 2;
						contentPane.add(cityName, gbc_cityName);
						cityName.setColumns(10);
				
						JLabel lblNewLabel_4 = new JLabel("Email address");
						GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
						gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTH;
						gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
						gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_4.gridx = 1;
						gbc_lblNewLabel_4.gridy = 3;
						contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
				
						emailAddress = new JTextField();
						GridBagConstraints gbc_emailAddress = new GridBagConstraints();
						gbc_emailAddress.fill = GridBagConstraints.BOTH;
						gbc_emailAddress.insets = new Insets(0, 0, 5, 0);
						gbc_emailAddress.gridwidth = 2;
						gbc_emailAddress.gridx = 2;
						gbc_emailAddress.gridy = 3;
						contentPane.add(emailAddress, gbc_emailAddress);
						emailAddress.setColumns(10);
						
								JLabel lblNewLabel = new JLabel("Postal code");
								GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
								gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel.gridx = 1;
								gbc_lblNewLabel.gridy = 4;
								contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
						postalCode = new JTextField();
						GridBagConstraints gbc_postalCode = new GridBagConstraints();
						gbc_postalCode.fill = GridBagConstraints.BOTH;
						gbc_postalCode.insets = new Insets(0, 0, 5, 0);
						gbc_postalCode.gridwidth = 2;
						gbc_postalCode.gridx = 2;
						gbc_postalCode.gridy = 4;
						contentPane.add(postalCode, gbc_postalCode);
						postalCode.setColumns(10);
				
						JLabel lblNewLabel_5 = new JLabel("Street adress");
						GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
						gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
						gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_5.gridx = 1;
						gbc_lblNewLabel_5.gridy = 5;
						contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
						
								streetAddress = new JTextField();
								GridBagConstraints gbc_streetAddress = new GridBagConstraints();
								gbc_streetAddress.fill = GridBagConstraints.BOTH;
								gbc_streetAddress.insets = new Insets(0, 0, 5, 0);
								gbc_streetAddress.gridwidth = 2;
								gbc_streetAddress.gridx = 2;
								gbc_streetAddress.gridy = 5;
								contentPane.add(streetAddress, gbc_streetAddress);
								streetAddress.setColumns(10);
				
						lblNewLabel_6 = new JLabel("Phone number");
						GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
						gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTH;
						gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
						gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_6.gridwidth = 2;
						gbc_lblNewLabel_6.gridx = 1;
						gbc_lblNewLabel_6.gridy = 6;
						contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
				
						phoneNumber = new JTextField();
						GridBagConstraints gbc_phoneNumber = new GridBagConstraints();
						gbc_phoneNumber.fill = GridBagConstraints.BOTH;
						gbc_phoneNumber.insets = new Insets(0, 0, 5, 0);
						gbc_phoneNumber.gridwidth = 2;
						gbc_phoneNumber.gridx = 2;
						gbc_phoneNumber.gridy = 6;
						contentPane.add(phoneNumber, gbc_phoneNumber);
						phoneNumber.setColumns(10);
		
				lblNewLabel_7 = new JLabel("Balance");
				GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
				gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel_7.fill = GridBagConstraints.VERTICAL;
				gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_7.gridx = 1;
				gbc_lblNewLabel_7.gridy = 7;
				contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
				check = new JButton("Check");
				check.addActionListener(this);
				
						balance = new JTextField();
						GridBagConstraints gbc_balance = new GridBagConstraints();
						gbc_balance.fill = GridBagConstraints.BOTH;
						gbc_balance.insets = new Insets(0, 0, 5, 0);
						gbc_balance.gridwidth = 2;
						gbc_balance.gridx = 2;
						gbc_balance.gridy = 7;
						contentPane.add(balance, gbc_balance);
						balance.setColumns(10);
						
								JLabel lblNewLabel_7_1 = new JLabel("Date of birth");
								GridBagConstraints gbc_lblNewLabel_7_1 = new GridBagConstraints();
								gbc_lblNewLabel_7_1.anchor = GridBagConstraints.NORTH;
								gbc_lblNewLabel_7_1.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblNewLabel_7_1.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_7_1.gridheight = 2;
								gbc_lblNewLabel_7_1.gridx = 1;
								gbc_lblNewLabel_7_1.gridy = 8;
								contentPane.add(lblNewLabel_7_1, gbc_lblNewLabel_7_1);
				
						DOB = new JTextField();
						DOB.setColumns(10);
						GridBagConstraints gbc_DOB = new GridBagConstraints();
						gbc_DOB.fill = GridBagConstraints.BOTH;
						gbc_DOB.insets = new Insets(0, 0, 5, 0);
						gbc_DOB.gridwidth = 2;
						gbc_DOB.gridx = 2;
						gbc_DOB.gridy = 8;
						contentPane.add(DOB, gbc_DOB);
				GridBagConstraints gbc_check = new GridBagConstraints();
				gbc_check.anchor = GridBagConstraints.WEST;
				gbc_check.fill = GridBagConstraints.VERTICAL;
				gbc_check.gridx = 3;
				gbc_check.gridy = 10;
				contentPane.add(check, gbc_check);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat dateToAdd = new SimpleDateFormat("dd.MM.yyyy");
		String lastName = this.lastName.getText();
		String firstName = this.firstName.getText();
		String postalCode = this.postalCode.getText();
		String cityName = this.cityName.getText();
		String streetAddress = this.streetAddress.getText();
		String email = this.emailAddress.getText();
		String phoneNumber = this.phoneNumber.getText();
		String balance = this.balance.getText();
		Date DOB;
		try {
			DOB = dateToAdd.parse(this.DOB.getText());
			checkEmail(email);
			checkBalance(balance);
			Customer c = new Customer(lastName, firstName, DOB);
			c.setAddress(postalCode, cityName, streetAddress);
			c.setEmail(email);
			c.setPhone(phoneNumber);
			Savings s = new Savings(c, Double.parseDouble(balance));
			c.addAccount(s);
			Bank.addCustomer(c);
			dispose();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (BalanceException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (AccountTypeAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void checkEmail(String email) throws EmailException {
		boolean check = false;
		if (email.contains("@"))
			check = true;
		if (check == false)
			throw new EmailException(email);
	}

	private void checkBalance(String balance) throws BalanceException
	{
		boolean check = true;
		for(int i = 0;i<balance.length();i++) {
		if(!Character.isDigit(balance.charAt(i)))
		{
			if(balance.charAt(i)!='.')
				check = false;
		}
		}
		if(check ==true) {
			double bal = Double.parseDouble(balance);
			if(bal<10)
			{
				check = false;
			}
		}
		if(check == false)
		{
			throw new BalanceException(balance);
		}
	}
}
