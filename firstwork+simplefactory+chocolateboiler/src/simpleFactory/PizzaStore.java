package simpleFactory;
import simpleFactory.Pizza;
import simpleFactory.SimplePizzafactory; 

public class PizzaStore {
	SimplePizzafactory factory;
	public PizzaStore(SimplePizzafactory factory){
		this.factory=factory;
	}
	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = factory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
