package PT2019.Assignment_1.Assignment_a;

import java.util.LinkedList;

import MVC.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m = new Model();
		View v = new View();
		Controller c = new Controller(v,m);
		Monom m5 = new Monom(1, 5);
		Monom m1 = new Monom(5,3);
		Monom m2 = new Monom(-1,2);
		Monom m3 = new Monom(-6,1);
		Monom m4 = new Monom(9,0);
		LinkedList<Monom> polin = new LinkedList<Monom>();
		LinkedList<Monom> polin2 = new LinkedList<Monom>();
		polin.add(m5);
		polin.add(m1);
		polin.add(m2);
		polin.add(m3);
		polin2.add(m4);
		polin2.add(m2);
		polin2.add(new Monom(-m1.getCoef(),m1.getPow()));
		
		Polinom p = new Polinom(polin);
		System.out.println(p.toString());
		Polinom p2 = new Polinom(polin2);
		System.out.println(p2);
		System.out.println(p.add(p2));
		System.out.println(p.sub(p2));
		System.out.println(p.mul(p2));
		System.out.println(p.mul(p2).der());
		System.out.println(p.mul(p2).der().itg());
		//System.out.println(m2);
		
		
	}

}
