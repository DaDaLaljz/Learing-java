package three;

public class ChocolateBoiler {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 ChocolateBoiler boiler = ChocolateBoiler.getInstance();  
	     boiler.fill();  
	     boiler.boil();  
         boiler.drain();  

	}
	
	private boolean empty=true;
	private boolean boiled=false;
	private static ChocolateBoiler uniqueInstance;
	
    public boolean isEmpty() {  
	        return empty;  
    }
    
    public boolean isBoiled() {  
	        return boiled;  
	}  
    
	public void fill(){
		if(isEmpty()){
			System.out.println("锅炉填满巧克力和牛奶");
			empty=false;
			boiled=false;
		}
	}
	
	public void boil(){
		if(!isEmpty() && !isBoiled()){
			System.out.println("锅炉内煮沸");
			boiled=true;
			empty=false;
		}
	}
	
	public void drain() {  
	    if (!isEmpty() && isBoiled()){  
	            System.out.println("排出煮沸的巧克力和牛奶");  
	            empty = true;  
	            boiled=false;
	        }  
    }  
	
    public static ChocolateBoiler getInstance() {  
        if (uniqueInstance == null) {  
            uniqueInstance = new ChocolateBoiler();  
        }
        return uniqueInstance;  
    }

	public void doChocolate(String name) {
		// TODO 自动生成的方法存根
		System.out.println("making "+name);
	}



}
