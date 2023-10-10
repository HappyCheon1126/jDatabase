package SwingEx1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_CardLayout1 extends JFrame {
	private JPanel pnCenter,pnSouth;
	private JButton btn1,btn2,btn3,btn4;
	private JLabel lbl1,lbl2,lbl3,lbl4;
	
	public T01_CardLayout1() {
		setTitle("카드레이아웃연습");
		setSize(300, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		lbl1 = new JLabel();
		lbl2 = new JLabel();
		lbl3 = new JLabel();
		lbl4 = new JLabel();
		
		lbl1.setIcon(new ImageIcon("./images/11.jpg"));
		lbl2.setIcon(new ImageIcon("./images/12.jpg"));
		lbl3.setIcon(new ImageIcon("./images/13.jpg"));
		lbl4.setIcon(new ImageIcon("./images/14.jpg"));
		//lbl4.setIcon(new ImageIcon(getClass().getResource("./images/14.jpg")));
		
		pnCenter = new JPanel();
		pnCenter.add(lbl1);
		pnCenter.add(lbl2);
		pnCenter.add(lbl3);
		pnCenter.add(lbl4);
		
		pnSouth = new JPanel();
		
		btn1 = new JButton("봄");
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");
		pnSouth.add(btn1);
		pnSouth.add(btn2);
		pnSouth.add(btn3);
		pnSouth.add(btn4);
		
		add(pnCenter,BorderLayout.CENTER);
		add(pnSouth, BorderLayout.SOUTH);
		
		/* ==================================== */
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(true);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(true);
				lbl3.setVisible(false);
				lbl4.setVisible(false);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(true);
				lbl4.setVisible(false);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lbl1.setVisible(false);
				lbl2.setVisible(false);
				lbl3.setVisible(false);
				lbl4.setVisible(true);
			}
		});
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T01_CardLayout1 t01 = new T01_CardLayout1();
				t01.setVisible(true);
			}
		});
	}
}
