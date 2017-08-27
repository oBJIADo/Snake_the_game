package snake.game.exception;

public class GameOverException extends Exception{
	private String throwMsg;
	public GameOverException(){
		throwMsg = "Snake is dead";
	}
	public GameOverException(String message){
		throwMsg = message;
	}
	
	@Override
	public String getMessage() {
		return throwMsg;
	}
	public String toString() {
		return "Game error: GameOverException"
				+ "\nMessage: " + throwMsg;
	}
}