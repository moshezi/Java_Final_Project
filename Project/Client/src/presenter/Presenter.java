package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class Presenter implements Observer {

	View view;

	
	Model model;

	public Presenter(View view, Model model) {
		this.view = view;
		this.model = model;
		setUserCommand();
	}

	/** user command. */

	public void setUserCommand() {
		view.setCommands("generateMaze", new generateMazeCommand());
		view.setCommands("displayMaze", new displayMazeCommand());
		view.setCommands("solveMaze", new solveMazeCommand());
		view.setCommands("displaySolution", new displaySolutionCommand());
		view.setCommands("exit", new exitCommand());
		view.setCommands("getProperties", new getProperties());
		view.setCommands("setProperties", new setProperties());
	}

	public void update(Observable o, Object arg) {
		String[] Name_params = ((String) arg).split(" ");
		if (o == view) {
			if (Name_params[0].equals("Start")) {
				start();
			} else if (Name_params[0].equals("Command")) {
				Command command = view.getUserCommand();
				command.doCommand(Name_params[1]);
			}
		} else if (o == model) {

			if (Name_params[0].equals("generateMazeComplete")) {
				

			} else if (Name_params[0].equals("solveMazeCompleted")) {
				

			}
			
			else if (Name_params[0].equals("solveMazeCompletedErorr")) {
				view.display("Maze " + Name_params[1] + " not exist");

			}
		}

	}

	private void start() {
		model.start();

	}

	/**Interface.*/
	public interface Command {

		/**
		 * Do command.
		 * @param arg
		 */
		void doCommand(String arg);
	}

	/**
	 *Class generateMazeCommand.
	 */
	public class generateMazeCommand implements Command {

		@Override
		public void doCommand(String arg) {
			model.generateMaze(arg/* , 0, 0 */);

		}

	}

	/**Class displayMazeCommand.*/
	public class displayMazeCommand implements Command {

		@Override
		public void doCommand(String arg) {
			if (model.getMaze(arg) != null)
				view.displayMaze(model.getMaze(arg));
			else
				view.display("Maze " + arg + "  not found");
		}
	}

	/**Class solveMazeCommand.*/
	public class solveMazeCommand implements Command {

		@Override
		public void doCommand(String arg) {
			model.solveMaze(arg);
		}
	}

	/**Class displaySolutionCommand.*/
	public class displaySolutionCommand implements Command {

		@Override
		public void doCommand(String arg) {
			if (model.getSolution(arg) != null)
				view.displaySolution(model.getSolution(arg));
			else
				view.display("Solution for maze : " + arg + " not found");

		}
	}

	/**Class exitCommand.*/
	public class exitCommand implements Command {

		@Override
		public void doCommand(String arg) {
			model.stop();
		}
	}

	/**Class getProperties.*/
	public class getProperties implements Command {

		@Override
		public void doCommand(String arg) {
			view.setRunOptions(model.getRunProperties());

		}
	}

	/**Class setProperties.*/
	public class setProperties implements Command {

		@Override
		public void doCommand(String arg) {
			model.setRunProperties(arg);
		}
	}

}
