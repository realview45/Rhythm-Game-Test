//13
package dynamic_beat_16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/Note01.png")).getImage();
	private Image noteLongImage = new ImageIcon(Main.class.getResource("../images/noteLong.png")).getImage();

	//노트가 생성되고 1초뒤에 판정라인에 다다르게됨
	//현재위치 120 1초에 700이동 1초가 지났을때 580이라는 판정라인에다다름
	private int x,y=580-1000/Main.SLEEP_TIME*Main.NOTE_SPEED * Main.REACH_TIME;
	private String noteType;
	
	//15.5
	public String getNoteType() {
		return noteType;
	}
	
	
	//15 현재노트의 진행여부
	private boolean proceeded = true;
	public boolean isProceeded() {
		return proceeded;
	}
	public void close() {//현재노트가 움직이지않도록해주는 함수
		proceeded = false;
	}
	
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
			x=747;
		}
		else if(noteType.equals("K")) {
			x=851;
		}
		else if(noteType.equals("L")) {
			x=955;
		}
		else if(noteType.equals(";")) {
			x=1059;
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
		//15 노트가 판정바를 벗어날 때
		if(y>620) {
			System.out.println("Miss");
			close();
		}
	}
	@Override 
	public void run() {
		try {
			while(true) {//무한반복
				drop();
				//15
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
				
				//떨어지고 SLEEPTIME만큼 0.01초쉴수있도록함= 1초에 100번실행700만큼
				Thread.sleep(Main.SLEEP_TIME);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//15.5
	public String judge() {
		if(y>=613) {
			System.out.println("Late");
			close();
			return "Late";
		}
		else if(y>=600) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y>=587) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y>=573) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y>=565) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y>=550) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y>=535){
			System.out.println("Early");
			close();
			return "Early";	
		}
		else {
			return "None";
		}
		
	}
	public int getY() {
		return y;
	}
}
