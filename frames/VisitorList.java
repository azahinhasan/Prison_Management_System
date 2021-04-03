package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class VisitorList extends JFrame implements ActionListener
{
	private JButton getAll, back;
	private JPanel panel;
	private JTable visitorListTable;
	private JScrollPane visitorListTableSP;

	private VisitorRepo vr;
	User user;

	public VisitorList(User user)
	{
		super("Prisoner List");
		this.user=user;

		this.setSize(800, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		vr = new VisitorRepo();

		panel = new JPanel();
		panel.setLayout(null);

		String data[][] = {{"", "", "", "", "",""}};
		String head[] = {"Serial", "prisonerId", "Visitor Name", "Relation", "Date", "Time"};

		visitorListTable = new JTable(data, head);
		visitorListTableSP = new JScrollPane(visitorListTable);
		visitorListTableSP.setBounds(100, 100, 600, 150);
		visitorListTable.setEnabled(false);
		panel.add(visitorListTableSP);

		getAll = new JButton("Get All");
		getAll.setBounds(600, 300, 80, 30);
		getAll.addActionListener(this);
		panel.add(getAll);

		back = new JButton("Back");
		back.setBounds(600, 350, 80, 30);
		back.addActionListener(this);
		panel.add(back);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(getAll.getText()))
		{
			String data[][] = vr.getAllVisitor();
			String head[] = {"Serial", "prisonerId", "Visitor Name", "Relation", "Date", "Time"};

			panel.remove(visitorListTableSP);

			visitorListTable = new JTable(data, head);
			visitorListTable.setEnabled(false);
			visitorListTableSP = new JScrollPane(visitorListTable);
			visitorListTableSP.setBounds(100, 100, 600, 150);
			panel.add(visitorListTableSP);

			panel.revalidate();
			panel.repaint();
		}

		else if(command.equals(back.getText()))
		{
			WardenHome wh = new WardenHome(user);
			wh.setVisible(true);
			this.setVisible(false);
		}

		else
		{

		}
	}
}