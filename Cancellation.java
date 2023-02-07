import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Cancellation extends Frame implements ActionListener
{
        Label l1,l2,l3;
	TextField t1;
        
	Button b1,b2;
	GridBagLayout gbl;
	GridBagConstraints gbc; 
        Connection con;
        PreparedStatement ps;
        Statement stmt;
	ResultSet rs;
	int count;
	Font f;
	Cancellation()
 {
         setBackground(Color.red);
         f = new Font("TimesRoman",Font.BOLD,20);
         gbl=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 setLayout(gbl);
	 
         l1 = new Label("PNR No");
	 l1.setFont(f);
         
         t1 = new TextField(20);
         
         l2 = new Label("");
	 l3 = new Label("");
          
         b1 = new Button("Submit");
	 b2 = new Button("Reset");

         gbc.gridx=0;
	 gbc.gridy=0;
	 gbl.setConstraints(l1,gbc);
	 add(l1);

         gbc.gridx=2;
	 gbc.gridy=0;
	 gbl.setConstraints(t1,gbc);
	 add(t1);

         gbc.gridx=0;
	 gbc.gridy=2;
	 gbl.setConstraints(l2,gbc);
	 add(l2);

         gbc.gridx=2;
	 gbc.gridy=2;
	 gbl.setConstraints(l3,gbc);
	 add(l3);

         gbc.gridx=0;
	 gbc.gridy=4;
	 gbl.setConstraints(b1,gbc);
	 add(b1);

         gbc.gridx=2;
	 gbc.gridy=4;
	 gbl.setConstraints(b2,gbc);
	 add(b2);

         b1.addActionListener(this);
	 b2.addActionListener(this);
         addWindowListener(new TU());
 }
        public void actionPerformed(ActionEvent ae)
	{
        
        if(ae.getSource()==b2)
	{
         t1.setText("");
        }
         
       
        if(ae.getSource()==b1)
	{
	try
	{   
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection("jdbc:odbc:MyDataSource1");
        
        ps=con.prepareStatement("select FlightNo,TravelDate,Class from Passengers where PNRNo=?");
        String pnrno = t1.getText();
        ps.setInt(1,Integer.parseInt(pnrno));
        rs=ps.executeQuery();
        rs.next();
        
        System.out.println(rs.getString(1)+""+rs.getString(2)+" "+rs.getString(3));          
        
        

        
        

       
  /*      if(rs.getString(3).equals(String.valueOf('F')))
        {
       
        
        ps=con.prepareStatement("update Reservation set FSeats=FSeats+1 where FlightNo=? and TravelDate=?"); 
        ps.setString(1,rs.getString(1));
        ps.setString(2,rs.getString(2));
        count=ps.executeUpdate();
        
        }  

      if(rs.getString(3).equals(String.valueOf('B')))
        {
        
        
        ps=con.prepareStatement("update Reservation set BSeats=BSeats+1 where FlightNo= ? and TravelDate= ? ");
        ps.setString(1,rs.getString(1));
        ps.setString(2,rs.getString(2));
        count=ps.executeUpdate();
       
        }


       if(rs.getString(3).equals(String.valueOf('E')))
        {
        
       
        ps=con.prepareStatement("update Reservation set ESeats=ESeats+1 where FlightNo=? and TravelDate=?"); 
        ps.setString(1,rs.getString(1));
        ps.setString(2,rs.getString(2));
        count=ps.executeUpdate();
        
        }
        
*/
     
        ps=con.prepareStatement("delete from Passengers where PNRNo=?");
        ps.setInt(1,Integer.parseInt(pnrno));
        count = ps.executeUpdate();  
        con.close();
        t1.setText("");


        }
        
        catch(Exception e)
        {
        System.out.println("Error : "+e);
        }
        
        }

        }
	
        class TU extends WindowAdapter
	{
	public void windowClosing(WindowEvent e)
	{
	setVisible(false);
	dispose();
			
	}
	}

}

