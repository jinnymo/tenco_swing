package bubble.test.ex04;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubleFrame() {
		// TODO Auto-generated constructor stub
		initDat();
		setInitLayout();
		addEventListener();
		
		//백그라운드 서비스 시작
		
		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initDat() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame rootpanal
		setContentPane(backgroundMap);
		setSize(1000, 640);

		player = new Player();
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);// jframe 모니터 가운데 자동 배치
		setVisible(true);

		add(player);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					//왼쪽 누르고 있다면 
					//key 이벤트가 계속 <-<-<-<- 
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
					if(!player.isUp()) {
						player.up();
					}
					
					break;
				case KeyEvent.VK_DOWN:
					//if(!player.isUp()) {
					//	player.up();
					//}
					
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
					player.setRight(false)
					;
					break;
				case KeyEvent.VK_UP:
					player.setUp(false)
					;
					break;
				default:
					break;
				}
			}
		});

	}

	public static void main(String[] args) {
		new BubleFrame();
	}
}
