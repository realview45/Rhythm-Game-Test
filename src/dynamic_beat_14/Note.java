//13
package dynamic_beat_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/Note01.png")).getImage();
	private Image noteLongImage = new ImageIcon(Main.class.getResource("../images/noteLong.png")).getImage();

	//노트가 생성되고 1초뒤에 판정라인에 다다르게됨
	//현재위치 120 1초에 700이동 1초가 지났을때 580이라는 판정라인에다다름
	private int x,y=580-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	
	//14
	//public Note(int x, int y, String noteType) {
	public Note(String noteType) {
		if(noteType.equals("A")) {
			x=123;
		}
		else if(noteType.equals("S")) {
			x=227;
		}
		else if(noteType.equals("D")) {
			x=331;
		}
		else if(noteType.equals("F")) {
			x=435;
		}
		else if(noteType.equals("SB")) {
			x=539;
		}
		else if(noteType.equals("J")) {
			x=643;
		}
		else if(noteType.equals("K")) {
			x=747;
		}
		else if(noteType.equals("L")) {
			x=851;
		}
		else if(noteType.equals(";")) {
			x=955;
		}
		this.noteType=noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		//14
		if(!noteType.equals("SB"))
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
		else //스페이스바
		{
			g.drawImage(noteLongImage, x, y, null);

		}
	}
	public void drop() {
		y+=Main.NOTE_SPEED;
	}
	@Override 
	public void run() {
		try {
			while(true) {//무한반복
				drop();
				//떨어지고 SLEEPTIME만큼 0.01초쉴수있도록함= 1초에 100번실행700만큼
				Thread.sleep(Main.SLEEP_TIME);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
