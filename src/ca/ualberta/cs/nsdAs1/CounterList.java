package ca.ualberta.cs.nsdAs1;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class CounterList implements Parcelable{

	protected ArrayList<Counter> list;
	
	public CounterList(){
		super();
		this.list = new ArrayList<Counter>();	
	}
	public int ListSize(){
		return this.list.size();
	}
	public Counter GetCounter(int i){
		return this.list.get(i);
	}
	public void addToList(Counter count){
		this.list.add(count);
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}

}
