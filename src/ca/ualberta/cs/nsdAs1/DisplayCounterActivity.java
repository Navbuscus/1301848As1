package ca.ualberta.cs.nsdAs1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ca.ualberta.cs.As1.R;


public class DisplayCounterActivity extends Activity {
	protected CounterList counterList;
	protected String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_counter);
		Intent intent = getIntent();
		counterList = (CounterList) intent.getParcelableExtra("counterList");
		name =  intent.getExtras().getString("counterName");
		
	}

	

}
