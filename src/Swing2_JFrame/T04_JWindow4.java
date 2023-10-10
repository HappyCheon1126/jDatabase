package Swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow4 extends JWindow {
	JButton exitBtn;

	public T04_JWindow4() {
		setSize(600, 350);
		
		exitBtn = new JButton("종료");
		add(exitBtn);
		
		// JWindow를 화면 중앙에 띄우기
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Point centerPoint = ge.getCenterPoint();
//		int leftTopX = centerPoint.x - this.getWidth()/2;
//		int leftTopY = centerPoint.y - this.getHeight()/2;
//		setLocation(leftTopX, leftTopY);	

		setLocationRelativeTo(null);	// 화면 가운데 view(window) 배치하기
	
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_JWindow4 t04 = new T04_JWindow4();
				t04.setVisible(true);
			}
		});
	}

}
