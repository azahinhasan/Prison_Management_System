package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements MouseListener, ActionListener
{
	ImageIcon img;
	private JLabel title, userLabel, passLabel, imgLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton login, exit, showPass;
	private JPanel panel;

	public LoginFrame()
	{
		super("Prison Management System - Login");

		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		panel= new JPanel();
		panel.setLayout(null);

		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(270, 150, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(340, 150, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(270, 200, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(340, 200, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPass = new JButton("Show");
		showPass.setBounds(450,200,80,30);
		showPass.addMouseListener(this);
		panel.add(showPass);
		
		login = new JButton("Login");
		try 
		{
    		Icon icon = new ImageIcon("icons/login.png");
    		login.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		login.setBounds(270, 250, 100, 30);
		login.addActionListener(this);
		panel.add(login);
				
		exit = new JButton("Exit");
		try 
		{
    		Icon icon = new ImageIcon("icons/logout.png");
    		exit.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		exit.setBounds(400, 250, 100, 30);
		exit.addActionListener(this);
		panel.add(exit);
		

		img = new ImageIcon("loginImg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(50, 100, 200, 200);
		panel.add(imgLabel);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(login.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0)
				{
					WardenHome eh = new WardenHome(user);
					eh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 1)
				{
					Jailorf jf = new Jailorf(user);
					jf.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					Receptionf rf = new Receptionf(user);
					rf.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exit.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}