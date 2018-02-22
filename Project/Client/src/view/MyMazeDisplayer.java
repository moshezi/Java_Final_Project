package view;

import java.io.PrintStream;

import algorithms.mazeGenerator.Cell;
import algorithms.mazeGenerator.Maze;

// TODO: Auto-generated Javadoc

/**MyMazeDisplayer implements MazeDisplayer.*/
public class MyMazeDisplayer implements MazeDisplayer {

	@Override
	public void mazeDisplayer(Maze m, PrintStream out) {
		
		int cols = m.getCols();
		int rows = m.getRows();

		for (int j = 0; j < cols; j++)
			out.print("__");
		out.println("_");
		
		for (int i = 0; i < rows; i++) {
			out.print("|");
			for (int j = 0; j < cols; j++) {				
				Cell cell =  m.getCell(i, j);
				if (cell.getHasBottomWall())
					out.print("_");
				else
					out.print(" ");
				
				if (cell.getHasRightWall())
					out.print("|");
				else
					out.print(" ");	
								
			}
			out.println();
		}
	}
}
