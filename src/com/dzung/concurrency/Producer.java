package com.dzung.concurrency;

import java.nio.Buffer;
import java.util.Random;

public class Producer extends Thread {
	
	private IntBuffer intBuffer;
	public Producer(IntBuffer intBuffer) {
		this.intBuffer = intBuffer;
	}
	
	public void run() {
		Random r = new Random();
		while (true) {
			int number = r.nextInt();
			intBuffer.add(number);
			System.out.println("Produced: " + number);
		}
	}

}
