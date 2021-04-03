package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ChangePass extends JFrame implements ActionListener
{
	private JLabel confirmPass,newPass,oldPass ;
	private JPasswordField  confirmPassTF, newPassTF,oldPassTF;
	private JButton  backBtn,con;

	private JPanel panel;
	

	
	private User user;
	
	
	public ChangePass(User user)
	{
		super("Change Password");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
	
		
		oldPass = new JLabel("Old Pass:");
		oldPass.setBounds(100,60,100,30);
		panel.add(oldPass);
		
		oldPassTF = new JPasswordField();
		oldPassTF.setBounds(220,60,100,30);
		oldPassTF.setEchoChar('*');
		panel.add(oldPassTF);
		
		

		newPass = new JLabel("New Pass:");
		newPass.setBounds(100,110,100,30);
		panel.add(newPass);
		
		newPassTF = new JPasswordField();
		newPassTF.setBounds(220,110,100,30);
		newPassTF.setEchoChar('*');
		panel.add(newPassTF);
		
		

		confirmPass = new JLabel("Again:");
		confirmPass.setBounds(100,170,100,30);
		panel.add(confirmPass);
		
		confirmPassTF = new JPasswordField();
		confirmPassTF.setBounds(220,170,100,30);
		confirmPassTF.setEchoChar('*');
		panel.add(confirmPassTF);
		
		
		con = new JButton("Confirm");
		con.setBounds(300, 250, 80, 30);
		con.addActionListener(this);
		panel.add(con);

		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		UserRepo ur = new UserRepo();
		if(command.equals(con.getText()))
		{
			if(user.getPassword().equals(oldPassTF.getText())){

				if(newPassTF.getText().equals(confirmPassTF.getText())){
				User u = new User();
				u.setPassword(newPassTF.getText());
				u.setUserId(user.getUserId());
				
				ur.updateInDB(u);
				JOptionPane.showMessageDialog(this, "Password Updated. Please Login Again.","Warning",2);

				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
				this.setVisible(false);
				}

				else{
					JOptionPane.showMessageDialog(this, "Password Not Matched. Try Again.","Warning",0);
					ChangePass pass = new ChangePass(user);
					pass.setVisible(true);
					this.setVisible(false);
				}

			}


			else{
				JOptionPane.showMessageDialog(this, "Wrong Old Password","Warning",0);
			}
		}
		else if(command.equals(backBtn.getText()))
		{
			
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

}
}

