package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow2 extends JWindow {
	JButton exitBtn;

	public T04_JWindow2() {
		setSize(600, 350);
		
		exitBtn = new JButton("종료");
		add(exitBtn);
		
//		exitBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
		
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				//setVisible(false);
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow2 t04 = new T04_JWindow2();
				t04.setVisible(true);
			}
		});
	}

}
