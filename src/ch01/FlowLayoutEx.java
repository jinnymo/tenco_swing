package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//Swing -> 배치 관리자 : FlowLayout
//컴포넌트들을 (버튼,라벨)등으 수평 , 수직으로 배치를 해주는 클래스이다.
public class FlowLayoutEx extends JFrame {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;

	// 생성자
	public FlowLayoutEx() {
		super.setTitle("FlowLayout practice");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//생성자에서 메서드 호출 가능하다.
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화 하는 기능 (값 넣다)
	public void initData() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		button4 = new JButton("button4");
		button5 = new JButton("button5");
		button6 = new JButton("button6");
		
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		//배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용 된다.
		//배치 관리자 생성 및 JFrame 셋팅
		super.setLayout(new FlowLayout(FlowLayout.LEFT, 50,50));
		
		//컴포넌트들을 붙이다.
		super.add(button1);
		super.add(button2);
		super.add(button3);
		super.add(button4);
		super.add(button5);
		super.add(button6);
	}

	public static void main(String[] args) {
		new FlowLayoutEx();// <--익명 클래스 (주소값이 없다)
		// 다시접근해서 사용할일 없으면 그냥 new 선언만 해도 됨
	}

}
