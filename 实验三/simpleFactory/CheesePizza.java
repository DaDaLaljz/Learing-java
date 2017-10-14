package simpleFactory;

public class CheesePizza extends Pizza{
	
	public void prepare(){
		System.out.println("Prepare CheesePizza¡£");
	}
	
	public void cut(){
		System.out.println("Cut CheesePizza.");
	}
	
	public void bake(){
		System.out.println("Bake CheesePizza.");
	}
	
	public void box(){
		System.out.println("Box CheesePizza.");
	}
	
}
