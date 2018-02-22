package model;

import java.util.concurrent.Callable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import algorithms.mazeGenerator.Cell;
import algorithms.mazeGenerator.DFSMazeGenerator;
import algorithms.mazeGenerator.Maze;
import algorithms.mazeGenerator.MazeGenerator;
import algorithms.mazeGenerator.RandomMazeGenerator;

/**Generate Maze with thread.*/
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CallableMaze implements Callable<Maze> {
	
	/** rows. */
	private int rows;
	
	/** cols. */
	private int cols;
	
	/** x start point. */
	private int xStartPoint;
	
	/** y start point. */
	private int yStartPoint;
	
	/** maze generate type. */
	private String mazeGenerateType;

    public CallableMaze() {
    }

        
        
	/** Instantiates a new callable maze.*/
	public CallableMaze(String mazeGenerateType, int rows, int cols, int xStartPoint, int yStartPoint) {

		this.mazeGenerateType = mazeGenerateType;
		this.rows = rows;
		this.cols = cols;
		this.xStartPoint = xStartPoint;
		this.yStartPoint = yStartPoint;
	}
	
	@Override
	public Maze call() throws Exception {
		MazeGenerator mg = null;
		if (mazeGenerateType.equals("DFS")){
			mg = new DFSMazeGenerator();
			
		}
		else if (mazeGenerateType.equals("RANDOM")){
			mg = new RandomMazeGenerator();
		}
		Maze maze = mg.generateMaze(rows,cols,new Cell(xStartPoint,yStartPoint));
		return maze;
	}

}
