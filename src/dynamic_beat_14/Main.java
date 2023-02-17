package dynamic_beat_14;

public class Main {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	//13 떨어지는 속도, 무한정 떨어지는것이 아니라 얼마간의 시간을 주기로 떨어지는지 상수설정
	public static final int NOTE_SPEED = 3;//0.007초
	public static final int SLEEP_TIME =10;//0.01초
	//14.5-2
	public static final int REACH_TIME =2;//노트가 생성되고 나서 판정바에 도달하기까지의시간
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DynamicBeat();
	
	}
}
