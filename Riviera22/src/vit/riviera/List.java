package vit.riviera;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Bundle b= getIntent().getExtras();
        String[] data= b.getStringArray("events_array");
        System.out.println(data[0]);
       SimpleDateFormat sdf=new SimpleDateFormat("dd");
       SimpleDateFormat sdf2=new SimpleDateFormat("HH");
       Calendar d=Calendar.getInstance();
       String currentDate = sdf.format(d.getTime());
       String currentTime=sdf2.format(d.getTime()); 
       System.out.println("hello");
       System.out.println(currentDate+currentTime);
       int date1 = Integer.parseInt(currentDate);
       int time1=Integer.parseInt(currentTime);
       ArrayList events=new ArrayList();
       boolean[] check=new boolean[data.length];
       for(int i=0;i<data.length;i++)
    	   check[i]=false;
       DBAdapter7 status_database=new DBAdapter7(this);
       
       if(date1==6 && (time1 >=9 && time1<=13))
       {
       status_database.open();
       Cursor c= status_database.getslot1();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
       
       if(date1==06 && (time1 >13 && time1<=17))
       {
       status_database.open();
       Cursor c= status_database.getslot2();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
     
       if(date1==7 && (time1 >=9 && time1<=13))
       {
       status_database.open();
       Cursor c= status_database.getslot3();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
       
       if(date1==7 && (time1 >13 && time1<=17))
       {
       status_database.open();
       Cursor c= status_database.getslot4();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
       
       
       if(date1==8 && (time1 >=9 && time1<=13))
       {
       status_database.open();
       Cursor c= status_database.getslot5();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
       
       if(date1==8 && (time1 >13 && time1<=17))
       {
       status_database.open();
       Cursor c= status_database.getslot6();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
       
       if(date1==9 && (time1 >=9 && time1<=13))
       {
       status_database.open();
       Cursor c= status_database.getslot7();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
       
       if(date1==9 && (time1 >13 && time1<=17))
       {
       status_database.open();
       Cursor c= status_database.getslot8();
       if(c.moveToFirst())
       {
       do
       {
      String x=c.getString(0);
       events.add(x);
      
       }while(c.moveToNext());
       }}
     
       
       
       
       
       
       String[] event=(String[]) events.toArray(new String[events.size()]);
       
    for(int i=0;i<data.length;i++)
       {

       for(int j=0;j<events.size();j++)
       {
       if(data[i].equalsIgnoreCase(event[j]))
       {
    	   System.out.println("alert");
       check[i]=true;
       System.out.println(data[i]);
       }

       }
       }
       
       status_database.close();
       


       Weather weather_data[] = new Weather[data.length];
       for(int i=0;i<data.length;i++)
       	weather_data[i]=new Weather(data[i]);
      
      WeatherAdapter adapter = new WeatherAdapter(this, 
               R.layout.list_layout, weather_data,check);
       
        listView1 = (ListView)findViewById(R.id.listview);
         
     final View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView1.addHeaderView(header);
       // header.setClickable(false);
        header.setFocusable(false);
        
        listView1.setAdapter(adapter);
        listView1.setItemsCanFocus(false);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(arg1==header)
					System.out.println("truett");
				else
				{	
				ListView lv=(ListView)arg0;
				if(arg0==header)
					System.out.println("hey");
				Weather tv= (Weather) arg0.getItemAtPosition(arg2);
				String s=tv.title;
				System.out.println(s);
				System.out.println("inside click");
				Intent myIntent = new Intent(List.this,
						EventInfo.class);
				Bundle bundle=new Bundle();
				bundle.putString("culturalname", s);
				myIntent.putExtras(bundle);
					List.this.startActivity(myIntent);

				}
				
			}
		});

        
        
        
        
    }}