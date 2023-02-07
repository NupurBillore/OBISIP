import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Create extends Frame implements ActionListener  
{   
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	Choice c;
	Button b1,b2,b3;
	GridBagLayout gbl;
	GridBagConstraints gbc; 
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font f;
	
	Create()
	{
		setBackground(Color.red);
		f = new Font("TimesRoman",Font.BOLD,20);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		setLayout(gbl);
		
		l15 = new Label("Compartment No");
		l15.setFont(f);
		l1 = new Label("Travel Date");
		l1.setFont(f);
		l2 = new Label("CName");
		l2.setFont(f);
		l3 = new Label("LName");
		l3.setFont(f);
		l4 = new Label("Age");
		l4.setFont(f);
		l5 = new Label("Gender");
		l5.setFont(f);
		l6 = new Label("Address");
		l6.setFont(f);
		l7 = new Label("Phone");
		l7.setFont(f);
		l8= new Label("Class");
		l8.setFont(f);
		l9= new Label("Status");
		l9.setFont(f);
		
		t10 = new TextField(20);
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		t6 = new TextField(20);
		t7 = new TextField(20);
		t8 = new TextField(20);
		t9 = new TextField(20);
		
		c = new Choice();
		
		b1 = new Button("Submit");
		b2 = new Button("Reset");
                b3 = new Button("Generate Ticket");
	   
		l10 = new Label("");
		l11 = new Label("");
		l12 = new Label("");
		l13 = new Label("");
		l14 = new Label("");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(l10,gbc);
		add(l10);
		
		c.add("DL - BGR : HA101");
		c.add("BGR - DL : HA102");
		c.add("DL - BY  : HA201");
		c.add("BY - DL  : HA202");
		c.add("DL - KLA : HA301");
		c.add("KLA - DL : HA302");
		c.add("DL - CHN : HA401");
		c.add("CHN - DL : HA402");
		c.add("DL - HYD : HA501");
		c.add("HYD - DL : HA502");
		c.add("DL - PUN : HA601");
		c.add("PUN - DL : HA602");
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(c,gbc);
		add(c);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(l13,gbc);
		add(l13);

		gbc.gridx=2;
		gbc.gridy=2;
		gbl.setConstraints(l14,gbc);
		add(l14);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(l15,gbc);
		add(l15);

		gbc.gridx=2;
		gbc.gridy=4;
		gbl.setConstraints(t10,gbc);
		add(t10);


		gbc.gridx=0;
		gbc.gridy=6;
		gbl.setConstraints(l1,gbc);
		add(l1);
 
		gbc.gridx=2;
		gbc.gridy=6;
		gbl.setConstraints(t1,gbc);
		add(t1);

		gbc.gridx=0;
		gbc.gridy=8;
		gbl.setConstraints(l2,gbc);
		add(l2);
		
		gbc.gridx=2;
		gbc.gridy=8;
		gbl.setConstraints(t2,gbc);
		add(t2);

		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(l3,gbc);
		add(l3);

		gbc.gridx=2;
		gbc.gridy=10;
		gbl.setConstraints(t3,gbc);
		add(t3);

		gbc.gridx=0;
		gbc.gridy=12;
		gbl.setConstraints(l4,gbc);
		add(l4);

		gbc.gridx=2;
		gbc.gridy=12;
		gbl.setConstraints(t4,gbc);
		add(t4);
		
		gbc.gridx=0;
		gbc.gridy=14;
		gbl.setConstraints(l5,gbc);
		add(l5);

		gbc.gridx=2;
		gbc.gridy=14;
		gbl.setConstraints(t5,gbc);
		add(t5);

		gbc.gridx=0;
		gbc.gridy=16;
		gbl.setConstraints(l6,gbc);
		add(l6);

		gbc.gridx=2;
		gbc.gridy=16;
		gbl.setConstraints(t6,gbc);
		add(t6);

		gbc.gridx=0;
		gbc.gridy=18;
		gbl.setConstraints(l7,gbc);
		add(l7);

		gbc.gridx=2;
		gbc.gridy=18;
		gbl.setConstraints(t7,gbc);
		add(t7);

		gbc.gridx=0;
		gbc.gridy=20;
		gbl.setConstraints(l8,gbc);
		add(l8);

		gbc.gridx=2;
		gbc.gridy=20;
		gbl.setConstraints(t8,gbc);
		add(t8);

		gbc.gridx=0;
		gbc.gridy=22;
		gbl.setConstraints(l9,gbc);
		add(l9);

		gbc.gridx=2;
		gbc.gridy=22;
		gbl.setConstraints(t9,gbc);
		add(t9);

		gbc.gridx=0;
		gbc.gridy=24;
		gbl.setConstraints(l11,gbc);
		add(l11);

		gbc.gridx=2;
		gbc.gridy=24;
		gbl.setConstraints(l12,gbc);
		add(l12);

		gbc.gridx=0;
		gbc.gridy=26;
		gbl.setConstraints(b1,gbc);
		add(b1);

		gbc.gridx=2;
		gbc.gridy=26;
		gbl.setConstraints(b2,gbc);
		add(b2);

                


                
          /*      gbc.gridx=0;
		gbc.gridy=28;
		gbl.setConstraints(l16,gbc);
		add(l16);

                gbc.gridx=2;
		gbc.gridy=28;
		gbl.setConstraints(l17,gbc);
		add(l17);

                gbc.gridx=0;
		gbc.gridy=30;
		gbl.setConstraints(b3,gbc);
		add(b3);

         */
                
                b1.addActionListener(this);
                b2.addActionListener(this);
         //     b3.addActionListener(this); 
		addWindowListener(new W());
        
	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{   
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:MyDataSource1");
				ps=con.prepareStatement("insert into Passengers(Compartment No,TravelDate,CName,LName,Age,Gender,Address,Phone,Class,Status)values(?,?,?,?,?,?,?,?,?,?)");
				
				String age = t4.getText();
				ps.setString(1,t10.getText());
				ps.setString(2,t1.getText());
				ps.setString(3,t2.getText());
				ps.setString(4,t3.getText());
				ps.setInt(5,Integer.parseInt(age));
				ps.setString(6,t5.getText());
				ps.setString(7,t6.getText());
				ps.setString(8,t7.getText());
				ps.setString(9,t8.getText());
				ps.setString(10,t9.getText());
				ps.executeUpdate();
				

				
                                
          if(t8.getText().equals(String.valueOf('F')))
          {   
           String str = "update Reservation set CSeats=CSeats-1 where Compartment No=? and TravelDate = ?";
           ps = con.prepareStatement(str);
           ps.setString(1,t10.getText());
           ps.setString(2,t1.getText());   
          count = ps.executeUpdate();
          }
       if(t8.getText().equals(String.valueOf('B')))
{
	String str = "update Reservation set BSeats=BSeats-1 where FlightNo=? and TravelDate = ?";
	ps = con.prepareStatement(str);
	ps.setString(1,t10.getText());
	ps.setString(2,t1.getText());   
	count = ps.executeUpdate();
}

				if(t8.getText().equals(String.valueOf('E')))
				{
					String str = "update Reservation set ESeats=ESeats-1 where FlightNo=? and TravelDate = ?";
					ps = con.prepareStatement(str);
					ps.setString(1,t10.getText());
					ps.setString(2,t1.getText());   
					count = ps.executeUpdate();
				}


				
				
				
				con.close();
                                t1.setText("");
                                t2.setText("");
                                t3.setText("");
                                t4.setText("");
                                t5.setText("");
                                t6.setText("");
                                t7.setText("");
                                t8.setText("");
                                t9.setText("");
                                t10.setText("");

                               Ticket t = new Ticket();
			      //setVisible(false);
			       t.setSize(400,500);
			       t.setVisible(true);
			       t.setTitle("Ticket Screen");




			}

			catch(SQLException e)
			{
				System.out.println("2 Error : "+e);
			}
			catch(Exception ex)
			{
				System.out.println("Error 1:"+ex);
			}

		}
	
                   if(ae.getSource()==b2)


   {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");



   }

   }





	class W extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			dispose();
			
		}
	}
	public static void main(String args[])
	{

		Create v = new Create();
		v.setSize(400,500);
		v.setVisible(true);
		v.setTitle("Create Passenger Screen");


	}
}


