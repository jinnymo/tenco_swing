package ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	private JLabel backgroundMap,player;

	public MyFrame() {

		initData();
		setInitLayout();

		// TODO Auto-generated constructor stub

	}

	private void initData() {
		setTitle("JLable을 활용한 이미지 사용 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		Icon icon = new ImageIcon("images/background1.jpg");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(icon.getIconWidth(),icon.getIconHeight());
		//backgroundMap.setLocation(0,0);
		setSize(icon.getIconWidth(),icon.getIconHeight());
		
		
		player = new JLabel(new ImageIcon("images/image3.png"));
		
		
		player.setSize(player.getIcon().getIconWidth(),player.getIcon().getIconHeight());
		player.setLocation(10,100);
	}

	private void setInitLayout() {
		//좌표값으로 세팅 하기 위해서는 배치 관리자를 null값으로 만들어 주어야 한다.
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);
	}

}
