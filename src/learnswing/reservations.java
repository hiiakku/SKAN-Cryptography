

package learnswing;

import javax.swing.*;

import com.sandeep.dao.ConnectionProvider;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.*;

/**
 * @author akki
 *
 */

public class reservations extends JFrame implements ActionListener {
	
	Container c;
	JLabel lbl,lb2,lb3,lb4;
	JButton b1,b2,b3,b4,lgo;
	String s;
	Icon img1,img2,img3,img4,img; 

	 reservations(String st)
	 {
		s=st;
	 c=getContentPane();
	 c.setBackground(new Color(188,143,143));
	 setTitle("SKAN APPLICATION ");
	 setSize(1025,738);
	 setLayout(null);
	 
	 lbl=new JLabel(" SKAN FEATURES ");
	 lbl.setBounds(230,100,800,100);
	 lbl.setFont(new Font("TimesRoman", Font.BOLD, 63));
	 
	 lb2=new JLabel("WELCOME "+s );
	 lb2.setBounds(390,35,800,30);
	 lb2.setFont(new Font("TimesRoman", Font.BOLD, 27));
	 
	 img1=new ImageIcon("encode.jpg");
	 img2=new ImageIcon("decode.jpg");
	 img3=new ImageIcon("change.jpg");
	 img4=new ImageIcon("image.jpg");
	 img=new ImageIcon("lgo.png");
	 
	 b1=new JButton(img3);
	 b1.setBounds(109,260,372,195);
	 b1.setBackground(Color.black);
	 b1.addActionListener(this);
	 b1.setToolTipText(" RESET PASSWORD ");
	 
	 b2=new JButton(img2);
	 b2.setBounds(510,260,360,195);
	 b2.setBackground(Color.black);
	 b2.addActionListener(this);
	 b2.setToolTipText(" DECRYPT DATA ");

	 b3=new JButton(img1);
	 b3.setBounds(109,468,372,195);
	 b3.setBackground(Color.black);
	 b3.addActionListener(this);
	 b3.setToolTipText(" ENCRYPT DATA ");

	 
	 b4=new JButton(img4);
	 b4.setBounds(510,468,360,195);
	 b4.setBackground(Color.black);
	 b4.addActionListener(this);
	 b4.setToolTipText("  ABOUT AES ALGORITHM  ");
	 
	 lgo=new JButton(img);
	 lgo.setBounds(918,20,90,50);
	 lgo.addActionListener(this);
	 
	 c.add(lgo);
	 c.add(lbl);
	 c.add(lb2);
	
	 c.add(b1);
	 c.add(b2);
	 c.add(b3);
	 c.add(b4);

	 setVisible(true);
	}

	 public void actionPerformed(ActionEvent e) 
     {
     	this.dispose();
        if (e.getSource() == b1)
         {
        	new change_pswd(s);
          }
         else if(e.getSource()==b2)
          {
        	 new decrypt(s);
          }
         else if (e.getSource()==b3)
         {
        	 new encrypt(s);
        }
        else if(e.getSource()==b4)
        {
       	 new under_construction(s);

        }
        else{
        	new Login();
        }
    }

	public static void main(String args[])
	 {
	 new buttonicon();
	 }
	}
	

