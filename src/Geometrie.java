import java.awt.*;
import javax.swing.*;

public class Geometrie {

	public static void main(String[] args) {

		// fereastra principala
		JFrame window = new JFrame("Pitagora"); // crearea intantei JFrame
		ImageIcon windowIcon = new ImageIcon("src/Images/icon.png"); // pictograma fereastra
		window.setIconImage(windowIcon.getImage()); // adauga pictograma pe bara de titlu
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la aparea pe x inchide instanta
		window.setSize(600, 400); // dimensiuni fereastra 600x400
		window.setResizable(false); // dezactivare buton maximizare
		window.getContentPane().setLayout(null); // fara manageri de aspect
		window.setLocationRelativeTo(null); // deschide fereastra in centrul ecranului

		// titlu afisat
		JLabel title = new JLabel("Teorema lui Pitagora", SwingConstants.CENTER);
		title.setForeground(Color.darkGray);
		title.setOpaque(true);
		title.setLocation(150, 0);
		title.setSize(300, 35);
		title.setFont(new Font("Serif", Font.BOLD, 24));
		window.getContentPane().add(title);

		// imagine triunghi
		JLabel img = new JLabel(); // crearea intantei JLabel
		img.setIcon(new ImageIcon("src/Images/triangle.png"));
		Dimension imgSize = img.getPreferredSize(); // afisare imagine completa
		img.setBounds(100, 70, imgSize.width, imgSize.height); // pozite pe ferastra
		window.getContentPane().add(img);
		// notatie A
		JLabel a = new JLabel();
		a.setIcon(new ImageIcon("src/Images/a.png"));
		Dimension aSize = a.getPreferredSize();
		a.setBounds(90, 240, aSize.width, aSize.height);
		window.getContentPane().add(a);
		// notatie B
		JLabel b = new JLabel();
		b.setIcon(new ImageIcon("src/Images/b.png"));
		Dimension bSize = b.getPreferredSize();
		b.setBounds(250, 240, bSize.width, bSize.height);
		window.getContentPane().add(b);
		// notatie C
		JLabel c = new JLabel();
		c.setIcon(new ImageIcon("src/Images/c.png"));
		Dimension cSize = c.getPreferredSize();
		c.setBounds(85, 45, cSize.width, cSize.height);
		window.getContentPane().add(c);

		// afisare rezultate
		JLabel[] results = new JLabel[5];
		int y = 50; // coordonata initiala y
		/*
		 * sunt 5 randuri pe care se afiseaza cate un rezultat diferit pentur fiecare
		 * rand se creaza un nou JLabel cu atributii individuale fiecare JLabel se
		 * adauga intr-un array de tip JLabel -> results
		 */
		for (int i = 0; i < 5; i++) {
			JLabel result = new JLabel();
			/* ca pozitie sunt aranjate una sub cealalta */
			result.setBounds(350, y, 200, 25);
			y += 30; // urmatorul rand se muta mai jos pe fereastra
			/* atributii comune */
			result.setOpaque(true);
			result.setForeground(Color.darkGray);
			result.setFont(new Font("Serif", Font.BOLD, 16));
			/* se adauga fiecare element pe fereastra principala */
			window.getContentPane().add(result);
			/* se adauga in array */
			results[i] = result;
		}

		// introducere date
		// cateta 1 - AB
		JTextField input1 = new JTextField();
		input1.setBounds(160, 260, 60, 25);
		input1.setToolTipText("Dimensiune cateta 1");
		input1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		input1.setForeground(Color.DARK_GRAY);
		input1.addKeyListener(new InputData(input1));
		window.getContentPane().add(input1);
		// cateta 2 - AC
		JTextField input2 = new JTextField();
		input2.setBounds(50, 155, 60, 25);
		input2.setToolTipText("Dimensiune cateta 2");
		input2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		input2.setForeground(Color.DARK_GRAY);
		input2.addKeyListener(new InputData(input2));
		window.getContentPane().add(input2);
		// ipotenuza - BC
		JTextField input3 = new JTextField();
		input3.setBounds(200, 140, 60, 25);
		input3.setToolTipText("Dimensiune ipotenuza");
		input3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		input3.setForeground(Color.DARK_GRAY);
		input3.addKeyListener(new InputData(input3));
		window.getContentPane().add(input3);

		// buton calculare solutie
		JButton btn = new JButton("Calculeaza");
		btn.setBounds(60, 320, 250, 30);
		// eveniment apasa pe buton
		btn.addActionListener(new ButtonClick(input3, input2, input1, results));
		window.getContentPane().add(btn);

		window.setVisible(true); // fereastra vizibila
	} // main
} // Geometrie