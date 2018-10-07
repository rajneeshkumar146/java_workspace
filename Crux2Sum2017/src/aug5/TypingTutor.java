package aug5;

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
	private Timer timer = null;
	private boolean running = false;
	private int timeRemaining = 0;
	private int score = 0;

	private JLabel lblTimer;
	private JLabel lblScore;
	private JLabel lblWord;
	private JTextField txtWord;
	private JButton btnStart;
	private JButton btnStop;

	private String[] words = null;

	public TypingTutor(String[] args) {
		this.words = args;

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

		resetTheGame();
	}

	public void resetTheGame() {
		timer = new Timer(2000, this);
		running = false;
		timeRemaining = 50;
		score = 0;

		lblTimer.setText("Timer: " + timeRemaining);
		lblScore.setText("Score: " + score);
		lblWord.setText("");
		txtWord.setText("");
		btnStart.setText("Start");
		btnStop.setText("Stop");

		txtWord.setEnabled(false);
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

	private void handleStart() {
		if (running == true) {
			timer.stop();
			running = false;
			btnStart.setText("Resume");
			txtWord.setEnabled(false);
			btnStop.setEnabled(false);
		} else {
			timer.start();
			running = true;
			btnStart.setText("Pause");
			txtWord.setEnabled(true);
			btnStop.setEnabled(true);
		}
	}

	private void handleStop() {
		timer.stop();

		int choice = JOptionPane.showConfirmDialog(this, "Score = " + score + ". Replay?");

		if (choice == JOptionPane.YES_OPTION) {
			resetTheGame();
		} else if (choice == JOptionPane.NO_OPTION) {
			super.dispose();
		} else {
			if (timeRemaining == -1) {
				resetTheGame();
			} else {
				timer.start();
			}
		}
	}

	private void handleTimer() {
		timeRemaining--;

		String wanted = lblWord.getText();
		String real = txtWord.getText();

		if (wanted.length() > 0 && wanted.equals(real)) {
			score++;
		}

		lblScore.setText("Score: " + score);

		if (timeRemaining == -1) {
			handleStop();
		} else {
			lblTimer.setText("Timer: " + timeRemaining);
			txtWord.setText("");

			int ridx = (int) (Math.random() * words.length);
			lblWord.setText(words[ridx]);
		}
	}
}
