package three;

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
