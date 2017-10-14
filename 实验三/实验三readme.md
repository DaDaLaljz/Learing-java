## java的面向对象基础
### 1.JAVA访问权修饰符的掌握
编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
```
public class demo {
	public static void main(String[] args) {
		demo momo=new demo();
		System.out.print(momo.a);
		System.out.print(momo.b);
		System.out.print(momo.c);
		System.out.println(momo.d);
		momo.print();
	}
   public int a=1;
   private int b=2;
   protected int c=3;
   int d=4;
   public void print(){
	   System.out.print(a);
	   System.out.print(b);
	   System.out.print(c);
	   System.out.println(d);   
   }
}
```
此题重点在于理解四个权限限制的异同。

|     |   同一个类 |同一个包     | 不同包子类    |  不同包非子类   |
| --- | --- | --- | --- | --- |
| private    |   √  |     |     |     |
|  default   |   √  |    √  |     |     |
|  protected   | √    |    √  |    √  |     |
|   public  |    √ |   √  |    √  |  √    |

1、private: Java语言中对访问权限限制的最窄的修饰符，一般称之为“私有的”。被其修饰的类、属性以及方法只能被该类的对象访问，其子类不能访问，更不能允许跨包访问。
2、default：即不加任何访问修饰符，通常称为“默认访问模式“。该模式下，只允许在同一个包中进行访问。
3、protect: 介于public 和 private 之间的一种访问修饰符，一般称之为“保护形”。被其修饰的类、属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。
4、public： Java语言中访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且允许跨包（package）访问。

### 2.单例模式
1、Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler。
2、ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值。
private boolean empty;
private boolean boiled;
3、ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。
（1）public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false。
（2）public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。
（3）public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。
（4）isEmpty和isBoiled方法来获取empty和boiled标志位的值。
```
public class ChocolateBoiler {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 ChocolateBoiler boiler = ChocolateBoiler.getInstance();  
	     boiler.fill();  
	     boiler.boil();  
         boiler.drain();  

	}
	
	private boolean empty=true;//初始的锅炉为空
	private boolean boiled=false;//初始的锅炉没有煮沸
	private static ChocolateBoiler uniqueInstance;//单例模式
	
    public boolean isEmpty() {  
	        return empty;  
    }//标志位
    
    public boolean isBoiled() {  
	        return boiled;  
	}  //标志位
    
	public void fill(){
		if(isEmpty()){
			System.out.println("锅炉填满巧克力和牛奶");
			empty=false;
			boiled=false;
		}
	}//填满但没有煮沸
	
	public void boil(){
		if(!isEmpty() && !isBoiled()){
			System.out.println("锅炉内煮沸");
			boiled=true;
			empty=false;
		}
	}//填满且煮沸
	
	public void drain() {  
	    if (!isEmpty() && isBoiled()){  
	            System.out.println("排出煮沸的巧克力和牛奶");  
	            empty = true;  
	            boiled=false;
	        }  
    }  //倒出后为空且不煮沸
	
    public static ChocolateBoiler getInstance() {  
        if (uniqueInstance == null) {  
            uniqueInstance = new ChocolateBoiler();  
        }
        return uniqueInstance;  
    }  //单例模式的实现

}
```
此题重点在于单例模式的实现，保证只有一个类。单例模式的要点有三个：（1）某个类只能有一个实例，（2）它必须自行创建这个实例;（3）它必须自行向整个系统提供这个实例。
### 3.总结
对第一题不理解题意，成员函数对每个权限都可以访问，数值都可以输出，所以导致不知道该怎么写....
第二题可以掌握单例模式了，类只能new一个对象，只能有一个类。