package ch06;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame3 extends JFrame {

	private JLabel jPlayer;
	private static int posH;
	private static int posV;
	private final int MOVE_DISTANCE =10;
	private final int PLAYER_WIDTH =100;
	private final int PLAYER_HEIGHT =100;
	

	public MiniGame3() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel("플레이어1");
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		
	}

	private void setInitLayout() {
		// 좌표기반 배치 관리자 변경
		setLayout(null);
		add(jPlayer);
		jPlayer.setLocation(200, 200);
		posH =200;
		posV =200;
		setVisible(true);
		
	}

	private void addEventListener() {
		// jplayer 객체에만 keyListener 동작을 시키고자 한다면
		// 익명 구현 클래스로 keyListener 인터페이스를 재정의 할 수 있다.
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					posV -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					posV += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					posH += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					posH -= MOVE_DISTANCE;
				}
					jPlayer.setLocation(posH,posV);
			}
		});
	
	}

	// 코드테스트
	public static void main(String[] args) {
		new MiniGame3();
	}

}
