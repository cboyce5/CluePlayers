package ClueGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ClueGame extends JFrame{
	private static Board board;
	private DetectiveNotesDialog dialog;
	public static int NUM_ROOMS = 11;
	public static int NUM_ROWS = 25;
	public static int NUM_COLUMNS = 25;
	
	public ClueGame() {
		board = new Board("layout.csv", "ClueLegend.txt");
		board.initialize();
		board.loadConfigFiles();
		setTitle("Clue Game");
		setSize(new Dimension(890,930));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		add(board, BorderLayout.CENTER);
	}
	
	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createNotesItem());
		menu.add(createFileExitItem());
		return menu;
	}
	
	private JMenuItem createNotesItem() {
		JMenuItem item = new JMenuItem("Show Notes");
		DetectiveNotesDialog dialog = new DetectiveNotesDialog();
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	public static void main(String[] args) {
		ClueGame game = new ClueGame();
		game.setVisible(true);
	}

}
