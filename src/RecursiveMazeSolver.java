
public class RecursiveMazeSolver implements Runnable {
	private static final int SLEEP_TIME = 8;
	private int[][] myPath = new int[1000][2];
	private int myInd = 0;
	int tempLocation = -1;
	// The maze
	private TwoDimGrid maze;

	/**
	 * Create a maze solver for a grid
	 */
	public RecursiveMazeSolver(TwoDimGrid m) {
		maze = m;
	}

	/**
	 * Here Find a path in the maze that will start at the top left and keep
	 * looking to the down to right corner of the maze. if we find a path and
	 * not blocked we will show it by different color.
	 */
	public boolean findMazePath() throws InterruptedException {
		
	}

	/**
	 * Find a path in the maze from position x, y
	 * 
	 * @param x
	 *            the x coordinate to solve from
	 * @param y
	 *            the y coordinate to solve from
	 * @return true if a path is found from here to the bottom right corner of
	 *         the maze
	 * @throws InterruptedException
	 *             if the thread that the solver is running in is interrupted
	 */
	private int findShortestPath(int x, int y, int start) {
		for (int i = start; i < 1000; i++) {
			if (x - 1 == myPath[i][0] && y == myPath[i][1] && i > start) {
				return i;
			}
			if (x + 1 == myPath[i][0] && y == myPath[i][1] && i > start) {
				return i;
			}
			if (x == myPath[i][0] && y - 1 == myPath[i][1] && i > start) {
				return i;
			}
			if (x == myPath[i][0] && y + 1 == myPath[i][1] && i > start) {
				return i;
			}
		}
		return -1;

	}

	private boolean findMazePath(int x, int y, int distance) throws InterruptedException {
		// Attempting to look at a non-existent location
		if (x < 0 || y < 0 || x >= maze.getNumCols() || y >= maze.getNumRows()) {
			return false;
		}

		// Attempting to go to a square that represents a wall
		else if (maze.isWall(x, y)) {
			return false;
		}

		// Already explored
		else if (maze.alreadyVisited(x, y)) {
			return false;
		}

		// Found the bottom right corner!
		else if (x == maze.getNumCols() - 1 && y == maze.getNumRows() - 1) {
			// Color the square to show that it is part of the solution.
			
				}
				tempLocation = findShortestPath(myPath[i][0], myPath[i][1], i + 1);
				maze.onPath(myPath[i][0], myPath[i][1]);
				if (tempLocation != -1)
					i = tempLocation;
				else
					i++;
			}
			/*
			 * maze.onPath (x, y); maze.setLabel(x, y, "" + distance);
			 * 
			 * Thread.sleep(SLEEP_TIME);
			 */
			return true;
		}

		else {
			// Color this square to indicate it is being explored. Sleep so user
			// can see the maze update.
			maze.explore(x, y);
			maze.setLabel(x, y, "" + distance);
			Thread.sleep(SLEEP_TIME);
			myPath[myInd][0] = x;
			myPath[myInd][1] = y;
			myInd++;
			
				return true;
			}

			else {
				// None of the 4 paths worked out. Color this square as a dead
				// end. Sleep
				// so the user sees the animation.
				myInd--;
				myPath[myInd][0] = -1;
				myPath[myInd][1] = -1;
				maze.deadEnd(x, y);
				Thread.sleep(SLEEP_TIME);
				return false;
			}
		}
	}

	/**
	 * Solve the maze.
	 */
	public void run() {
		try {
			findMazePath();
		} catch (InterruptedException e) {
			// Thread stops.
		}
	}
}