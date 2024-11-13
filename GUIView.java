import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class GUIView extends JFrame {
    private static LibrarySetup mainLibrary = new LibrarySetup();
	private JPanel panel;
	private JLabel statusLabel;
	private JLabel countLabel;
	
	public GUIView() {
		setUp();
	}
	
	private void setUp() {
		//setting size of frame
		this.setSize(400,400);
		
		//setting up the status label
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(350,100);
		this.add(statusLabel);
		
		//setting up the count label
		countLabel = new JLabel("",JLabel.LEFT);
		countLabel.setSize(350,100);
		this.add(countLabel);
		
		//adding the panel
		panel = new JPanel();
		this.add(panel);

        JButton searchButton = new JButton("Search");
        JButton addBookButton = new JButton("Add Book");
        JButton setBookButton = new JButton("Set Book to Read");
        JButton rateButton = new JButton("Rate Book");
        JButton getBooksButton = new JButton("Get Books");
        JButton suggestButton = new JButton("Suggest Read");
        JButton addBooksButton = new JButton("Add Books");
        JButton exitButton = new JButton("Exit");

        // Add all buttons to panel.
        panel.add(searchButton);
        panel.add(addBookButton);
        panel.add(setBookButton);
        panel.add(rateButton);
        panel.add(getBooksButton);
        panel.add(suggestButton);
        panel.add(addBooksButton);
        panel.add(exitButton);
		
		//adding a window listener for closing the app
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}
	
	private void start() {
		//setting up the search button
		JButton searchButton = new JButton("Search");
		searchButton.setActionCommand("toggle");
		searchButton.addActionListener(new ButtonClickListener());
		panel.add(searchButton);
        
	}
	
	//Listener for the two buttons
	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if(command.equals("Search")) {
				mainLibrary.search();
				statusLabel.setText(model.getStatus().toString());
				updateCount(model.getCount() == -1);
			} else if(command.equals("count")) {
				model.toggleCount();
				updateCount(model.getCount() == -1);
			}
		}
		
		private void updateCount(boolean isOff) {
			if(isOff) {
				countLabel.setText("");
			} else {
				countLabel.setText("count: " + model.getCount());
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		GUIView view = new GUIView();
		//view.start();
		view.setVisible(true);
	}
}