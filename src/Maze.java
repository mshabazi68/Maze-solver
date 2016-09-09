import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main class to run a maze solver
 *
 */
public class Maze {
	// The thread that the solver runs in
	private static Thread solvingThread;

	/**
	 * The main program to create the user interface
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Maze solver");
		f.setSize(new Dimension(1500,1000));

		// Create the panel that will display the maze
		final TwoDimGrid componentsPanel = new TwoDimGrid();

		Container contentPane = f.getContentPane();
		contentPane.add(componentsPanel, BorderLayout.CENTER);

		// Solve button
		JPanel buttonPanel = new JPanel();
		JButton startButton = new JButton("Solve");
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Create a thread to animation the solution of the maze
				RecursiveMazeSolver solver = new RecursiveMazeSolver(componentsPanel);
				solvingThread = new Thread(solver);
				solvingThread.start();
			}
		});
		buttonPanel.add(startButton);

		// Button to create a new maze
		JButton newMazeButton = new JButton("New maze");
		newMazeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Stop the solving thread if there is one
				if (solvingThread != null && solvingThread.isAlive()) {
					solvingThread.interrupt();
				}

				// Create a new maze
				componentsPanel.newMaze();
			}

		});
		buttonPanel.add(newMazeButton);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		// Display the window.
		f.setVisible(true);

	}

}