import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class GUIView extends JFrame {
    private static LibrarySetup mainLibrary = new LibrarySetup();
	private JPanel panel;
	private JTextField textField;
	private JTextArea textArea;
	
	public GUIView() {
		setUp();
	}
	
	private void setUp() {
		//setting size of frame
		this.setSize(400,400);
		
		//setting up the status label
		textField = new JTextField("",JTextField.CENTER);
		textField.setSize(350,100);
		this.add(textField);
		
		//setting up the count label
		textArea = new JTextArea(10, 10);
		textArea.setSize(350,100);
		this.add(textArea);
		
		//adding the panel
		panel = new JPanel();
		this.add(panel);
		
		//adding a window listener for closing the app
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}
	
	private void start() {

		//setting up the required buttons.
        JButton searchButton = new JButton("Search");
        searchButton.setActionCommand("search");
        searchButton.addActionListener(new ButtonClickListener());
        panel.add(searchButton);
        JButton addBookButton = new JButton("Add Book");
        addBookButton.setActionCommand("addBook");
        addBookButton.addActionListener(new ButtonClickListener());
        panel.add(addBookButton);
        JButton setBookButton = new JButton("Set Book to Read");
        setBookButton.setActionCommand("set");
        setBookButton.addActionListener(new ButtonClickListener());
        panel.add(setBookButton);
        JButton rateButton = new JButton("Rate Book");
        rateButton.setActionCommand("rate");
        rateButton.addActionListener(new ButtonClickListener());
        panel.add(rateButton);
        JButton getBooksButton = new JButton("Get Books");
        getBooksButton.setActionCommand("get");
        getBooksButton.addActionListener(new ButtonClickListener());
        panel.add(getBooksButton);
        JButton suggestButton = new JButton("Suggest Read");
        suggestButton.setActionCommand("suggest");
        suggestButton.addActionListener(new ButtonClickListener());
        panel.add(suggestButton);
        JButton addBooksButton = new JButton("Add Books");
        addBooksButton.setActionCommand("addBooks");
        addBooksButton.addActionListener(new ButtonClickListener());
        panel.add(addBooksButton);
        JButton exitButton = new JButton("Exit");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(new ButtonClickListener());
        panel.add(exitButton);
        
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
	}
	
	//main method
	public static void main(String[] args) {
		GUIView view = new GUIView();
		//view.start();
		view.setVisible(true);
	}
}