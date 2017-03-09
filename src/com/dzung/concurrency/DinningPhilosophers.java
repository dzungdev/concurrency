package com.dzung.concurrency;

public class DinningPhilosophers {
	
	private Object[] forks;
	private Philosopher[] philosophers;
	
	private DinningPhilosophers(int num) {
		forks = new Object[num];
		philosophers = new Philosopher[num];
		
		for (int i = 0; i < num; ++i) {
			forks[i] = new Object();
			philosophers[i] = new Philosopher(i, i, (i + 1) % num);
		}
	}
	
	public void startEating() throws InterruptedException {
		for (Philosopher philosoper: philosophers) {
			philosoper.start();
		}
		//suspend main thread until all philosophers finish eating
		philosophers[0].join();
	}
	
	private class Philosopher extends Thread {
		
		private int id;
		private int fork1;
		private int fork2;
		
		public Philosopher(int id, int fork1, int fork2) {
			this.id = id;
			this.fork1 = fork1;
			this.fork2 = fork2;
		}
		
		/**
		 * pick up forks
		 */
		public void run() {
			status("Ready to eat using forks: " + fork1 + " and " + fork2);
			while (true) {
				status("Picking up fork " + fork1);
				synchronized (forks[fork1]) {
					status("Picking up fork " + fork2);
					synchronized (forks[fork2]) {
						status("Eating");
					}
				}
			}
		}
		
		private void status(String msg) {
			System.out.println("Philosopher " + id + ": " + msg);
		}
	 	
	}
	
}
