package view;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import presenter.Presenter.Command;
import algorithms.mazeGenerator.Maze;
import algorithms.search.Solution;



/**Class MyView extends Observable implements View.*/
public class MyView extends Observable implements View{
	
	
	BufferedReader in;
	
	PrintStream out;
	
	/** cli. */
	NewCli cli;
	
	/** command queue. */
	Queue<Command> commandQueue;
	

	/** user commands. */
	HashMap<String, Command> userCommands = new HashMap<String, Command>();

	/**
	 * Instantiates,new my view.
	 * @param in the in
	 * @param out the out
	 */
	public MyView(BufferedReader in, PrintStream out) {
	
		super();
		
		commandQueue = new LinkedList<Command>();
		
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}
	
	@Override
	public void start() {
		
		setChanged();
		notifyObservers("Start");
		Thread t = new Thread(new CLIRunnable(cli) );
		t.start();
		
	}

	@Override
	public void setCommands(String commandName, Command command) {
		userCommands.put(commandName, command);
		cli = new NewCli(userCommands, this, in, out);
	}

	@Override
	public Command getUserCommand() {	
		return commandQueue.poll();
	}

	@Override
	public void displayMaze(Maze m) {
		
		if (m != null){
			MyMazeDisplayer disMaze = new MyMazeDisplayer();
			disMaze.mazeDisplayer(m, out);
		}
		else{
			display("Maze not found" );
		}

	}

	@Override
	public void displaySolution(Solution s) {
		if (s != null){		
			MySolutionDisplayer disSol = new MySolutionDisplayer();
			disSol.solutionDisplayer(s, out);
		}
		else{
			display("Solution not found" );
		}
		
	}

	public void Notify(String arg){
		setChanged();
		notifyObservers(arg);
	}

	@Override
	public void display(String s) {
		System.out.println(s);
		
	    }
	
	
	@Override
	public String getRunOptions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void setRunOptions(String runProperties) {
		// TODO Auto-generated method stub
		
	}


}
