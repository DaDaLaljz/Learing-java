## Thread多线程
### 1.对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。
```
package Thread;
import three.ChocolateBoiler;

public class Thread1 extends Thread{
	private String name;

	public Thread1(String name) {
		this.name = name;

	}

	public static void main(String[] args) {
		Thread test1 = new Thread(new Thread1("test1"));
		Thread test2 = new Thread(new Thread1("test2"));
		Thread test3 = new Thread(new Thread1("test3"));
		Thread test4 = new Thread(new Thread1("test4"));
		test1.start();
		test2.start();
		test3.start();
		test4.start();
	}

	public synchronized void run() {
		ChocolateBoiler.getInstance().doChocolate(name);
	}
}

```
### 2.利用4个线程分段求和1~100
（1）线程1计算1~25之和；线程2计算26~50之和；以此类推
（2）要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
（3）打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第 二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果
```
package Thread;

public class Thread2 extends Thread{
	private int start;
	private int end;
	private int sum = 0;
	public static int count = 1;

	public Thread2(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void run() {
		try {
			for (int i = this.start; i <= this.end; i++) {
				this.sum += i;
				sleep(100);
			}
			System.out.println("第" + count + "次结果：" + this.sum);
			count++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Thread2 test1 = new Thread2(1, 25);
		Thread2 test2 = new Thread2(26, 50);
		Thread2 test3 = new Thread2(51, 75);
		Thread2 test4 = new Thread2(76, 100);
		Thread2[] thr = { test1, test2, test3, test4 };
		try {
			for (int i = 0; i < thr.length; i++) {
				thr[i].start();
				thr[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("最终求和结果：" + (test1.sum + test2.sum + test3.sum + test4.sum));
	}
}
```
### 3.总结
继承Thread类，并覆盖run()方法，必须覆盖run()方法，run()结束则线程结束， 调用start()方法使线程运行。start():开始运行线程，执行run()方法。join():等待加入的线程执行结束（另外的线程加入当前的线程中）。

