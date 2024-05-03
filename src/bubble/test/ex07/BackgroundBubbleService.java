package bubble.test.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundBubbleService  implements Runnable{

	private BufferedImage image;
	private Bubble bubble;



	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		boolean check = true;
		while(check) {			
			System.out.println("Sdafsd");
			Color leftColorBubble = new Color(image.getRGB(bubble.getX(), bubble.getY()+25));
			Color rightColorBubble = new Color(image.getRGB(bubble.getX()+50, bubble.getY()+25));			
			//왼쪽에 출동함
			
		if(rightColorBubble.getRed() == 255 && rightColorBubble.getGreen() == 0 && rightColorBubble.getBlue() ==0) {
				 System.out.println("버블이  왼쪽벽에 출동함");
				 bubble.setRight(false);
				 bubble.setLeftWallCrash(true);
				 check =false;
				 bubble.setVisible(false);
			}else if(leftColorBubble.getRed() == 255 && leftColorBubble.getGreen() == 0 && leftColorBubble.getBlue() ==0) {
				 System.out.println("버블이  오른쪽벽에 출동함");
				 bubble.setLeft(false);
				 bubble.setRightWallCrash(true);
				 check =false;
				 bubble.setVisible(false);
				
			}
			else {
				
				bubble.setLeftWallCrash(false);
				bubble.setRightWallCrash(false);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//System.out.println(player.getX()+"||"+player.getY());
		
	}
}
