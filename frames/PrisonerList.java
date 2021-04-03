package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class PrisonerList extends JFrame implements ActionListener
{
	private JButton getAllBtn, backBtn;

	private JPanel panel;
	private JTable prisonerListTable;
	private JScrollPane prisonerListTableSP;

	private PrisonerRepo pr; 
	User user;

	public PrisonerList(User user)
	{
		super("Prisoner List");
		this.user=user;
		
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pr = new PrisonerRepo();
		
		panel = new JPanel();
		panel.setLayout(null);

		String data[][] = {{"", "", "", "", "","",""}};
		
		String head[] = {"PrisonerId", "PrisonerName", "Crime", "EntryDate","ReleasedDate","CellNo","NID"};

		prisonerListTable = new JTable(data,head);
		prisonerListTableSP = new JScrollPane(prisonerListTable);
		prisonerListTableSP.setBounds(100, 100, 600, 150);
		prisonerListTable.setEnabled(false);
		panel.add(prisonerListTableSP);
		
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(600, 300, 80, 30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(getAllBtn.getText()))
		{
			String data[][] = pr.getAllPrisoner();
			String head[] = {"PrisonerId", "PrisonerName", "Crime", "EntryDate","ReleasedDate","CellNo","NID"};
			
			panel.remove(prisonerListTableSP);
			
			prisonerListTable = new JTable(data,head);
			prisonerListTable.setEnabled(false);
			prisonerListTableSP = new JScrollPane(prisonerListTable);
			prisonerListTableSP.setBounds(100, 100, 600, 150);
			panel.add(prisonerListTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			WardenHome eh = new WardenHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}

		else{}
		
	}
}