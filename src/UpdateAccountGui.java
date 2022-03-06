import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class UpdateAccountGui extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;
	private JButton check;
	private JRadioButton over, line, investment;
	private Customer cust;

	public UpdateAccountGui(Customer c) {
		buildUpdateAccountGUI();
		cust = c;
		textField_2.setText(c.getFirstName());
		textField_1.setText(c.getLastName());
		textField_3.setText(c.getCity());
		textField_4.setText(c.getEmail());
		textField.setText(c.getPostalCode());
		textField_5.setText(c.getAddress());
		textField_6.setText(c.getPhone());
	}

	private void buildUpdateAccountGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(61, 16, 74, 16);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(161, 11, 284, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(61, 49, 80, 16);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setBounds(161, 44, 284, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Postal code");
		lblNewLabel_3.setBounds(58, 82, 77, 16);
		contentPane.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setBounds(161, 77, 284, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Email address");
		lblNewLabel_4.setBounds(58, 119, 89, 16);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(161, 114, 284, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(56, 156, 89, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(161, 151, 284, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("City");
		lblNewLabel_5.setBounds(58, 193, 89, 16);
		contentPane.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setBounds(161, 188, 284, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(161, 225, 284, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		lblNewLabel_6 = new JLabel("Phone number");
		lblNewLabel_6.setBounds(56, 230, 101, 16);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Balance");
		lblNewLabel_7.setBounds(56, 267, 58, 16);
		contentPane.add(lblNewLabel_7);

		textField_7 = new JTextField();
		textField_7.setBounds(161, 262, 285, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		check = new JButton("Check");
		check.setBounds(182, 409, 101, 29);
		check.addActionListener(this);
		contentPane.add(check);
		over = new JRadioButton("Overdraft Protection");
		over.setBackground(Color.LIGHT_GRAY);
		over.setBounds(61, 327, 141, 23);
		contentPane.add(over);

		line = new JRadioButton("Line of credit");
		line.setBackground(Color.LIGHT_GRAY);
		line.setBounds(61, 353, 141, 23);
		contentPane.add(line);

		investment = new JRadioButton("Investment");
		investment.setBackground(Color.LIGHT_GRAY);
		investment.setBounds(61, 379, 141, 23);
		contentPane.add(investment);
		ButtonGroup group = new ButtonGroup();
		group.add(over);
		group.add(line);
		group.add(investment);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String lastName = this.textField_1.getText();
		String firstName = this.textField_2.getText();
		String postalCode = this.textField.getText();
		String cityName = this.textField_3.getText();
		String streetAddress = this.textField_5.getText();
		String email = this.textField_4.getText();
		String phoneNumber = this.textField_6.getText();
		String balance = this.textField_7.getText();
		try {
			checkEmail(email);
			if (!line.isSelected() && !over.isSelected() && !investment.isSelected()) {
				cust.setAddress(cityName, streetAddress, postalCode);
				cust.setEmail(email);
				cust.setPhone(phoneNumber);
				cust.setName(lastName, firstName);
				Bank.updateCustomer(cust);
				dispose();
			} else {
				checkBalance(balance);
				cust.setAddress(cityName, streetAddress, postalCode);
				cust.setEmail(email);
				cust.setPhone(phoneNumber);
				cust.setName(lastName, firstName);
				if (over.isSelected()) {
					OverdraftProtection o = new OverdraftProtection(cust, Double.parseDouble(balance),
							(Savings) cust.getAccount("S"));
					cust.addAccount(o);
					Bank.updateCustomer(cust);
					dispose();
				} else if (line.isSelected()) {
					LineOfCredit l = new LineOfCredit(cust, Double.parseDouble(balance), 50000);
					cust.addAccount(l);
					Bank.updateCustomer(cust);
					dispose();
				}

				else if (investment.isSelected()) {
					Investment i = new Investment(cust, Double.parseDouble(balance), 6);
					cust.addAccount(i);
					Bank.updateCustomer(cust);
					dispose();
				}
			}
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (BalanceException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		} catch (AccountTypeAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
			dispose();
		}
	}

	private void checkEmail(String email) throws EmailException {
		boolean check = false;
		if (email.contains("@"))
			check = true;
		if (check == false)
			throw new EmailException(email);
	}

	private void checkBalance(String balance) throws BalanceException {
		boolean check = true;
		if(balance.isEmpty()) {
			check = false;
		}
		for (int i = 0; i < balance.length(); i++) {
			if (!Character.isDigit(balance.charAt(i))) {
				if (balance.charAt(i) != '.')
					check = false;
			}
		}
		if (check == true) {
			double bal = Double.parseDouble(balance);
			if (bal < 10) {
				check = false;
			}
		}
		if (check == false) {
			throw new BalanceException(balance);
		}
	}

}
