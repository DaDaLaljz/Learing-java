package simpleFactory;
import simpleFactory.Pizza; 
import simpleFactory.SimplePizzafactory; 
import simpleFactory.PizzaStore;

public class PizzaTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SimplePizzafactory factoryOne=new SimplePizzafactory();
		PizzaStore storeOne=new PizzaStore(factoryOne);
		Pizza pizzaOne=storeOne.orderPizza("CheesePizza");
		System.out.println("");
		SimplePizzafactory factoryTwo=new SimplePizzafactory();
		PizzaStore storeTwo=new PizzaStore(factoryTwo);
		Pizza pizzaTwo=storeTwo.orderPizza("ClamPizza");
		System.out.println("");
		SimplePizzafactory factoryThree=new SimplePizzafactory();
		PizzaStore storeThree=new PizzaStore(factoryThree);
		Pizza pizzaThree=storeThree.orderPizza("PepperoniPizza");
	}

}
