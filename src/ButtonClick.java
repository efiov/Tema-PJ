import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonClick implements ActionListener {

	// variabile private
	private JTextField _a; // ipotenuza
	private JTextField _b; // cateta 2
	private JTextField _c; // cateta 1
	private JLabel[] _labels;

	// constructor cu 5 parametrii
	public ButtonClick(JTextField a, JTextField b, JTextField c, JLabel[] labels) {
		/* a = ipotenuza, b = cateta, c = cateta, labels = vector de componente */
		this._a = a;
		this._b = b;
		this._c = c;
		this._labels = labels;
	} // ButtonClick

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// textul introdus in JTextField
		String input3 = this._a.getText();
		String input2 = this._b.getText();
		String input1 = this._c.getText();
		// variabile intregi care retin valoare introdusa
		int a = 0, b = 0, c = 0;
		// variabile boolene care retin daca a fost sau nu introdus un camp
		boolean c1 = false, c2 = false, c3 = false;
		if (input3.length() > 0) {
			// dimensiune cateta
			a = Integer.parseInt(this._a.getText());
			c3 = true;
		} // if
		if (input2.length() > 0) {
			// dimeniune cateta
			b = Integer.parseInt(this._b.getText());
			c2 = true;
		} // if
		if (input1.length() > 0) {
			// dimensiune cateta
			c = Integer.parseInt(this._c.getText());
			c1 = true;
		} // if
		if (c1 && c2 && !c3) {
			// sunt introduse dimensiunele catetelor si se calculeaza ipotenuza
			int x = (int) Math.sqrt(b * b + c * c); // valoarea ipotenuzei
			this._a.setText(String.valueOf(x)); // se completeaza rezultatul
			// se afiseaza modul cum s-a calculat rezultatul in partea dreapta
			this._labels[0]
					.setText("<html>BC<sup>2</sup>=&nbsp;AB<sup>2</sup>&nbsp;+&nbsp;AC<sup>2</sup>&nbsp;=</html>");
			this._labels[1].setText("       = " + String.valueOf(c) + " * " + String.valueOf(c) + " + "
					+ String.valueOf(b) + " * " + String.valueOf(b) + " =");
			this._labels[2].setText("       = " + String.valueOf(c * c) + " + " + String.valueOf(b * b) + " = "
					+ String.valueOf(c * c + b * b));
			this._labels[3].setText("BC = " + "rad(" + String.valueOf(c * c + b * b) + ") =>");
			this._labels[4].setText("BC = " + x);
		} // if
		if (c1 && !c2 && c3) {
			// este introdusa dimensiunea unei catete si a ipotenuzei
			int x = (int) Math.sqrt(a * a - c * c); // valoarea catetei 2
			this._b.setText(String.valueOf(x));
			// se afiseaza modul cum s-a calculat rezultatul in partea dreapta
			this._labels[0]
					.setText("<html>AC<sup>2</sup>=&nbsp;BC<sup>2</sup>&nbsp;-&nbsp;AB<sup>2</sup>&nbsp;=</html>");
			this._labels[1].setText("       = " + String.valueOf(a) + " * " + String.valueOf(a) + " - "
					+ String.valueOf(c) + " * " + String.valueOf(c) + " =");
			this._labels[2].setText("       = " + String.valueOf(a * a) + " - " + String.valueOf(c * c) + " = "
					+ String.valueOf(a * a - c * c));
			this._labels[3].setText("AC = " + "rad(" + String.valueOf(a * a - c * c) + ") =>");
			this._labels[4].setText("AC = " + x);
		} // if
		if (!c1 && c2 && c3) {
			// este introdusa dimensiunea unei catete si a ipotenuzei
			int x = (int) Math.sqrt(a * a - b * b);
			this._c.setText(String.valueOf(x)); // valoarea catetei 2
			// se afiseaza modul cum s-a calculat rezultatul in partea dreapta
			this._labels[0]
					.setText("<html>AB<sup>2</sup>=&nbsp;BC<sup>2</sup>&nbsp;-&nbsp;AC<sup>2</sup>&nbsp;=</html>");
			this._labels[1].setText("       = " + String.valueOf(a) + " * " + String.valueOf(a) + " - "
					+ String.valueOf(b) + " * " + String.valueOf(b) + " =");
			this._labels[2].setText("       = " + String.valueOf(a * a) + " - " + String.valueOf(b * b) + " = "
					+ String.valueOf(a * a - b * b));
			this._labels[3].setText("AC = " + "rad(" + String.valueOf(a * a - b * b) + ") =>");
			this._labels[4].setText("AC = " + x);
		} // if
		if (!c1 && !c2 && !c3) {
			// fara date introduse
			for (int i = 0; i < 5; i++) {
				this._labels[i].setText("");
			} // for
			this._labels[0].setText("Date invalide");
		} // if
		if (c1 && !c2 && !c3) {
			// este introdusa doar o latura
			for (int i = 0; i < 5; i++) {
				// se sterge continutul
				this._labels[i].setText("");
			} // for
				// se afiseaza mesaj de eroare
			this._labels[0].setText("Date invalide");
		} // if
		if (!c1 && c2 && !c3) {
			// este introdusa doar o latura
			for (int i = 0; i < 5; i++) {
				this._labels[i].setText("");
			}
			this._labels[0].setText("Date invalide");
		} // if
		if (!c1 && !c2 && c3) {
			// este introdusa doar o latura
			for (int i = 0; i < 5; i++) {
				this._labels[i].setText("");
			} // for
			this._labels[0].setText("Date invalide");
		} // if
	} // actionPerformed
} // ButtonClick
