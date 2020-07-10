import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;

public class Display extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	public static JTextArea output;
	private static Thread t1, t2;
	
	public Display(String name) {
		super(name);
		output = new JTextArea(20, 30);
		DefaultCaret caret = (DefaultCaret)output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		add(new JScrollPane(output));
		setSize(500, 500);
		setVisible(true);
		output.addKeyListener(this);
		
	}

	public static void main(String[] args) {
		
		Display display = new Display("Jacob Berger Lab 1");
		display.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		t1 = new Thread(new Message("Thread 1"));
		t2 = new Thread(new Message("Thread 2"));
		
		t1.start();
		t2.start();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (t1.isAlive()) {
			t1.interrupt();
			output.append("Thread-1 Gets Interrupted! Terminate!\n");
		} else if (t2.isAlive()) {
			t2.interrupt();
			output.append("Thread-2 Gets Interrupted! Terminate!\n");
		}
		
		if (!t1.isAlive() && !t2.isAlive()) {
			output.append("All Threads are interrupted.\n");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
