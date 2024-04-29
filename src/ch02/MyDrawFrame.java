package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 패널에 그림을 그리는 방법
 * 자바 문법 - 중첩 클래스 (클래스안 클래스를 만드는것)
 * 외부 클래스, 내부클래스
 */
public class MyDrawFrame extends JFrame {

	MyDrawPanel myDrawPanel;

	public MyDrawFrame() {
		// TODO Auto-generated constructor stub
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부클래스를 활용한 그림 그리는 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}
	
	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);
	}

	// 내부 클래스 만들어 보기
	//
	// paint --> 좌표값으로 x =0 y =0
	// Jpanel 에 있는 기능을 확장해 보자.
	class MyDrawPanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawRect(100, 100, 50, 100);
			g.drawRect(200, 200, 150, 150);
			g.clearRect(250, 300, 300, 300);
		}
	}// end of inner class

}
