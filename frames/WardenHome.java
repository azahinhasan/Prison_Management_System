package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class WardenHome extends JFrame implements ActionListener
{
	JButton logout, manageEmp, changePassword, addNewEmp,checkPrisoner,checkVisitor,checkReleasedPrisoner;
	JPanel panel;
	
	User user;
	Prisoner prisoner;
	
	public WardenHome(User user)
	{
		super("Welcome Warden");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		this.prisoner = prisoner;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logout = new JButton("Logout");
		logout.setBounds(600, 50, 150, 30);
		logout.addActionListener(this);
		panel.add(logout);
		
		changePassword = new JButton("Change Password");
		changePassword.setBounds(600, 100, 150, 30);
		changePassword.addActionListener(this);
		panel.add(changePassword);
		
		manageEmp = new JButton("Manage Employee");
		manageEmp.setBounds(50, 100, 150, 30);
		manageEmp.addActionListener(this);
		panel.add(manageEmp);
		
		checkPrisoner= new JButton("Check Prisoner");
		checkPrisoner.setBounds(300, 100, 150, 30);
		checkPrisoner.addActionListener(this);
		panel.add(checkPrisoner);

		checkVisitor = new JButton("Check Visitor");
		checkVisitor.setBounds(50, 150, 150, 30);
		checkVisitor.addActionListener(this);
		panel.add(checkVisitor);

		checkReleasedPrisoner = new JButton("Check Released Prisoner");
		checkReleasedPrisoner.setBounds(300, 150, 200, 30);
		checkReleasedPrisoner.addActionListener(this);
		panel.add(checkReleasedPrisoner);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logout.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);	

		}

		else if(command.equals(changePassword.getText()))
		{
			ChangePass pass = new ChangePass(user);
			pass.setVisible(true);
			this.setVisible(false);
		}

		else if(command.equals(checkReleasedPrisoner.getText()))
		{
			Released_prisonerList rp = new Released_prisonerList(user);
			rp.setVisible(true);
			this.setVisible(false);	
		}


		else if(command.equals(manageEmp.getText()))
		{

				WardenFrame wf = new WardenFrame(user);
				wf.setVisible(true);
				this.setVisible(false);

		}
		else if(command.equals(checkPrisoner.getText()))
		{

				PrisonerList pf = new PrisonerList(user);
				pf.setVisible(true);
				this.setVisible(false);

		}

		else if(command.equals(checkVisitor.getText()))
		{

				VisitorList vl = new VisitorList(user);
				vl.setVisible(true);
				this.setVisible(false);

		}
		
		else{}
	}
}































