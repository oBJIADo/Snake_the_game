package snake.game.objs;
import snake.game.objs.GameObject;

public class Food extends GameObject{
	private final char curObjectPicID = 'O';//0x2363;
	final public char draw(){
		return curObjectPicID;
	}
	public int objectType(){
		return GameObject.FOOD;
	}
}