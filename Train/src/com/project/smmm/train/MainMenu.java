package com.project.smmm.train;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMenu extends ListActivity{

	String classes[] = {"Book","ShowTickets","Pay","LogOut"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main_menu);
		setListAdapter(new ArrayAdapter<String>(MainMenu.this,android.R.layout.simple_expandable_list_item_1,classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String choose = classes[position];
		try {
			Intent ourActivity = new Intent("com.project.smmm."+choose.toUpperCase());
			startActivity(ourActivity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
