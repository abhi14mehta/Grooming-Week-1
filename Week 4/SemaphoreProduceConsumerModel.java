import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreProduceConsumerModel {

    static Semaphore semCon = new Semaphore(0);
  
    static Semaphore semProd = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException{

		final ProducerConsumer pc = new ProducerConsumer();

		Thread producer = new Thread(new Runnable() {
			@Override
			public void run(){
            try {
                for(int i=0;i<10;i++){
                    pc.produce();
                }
            }
            catch (InterruptedException e) {
					e.getMessage();
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run(){
				try {
                    for(int i=0;i<10;i++){
                        pc.consume();
                    }
				}
				catch (InterruptedException e) {
					e.getMessage();
				}
			}
		});

		producer.start();
		consumer.start();
	}

	public static class ProducerConsumer {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;
        int value=0;

		
		public void produce() throws InterruptedException
		{
			
            try {
                semProd.acquire();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }

            System.out.println("Producer produced "+ value);
            
            list.add(value++);

            semCon.release();
		}

		public void consume() throws InterruptedException
		{
            try {
                semCon.acquire();
            }
            catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            int value = list.removeFirst();

            System.out.println("Consumer consumed "+ value);

            semProd.release();  
		}
	}
}