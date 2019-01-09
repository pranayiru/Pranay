import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class Result implements ActionListener
{
JFrame f;
Panel p;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;

JButton b1,b2,b3,b4,b5,b6;

GridBagLayout gbl;
GridBagConstraints gbc;
public Result()
{
f=new JFrame("Submit Result");
p=new Panel();
l1=new Label("Registation No.");
l2=new Label("UniversityRollno.");
l3=new Label("Branch");
l4=new Label("year");
l5=new Label("Semester");
l6=new Label("Subject marks");
l7=new Label("Lab Marks");
l8=new Label("Total");
l9=new Label("Percentage");

t1=new TextField(10);
t2=new TextField(20);
t3=new TextField(20);
t4=new TextField(20);
t5=new TextField(20);
t6=new TextField(40);
t7=new TextField(40);
t8=new TextField(20);
t9=new TextField(20);

b1=new JButton("Save");
b2=new JButton("Exit");
b3=new JButton("Submit");
b4=new JButton ("Update");
b5=new JButton ("Delete");
b6=new JButton ("Retrieve");

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
gbl.setConstraints(t3,gbc);
p.add(t3);

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
gbc.gridx=1;
gbc.gridy=15;
gbl.setConstraints(l8,gbc);
p.add(l8);
gbc.gridx=4;
gbc.gridy=15;
gbl.setConstraints(t8,gbc);
p.add(t8);
gbc.gridx=1;
gbc.gridy=17;
gbl.setConstraints(l9,gbc);
p.add(l9);
gbc.gridx=4;
gbc.gridy=17;
gbl.setConstraints(t9,gbc);
p.add(t9);
		

gbc.gridx=4;
gbc.gridy=21;
gbl.setConstraints(b1,gbc);
p.add(b1);
b1.addActionListener(this);

gbc.gridx=6;
gbc.gridy=21;
gbl.setConstraints(b2,gbc);
p.add(b2);
b2.addActionListener(this);

gbc.gridx=5;
gbc.gridy=1;
gbl.setConstraints(b3,gbc);
p.add(b3);
b3.addActionListener(this);

gbc.gridx=4;
gbc.gridy=22;
gbl.setConstraints(b4,gbc);
b4.addActionListener(this);
p.add(b4);

gbc.gridx=5;
gbc.gridy=22;
gbl.setConstraints(b5,gbc);
b5.addActionListener(this);
p.add(b5);

gbc.gridx=6;
gbc.gridy=22;
gbl.setConstraints(b6,gbc);
b6.addActionListener(this);
p.add(b6);

f.add(p);
t2.enable(true);
t3.enable(true);
t4.enable(true);
f.setVisible(true);
f.setSize(600,600);
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
 f.setVisible(true);
}                                           
if(obj==b3)
{
Submit();
}
if(obj==b4)
{
    update();
  
}
if (obj==b5)
{
    delete();
}
if (obj==b6);
{
  retrieve();
}     
}
public void Save()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
PreparedStatement stmt=co.prepareStatement("insert into Result values(?,?,?,?,?,?,?,?,? )");
stmt.setString(1,t1.getText());
stmt.setString(2,t2.getText());
stmt.setString(3,t3.getText());
stmt.setString(4,t4.getText());
stmt.setString(5,t5.getText());
stmt.setString(6,t6.getText());
stmt.setString(7,t7.getText());
stmt.setString(8,t8.getText());
stmt.setString(9,t9.getText());
stmt.executeUpdate();
//System.out.println ("Value Saved successfully");
JOptionPane.showMessageDialog(null,"value is Saved successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}
}

public void Submit()
{
    System.out.print(("hello"));
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
Statement Stat=co.createStatement();
ResultSet  rs;
rs=Stat.executeQuery("Select *  from  Result where sturegstation_no='"+t1.getText()+"' ");
t1.setText("");
rs.next();
t1.setText(rs.getString(1));
t2.setText(rs.getString(2));
t3.setText(rs.getString(3));
t4.setText(rs.getString(4));
t5.setText(rs.getString(5));
t6.setText(rs.getString(6));
t7.setText(rs.getString(7));
}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}


}
public void retrieve()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
Statement Stat=co.createStatement();
ResultSet  rs;
rs=Stat.executeQuery("Select *  from  Result where sturegistation_no='"+t1.getText()+"' ");

rs.next();

t2.setText(rs.getString(2));
t3.setText(rs.getString(3));
t4.setText(rs.getString(4));
t5.setText(rs.getString(5));
t6.setText(rs.getString(6));
t7.setText(rs.getString(7));
t8.setText(rs.getString(8));
t9.setText(rs.getString(9));
}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}
}
public void delete()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
PreparedStatement stmt=co.prepareStatement("Delete from Result where sturegistation_no=? ");
stmt.setString(1,t1.getText());
stmt.executeUpdate();
//System.out.println ("Value Deleted successfully");
JOptionPane.showMessageDialog(null,"value is Deleted successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}
}
public void update()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
PreparedStatement stmt=co.prepareStatement("Update Result set stubranch=?,stusemester=?,stusub_marks=?,stuLab_marks=?,stutotal=?,stupercentage=? where  sturegistation_no=?");

stmt.setString(1,t2.getText());
stmt.setString(2,t3.getText());
stmt.setString(3,t4.getText());
stmt.setString(4,t5.getText());
stmt.setString(5,t6.getText());
stmt.setString(6,t7.getText());
stmt.setString(7,t1.getText());
stmt.executeUpdate();
//System.out.println ("Value updated successfully");
JOptionPane.showMessageDialog(null,"value inserted successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}
}

public static void main(String arg[])
{
Result r=new Result();
}
}
