
package bubble.test.ex05;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubble.test.ex01.Player;

public class Bubble extends JLabel {

	private bubble.test.ex05.Player player;
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean leftWallCrash;
	private boolean right;
	private boolean rightWallCrash;

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0은 기본 1.적을 가둔 상태 물방울

	private ImageIcon bubble; // 기본
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 터지는 모션

	// getset

	public Bubble(bubble.test.ex05.Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		initData();
		setInitLayout();
	}

	public bubble.test.ex05.Player getPlayer() {
		return player;
	}

	public void setPlayer(bubble.test.ex05.Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	private void initData() {
		// TODO Auto-generated method stub

		bubble = new ImageIcon("img/bubble.png");
		bubbled = new ImageIcon("img/bubbled.png");
		bomb = new ImageIcon("img/bomb.png");
		left = false;
		right = false;
		up = false;

		state = 0;
		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);

		setVisible(true);

	}

	private void setInitLayout() {

	}

	public void spacePress() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// bubble = new Bubble(this);
				System.out.println("sadf");

				for (int i = 0; i < 10; i++) {
					
			
					x += 10;
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setLocation(x, y);
					
				}

			}

		}).start();

	}

}