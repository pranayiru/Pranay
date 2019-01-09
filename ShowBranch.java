import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;
import java.sql.*;


public class ShowBranch {
    String username = "sa";
String password = "";
String Database = "jdbc:odbc:khem";
Connection Conn;
    JFrame f;
    ShowBranch(String str23)
    {
        try
        {
        f = new JFrame("menu");
        f.setSize(400,300);
f.setLocation(200,100);
f.setTitle("Stock Report");


JPanel jPanel = new JPanel( new BorderLayout() );




Conn = DriverManager.getConnection( Database, username, password );
System.out.println("*** Connect to the database ***");

//Access Rows and Columns from database
Vector<String> Columns = new Vector<String>();
Vector<Vector<Object>> Rows = new Vector<Vector<Object>>();
String Query = "Select * from Result where stubranch='"+str23+"'";

Statement smnt = Conn.createStatement();
ResultSet results = smnt.executeQuery( Query );
ResultSetMetaData metaDt = results.getMetaData();

int cols = metaDt.getColumnCount();
Columns.clear(); // clear unwanted value if exist any in Columns variable.

//Get Columns From database
for (int i = 1; i <= cols; i++)
{
Columns.addElement(metaDt.getColumnName(i));
}

Rows.clear(); // clear unwanted value if exist any in Rows variable.	
//Get RowsNames From database
while( results.next())
{
Vector<Object> row = new Vector<Object>(cols); 
for (int i = 1; i <= cols; i++)
{
row.addElement(results.getObject(i));
}
Rows.addElement(row); 
}

results.close(); //close Resultset.
smnt.close(); //close Statement.

//Define TableModel
TableModel tmodel = new DefaultTableModel(Rows, Columns){ };

// JTable Creation
JTable Table = new JTable(tmodel);
JScrollPane scroll = new JScrollPane(Table);
jPanel.add(scroll); 
f.add(jPanel, BorderLayout.CENTER);
f.setVisible(true);
Conn.commit();
Conn.close(); //Close Connection to the database 
        }
        catch(Exception e)
        {
            
        }
    }

  //public static void main(String arg[])
//{
  //        ShowBranch cbhj  = New ShowBranch();
//}
} 
