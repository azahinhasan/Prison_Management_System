package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class Released_prisonerList extends JFrame implements ActionListener
{
	private JLabel empIdLabel, empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable rPriTable;
	private JScrollPane prisonerTableSP;
	
	private Prisoner prisoner;
	private PrisonerRepo pr;
	User user;
	
	public Released_prisonerList(User user)
	{
		super("Released Prisoner");
		this.user=user;
		
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pr = new PrisonerRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		String data[][] = {{"", "", "", "", ""}};
		
		String head[] = {"NID", "PrisonerName", "EntryDate", "ReleasedDate","Crime"};
		
		rPriTable = new JTable(data,head);
		prisonerTableSP = new JScrollPane(rPriTable);
		prisonerTableSP.setBounds(100, 100, 600, 150);
		rPriTable.setEnabled(false);
		panel.add(prisonerTableSP);
		
		
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
			String data[][] = pr.getAllReleased_prisoner();
			String head[] = {"NID", "PrisonerName", "EntryDate", "ReleasedDate","Crime"};
			
			panel.remove(prisonerTableSP);
			
			rPriTable = new JTable(data,head);
			rPriTable.setEnabled(false);
			prisonerTableSP = new JScrollPane(rPriTable);
			prisonerTableSP.setBounds(100, 100, 600, 150);
			panel.add(prisonerTableSP);
			
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