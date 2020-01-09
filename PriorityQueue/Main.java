package PriorityQueue;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(25);
		pq.add(-22);
		pq.add(1343);
		pq.add(54);
		pq.add(0);
		pq.add(-3492);
		pq.add(429);
		
		//will get the lowest number of the queue, -3492, which is at the root since it's a min heap
		System.out.println(pq.peek());
		//returns item it removes, which is -3492
		System.out.println(pq.remove());
		//-22 now smallest item
		System.out.println(pq.peek());
		//polled, got -22, removed it
		System.out.println(pq.poll());
		//get 0 after polled, since now min value
		System.out.println(pq.peek());
		//remove random number
		//redundant to return what you want to remove, so it instead returns true
		System.out.println(pq.remove(54));
		System.out.println("------------------------------------------");
		Object[] ints = pq.toArray();
		for(Object num : ints)
		{
			System.out.println(num);
		}
		System.out.println("------------------------------------------");
		//0 still at priority, still at root
		System.out.println(pq.peek());
		pq.add(-1);
		//now -1 is at the root
		System.out.println(pq.peek());


	}

}
