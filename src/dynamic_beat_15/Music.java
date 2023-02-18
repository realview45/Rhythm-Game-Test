package dynamic_beat_15;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;//라이브러리 임포트

//쓰레드는 프로그램 안의 작은 프로그램
//현재 하는 게임과 별도로 곡 재생해주는 작은 프로그램
public class Music extends Thread{
	
	private Player player;
	private boolean isLoop; //음악반복재생여부
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	// 00. src우클릭-> build Path -> configure build Path -> JLayer1.0.1파일을 class path에 넣기
	public Music(String name, boolean isLoop) {//생성자 곡제목,반복여부
		try {//try에서 오류가 발생시 catch문으로 넘어감
			this.isLoop = isLoop;
			//음악파일 가져오기
			file = new File(Main.class.getResource("../music/"+name).toURI());
			//음악파일 들여읽기
			fis = new FileInputStream(file);
			//음악파일을 버퍼에 담아 읽어오기
			bis = new BufferedInputStream(fis);
			//플레이어에 해당파일 담기
			player = new Player(bis);
		}catch(Exception e) {
				System.out.println(e.getMessage());//sysout ctrl+space	
		}
	}
	public int getTime() { //현재 어떤위치에 실행되고 있는지 알려줌 0.0001단위(10초=10000)
		if(player == null)return 0;
		return player.getPosition();
	}
	public void close() { //음악 종료 함수 (뒤로가기)
		isLoop = false;
		player.close();
		this.interrupt(); //해당 쓰레드를 중지상태로 만듬	
	}
	@Override
	public void run() {
		try {
			do { //isLoop라는 변수가 true라면 무한반복
				player.play();
				//아래세줄 위에서 복붙
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
