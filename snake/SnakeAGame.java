package snake;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import snake.game.exception.GameOverException;
import snake.game.SnakePositions;

class SnakeAGame{
	public static void main(String[] args){
		
		String menu ="";
		boolean menuCont = true;
		char a;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); ;
		
		menu = menu.toLowerCase();
		System.out.println("Lets start");
		
		while(menuCont) {
			SnakeAGame.menuOut();
			try {
				menu = br.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			switch(menu) {
				case "start":
					MovingIsReal gameStart;
					try {
						gameStart = new MovingIsReal(400);
					}
					catch(GameOverException e) {
						System.out.println(e.getMessage());
						return;
					}
					a ='\0';
					while(gameStart.isAlive()) {
						try {
							a = (char)br.read();
						}
						catch(IOException e) {
							System.out.println(e.getMessage());
						}
						switch(a) {
							case 'a':
								gameStart.direction = SnakePositions.LEFT;
								break;
							case 's':
								gameStart.direction = SnakePositions.DOWN;
								break;
							case 'd':
								gameStart.direction = SnakePositions.RIGHT;
								break;
							case 'w':
								gameStart.direction = SnakePositions.UP;
							break;
						}
					}
					break;
				case "exit":
					menuCont = false;
					break;

			}
			
		}
	}
	
	public static void menuOut(){
		System.out.println("Print:"
				+ "\n\tstart - start the game"
				+ "\n\texit - close the game");
	}
}

//What to do!
/*
3. I does IT!!!
*/