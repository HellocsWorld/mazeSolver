package p2;
/**************************
 * Raul A Serrano
 * 916615562
 * rserran2@mail.sfsu.edu
 **************************/
import java.util.Vector;

public class Maze {
  private char[][] maze;
  private int height;
  private int width;

  /**
   * Create a new Maze of the specified height and width, initializing every
   * location as empty, with a ' '.
   **/
  public Maze( int width, int height ) {
	  this.width = width;
	  this.height = height;	
	  this.maze = new char[width][height];
	    for (int x = 0; x < height; x++) {
	      for (int y = 0; y < width; y++) {
	        this.maze[y][x] = ' ';
	      }
	    }
  }

  /**
   * Mutator to allow us to set the specified Coordinate as blocked,
   * marking it with a 'X'
   **/
  public void setBlocked( Coordinate coord ) {
			  maze[coord.y][coord.x]='X';
	 }
	

  /**
   * Mutator to allow us to set the specified Coordinate as having been visited,
   * marking it with a '*'
   **/
  public void setVisited( Coordinate coord ) {	
		  maze[coord.y][coord.x]='*';
		     
	 }

  /**
   * Mutator to allow us to set the specified Coordinate as part of the path solution,
   * marking it with a '.'
   **/
  public void setPath( Coordinate coord ) {
		maze[coord.y][coord.x]='.';
   }				  
 

  /**
   * Returns the character at the locatio specified by the Coordinate
   **/
  public char at( Coordinate coord ) {	 
	  return maze[coord.y][coord.x];			  
		     
 }	

  /**
   * Returns a Coordinate array containing all Coordinates that are clear around
   * the specified coordinate.
   **/
  public Coordinate[] clearAround( Coordinate coord ) {
    Vector<Coordinate> vector = new Vector<Coordinate>();
    // Look at each of the locations around the specified Coordinate, and add it
    // to the vector if it is clear (i.e. a space)/.    
         
         if(coord.y !=0 && maze[coord.y-1][coord.x]== ' '){ //down
           vector.add(new Coordinate(coord.x, coord.y - 1));
         }
         if(coord.x != 0 && maze[coord.y][coord.x-1]== ' '){ //left
           vector.add(new Coordinate(coord.x - 1, coord.y));
         }
         if(coord.y + 1 != height && maze[coord.y+1][coord.x]== ' '){ //up
           vector.add(new Coordinate(coord.x, coord.y + 1));
         }
         if(coord.x != width && maze[coord.y][coord.x+1]== ' ') {//right
           vector.add(new Coordinate(coord.x + 1, coord.y));
         }
        return vector.toArray( new Coordinate[0] );
  }

  /**
   * Returns a Coordinate that provides the entrance location in this maze.
   **/
  public Coordinate start() {
    return new Coordinate( 0, 1 );
  }

  /**
   * Returns a Coordinate that provides the exit location from this maze.
   **/
  public Coordinate end() {
    // ADD STATEMENTS HERE
	  return new Coordinate(height-1, width-2);	  
  }

  /**
   * The toString() method is responsible for creating a String representation
   * of the Maze.  See the project specification for sample output.  Note that
   * the String representation adds numbers across the top and side of the Maze
   * to show the Coordinates of each cell in the maze.
   **/
  public String toString() {
    StringBuilder buffer = new StringBuilder();

    // ADD STATEMENTS HERE
    // First, print out the column headings
    buffer.append("   ");
    for (int i = 0; i < width; i++) {
      if (i < 10) {
        buffer.append(" " + i);
      } 
      else {
        buffer.append(" " + (i % 10));
      }
    }
    // Next, print out each row in the maze - note the spaces between
    // cells to facilitate reading.  Each row should include its row number.
    for (int i = 0; i < height; i++) {
        buffer.append('\n');
        if (i < 10) {
          buffer.append(" " + i + " ");
        } 
        else {
          buffer.append(" " + (i % width));
        }
        for (int j = 0; j < width; j++) {
          buffer.append(" " + maze[i][j]);
        }
        
     }  	
  
      return buffer.toString();
  }
}
  
  


