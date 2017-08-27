package snake.game.objs;

//abstract super class for games objects
public abstract class GameObject{	
	final static public int FLOOR = 0, WALL = 1, SNAKE_B = 2, SNAKE_H = 3, FOOD = 4; //constants for objects
	
	//function what return unic game object's symbol
	public char draw(){  
		return '0';
	}
	
	//function what return type of game object
	//return int object constant
	public int objectType(){ 
		return -1;			 
	}
	
	public static void isObject(Object ob) {
		
	}
}
