package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;//Ctrl+Shift+O
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{//JFrame은 텍스트 기반이아닌 GUI(그래픽유저인터페이스)기반의 프로그램을 만들기 위한 가장 기본적으로 상속받아야함
	//내부에서 공유하는 바뀌지않는(상수) 상수는 전부 대문자 사용
	
	//버블버퍼링: 버퍼에 담아 매순간마다 이미지 갱신해주는 기술
	private Image screenImage;//이미지를 담는 인스턴스(변수)
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public DynamicBeat() {//생성자(DynamicBeat라는 객체가 만들어졌을 떄 가장 먼저 실행되는 부분(초기화를 담당)
		setTitle("Dynamic Beat");//우리가 만들 게임의 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);//한번만들어진 게임창은 사용자가 임의로 줄일수없음
		setLocationRelativeTo(null);//게임창이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창이 종료됐을 때 프로그램 전체가 종료된다 필수1
		setVisible(true);//게임창이 화면에 출력되도록함 필수2

		setResizable(false);
			
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
		
	}
	//메서드(함수) 생성
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);//백그라운드이미지를 스크린에 그리기
		//HEIGHT, FRAMEBITS, ERROR, ALLBITS, ABORT, rootPane(선택)
		//0,0의 위치에 그린다
		g.drawImage(screenImage,  0,  0, null);
	}
	public void screenDraw(Graphics g) {//백그라운드이미지를 스크린에 그리기
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();//다시 paint()함수를 불러옴 즉 전체이미지를 프로그램이 종료될때까지 계속 반복해서 불러옴 
	}
}
