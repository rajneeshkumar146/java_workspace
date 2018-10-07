package aug3;

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
	private JLabel lblTimer;
	private JLabel lblScore;
	private JLabel lblWord;
	private JTextField txtWord;
	private JButton btnStart;
	private JButton btnStop;

	Timer timer = null;
	int timeRemaining = 0;
	int score = 0;
	boolean running = false;

	String[] words = null;

	public TypingTutor(String[] words) {
		this.words = words;

		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		Font font = new Font("Comic Sans MS", 1, 150);

		lblTimer = new JLabel("Timer");
		lblTimer.setFont(font);
		super.add(lblTimer);

		lblScore = new JLabel("Score");
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

		super.setTitle("Typing Tutor");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setVisible(true);

		setupthegame();
	}

	private void setupthegame() {
		timer = new Timer(2000, this);
		timeRemaining = 50;
		score = 0;
		running = false;

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
		if (e.getSource() == btnStart) {
			handleStart();
		} else if (e.getSource() == btnStop) {
			handleStop();
		} else if (e.getSource() == timer) {
			handleTimer();
		}
	}

	private void handleTimer() {
		if (timeRemaining > 0) {
			timeRemaining--;

			String actual, expected;
			expected = lblWord.getText();
			actual = txtWord.getText();
			if (actual.length() > 0 && actual.equals(expected)) {
				score++;
			}

			lblTimer.setText("Time: " + timeRemaining);
			lblScore.setText("Score: " + score);

			int ridx = (int) (Math.random() * words.length);
			lblWord.setText(words[ridx]);

			txtWord.setText("");
		} else {
			handleStop();
		}
	}

	private void handleStop() {
		timer.stop();
		
		int choice = JOptionPane.showConfirmDialog(this, "Restart?");
		if(choice == JOptionPane.YES_OPTION){
			setupthegame();
		} else if(choice == JOptionPane.NO_OPTION){
			super.dispose();
		} else if(choice == JOptionPane.CANCEL_OPTION){
			timer.start();
		}
	}

	private void handleStart() {
		if (running == false) {
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
