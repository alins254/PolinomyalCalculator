package PT2019.Assignment_1.Assignment_a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Iterator;

public class Polinom {
	LinkedList<Monom> polin = new LinkedList<Monom>();

	public Polinom(LinkedList<Monom> polin) {
		super();
		Collections.sort(polin);
		this.polin = polin;
	}
	
	public Polinom() {
		super();
		this.polin=new LinkedList<Monom>();
	}
	
	public Polinom(Polinom p) {
		super();
		this.polin.addAll(p.polin);
	}
	@Override
	public String toString() {
		if(this.polin.isEmpty())
			return "0";
		String s= new String();
		for(Monom m:polin)
		{
			if(m.getCoef()>0)
				s+="+";
			s+=m.toString();
		}
		if(s.charAt(0)=='+') {
			s=s.substring(1);
		}
		if(s.charAt(0)=='+') {
			s=s.substring(1);
		}
		return s;
	}
	
	
	public LinkedList<Monom> getPolin() {
		return polin;
	}

	public Polinom add (Polinom toAdd) {
		Polinom result = new Polinom();
		Monom dolly = null;
		this.polin.addLast(dolly);
		toAdd.polin.addLast(dolly);
		Iterator<Monom> i = this.polin.iterator();
		Iterator<Monom> j = toAdd.polin.iterator();
		Monom m = (Monom)i.next();
		Monom mToAdd = (Monom)j.next();
		while(i.hasNext()&&j.hasNext()){
			switch (m.compareTo(mToAdd)){
			case -1:  result.polin.add(m);
					  m = (Monom)i.next();	break;
			case 0: if(m.getCoef()!=-mToAdd.getCoef())
						result.polin.add(Monom.add(m, mToAdd));
					m =(Monom)i.next();
					mToAdd =(Monom)j.next();	break;
			case 1: result.polin.add(mToAdd);
					mToAdd = (Monom)j.next();	break;
			}
		}
		while(i.hasNext()) {
			result.polin.add(m);
			m = (Monom)i.next();
		}
		while(j.hasNext()) {
			result.polin.add(mToAdd);
			mToAdd = (Monom)j.next();
		}	
		Collections.sort(result.polin);
		this.polin.removeLast();	
		toAdd.polin.removeLast();
		if(!result.polin.isEmpty()) Collections.sort(result.polin);
		return result;
	}
	
	public Polinom sub (Polinom toSub) {
		Polinom result = new Polinom();
		Monom dolly = null;
		this.polin.addLast(dolly);
		toSub.polin.addLast(dolly);
		Iterator<Monom> i = this.polin.iterator();
		Iterator<Monom> j = toSub.polin.iterator();
		Monom m = (Monom)i.next();
		Monom mToSub = (Monom)j.next();
		while(i.hasNext()&&j.hasNext()){
			switch (m.compareTo(mToSub)){
			case -1:  result.polin.add(m);
					  m = (Monom)i.next(); break;
			case 0: if(m.getCoef()!=mToSub.getCoef())
						result.polin.add(Monom.sub(m, mToSub));
					m =(Monom)i.next();
					mToSub =(Monom)j.next(); break;
			case 1: result.polin.add(new Monom(-mToSub.getCoef(),mToSub.getPow()));
					mToSub = (Monom)j.next(); break;
			}
		}
		while(i.hasNext()) {
			result.polin.add(m);
			m = (Monom)i.next();
		}
		while(j.hasNext()) {
			result.polin.add(new Monom(-mToSub.getCoef(),mToSub.getPow()));
			mToSub = (Monom)j.next();
		}	
		Collections.sort(result.polin);
		this.polin.removeLast();
		toSub.polin.removeLast();
		if(!result.polin.isEmpty()) Collections.sort(result.polin);
		return result;
	}
	
	public Polinom mul(Polinom p) {
		Polinom result = new Polinom();
		Polinom partial = new Polinom();
		for(Monom m:this.polin)
		{
			for(Monom i:p.polin) {
				if(i.getCoef()!=0&&m.getCoef()!=0)
					partial.polin.add(Monom.mul(m, i));
			}
			result=result.add(partial);
			partial.polin.clear();
		}
		if(!result.polin.isEmpty()) Collections.sort(result.polin);
		return result;
	}
	
	public Polinom div(Polinom divider) {
		Polinom cat = new Polinom();
		Polinom partial = new Polinom();
		Collections.sort(this.polin);
		Collections.sort(divider.polin);
		while(!this.polin.isEmpty()) {
			if(this.polin.getFirst().getPow()<divider.polin.getFirst().getPow())
				break;
			if(divider.polin.isEmpty())
				break;
			if(divider.polin.getFirst().getCoef()==0)
			{
				divider.polin.removeFirst();
				continue;
			}
			Monom m = Monom.div(this.polin.getFirst(), divider.polin.getFirst());	
			partial.polin.clear();
			partial.polin.add(m);
			cat.polin.add(m);
			this.polin = this.sub(divider.mul(partial)).polin;
		}
		return cat;
	}
	
	public Polinom der() {
		Polinom result  = new Polinom();
		for(Monom m: this.polin) {
			if(m.getPow()>0)
				if(m.getCoef()!=0)
					result.polin.add(new Monom(m.getCoef()*m.getPow(),m.getPow()-1));
		}
		if(!result.polin.isEmpty()) Collections.sort(result.polin);
		return result;
	}
	
	public Polinom itg() {
		Polinom result  = new Polinom();
		for(Monom m:this.polin) {
			if(m.getCoef()!=0)
				if(m.getPow()!=0)
					result.polin.add(new Monom(m.getCoef()/(m.getPow()+1),m.getPow()+1));
				else
					result.polin.add(new Monom(m.getCoef(),1));
			
		}
			
		if(!result.polin.isEmpty()) Collections.sort(result.polin);
		return result;
	}
}
