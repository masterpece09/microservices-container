package com.in28min.microservices.limitssevice.bean;

public class Limits {
 
	private int minimum;
	private int maximun;
	
	public Limits() {
		super();
	}
 

	public Limits(int minimum, int maximun) {
		this.minimum = minimum;
		this.maximun = maximun;
	}


	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	public int getMinimum() {
		return minimum;
	}
	
	public int getMaximun() {
		return maximun;
	}
	public void setMaximun(int maximun) {
		this.maximun = maximun;
	}
	
	
}
