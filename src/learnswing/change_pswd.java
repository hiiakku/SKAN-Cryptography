package learnswing;

import javax.swing.*;

import com.sandeep.dao.ConnectionProvider;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;


class change_pswd extends JFrame implements ActionListener {
	
	Container c;
	JLabel h,l1,l2,l3,l4;
	JButton back,b1,b2;
	JTextField tf1,tf2;
	JPasswordField p1,p2;
	Icon img1;
	String s;
	change_pswd(String st)
	{
		s=st;
	 c=getContentPane();
	 c.setBackground(new Color(192,192,192));
	 setTitle("SKAN APPLICATION ");
	 setSize(810,600);
	 setLayout(null);
	 
	 img1=new ImageIcon("bck3.png");
	 back = new JButton(img1);
	 back.setBounds(0,10,69,69);
	 back.setBackground(Color.BLACK);
	 
	 b1= new JButton(" SAVE ");
	 b1.setBounds(360,450,90,36);
	 
	 back.addActionListener(this);
     b1.addActionListener(this);
     
	 c.add(b1);
	 c.add(back);
	 h=new JLabel(" RESET PASSWORD ");
	 h.setBounds(150,40,800,100);
	 h.setFont(new Font("TimesRoman", Font.BOLD, 54));
	 
	 l1 = new JLabel("User Name");
     l2 = new JLabel("Current Password");
     l3 = new JLabel("New Password");
     l4 = new JLabel("Confirm Password");
     
     tf1 = new JTextField();
     tf2 = new JTextField();
     
     p1 = new JPasswordField();
     p2 = new JPasswordField();
     
     l1.setBounds(140, 200, 400, 50);
	 l1.setFont(new Font("TimesRoman", Font.BOLD, 27));

     l2.setBounds(140, 250, 240, 50);
	 l2.setFont(new Font("TimesRoman", Font.BOLD, 27));

     l3.setBounds(140, 300, 240, 50);
	 l3.setFont(new Font("TimesRoman", Font.BOLD, 27));

     l4.setBounds(140, 350, 240, 50);
	 l4.setFont(new Font("TimesRoman", Font.BOLD, 27));

     tf1.setBounds(470, 210, 200, 36);
     tf2.setBounds(470, 260, 200, 36);
	 tf1.setFont(new Font("TimesRoman", Font.ITALIC, 18));
	 tf2.setFont(new Font("TimesRoman", Font.ITALIC, 18));

     p1.setBounds(470, 310, 200, 36);
     p2.setBounds(470, 360, 200, 36);
     
     c.add(h);
     c.add(l1);
     c.add(l2);
     c.add(l3);
     c.add(l4);
     c.add(tf1);
     c.add(tf2);
     c.add(p1);
     c.add(p2);
     setVisible(true);

	}
	

    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == b1)
         {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
 
            String s3 = p1.getText();
            String s4 = p2.getText();
            String s8 = new String(s3);
            String s9 = new String(s4);
            if (s8.equals(s9))
           {
                try
               {
        Connection con=ConnectionProvider.getCon();
  		PreparedStatement ps=con.prepareStatement("select * from users where uname =? and pswd=?");
  		ps.setString(1, s1);
		ps.setString(2, s2);
		ResultSet rs=ps.executeQuery();	
		
   boolean recordfound = rs.next();

  if((s1.equals("")) && (s2.equals("")))
   {
  JOptionPane.showMessageDialog(null,"Please Enter User Name/Password");
  return;
   }  
  
      if(recordfound)
      {
    	 // this.dispose();
    
          PreparedStatement ps1=con.prepareStatement("update users set pswd=? where uname=? and pswd=?");
          ps1.setString(1, s8);
          ps1.setString(2, s1);
          ps1.setString(3, s2);
          ps1.executeUpdate();
          JOptionPane.showMessageDialog(null,"Database Updated");
          this.dispose();
          new reservations(s);
      }

      
      else
      {
       JOptionPane.showMessageDialog(null,"Invalid User Name/Password");
       tf1.setText("");
       tf2.setText("");

      }
         }
                catch (Exception ex) 
                {
                   System.out.println(ex);
               }
           }
            else
            {
                 JOptionPane.showMessageDialog(b1, "Password Does Not Match");
             } 
         }
        else{
        	this.dispose();
        	new reservations(s);
        }
    }
       
	public static void main(String []args)
	{
		new buttonicon();
	}
	
}
