import java.awt.*;
import java.awt.event.*;

public class Reservation extends Frame implements ActionListener 
{
	Button b1,b2,b3;
	Label l1,l2;
	GridBagLayout gbl;
	GridBagConstraints gbc; 
	Font f;
	Reservation()
	{
		setBackground(Color.cyan);
		f = new Font("TimesRoman",Font.BOLD,20);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		setLayout(gbl);
		b1=new Button("Check Availability");
		b1.setFont(f);
		b2=new Button(" Create Passenger ");
		b2.setFont(f);
       //        b3=new Button(" Fare Teller ");
	//	b3.setFont(f);

		l1= new Label("");
                l2= new Label("");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(b1,gbc);
		add(b1);

		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(l1,gbc);
		add(l1);

		gbc.gridx=0;
		gbc.gridy=8;
		gbl.setConstraints(b2,gbc);
		add(b2);

       /*         gbc.gridx=0;
		gbc.gridy=12;
		gbl.setConstraints(l2,gbc);
		add(l2);

                gbc.gridx=0;
		gbc.gridy=16;
		gbl.setConstraints(b3,gbc);
		add(b3);

*/

                b1.addActionListener(this);
		b2.addActionListener(this);
         //       b3.addActionListener(this);
		addWindowListener(new W());
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			
			Check m = new Check();
			//setVisible(false);
			m.setSize(400,400);
			m.setVisible(true);
			m.setTitle("Check Availability Screen");
		}
		if(ae.getSource()==b2)
		{
			
			Create v = new Create();
			//setVisible(false);
			v.setSize(400,500);
			v.setVisible(true);
			v.setTitle("Create Passenger Screen");
		}
                
        /*         if(ae.getSource()==b3)
		{
			
			Fare f = new Fare();
			//setVisible(false);
			f.setSize(400,500);
			f.setVisible(true);
			f.setTitle("Fare Teller Screen");
		
                }

       */


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
