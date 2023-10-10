package Windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class T01 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMid, txtName, txtSosok;
	private JButton btnInput, btnReset, btnClose;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T01 frame = new T01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T01() {
		setTitle("스윙연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 창");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(76, 27, 591, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(103, 126, 120, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(103, 225, 120, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("성명");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(103, 320, 120, 40);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("소속");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(103, 399, 120, 40);
		contentPane.add(lblNewLabel_1_3);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.PLAIN, 18));
		txtMid.setBounds(277, 126, 313, 40);
		contentPane.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 18));
		txtName.setColumns(10);
		txtName.setBounds(277, 320, 313, 40);
		contentPane.add(txtName);
		
		txtSosok = new JTextField();
		txtSosok.setFont(new Font("굴림", Font.PLAIN, 18));
		txtSosok.setColumns(10);
		txtSosok.setBounds(277, 399, 313, 40);
		contentPane.add(txtSosok);
		
		// 회원가입버튼
		btnInput = new JButton("회원가입");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				str += "아이디 : " + txtMid.getText() + "\n";
				str += "비밀번호 : " + txtPwd.getText() + "\n";
				str += "성 명 : " + txtName.getText() + "\n";
				str += "소 속 : " + txtSosok.getText();
				
				JOptionPane.showMessageDialog(null, str);
			}
		});
		btnInput.setFont(new Font("굴림", Font.PLAIN, 18));
		btnInput.setBounds(103, 488, 150, 40);
		contentPane.add(btnInput);
		
		// 리셋버튼
		btnReset = new JButton("다시입력");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtSosok.setText("");
			}
		});
		btnReset.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReset.setBounds(336, 488, 150, 40);
		contentPane.add(btnReset);
		
		
		// 창닫기 버튼
		btnClose = new JButton("창닫기");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("굴림", Font.PLAIN, 18));
		btnClose.setBounds(548, 488, 150, 40);
		contentPane.add(btnClose);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("굴림", Font.PLAIN, 18));
		txtPwd.setBounds(277, 225, 313, 40);
		contentPane.add(txtPwd);
	}
}
