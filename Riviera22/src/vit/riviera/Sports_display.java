package vit.riviera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Sports_display extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_display);
        String[] sports_name=new String[]{"BasketBall","Mr. Riviera" ,
        		"HandBall", "Snookers","VolleyBall","Tennis","Squash","Swimming","Hockey","Football","Table Tennis"
        		,"Chess","ThrowBall","Badminton"};
        
 ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,sports_name);
        
        
       ListView listView1 = (ListView)findViewById(R.id.sports_display_listview);
         
     final View header = (View)getLayoutInflater().inflate(R.layout.sports_header, null);
       listView1.addHeaderView(header);
       
    
        listView1.setAdapter(adapter);
        listView1.setItemsCanFocus(false);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
				
				Intent myIntent = new Intent(Sports_display.this,
						Sports.class);
					Bundle bundle=new Bundle();
					bundle.putString("sportsname", tv);
					myIntent.putExtras(bundle);
					Sports_display.this.startActivity(myIntent);
				}
				
				
			}
		});
        
        
       DBAdapter3 database=new DBAdapter3(this);
       database.open();
       if(global.sports_i==1)
       {
    	   database.insertContact("BasketBall", "BasketBall Court", "4th - 5th Feb 2013", "", "For Men and Women", "12", "", "12000", "10000", "8000", "6000", "Neal Manjeshwar  ", "9566811287");
    		
    	   database.insertContact("Mr. Riviera", "Indoor Stadium", "4th - 5th Feb 2013", "", "For Men", "", "", "1500", "1000", "500", "", "Neal Manjeshwar  ", "9566811287");
    	   
    	   database.insertContact("HandBall", "Outdoor Stadium", "4th - 5th Feb 2013", "", "For Men", "12", "", "12000", "10000", "8000", "6000", "Neal Manjeshwar  ", "9566811287");
    	   
    	   database.insertContact("VolleyBall", "VolleyBall Court", "4th - 5th Feb 2013", "", "For Men and Women", "12", "", "12000", "10000", "8000", "6000", "Neal Manjeshwar  ", "9566811287");
    	   
    	  database.insertContact("Tennis", "Tennis Court", "3th - 4th Feb 2013", "", "For Men and Women", "4", "", "5000", "4000", "3000", "2000", "Neal Manjeshwar  ", "9566811287");

    	  database.insertContact("Snookers", "Snooker Hall", "5th - 6th Feb 2013", "", "For Men", "4", "", "5000", "4000", "3000", "2000", "Neal Manjeshwar  ", "9566811287");
    	       
    	  database.insertContact("Swimming", "Swimming Pools", "5th - 6th Feb 2013", "", "For Men and Women", "", "", "15000", "10000", "5000", "", "Neal Manjeshwar  ", "9566811287");
    	   
    	  database.insertContact("Squash", "Indoor Stadium", "3rd - 4th Feb 2013", "", "For Men and Women", "", "", "25000", "15000", "", "", "Neal Manjeshwar  ", "9566811287");

    	  database.insertContact("Hockey", "Outdoor Stadium", "4th - 5th Feb 2013", "", "For Men", "16", "", "15000", "12000", "10000", "8000", "Neal Manjeshwar  ", "9566811287");
    	    
    	  database.insertContact("Football", "Sjt Building", "4th - 5th Feb 2013", "", "For Men", "16", "", "15000", "12000", "10000", "8000", "Neal Manjeshwar  ", "9566811287");

    	  database.insertContact("Table Tennis", "Indoor Stadium", "3rd - 4th Feb 2013", "", "For Men and Women", "4", "", "5000", "4000", "3000", "2000", "Neal Manjeshwar  ", "9566811287");

    	  database.insertContact("Chess", "Foodys", "3rd - 4th Feb 2013", "", "For Men and Women", "4", "", "5000", "4000", "3000", "2000", "Neal Manjeshwar  ", "9566811287");

    	  database.insertContact("Badminton", "Indoor Stadium", "3rd - 4th Feb 2013", "", "For Men and Women", "4", "", "5000", "4000", "3000", "2000", "Neal Manjeshwar  ", "9566811287");

    	  database.insertContact("ThrowBall", "ThrowBall Court", "4th - 5th Feb 2013", "", "For  Women", "12", "", "12000", "10000", "8000", "6000", "Neal Manjeshwar  ", "9566811287");
       global.sports_i=0;
       
       }
       database.close();

	}
    
}
