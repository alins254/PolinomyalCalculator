package PT2019.Assignment_1.Assignment_a;

public class Monom implements Comparable<Object>{
	private int pow;
	private double coef;
	public Monom(double coef, int pow) {
		super();
		this.pow = pow;
		this.coef = coef;
	}
	
	public Monom(int pow) {
		super();
		this.pow = pow;
		this.coef = 1;
	}
	
	public Monom(Monom m) {
		super();
		this.pow = m.getPow();
		this.coef = m.getCoef();
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

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
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
	private String toStringInt() {
		String s = new String();
		int cof = (int)coef;
		if(pow == 0)
			s+=cof;
		else
			if(pow==1)
				if(cof==1)
					s+="x";
				else if(cof == -1)
						s+="-x";
					 else
						s+=cof+"x";
			else
				if(cof==1)
					s+="x^"+pow;
				else if(cof == -1)
						s+="-x^"+pow;
					 else
						s+=cof+"x^"+pow;
		return s;
	}
	
	@Override
	public String toString() {
		String s = new String();
		if(coef == (int)coef)
			return this.toStringInt();
		if(pow == 0)
			s+=format(coef);
		else
			if(pow==1)
				if(format(coef)==1)
					s+="x";
				else if(format(coef) == -1)
						s+="-x";
					 else
						s+=format(coef)+"x";
			else
				if(format(coef)==1)
					s+="x^"+pow;
				else if(format(coef) == -1)
						s+="-x^"+pow;
					 else
						s+=format(coef)+"x^"+pow;
		return s;
	}
	public Double format(double n) {
		int res = (int)(n*100);
		Double result = (double)res;
		return result/100.;
	}
	
	public static Monom add(Monom m1,Monom m2) {
		if(m1.getPow()==m2.getPow())
			return new Monom(m1.coef+m2.getCoef(),m1.getPow());
		return null;
	}
	
	public static Monom sub(Monom m1,Monom m2) {
		if(m1.getPow()==m2.getPow())
			return new Monom(m1.coef-m2.getCoef(),m1.getPow());
		return null;
	}
	
	public static Monom mul(Monom m1, Monom m2) {
		return new Monom(m1.coef*m2.coef,m1.getPow()+m2.getPow());
	}
	
	public static Monom div(Monom m1, Monom m2) {
		return new Monom(m1.coef/m2.coef,m1.getPow()-m2.getPow());
	}
	
	public boolean isEqual(Monom m) {
		if(this.pow!=m.pow)
			return false;
		if(this.coef!=m.coef)
			return false;
		return true;
	}
}
