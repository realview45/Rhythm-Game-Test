package dynamic_beat_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;//Ctrl+Shift+O
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {// JFrame은 텍스트 기반이아닌 GUI(그래픽유저인터페이스)기반의 프로그램을 만들기 위한 가장 기본적으로 상속받아야함
	// 내부에서 공유하는 바뀌지않는(상수) 상수는 전부 대문자 사용

	// 버블버퍼링: 버퍼에 담아 매순간마다 이미지 갱신해주는 기술
	private Image screenImage;// 이미지를 담는 인스턴스(변수)
	private Graphics screenGraphic;

	// 전역변수로 변경쓰
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground(Title).jpg"))
			.getImage();
	
	private Image titleImage1 = new ImageIcon(Main.class.getResource("../images/KickBack.png")).getImage();
	private Image titleImage2 = new ImageIcon(Main.class.getResource("../images/Marionette.png")).getImage();
	private Image titleImage3 = new ImageIcon(Main.class.getResource("../images/Crow.png")).getImage();
	private Image titleImage4 = new ImageIcon(Main.class.getResource("../images/Naruto.png")).getImage();
	// 아티스트 초상화 getImage는 ImageIcon을 Image로 변화해준다
	private Image ArtistImage1 = new ImageIcon(Main.class.getResource("../images/SungHa.png")).getImage();
	private Image ArtistImage2 = new ImageIcon(Main.class.getResource("../images/HwaJong.png")).getImage();
	private Image ArtistImage3 = new ImageIcon(Main.class.getResource("../images/JinSan.png")).getImage();
	private Image ArtistImage4 = new ImageIcon(Main.class.getResource("../images/JaeHoon.png")).getImage();
	
	
	// menuBar라는 객체안에 menuBar.png이미지가 들어감
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	//창닫기버튼
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Exit.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/ExitHover.png"));
	
	//시작버튼
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/UpsideButton.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/UpsideButtonHover.png"));
	
	//방향버튼
	private ImageIcon leftButtonImage = new ImageIcon(Main.class.getResource("../images/leftButton.png"));
	private ImageIcon rightButtonImage = new ImageIcon(Main.class.getResource("../images/rightButton.png"));
	
	
	//끝내기버튼
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/UpsideButton.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/UpsideButtonHover.png"));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonImage);
	private JButton rightButton = new JButton(rightButtonImage);
	// private JButton exitButton = new JButton(new
	// ImageIcon(Main.class.getResource("../images/ExitON.png")));

	
	private int mouseX, mouseY;
	
	//메인화면일떄 true
	private boolean isMainScreen =false;

	public DynamicBeat() {// 생성자(DynamicBeat라는 객체가 만들어졌을 떄 가장 먼저 실행되는 부분(초기화를 담당)
		// deco(menuBar)를 보이지않게 만듬
		setUndecorated(true);
		setTitle("Dynamic Beat");// 우리가 만들 게임의 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);// 한번만들어진 게임창은 사용자가 임의로 줄일수없음
		setLocationRelativeTo(null);// 게임창이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 게임창이 종료됐을 때 프로그램 전체가 종료된다 필수1
		setVisible(true);// 게임창이 화면에 출력되도록함 필수2
		// paintComponents 배경색설정
		setBackground(new Color(0, 0, 0, 0));
		// Button이나 JLabel등을 넣었을때 그 위치그대로 꽂힘
		setLayout(null);
		// menuBar의 절대위치와 크기를 정해줌
		menuBar.setBounds(0, 0, 1200, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			// 드래그할때 순간순간마다 x좌표와 y좌표를 얻어와서
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			// JFrame 게임창의위치를 바꿔준다 -> 메뉴바를 드래그했을떄 창이 이동한다
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});

		// screenImage(JFrame)에 menuBar(JLabel)추가
		add(menuBar);
		// 가로 세로 가로크기 세로크기
		exitButton.setBounds(1050, 50, 513, 510);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		//size는 히트박스
		exitButton.setSize(60, 60);
		exitButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);;
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					//누른다음 1초정도 있다가 프로그램이 종료되도록함(소리, 이미지 정상출력위해)
					Thread.sleep(800);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		startButton.setBounds(40, 200, 173, 36);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);;
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				
				//게임시작 이벤트
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);//이전에 초기화
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
						.getImage();
				//메인화면
				isMainScreen= true;
				
			}
		});
		quitButton.setBounds(40, 330, 173, 36);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);;
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					//누른다음 1초정도 있다가 프로그램이 종료되도록함(소리, 이미지 정상출력위해)
					Thread.sleep(800);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				//오른쪽버튼 이벤트
			}
		});
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				//오른쪽버튼 이벤트
			}
		});
		//add가 된 부분들은 paintComponents에 의해서 그려짐
		add(exitButton);
		add(startButton);
		add(quitButton);
		add(leftButton);
		add(rightButton);
		// introMusic을 무한재생하는 클래스객체생성
		Music introMusic = new Music("introMusicMP3.mp3", true);
		introMusic.start();
	}

	// 메서드(함수) 생성
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// 백그라운드이미지를 스크린에 그리기
		// HEIGHT, FRAMEBITS, ERROR, ALLBITS, ABORT, rootPane(선택)
		// 0,0의 위치에 그린다
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {// 백그라운드이미지를 스크린에 그리기
		// screenImage라는 변수 안에 일시적으로 그려줌
		g.drawImage(background, 0, 0, null);
		// paintComponents는 menuBar(JLabel등)를 screenImage(JFrame)라는 변수 안에 그려주는역할
		// ㅗ고정된이미지!
		if(isMainScreen) {
			g.drawImage(ArtistImage1,  300, 150, null);
			g.drawImage(ArtistImage2,  300, 250+10, null);
			g.drawImage(ArtistImage3,  300, 350+20, null);
			g.drawImage(ArtistImage4,  300, 450+30, null);
			g.drawImage(titleImage1, 375, 150-3, null);
			g.drawImage(titleImage2, 375, 250+10-3, null);
			g.drawImage(titleImage3, 375, 350+20-3, null);
			g.drawImage(titleImage4, 375, 450+30-3, null);
		}
		paintComponents(g);
		this.repaint();// 다시 paint()함수를 불러옴 즉 전체이미지를 프로그램이 종료될때까지 계속 반복해서 불러옴
	}
}
