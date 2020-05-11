package datingBureau;

public class Threads {
	public static long comparisonParallel() {
		long time_start = System.currentTimeMillis();
		System.out.println("Starting all threads...");
		FirstThread first = new FirstThread();
        Thread t1 = new Thread(first,"FirstThread"); 
        
		SecondThread second = new SecondThread();
        Thread t2 = new Thread(second,"SecondThread"); 
        
		ThirdThread third = new ThirdThread();
        Thread t3 = new Thread(third,"ThirdThread"); 

		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing all threads...");
		return System.currentTimeMillis() - time_start;
	}
	
	public static long comparisonSequential() {
		long time_start1 = System.currentTimeMillis();
		System.out.println("Starting sequence...");
		try {
			ThreadHelper.getAverageAge(Go.registration);
			ThreadHelper.getIndexOfOldestClient(Go.registration);
			ThreadHelper.getIndexOfYoungestClient(Go.registration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing sequence...");
		return System.currentTimeMillis() - time_start1;
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