
package learnswing;

import javax.swing.*;

import com.sandeep.dao.ConnectionProvider;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class Registration extends JFrame implements ActionListener 
  { 
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    JButton btn1, btn2;
    JPasswordField p1, p2;
    JButton back;
    Icon img1;
    
    Registration()
     {
        setVisible(true);
        setSize(700, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SKAN APPLICATION ");
 
        l1 = new JLabel("Registration Form");
        
        l1.setFont(new Font("Serif", Font.BOLD, 36));
 
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email-ID:");
        l4 = new JLabel("Create Passowrd:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Country:");
        l7 = new JLabel("State:");
        l8 = new JLabel("Phone No:"); 
        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
 
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
 
        l1.setBounds(162, 10, 400, 40);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
 
        
        img1=new ImageIcon("reg_bck.jpg");
   	 back = new JButton(img1);
   	 back.setBounds(0,10,48,48);
   	 back.setBackground(Color.BLACK);
     back.addActionListener(this);
     
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
   	 	add(back);

    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
 
            String s3 = p1.getText();
           String s4 = p2.getText();
            String s8 = new String(s3);
            String s9 = new String(s4);
 
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            if (s8.equals(s9))
           {
                try
               {
                	Connection con=ConnectionProvider.getCon();
  		PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?,?,?)");
ps.setString(1, s1);
ps.setString(2, s2);
ps.setString(3, s3);
ps.setString(4, s5);
ps.setString(5, s6);
ps.setString(6, s7);



            		ps.executeUpdate();
            		 	 this.dispose();
            		 	 new Login();

                   }
          catch (Exception ex) 
                {
                    System.out.println(ex);
                }
            }
          else
           {
                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
            } 
        } 
          else if(e.getSource() == btn2)
       {
            tf1.setText("");
            tf2.setText("");
            p1.setText("");
            p2.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
        }
          else{
        	  this.dispose();
        	  new Login();
          }
    } 
    public static void main(String args[])
   {
        new buttonicon();
    }
}
