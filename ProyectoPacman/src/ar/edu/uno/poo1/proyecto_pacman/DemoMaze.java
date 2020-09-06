package ar.edu.uno.poo1.proyecto_pacman;

public class DemoMaze {

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.print();
		maze.pacManRight();
		for (int i=1; i<=3; i++) {
			maze.tick();
			maze.print();
		}
		maze.pacManUp();
		for (int i=1; i<=3; i++) {
			maze.tick();
			maze.print();
		}
		
		
	}

}