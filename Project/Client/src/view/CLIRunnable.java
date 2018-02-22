package view;

// TODO: Auto-generated Javadoc
/** Class CLIRunnable implements Runnable.*/
public class CLIRunnable implements Runnable  {
		
		/** cli. */
		NewCli clI;

		public CLIRunnable(NewCli clI) {
		
			super();
			this.clI = clI;
		
		}
		
		@Override
		public void run() {
		
			clI.start();
			
		}

	}
