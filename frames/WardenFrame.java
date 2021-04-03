package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class WardenFrame extends JFrame implements ActionListener
{
	private JLabel empIdLabel, empNameLabel, empDesignationLabel, empSalaryLabel;
	private JTextField empIdTF, empNameTF, empDesignationTF, empSalaryTF;
	private JButton load, insert, update, delete, refresh, getAll, backBtn;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;
	
	private User user;
	private EmployeeRepo er;
	private UserRepo ur;
	
	
	public WardenFrame(User user)
	{
		super("Warden Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		er = new EmployeeRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Designation", "Salary"};
		
		//try{
		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(350, 60, 400, 150);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		empIdLabel = new JLabel("ID :");
		empIdLabel.setBounds(100,60,100,30);
		panel.add(empIdLabel);
		
		empIdTF = new JTextField();
		empIdTF.setBounds(220,60,100,30);
		panel.add(empIdTF);
		
		empNameLabel = new JLabel("Name :");
		empNameLabel.setBounds(100,110,100,30);
		panel.add(empNameLabel);
		
		empNameTF = new JTextField();
		empNameTF.setBounds(220,110,100,30);
		panel.add(empNameTF);
		
		empDesignationLabel = new JLabel("Designation: ");
		empDesignationLabel.setBounds(100,160,100,30);
		panel.add(empDesignationLabel);
		
		empDesignationTF = new JTextField();
		empDesignationTF.setBounds(220,160,100,30);
		panel.add(empDesignationTF);
		
		empSalaryLabel = new JLabel("Salary: ");
		empSalaryLabel.setBounds(100,210,100,30);
		panel.add(empSalaryLabel);
		
		empSalaryTF = new JTextField();
		empSalaryTF.setBounds(220,210,100,30);
		panel.add(empSalaryTF);
		// }catch(Exception e){
		// 		System.out.println("Exception "+e);
		// }
		
		load = new JButton("Load");
		try 
		{
    		Icon icon = new ImageIcon("icons/load.png");
    		load.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		load.setBounds(100,300,100,30);
		load.addActionListener(this);
		panel.add(load);
		
		insert = new JButton("Insert");
		try 
		{
    		Icon icon = new ImageIcon("icons/insert.png");
    		insert.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		insert.setBounds(210,300,100,30);
		insert.addActionListener(this);
		panel.add(insert);
		
		update = new JButton("Update");
		try 
		{
    		Icon icon = new ImageIcon("icons/update.png");
    		update.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		update.setBounds(320,300,100,30);
		update.addActionListener(this);
		update.setEnabled(false);
		panel.add(update);
		
		delete = new JButton("Delete");
		try 
		{
    		Icon icon = new ImageIcon("icons/delete.png");
    		delete.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		delete.setBounds(430,300,100,30);
		delete.addActionListener(this);
		delete.setEnabled(false);
		panel.add(delete);
		
		refresh = new JButton("Refresh");
		try 
		{
    		Icon icon = new ImageIcon("icons/refresh.jpg");
    		refresh.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		refresh.setBounds(540,300,150,30);
		refresh.addActionListener(this);
		refresh.setEnabled(false);
		panel.add(refresh);
		
		getAll = new JButton("Get All");
		try 
		{
    		Icon icon = new ImageIcon("icons/getall.png");
    		getAll.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		getAll.setBounds(500,260,100,30);
		getAll.addActionListener(this);
		panel.add(getAll);
		
		backBtn = new JButton("Back");
		try 
		{
    		Icon icon = new ImageIcon("icons/back2.png");
    		backBtn.setIcon(icon);
  		} 
  		catch (Exception ex) 
  		{
    		System.out.println("Image exception " + ex);
  		}
		backBtn.setBounds(600, 350, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(load.getText()))
		{
			if(!empIdTF.getText().equals("") || !empIdTF.getText().equals(null))
			{
				Employee e = er.searchEmployee(empIdTF.getText());
				if(e!= null)
				{
					empNameTF.setText(e.getName());
					empDesignationTF.setText(e.getDesignation());
					empSalaryTF.setText(e.getSalary()+"");
					
					empIdTF.setEnabled(false);
					empNameTF.setEnabled(true);
					empDesignationTF.setEnabled(true);
					empSalaryTF.setEnabled(true);
					
					update.setEnabled(true);
					delete.setEnabled(true);
					refresh.setEnabled(true);
					insert.setEnabled(false);
					load.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insert.getText()))
		{
			Employee e = new Employee();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			e.setSalary(Double.parseDouble(empSalaryTF.getText()));
			
			u.setUserId(empIdTF.getText());
			u.setPassword(x+"");
			
			if(((empDesignationTF.getText()).equals("Warden")) || ((empDesignationTF.getText()).equals("warden"))) 
			{
				u.setStatus(0);
			}
			else if(((empDesignationTF.getText()).equals("Jailor")) || ((empDesignationTF.getText()).equals("jailor")))
			{
				u.setStatus(2);
			} 
			else if(((empDesignationTF.getText()).equals("Receptionist")) || ((empDesignationTF.getText()).equals("receptionist")))
			{
				u.setStatus(1);
			}
			else if(((empDesignationTF.getText()).equals("Manager")) || ((empDesignationTF.getText()).equals("manager")))
			{
				u.setStatus(0);
			}

			er.insertInDB(e);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+empIdTF.getText()+" and Password: "+x);
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			load.setEnabled(true);
			insert.setEnabled(true);
			update.setEnabled(false);
			delete.setEnabled(false);
			refresh.setEnabled(false);
			
		}
		else if(command.equals(refresh.getText()))
		{
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			load.setEnabled(true);
			insert.setEnabled(true);
			update.setEnabled(false);
			delete.setEnabled(false);
			refresh.setEnabled(false);
		}
		else if(command.equals(update.getText()))
		{
			Employee e = new Employee();
			
			e.setEmpId(empIdTF.getText());
			e.setName(empNameTF.getText());
			e.setDesignation(empDesignationTF.getText());
			e.setSalary(Double.parseDouble(empSalaryTF.getText()));
			
			er.updateInDB(e);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			load.setEnabled(true);
			insert.setEnabled(true);
			update.setEnabled(false);
			delete.setEnabled(false);
			refresh.setEnabled(false);
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
		}
		else if(command.equals(delete.getText()))
		{
			er.deleteFromDB(empIdTF.getText());
			ur.deleteUser(empIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			empIdTF.setText("");
			empNameTF.setText("");
			empDesignationTF.setText("");
			empSalaryTF.setText("");
			
			empIdTF.setEnabled(true);
			empNameTF.setEnabled(true);
			empDesignationTF.setEnabled(true);
			empSalaryTF.setEnabled(true);
	
			load.setEnabled(true);
			insert.setEnabled(true);
			update.setEnabled(false);
			delete.setEnabled(false);
			refresh.setEnabled(false);
		}
		else if(command.equals(getAll.getText()))
		{
			String data[][] = er.getAllEmployee();
			String head[] = {"Id", "Name", "Designation", "Salary"};
			
			panel.remove(empTableSP);
			
			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(350, 60, 400, 150);
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