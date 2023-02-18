package dynamic_beat_16;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	private Image background = new ImageIcon(Main.class.getResource("../images/introbBackground.jpg"))
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
	

	private Image SelectedMusicImage = new ImageIcon(Main.class.getResource("../images/Bar.png")).getImage();
	
	// menuBar라는 객체안에 menuBar.png이미지가 들어감
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	//창닫기버튼
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Exit.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/ExitHover.png"));
	
	//시작버튼
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/UpsideButton.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/UpsideButtonHover.png"));
	
	//끝내기버튼
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/UpsideButton.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/UpsideButtonHover.png"));
	
	//난이도버튼
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Button.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/ButtonHover.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/Button.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/ButtonHover.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButton.png"));
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton backButton =new JButton(backButtonBasicImage);
	
	private JButton A1Button = new JButton();
	private JButton A2Button = new JButton();
	private JButton A3Button = new JButton();
	private JButton A4Button = new JButton();
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	Music selectedMusic = new Music("CROWshort.mp3", true);;
	
	// private JButton exitButton = new JButton(new
	// ImageIcon(Main.class.getResource("../images/ExitON.png")));

	private int mouseX, mouseY;
	//메인화면일떄 true
	private boolean isMainScreen =false;
	private boolean isGameScreen =false;
	//1은 KICKBACK, 1은 MarioNette, 2는 Crow, 3은 Naruto 
	private int whereMusic = 0;
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	//전체에 한곡만재생 한개의 게임만할수 있기 때문에 전체를 아우르는 public static넣어줌
	//프로젝트전체에 사용되는 하나의 변수가 됨    
	//public static Game game =new Game();
	//12 변수를 선언만 함 나중에 객체생성
	public static Game game;
	//Game game = new Game();
	
	public DynamicBeat() {// 생성자(DynamicBeat라는 객체가 만들어졌을 떄 가장 먼저 실행되는 부분(초기화를 담당)
		
		//14.5-2 로딩이길어지면 오류가 발생할수있으므로 add가 이뤄지지않은상태에서 코드가 실행되면 오류가 남
		trackList.add(new Track("Sungha.png", "KickBack.png","SungHaBG.png","KICKBACKshort.mp3","KICKBACKs.mp3","KICKBACK arr by Sungha Jung"));
		trackList.add(new Track("HwaJong.png", "Marionette.png","HwaJongBG.png","MARIONETTEshort.mp3","MARIONETTE.mp3","Dance of Marionette by HwaJong Kim"));
		trackList.add(new Track("JinSan.png", "Crow.png","JinSanBG.png","CROWshort.mp3","CROW.mp3","Crow by JinSan Kim"));
		trackList.add(new Track("JaeHoon.png", "Naruto.png","JaeHoonBG.png","NARUTOshort.mp3","NARUTO.mp3", "Rising Spirit arr by JaeHoon Jang"));
		
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
		
		//만든클래스 적용시키기
		addKeyListener(new KeyListener());
		
		//00코드옮김
		// introMusic을 무한재생하는 클래스객체생성 main으로넘어갈때 음악이 멈추도록
		Music introMusic = new Music("introMusicMP3.mp3", true);
		introMusic.start();
		
		A1Button.setVisible(false);
		A2Button.setVisible(false);
		A3Button.setVisible(false);
		A4Button.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(false);
		// menuBar의 절대위치와 크기를 정해줌
		menuBar.setBounds(0, 0, 1280, 30);
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
		exitButton.setBounds(1209, 40, 513, 510);
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
				
				introMusic.close();
				//하이라이트 부분만 잘라서 사용
				//selectedMusic = new Music("KICKBACKshort.mp3",true);
							
				//게임시작 이벤트
				startButton.setVisible(false);
				quitButton.setVisible(false);
				A1Button.setVisible(true);				
				A2Button.setVisible(true);
				A3Button.setVisible(true);
				A4Button.setVisible(true);

				isMainScreen = true;
				background = new ImageIcon(Main.class.getResource("../images/mainbBackground.png"))
						.getImage();	
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
		A1Button.setBounds( 290, 150, 60, 60);
		A1Button.setBorderPainted(false);
		A1Button.setContentAreaFilled(false);
		A1Button.setFocusPainted(false);
		//size는 히트박스
		A1Button.setSize(700, 100);
		A1Button.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				A1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				A1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				whereMusic=1;
				selectedMusic.close();
				selectedMusic = new Music("KICKBACKshort.mp3",true);
				selectedMusic.start();
				
				easyButton.setVisible(true);
				hardButton.setVisible(true);
			}
			
		});
		A2Button.setBounds( 290, 250+10, 60, 60);
		A2Button.setBorderPainted(false);
		A2Button.setContentAreaFilled(false);
		A2Button.setFocusPainted(false);
		//size는 히트박스
		A2Button.setSize(700, 100);
		A2Button.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				A2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				A2Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				whereMusic=2;
				selectedMusic.close();
				selectedMusic = new Music("MARIONETTEshort.mp3",true);
				selectedMusic.start();
				
				easyButton.setVisible(true);
				hardButton.setVisible(true);
			}
			
		});
		A3Button.setBounds(290, 350+20, 60, 60);
		A3Button.setBorderPainted(false);
		A3Button.setContentAreaFilled(false);
		A3Button.setFocusPainted(false);
		//size는 히트박스
		A3Button.setSize(700, 100);
		A3Button.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				A3Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				A3Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				whereMusic=3;
				selectedMusic.close();
				selectedMusic = new Music("CROWshort.mp3",true);
				selectedMusic.start();
				
				easyButton.setVisible(true);
				hardButton.setVisible(true);
			}
			
		});
		A4Button.setBounds( 290, 450+30, 60, 60);
		A4Button.setBorderPainted(false);
		A4Button.setContentAreaFilled(false);
		A4Button.setFocusPainted(false);
		//size는 히트박스
		A4Button.setSize(700, 100);
		A4Button.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				A4Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				A4Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				whereMusic=4;
				selectedMusic.close();
				selectedMusic = new Music("NARUTOshort.mp3",true);
				selectedMusic.start();
				
				easyButton.setVisible(true);
				hardButton.setVisible(true);
			}
			
		});
		easyButton.setBounds(290,616, 250,67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		//size는 히트박스
		easyButton.setSize(250, 67);
		easyButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);;
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				//난이도쉬움이벤트
				gameStart(whereMusic,"Easy");
			}
		});
		hardButton.setBounds(725,616, 250,67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		//size는 히트박스
		hardButton.setSize(250, 67);
		hardButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);;
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				//난이도어려움이벤드
				gameStart(whereMusic,"Hard");
			}
		});

		backButton.setBounds(20, 40, 60,60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		//size는 히트박스
		backButton.setSize(60, 60);
		backButton.addMouseListener(new MouseAdapter() {
			//마우스가 올라갔을 때 Entered로 버튼이미지 바뀌고 손가락모양으로바뀌고 소리남
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			//마우스가 떼졌을때 Basic으로 다시 바꿔줌 다시 원래커서모양으로 돌아오고 소리남
			@Override
			public void mouseExited(MouseEvent e) {		
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			//눌렀을때 꺼짐
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				//메인으로돌아가는이벤드
				backMain();
			}
		});
		
		add(exitButton);
		add(startButton);
		add(quitButton);
		add(A1Button);
		add(A2Button);
		add(A3Button);
		add(A4Button);
		add(easyButton);
		add(hardButton);
		add(backButton);
	}

	// 메서드(함수) 생성
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		//Graphics2D라는 라이브러리는 글자깨짐을 막는다
		screenDraw((Graphics2D) screenGraphic);
		//screenDraw(screenGraphic);// 백그라운드이미지를 스크린에 그리기
		// HEIGHT, FRAMEBITS, ERROR, ALLBITS, ABORT, rootPane(선택)
		// 0,0의 위치에 그린다
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {// 백그라운드이미지를 스크린에 그리기
		// screenImage라는 변수 안에 일시적으로 그려줌
		g.drawImage(background, 0, 0, null);
		// paintComponents는 menuBar(JLabel등)를 screenImage(JFrame)라는 변수 안에 그려주는역할
		// ㅗ고정된이미지!
		if(isMainScreen) {
			if(whereMusic==1) {
				g.drawImage(SelectedMusicImage,290,150,null);	
			}
			else if(whereMusic==2) {
				g.drawImage(SelectedMusicImage,290,250+10,null);
			}
			else if(whereMusic==3) {
				g.drawImage(SelectedMusicImage,290,350+20,null);
			}
			else if(whereMusic==4){
				g.drawImage(SelectedMusicImage,290,450+30,null);
			}
			g.drawImage(ArtistImage1,  300, 150, null);
			g.drawImage(ArtistImage2,  300, 250+10, null);
			g.drawImage(ArtistImage3,  300, 350+20, null);
			g.drawImage(ArtistImage4,  300, 450+30, null);
			g.drawImage(titleImage1, 375, 150-3, null);
			g.drawImage(titleImage2, 375, 250+10-3, null);
			g.drawImage(titleImage3, 375, 350+20-3, null);
			g.drawImage(titleImage4, 375, 450+30-3, null);
		}
		if(isGameScreen) {		
			game.screenDraw(g);
		}
		paintComponents(g);
		try {//시간차(텀)을 두면서 실행 프로그램이 가벼워짐
			Thread.sleep(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();// 다시 paint()함수를 불러옴 즉 전체이미지를 프로그램이   종료될때까지 계속 반복해서 불러옴
	}
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic !=null)
			selectedMusic.close();
		isMainScreen=false; 
		A1Button.setVisible(false);
		A2Button.setVisible(false);
		A3Button.setVisible(false);  
		A4Button.setVisible(false);		
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(whereMusic-1).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;

		//12
		game = new Game(trackList.get(whereMusic-1).getTitleName(),difficulty,trackList.get(whereMusic-1).getStartMusic());
		//14 해당인스턴스의 run함수가 자동실행됨
		game.start();
		
		//14.5-2 맨밑에둬야 오류가 없음
		//뷰의 키입력포커스를 가질수있는지 결정
		setFocusable(true); 
		//키이벤트 강제설정 
		//requestFocus();
		
	}
	public void backMain() {
		isMainScreen =true;
		A1Button.setVisible(true);
		A2Button.setVisible(true);
		A3Button.setVisible(true);  
		A4Button.setVisible(true);		
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainbBackground.png")).getImage();
		backButton.setVisible(false);
		isGameScreen = false;
		
		//12
		game.close();
	}
}
