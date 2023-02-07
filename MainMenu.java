import java.awt.*;
import java.awt.event.*;

public class MainMenu extends Frame implements ActionListener 
{
	MenuBar mbar;
	Menu m1,m2,m3;
	MenuItem m1_1,m1_2,m2_1,m2_2,m2_3,m3_1;
	public MainMenu()
	{
		
		mbar = new MenuBar();
		setMenuBar(mbar);
		m1=new Menu("Bookings");
		mbar.add(m1);
		m1_1 = new MenuItem("Reservation");
		m1.add(m1_1);
		m1_2 = new MenuItem("Cancellation");
		m1.add(m1_2);
		m2=new Menu("Reports");
		mbar.add(m2);
		m2_1 = new MenuItem("Confirmed Passengers");
		m2.add(m2_1);
		m2_2 = new MenuItem("Waiting");
		m2.add(m2_2);
		m2_3 = new MenuItem("Daily Collection Report");
		m2.add(m2_3);
		m3=new Menu("Close");
		mbar.add(m3);
		m3_1 = new MenuItem("Close");
		m3.add(m3_1);
		m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m2_1.addActionListener(this);
		m2_2.addActionListener(this);
		m2_3.addActionListener(this);
		m3_1.addActionListener(this);
		addWindowListener(new M());
	}
	


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==m1_1)
		{
			Reservation r = new Reservation();
			r.setSize(400,400);
			r.setVisible(true);
			r.setTitle("Reservation Screen");

		}
		if(ae.getSource()==m1_2)
		{
			Cancellation c = new Cancellation();
			c.setSize(400,400);
			c.setVisible(true);
			c.setTitle("Cancellation Screen");

		}
		if(ae.getSource()==m2_1)
		{
			Confirmed cr = new Confirmed();
			cr.setSize(400,400);
			cr.setVisible(true);
			cr.setTitle("Confirmed Passengers List");

		}

		if(ae.getSource()==m2_2)
		{
			Waiting wr = new Waiting();
			wr.setSize(400,400);
			wr.setVisible(true);
			wr.setTitle("Waiting List");

		}

		if(ae.getSource()==m2_3)
		{
			Collection dcr = new Collection();
			dcr.setSize(400,400);
			dcr.setVisible(true);
			dcr.setTitle("Daily Collection Report");

		}
		if(ae.getSource()==m3_1)
		{
			System.exit(0);
             
		}

	}

	public static void main(String args[])
	{
		MainMenu m = new MainMenu();
		m.setTitle("Main Menu");
		m.setSize(400,400);
		m.setVisible(true);


	}

	class M extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			dispose();
			
		}
	}

}

