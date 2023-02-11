package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{//JFrame은 텍스트 기반이아닌 GUI(그래픽유저인터페이스)기반의 프로그램을 만들기 위한 가장 기본적으로 상속받아야함
	//내부에서 공유하는 바뀌지않는(상수) 상수는 전부 대문자 사용
	
	public DynamicBeat() {//생성자(DynamicBeat라는 객체가 만들어졌을 떄 가장 먼저 실행되는 부분(초기화를 담당)
		setTitle("Dynamic Beat");//우리가 만들 게임의 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);//한번만들어진 게임창은 사용자가 임의로 줄일수없음
		setLocationRelativeTo(null);//게임창이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창이 종료됐을 때 프로그램 전체가 종료된다 필수1
		setVisible(true);//게임창이 화면에 출력되도록함 필수2
		
	}
}
