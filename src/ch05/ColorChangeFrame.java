package ch05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ColorChangeFrame extends JFrame implements ActionListener{

	//이벤트 리스너에 대한 개념을 이해하자.
	private JButton button1,button2;
	
	public ColorChangeFrame() {
		// TODO Auto-generated constructor stub
		initData();
		setInitLayout();
		addEventListner();
	}
	
	private void initData() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		
	
	}
	private void setInitLayout() {
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		setVisible(true);
	}
	private void addEventListner() {
		//button이 눌러지는지 계속 지켜보는중
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	
	//이벤트가 발생되면 이 메서드를 수행해 약속 되어어있음
	//
	
	public static void main(String[] args) {
		new ColorChangeFrame();
	}
	
	//추상메서드 오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("button1")) {
			System.out.println("11111actiionPerformed 메서드 호출()" );
		}else if(e.getActionCommand().equals("button2")) {
			System.out.println("2222actiionPerformed 메서드 호출()" );
			setBackground(Color.blue);
		}
	}
	
}
