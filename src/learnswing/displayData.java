package learnswing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.sandeep.dao.ConnectionProvider;

public class displayData extends JFrame implements ActionListener{
	
	Container c;
	JLabel l1;
	JButton back,edit;
	JTextArea ta;
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border compound;
	String st,s1,s2,k;
	displayData(String name,String ftitle,String key)
	{
		st=name;
		s1=ftitle;
		k=key;
		c=getContentPane();
		c.setBackground(new Color(107,142,35));
		setTitle("SKAN APPLICATION ");
		setSize(1025,700);
		setLayout(null);
		
		l1= new JLabel();
		l1.setBounds(471,27,600,63);
		l1.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 54));

		ta= new JTextArea();
		ta.setBounds(45,120,918,400);
		ta.setFont(new Font("TimesRoman", Font.ITALIC, 18));

		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		ta.setBorder(compound);
		ta.setBackground(new Color(253,245,230));
		
		
 		 back = new JButton("Choose other file");
		 back.setBounds(270,570,180,40);
		 back.addActionListener(this);
		 
		 edit= new JButton("Edit and Save");
		 edit.setBounds(580,570,180,40);
		 edit.addActionListener(this);
		 
		 c.add(edit);
		 c.add(back);
		 c.add(ta);
		 c.add(l1);
		 setVisible(true);
		 
		 try
         {
  Connection con=ConnectionProvider.getCon();
	
	PreparedStatement ps1=con.prepareStatement("select * from user_data where uname=? and title=?");
	ps1.setString(1, name);
	ps1.setString(2, ftitle);
	
	ResultSet rs=ps1.executeQuery();
	rs.next();
		l1.setText(rs.getString(3));
		AES a=new AES(rs.getString(2),key,Integer.parseInt(rs.getString(4)));
		//System.out.println(rs.getString(2));
		//System.out.println(key);
		//System.out.println(a.DecryptedData());
		if(a.DecryptedData()==null)
			{
			this.dispose();
			new decrypt(st);
			}
		ta.setText(a.DecryptedData());
         }
          catch (Exception ex) 
          {
             System.out.println(ex);
         }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back)
		{
			new decrypt(st);
			this.dispose();
		}
		if (e.getSource() == edit)
        {
           
           String s12 = ta.getText();
           int i=0;
           String[] datas = new String[20];
           for (String line : ta.getText().split("\\n"))
           {
           	datas[i]=line ;
           	i=i+1;
           }
           StringBuilder strBuilder = new StringBuilder();
           for (int j = 0; j < i; j++) {
              strBuilder.append(datas[j]+'\n');
           }
           String newString = strBuilder.toString();
           
               try
              {
       Connection con=ConnectionProvider.getCon();
       
       //System.out.println("AKK " +k);
        AES b=new AES(newString,k,0);
 		PreparedStatement ps=con.prepareStatement("update user_data set info=? where uname=? and title=?");
 		ps.setString(1, newString);
		ps.setString(2, st);
		ps.setString(3, s1);
		
		ps.executeUpdate();	
		
		JOptionPane.showMessageDialog(null,"Database Updated");
       this.dispose();
       new decrypt(st);
              }
               catch (Exception ex) 
               {
                  System.out.println(ex);
              }
        }
	}
}
