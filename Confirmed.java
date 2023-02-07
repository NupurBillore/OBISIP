import java.awt.*;
import java.awt.event.*;

public class Confirmed extends Frame 
{         
	Confirmed()
    {
		addWindowListener(new W());
	}
	class W extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			//dispose();
			System.exit(0);
			
		}
	}
}