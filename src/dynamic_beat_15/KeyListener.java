package dynamic_beat_15;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	@Override
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game==null) {//현재 게임이 진행되고있지 않다면 끝내기 키보드눌러도 변화X
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			DynamicBeat.game.pressA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.pressSB();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) { 
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.pressL();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			DynamicBeat.game.presssem();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(DynamicBeat.game==null) {//현재 게임이 진행되고있지 않다면 끝내기 키보드눌러도 변화X
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			DynamicBeat.game.releaseA();

		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.releaseD();

		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.releaseF();

		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.releaseSB();

		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.releaseJ();

		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.releaseK();

		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.releaseL();

		}
		else if(e.getKeyCode() == KeyEvent.VK_SEMICOLON) {
			DynamicBeat.game.releasesem();

		}
	}
}
