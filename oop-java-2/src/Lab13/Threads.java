package datingBureau;

import java.util.Random;

public class Threads {
	public static void start_all_threads() throws InterruptedException {
		System.out.println("Set the timer [0 - 100 000 ms]: ");
		Random random = new Random ();
		int timer_num = random.nextInt(100000);
		System.out.println("Starting all threads..." + "\n");
		
		FirstThread first = new FirstThread();
        Thread t1 = new Thread(first,"FirstThread"); 
        
		SecondThread second = new SecondThread();
        Thread t2 = new Thread(second,"SecondThread"); 
        
		ThirdThread third = new ThirdThread();
        Thread t3 = new Thread(third,"ThirdThread"); 

		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(timer_num);
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		System.out.println("Finishing all threads...");
	}

}

class FirstThread implements Runnable {
	public void run() {

        System.out.println("First Thread: I`m started" + "\n");
		try {
			if (!Thread.currentThread().isInterrupted()) {
				ThreadHelper.getAverageAge(Go.registration);
				System.out.println("First thread: I`m finished!!!" + "\n");
			} else {
                throw new InterruptedException();
			}
		} catch (InterruptedException e) {
            System.out.println("First Thread is interrupted");
        }
    }
} 

class SecondThread implements Runnable {
	public void run() {
		System.out.println("Second Thread: I`m started" + "\n");
		try {
			if (!Thread.currentThread().isInterrupted()) {
				ThreadHelper.getIndexOfOldestClient(Go.registration);
				System.out.println("Secound thread: I`m finished!!!" + "\n");
			} else {
                throw new InterruptedException();
			}
		} catch (InterruptedException e) {
            System.out.println("First Thread is interrupted");
        }	
    }
} 

class ThirdThread implements Runnable {
	public void run() {
        System.out.println("Third Thread: I`m started" + "\n");
		try {
			if (!Thread.currentThread().isInterrupted()) {
				ThreadHelper.getIndexOfYoungestClient(Go.registration);
				System.out.println("Third thread: I`m finished!!!" + "\n");
			} else {
                throw new InterruptedException();
			}
		} catch (InterruptedException e) {
            System.out.println("First Thread is interrupted");
        }	
    }
} 