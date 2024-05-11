package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame3 extends JFrame implements ActionListener {

	// 이벤트 리스너에 대한 개념을 이해하자.
	private JPanel panel, panel2;
	
	private JButton button1, button2, button3, button4, button5;

	public ColorChangeFrame3() {
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
		panel2 = new JPanel();
		panel.setBackground(Color.yellow);
		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button3 = new JButton("click3");
		button4 = new JButton("click4");
		button5 = new JButton("click5");

	}

	private void setInitLayout() {
		add(panel, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		setVisible(true);
	}

	// 이메서드에 책임은 이벤트 리스너만 등록
	private void addEventListner() {
		// button이 눌러지는지 계속 지켜보는중

		button1.addActionListener(this);
		
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);

	}

	// 이벤트가 발생되면 이 메서드를 수행해 약속 되어어있음
	//

	public static void main(String[] args) {
		new ColorChangeFrame3();
	}
	//콜백 메서드이다.
	// 오버라이드 이베트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.toString());

		if (e.getSource().equals(button1)) {
			panel.setBackground(Color.blue);
		} else if (e.getSource().equals(button2)) {
			panel.setBackground(Color.black);
		}else if (e.getSource().equals(button3)) {
			panel.setBackground(Color.cyan);
		}else if (e.getSource().equals(button4)) {
			panel.setBackground(Color.gray);
		}else if (e.getSource().equals(button5)) {
			panel.setBackground(Color.green);
		}
	}

}
