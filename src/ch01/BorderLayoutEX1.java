package ch01;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEX1 extends JFrame {

	final int WIDTH =600;
	final int HEIGHT = 600;
	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	// 생성자 만들기
	public BorderLayoutEX1() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("boredeLayout practice");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttons = new JButton[directions.length];
	}

	public void setInitLayout() {
		// 배치관리자 선정(컨테이너)
		// borderlayout --> 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃
		setLayout(new BorderLayout());

		for (int i = 0; i < buttons.length; i++) {
			add(buttons[i] = new JButton(directions[i]), directions[i]);
		}

	}

	public static void main(String[] args) {
		new BorderLayoutEX1();
	}

}
