package demo;
import java.util.*;

public class hello{
	public static void main(String[] args) {
		int mark=0;
		int a = 1990;
		for(int i=0;a<=2007;i++){
			if(a%4==0 && a%100!=0){
				System.out.print(a);
				System.out.print(" ");
				mark++;
				if(mark%2==0){
				System.out.println("");}
				}else if(a%400==0){
					System.out.print(a);
					System.out.print(" ");
					mark++;
					if(mark%2==0){
						System.out.println("");
					}
				}
			  a++;
			
			  }
		System.out.println();
		workTwo();
		System.out.println();
		third();
		System.out.println();
		fourth();
	}
	
	public static void workTwo() {
		Scanner in=new Scanner(System.in);
		System.out.println("输入五个成绩：");
		double a[];
		a=new double[5];
		for(int i=0;i<5;i++){
			a[i]=in.nextDouble();
		}
		for(int i=0;i<a.length;i++){
			if(a[i]>=90&&a[i]<100){
				System.out.println("优");
			}
			if(a[i]>=80&&a[i]<90){
				System.out.println("良");
			}
			if(a[i]>=70&&a[i]<80){
				System.out.println("中");
			}
			if(a[i]>=60&&a[i]<70){
				System.out.println("及格");
			}
			if(a[i]<60){
				System.out.println("不及格");
			}
		}
	}
	
	public static void third(){
		int max=7;
		for(int i=0;i<max;i++){
			if(i<4){
				int n=2*i+1;
				for(int j=0;j<3-i;j++){
					System.out.print(" ");
				}
				for(int k=0;k<n;k++){
					System.out.print("*");
				}
				System.out.println();
			}
			if(i>=4){
				int n=max-2*(i-3);
				for(int j=0;j<i-3;j++){
					System.out.print(" ");
				}
				for(int k=0;k<n;k++){
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
	}

	public static void fourth(){
		for(int i=1;i<10;i++)
			for(int j=0;j<10;j++)
				for(int k=0;k<10;k++){
					if((i*i*i+k*k*k+j*j*j)==(i*100+j*10+k)){
						System.out.println((i*100+j*10+k));
					}
				}
	}
}


