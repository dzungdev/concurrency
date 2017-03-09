package com.dzung.concurrency;

public class BusyWaiting {
	
	/**
	 * 2017-02-22 9:41:03 AM alex
	 * 
	 * To avoid busywaiting we can use one object is lock for the thread
	 * then after thread start, we wait
	 * until thread finish in run() method, we make the lock notify.
	 */
	public void doSomething() {
		TheTask task = new TheTask();
		synchronized (task) {
			task.start();
			try{
				task.wait();
			} catch(InterruptedException ie) {
				//do something if interrupted
			}
		}
	}
	
}

class TheTask extends Thread {
	
	public void rund() {
		synchronized(this) {
			//do the task here
			this.notify();//notify when end
		}
	}
}
