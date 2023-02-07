import java.awt.*;
import java.awt.event.*;

public class Change extends Frame 
{
	Label l1,l2;
	TextField t1,t2;
	GridLayout g;
	Button b1,b2;
	Change()
	{
	g = new GridLayout(3,2,20,40);
	setLayout(g);
    l1 = new Label("Username",Label.CENTER);
	l2 = new Label("Password",Label.CENTER);
	t1 = new TextField(20);
	t2 = new TextField(20);
    t2.setEchoChar('*'); 
	b1 = new Button("Submit");
	b2 = new Button("Close");
	b2.addActionListener(new W());
	addWindowListener(new L());
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(b1);
	add(b2);
	
    }
	class W implements ActionListener
	{

		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b2)
			{
				dispose();
				
			}
			
		}
	}
	class L extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			//dispose();
			System.exit(0);
			
		}
	}


	public Insets getInsets()
	{
		return new Insets(40,40,40,40);
	}
	public static void main(String args[])
	 {
	 Change m = new Change();
	 m.setTitle("Change Login Details");
	 m.setSize(400,300);
	 m.setVisible(true);
     }
     }



