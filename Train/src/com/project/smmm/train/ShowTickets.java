package com.project.smmm.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowTickets extends Activity {

	
	//List<String> stringList = new ArrayList<String>(Arrays.asList(strings))
	private ArrayList<String> listItems;
	SharedPreferences data;
	List<String> stringList;
	ArrayAdapter tickAdaoter;
	Book file=new Book();
	SharedPreferences.Editor editor;
	String tickets;   // user name of log in 
	//file data at the next line should be delete 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_tickets);
		data=getSharedPreferences(file.fileName1, 0);
		editor=data.edit();		
		tickets=getUser();
		stringList = new ArrayList<String>(Arrays.asList(data.getString(tickets,"").replace("+", ",").split("-")));
		tickAdaoter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stringList);
		ListView ticketsList=(ListView)findViewById(R.id.ticketList);
		ticketsList.setAdapter(tickAdaoter);
		tickAdaoter.notifyDataSetChanged();
		
		ticketsList.setOnItemClickListener(
				new AdapterView.OnItemClickListener() {
					
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						String ticket=String.valueOf(parent.getItemAtPosition(position));
						AlertDialog diaBox = AskOption(ticket);
						diaBox.show();
						
					}
			}
		);

	}
	
	private AlertDialog AskOption(final String target)
	 {
	    AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this) 
	        //set message, title, and icon
	        .setTitle("Delete") 
	        .setMessage("Do you want to Delete")

	        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

	            public void onClick(DialogInterface dialog, int whichButton) { 
	                //your deleting code
	            	stringList.remove(target);
	            	tickAdaoter.notifyDataSetChanged();
	            	String listString = "";

	            	for (String s : stringList)
	            	{
	            	    listString += s + "-";
	            	}
	            	listString=listString.replace(",", "+");
	            	if(!listString.equals("")){
	            		listString=(String) listString.subSequence(0, listString.length()-1);
	            	}
	            	editor.putString(tickets, listString);
	            	editor.commit();
	            	
	            }   

	        })



	        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {

	                dialog.dismiss();

	            }
	        })
	        .create();
	        return myQuittingDialogBox;

	    }

	public String getUser(){
		Login file=new Login();
		SharedPreferences user =getSharedPreferences(file.fileForActivity, 0);
		return user.getString("userName", null);
		
	}
}
