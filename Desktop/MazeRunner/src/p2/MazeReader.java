package p2;
/**************************
 * Raul A Serrano
 * 916615562
 * rserran2@mail.sfsu.edu
 **************************/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MazeReader {
  private String fileName;
  private Maze maze;

  public MazeReader( String fileName ) {
    this.fileName = fileName;
    this.maze = null;
  }

  public Maze open() throws FileNotFoundException {
    Scanner scanner = new Scanner( new File( this.fileName ));

    int width = scanner.nextInt();
    int height = scanner.nextInt();
    this.maze = new Maze( width, height );

    // Remove new line after int
    scanner.nextLine();
    // ADD STATEMENTS HERE
    // You will need to read in each line using the Scanner, and provide
    // the row number and the line to the addLine method to add it to the Maze      
    int row=0;
    String line;
    while(scanner.hasNext()){
    	line=scanner.nextLine();    	
    	addLine(row, line);	
    	row++;
      }	
      scanner.close();          
      return maze;
    }


  private void addLine( int row, String line ) {
	  for(int n=0; n<line.length(); n++)
	  {
		  char nextLetter=line.charAt(n);
		  if(nextLetter != ' ')
		  maze.setBlocked(new Coordinate(n,row));
	   
	  }
	
	  
  }

  public static void main( String[] args ) throws FileNotFoundException {
    MazeReader reader = new MazeReader( "sampleMaze.txt" );
    Maze maze = reader.open();
    
    System.out.println( maze );
    System.out.println( maze.at( new Coordinate( 0, 0 )));
    System.out.println( maze.at( new Coordinate( 0, 1 )));

  }
}
