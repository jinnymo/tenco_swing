package bubble.test.ex09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubleFrame extends JFrame {
	//컨텍스트 생성하는 방법(셀프참조);
	BubleFrame mContext = this;
	private JLabel backgroundMap;
	private Player player;
	private Bubble bubble;

	public BubleFrame() {
		// TODO Auto-generated constructor stub
		initDat();
		setInitLayout();
		addEventListener();

		// 백그라운드 서비스 시작

		new Thread(new BackgroundPlayerService(player)).start();
	}
	

	private void initDat() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame rootpanal
		setContentPane(backgroundMap);
		setSize(1000, 640);


		player = new Player(mContext);

	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);// jframe 모니터 가운데 자동 배치
		setVisible(true);

		add(player);
		// add(bubble);
	}


	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 왼쪽 누르고 있다면
					// key 이벤트가 계속 <-<-<-<-
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp()) {
						player.up();
					}

					break;
				case KeyEvent.VK_DOWN:
					// if(!player.isUp()) {
					// player.up();
					// }

					break;
				case KeyEvent.VK_SPACE:
					player.attack();

					break;
				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				default:
					break;
				}
			}
		});

	}
	public Player getPlayer() {
		return player;
	}

	public static void main(String[] args) {
		//메인함수를 가지고 있는 클래스는 하위에 생선된 모든 객체들에 
		//주소값을 알고 있다.(중요!)
		new BubleFrame();
	}
}
