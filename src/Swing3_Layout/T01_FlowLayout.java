package Swing3_Layout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_FlowLayout extends JFrame {
	private JButton btnOk, btnExit, btnAnswer1, btnAnswer2, btnAnswer3, btnInput;
	private JLabel lblName;
	
	public T01_FlowLayout() {
		setTitle("FlowLayout연습");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 프레임 창 닫기
		setLocationRelativeTo(null);	// 프레임을 가운데 정렬하기
		setResizable(false);					// 프레임의 크기 고정
		
		setLayout(new FlowLayout());
		//this.getContentPane().add(getBtnOk());
		add(getBtnOk());
		add(getBtnExit());
		add(getBtnAnswer1());
		add(getBtnAnswer2());
		add(getBtnAnswer3());
		add(getBtnInput());
		
		add(getLblName());
		
		
		/* -------------------------------------------------- */
		
		btnInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("성명을 입력하세요", "성명을 입력란...");
				JOptionPane.showMessageDialog(null, "성명 : " + name);
				lblName.setText("성명 : " + name);
				System.out.println("name : " + name);
			}
		});
		
		
		btnAnswer3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 옵션이 'YES_NO_CANCEL_OPTION'인 경우는 '예(0)/아니오(1)/취소(2)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?","선택박스",JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans == 0) JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.","확인창",JOptionPane.INFORMATION_MESSAGE);
				else if(ans == 1) {
					JOptionPane.showMessageDialog(null, "작업을 마치겠습니다.","종료",JOptionPane.WARNING_MESSAGE);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "취소합니다.","취소창",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btnAnswer2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 옵션이 'YES_NO_OPTION'인 경우는 '예(0)/아니오(1)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?","선택박스",JOptionPane.YES_NO_OPTION);
				if(ans == 0) JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.","확인창",JOptionPane.INFORMATION_MESSAGE);
				else {
					JOptionPane.showMessageDialog(null, "작업을 마치겠습니다.","취소창",JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});
		
		btnAnswer1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 옵션이 'OK_CANCEL_OPTION'인 경우는 '확인(0)/취소(2)' 값을 반환한다.
				int ans = JOptionPane.showConfirmDialog(null, "버튼을 선택하세요?","선택박스",JOptionPane.OK_CANCEL_OPTION);
				if(ans == 0) JOptionPane.showMessageDialog(null, "확인버튼을 누르셨습니다.","확인창",JOptionPane.INFORMATION_MESSAGE);
				else JOptionPane.showMessageDialog(null, "추소버튼을 누르셨습니다.","취소창",JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "확인버튼을 누르셨습니다.","확인창",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "작업을 종료합니다.");
				//JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null, "작업을 종료합니다.", "종료창", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		});
	}
	
	private JLabel getLblName() {
		lblName = new JLabel();
		return lblName;
	}

	private JButton getBtnInput() {
		btnInput = new JButton("입력");
		return btnInput;
	}

	private JButton getBtnAnswer1() {
		btnAnswer1 = new JButton("선택1");
		return btnAnswer1;
	}
	
	private JButton getBtnAnswer2() {
		btnAnswer2 = new JButton("선택2");
		return btnAnswer2;
	}
	
	private JButton getBtnAnswer3() {
		btnAnswer3 = new JButton("선택3");
		return btnAnswer3;
	}

	private JButton getBtnExit() {
		btnExit = new JButton("종료");
		return btnExit;
	}

	private JButton getBtnOk() {
		if(btnOk == null) {
			//btnOk = new JButton("확인");
			btnOk = new JButton();
			btnOk.setText("확인");
		}
		
		return btnOk;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T01_FlowLayout t01 = new T01_FlowLayout();
				t01.setVisible(true);
			}
		});
	}
}
