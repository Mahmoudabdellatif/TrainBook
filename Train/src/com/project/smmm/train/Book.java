package com.project.smmm.train;

import android.support.v7.app.ActionBarActivity;
import android.R.string;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Book extends ActionBarActivity {

	
	//public Login file = new Login();
	public  class MyOnItemSelectedListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			// TODO Auto-generated method stub
	
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static String userName;  // will be sent from log in activity
	public static String fileName1 = "tickets";
	SharedPreferences data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book);
		
		data = getSharedPreferences(fileName1, 0);
		Spinner list1;
		list1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.city_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list1.setAdapter(adapter1);
        list1.setOnItemSelectedListener(new MyOnItemSelectedListener());
 
        Spinner list2;
		list2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.city_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list2.setAdapter(adapter2);
        list2.setOnItemSelectedListener(new MyOnItemSelectedListener());
        
        Spinner list3;
		list3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.class_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list3.setAdapter(adapter3);
        list3.setOnItemSelectedListener(new MyOnItemSelectedListener());
        
        Button myButton =(Button)findViewById(R.id.button1);
        myButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
 
            Spinner fromList =	(Spinner)findViewById(R.id.spinner1);
            Spinner toList =	(Spinner)findViewById(R.id.spinner2);
            Spinner classList =	(Spinner)findViewById(R.id.spinner3);
            String city1 = null;
            String city2 = null;
            String myclass = null;
            city1 = fromList.getSelectedItem().toString();
            city2 = toList.getSelectedItem().toString();
            myclass = classList.getSelectedItem().toString();
            if(city1==city2){
            	Toast.makeText(getApplicationContext(), "Can not be done , Choose another city", 
                		Toast.LENGTH_LONG).show();
            }
            else {
            	//userName = login.gusernamefortickets;
            	userName = getUser();
            	String lastTickets = data.getString(userName, "");
            	String ticket = city1+"+"+city2+"+"+myclass;
            	if(lastTickets == ""){
            		lastTickets = ticket;
            	}
            	else{
            		lastTickets = lastTickets + "-" + ticket;
            	}
            	SharedPreferences.Editor editor = data.edit();
            	editor.putString(userName, lastTickets);
            	editor.commit();
            	Toast.makeText(getApplicationContext(), "Ticket has been booked", 
                		Toast.LENGTH_LONG).show();
            }
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.book, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public String getUser(){
		Login file=new Login();
		SharedPreferences user =getSharedPreferences(file.fileForActivity, 0);
		return user.getString("userName", null);
		
	}
}
