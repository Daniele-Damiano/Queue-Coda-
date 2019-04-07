package org.queue.coda;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		System.out.println("Empty ="+queue.Empty());
		
		queue.Enqueue(5);
		queue.Enqueue(10);
		queue.Enqueue(13);
		queue.Enqueue(4);
		queue.Enqueue(9);
		
		System.out.println("First = "+queue.First());
		System.out.println("Empty = "+queue.Empty());
		System.out.println("Dequeue = "+queue.Dequeue());
		
		queue.Enqueue(1);
		queue.Enqueue(3);
		queue.Enqueue(11);
		
		
		System.out.println(queue.First());
		
		
		//String
		Queue<String> queue1 = new Queue<>();
		System.out.println("Empty ="+queue1.Empty());
		
		queue1.Enqueue("Daniele");
		queue1.Enqueue("Paperino");
		queue1.Enqueue("Pippo");
		queue1.Enqueue("Baudo");
		queue1.Enqueue("Tastiera");
		
		System.out.println("First = "+queue1.First());
		System.out.println("Empty = "+queue1.Empty());
		System.out.println("Dequeue = "+queue1.Dequeue());
		
		queue1.Enqueue("Mouse");
		queue1.Enqueue("Bho");
		queue1.Enqueue("Mha");
		
		
		System.out.println("First = "+queue1.First());
		
		//
		
		
	}

}
