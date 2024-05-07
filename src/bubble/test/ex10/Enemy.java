package bubble.test.ex10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Moveable {

	BubleFrame mContext;
	
	private int state;//0= 살아있는 //1= 물방울 같힌 상태
	
	private int x;
	private int y;
	private ImageIcon enemyR, enemyL;
	// 움직임의 상태

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	EnemyWay enemyWay;

	public Enemy(BubleFrame mContext) {
		initData();
		setInitLayout();
		this.mContext = mContext;
		mContext.add(this);
	//	left();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	private void initData() {

		enemyR = new ImageIcon("img/enemyR.png");
		enemyL = new ImageIcon("img/enemyL.png");
		state = 0;
		// 처음 실행시 초기값 셋팅
		x = 720;
		y = 175;
		// 플레이어 가만히 멈춘 상태
		left = false;
		right = false;
		up = false;
		down = false;

		enemyWay = EnemyWay.LEFT;

	}

	private void setInitLayout() {
		setIcon(enemyL);
		setSize(50, 50);
		setLocation(x, y);

	}

	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;
		left = true;
		setIcon(enemyL);

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
		enemyWay = enemyWay.RIGHT;
		right = true;
		setIcon(enemyR);
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
	}

	@Override
	public void down() {
	}

}
