package Swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
  - CardLayout 사용법
  카드레이아웃 제어 메소드 : first(), last(), next(), show()
  first() : 첫번째 카드 보이기
  last() : 마지막 카드 보이기
  next() : 다음 카드 보이기
  show() : 지정된카드보이기 카드 보이기
*/
@SuppressWarnings("serial")
public class T04_CardLayout3 extends JFrame {
	private JButton btn1, btn2, btn3, btn4;
	
	public T04_CardLayout3() {
		setTitle("CardLayout연습3");
		setSize(250, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		CardLayout card = new CardLayout();
		setLayout(card);
		
		btn1 = new JButton("봄");
		btn2 = new JButton("여름");
		btn3 = new JButton("가을");
		btn4 = new JButton("겨울");
		
		btn1.setBackground(Color.GREEN);
		btn2.setBackground(Color.BLUE);
		btn3.setBackground(Color.RED);
		btn4.setBackground(Color.GRAY);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		/* ----------------------------------- */
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout3 t04 = new T04_CardLayout3();
				t04.setVisible(true);
			}
		});
	}
}
