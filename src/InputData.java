import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/* clasa pentru validarea datelor introduse 
 * se pot introduce doar cifre
 */
public class InputData implements KeyListener {

	private JTextField _input; // variabila privata

	public InputData(JTextField input) {
		// TODO Auto-generated constructor stub
		this._input = input;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		/* cifre 0 - 9 si tasta backspace */
		if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			_input.setEditable(true);
		} else {
			/* daca se introduc alte caractere se dezactiveaza */
			_input.setEditable(false);
		} // else
	} // keyPressed

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	} // keyTyped

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	} // keyReleased

} // InputData
