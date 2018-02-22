/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import algorithms.mazeGenerator.Cell;
import algorithms.mazeGenerator.Maze;
import algorithms.search.Solution;

public class MazeDisplay extends Canvas {

	Maze mazeData = null;
	Solution mazeSolution;

	public Maze getMazeData() {
		return mazeData;
	}

	public void setMazeData(Maze mazeData) {
		this.mazeData = mazeData;
	}

	Timer timer;
	TimerTask myTask;
	GameCharecter gameCharecter;

	public MazeDisplay(Composite parent, int style/* ,Maze m */) {
		super(parent, style);

		
	}

	public void startMazeDisplay() {
		setBackground(new Color(null, 255, 255, 255));

		Cell c = new Cell(mazeData.getStartState());
		gameCharecter = new GameCharecter(c.getCol(), c.getRow());

		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {

				e.gc.setForeground(new Color(null, 0, 0, 0));
				e.gc.setBackground(new Color(null, 0, 0, 0));

				int width = getSize().x;
				int height = getSize().y;

				int w = width / mazeData.getCols();
				int h = height / mazeData.getRows();

				gameCharecter.x = gameCharecter.x * w;
				gameCharecter.y = gameCharecter.y * h;

				for (int i = 0; i < mazeData.getRows(); i++)
					for (int j = 0; j < mazeData.getCols(); j++) {

						int x = j * w;
						int y = i * h;
						Cell c = mazeData.getCell(i, j);

						if (mazeSolution != null && mazeSolution.contains(c)) {

							new GameCharecter(c.getCol(), c.getRow())
							.paint(e, w, h, x, y);
						}
						if (c.getHasTopWall()) {
							e.gc.drawLine(x, y, x + w, y);
						}
						if (c.getHasBottomWall()) {
							e.gc.drawLine(x, y + h, x + w, y + h);
						}
						if (c.getHasLeftWall()) {
							e.gc.drawLine(x, y, x, y + h);
						}
						if (c.getHasRightWall()) {
							e.gc.drawLine(x + w, y, x + w, y + h);
						}

					}

				gameCharecter.paint(e, w, h);
			}
		});

	}

	public void start() {
		myTask = new TimerTask() {

			@Override
			public void run() {

				getDisplay().syncExec(new Runnable() {

					@Override
					public void run() {
						Random r = new Random();
						gameCharecter.x = r.nextInt(500);
						gameCharecter.y = r.nextInt(500);
						redraw();
					}
				});
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(myTask, 0, 500);
	}

	public void move(int x, int y) {

		gameCharecter.x = y;
		gameCharecter.y = x;
		redraw();

	}

	public void draw(Solution s) {
		// printSolution = true;
		mazeSolution = s;
		ArrayList<GameCharecter> x = new ArrayList<>();

		// GameCharecter gameChar new GameCharecter(x, y);
		redraw();
	}

	public void stop() {
		myTask.cancel();
		timer.cancel();
	}

	private Cell fromStringToCell(String s) {
		String[] strXY = s.split(",");
		int x = Integer.parseInt(strXY[0]);
		int y = Integer.parseInt(strXY[1]);

		return new Cell(x, y);
	}

}
