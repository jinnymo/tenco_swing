package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 중첩 클래스 ---> 외부 내부 클래스로 활용가능
 * 					내부 클래스로 --> 인스턴스 클래스, static 클래스
 * 
 */
public class MyImageFrame extends JFrame{
	//내부클래스로 정의한 데이터 타입
	private MyImagePanel myImagePanel;
	
	public MyImageFrame() {
		initData();
		setInitLayout();
	
	}
	
	private void initData() {
		setTitle("이미지 활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myImagePanel = new MyImagePanel();
		
	}
	
	private void setInitLayout(){
		add(myImagePanel);
		setVisible(true);
	}
	//내부 ㅋㄹ래스 --> static 키워드 활용
	//정적(static) 내부 클래스라고 한다.
	static class MyImagePanel extends JPanel{
		
		private Image image;
		static int a=100;
		public MyImagePanel() {
			//ImageIcon 데이터 타입 -> getImage() 메서드를 호출하면 
			//image 데이터 타입을 만들어 낼수 있다.
			image = new ImageIcon("image1.png").getImage();
		}
		//paints -> x
		//print -> x
		
		@Override
		public void paint(Graphics g) {
		
			super.paint(g);
			System.out.println("sadf");
			g.drawImage(image,100,a,100,100,null);
			g.drawImage(image,200,a,100,100,null);
			
			a+=100;
			
		}
	}
	
}
