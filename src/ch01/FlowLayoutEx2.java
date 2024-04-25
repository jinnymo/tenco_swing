package ch01;

import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

//Swing -> 배치 관리자 : FlowLayout
//컴포넌트들을 (버튼,라벨)등으 수평 , 수직으로 배치를 해주는 클래스이다.
public class FlowLayoutEx2 extends JFrame {

	private JButton[] arrayB;

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout practice");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능하다.
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화 하는 기능 (값 넣다)
	public void initData() {
		arrayB = new JButton[50];
		for (int i = 0; i < arrayB.length; i++) {
			arrayB[i] = new JButton("button" + i);
			
		}

	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		super.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 50));

		for (int i = 0; i < arrayB.length; i++) {
			super.add(arrayB[i]);
		}
		

	}

	public static void main(String[] args) {
		new FlowLayoutEx2();// <--익명 클래스 (주소값이 없다)
		// 다시접근해서 사용할일 없으면 그냥 new 선언만 해도 됨
	}

}
