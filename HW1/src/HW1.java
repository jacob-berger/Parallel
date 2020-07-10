import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;

import static java.lang.System.exit;
import static java.lang.System.in;

public class HW1 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	public static JTextArea output;
	private static Thread input;
	public String text = "";

	private HW1(String name) {
		super(name);
		output = new JTextArea(20, 30);
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		add(new JScrollPane(output));
		setSize(500, 500);
		setVisible(true);
		output.addKeyListener(this);
		input = new Thread();
	}

	public static void main(String[] args) {
		HW1 output = new HW1("Jacob Berger Homework 1");
		output.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit(0);
			}
		});

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == '\b' && text.length() != 0) {
			text = text.substring(0, text.length() - 1);
		}

		if (e.getKeyChar() != '\n' && e.getKeyChar() != '\b') {
			text += e.getKeyChar();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10 && text.length() != 0) {
			if (text.compareToIgnoreCase("exit") == 0) exit(0);
			if (input.isAlive()) input.interrupt();
			input = new Thread(new Input(text));
			input.start();
			text = "";
		} else {
			if (input.isAlive()) input.interrupt();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
