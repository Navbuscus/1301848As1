package ca.ualberta.cs.nsdAs1;

import java.util.ArrayList;
import java.util.Date;


public class Counter {
	protected ArrayList<Count> count;
	protected Date timestamp;
	private String name;
	
	public Counter(String name) {
		super();
		this.timestamp = new Date();
		this.name = name;
	}
	
	/*Getters and Setters*/
	public Date GetDate() {
		return this.timestamp;
	}
	public int GetCount(){
		return this.count.size();
	}
	
	public void SetDate(Date timestamp){
		this.timestamp = timestamp;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**/
	@Override
	public String toString() {
        return this.getName() + " [" + this.count.size() + "]";
    }
}
