package datingBureau;

public class ThreadHelper {
	public static int getIndexOfOldestClient(Registration reg) throws InterruptedException {
		int index = 0;
		for(int i = 1; i < reg.getSize(); i++) {
			if (!Thread.currentThread().isInterrupted()) {
				if(reg.getClientByIndex(i).getAge() > reg.getClientByIndex(index).getAge()) {
					index = i;
				}
				Thread.sleep(100);
			} else {
                throw new InterruptedException();
			}
		}
		return index;
	}
	
	public static int getIndexOfYoungestClient(Registration reg) throws InterruptedException {
		int index = 0;
		for(int i = 1; i < reg.getSize(); i++) {
			if (!Thread.currentThread().isInterrupted()) {
				if(reg.getClientByIndex(i).getAge() < reg.getClientByIndex(index).getAge()) {
					index = i;
				} 
				Thread.sleep(100);
			} else {
                throw new InterruptedException();
			}
		}
		return index;
	}
	
	public static void getAverageAge(Registration reg) throws InterruptedException {
		int averageAge = 0;
		for(int i = 0; i < reg.getSize(); i++) {
			if (!Thread.currentThread().isInterrupted()) {
				averageAge = averageAge + reg.getClientByIndex(i).getAge();
				Thread.sleep(100);
			} else {
                throw new InterruptedException();
			}
		}
		averageAge = averageAge / reg.getSize();
		System.out.println("Average age: " + averageAge + "\n");
	}
	
}
