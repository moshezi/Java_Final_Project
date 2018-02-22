package model;

import algorithms.mazeGenerator.Maze;
import algorithms.search.Solution;

public interface Model {

	/**
	 * maze.
	 * @param mazeName the maze name
	 */
	
	void generateMaze(String mazeName);
	
	Maze getMaze(String mazeName);
	
	/**
	 * Solve maze.
	 * @param mazeName the maze name
	 */
	
	void solveMaze(String mazeName);
	
	/**
	 * Gets the solution.
	 *
	 * @param mazeName, maze name
	 * @return {@link Solution}
	 */
	Solution getSolution(String mazeName);
	
	void stop();
	
	void upaloadSolutions();

	void start();
	
	public String getRunProperties();
	
	/** setRunProperties*/
	public void setRunProperties(String runProperties);
}
