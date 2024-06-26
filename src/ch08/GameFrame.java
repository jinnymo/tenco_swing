package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;

	int playerX = 150;
	int playerY = 300;
	int enemyX = 250;
	int enemyY = 420;

	boolean enemyMove = true;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 클래스 안 클래스 --> 중첩 클래스 -> 외부클래스, 내부 클래스
	private class ImagePanel extends JPanel implements Runnable {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(player1, playerX, playerY, 50, 50, null);
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);

			// ToDo 플레이어, 적군 그림 그려야함
			// 쓰레드를 활용할 예정

		}

		@Override
		public void run() {
			// true : 왼쪽으로 가는 상황 
			// false : 오른쪽으로 가는 상황
			boolean direction = true;
			while (true) {
				
				
				if (enemyMove) {
					System.out.println("진행중");

					if (direction) {
						enemyX -= 10;
					} else {
						enemyX += 10;
					}
					// 방향 바꾸는 개념은 적군 x 좌표값이
					if (enemyX <= 50) {
						direction = false;
					}
					if (enemyX >= 500) {
						direction = true;
					}

					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
				else {
					System.out.println("대기중");
					//Thread.interrupted();
				}

			}

		}
	}

	private void initData() {
		setTitle("thread 를 활용한 미니 예제");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			// 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerL.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임 시킨다.
		Thread thread = new Thread(imagePanel);
		thread.start();
	}

	private void setInitLayout() {
		// setLayout(null);
		// setResizable(false);//프레임 크기 조절불가 설정
		setVisible(true);

		add(imagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너 등록 방법 2가지
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("여기가 동작 합니다.");
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					playerY -= 10;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					playerY += 10;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (enemyMove) {
						enemyMove = false;
						System.out.println(enemyMove);
					} else {
						enemyMove = true;
						System.out.println(enemyMove); 
					}
					// 1.스페이스를 눌렀을때 적군을 멈출수 있도록 코드수정

					// 2. 토글 개념으로 스페이스바를 누렀을떄 다시
					
				}

				repaint();
			}
		});
	}

}
