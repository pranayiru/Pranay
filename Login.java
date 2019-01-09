import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Login implements ActionListener
{

JFrame f;
Panel p;
Label l1,l2;
TextField tf1,tf2;
JButton b1,b2;
GridBagLayout gbl;
GridBagConstraints gbc;
public Login()   
 {
f=new JFrame("Login Form");   
p=new Panel();
tf1=new TextField(30);
tf2=new TextField(30);
tf2.setEchoChar('*');

b1=new JButton("SUBMIT");
b2=new JButton("Exit");

l1=new Label(" ENTER USER NAME");
l2=new Label(" ENTER PASSWORD");

f.add(p);


gbl=new GridBagLayout();
gbc=new GridBagConstraints();
p.setLayout(gbl);
gbc.anchor= GridBagConstraints.WEST;

gbc.gridx=1;
gbc.gridy=1;
gbl.setConstraints(l1,gbc);
p.add(l1);
gbc.gridx=3;
gbc.gridy=1;
gbl.setConstraints(tf1,gbc);
p.add(tf1);

gbc.gridx=1;
gbc.gridy=2;
gbl.setConstraints(l2,gbc);
p.add(l2);
gbc.gridx=3;
gbc.gridy=2;
gbl.setConstraints(tf2,gbc);
p.add(tf2);

gbc.gridx=3;
gbc.gridy=6;
gbl.setConstraints(b1,gbc);
p.add(b1);

b1.addActionListener(this);

//gbc.gridx=3;
//gbc.gridy=8;
//gbl.setConstraints(b2,gbc);
//p.add(b2);

//b2.addActionListener(this);

f.setVisible(true);

f.setSize(400,300);
p.setBackground(Color.pink);

}
    
public void actionPerformed(ActionEvent e)
{
Object obj=e.getSource();
if(obj==b1)
{
     try
{


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co;
co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
PreparedStatement stmt;
stmt=co.prepareStatement("select * from Login where username=? and userpassword=?");
stmt.setString(1,tf1.getText());
stmt.setString(2,tf2.getText());

ResultSet rs=stmt.executeQuery();
if(rs.next())
{
Registation rg=new Registation();

}

else
{
 
JOptionPane.showMessageDialog(null,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
}
}
catch(Exception ex1)
{
System.out.println(e);
}  

}
}

public static void main(String arg[])
{
Login l=new Login();
}
}







