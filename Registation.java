import java.awt.*;
import java.sql.*;
import javax. swing.*;
import java.awt.event.*;
public class Registation implements ActionListener
{
JFrame f;
Panel p;
Label l1,l2,l3,l4,l5,l6,l7;
TextField t1,t2,t4,t5,t6,t7;
JButton b1,b2,b3;
Choice ch;
GridBagLayout gbl;
GridBagConstraints gbc;
public Registation()
{
f=new JFrame("REGISTATION FORM");
p=new Panel();
l1=new Label("Registation No:");
l2=new Label("Name:");
l3=new Label("Branch:");
l4=new Label("University RollNo:");
l5=new Label("Address:");
l6=new Label("Batch:");
l7=new Label("Contact No:");

t1=new TextField(10);
t2=new TextField(20);

t4=new TextField(20);
t5=new TextField(20);
t6=new TextField(20);
t7=new TextField(20);

ch=new Choice();
ch.addItem("---Select One---");
ch.addItem("C.S.E");
ch.addItem("M.E");
ch.addItem("E.C.E");
ch.addItem("E.E.E");
ch.addItem("C.E");


b1=new JButton("Save");
b2=new JButton("Next");
b3=new JButton("Exit");


gbl=new GridBagLayout();
gbc=new GridBagConstraints();
f.add(p);
p.setLayout(gbl);
gbc.anchor=GridBagConstraints.NORTHWEST;
gbc.gridx=1;
gbc.gridy=1;
gbl.setConstraints(l1,gbc);
p.add(l1);
gbc.gridx=4;
gbc.gridy=1;
gbl.setConstraints(t1,gbc);
p.add(t1);

gbc.gridx=1;
gbc.gridy=3;
gbl.setConstraints(l2,gbc);
p.add(l2);
gbc.gridx=4;
gbc.gridy=3;
gbl.setConstraints(t2,gbc);
p.add(t2);
		
gbc.gridx=1;
gbc.gridy=5;
gbl.setConstraints(l3,gbc);
p.add(l3);
gbc.gridx=4;
gbc.gridy=5;
gbl.setConstraints(ch,gbc);
p.add(ch);

gbc.gridx=1;
gbc.gridy=7;
gbl.setConstraints(l4,gbc);
p.add(l4);
gbc.gridx=4;
gbc.gridy=7;
gbl.setConstraints(t4,gbc);
p.add(t4);

gbc.gridx=1;
gbc.gridy=9;
gbl.setConstraints(l5,gbc);
p.add(l5);
gbc.gridx=4;
gbc.gridy=9;
gbl.setConstraints(t5,gbc);
p.add(t5);
		
gbc.gridx=1;
gbc.gridy=11;
gbl.setConstraints(l6,gbc);
p.add(l6);
gbc.gridx=4;
gbc.gridy=11;
gbl.setConstraints(t6,gbc);
p.add(t6);
		
gbc.gridx=1;
gbc.gridy=13;
gbl.setConstraints(l7,gbc);
p.add(l7);
gbc.gridx=4;
gbc.gridy=13;
gbl.setConstraints(t7,gbc);
p.add(t7);
		

gbc.gridx=4;
gbc.gridy=21;
gbl.setConstraints(b1,gbc);
b1.addActionListener(this);
p.add(b1);

gbc.gridx=6;
gbc.gridy=21;
gbl.setConstraints(b2,gbc);
b1.addActionListener(this);
p.add(b2);
b2.addActionListener(this);


gbc.gridx=8;
gbc.gridy=23;
gbl.setConstraints(b3,gbc);
b1.addActionListener(this);
p.add(b3);
b3.addActionListener(this);


f.add(p);
f.setVisible(true);
f.setSize(500,500);
}

public void actionPerformed(ActionEvent e)
{
Object obj=e.getSource();
if (obj==b1)
{
Save();
}
if(obj==b2)
{
Result re=new Result();
}
else if(obj==b3)
{
f.dispose();
MyMenu mn = new  MyMenu();
}


}

public void Save()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
PreparedStatement stmt=co.prepareStatement("insert into Registation values(?,?,?,?,?,?,? )");
stmt.setString(1,t1.getText());
stmt.setString(2,t2.getText());
stmt.setString(3,ch.getSelectedItem());
stmt.setString(4,t4.getText());
stmt.setString(5,t5.getText());
stmt.setString(6,t6.getText());
stmt.setString(7,t7.getText());
stmt.executeUpdate();

JOptionPane.showMessageDialog(null,"value is Saved successfully");

}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}
}
public static void main(String arg[])
{
Registation rg=new Registation();
}
 }




