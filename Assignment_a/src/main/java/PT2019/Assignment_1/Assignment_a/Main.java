package PT2019.Assignment_1.Assignment_a;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monom m1 = new Monom(5,3);
		Monom m2 = new Monom(-1,2);
		Monom m3 = new Monom(-6,1);
		Monom m4 = new Monom(9,0);
		LinkedList<Monom> polin = new LinkedList<Monom>();
		polin.add(m1);
		polin.add(m2);
		polin.add(m3);
		polin.add(m4);
		
		Polinom p = new Polinom(polin);
		System.out.println(p.toString());
		System.out.println(m2);
	}

}
