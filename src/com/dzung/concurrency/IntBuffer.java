package com.dzung.concurrency;

public class IntBuffer {
	
	private int index;
	private int[] buffer = new int[8];
	
	public synchronized void add(int num) {
		
		while (index == buffer.length - 1) {
			try {
				wait();
			} catch(InterruptedException ie) {
				
			}
		}
		buffer[index++] = num;
		notifyAll();
	}
	
	public synchronized int remove() {
		while (index == 0) {
			try {
				wait();
			} catch(InterruptedException ie) {
				
			}
		}
		int result = buffer[--index];
		notifyAll();
		return result;
	}
}
