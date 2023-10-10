package Swing2_JFrame;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T01_JFrame extends JFrame {

	public T01_JFrame() {
		setTitle("스윙연습2");
		setBounds(300, 250, 300, 150);
	}
	
	public static void main(String[] args) {
		T01_JFrame t1 = new T01_JFrame();
		t1.setVisible(true);
	}
}
