package bubble.test.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private Bubble bubble;

	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX(), player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50, player.getY() + 25));
			Color bottomColor = new Color(image.getRGB(player.getX() + 25, player.getY() + 50));

			
			// 왼쪽에 출동함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽벽에 출동함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽벽에 출동함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else if (bottomColor.getRed() == 0 && bottomColor.getGreen() == 0 && bottomColor.getBlue() == 255) {
				System.out.println("파란바닥 터치");
				player.setbluetWallCrash(true);
				player.setlastStandingAreaRed(false);

			} else if (bottomColor.getRed() == 255 && bottomColor.getGreen() == 0 && bottomColor.getBlue() == 0) {
				System.out.println("빨간바닥 터치");
				player.setlastStandingAreaRed(true);

			} else if (!player.islastStandingAreaRed() && player.isblueWallCrash()) {
				
				player.down();
				player.setbluetWallCrash(false);
			} else {

				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// System.out.println(player.getX()+"||"+player.getY());

	}
}
