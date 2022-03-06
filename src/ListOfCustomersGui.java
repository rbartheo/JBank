import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class ListOfCustomersGui extends JFrame implements ActionListener {
	private JScrollPane scroll;
	private JList<Customer> list;
	private JButton addUser, updateUser, removeUser;
	private Customer customers[];

	ListOfCustomersGui() {
		customers = Bank.getCustomers();
		buildListOfCustomersGUI();

	}

	public void buildListOfCustomersGUI() {
		setBounds(100, 100, 552, 357);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		scroll = new JScrollPane();
		scroll.setBounds(0, 0, 358, 307);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);
		list = new JList(customers);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(8);
		list.setFixedCellWidth(20);
		scroll.setViewportView(list);
		addUser = new JButton("Add customer");
		addUser.setBounds(385, 11, 141, 83);
		addUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame user = new AddCustomerGui();
				user.setVisible(true);
			}

		});
		panel.add(addUser);

		updateUser = new JButton("Update Customer");
		updateUser.setBounds(385, 199, 141, 83);
		updateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!= null) {
				JFrame user = new UpdateAccountGui(list.getSelectedValue());
				user.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Please select a customer which you want to update", "WARNING", JOptionPane.WARNING_MESSAGE);
			}

		});
		panel.add(updateUser);

		removeUser = new JButton("Remove Customer");
		removeUser.setBounds(385, 105, 141, 83);
		removeUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null) {
				Bank.removeCustomer(customers[list.getSelectedIndex()].getCustID());
				}
				else
					JOptionPane.showMessageDialog(null, "Please select customer which you want to remove", "WARNING", JOptionPane.WARNING_MESSAGE);
				
			}
			
		});
		panel.add(removeUser);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
