import java.awt.*;
import java.awt.event.*;

public class Collection extends Frame 
{
	Collection()
	{
		addWindowListener(new W());
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