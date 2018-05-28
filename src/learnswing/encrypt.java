package learnswing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sandeep.dao.ConnectionProvider;


class encrypt extends JFrame implements ActionListener{

	Container c;
	JLabel l1,l2,l3,l4;
	JTextArea ta;
	JTextField tf,tf1;
	Icon img,img1;
	JButton back,encode,reset;
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border compound;
	String st;
	encrypt(String s){
		st=s;
		c=getContentPane();
		c.setBackground(new Color(180,120,250));//(240,230,140));
		setTitle("SKAN APPLICATION ");
		setSize(972,700);
		setLayout(null);
		
		l2=new JLabel(" PROTECT YOUR DATA ");
		l2.setBounds(150,15,900,50);
		l2.setFont(new Font("TimesRoman", Font.BOLD, 54));

		l1= new JLabel("Enter the text below to encrypt. ");
		l1.setBounds(45, 108, 500, 45);
		l1.setFont(new Font("TimesRoman", Font.BOLD, 27));
		
		l3=new JLabel("Enter Public Key ");
		l3.setBounds(415,588,180,36);
		l3.setFont(new Font("TimesRoman", Font.ITALIC, 21));

		l4=new JLabel("File Title");
		l4.setBounds(549,112,120,45);
		l4.setFont(new Font("TimesRoman", Font.ITALIC, 27));

		tf=new JTextField();
		tf.setBounds(585, 594, 270, 27);
		
		tf1=new JTextField();
		tf1.setBounds(675, 118, 180, 30);
		
		ta= new JTextArea();
		ta.setBounds(45,160,810,400);
		compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		ta.setBorder(compound);
		ta.setBackground(new Color(253,245,230));
		

		 img1=new ImageIcon("back1.jpg");
		 back = new JButton(img1);
		 back.setBounds(0,10,69,69);
		 back.setBackground(Color.BLACK);
		 
		 encode= new JButton("Encrypt");
		 encode.setBounds(54,594,90,36);
		 
		 reset=new JButton("Reset");
		 reset.setBounds(240,594,90,36);
		 
		 back.addActionListener(this);
	     encode.addActionListener(this);
	     reset.addActionListener(this);
	     
	     c.add(l4);
	     c.add(tf1);
	     c.add(tf);
	     c.add(l3);
	     c.add(reset);
		 c.add(encode);
		 c.add(back);
		
		c.add(l2);

		c.add(ta);
		c.add(l1);
		setVisible(true);
		
	}
	
	public static void main(String args[]){
		new buttonicon();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

        if (e.getSource() == encode)
         {
            
            String s1 = ta.getText();
            //System.out.println(s1);
            String s2 = tf.getText();
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
            //System.out.println(newString);

            String s3 = tf1.getText();

                try
               {
        Connection con=ConnectionProvider.getCon();
        AES a=new AES(newString,s2,0);
        //RSA rs = new RSA(newString);
        
  		PreparedStatement ps=con.prepareStatement("insert into user_data values(?,?,?,?)");
  		ps.setString(1, st);
		ps.setString(2, newString);
		ps.setString(3, s3);
		ps.setString(4, s2);
		ps.executeUpdate();	
		
		
		JOptionPane.showMessageDialog(null,"Database Updated");
        this.dispose();
        new reservations(st);
               }
                catch (Exception ex) 
                {
                   System.out.println(ex);
               }
         }
        else if(e.getSource()== reset)
        {
        	ta.setText("");
        	tf.setText("");
        	tf1.setText("");
        }
        else{
        	this.dispose();
            new reservations(st);
        }
	}
	
	
}
