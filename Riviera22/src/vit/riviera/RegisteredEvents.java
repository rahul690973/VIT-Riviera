package vit.riviera;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RegisteredEvents extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeredevents);
        ListView listview_registered=(ListView)findViewById(R.id.listview_registered);
        final DBAdapter2 database=new DBAdapter2(this);
        final DBAdapter events=new DBAdapter(this);
        final DBAdapter3 sports=new DBAdapter3(this);
        DBAdapter4 workshop=new DBAdapter4(this);
        database.open();
        Cursor c=database.getRegEvents();
        ArrayList reg_events=new ArrayList();
        if(c.moveToFirst())
 	   {
        	System.out.println("in registered");
 		 do
 		   {
 			  System.out.println("hello");
 			   String s=c.getString(0);
 			   System.out.println(s);
 			   reg_events.add(s);
 	
 			  
 		   }while(c.moveToNext());
 	   }
        database.close();
        String[] weather_data=(String[]) reg_events.toArray(new String[reg_events.size()]);
 	
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,weather_data);
        final View header = (View)getLayoutInflater().inflate(R.layout.myevents, null);
        listview_registered.addHeaderView(header);
   
        listview_registered.setAdapter(adapter);
        
        listview_registered.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    	@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
    		if(arg1==header)
    		{
    			
    		}
    		else
    		{
			ListView lv=(ListView)arg0;
			String tv= (String) arg0.getItemAtPosition(arg2);
		
			System.out.println(tv);
			events.open();
			Cursor c=events.check(tv);
			if(c.getCount()>0)
			{
				Intent myIntent = new Intent(RegisteredEvents.this,
						EventInfo.class);
				Bundle b=new Bundle();
				b.putString("culturalname", tv);
				myIntent.putExtras(b);
					RegisteredEvents.this.startActivity(myIntent);
					events.close();
	
			}
			else 
			{
				sports.open();
				c=sports.check(tv);
				if(c.getCount()>0)
				{
					Intent myIntent = new Intent(RegisteredEvents.this,
							Sports.class);
					Bundle b=new Bundle();
					b.putString("sportsname", tv);
					myIntent.putExtras(b);
				
						RegisteredEvents.this.startActivity(myIntent);
						events.close();
			sports.close();
				}
				else
				{
					Intent myIntent = new Intent(RegisteredEvents.this,
							Workshop.class);
					Bundle b=new Bundle();
					b.putString("workshopname", tv);
					myIntent.putExtras(b);
					
						RegisteredEvents.this.startActivity(myIntent);
						events.close();		
				}
				
				
			}
			
			
			
    		}
		}
	});

    	
        
	}
	
}
