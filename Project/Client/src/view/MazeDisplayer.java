package view;

import java.io.PrintStream;

import algorithms.mazeGenerator.Maze;

// TODO: Auto-generated Javadoc
/** Interface MazeDisplayer.*/
public interface MazeDisplayer {

	/**
	 * Maze displayer.
	 * @param m the m
	 * @param out the out
	 */
	public void mazeDisplayer(Maze m , PrintStream out);
}
