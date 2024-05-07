package bubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;
	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean spaceKey;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean blueWallCrash;

	private boolean lastStandingAreaRed;
	private BubleFrame mContext;

	PlayerWay playerWay;

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

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean islastStandingAreaRed() {
		return lastStandingAreaRed;
	}

	public void setlastStandingAreaRed(boolean lastStandingAreaRed) {
		this.lastStandingAreaRed = lastStandingAreaRed;
	}

	public boolean isblueWallCrash() {
		return blueWallCrash;
	}

	public void setbluetWallCrash(boolean blueWallCrash) {
		this.blueWallCrash = blueWallCrash;
	}

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

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isUp() {
		return up;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	// setter
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	public Player(BubleFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
		
	}

	private void initData() {

		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행시 초기값 셋팅
		x = 355;
		y = 536;
		// 플레이어 가만히 멈춘 상태
		left = false;
		right = false;
		up = false;
		down = false;

		playerWay = PlayerWay.RIGHT;

		leftWallCrash = false;
		rightWallCrash = false;
		blueWallCrash = false;
		lastStandingAreaRed = true;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		playerWay = PlayerWay.LEFT;
		left = true;
		setIcon(playerL);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	@Override
	public void right() {
		playerWay = PlayerWay.RIGHT;
		right = true;
		setIcon(playerR);
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	@Override
	public void up() {
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 70; i++) {
					y -= JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				blueWallCrash = false;
				down();
			}
		}).start();

	}

	@Override
	public void down() {
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				int x = 70;
				for (int i = 0; i < x; i++) {
					if (blueWallCrash) {
						blueWallCrash = false;
						lastStandingAreaRed = false;
						return;
					}
					if (!blueWallCrash) {
						if (islastStandingAreaRed()) {
							y = 536;
							return;
						}
						x++;
					}

					y += JUMPSPEED;
					setLocation(x, y);
					try {

						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				blueWallCrash = false;

			}
		}).start();
		down = false;
	}

	public void attack() {
		
		//람다 표현식
		new Thread(() -> {
			Bubble bubble = new Bubble(mContext);
			mContext.add(bubble);
			if (playerWay == PlayerWay.LEFT) {
				bubble.left();
				
			} else {
				bubble.right();
			}
		}).start();
	}
}
