package PT2019.Assignment_1.Assignment_a;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import MVC.Model;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public void testAdd() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(5,4));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(-1,1));
		p1.getPolin().add(new Monom(5,0));
		Polinom p2 = new Polinom();
		p2.getPolin().add(new Monom(3,5));
		p2.getPolin().add(new Monom(10,3));
		p2.getPolin().add(new Monom(-1,1));
		p2.getPolin().add(new Monom(15,0));
		Polinom p3 = new Polinom();
		p3.getPolin().add(new Monom(3,5));
		p3.getPolin().add(new Monom(5,4));
		p3.getPolin().add(new Monom(-2,1));
		p3.getPolin().add(new Monom(20,0));
		assertTrue(p3.isEqual(p1.add(p2)));
	}
	
	public void testSub() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(5,4));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(-1,1));
		p1.getPolin().add(new Monom(5,0));
		Polinom p2 = new Polinom();
		p2.getPolin().add(new Monom(3,5));
		p2.getPolin().add(new Monom(10,3));
		p2.getPolin().add(new Monom(-1,1));
		p2.getPolin().add(new Monom(15,0));
		Polinom p3 = new Polinom();
		p3.getPolin().add(new Monom(-3,5));
		p3.getPolin().add(new Monom(5,4));
		p3.getPolin().add(new Monom(-20,3));
		p3.getPolin().add(new Monom(-10,0));
		assertTrue(p3.isEqual(p1.sub(p2)));
	}
	
	public void testMul() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(5,4));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(5,0));
		Polinom p2 = new Polinom();
		p2.getPolin().add(new Monom(1,2));
		p2.getPolin().add(new Monom(2,1));
		p2.getPolin().add(new Monom(0,0));
		Polinom p3 = new Polinom();
		p3.getPolin().add(new Monom(5,2));
		p3.getPolin().add(new Monom(5,6));
		p3.getPolin().add(new Monom(-20,4));
		p3.getPolin().add(new Monom(10,1));
		assertTrue(p3.isEqual(p1.mul(p2)));
	}
	
	public void testDiv() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(5,4));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(4,0));
		Polinom p2 = new Polinom();
		p2.getPolin().add(new Monom(1,2));
		p2.getPolin().add(new Monom(2,1));
		p2.getPolin().add(new Monom(0,0));
		Polinom p3 = new Polinom();
		p3.getPolin().add(new Monom(5,2));
		p3.getPolin().add(new Monom(40,0));
		p3.getPolin().add(new Monom(-20,1));
		Polinom p4 = new Polinom();
		p4.getPolin().add(new Monom(4,0));
		p4.getPolin().add(new Monom(-80,1));
		assertTrue(p3.isEqual(p1.div(p2)));
		assertTrue(p4.isEqual(p1));
	}
	
	public void testDer() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(5,4));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(5,1));
		p1.getPolin().add(new Monom(8,0));
		Polinom p3 = new Polinom();
		p3.getPolin().add(new Monom(20,3));
		p3.getPolin().add(new Monom(-30,2));
		p3.getPolin().add(new Monom(5,0));
		assertTrue(p3.isEqual(p1.der()));
	}
	
	public void testItg() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(5,4));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(5,0));
		Polinom p3 = new Polinom();
		p3.getPolin().add(new Monom(1,5));
		p3.getPolin().add(new Monom(-2.5f,4));
		p3.getPolin().add(new Monom(5,1));
		assertTrue(p3.isEqual(p1.itg()));
	}
	
	public void testConvert() {
		Polinom p1 = new Polinom();
		p1.getPolin().add(new Monom(-15,6));
		p1.getPolin().add(new Monom(12,5));
		p1.getPolin().add(new Monom(1,4));
		p1.getPolin().add(new Monom(2,2));
		p1.getPolin().add(new Monom(-10,3));
		p1.getPolin().add(new Monom(5,1));
		p1.getPolin().add(new Monom(-44,0));

		System.out.println(p1);
		String s = new String (" -15*x^6+ 12x^5+x^4+2x^2-10x^3+5x-44");
		Model m = new Model();
		try {
		Polinom p2 = m.convert(s);
		assertTrue(p1.isEqual(p2));
		}
		catch(Exception e) {
			assertTrue(false);
		}
	}
}
