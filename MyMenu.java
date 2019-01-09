
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyMenu implements ActionListener
 {
JFrame f;
//Panel p;
MenuBar mb;
Menu us, ad,sh;
MenuItem lg,erf,sar,sbr,sir;
public MyMenu()
{
	f=new JFrame("Welcome MyMenu");
	mb=new MenuBar();
	
	us= new Menu("USER");
	ad =new Menu("ADMIN");
	

        
	sh=new Menu("SHOW RESULT");
	lg=new MenuItem("LOGIN ");
        erf =new MenuItem("Exit");
        sar=new MenuItem("SHOW ALL RESULT");
        sbr=new MenuItem("SHOW BRANCH RESULT");
        sir=new MenuItem("SHOW INDIVIDUAL RESULT");
        
	
	
	f.setMenuBar(mb);
	mb.add(us);
	
	us.add(sh);
        mb.add(ad);
	ad.add(lg);
        ad.add(erf);
        erf.addActionListener(this);
       
        
	sh.add(sar);
        sar.addActionListener(this);
        sh.add(sbr);
        sbr.addActionListener(this);
        sh.add(sir);
        sir.addActionListener(this);
	

        
        lg.addActionListener(this);
        
	f.setVisible(true);
	f.setSize(400,400);
        //p.setBackground(Color.pink);
        
	}
public void actionPerformed(ActionEvent e)
{
Object obj=e.getSource();
 if(obj==lg)
{
Login l=new Login();
}
else if(obj==sir)
{
    ShowEnggResult fgt=new ShowEnggResult();
}                          
else if  (obj==sar)
{
    ShowAll sha  =new ShowAll();
}
else if(obj == sbr)
{
    ShowEngg MF=new ShowEngg();
}

else if(obj==erf)
{
f.dispose();
}

}
	public static void main(String[] args)
 {
		MyMenu at=new MyMenu();
		                                                                     
	}

}
