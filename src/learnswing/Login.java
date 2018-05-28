package learnswing;

 import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import com.sandeep.dao.ConnectionProvider;

 public class Login extends JFrame implements ActionListener,Runnable
  {
   JLabel l1,l2,l3;
   JTextField t1;
   JTextArea a;
   JPasswordField t2;
   JButton b1,b2;
   Container c;
  public Login()
  {
 c=getContentPane();
 
 c.setBackground(new Color(255,218,185));
 c.setLayout(new FlowLayout());
 c.setLayout(null);
 l3= new JLabel("Get Started");
 l3.setBounds(200,10,350,40);
 l3.setFont(new Font("TimesRoman", Font.BOLD, 33));

 c.add(l3);
 l1=new JLabel("User Name ");
 l2=new JLabel("Password ");
 b1=new JButton("Login");
 b2=new JButton("Register");
 t1=new JTextField(15);
 t1.setToolTipText("Enter USER ID");
 t2=new JPasswordField(15);
 t2.setToolTipText("Enter Password");
 a=new JTextArea("New to SKAN or not a member yet ? Register to continue... ");
 a.setBounds(320,63,216,90);
 a.setLineWrap(true);
 a.setWrapStyleWord(true);
 a.setBackground(new Color(255,218,185));
 a.setFont(new Font("VARDANA", Font.ITALIC, 16));
c.add(a);
 l1.setBounds(50,60,100,30);
 l2.setBounds(50,100,100,30);
 b1.setBounds(80,160,100,30);
 b2.setBounds(360,160,100,30);
 t1.setBounds(150,60,100,30);
 t2.setBounds(150,100,100,30);
 b1.addActionListener(this);
 b2.addActionListener(this); 
  c.add(l1);
  c.add(l2);
  c.add(t1);
  c.add(t2);
  c.add(b1);
  c.add(b2);
   setBounds(400,200,300,300);
 setVisible(true);
 setSize(550,280);
 setTitle("SKAN APPLICATION");
 }
 public void actionPerformed(ActionEvent ae)
 {
	 String s1=t1.getText();
	 String s2=t2.getText();
		
 if(ae.getSource()==b1)
 {
 try 
    { 
    Connection con= ConnectionProvider.getCon();
	// ss' or '1'='1
	//Statement st=con.createStatement();
	//ResultSet rs=st.executeQuery("select * from user1 where  name='" + s1 + "' AND email='"+s2+"'");				

	PreparedStatement ps=con.prepareStatement("select * from users where uname=? and pswd=?");
	//System.out.println("a");
	ps.setString(1,s1);
	//System.out.println("a1");
	
ps.setString(2,s2);
//	System.out.println("a2");
	
ResultSet rs=ps.executeQuery();	

boolean recordfound = rs.next();

  if((s1.equals("")) && (s2.equals("")))
   {
  JOptionPane.showMessageDialog(null,"Please Enter User Name/Password");
  return;
   }  
  
      if(recordfound)
      {
    	  this.dispose();
    	 new reservations(s1);
    	 
      }
      else
      {
       JOptionPane.showMessageDialog(null,"Invalid User Name/Password");
       t1.setText("");
       t2.setText("");

      }
    }catch(Exception e)   {}      

   }
    
  if(ae.getSource()==b2)
    {
      this.dispose();
      new Registration();
    }	
   }   
  public static void main(String args[])
    {
  buttonicon b=new buttonicon();
    }
@Override
public void run() {
	// TODO Auto-generated method stub
	
}
    }

