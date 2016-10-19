package com.project.smmm.train;

import java.util.LinkedList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends ActionBarActivity {
	
	private EditText username;
	private EditText password;
	private Button login;
	private Button signUp;
	public String filename,fileForActivity="user"  ;
	public String usernamefortickets;
	public SharedPreferences someData;
	SignUp file = new SignUp();
	public String data2 = null;
	public String stringData = null;
	public String Data = null, pass = null;
	
	public void authenticateLogin(View view) {
		someData=getSharedPreferences(file.fileName, 0);
		String check = username.getText().toString();
		String check1 = password.getText().toString();
		if (!check1.equals(null) && someData.contains(check) && check1.equals(someData.getString(check, null))){
			//here will be intent to menue activity
			Toast.makeText(this, "Hi " + check , Toast.LENGTH_LONG).show();
			putUser(check);
			Intent openMainActivity = new Intent("com.project.smmm.MAINMENU");
			startActivity(openMainActivity);
			finish();
		} else {
			
			Toast.makeText(this, "fail", Toast.LENGTH_LONG).show();
			
		}
	}
	
	public String getUserName(){
	    return usernamefortickets;
	}
	private void setupVariables() {
		username = (EditText) findViewById(R.id.usernameET);
		password = (EditText) findViewById(R.id.passwordET);
		login = (Button) findViewById(R.id.loginBtn);
		signUp = (Button) findViewById(R.id.signupBtn);
		someData = getSharedPreferences(file.fileName, 0);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		setupVariables();
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				authenticateLogin(v);
			}
		});
		signUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//should be here intent to sign up activity 
				Intent openMainActivity = new Intent("com.project.smmm.SIGNUP");
				startActivity(openMainActivity);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
	
	public void putUser(String string){
		SharedPreferences user =getSharedPreferences(fileForActivity, 0);
		SharedPreferences.Editor editor=user.edit();
		editor.putString("userName", string);
		editor.commit();
	}
}
