package SwingEx1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_Tabbed extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel pnTab1, pnTab2;
	
	public T03_Tabbed() {
		setTitle("TabButton연습");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(getTabbedPane(), BorderLayout.CENTER);
	}
	
	private JTabbedPane getTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.addTab("탭1", getPnTab1());
		tabbedPane.addTab("탭2", getPnTab2());
		return tabbedPane;
	}

	// 첫번째 탭설정...
	private JPanel getPnTab1() {
		pnTab1 = new JPanel();
		JLabel lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/11.jpg")));
		pnTab1.add(lblImg);
		return pnTab1;
	}

	// 두번째 탭설정...
	private JPanel getPnTab2() {
		pnTab2 = new JPanel();
		JLabel lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/12.jpg")));
		pnTab2.add(lblImg);
		return pnTab2;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_Tabbed t03 = new T03_Tabbed();
				t03.setVisible(true);
			}
		});
	}
}
