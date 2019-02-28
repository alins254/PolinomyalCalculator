package PT2019.Assignment_1.Assignment_a;

public class Monom implements Comparable{
	private int pow;
	private int coef;
	public Monom(int coef, int pow) {
		super();
		this.pow = pow;
		this.coef = coef;
	}
	
	public Monom(int pow) {
		super();
		this.pow = pow;
		this.coef = 1;
	}
	
	public Monom() {
		super();
		pow = 0;
		coef = 0;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int compareTo(Object arg0) {
		Monom m = (Monom)arg0;
		if (m.getPow()==this.getPow())
			return 0;
		else if(m.getPow()>this.getPow())
				return 1;
		return -1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return coef+"*x^"+pow;
	}
	
	
}
