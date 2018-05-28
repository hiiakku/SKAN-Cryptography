package learnswing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sandeep.dao.ConnectionProvider;

public class decrypt extends JFrame implements ActionListener{

	Container c;
	JLabel l1,l2,l3;

	Icon img,img1;
	JButton back;
	String st;
	JButton b[];
	JButton del,sav;
	int bs;
	ResultSet rs;
	decrypt(String s)
	{
		st=s;
		c=getContentPane();
		c.setBackground(new Color(127,255,0));
		setTitle("SKAN APPLICATION ");
		setSize(1025,700);
		setLayout(null);
		
		l1= new JLabel();
		l1.setBounds(100,90,600,45);
		l1.setFont(new Font("TimesRoman", Font.ITALIC, 36));

		 img1=new ImageIcon("g_bck.png");

		 
		 c.add(l1);
		
		 try
         {
  Connection con=ConnectionProvider.getCon();
	
	PreparedStatement ps1=con.prepareStatement("select * from user_data where uname=?");
	ps1.setString(1, st);
	
	
	
	rs=ps1.executeQuery();
	
	int x=100,y=150;
	int ct=0;
	while(rs.next())
		ct=ct+1;
	
	if(ct==0)
	{
		c.setBackground(Color.WHITE);
		l1.setText("SORRY You have no encrypted files .");
		l1.setBounds(240, 100, 600, 100);
		img=new ImageIcon("D:\\no.jpg");
		img1=new ImageIcon("D:\\y_bck.png");
		l2=new JLabel(img);
		l2.setBounds(270, 200, 460, 370);
		c.add(l2);
		
	}
	
	else{
		l1.setText("Following are your encrypted files .");
		b=new JButton[ct];
		
		rs.first();
		bs=ct;
	for(int i=0;i<ct;i++)
	{
		b[i]=new JButton(rs.getString(3));
				b[i].setBounds(x+40,y+40,100,40);
				x=x+150;
				if(x>800)
				{
					y=y+60;
					x=100;
				}
				b[i].addActionListener(this);
				c.add(b[i]);
				rs.next();
	}
	rs.first();

         }
         }
          catch (Exception ex) 
          {
             System.out.println(ex);
         }
		
  		 back = new JButton(img1);
		 back.setBounds(0,10,69,69);
		 back.setBackground(Color.BLACK);
		 back.addActionListener(this);
		 c.add(back);
		setVisible(true);
		
	}
	public static void main(String args[]){
		new buttonicon();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==back)
			{
			this.dispose();
		new reservations(st);
			}
		else{
			try{
				String input_msg=JOptionPane.showInputDialog(c,"Enter key to decrypt","Public key",JOptionPane.WARNING_MESSAGE);
				if(input_msg!=null)
				{		
			for(int i=0;i<bs;i++)
			{
				
				if(e.getSource()==b[i])
					{
					this.dispose();
					new displayData(rs.getString(1),rs.getString(3),input_msg);
					break;
					}
				rs.next();

			}
		}
			}
	          catch (Exception ex) 
	          {
	             System.out.println(ex);
	         }
		}
	}
}
