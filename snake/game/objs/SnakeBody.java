package snake.game.objs;

import snake.game.objs.GameObject;

public class SnakeBody extends GameObject{
	private final char curObjectPicID = 2;//scared smile :D
	final public char draw(){
		return curObjectPicID;
	}
	public int objectType(){
		return GameObject.SNAKE_B;
	}
}