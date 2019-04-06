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
	}

}
