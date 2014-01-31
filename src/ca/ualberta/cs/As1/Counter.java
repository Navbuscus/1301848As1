package ca.ualberta.cs.As1;
import java.util.Date;
import java.util.ArrayList;

public class Counter {
	protected ArrayList<Count> count;
	protected Date timestamp;
	protected static String name;
	
	public Counter(String name) {
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
	public String GetName(){
		return this.name;
	}
	public void SetCount(int count) {
		//this.count = count;
	}
	public void SetDate(Date timestamp){
		this.timestamp = timestamp;
	}
	public void SetName(String name){
		this.name = name;
	}
	/**/
	@Override
	public String toString() {
        return this.name + " [" + this.count.size() + "]";
    }
}
