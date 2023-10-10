package Swing1_Frame;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T02_WindowClosing1 extends Frame implements WindowListener {

	public T02_WindowClosing1() {
		//super("스윙연습!!");
		setTitle("스윙연습!!");
		setSize(300, 200);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		T02_WindowClosing1 t1 = new T02_WindowClosing1();
		t1.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) { System.exit(0);}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
