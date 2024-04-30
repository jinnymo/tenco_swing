package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel player, background, bubbleIcon;
	private static int posH;
	private static int posV;
	private int startPosH = 200;
	private int startPosV = 200;
	private final int MOVE_DISTANCE = 10;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	private Icon[] playerIcons;
	//private Icon bubbleIcon;
	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("images/backgroundMap.png");
		Icon icon2 = new ImageIcon("images/playerL.png");
		Icon iconBubble = new ImageIcon("images/bubble.png");
		
		setSize(icon.getIconWidth(), icon.getIconHeight());
		
		background = new JLabel(icon);
		background.setSize(icon.getIconWidth(), icon.getIconHeight());
		//background.setLocation(0, 0);
		
		player = new JLabel(icon2);
		player.setSize(player.getIcon().getIconWidth(), player.getIcon().getIconHeight());
		player.setLocation(startPosH, startPosV);

		posH = startPosH;
		posV = startPosV;
		
		

		playerIcons = new Icon[2];
		playerIcons[0] = new ImageIcon("images/playerL.png");
		playerIcons[1] = new ImageIcon("images/playerR.png");
		
		
		bubbleIcon = new JLabel(iconBubble);
		bubbleIcon.setLocation(posH, posV);
		bubbleIcon.setVisible(false);
		bubbleIcon.setSize(iconBubble.getIconWidth(),iconBubble.getIconHeight());
	
	}

	public void setInitLayout() {
		setLayout(null);
		add(background);
		background.add(player);
		background.add(bubbleIcon);
		setVisible(true);
	}

	public void addEventListener() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					posV -= MOVE_DISTANCE;
					
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					posV += MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					posH += MOVE_DISTANCE;
					player.setIcon(playerIcons[1]);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					posH -= MOVE_DISTANCE;
					player.setIcon(playerIcons[0]);
				}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("asdff");
					bubbleIcon.setLocation(posH, posV);
					bubbleIcon.setVisible(true);
					int bubbleH = posH;
					for (int i = 0; i < 10; i++) {
						bubbleH += i*10; 
						bubbleIcon.setLocation(bubbleH, posV );
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				player.setLocation(posH, posV);
			}
		});
	}

	public static void main(String[] args) {
		new MiniGame2();
	}

}
