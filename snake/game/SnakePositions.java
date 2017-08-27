package snake.game;

import snake.game.exception.DirectionException;

//class which show where is the snake
public class SnakePositions{ 
	private int[] indexMassive_y, indexMassive_x;
	public int dPosition_x = -1,dPosition_y = -1;
	static public final int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3; //int constants for snake direction
	private int currentDirection = UP;
	
	/*public SnakePositions(int length){ //need to rebuild this idea
		indexMassive_y = new int[length];
		indexMassive_x = new int[length];		
	}*/
	
	public SnakePositions(int[] xmas,int[] ymas){
		indexMassive_y = ymas;
		indexMassive_x = xmas;
	}
	
	
	
	public void changeDirection(int newDirection) throws DirectionException{
		if(newDirection>SnakePositions.DOWN & newDirection<SnakePositions.LEFT )
			throw new DirectionException(newDirection);
		//also up+up = 2  %2 =0
		if((newDirection + currentDirection)%2 != 0) //Check: left + right = 2  %2 =0
			currentDirection = newDirection;	 //		  up + down = 4  %2 =0
	}
	public int curDirection() { //Direction. do you need anymore info? :D
		return currentDirection;
	}
	
	//special function for snake's move
	//save deleted position
	//i should rework with dat two functions, but i like it #GovnoCode #ShitCode #StupidProgrammer
	private void move(int xIndex, int yIndex){  
		dPosition_x = indexMassive_x[indexMassive_x.length-1];
		dPosition_y = indexMassive_y[indexMassive_y.length-1];
		for(int i=indexMassive_y.length-1; i>0; i--){
			indexMassive_y[i]=indexMassive_y[i-1];
			indexMassive_x[i]=indexMassive_x[i-1];
		}
		indexMassive_y[0] = yIndex;
		indexMassive_x[0] = xIndex;
		
	}
	public void move(){
		switch(currentDirection) {
			case UP:
				move(indexMassive_x[0], indexMassive_y[0]-1);
				break;
			case DOWN:
				move(indexMassive_x[0], indexMassive_y[0]+1);
				break;
			case LEFT:
				move(indexMassive_x[0]-1, indexMassive_y[0]);
				break;
			case RIGHT:
				move(indexMassive_x[0]+1, indexMassive_y[0]);
				break;
		}
	}
	
	//special function for snake's increasing
	//Increase in the tail
	public void increase(int y, int x){
		int imas[] = new int[indexMassive_y.length+1];
		int jmas[] = new int[indexMassive_x.length+1];
		for(int k=0; k<indexMassive_y.length; k++){
			imas[k] = indexMassive_y[k];
			jmas[k] = indexMassive_x[k];
		}
		imas[imas.length-1] = y;
		jmas[jmas.length-1] = x;
		indexMassive_y = imas;
		indexMassive_x = jmas;
	}
	
	//special function for snake's increasing
	//Increase in the tail. Used dPositions
	public void increase() {
		increase(dPosition_y, dPosition_x);
	}
	
	public int snakelength() {
		return indexMassive_y.length;
	}
	
	//x and y params at i position in massive
	public int snakePart_y(int i) {
		return indexMassive_y[i];
	}
	public int snakePart_x(int i) {
		return indexMassive_x[i];
	}
	
	//helping function which show massive
	public void showMassive(){ 
		for(int x:indexMassive_y)
			System.out.print(x+ "	");
		System.out.println();
		for(int x:indexMassive_x)
			System.out.print(x+ "	");
		System.out.println();
	}
}