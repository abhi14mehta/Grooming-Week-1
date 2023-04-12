// 1.Write a program to create Thread using Thread class.
// 3.Write a program to interrupt a Thread.
// 4.Write a program to set the Thread priority.
 

class EvenThread extends Thread{
	EvenThread(String name, int priority){
		super(name);
		setPriority(priority);
	}
    @Override
	public void run(){
		int i;
		System.out.println("Even Thread :"+ this);
		for(i=0; i<10 ;i+=2){
			System.out.println("Even : "+i);
			try{
				Thread.sleep(250);
			}catch(InterruptedException e){
				System.out.println("InterruptedException caught:"+ e.getMessage());
			}
		}
	}
}
class OddThread extends Thread{
	OddThread(){
		run();
		setName("Odd Thread");
	}
    @Override
	public void run(){
		int i;
		System.out.println("Odd Thread :"+ this);
		for(i=1; i<10 ;i+=2){
			System.out.println("Odd : "+i);
			try{
				Thread.sleep(500);
                this.interrupt();
			}catch(InterruptedException e){
				System.out.println("InterruptedException caught:"+ e.getMessage());
			}
		}
	}
}
public class ThreadDemo{
	public static void main(String[] args) {
		EvenThread e = new EvenThread("Even Thread",9);
		OddThread o = new OddThread();
		e.start();
        e.interrupt();
		Thread t = Thread.currentThread();
		System.out.println("Main Thread:"+t);

		
	}
}