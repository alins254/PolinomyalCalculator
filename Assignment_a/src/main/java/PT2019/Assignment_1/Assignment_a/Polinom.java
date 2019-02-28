package PT2019.Assignment_1.Assignment_a;

import java.util.Collections;
import java.util.LinkedList;

public class Polinom {
	LinkedList<Monom> polin = new LinkedList<Monom>();

	public Polinom(LinkedList<Monom> polin) {
		super();
		Collections.sort(polin);
		this.polin = polin;
	}
	@Override
	public String toString() {
		String s= new String();
		for(Monom m:polin)
		{
			if(m.getCoef()>0)
				s+="+";
			s+=m.toString();
		}
		return s;
	}
	
	
}
