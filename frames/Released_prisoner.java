package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class Released_prisoner extends JFrame implements ActionListener
{
	private JLabel empIdLabel, empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable rPriTable;
	private JScrollPane empTableSP;
	
	private Prisoner prisoner;
	private PrisonerRepo pr;
	
	
	public WardenFrame( )
	{
		//super("Released_prisoner");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pr = new PrisonerRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "", ""}};
		
		String head[] = {"NID", "PrisonerID", "EntryDate", "ReleaseDate","getCrime"};
		
		rPriTable = new JTable(data,head);
		empTableSP = new JScrollPane(rPriTable);
		empTableSP.setBounds(350, 100, 400, 150);
		rPriTable.setEnabled(false);
		panel.add(empTableSP);
		
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
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
			String data[][] = pr.getAllReleased_prisone();
			String head[] = {"NID", "PrisonerID", "EntryDate", "ReleaseDate","getCrime"};
			
			panel.remove(empTableSP);
			
			rPriTable = new JTable(data,head);
			rPriTable.setEnabled(false);
			empTableSP = new JScrollPane(rPriTable);
			empTableSP.setBounds(350, 100, 400, 150);
			panel.add(empTableSP);
			
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