package snake.game.objs;

import snake.game.objs.GameObject;

public class Wall extends GameObject{
	private final char curObjectPicID = '@';//35;
	final public char draw(){
		return curObjectPicID;
	}
	public int objectType(){
		return GameObject.WALL;
	}
}

