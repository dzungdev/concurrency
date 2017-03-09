package com.dzung.concurrency;

public class ProducerConsumer {
	public static void main(String[] args) {
		IntBuffer b = new IntBuffer();
		Producer p = new Producer(b);
		Consumer c = new Consumer(b);
		p.start();
		c.start();
	}
}
