// 6.Write program to implement produce and consumer model


import java.util.LinkedList;

public class ProduceConsumerModel {
	public static void main(String[] args) throws InterruptedException{

		final ProducerConsumer pc = new ProducerConsumer();

		Thread producer = new Thread(new Runnable() {
			@Override
			public void run(){
				try {
					pc.produce();
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
					pc.consume();
				}
				catch (InterruptedException e) {
					e.getMessage();
				}
			}
		});

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();
	}

	public static class ProducerConsumer {
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		
		public void produce() throws InterruptedException
		{
			int value = 0;
			while (true) {
				synchronized (this)
				{
					while (list.size() == capacity)
						wait();

					System.out.println("Producer produced "+ value);
                    

					list.add(value++);

					notify(); // notify to consumer thread.

					Thread.sleep(1000);
				}
			}
		}

		public void consume() throws InterruptedException
		{
			while (true) {
				synchronized (this)
				{
					while (list.size() == 0)
						wait();

					int value = list.removeFirst();

					System.out.println("Consumer consumed "+ value);

					notify(); // call producer thread.

					Thread.sleep(1000);
				}
			}
		}
	}
}
