
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
public class ShowEngg implements ActionListener
{
JFrame f;
Panel p,p1;
Label l;
Choice ch;

JButton b1,b2;

GridBagLayout gbl;
GridBagConstraints gbc;
GridLayout gl;

public ShowEngg()
{
f=new JFrame("My Result");
p=new Panel();
p1=new Panel();
  p1.setSize(400,300);
p1.setLocation(200,100);



l=new Label("Branch");




ch=new Choice();
ch.addItem("---Select One---");
ch.addItem("C.S.E");
ch.addItem("M.E");
ch.addItem("E.C.E");
ch.addItem("E.E.E");
ch.addItem("C.E");



b1=new JButton("Submit");
b2=new JButton("Exit");

gbl=new GridBagLayout();
gbc=new GridBagConstraints();
gl=new GridLayout(2,1);
f.setLayout(gl);

p.setLayout(gbl);


gbc.anchor=GridBagConstraints.NORTHWEST;

		
gbc.gridx=1;
gbc.gridy=5;
gbl.setConstraints(l,gbc);
p.add(l);
gbc.gridx=4;
gbc.gridy=5;
gbl.setConstraints(ch,gbc);
p.add(ch);


gbc.gridx=4;
gbc.gridy=19;
gbl.setConstraints(b1,gbc);
p.add(b1);
b1.addActionListener(this);


gbc.gridx=4;
gbc.gridy=21;
gbl.setConstraints(b2,gbc);
p.add(b2);
b2.addActionListener(this);


f.add(p);
f.add(p1);


f.setVisible(true);
f.setLocation(300,300);
f.setSize(400,400);
}
public void actionPerformed(ActionEvent e)
{
Object obj=e.getSource(); 
if(obj==b1)
{
Submit();
}
if(obj==b2)
{
f.dispose();
}
}

public void Submit()
{
   String st23 = ch.getSelectedItem();
   ShowBranch cbhj = new  ShowBranch(st23);
}

}






