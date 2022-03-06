import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;

public class ATMGUI extends JFrame implements ActionListener {

	private JTextField textFieldCustID;
	private JTextField textFieldAmount;
	private JTextArea textArea;
	private JCheckBox chckbxLOC, chckbxInvestment, chckbxOverdraft, chckbxSavings;
	private JScrollPane scrollPane;
	

	public ATMGUI() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		initialize();
	}

	public String getMessage() {
		return textArea.getText();
	}

	public void setMessage(String msg) {
		textArea.setText(msg);
	}

	public String getCustid() {
		return textFieldCustID.getText();
	}

	public String getAmount() {
		return textFieldAmount.getText();
	}

	public String getAcctType() {
		String type = "\0";
		if (chckbxSavings.getSelectedObjects() != null) {
			type = "S";
		}
		if (chckbxLOC.getSelectedObjects() != null) {
			type = "L";
		}
		if (chckbxInvestment.getSelectedObjects() != null) {
			type = "I";
		}
		if (chckbxOverdraft.getSelectedObjects() != null) {
			type = "O";
		}		
		return type;
	}
	
	private void errorMessage(String msg) {
		textArea.append(msg);
	}
	
	private Account locateAccount(String acctType, Customer cust) {
		return cust.getAccount(acctType);
		
	}

	private void initialize() {

		setBounds(100, 100, 682, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 178, 547, 173);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean d = false;
				String Sbalance = textFieldAmount.getText();
				String SCustomer = textFieldCustID.getText();
				for (int i = 0; i < Sbalance.length(); i++) {
					if (!Character.isDigit(Sbalance.charAt(i)))
						if (Sbalance.charAt(i) != '.')
							d = true;
				}
				for (int j = 0; j < SCustomer.length(); j++) {
					if (!Character.isDigit(SCustomer.charAt(j)))
						if (SCustomer.charAt(j) != '.')
							d = true;
				}
				StringBuffer strb = new StringBuffer();
				if (d == false) {
					if (Bank.getCustomer(Integer.parseInt(textFieldCustID.getText())) != null) {
						Customer customer = Bank.getCustomer(Integer.parseInt(textFieldCustID.getText()));
						String acctType = getAcctType();
						if (acctType != null) {
							Account acct = locateAccount(acctType, customer);
							if (acct != null) {
								double balance = Double.parseDouble(textFieldAmount.getText());
								if (acct.deposit(balance)) {
									strb.append(getMessage() + "\n" + " account : " + getCustid() + " amount deposit: $"
											+ getAmount() + " account balance " + acct.getBalance() + " \n");
									setMessage(strb.toString());
								} else {
									errorMessage("\"Unable to complete transaction. Your\n" + "ammount is "
											+ textFieldAmount.getText());
								}

							} else
								errorMessage("Customer does not have an " + getAcctType() + " Type" + "\n");
						}

					} else
						errorMessage("No Customer with " + textFieldCustID.getText() + " ID found" + "\n");

				} else
					errorMessage("Amount/Customer textfield contains illegal characters");
			}
			
		});
		depositButton.setBounds(549, 218, 117, 45);
		getContentPane().add(depositButton);

		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean d = false;
				String Sbalance = textFieldAmount.getText();
				String SCustomer = textFieldCustID.getText();
				for (int i = 0; i < Sbalance.length(); i++) {
					if (!Character.isDigit(Sbalance.charAt(i)))
						if (Sbalance.charAt(i) != '.')
							d = true;
				}
				for (int j = 0; j < SCustomer.length(); j++) {
					if (!Character.isDigit(SCustomer.charAt(j)))
						if (SCustomer.charAt(j) != '.')
							d = true;
				}
				StringBuffer strb = new StringBuffer();
				if (d == false) {
					if (Bank.getCustomer(Integer.parseInt(textFieldCustID.getText())) != null) {
						Customer customer = Bank.getCustomer(Integer.parseInt(textFieldCustID.getText()));
						String acctType = getAcctType();
						if (acctType != null) {
							Account acct = locateAccount(acctType, customer);
							if (acct != null) {
								double balance = Double.parseDouble(textFieldAmount.getText());
								try {
									acct.withdraw(balance);
									strb.append(
											getMessage() + "\n" + " account : " + getCustid() + " amount withdrawn: $"
													+ getAmount() + " account balance " + acct.getBalance() + " \n");
									setMessage(strb.toString());
								} catch (AmountOverDrawnException ex) {
									strb.append(getMessage() + ex.getMessage() + " \n");
									setMessage(strb.toString());
								}

							} else
								errorMessage("Customer does not have an " + getAcctType() + " Type" + "\n");
						}
					} else
						errorMessage("No Customer with " + textFieldCustID.getText() + " ID found" + "\n");

				}
				else
					errorMessage("Amount/Customer textfield contains illegal characters");
			}
			

		});
		withdrawButton.setBounds(549, 262, 117, 45);

		getContentPane().add(withdrawButton);

		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(549, 306, 117, 45);
		exitButton.addActionListener(this);
		getContentPane().add(exitButton);

		chckbxLOC = new JCheckBox("Line Of Credit");
		chckbxLOC.setBackground(Color.LIGHT_GRAY);
		chckbxLOC.setBounds(221, 42, 117, 23);
		getContentPane().add(chckbxLOC);

		chckbxInvestment = new JCheckBox("Investment");
		chckbxInvestment.setBackground(Color.LIGHT_GRAY);
		chckbxInvestment.setBounds(221, 68, 97, 23);
		getContentPane().add(chckbxInvestment);

		chckbxOverdraft = new JCheckBox("Overdraft");
		chckbxOverdraft.setBackground(Color.LIGHT_GRAY);
		chckbxOverdraft.setBounds(221, 94, 97, 23);
		getContentPane().add(chckbxOverdraft);

		chckbxSavings = new JCheckBox("Savings");
		chckbxSavings.setBackground(Color.LIGHT_GRAY);
		chckbxSavings.setBounds(221, 16, 97, 23);
		getContentPane().add(chckbxSavings);

		JLabel labelCustid = new JLabel("Enter customer ID: ");
		labelCustid.setBounds(10, 72, 127, 14);
		getContentPane().add(labelCustid);

		JLabel labelAmount = new JLabel("Enter amount here:");
		labelAmount.setBounds(324, 72, 137, 14);
		getContentPane().add(labelAmount);

		textFieldCustID = new JTextField();
		textFieldCustID.setBounds(135, 69, 80, 20);
		getContentPane().add(textFieldCustID);
		textFieldCustID.setColumns(10);

		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(471, 69, 156, 20);
		getContentPane().add(textFieldAmount);
		textFieldAmount.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Your are exiting a secure session. Good Bye", " Exit message",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);

	}
}
