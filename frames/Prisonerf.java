package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class Prisonerf extends JFrame implements ActionListener
{

    JButton savebtn,backbtn,newbtn,updateBtn,releaseBtn,loadBtn;
    JPanel panel; 
    JLabel id,name,crime,edate,rdate,cellno,cellsh,NID;
    JTextField idtf,nametf,crimetf,edatetf,rdatetf,cellnotf,cellshtf,nIDtf;
    JRadioButton r1, r2;
    
    PrisonerRepo pr;

    User user;
    Prisoner p;

    public Prisonerf(User user)
    {
    	super("Prisoner");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		pr = new PrisonerRepo();
		this.p=p;
		this.user = user;

		panel = new JPanel();
		panel.setLayout(null);

		//try{
		id = new JLabel("ID :");
		id.setBounds(350,10,100,30);
		panel.add(id);

		idtf = new JTextField();
		idtf.setBounds(400,10,100,30);
		panel.add(idtf);

		name = new JLabel("Name :");
		name.setBounds(325,50,100,30);
		panel.add(name);

		nametf = new JTextField();
		nametf.setBounds(400,50,100,30);
		panel.add(nametf);

		crime = new JLabel("Crime :");
		crime.setBounds(325,90,100,30);
		panel.add(crime);

		crimetf = new JTextField();
		crimetf.setBounds(400,90,100,30);
		panel.add(crimetf);

		edate= new JLabel("Enter Date :");
		edate.setBounds(300,130,100,30);
		panel.add(edate);

		edatetf= new JTextField();
		edatetf.setBounds(400,130,100,30);
		panel.add(edatetf);

		rdate = new JLabel("Release Date :");
		rdate.setBounds(280,170,100,30);
		panel.add(rdate);

		rdatetf = new JTextField();
		rdatetf.setBounds(400,170,100,30);
		panel.add(rdatetf);

		cellno = new JLabel("Cell no :");
		cellno.setBounds(320,210,100,30);
		panel.add(cellno);

		cellnotf = new JTextField();
		cellnotf.setBounds(400,210,100,30);
		panel.add(cellnotf);

		NID = new JLabel("National Id :");
		NID.setBounds(310,250,100,30);
		panel.add(NID);

		nIDtf = new JTextField();
		nIDtf.setBounds(400,250,100,30);
		panel.add(nIDtf);
		// }catch(Exception e){
		// 		System.out.println("Exception "+e);
		// }

		savebtn = new JButton("Save");
		savebtn.setBounds(250,300,80,30);
		savebtn.addActionListener(this);
		panel.add(savebtn);

		loadBtn = new JButton("Load");
		loadBtn.setBounds(150,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		
		releaseBtn = new JButton("Release");
		releaseBtn.setBounds(550,300,80,30);
		releaseBtn.addActionListener(this);
		releaseBtn.setEnabled(true);
		panel.add(releaseBtn);

		newbtn =new JButton("New");
		newbtn.setBounds(350,300,80,30);
		newbtn.addActionListener(this);
		panel.add(newbtn);

		backbtn = new JButton("Back");
		backbtn.setBounds(450,300,80,30);
		backbtn.addActionListener(this);
		panel.add(backbtn);



		this.add(panel);


    }

    public void actionPerformed(ActionEvent ae)
    {
    	String command = ae.getActionCommand();

		if(command.equals(loadBtn.getText()))
		{
			if(!idtf.getText().equals("") || !idtf.getText().equals(null))
			{
				Prisoner p = pr.searchPrisoner(idtf.getText());
				if(p!= null)
				{
					nametf.setText(p.getPrisonerName());
					crimetf.setText(p.getCrime());
					edatetf.setText(p.getEntryDate());
					rdatetf.setText(p.getReleasedDate());
					cellnotf.setText(p.getCellNo()+"");
					nIDtf.setText(p.getNID()+"");

					
					idtf.setEnabled(false);
					nametf.setEnabled(true);
					edatetf.setEnabled(true);
					rdatetf.setEnabled(true);
					cellnotf.setEnabled(true);
			
					releaseBtn.setEnabled(true);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}

    	else if(command.equals(newbtn.getText()))
		{
	
			idtf.setText("");
			nametf.setText("");
			crimetf.setText("");
			edatetf.setText("");
			rdatetf.setText("");
			cellnotf.setText("");
			nIDtf.setText("");

			idtf.setEnabled(true);
			nametf.setEnabled(true);
			crimetf.setEnabled(true);
			edatetf.setEnabled(true);
			rdatetf.setEnabled(true);
			cellnotf.setEnabled(true);
			nIDtf.setEnabled(true);
			loadBtn.setEnabled(true);

		}
 
		else if(command.equals(backbtn.getText()))
		{
		    Jailorf jf = new Jailorf(user);
			jf.setVisible(true);
		    this.setVisible(false);
		}



		else if(command.equals(savebtn.getText()))
		{
			Prisoner p = new Prisoner();
			
			p.setPrisonerName(nametf.getText());
			p.setPrisonerID(idtf.getText());
			p.setCellNo(Integer.parseInt(cellnotf.getText()));
			p.setEntryDate(edatetf.getText());
			p.setReleasedDate(rdatetf.getText());
			p.setNID(nIDtf.getText());
			p.setCrime(crimetf.getText());
			
			
			pr.insertPrisoner(p);
			
			JOptionPane.showMessageDialog(this, "Saved");
		
		}
		
			else if(command.equals(releaseBtn.getText()))
		{
			pr.releasePrisoner(idtf.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			nametf.setText("");
			idtf.setText("");
			crimetf.setText("");
			cellnotf.setText("");
			edatetf.setText("");
			rdatetf.setText("");
			nIDtf.setText("");


		    nametf.setEnabled(true);
			idtf.setEnabled(true);
			cellnotf.setEnabled(true);
			edatetf.setEnabled(true);
			rdatetf.setEnabled(true);
			nIDtf.setEnabled(true);
	
			loadBtn.setEnabled(true);
			
			releaseBtn.setEnabled(false);
		}

		else if(command.equals(updateBtn.getText()))
		{}
		
		else
		{}
	}	



   }
    

