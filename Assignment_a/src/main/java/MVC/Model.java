package MVC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PT2019.Assignment_1.Assignment_a.*;


public class Model{

	public Polinom convert(String s) throws Exception{
		Polinom result = new Polinom();
		s=removeBlanks(s);
		//System.out.println(s);
		String[] divided = divide(s);
			for(String z:divided) {
				System.out.println(z);
				Monom m;
				if(!z.equals("")) {
					if(z.charAt(0)=='-') {
						m = matching(z.substring(1));
						m.setCoef(-m.getCoef());
					
					}
					else 
						m = matching(z);
					result.getPolin().add(m);
				}
			}
		return result;
	}
	
	private Monom matching(String s) throws Exception{
		String pattern[] = new String[7];
		pattern[0] = "(^\\d+)(\\*)(x)(\\^)(\\d+$)";
		pattern[1] = "(^\\d+)(x)(\\^)(\\d+$)";
		pattern[2] = "(^x)(\\^)(\\d+$)";
		pattern[3] = "(^\\d+)(\\*)(x$)";
		pattern[4] = "(^\\d+)(x$)";
		pattern[5] = "(^x$)";
		pattern[6] = "(^\\d+$)";
		int i=0;
		Pattern r = Pattern.compile(pattern[i]);
		Matcher m = r.matcher(s);
		for(i=0;i<7;i++)
		{
			r = Pattern.compile(pattern[i]);
			m = r.matcher(s);
			if(m.find())
				break;
		}
		Monom toReturn = new Monom();
		if(i>=7)
			throw new Exception("Input Gresit!");
		else {
			switch(i) {
			case 0: toReturn.setCoef(Integer.parseInt(m.group(1)));
					toReturn.setPow(Integer.parseInt(m.group(5)));
					break;
			case 1: toReturn.setCoef(Integer.parseInt(m.group(1)));
					toReturn.setPow(Integer.parseInt(m.group(4)));
					break;
			case 2: toReturn.setCoef(1);
					toReturn.setPow(Integer.parseInt(m.group(3)));
					break;
			case 3: toReturn.setCoef(Integer.parseInt(m.group(1)));
					toReturn.setPow(1);
					break;
			case 4: toReturn.setCoef(Integer.parseInt(m.group(1)));
					toReturn.setPow(1);
					break;
			case 5: toReturn.setCoef(1);
					toReturn.setPow(1);
					break;
			default: toReturn.setCoef(Integer.parseInt(m.group(1)));
					 toReturn.setPow(0);
					 break;
			}
		}
		return toReturn;
	}
	
	private String removeBlanks(String s) {
		if(s.isEmpty())
			return "";
		if(s.charAt(0)==' ')
			return removeBlanks(s.substring(1));
		return s.charAt(0)+removeBlanks(s.substring(1));
	}
	
	private String[] divide(String s) {
		s=s.replaceAll("-", "+-");
		String[] res = s.split("(\\+)");
		return res;
	}
}
