//this is a new line just to commit
package p2;
import java.io.FileNotFoundException;
/**************************
 * Raul A Serrano
 * 916615562
 * rserran2@mail.sfsu.edu
 **************************/
public class MazeSolver {
  private Maze maze;
  private LinkedStack<Coordinate> path;

  public MazeSolver( Maze maze ) {
    // ADD STATEMENTS HERE
	  this.maze = maze;
	  this.path = new LinkedStack<Coordinate>();
  }

  public void solve() {
    // ADD STATEMENTS HERE
    // Add the starting Coordinate to the maze, and while the Stack has
    // entries, and the top of the Stack is not the end, continue searching
    // for the path 
	  this.path.push(maze.start());
	    while (!path.isEmpty() && !(path.peek().x == maze.end().x && path.peek().y == maze.end().y)) {
	      Coordinate[] clear = maze.clearAround(path.peek());
	      if (clear.length == 0) {
	        this.maze.setVisited(path.peek());
	        this.path.pop();
	      } else {
	        this.maze.setPath(path.peek());
	        this.path.push(clear[0]);
	      }
	    }
	     maze.setPath(maze.end());
	  }


  public static void main( String[] args ) throws FileNotFoundException {
    MazeReader reader = new MazeReader( "sampleMaze.txt" );
    Maze maze = reader.open();
    MazeSolver solver = new MazeSolver( maze );

    System.out.println( "Before solving" );
    System.out.println( maze );
    System.out.println( "Start is " + maze.start() );
    System.out.println( "End is " + maze.end() );

    solver.solve();
    System.out.println( "After solving (. shows solution, * shows visited)" );
    System.out.println( maze );
  }
}
