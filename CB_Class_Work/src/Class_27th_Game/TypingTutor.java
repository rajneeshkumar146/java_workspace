package Class_27th_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.activation.Activatable;

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

	private Timer time;
	private int timeremaning = 0;
	private boolean running = false;
	private int Score = 0;

	private String[] word = null;

	public TypingTutor(String[] args) {
		this.word = args;
		GridLayout layout = new GridLayout(3, 2);
		super.setLayout(layout);

		Font font = new Font("Comic Sans MS", 1, 150);

		lblTimer = new JLabel("Timer");
		lblTimer.setFont(font);
		lblTimer.setOpaque(true);
		lblTimer.setBackground(Color.GREEN);
		super.add(lblTimer);

		lblScore = new JLabel("Score");
		lblScore.setFont(font);
		lblScore.setOpaque(true);
		lblScore.setBackground(Color.ORANGE);
		super.add(lblScore);

		lblWord = new JLabel("Word");
		lblWord.setFont(font);
		lblWord.setOpaque(true);
		lblWord.setBackground(Color.yellow);
		super.add(lblWord);

		txtWord = new JTextField();
		txtWord.setFont(font);
		txtWord.setBackground(Color.white);
		super.add(txtWord);

		btnStart = new JButton("Start");
		btnStart.setFont(font);
		btnStart.setBackground(Color.PINK);
		btnStart.addActionListener(this);
		super.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setFont(font);
		btnStop.setBackground(Color.magenta);
		btnStop.addActionListener(this);
		super.add(btnStop);

		super.setTitle("Typing Tutor");
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setVisible(true);

		resetupgame();
	}

	public void resetupgame() {

		time = new Timer(2000, this);
		timeremaning = 50;
		running = false;
		Score = 0;

		btnStart.setText("Start");
		btnStop.setText("Stop");
		lblWord.setText("");
		lblScore.setText("Score: " + Score);
		lblTimer.setText("Time: " + timeremaning);

		txtWord.setEnabled(false);
		btnStop.setEnabled(false);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			handelStart();

		} else if (e.getSource() == btnStop) {
			handelStop();

		} else if (e.getSource() == time) {
			handeltimer();
		}

	}

	private void handeltimer() {
		timeremaning--;
		String actual = txtWord.getText();
		String expected = lblWord.getText();
		if (expected.length() > 0 && actual.equals(expected)) {
			Score++;
		}

		lblScore.setText("Score: " + Score);

		if (timeremaning == -1) {
			handelStop();
		} else {
			lblTimer.setText("Timer: " + timeremaning);
			int idx = (int) (Math.random() * word.length);
			lblWord.setText(word[idx]);
			txtWord.setText("");
		}

	}

	private void handelStop() {
		time.stop();
		int choice = JOptionPane.showConfirmDialog(this, "Stop = " + Score + ". Replay");

		if (choice == JOptionPane.YES_OPTION) {
			resetupgame();
		} else if (choice == JOptionPane.NO_OPTION) {
			super.dispose();
		} else {
			if (timeremaning == -1) {
				resetupgame();
			} else {
				time.start();
			}

		}

	}

	private void handelStart() {
		if (running == true) {
			time.stop();
			running = false;
			btnStart.setText("resume");

			txtWord.setEnabled(false);
			btnStop.setEnabled(false);

		} else {

			time.start();
			running = true;
			btnStart.setText("Pause");

			txtWord.setEnabled(true);
			btnStop.setEnabled(true);

		}
	}

}
