import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	/**
	 * @wbp.nonvisual location=-17,14
	 */
	private final JPanel panel = new JPanel();
	private JTextField txtGuess;
	private JLabel lblDescription;
	private JButton btnGuess;
	private JLabel lblOutput;
	private int count;
	
	private int theNumber;
	
	public GuessingGame() {
		setTitle("Jie's Guessing Game");
		getContentPane().setLayout(null);
		
		lblDescription = new JLabel("Please enter a number between 1 and 100:");
		lblDescription.setBounds(64, 96, 260, 16);
		getContentPane().add(lblDescription);
		
		btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(156, 152, 97, 25);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("enter a number above, and press Guess");
		lblOutput.setBounds(96, 211, 272, 16);
		getContentPane().add(lblOutput);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(316, 93, 63, 19);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
	
	public void checkGuess() {
        String guessText = txtGuess.getText();
        String message = "";
        count++;
        int guess = Integer.parseInt(guessText);
        if (guess < theNumber)
            message = guess + " is too low. Try again.";
        else if (guess > theNumber)
            message = guess + " is too high. Try again.";
        else {
            message = guess + " is correct. You win!" + " You tried " + count + " times.";
            newGame();
        }
        lblOutput.setText(message);
    }
	
	public void newGame() {
        theNumber = (int) (Math.random() * 100 + 1);
    }
}
