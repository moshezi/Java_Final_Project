package model;

import java.io.Serializable;
import java.util.HashMap;

import algorithms.mazeGenerator.Maze;
import algorithms.search.Solution;

// TODO: Auto-generated Javadoc
/** Class SolutionsMap.*/
public class SolutionsMap extends HashMap<Maze,Solution> implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new solutions map.
	 */
	public SolutionsMap() {
		
	}

}
