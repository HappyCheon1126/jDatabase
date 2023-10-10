package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T1_Closing1 extends Frame implements WindowListener, ActionListener {
	Button btnExit;

	public T1_Closing1() {
		super("어뎁터 활용");
		this.setBounds(300, 250, 300, 350);
		
		btnExit = new Button("종 료");
		this.add(btnExit);
		
		this.setVisible(true);
		
		////////////////////////////////////////////////
		
		btnExit.addActionListener(this);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T1_Closing1();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
