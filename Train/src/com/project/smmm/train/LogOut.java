package com.project.smmm.train;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LogOut extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_out);
		Intent openMainActivity = new Intent("com.project.smmm.LOGIN");
		startActivity(openMainActivity);
		finish();
	}
}
