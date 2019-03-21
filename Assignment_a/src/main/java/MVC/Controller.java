package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import PT2019.Assignment_1.Assignment_a.Polinom;

public class Controller {
	private Model model;
	private View view;

	public Controller(View v, Model m) {
		view = v;
		model = m;
		addListeners();
	}

	private static enum opp {
		ADD, SUB, MUL, DIV, DER, ITG
	};

	private static opp selectedOpperation = opp.DIV;

	protected void addListeners() {
		view.addB.addActionListener(new AddListener());
		view.subB.addActionListener(new SubListener());
		view.mulB.addActionListener(new MulListener());
		view.divB.addActionListener(new DivListener());
		view.derB.addActionListener(new DerListener());
		view.itgB.addActionListener(new ItgListener());
		view.calculateB.addActionListener(new CalcListener());
	}

	class AddListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.divResult.setVisible(false);
			view.polinom2.setVisible(true);
			view.t1.setText("Polinomul 1:");
			view.oppSel2L.setText("Adunare");
			selectedOpperation = opp.ADD;
		}

	}

	class SubListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.divResult.setVisible(false);
			view.polinom2.setVisible(true);
			view.t1.setText("Polinomul 1:");
			view.oppSel2L.setText("Scadere");
			selectedOpperation = opp.SUB;
		}

	}

	class MulListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.divResult.setVisible(false);
			view.polinom2.setVisible(true);
			view.t1.setText("Polinomul 1:");
			view.oppSel2L.setText("Inmultire");
			selectedOpperation = opp.MUL;
		}

	}

	class DivListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.divResult.setVisible(true);
			view.polinom2.setVisible(true);
			view.t1.setText("Polinomul 1:");
			view.oppSel2L.setText("Impartire");
			selectedOpperation = opp.DIV;
		}

	}

	class DerListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.divResult.setVisible(false);
			view.polinom2.setVisible(false);
			view.t1.setText("Polinomul:");
			view.oppSel2L.setText("Derivare");
			selectedOpperation = opp.DER;
		}
	}

	class ItgListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			view.divResult.setVisible(false);
			view.polinom2.setVisible(false);
			view.t1.setText("Polinomul:");
			view.oppSel2L.setText("Integrare");
			selectedOpperation = opp.ITG;
		}
	}

	class CalcListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Polinom p1;
			Polinom p2;
			try {
				switch (selectedOpperation) {
				case ADD:
					p1 = model.convert(view.p1.getText());
					p2 = model.convert(view.p2.getText());
					Collections.sort(p1.getPolin());
					Collections.sort(p2.getPolin());
					view.cat.setText(p1.add(p2).toString());
					break;
				case SUB:
					p1 = model.convert(view.p1.getText());
					p2 = model.convert(view.p2.getText());
					Collections.sort(p1.getPolin());
					Collections.sort(p2.getPolin());
					view.cat.setText(p1.sub(p2).toString());
					break;
				case MUL:
					p1 = model.convert(view.p1.getText());
					p2 = model.convert(view.p2.getText());
					Collections.sort(p1.getPolin());
					Collections.sort(p2.getPolin());
					view.cat.setText(p1.mul(p2).toString());
					break;
				case DIV:
					p1 = model.convert(view.p1.getText());
					p2 = model.convert(view.p2.getText());
					Collections.sort(p1.getPolin());
					Collections.sort(p2.getPolin());
					Polinom p3 = new Polinom(p1);
					view.cat.setText(p3.div(p2).toString());
					view.rest.setText(p3.toString());
					break;
				case DER:
					p1 = model.convert(view.p1.getText());
					Collections.sort(p1.getPolin());
					view.cat.setText(p1.der().toString());
					break;
				case ITG:
					p1 = model.convert(view.p1.getText());
					Collections.sort(p1.getPolin());
					view.cat.setText(p1.itg().toString());
					break;
				}
			}
			catch(Exception exception) {
				view.badInput();
			}
		}

	}
}
