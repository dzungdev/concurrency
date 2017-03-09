package com.dzung.concurrency;

public class Consumer extends Thread {
	private IntBuffer intBuffer;
	
	public Consumer(IntBuffer intBuffer) {
		this.intBuffer = intBuffer;
	} 
	
	public void run() {
		while (true) {
			int num = intBuffer.remove();
			System.out.println("Consumed: " + num);
		}
	}
}
