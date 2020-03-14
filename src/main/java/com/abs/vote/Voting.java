package com.abs.vote;

public class Voting {


	private int maximum;  
	private int minimum;  
	//no-argument constructor  
	protected Voting()  
	{  
	}  
	//generating getters  
	public int getMaximum()   
	{  
	return maximum;  
	}  
	public int getMinimum()   
	{  
	return minimum;  
	}  
	//genetrating constructor using fields  
	public Voting(int maximum, int minimum)   
	{  
	super();  
	this.maximum = maximum;  
	this.minimum = minimum;  
	  
	}  
}
