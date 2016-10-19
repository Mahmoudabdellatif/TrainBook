package com.project.smmm.train;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends ActionBarActivity implements OnClickListener {
	public String data2 = null;
	public String stringData = null;
	public String dataReturned = null;
	public String dataReturned1 = null;
	Button sign;
	TextView email, password;
	EditText mail, pass;
	public String fileName = "login";
	public SharedPreferences someData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		sign = (Button) findViewById(R.id.bsign);
		
		email = (TextView) findViewById(R.id.tvEmail);
		password = (TextView) findViewById(R.id.tvpass);
		
		mail = (EditText) findViewById(R.id.etEmail);
		pass = (EditText) findViewById(R.id.etpass);
		sign.setOnClickListener(this);
		
		someData = getSharedPreferences(fileName, 0);
	}
	
	public void onClick(View v){
		switch (v.getId()){
		case R.id.bsign:
			stringData = mail.getText().toString();
			data2 = pass.getText().toString();
		//	dataReturned  = someData.getString(stringData, null);
			if(!stringData.equals(null) && !data2.equals(null) && !someData.contains(stringData)){
				SharedPreferences.Editor editor = someData.edit();
				editor.putString(stringData, data2);
				editor.commit();
				Toast.makeText(this, "data saved", Toast.LENGTH_LONG).show();
				Intent openMainActivity = new Intent("com.project.smmm.MAINMENU");
				startActivity(openMainActivity);
				finish();
			}
			else{
				Toast.makeText(this, "enter another E-mail", Toast.LENGTH_LONG).show();
			}
			
			break;
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
