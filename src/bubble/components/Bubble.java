
package bubble.components;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bubble.test.ex01.Player;

public class Bubble extends JLabel implements Moveable {

	private bubble.test.ex10.Player player;
	private Enemy enemy;
	private BubleFrame mContext;

	private BackgroundBubbleService backgroundBubbleService;
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
	static int countt;

	// getset

	public Bubble(BubleFrame mContext) {
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		this.enemy = mContext.getEnemy();
		initData();
		setInitLayout();

	}

	public bubble.test.ex10.Player getPlayer() {
		return player;
	}

	public void setPlayer(bubble.test.ex10.Player player) {
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
		backgroundBubbleService = new BackgroundBubbleService(this);
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

// 공통으로 사용하는 부분을 메서드로 만들어 보자
	// 이 메서드는 내부에서만 사용할 예정
	@Override
	public void left() {
		left = true;
		setIcon(bubble);
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			if (backgroundBubbleService.leftWall()) {
				break;
			}

			int absXResult = Math.abs(x - mContext.getEnemy().getX());
			int absYResult = Math.abs(y - mContext.getEnemy().getY());

			if (absXResult < 10 && absYResult < 50) {
				if (enemy.getState() == 0) {
					crash();
				}
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		up();
	}

	@Override
	public void right() {
		right = true;

		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if (backgroundBubbleService.rightWall()) {
				break;
			}
			int absXResult = Math.abs(x - mContext.getEnemy().getX());
			int absYResult = Math.abs(y - mContext.getEnemy().getY());

			if (absXResult < 10 && absYResult < 50) {
				if (enemy.getState() == 0) {
					crash();
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		up();

	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);

			if (backgroundBubbleService.topWall()) {

				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		clearBubble();
	}

	private void clearBubble() {

		try {
			Thread.sleep(1000);
			setIcon(bomb);
			Thread.sleep(180);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIcon(null);
		setVisible(false);
		mContext.remove(this);

		// player.removeAll();

	}

	public void crash() {
		// 적군이 살아 있는 상태에서 //버블에 갇힌 상태로 변경
		// 버블에 이미지를 변결처리 bubbled//
		enemy.setIcon(null);
		enemy.setState(1);
		enemy.setVisible(false);
		mContext.remove(enemy);
		mContext.repaint();
		setIcon(bubbled);

	}
}