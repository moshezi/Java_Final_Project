package view;

import java.io.PrintStream;

import algorithms.search.Solution;
import algorithms.search.State;

// TODO: Auto-generated Javadoc
/**Class MySolutionDisplayer implements SolutionDisplayer.*/
public class MySolutionDisplayer implements SolutionDisplayer {
	
	@Override
	public void solutionDisplayer(Solution s, PrintStream out) {
		if (s != null){
			for(State st: s){
				out.println(st.getState());
			}
		}
	
		else{
			out.println("not found Solution");
		}
	}

}
