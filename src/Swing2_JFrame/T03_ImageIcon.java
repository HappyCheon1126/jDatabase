package Swing2_JFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_ImageIcon extends JFrame {

	public T03_ImageIcon() {
		setTitle("창제목");
		setSize(600, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setIconImage(new ImageIcon(getClass().getResource("./images/1.jpg")).getImage());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_ImageIcon t03 = new T03_ImageIcon();
				t03.setVisible(true);
			}
		});
	}
}
