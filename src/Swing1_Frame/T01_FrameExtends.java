package Swing1_Frame;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T01_FrameExtends extends Frame {

	public T01_FrameExtends() {
		//super("스윙연습!!");
		setTitle("스윙연습!!");
		setSize(300, 200);
	}
	
	public static void main(String[] args) {
		T01_FrameExtends t1 = new T01_FrameExtends();
		t1.setVisible(true);
	}
}
