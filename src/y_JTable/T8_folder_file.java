package y_JTable;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

@SuppressWarnings("serial")
public class T8_folder_file extends JFrame {

	private JPanel contentPane, pn1, pn2, pn3;
	private JButton btnExit;
	private JTable table;
	private JLabel lblImage;
	private JFileChooser chooser;
	
	@SuppressWarnings("rawtypes")
	private Vector title, vData;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JButton btnUpload;
	private JButton btnDelete;
	
	private Object value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T8_folder_file frame = new T8_folder_file();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T8_folder_file() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 784, 63);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		btnExit = new JButton("종  료");

		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(653, 10, 119, 43);
		pn1.add(btnExit);
		
		btnUpload = new JButton("그림업로드");
		btnUpload.setFont(new Font("굴림", Font.PLAIN, 14));
		btnUpload.setBounds(35, 10, 144, 43);
		pn1.add(btnUpload);
		
		btnDelete = new JButton("삭  제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 16));
		btnDelete.setBounds(191, 10, 119, 43);
		pn1.add(btnDelete);
		
		pn2 = new JPanel();
		pn2.setBounds(0, 63, 784, 435);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		/* JTable 설계 */
		title = new Vector<>();
		title.add("경로/파일명");
		
		// 폴더안의 파일 정보 가져오기.
		getFolderInfor();
		
//		File folder = new File("myImage");
//		File files[] = folder.listFiles();
//		
//		vData = new Vector<>();
//		for(int i=0; i<files.length; i++) {
//			System.out.println("files : " + files[i]);
//			Vector vo = new Vector<>();
//			vo.add(files[i]);
//			vData.add(vo);			
//		}
//		defaultTableModel = new DefaultTableModel(vData, title);
		
		table = new JTable(defaultTableModel);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 0, 235, 435);
		pn2.add(scrollPane);
		
		
		//scrollPane.setViewportView(table);
		
		lblImage = new JLabel("사진이 출력됩니다.");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(259, 10, 513, 415);
		pn2.add(lblImage);
		
		pn3 = new JPanel();
		pn3.setBackground(Color.LIGHT_GRAY);
		pn3.setBounds(0, 498, 784, 63);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		/* ============================================================ */
		
		// table안의 셀을 클릭시..
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				//Object value = table.getValueAt(row, col);
				value = table.getValueAt(row, col);
				lblImage.setIcon(new ImageIcon(value.toString()));
				
				//System.out.println("value : " + value);
				
				// 이미지 크기 조절
				// 이미지의 정보를 읽어서 다시 ImageIcon객체로 변경...
				ImageIcon icon = new ImageIcon(value.toString());
				
				// 이미지의 크기를 조절..하기위해 새롭게 불러와서 Image객체로 만든다.
				Image img = icon.getImage();
				
				// 추출된 이미지의 크기를 조정하여 새로운 Image객체로 생성시켜준다.
				Image updateImg = img.getScaledInstance(700, 550, Image.SCALE_SMOOTH);
				
				// 새로운 Image객체로 ImageIcon객체 생성
				ImageIcon updateIcon = new ImageIcon(updateImg);
				
				lblImage.setIcon(updateIcon);
				
			}
		});
		
		//그림 업로드처리
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser= new JFileChooser(); // 파일 다이얼로그 생성
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", // 파일 이름 창에 출력될 문자열
            "jpg", "gif"); // 파일 필터로 사용되는 확장자. *.jpg. *.gif만 나열됨
				chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정
				
				// 파일 다이얼로그 출력
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
			    JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
				  // 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
				  String filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
				  lblImage.setIcon(new ImageIcon(filePath)); // 파일을 로딩하여 이미지 레이블에 출력한다.
				  //System.out.println("filePath : " + filePath);
				  //pack(); // 이미지의 크기에 맞추어 프레임의 크기 조절(잘 안됨.ㅜㅜ.)
				  
				  // 파일 업로드하기
				  try {
						//URL imgURL = new URL(imageURL);		// URL을 통한 파일 가져오기
				  	File imageFile = new File(filePath);	// 파일시스템에서 가져온 정보로 파일객체 생성하기
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); // 파일명+확장자 구하기
						String extension = filePath.substring(filePath.lastIndexOf(".")+1); // 확장자 구하기
						//System.out.println("fileName : " + fileName);
						
						BufferedImage image = ImageIO.read(imageFile);
						File file = new File("myImage/" + fileName);
						if(!file.exists()) { // 해당 경로의 폴더가 존재하지 않을 경우
							file.mkdirs(); // 해당 경로의 폴더 생성
						}
						
						ImageIO.write(image, extension, file); // image를 file로 업로드
						System.out.println("이미지 업로드 완료!");
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				  // 폴더안의 그림정보 가져오기
				  getFolderInfor();
				  
				}
			}
		});
		
		
		// 선택그림 삭제처리하기
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("value : " + value);
				if(value != null) {
					int ans = JOptionPane.showConfirmDialog(null, "다음파일을 삭제하시겠습니까?\n"+value,"삭제화면", JOptionPane.YES_NO_OPTION);
					if(ans == 0) {
						File file = new File(value.toString());
						file.delete();
						JOptionPane.showMessageDialog(null, "파일을 삭제처리했습니다.");
						lblImage.setIcon(null);
						getFolderInfor();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "파일을 선택해 주세요.");
				}
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}

	// 폴더안의 정보 가져오는 메소드
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void getFolderInfor() {
		File folder = new File("myImage");
		File files[] = folder.listFiles();
		
	  vData = new Vector<>();
	  //System.out.println("vData : " + vData.size());
	  if(files.length != 0) {
			for(int i=0; i<files.length; i++) {
				System.out.println("files : " + files[i]);
				Vector vo = new Vector<>();
				vo.add(files[i]);
				vData.add(vo);			
			}
			defaultTableModel.setDataVector(vData, title);
	  }
	}
}
