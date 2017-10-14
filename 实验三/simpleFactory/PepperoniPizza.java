package simpleFactory;

public class PepperoniPizza extends Pizza{
	
	public void prepare(){
		System.out.println("Prepare PepperoniPizza.");
	}
	
	public void cut(){
		System.out.println("Cut PepperoniPizza.");
	}
	
	public void bake(){
		System.out.println("Bake PepperoniPizza.");
	}
	
	public void box(){
		System.out.println("Box PepperoniPizza.");
	}
	
}
