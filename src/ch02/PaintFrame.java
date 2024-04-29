package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch02.MyDrawFrame.MyDrawPanel;

public class PaintFrame extends JFrame{

	
	MyDrawPanel myDrawPanel;

	public PaintFrame() {
		// TODO Auto-generated constructor stub
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부클래스를 활용한 그림 그리는 연습");
		setSize(1000, 1000);
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
			g.drawRect(250, 350, 500, 500);
			g.drawRect(400, 700, 80, 150);
			g.drawOval(420, 780, 10, 10);
			g.drawRect(300, 500, 120, 120);
			g.drawRect(355, 500, 10, 120);
			g.drawRect(300, 555, 120, 10);
			g.drawRect(600, 500, 120, 120);
			g.drawRect(655, 500, 10, 120);
			g.drawRect(600, 555, 120, 10);
			g.drawLine(100, 350, 500, 100);
			g.drawLine(900, 350, 500, 100);
			g.drawLine(100, 350, 900, 350);
			
		}
	}// end of inner class
}
