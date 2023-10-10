package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow5 extends JWindow {
	JLabel lblImg;

	public T04_JWindow5() {
		setSize(600, 350);
		
		//lblImg = new JLabel("안녕하세요.");
		//lblImg = new JLabel("안녕하세요.");
		//add(lblImg);
		
		lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
		add(lblImg);
		
		setLocationRelativeTo(null);	// 화면 가운데 view(window) 배치하기
	
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.exit(0);
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow5 t05 = new T04_JWindow5();
				t05.setVisible(true);
			}
		});
	}

}
