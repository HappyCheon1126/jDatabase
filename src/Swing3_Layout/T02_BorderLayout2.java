package Swing3_Layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// BorderLayout연습
@SuppressWarnings("serial")
public class T02_BorderLayout2 extends JFrame {
	private JButton btnNorth, btnWest, btnEast;
	private JTextField txtSouth;
	private JTextArea txtaCenter;

	public T02_BorderLayout2() {
		setTitle("BorderLayout 연습2");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.getContentPane().add(getBtnNorth(), BorderLayout.NORTH);
		this.getContentPane().add(getTxtSouth(), BorderLayout.SOUTH);
		this.getContentPane().add(getBtnWest(), BorderLayout.WEST);
		this.getContentPane().add(getBtnEast(), BorderLayout.EAST);
		add(getBtnCenter(), BorderLayout.CENTER);
	}
	
	private JTextArea getBtnCenter() {
		txtaCenter = new JTextArea();
		return txtaCenter;
	}

	private JButton getBtnNorth() {
		btnNorth = new JButton("북쪽");
		return btnNorth;
	}
	
	private JTextField getTxtSouth() {
		txtSouth = new JTextField();
		return txtSouth;
	}
	
	private JButton getBtnWest() {
		btnWest = new JButton("서쪽");
		return btnWest;
	}
	
	private JButton getBtnEast() {
		btnEast = new JButton("동쪽");
		return btnEast;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T02_BorderLayout2 t02 = new T02_BorderLayout2();
				t02.setVisible(true);
			}
		});
	}
}
