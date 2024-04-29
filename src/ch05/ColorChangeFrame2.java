package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	// 이벤트 리스너에 대한 개념을 이해하자.
	private JPanel panel;
	private JButton button1, button2;

	public ColorChangeFrame2() {
		// TODO Auto-generated constructor stub
		initData();
		setInitLayout();
		addEventListner();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");

	}

	private void setInitLayout() {
		add(panel, BorderLayout.CENTER);
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		setVisible(true);
	}

	// 이메서드에 책임은 이벤트 리스너만 등록
	private void addEventListner() {
		// button이 눌러지는지 계속 지켜보는중

		button1.addActionListener(this);
		button2.addActionListener(this);

	}

	// 이벤트가 발생되면 이 메서드를 수행해 약속 되어어있음
	//

	public static void main(String[] args) {
		new ColorChangeFrame2();
	}

	// 오버라이드 이베트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.toString());

		if (e.getActionCommand().equals("click1")) {
			System.out.println("11111actiionPerformed 메서드 호출()");
			panel.setBackground(Color.blue);
		} else if (e.getSource().equals(button2)) {
			System.out.println("2222actiionPerformed 메서드 호출()");
			panel.setBackground(Color.black);
		}
	}

}
