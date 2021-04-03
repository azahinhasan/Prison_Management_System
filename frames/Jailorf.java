package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class Jailorf extends JFrame implements ActionListener
{
	JButton logoutBtn, changePassword, managePrisoner;
	JPanel panel;
	User user;
	

	
	public Jailorf(User user)
	{
		super("Jailor's Window");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;

		panel = new JPanel();
		panel.setLayout(null);

		managePrisoner = new JButton("Manage Prisoner");
		managePrisoner.setBounds(50, 100, 150, 30);
		managePrisoner.addActionListener(this);
		panel.add(managePrisoner);

		changePassword = new JButton("Change Password");
		changePassword.setBounds(225, 100, 150, 30);
		changePassword.addActionListener(this);
		panel.add(changePassword);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(400, 100, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(logoutBtn.getText()))
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
		else if(command.equals(managePrisoner.getText()))
		{
			Prisonerf pf = new Prisonerf(user); //error
			pf.setVisible(true);
			this.setVisible(false);
		}

		else
		{
			JOptionPane.showMessageDialog(this, "Invaild");
		}
	}


}