package JavaSubject3;

import JavaSubject3.SJF_TP;

public class main {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		SJF_TP test = new SJF_TP("Test1");
		SJF_TP test2 = new SJF_TP("Test2");
		test.startUp();
		test2.startUp();
		do{
			test.startUp();
			test2.startUp();
		}while(test.getWaitQueueSize()!=0 ||test2.getWaitQueueSize()!=0 || SJF_TP.TaskQueue.size()!=0);
		/*do{
			test.startUp();
		}while(test.getWaitQueueSize()!=0  ||SJF_TP.TaskQueue.size()!=0);*/
		//InputFile.inputFiles();
	/*	FCFS test = new FCFS("Test1");
		test.startUp();*/
	/*	do{
			test.startUp();
		}while(test.getWaitQueueSize()!=0  || FCFS.TaskQueue.size()!=0);*/
	/*	FCFS test2 = new FCFS("Test2");
		test2.startUp();
		do{
			test.startUp();
			test2.startUp();
		}while(test.getWaitQueueSize()!=0 ||test2.getWaitQueueSize()!=0 || FCFS.TaskQueue.size()!=0);*/
		
		
		
		
	}



}

