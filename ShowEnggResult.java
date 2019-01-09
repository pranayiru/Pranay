import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import javax.swing.*;
import java.awt.print.*;
public class ShowEnggResult  implements  ActionListener,Printable
{
JFrame f;
Panel p,p1;
Label l2,l3,l4,l5,l6,l7,l8;
TextField t2,t4,t5,t6,t7,t8;
Choice ch;

Button b1,b2,b3;

GridBagLayout gbl;
GridBagConstraints gbc;
GridLayout gl;

public ShowEnggResult()
{
f=new JFrame("My Result");
p=new Panel();
p1=new Panel();

l2=new Label("Regisrtation No.");
l3=new Label("Branch");
l4=new Label("University Roll No.");
l5=new Label("Subject Marks");
l6=new Label("Lab Marks");
l7=new Label("Total");
l8=new Label("Percentage");

t2=new TextField(10);

t4=new TextField(10);
t5=new TextField(40);
t6=new TextField(40);
t7=new TextField(10);
t8=new TextField(10);
ch=new Choice();
ch.addItem("---Select One---");
ch.addItem("C.S.E");
ch.addItem("M.E");
ch.addItem("E.C.E");
ch.addItem("E.E.E");
ch.addItem("C.E");



b1=new Button("Ok");
b2=new Button("Cancel");
b3=new Button("Print");

gbl=new GridBagLayout();
gbc=new GridBagConstraints();
gl=new GridLayout(2,1);
f.setLayout(gl);

p.setLayout(gbl);
p1.setLayout(gbl);

gbc.anchor=GridBagConstraints.NORTHWEST;

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
p1.add(l5);
gbc.gridx=4;
gbc.gridy=9;
gbl.setConstraints(t5,gbc);
p1.add(t5);


gbc.gridx=1;
gbc.gridy=11;
gbl.setConstraints(l6,gbc);
p1.add(l6);
gbc.gridx=4;
gbc.gridy=11;
gbl.setConstraints(t6,gbc);
p1.add(t6);

gbc.gridx=1;
gbc.gridy=13;
gbl.setConstraints(l7,gbc);
p1.add(l7);
gbc.gridx=4;
gbc.gridy=13;
gbl.setConstraints(t7,gbc);
p1.add(t7);
gbc.gridx=1;
gbc.gridy=15;
gbl.setConstraints(l8,gbc);
p1.add(l8);
gbc.gridx=4;
gbc.gridy=15;
gbl.setConstraints(t8,gbc);
p1.add(t8);


gbc.gridx=4;
gbc.gridy=19;
gbl.setConstraints(b1,gbc);
p.add(b1);
b1.addActionListener(this);


gbc.gridx=7;
gbc.gridy=21;
gbl.setConstraints(b2,gbc);
p.add(b2);
b2.addActionListener(this);

gbc.gridx=4;
gbc.gridy=23;
gbl.setConstraints(b3,gbc);
p1.add(b3);
b3.addActionListener(this);


f.add(p);
f.add(p1);

f.setVisible(true);
f.setLocation(300,300);
f.setSize(600,600);
}

    public void actionPerformed(ActionEvent e) {
       Object obj =  e.getSource();
       if(obj==b1)
       {
         try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection co=DriverManager.getConnection("jdbc:odbc:khem","sa","");
Statement Stat=co.createStatement();
ResultSet  rs;
rs=Stat.executeQuery("Select *  from  Result where sturegistation_no='"+t2.getText()+"'and stubranch='"+ch.getSelectedItem()+"'and stuuniversityrllo_no='"+t4.getText()+"'");

rs.next();


t5.setText(rs.getString(5));
t6.setText(rs.getString(6));
t7.setText(rs.getString(7));
t8.setText(rs.getString(8));
}
catch(Exception ex1)
{
System.out.println("error found"+ex1);
}  
       }
       else  if (obj ==  b2)
       {
      f.dispose();   
       }
       else  if (obj ==b3 )
       {
        PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }   
       }

}
public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) { 
            return NO_SUCH_PAGE;
        }

        
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        String  str10   ="ENGINEERING STUDENT RESULT";
        String str11   = "===========================";
     String str12 =  "Registration  No.         "+t2.getText();
      String  str13= "Branch                    " +ch.getSelectedItem();
      String str14 = "University RollNO         " +t4 .getText();
      String str15 = "Subject Marks              "+t5.getText();
      String str16 = "Lab Marks                     "+t6.getText();
      String str17=  "Total                       "+t7.getText(); 
      String str18 = "Percentage                "+t8.getText()+"%"; 
     g.drawString(str11,175,200);
     
        g.drawString(str10,175,205);
        g.drawString(str12,150,230);
         g.drawString(str13,150,260);
          g.drawString(str14,150,290);
           g.drawString(str15,150,320);
            g.drawString(str16,150,350);
             g.drawString(str17,150,380);
            

       
        return PAGE_EXISTS;
    }
                  public static void main(String args[])
           {
          ShowEnggResult sher=new ShowEnggResult();
}

}


