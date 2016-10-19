package com.project.smmm.train;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Thread timer = new Thread(){
			public void run(){
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.project.smmm.LOGIN");
					startActivity(openMainActivity);
					finish();
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
