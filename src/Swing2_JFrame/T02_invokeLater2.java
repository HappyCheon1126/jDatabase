package Swing2_JFrame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_invokeLater2 extends JFrame {
	
	public T02_invokeLater2() {
		setTitle("스윙 이벤트 큐 연습");
		setSize(300, 200);
		
		System.out.println("22222222222222222");
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		System.out.println("11111111111111111");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T02_invokeLater2 t02 = new T02_invokeLater2();
				t02.setVisible(true);
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		System.out.println("33333333333333333");
		System.out.println(Thread.currentThread().getName());
	}
}
