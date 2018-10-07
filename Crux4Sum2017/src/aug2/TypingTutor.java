package aug2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypingTutor extends JFrame implements ActionListener {
	JLabel lblTimer;
	JLabel lblScore;
	JLabel lblWord;
	JTextField txtWord;
	JButton btnStart;
	JButton btnStop;
	
	boolean running = false;
	int timeRemaining = 0;
	int score = 0;
	Timer timer = null;
	String[] words = null;

	public TypingTutor(String[] words) {
		this.words = words;
		
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);
		
		Font font = new Font("Comic Sans MS", 1, 150);

		lblTimer = new JLabel("Timer:");
		lblTimer.setFont(font);
		super.add(lblTimer);

		lblScore = new JLabel("Score:");
		lblScore.setFont(font);
		super.add(lblScore);

		lblWord = new JLabel("");
		lblWord.setFont(font);
		super.add(lblWord);

		txtWord = new JTextField();
		txtWord.setFont(font);
		super.add(txtWord);

		btnStart = new JButton("Start");
		btnStart.setFont(font);
		btnStart.addActionListener(this);
		super.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setFont(font);
		btnStop.addActionListener(this);
		super.add(btnStop);

		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setTitle("Typing Tutor");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setVisible(true);
		
		setupTheGame();
	}

	private void setupTheGame() {
		running = false;
		timeRemaining = 50;
		score = 0;
		timer = new Timer(2000, this);
		
		lblTimer.setText("Time: " + timeRemaining);
		lblScore.setText("Score: " + score);
		lblWord.setText("");
		
		txtWord.setText("");
		txtWord.setEnabled(false);
		
		btnStart.setText("Start");
		
		btnStop.setText("Stop");
		btnStop.setEnabled(false);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStart){
			handleStartClick();
		} else if(e.getSource() == btnStop){
			handleStopClick();
		} else if(e.getSource() == timer){
			handleTimeElapsed();
		}
	}

	private void handleTimeElapsed() {
		if(timeRemaining > 0){
			timeRemaining--;
			
			String actual = txtWord.getText();
			String expected = lblWord.getText();
			if(expected.length() > 0 && actual.equals(expected)){
				score++;
			}
			
			lblTimer.setText("Time: " + timeRemaining);
			lblScore.setText("Score: " + score);
			
			int randomIdx = (int)(Math.random() * words.length);
			lblWord.setText(words[randomIdx]);
			
			txtWord.setText("");
			txtWord.setFocusable(true);
		} else {
			handleStopClick();
		}
	}

	private void handleStopClick() {
		timer.stop();
		
		int choice = JOptionPane.showConfirmDialog(this, "Restart?");
		if(choice == JOptionPane.YES_OPTION){
			setupTheGame();
		} else {
			super.dispose();
		}
	}

	private void handleStartClick() {
		if(running == false){
			running = true;
			timer.start();
			txtWord.setEnabled(true);
			btnStart.setText("Pause");
			btnStop.setEnabled(true);
		} else {
			running = false;
			timer.stop();
			txtWord.setEnabled(false);
			btnStart.setText("Start");
		}
	}


}
