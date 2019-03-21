package MVC;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame{

	private static final long serialVersionUID = 1L;

	//patterns matching
	JPanel buttons = new JPanel();
	JPanel rightpanel = new JPanel();
	JPanel label1 = new JPanel();
	JPanel polinom1 = new JPanel();
	JPanel label2 = new JPanel();
	JPanel polinom2 = new JPanel();
	JPanel result = new JPanel();
	JPanel divResult = new JPanel();
	JPanel calculate = new JPanel();
	JPanel oppSelected = new JPanel();
	
	JButton calculateB = new JButton("Calculeaza");
	JButton addB = new JButton("+");
	JButton subB = new JButton("-");
	JButton divB = new JButton("/");
	JButton mulB = new JButton("*");
	JButton derB = new JButton("'");
	JButton itgB = new JButton("S");
	
	JTextField p1 = new JTextField(20);
	JTextField p2 = new JTextField(20);
	JTextField cat = new JTextField(20);
	JTextField rest = new JTextField(20);
	
	JLabel t1 = new JLabel("Polinomul 1", JLabel.CENTER);
	JLabel t2 = new JLabel("Polinomul 2", JLabel.CENTER);
	JLabel resultL = new JLabel("Rezultatul este", JLabel.CENTER);
	JLabel restL = new JLabel("Cu restul", JLabel.CENTER);
	JLabel oppSelL = new JLabel("Operatia selectata este:", JLabel.CENTER);
	JLabel oppSel2L = new JLabel("Impartire", JLabel.CENTER);
	
	public View() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		setSize(700,700);
		setVisible(true);
		addPanels();
		JOptionPane.showMessageDialog(this, "Ghid de utilizare:\n"
				+ "->Variabila utilizata este 'x'\n"
				+ "->Mai intai se selecteaza operatia, "
				+ "apoi se introduc polinoamele, \n"
				+ "in final apasandu-se butonul 'Calculeaza'"
				+ " pentru a se realiza operatia\n"
				+ "\nForme acceptate:\n"
				+ "->10*x^2\n"
				+ "->10x^2\n"
				+ "->10*x\n"
				+ "->10x\n"
				+ "->x^2\n"
				+ "->x\n"
				+ "->10\n");
	}
	
	private void addPanels() {
		addButtons();
		polinom1.add(t1,BorderLayout.SOUTH);
		polinom1.add(p1);
		polinom1.setLayout(new GridLayout(2,1));
		polinom2.setLayout(new GridLayout(2,1));
		polinom2.add(t2);
		polinom2.add(p2);
		
		result.add(resultL);
		result.add(cat);
		cat.setEditable(false);
		result.setLayout(new GridLayout(2,1));
		divResult.add(restL);
		rest.setEditable(false);
		divResult.add(rest);
		divResult.setLayout(new GridLayout(2,1));
		calculate.add(calculateB);
		oppSelected.setLayout(new GridLayout(2,1));
		oppSelected.add(oppSelL);
		oppSelected.add(oppSel2L);
		
		rightpanel.setLayout(new GridLayout(8,1));
		rightpanel.add(label2);
		rightpanel.add(polinom1);
		rightpanel.add(polinom2);
		rightpanel.add(label1);
		rightpanel.add(calculate);
		rightpanel.add(result);
		rightpanel.add(divResult);
		rightpanel.add(oppSelected);
		
		add(buttons);
		add(rightpanel);
	}
	
	private void addButtons() {
		buttons.setLayout(new GridLayout(6,1));
		buttons.setSize(175, 675);
		buttons.add(addB);
		buttons.add(subB);
		buttons.add(mulB);
		buttons.add(divB);
		buttons.add(derB);
		buttons.add(itgB);
	}
	
	public void badInput() {
		JOptionPane.showMessageDialog(this, "Input gresit!\nVa rugam incercati din nou!" );
	}
	
}
