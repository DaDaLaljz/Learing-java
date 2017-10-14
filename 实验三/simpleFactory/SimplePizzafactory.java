package simpleFactory;
import simpleFactory.CheesePizza;
import simpleFactory.ClamPizza;
import simpleFactory.PepperoniPizza;
import simpleFactory.Pizza;

public class SimplePizzafactory {

	public Pizza createPizza(String type){
		Pizza pizza = null;
		
		if(type.equals("CheesePizza")){
			pizza = new CheesePizza();
		}
		
		else if(type.equals("ClamPizza")){
			pizza = new ClamPizza();
		}
		
		else if(type.equals("PepperoniPizza")){
			pizza = new PepperoniPizza();
		}
		
		return pizza;
	}
}
