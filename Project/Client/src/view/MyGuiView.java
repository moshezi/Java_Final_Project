/**
 * 
 */
package view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import presenter.Presenter.Command;
import algorithms.mazeGenerator.Maze;
import algorithms.search.Solution;


public class MyGuiView extends Observable implements View {

	/** command queue. */
	Queue<Command> commandQueue;
	

	/** user commands. */
	HashMap<String, Command> userCommands;
	
	
	MazeWindow mazeWindow ;
	String runOptions;
	
	public MyGuiView() {
		super();
		userCommands = new HashMap<String, Command>();
		commandQueue = new LinkedList<Command>();
		runOptions = null;
		
	}
	
	@Override
	public void start() {
		setChanged();
		notifyObservers("Start");
		mazeWindow = new MazeWindow("maze", 600, 600,this);
		mazeWindow.run();
	}

	@Override
	public void setCommands(String commandName, Command command) {
		userCommands.put(commandName, command);

	}

	@Override
	public Command getUserCommand() {
		return commandQueue.poll();
	}

	@Override
	public void displayMaze(Maze m) {
		if (m != null){
			
			mazeWindow.setMazeData(m);
		}
		else{
			display("Maze not found" );
		}

	}

	@Override
	public void displaySolution(Solution s) {
		mazeWindow.displaySolution(s);

	}

	@Override
	public void display(String s) {
		mazeWindow.displayMsg(s);

	}
	
	public void Notify(String arg){
		setChanged();
		notifyObservers(arg);
	}

	@Override
	public String getRunOptions() {
		// TODO Auto-generated method stub
		return runOptions;
	}

	@Override
	public void setRunOptions(String runProperties) {
		this.runOptions = runProperties;
		
	}

}
