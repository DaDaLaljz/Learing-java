package three;

public class ChocolateBoiler {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
			System.out.println("��¯�����ɿ�����ţ��");
			empty=false;
			boiled=false;
		}
	}
	
	public void boil(){
		if(!isEmpty() && !isBoiled()){
			System.out.println("��¯�����");
			boiled=true;
			empty=false;
		}
	}
	
	public void drain() {  
	    if (!isEmpty() && isBoiled()){  
	            System.out.println("�ų���е��ɿ�����ţ��");  
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
		// TODO �Զ����ɵķ������
		System.out.println("making "+name);
	}



}
