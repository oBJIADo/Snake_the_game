package snake.game.exception;

//special game exceptions
public class DirectionException extends Exception{
	private int wrongDirection;
	public DirectionException(int wrongDirection) {
		this.wrongDirection = wrongDirection;
	}
	public String toString() {
		return "Wrong snake dierction: "+this.wrongDirection;
	}
}