package learnswing;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class buttonicon extends JFrame implements ActionListener
{

Container c;
JLabel lbl;
JButton b;

Icon img1; 

 buttonicon()
 {
 c=getContentPane();
 c.setBackground(new Color(205,92,92));//(100,145,150));//(240,230,140));
 setTitle("SKAN APPLICATION ");
 setSize(1025,700);
 setLayout(null);
 
 lbl=new JLabel(" Welcome To SKAN ");
 lbl.setBounds(198,15,800,100);
 lbl.setFont(new Font("TimesRoman", Font.BOLD, 63));

 JTextArea textField = new JTextArea("Privacy is possible and SKAN makes it easy. SKAN while being a lightweight application enables one to easily encrypt/decrypt text and informations and thus secure them. An efficient application for saving your private information in encrypted format protected by a key. SKAN also assists in choosing the key by creating it using user relevant details thus saving the user from the brainstorming process .");
 textField.setBounds(30,470,945,300);
 textField.setLineWrap(true);
 textField.setWrapStyleWord(true);
 textField.setBackground(new Color(205,92,92));//100,145,150));
 textField.setFont(new Font("VARDANA", Font.ITALIC, 21));

 img1=new ImageIcon("encrypt.jpg");

 b=new JButton(img1);
 b.setBounds(270,135,432,291);
 b.setBackground(Color.BLACK);
 b.addActionListener(this);

 c.add(lbl);
 c.add(textField);
 c.add(b);
 setVisible(true);
}

public void actionPerformed(ActionEvent ae)
 {
 this.dispose();
 new Login();
}

public static void main(String args[])
 {
 buttonicon obj=new buttonicon();
 }
}