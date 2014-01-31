package ca.ualberta.cs.As1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import com.google.gson.Gson;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	private Gson gson = new Gson();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView counterList = (ListView) findViewById(R.id.counterList);
		Button newCounterButton = (Button) findViewById(R.id.newCounter);
		
		newCounterButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				AlertDialog.Builder alert = new AlertDialog.Builder(this);

				alert.setTitle("Title");
				alert.setMessage("Message");

				// Set an EditText view to get user input 
				final EditText input = new EditText(this);
				alert.setView(input);

				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				  String value = input.getText();
				  // Do something with value!
				  }
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int whichButton) {
				    // Canceled.
				  }
				});

				alert.show();
				
				
			}
		});
		Counter[] items = {new Counter("Sausage"), new Counter("HELLO")};
		ArrayAdapter<Counter> adapter = new ArrayAdapter<Counter>(this, android.R.layout.simple_list_item_1, items);
		
		counterList.setAdapter(adapter);
	}
	
	
	
		public void SaveCounterInFile(String name){
			try {
				FileOutputStream fos = openFileOutput(name,
						Context.MODE_PRIVATE);
				Counter count = new Counter(name);
				String json = gson.toJson(count);
				fos.write(json.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
