package PT2019.Assignment_1.Assignment_a;

import MVC.Controller;
import MVC.Model;
import MVC.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Model m = new Model();
		View v = new View();
		Controller c = new Controller(v,m);
    }
}
