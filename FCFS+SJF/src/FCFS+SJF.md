## java集合类综合小实验
### 1.FCFS算法按照任务到达的顺序进行服务，先来先服务
（1）每个Task对象可以描述为至少包含下列属性：
taskID //任务ID
arrivalTime //到达时间
serviceTime //服务时间
startingTime //开始时间
finishingTime //完成时间=开始时间+服务时间
turnAroundTime //周转时间=完成时间-达到时间
weightTurnAround //带权周转时间=周转时间/服务时间
其他的属性根据程序需要设置
（2）任务(Task)的ID、开始时间和服务时间由文件读入。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。
### 2.SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。

代码如下：
1.创建一个生产txt文件的InputFile.java，存放TaskID，到达时间，服务时间。
```
public class InputFile {
	
	
	public static void inputFiles(){
		File dest = new File("D://serviceTime.txt");
		Writer er=null;
		try {
			er=new FileWriter(dest);
			int TaskID;
			int arrivalTime;
			int serviceTime;
			for(int i=0;i<100;i++){
				TaskID = i+1;
				arrivalTime = i;
				serviceTime = creatServiceTime();
				er.append(TaskID+" "+arrivalTime+" "+serviceTime+"\r\n");
			}
			er.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(null!=er)
			try {
				er.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static int creatServiceTime() {
	    Random random = new Random();
        int s = random.nextInt(5);
		switch(s){
		case 0:return 6;
		case 1:return 2;
		case 2:return 1;
		case 3:return 3;
		default:return 9;
		}
		
	}
}
```
2.创建一个构造文件，Task.java。
```
public class Task {
	private int taskID;
	private int arrivalTime; //到达时间
	private int serviceTime; //服务时间
	private int startingTime; //开始时间
	private int finishingTime; //完成时间=开始时间+服务时间
	private int turnAroundTime; //周转时间=完成时间-达到时间
	private double weightTurnAround; //带权周转时间=周转时间/服务时间
	private int RemainingTine;
	public int getTaskID() {
		return taskID;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public int getStartingTime() {
		return startingTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	public double getWeightTurnAround() {
		return weightTurnAround;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public void setTurnAroundTime(int turnAroundTime) {
		this.turnAroundTime = turnAroundTime;
	}
	public void setWeightTurnAround(double weightTurnAround) {
		this.weightTurnAround = weightTurnAround;
	}
	public int getRemainingTine() {
		return RemainingTine;
	}
	public void setRemainingTine(int remainingTine) {
		RemainingTine = remainingTine;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "Task [taskID=" + taskID + ", arrivalTime=" + arrivalTime
				+ ", serviceTime=" + serviceTime + ", startingTime="
				+ startingTime + ", finishingTime=" + finishingTime
				+ ", turnAroundTime=" + turnAroundTime + ", weightTurnAround="
				+ df.format(weightTurnAround) + "]";
	}
}
```
3.FCFS服务。
```
public class FCFS {
	static LinkedList<Task> TaskQueue = null;
	private LinkedList<Task> waitQueue = new LinkedList<Task>();
	private int sumTime;
	private boolean isFree;
	private Task now;
	private String name;
	
	public int getWaitQueueSize(){
		return waitQueue.size();
	}

	public FCFS(String name) {
		if (this.TaskQueue == null) {
			loadTaskQueue();
		}
		this.name = name;
		isFree = true;
	}

	public void startUp() {
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
		if (isFree) {
			begin();
		} else {
			work();
		}
		
	}

	private void begin() {
		if(waitQueue.size()!=0){
			this.now = this.waitQueue.poll();
			isFree = false;
			now.setStartingTime(sumTime);
			now.setFinishingTime(now.getStartingTime() + now.getServiceTime());
			now.setTurnAroundTime(now.getFinishingTime() - now.getArrivalTime());
			now.setWeightTurnAround(now.getTurnAroundTime() * 1.0
					/ now.getServiceTime());
			System.out.println(this.name + ":" + now);
		}
	}

	private void work() {
		// TODO Auto-generated method stub
		sumTime++;
		if (sumTime == now.getFinishingTime()) {
			isFree = true;
		}
	}

	private void loadTaskQueue() {
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {
		System.out.println("readFile");
		LinkedList<Task> queue = new LinkedList<Task>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("D:\\serviceTime.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infos = null;
			while ((line = br.readLine()) != null) {
				Task temp = new Task();
				infos = line.split(" ");
				temp.setTaskID(Integer.parseInt(infos[0]));
				temp.setArrivalTime(Integer.parseInt(infos[1]));
				temp.setServiceTime(Integer.parseInt(infos[2]));
				// System.out.println(temp);
				queue.offer(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return queue;

	}
}
```
4.SJF服务。
```
public class SJF {
	
	static LinkedList<Task> TaskQueue = null;
	private LinkedList<Task> waitQueue = new LinkedList<Task>();
	private int sumTime;
	private boolean isFree;
	private Task now;
	private String name;
	
	public int getWaitQueueSize(){
		return waitQueue.size();
	}
	
	public class TaskComparator implements Comparator<Task> {

		@Override
		public int compare(Task o1, Task o2) {
			// TODO Auto-generated method stub
			return (o1.getServiceTime()-o2.getServiceTime());
		}
		
	}

	public SJF(String name) {
		if (this.TaskQueue == null) {
			loadTaskQueue();
		}
		this.name = name;
		isFree = true;
	}

	public void startUp() {
		if(TaskQueue.size()!=0){
			waitQueue.offer(TaskQueue.poll());
		}
		if (isFree) {
			begin();
		} else {
			work();
		}
	}
	
	

	private void begin() {
		Collections.sort(waitQueue, new TaskComparator());
		if(waitQueue.size()!=0){
			this.now = this.waitQueue.poll();
			isFree = false;
			now.setStartingTime(sumTime);
			now.setFinishingTime(now.getStartingTime() + now.getServiceTime());
			now.setTurnAroundTime(now.getFinishingTime() - now.getArrivalTime());
			now.setWeightTurnAround(now.getTurnAroundTime() * 1.0
					/ now.getServiceTime());
			System.out.println(this.name + ":" + now);
		}
	}

	private void work() {
		// TODO Auto-generated method stub
		sumTime++;
		if (sumTime == now.getFinishingTime()) {
			isFree = true;
		}

	}

	private void loadTaskQueue() {
		this.TaskQueue = readFile();
	}

	private LinkedList<Task> readFile() {
		System.out.println("readFile");
		LinkedList<Task> queue = new LinkedList<Task>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("D:\\serviceTime.txt");
			br = new BufferedReader(fr);
			String line = "";
			String[] infos = null;
			while ((line = br.readLine()) != null) {
				Task temp = new Task();
				infos = line.split(" ");
				temp.setTaskID(Integer.parseInt(infos[0]));
				temp.setArrivalTime(Integer.parseInt(infos[1]));
				temp.setServiceTime(Integer.parseInt(infos[2]));
				// System.out.println(temp);
				queue.offer(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return queue;
	}
}
```
5.main函数调用
```
InputFile.inputFiles();//先生成文件
/* FCFS只有一个队列。*/
FCFS test = new FCFS("Test1");
		test.startUp();
		do{
			test.startUp();
		}while(test.getWaitQueueSize()!=0  || FCFS.TaskQueue.size()!=0);
        
/*  两个队列。*/
FCFS test2 = new FCFS("Test2");
		test2.startUp();
		do{
			test.startUp();
			test2.startUp();
		}while(test.getWaitQueueSize()!=0 ||test2.getWaitQueueSize()!=0 || FCFS.TaskQueue.size()!=0);
        
 /*SJF只有一个队列*/
 SJF test = new FCFS("Test1");
		test.startUp();
		do{
			test.startUp();
		}while(test.getWaitQueueSize()!=0  ||SJF.TaskQueue.size()!=0);
/* 两个队列*/
SJF test2 = new SJF("Test2");
		test2.startUp();
		do{
			test.startUp();
			test2.startUp();
		}while(test.getWaitQueueSize()!=0 ||test2.getWaitQueueSize()!=0 || SJF.TaskQueue.size()!=0);
 ```
### 3.总结
这次实验对于我是个很大的困难，我很多都没有理解清楚，都是请教同学，只完成一个处理队列的。挺难的，跟以前的c++实验不是同个level，加上本身编程基础比较弱，真的挺难理解... 所以要加强努力。希望老师能布置一些比较基础的java题目，因为java基础真的不扎地.


