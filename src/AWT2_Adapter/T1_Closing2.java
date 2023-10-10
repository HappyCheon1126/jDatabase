package AWT2_Adapter;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class T1_Closing2 extends Frame {
	Button btnExit;

	public T1_Closing2() {
		super("어뎁터 활용");
		this.setBounds(300, 250, 300, 350);
		
		btnExit = new Button("종 료");
		this.add(btnExit);
		
		this.setVisible(true);
		
		////////////////////////////////////////////////
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new T1_Closing2();
	}

	
}
