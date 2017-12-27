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
