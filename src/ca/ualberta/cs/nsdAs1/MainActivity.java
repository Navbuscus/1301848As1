package ca.ualberta.cs.nsdAs1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.As1.R;

import com.google.gson.Gson;
//import android.view.Menu;

public class MainActivity extends Activity {
	private Gson gson = new Gson();
	final Context context = this;
	private CounterList counterList;
	private static final String FILENAME = "list.json";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView counterList = (ListView) findViewById(R.id.counterList);
		Button newCounterButton = (Button) findViewById(R.id.newCounter);
		
		//when clicking new counter button open dialog box
		newCounterButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater layoutInflater = LayoutInflater.from(context);
				View promptView = layoutInflater.inflate(R.layout.countercreate, null);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				alertDialogBuilder.setView(promptView);
				final EditText inputCounterName = (EditText) promptView.findViewById(R.id.userInput);
				// setup a dialog window
				alertDialogBuilder
						.setCancelable(false)
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										//check if name is already in counter list
										//ENTER COUNTER ACTIVITY HERE!
									}
								})
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,	int id) {
										dialog.cancel();
									}
								});

				// create an alert dialog
				AlertDialog alertD = alertDialogBuilder.create();

				alertD.show();
				
				
			}
		});
		Counter[] items = {new Counter("Sausage"), new Counter("HELLO")};
		ArrayAdapter<Counter> adapter = new ArrayAdapter<Counter>(this, android.R.layout.simple_list_item_1, items);
		
		counterList.setAdapter(adapter);
	}
	
	
	private CounterList LoadFromFile(){
		CounterList list = new CounterList();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			StringBuilder sb = new StringBuilder();
			String line = in.readLine();
			while (line != null) {
				sb.append(line);
				line = in.readLine();
			}
			String json = sb.toString();
			list = gson.fromJson(json, CounterList.class);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public void SaveInFile(CounterList counterList){
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			String json = gson.toJson(counterList);
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
