package learnswing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class under_construction extends JFrame implements ActionListener {

	Container c;
	JLabel l1;
	
	Icon img1,img2;
	JButton back;
	String st;
	under_construction(String s){
		st=s;
		c=getContentPane();
		c.setBackground(Color.WHITE);
		setTitle("SKAN APPLICATION ");
		setSize(1025,700);
		setLayout(null);
		
		 img1=new ImageIcon("bck.png");
		 back = new JButton(img1);
		 back.setBounds(0,10,69,69);
		 back.setBackground(Color.BLACK);
		 
		 img2=new ImageIcon("aes.png");
		 l1=new JLabel(img2);
		 l1.setBounds(150,90,700,500);
		 
		 c.add(back);
		 c.add(l1);
		 
		 back.addActionListener(this);
		 
		 setVisible(true);
		 
		}

	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new reservations(st);
	}
	
	public static void main(String agrs[])
	{
		new buttonicon();
	}
	
}
