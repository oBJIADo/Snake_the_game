package snake;

import java.io.IOException;
import snake.game.Field;
import snake.game.exception.GameOverException;

// Second thread for snake
// FIrst thread for reading symbols
// second thread make a movings(redraw game field)
class MovingIsReal implements Runnable{
	Thread game;
	private boolean isGameAlive;
	private Field currentGameField;
	public int direction;
	private int sleepTime;
	
	//construct using three params: 
	//		firts field high
	//		snd field width
	//		thrd is sleeping time (game quickness)
	public MovingIsReal(int high, int width ,int sleepTime) throws GameOverException {
		game = new Thread(this,"game");
		this.sleepTime = sleepTime;
		isGameAlive = true;
		currentGameField = new Field(high, width);
		currentGameField.draw();
		game.start();
	}
	public MovingIsReal(int high, int width) throws GameOverException {
		this(high, width ,1000);
	}
	public MovingIsReal(int sleepTime) throws GameOverException {
		this(15, 30 ,sleepTime);
	}
	public MovingIsReal() throws GameOverException {
		this(15, 30 ,1000);
	}
	
	//standart function what using runnable interface
	public void run() {
		while(isGameAlive) {//it's alive until bool param is true. To change u should use gameThrows
			try {
				Thread.sleep(sleepTime);
				// it is for Windows cmd (console)
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
				currentGameField.moveHerBudy(direction); // function what change snake position
				currentGameField.draw(); //redraw game field with new snake positions
			} catch(InterruptedException e){
				isGameAlive = false;
				System.out.println("Поток " + game.toString() + " прерван");
				System.out.println("Press Enter");
			} catch(GameOverException e) {
				isGameAlive = false;
				System.out.println("OLOLOLO " + e.getMessage());
				System.out.println("Press Enter");
			} catch(IOException e) {
				isGameAlive = false;
				System.out.println(e.toString());
				System.out.println("Press Enter");
			}
		}
	}
	
	
	
	public void gameStop() {	//one of three main rules of programming
		isGameAlive = false;	// sequre also
	}
	public boolean isAlive() {
		return isGameAlive;
	}
}