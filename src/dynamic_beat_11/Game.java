package dynamic_beat_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Game extends Thread{
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementBar.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/Note01.png")).getImage();
	//private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSBImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRoutesemImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	//public ArrayList<String> keyList = new ArrayList<String>();
	//private ArrayList<String> keyList = new ArrayList<>(Arrays.asList("A", "S", "D", "F","SB","J","K","L",""));
/*
	public ArrayList<Image> routeList = new ArrayList<Image>();
	
	public Game() {
		routeList.add(noteRouteAImage);
		routeList.add(noteRouteSImage);
		routeList.add(noteRouteDImage);
		routeList.add(noteRouteFImage);
		routeList.add(noteRouteSBImage);
		routeList.add(noteRouteJImage);
		routeList.add(noteRouteKImage);
		routeList.add(noteRouteLImage);
		routeList.add(noteRoutesemImage);
	}
*/
	public void screenDraw(Graphics2D g) {	
		/*
		for(int i=0;i<5;i++) {
			g.drawImage(noteRouteLineImage, 15+104+104*i, 30, null);
			g.drawImage(noteRouteImage, 123+104*i, 30, null);
		}
		for(int i=5;i<10;i++) {
			g.drawImage(noteRouteImage, 119+104*i, 30, null);
			g.drawImage(noteRouteLineImage, 219+104*i, 30, null);
		}
		*/	
		g.drawImage(noteRouteLineImage, 15+104+104*0, 30, null);
		g.drawImage(noteRouteAImage, 123+104*0, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*1, 30, null);
		g.drawImage(noteRouteSImage, 123+104*1, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*2, 30, null);
		g.drawImage(noteRouteDImage, 123+104*2, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*3, 30, null);
		g.drawImage(noteRouteFImage, 123+104*3, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*4, 30, null);
		g.drawImage(noteRouteSBImage, 123+104*4, 30, null);
		g.drawImage(noteRouteSBImage, 119+104*5, 30, null);
		g.drawImage(noteRouteLineImage,  219+104*5, 30, null);
		g.drawImage(noteRouteJImage, 119+104*6, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*6, 30, null);
		g.drawImage(noteRouteKImage, 119+104*7, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*7, 30, null);
		g.drawImage(noteRouteLImage, 119+104*8, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*8, 30, null);
		g.drawImage(noteRoutesemImage, 119+104*9, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*9, 30, null);
		
		g.drawImage(noteBasicImage, 123, 120, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		g.setColor(Color.white);
		//안티앨리어싱 적용되어 글자가 깨짐이 없이
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.ITALIC, 30));
		g.drawString("KICKBACK arr by SunghaJung",40,691);
		g.drawString("Easy", 1170, 691);
		
		g.setFont(new Font("Arial",Font.PLAIN,26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("A",  166,  609);
		g.drawString("S",  270,  609);
		g.drawString("D",  374,  609);
		g.drawString("F",  478,  609);
		g.drawString("Space Bar",  580,  609);
		g.drawString("J",  784,  609);
		g.drawString("K",  889,  609);
		g.drawString("L",  993,  609);
		g.drawString(";",  1097,  609);

		g.setFont(new Font("Elephant", Font.BOLD, 30));
		//점수판
		g.drawString("00000", 580, 691);
	}
	public void pressA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRouteA.png")).getImage();

	}
	public void pressS() {
		noteRouteSImage =new ImageIcon(Main.class.getResource("../images/noteRouteS.png")).getImage();

	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRouteD.png")).getImage();

	}
	public void pressF() {
		noteRouteFImage =new ImageIcon(Main.class.getResource("../images/noteRouteF.png")).getImage();

	}
	public void pressSB() {
		noteRouteSBImage = new ImageIcon(Main.class.getResource("../images/noteRoute1.png")).getImage();

	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRouteJ.png")).getImage();

	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRouteK.png")).getImage();

	}
	public void pressL() {
		noteRouteLImage =new ImageIcon(Main.class.getResource("../images/noteRouteL.png")).getImage();

	}
	public void presssem() {
		noteRoutesemImage = new ImageIcon(Main.class.getResource("../images/noteRoutesem.png")).getImage();

	}
	public void releaseA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseS() {
		noteRouteSImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseSB() {
		noteRouteSBImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseL() {
		noteRouteLImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releasesem() {
		noteRoutesemImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	@Override
	public void run() {//Game이라는 클래스로 만든 인스턴스가 run이라는 메서드를 사용할거임
	

	}
}
