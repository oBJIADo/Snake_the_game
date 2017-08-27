package snake.game.objs;
public class SnakeHead extends GameObject{
	private final char curObjectPicID = 2;//0x2363;
	final public char draw(){
		return curObjectPicID;
	}
	public int objectType(){
		return GameObject.SNAKE_H;
	}
}