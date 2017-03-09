package com.dzung.concurrency;

public class Account {
	private int userNumber;
	private String lastName;
	private String firstName;
	private double balance;
	
	public boolean deposit(double amount) {
		if (amount < 0) {
			return false;
		} else {
			synchronized(this) {
				balance += amount;
			}
			return true;
		}
	}
	
	public boolean withdraw(double amount) {
		if (amount < 0 || amount > balance) {
			return false;
		} else {
			synchronized (this) {
				balance -= amount;
			}
			return true;
		}
	}
	
}
