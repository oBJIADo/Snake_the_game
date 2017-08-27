package snake.game.objs;

import snake.game.objs.GameObject;

public class Floor extends GameObject{
	// id of the symbol for this object's type
	private final char curObjectPicID = 183; //dot
	final public char draw(){
		return curObjectPicID;
	}
	public int objectType(){
		return GameObject.FLOOR;
	}
}
