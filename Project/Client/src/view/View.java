/**
 * 
 */
package view;


import presenter.Presenter.Command;
import algorithms.mazeGenerator.Maze;
import algorithms.search.Solution;



/** Interface View.*/
public interface View {
	
	void start();
	
	/**
	 * Sets the commands.
	 * @param commandName the command name
	 * @param command the command
	 */
	void setCommands(String  commandName, Command command);
	
	/**
	 * Gets the user command.
	 *
	 * @return the user command
	 */
	Command getUserCommand();
	
	/**
	 * Display maze.
	 *
	 * @param m the m
	 */
	void displayMaze(Maze m);
	
	/**
	 * Display solution.
	 *
	 * @param s the s
	 */
	void displaySolution(Solution s);
	

	/**
	 * Display.
	 *
	 * @param s the s
	 */
	void display(String s);
	
	/**
	 * getRunOptions
	 * @return {@link String}
	 */
	public String getRunOptions();
	
	/**
	 * setRunOptions
	 */
	public void setRunOptions(String runProperties);

}


