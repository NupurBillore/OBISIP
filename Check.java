import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Check extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	TextField t1,t2,t3,t4,t5;
        Choice c;
	Button b1,b2;
	GridBagLayout gbl;
	GridBagConstraints gbc; 
        Connection con;
        PreparedStatement ps;
        Statement stmt;
	ResultSet rs;
	int count;
	Font f;
	
        Check()
	{
		setBackground(Color.red);
		f = new Font("TimesRoman",Font.BOLD,20);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		setLayout(gbl);
		l1 = new Label("");
		l4 = new Label("");
		l5 = new Label("");
		l6 = new Label("");
		l7 = new Label("");
		l2 = new Label("Travel Date");
		l2.setFont(f);
		l3 = new Label("Compartment No.");
		l3.setFont(f);
		l8 = new Label("First AC Sleeper Class ");
		l8.setFont(f);
		l9 = new Label("AC Chair car class");
		l9.setFont(f);
		l10 = new Label("Third AC Sleeper ");
		l10.setFont(f);
		l11 = new Label("");
		l12 = new Label("");
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		c = new Choice();
		b1 = new Button("Submit");
		b2 = new Button("Reset");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(l1,gbc);
		add(l1);
        
		c.add("DL - BGR : SA101");
		c.add("BGR - DL : SA102");
		c.add("DL - BY  : SA201");
		c.add("BY - DL  : SA202");
		c.add("DL - KLA : SA301");
		c.add("KLA - DL : SA302");
		c.add("DL - CHN : SA401");
		c.add("CHN - DL : SA402");
		c.add("DL - HYD : SA501");
		c.add("HYD - DL : SA502");
		c.add("DL - PUN : SA601");
		c.add("PUN - DL : SA602");
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbl.setConstraints(c,gbc);
		add(c);

		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(l4,gbc);
		add(l4);
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbl.setConstraints(l5,gbc);
		add(l5);
		
		
		
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(l2,gbc);
		add(l2);
		
		gbc.gridx=2;
		gbc.gridy=4;
		gbl.setConstraints(t1,gbc);
		add(t1);
        
		gbc.gridx=0;
		gbc.gridy=6;
		gbl.setConstraints(l3,gbc);
		add(l3);

		gbc.gridx=2;
		gbc.gridy=6;
		gbl.setConstraints(t2,gbc);
		add(t2);
		
		gbc.gridx=0;
		gbc.gridy=8;
		gbl.setConstraints(l6,gbc);
		add(l6);

		gbc.gridx=2;
		gbc.gridy=8;
		gbl.setConstraints(l7,gbc);
		add(l7);

		
		
		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(b1,gbc);
		add(b1);

		gbc.gridx=2;
		gbc.gridy=10;
		gbl.setConstraints(b2,gbc);
		add(b2);
        
		gbc.gridx=0;
		gbc.gridy=12;
		gbl.setConstraints(l11,gbc);
		add(l11);
        
		gbc.gridx=2;
		gbc.gridy=12;
		gbl.setConstraints(l12,gbc);
		add(l12);
        
		gbc.gridx=0;
		gbc.gridy=14;
		gbl.setConstraints(l8,gbc);
		add(l8);

		gbc.gridx=2;
		gbc.gridy=14;
		gbl.setConstraints(t3,gbc);
		add(t3);
         
		gbc.gridx=0;
		gbc.gridy=16;
		gbl.setConstraints(l9,gbc);
		add(l9);
		
		gbc.gridx=2;
		gbc.gridy=16;
		gbl.setConstraints(t4,gbc);
		add(t4);

		gbc.gridx=0;
		gbc.gridy=18;
		gbl.setConstraints(l10,gbc);
		add(l10);

		gbc.gridx=2;
		gbc.gridy=18;
		gbl.setConstraints(t5,gbc);
		add(t5);
		b1.addActionListener(this);
		b2.addActionListener(this);
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
				ps=con.prepareStatement("Select * from Reservation where TravelDate=? and Compartment No=?");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				rs=ps.executeQuery();
				rs.next();
				t3.setText(Integer.toString(rs.getInt(3)));
				t4.setText(Integer.toString(rs.getInt(4)));
		        t5.setText(Integer.toString(rs.getInt(5)));
                                con.close();
			}
			catch(Exception e)
			{
				System.out.println("2 Error : "+e);
			}
		}

		if(ae.getSource()==b2)
		{
                t1.setText("");
		t2.setText("");
	        t3.setText("");
		t4.setText("");
		t5.setText("");
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
}

