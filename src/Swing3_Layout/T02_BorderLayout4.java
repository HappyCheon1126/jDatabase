package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class T02_BorderLayout4 extends JFrame {
	private JButton btn1,btn2,btnExit;
	private JPanel pn1;
	
	public T02_BorderLayout4() {
		setTitle("BorderLayout연습");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		btn1 = new JButton("안녕하세요");
		add(btn1, BorderLayout.NORTH);
		
		
		btn2 = new JButton("버튼2");
		btnExit = new JButton("종료");
		
		pn1 = new JPanel();
		
		
		pn1.setLayout(new GridLayout(1,2));
		pn1.add(btn2);
		pn1.add(btnExit);
		
		//add(pn1);
		add(pn1, BorderLayout.SOUTH);
		
		/* ---------------------------------------------- */
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "안녕버튼을 누르셨습니다.");
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T02_BorderLayout4 t02 = new T02_BorderLayout4();
				t02.setVisible(true);
			}
		});
	}
}
