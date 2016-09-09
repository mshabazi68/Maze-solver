import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 */
public class TwoDimGrid extends JPanel {
	// Size of the maze
	private static final int NUM_ROWS =60;
	private static final int NUM_COLS = 60;
	
	// Indicates a wall
	private static final Color WALL = Color.BLACK;
	
	// Indicates a cell that was searched but did not lead to a path
	private static final Color FAILED = new Color (182, 27, 32);
	
	// Indicates an unexplored area
	private static final Color UNEXPLORED = Color.LIGHT_GRAY;
	
	// Indicates a cell known to be on the path out
	private static final Color PATH = new Color(102, 242, 70);
	
	// Indicates a cell on a path that is being explored.
	private static final Color TENTATIVE = Color.BLUE;
	
	// Indicates a cell that has been found but not yet explored
	private static final Color FOUND = new Color(207, 102, 33);
	
	// The cells that make up the maze
	private JPanel[][] grid = new JPanel[NUM_ROWS][NUM_COLS];
	
	private JLabel[][] labels = new JLabel[NUM_ROWS][NUM_COLS];
	
	// Random number generator to help decide where to put the walls.
	private Random colorGen = new Random();
	
	private boolean showLabels = false;
	
	/**
	 * Creates and displays a new maze.
	 */
	public TwoDimGrid() {
		initGrid();
		newMaze();
	}
	
	public TwoDimGrid(TwoDimGrid original) {
		initGrid();
		copyMaze(original);
	}

	private void initGrid() {
		
	}

	/**
	 * Generates a new maze
	 */
	public void newMaze() {
		
		}
	
		// Make sure starting and ending cells are visitable
		grid[0][0].setBackground(UNEXPLORED);
		grid[NUM_ROWS-1][NUM_COLS-1].setBackground(UNEXPLORED);
	}

	public void copyMaze(TwoDimGrid original) {
		
			}
		}
	
		// Make sure starting and ending cells are visitable
		grid[0][0].setBackground(UNEXPLORED);
		grid[NUM_ROWS-1][NUM_COLS-1].setBackground(UNEXPLORED);
		
	}

	/**
	 * Randomly select whether to put a wall or hallway
	 * @return
	 */
	private Color getRandomColor() {
		// 70% of the time we select a hallway
		int next = colorGen.nextInt(10);
		if (next <= 6) {
			return UNEXPLORED;
		}
		return WALL;
	}

	/**
	 * 
	 * @return number of rows in the maze
	 */
	public int getNumRows() {
	
	}

	/**
	 * 
	 * @return number of columns in the maze
	 */
	public int getNumCols() {
		
	}

	/**
	 * 
	 * @param x row of maze
	 * @param y column of maze
	 * @return true if there is a wall at (row, column)
	 */
	public boolean isWall(int x, int y) {
		return grid[x][y].getBackground() == WALL;
	}

	/**
	 * 
	 * @param x row of maze
	 * @param y column of maze
	 * @return true if the cell at (x, y) has already been explored
	 */
	public boolean alreadyVisited(int x, int y) {

	}

	/**
	 * Mark the cell at (x, y) as being on the solution path 
	 * @param x row of maze
	 * @param y column of maze
	 */
	public void onPath(int x, int y) {
		grid[x][y].setBackground(PATH);		
	}

	/**
	 * Mark the cell at (x, y) as being under exploration
	 * @param x row of maze
	 * @param y column of maze
	 */
	public void explore(int x, int y) {
		grid[x][y].setBackground(TENTATIVE);		
	}

	/**
	 * Mark the cell at (x, y) as being a dead end
	 * @param x row of maze
	 * @param y column of maze
	 */
	public void deadEnd(int x, int y) {
		grid[x][y].setBackground(FAILED);		
	}
	
	/**
	 * Mark the cell at (x, y) as being found but not yet explored
	 * @param x row of the maze
	 * @param y column of the maze
	 */
	public void found(int x, int y) {
		grid[x][y].setBackground(FOUND);
	}

	public void setLabel(int x, int y, String s) {
		if (showLabels) {
			labels[x][y].setText(s);
		}
	}

	public void showLabels(boolean show) {
		showLabels = show;
	}


}