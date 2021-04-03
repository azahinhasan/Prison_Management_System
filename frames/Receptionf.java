package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class Receptionf extends JFrame implements ActionListener
{
	JLabel serial,prisonerId,visitorName,relation,date,time;
	JTextField serialtf,visitornametf,prisonerIdtf,relationtf,datetf,timetf;
	JButton add,refreshBtn,logOut,changePasswordbtn;
	JFrame fi;
	JPanel panel;

	User user;
	VisitorRepo vr;
	public Receptionf(User user)
	{
		super("Receptionist's Window");

		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		vr= new VisitorRepo();

		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		try{
		serial = new JLabel("Serial : ");
		serial.setBounds(250, 20, 60, 30);
		panel.add(serial);
		
		serialtf = new JTextField();
		serialtf.setBounds(350, 20, 100, 30);
		panel.add(serialtf);
		
		visitorName = new JLabel("Visitor Name : ");
		visitorName.setBounds(250, 70, 100, 30);
		panel.add(visitorName);
		
		visitornametf = new JTextField();
		visitornametf.setBounds(350, 70, 100, 30);
		panel.add(visitornametf);

		prisonerId = new JLabel("Prisoner Id : ");
		prisonerId.setBounds(250, 120, 100, 30);
		panel.add(prisonerId);

		prisonerIdtf = new JTextField();
		prisonerIdtf.setBounds(350, 120, 100, 30);
		panel.add(prisonerIdtf);

		relation =new JLabel("Relation : ");
		relation.setBounds(250,170,100,30);
		panel.add(relation);

		relationtf = new JTextField();
		relationtf.setBounds(350,170,100,30);
		panel.add(relationtf);

		date = new JLabel("Date : ");
		date.setBounds(250, 220,100,30);
		panel.add(date);

		datetf = new JTextField();
		datetf.setBounds(350, 220,100,30);
		panel.add(datetf);

		time = new JLabel("Time : ");
		time.setBounds(250,270,100,30);
		panel.add(time);

		timetf = new JTextField();
		timetf.setBounds(350,270,100,30);
		panel.add(timetf);

		}catch(Exception e){
			System.out.println("Exception"+e);
		}

				
		add = new JButton("Save");
		add.setBounds(350,310,80,30);
		add.addActionListener(this);
		panel.add(add);

		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(450,310,80,30);
		refreshBtn.addActionListener(this);
		panel.add(refreshBtn);
		
		logOut = new JButton("Logout");
		logOut.setBounds(600, 50, 150, 30);
		logOut.addActionListener(this);
		panel.add(logOut);

		changePasswordbtn = new JButton("Change Password");
		changePasswordbtn.setBounds(600,100,150,30);
		changePasswordbtn.addActionListener(this);
		panel.add(changePasswordbtn);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)

	{
		String command = ae.getActionCommand();

		if(command.equals(refreshBtn.getText()))
		{
			visitornametf.setText("");
			serialtf.setText("");
			datetf.setText("");
			timetf.setText("");
			relationtf.setText("");
			prisonerIdtf.setText("");

			
		}
		else if(command.equals(changePasswordbtn.getText()))
		{
			ChangePass pass = new ChangePass(user);
			pass.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(logOut.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(add.getText()))
		{
			Visitor v = new Visitor();
			
			v.setserial(serialtf.getText());
			v.setvname(visitornametf.getText());
			v.setprisonerId(prisonerIdtf.getText());
			v.setrelationship(relationtf.getText());
			v.setdate(datetf.getText());
			v.settime(timetf.getText());
			
			vr.insertVisitor(v);

			JOptionPane.showMessageDialog(this, "Information Updated");
			
		}
		else
		{

		}
		
		
	}
}


		










	