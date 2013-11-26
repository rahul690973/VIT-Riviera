package vit.riviera;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Division2 extends Activity
{
	DBAdapter database;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division2);
        System.out.println("anshul again");
        
	}
	public void OnClick(View v)
	{
	Button b1=(Button)v;
	String user_category=b1.getText().toString();
	database=new DBAdapter(this);
	database.open();
	System.out.println(user_category);
	Cursor c=database.getAllContacts(user_category);
	 ArrayList<String> events=new ArrayList<String>();
	  
   if(c.moveToFirst())
	   {
		 do
		   {
			  
			   String s=c.getString(0);
			   System.out.println(s);
			 events.add(s);
			  
		   }while(c.moveToNext());
	   }
	 database.close();
	 System.out.println(events);
	 String[] events_string= events.toArray(new String[events.size()]);
		 Intent myIntent = new Intent(Division2.this,
					List.class);
		 Bundle b=new Bundle();
		 b.putStringArray("events_array", events_string);
		 myIntent.putExtras(b);
		 startActivity(myIntent); 
		 
		   //Division2.this.startActivity(myIntent);
	
	  
	}
}
