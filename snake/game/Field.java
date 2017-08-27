package snake.game;

import snake.game.objs.*;
import java.util.Random;
import snake.game.exception.*;


public class Field{ //function for working with game field
	
	int fieldSize_h = 0;
	int fieldSize_w = 0;
	GameObject gameField[][];
	SnakePositions aSnake;
	
	//simple constructor
	//size params h(high) and w(width)
	public Field(int size_h, int size_w) throws GameOverException{
		if(size_h < 10 | size_w<10) throw new GameOverException("Field is small");
		fieldSize_h = size_h;
		fieldSize_w = size_w;
		int y[] = {size_h-5, size_h-4, size_h-3};
		int x[] = {size_w/2, size_w/2, size_w/2};
		aSnake = new SnakePositions(x,y);
		fieldInitialization();
		snakeInitialization();
		createFood();
	}
	
	//initialization field in the massive with current params
	private void fieldInitialization(){ 
		gameField = new GameObject[fieldSize_h][fieldSize_w];
	//initialization wall around the field
		//horizontal left wall
		for(int j=0; j<fieldSize_w; j++) 
			gameField[0][j] = new Wall();
		//horizontal right wall
		for(int j=0; j<fieldSize_w; j++) 
			gameField[fieldSize_h-1][j] = new Wall();
		//vertical up wall
		for(int i=0; i<fieldSize_h; i++)
			gameField[i][0] = new Wall(); 
		//vertical down wall
		for(int i=0; i<fieldSize_h; i++)
			gameField[i][fieldSize_w-1] = new Wall();
		
	//initialization field
		for(int i=1; i<fieldSize_h-1; i++)
			for(int j=1; j<fieldSize_w-1; j++){
				gameField[i][j] = new Floor();
			}
		
	//initialization the Snake 
	}
	private void snakeInitialization(){
		gameField[aSnake.snakePart_y(0)][aSnake.snakePart_x(0)] = new SnakeHead();
		for(int i=1; i<aSnake.snakelength();i++) {
			gameField[aSnake.snakePart_y(i)][aSnake.snakePart_x(i)] = new SnakeBody();
		}
	}
	
	//Let her move
	public void moveHerBudy(int direction) throws GameOverException {
		try {
			//change current direction
			aSnake.changeDirection(direction);
			//move forward direction
			aSnake.move();
		}
		catch(DirectionException e) {
			System.out.println(e.toString());
		}
		//check what the snake eat
		switch(gameField[aSnake.snakePart_y(0)][aSnake.snakePart_x(0)].objectType()) {
			case GameObject.FLOOR:// if floor
				gameField[aSnake.dPosition_y][aSnake.dPosition_x] = new Floor();
				gameField[aSnake.snakePart_y(0)][aSnake.snakePart_x(0)] = new SnakeHead();
				gameField[aSnake.snakePart_y(1)][aSnake.snakePart_x(1)] = new SnakeBody();
				break;
			case GameObject.WALL:
			case GameObject.SNAKE_B:
				throw new GameOverException();
			case GameObject.FOOD:
				aSnake.increase();
				gameField[aSnake.snakePart_y(0)][aSnake.snakePart_x(0)] = new SnakeHead();
				gameField[aSnake.snakePart_y(1)][aSnake.snakePart_x(1)] = new SnakeBody();
				createFood();
				break;
		}
	}
	
	private void createFood() {
		Random randPosition = new Random();
		int xPos, yPos;
		do {
		xPos = randPosition.nextInt(fieldSize_w-3)+1;
		yPos = randPosition.nextInt(fieldSize_h-3)+1;
		} while(gameField[yPos][xPos] instanceof SnakeHead | gameField[yPos][xPos] instanceof SnakeBody);
		gameField[yPos][xPos] = new Food();
	}
	
	// draw field in console
	// casual draw squad massive with 2 cycles
	public void draw(){
		for(int i=0; i<fieldSize_h; i++){
			for(int j=0; j<fieldSize_w; j++){
				 System.out.print(gameField[i][j].draw());
			}
			System.out.println();
		}
	}
}