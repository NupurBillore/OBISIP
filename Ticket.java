import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Ticket extends Frame implements ActionListener  
{       

        TextField t1;
        Label l1;
        Button b1;
        GridBagLayout gbl;
	GridBagConstraints gbc; 
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	int count;
	Font f;
	
	
	Ticket()
	{

        setBackground(Color.red);
        t1 = new TextField(20);
        l1 = new Label("PNR NO ");
        l1.setFont(f);
        
        

	gbc.gridx=0;
	gbc.gridy=0;
	gbl.setConstraints(l1,gbc);
	add(l1);
        
        
        
	gbc.gridx=0;
	gbc.gridy=2;
	gbl.setConstraints(t1,gbc);
	add(t1);
       
        
    addWindowListener(new W());

	}
	public void actionPerformed(ActionEvent ae)
	{
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

		Ticket t = new Ticket();
		t.setSize(400,500);
		t.setVisible(true);
		t.setTitle("Ticket Screen");


	}



}
