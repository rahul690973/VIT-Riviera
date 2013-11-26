package vit.riviera;



import java.util.ArrayList;

import vit.riviera.EventInfo.ViewHolder;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sports extends Activity
{
	String name,venue,date,time,regfees,size,contactname,contactnum,desc;
	String prize1,prize2,prize3,prize4;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("0");
        setContentView(R.layout.sports);
        Bundle bundle=getIntent().getExtras();
        String sportsname=bundle.getString("sportsname");
        System.out.println(sportsname);
        System.out.println("1");
        Button sports_about=(Button)findViewById(R.id.rules);
        //Button sports_winner=(Button)findViewById(R.id.winner);
        Button sports_prize=(Button)findViewById(R.id.prize);
        Button sports_contacts=(Button)findViewById(R.id.sports_contact);
        Button sports_add=(Button)findViewById(R.id.sports_add);
        final TextView sports_name=(TextView)findViewById(R.id.sports_name);
        TextView sports_venue=(TextView)findViewById(R.id.sports_venue);
        TextView sports_date=(TextView)findViewById(R.id.sports_date);
        TextView sports_time=(TextView)findViewById(R.id.sports_time);
        Typeface face1=Typeface.createFromAsset(getAssets(),"fonts/VeryChristmess.ttf");
        Typeface face2=Typeface.createFromAsset(getAssets(),"fonts/Titania.ttf");
        Typeface face3=Typeface.createFromAsset(getAssets(),"fonts/aescrawl.ttf");
        PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,
				PhoneStateListener.LISTEN_CALL_STATE);
		
		Button sdir=(Button)findViewById(R.id.direction);

        System.out.println("2");
        final Dialog dialog_prize=new Dialog(this);
       final Dialog dialog_about=new Dialog(this);
        //
        final Dialog dialog_contact=new Dialog(this);
        //dialog_contact.setContentView(R.layout.contacts);
        
        final DBAdapter2 database=new DBAdapter2(this);
        final DBAdapter3 sports_database=new DBAdapter3(this);
        sports_database.open();
        Cursor c=sports_database.getAllInfo_Sports(sportsname);
        System.out.println("3");
       if(c.moveToFirst())
      {
    	  do
    	  {
    	prize1=c.getString(7);  
    	name=c.getString(0);
    	venue=c.getString(1);
    	date=c.getString(2);
    	time=c.getString(3);
    	regfees=c.getString(4);
    	desc=c.getString(5);
         size=c.getString(6);
    	prize2=c.getString(8);
    	prize3=c.getString(9);
    	prize4=c.getString(10);
        contactname=c.getString(11);
        contactnum=c.getString(12);
    	  }while(c.moveToNext());
      }
       System.out.println(name+venue+time+prize1+name);
       System.out.println("4");
       sports_database.close();
       sports_name.setText(name);
      sports_name.setTypeface(face1);
      /* sports_venue.setTypeface(face2);
       sports_date.setTypeface(face2);*/
       System.out.println("4");
       sports_venue.append(venue);
       System.out.println("4");
       sports_date.append(date);
       System.out.println("4");
       sports_time.append(time);
       
       dialog_about.requestWindowFeature(Window.FEATURE_NO_TITLE);
       
       sports_about.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		   dialog_about.setContentView(R.layout.sports_about); 
    		   dialog_about.show();
    		  // dialog_about.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    			TextView s_desc= (TextView) dialog_about.findViewById(R.id.sports_formenorwomen);
    	   		TextView s_regfees= (TextView) dialog_about.findViewById(R.id.sports_fees);
    	   		TextView s_teamsize= (TextView) dialog_about.findViewById(R.id.sports_size);
    	   		s_desc.setText(desc);
    	   		if(regfees.equalsIgnoreCase(""))
    	   			s_regfees.setText("NA");
    	   		else
    	   		s_regfees.setText(regfees);
    	   		s_teamsize.setText(size);
    	   		
    		   }
    		});
   	dialog_prize.requestWindowFeature(Window.FEATURE_NO_TITLE);
    
       sports_prize.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		   dialog_prize.setContentView(R.layout.prize_sports);
    	       
    		   dialog_prize.show();
    		 //  dialog_prize.getWindow().setBackgroundDrawable(new ColorDrawable(0));
   			
    	   		TextView s_prize1= (TextView) dialog_prize.findViewById(R.id.prize1);
    	   		TextView s_prize2= (TextView) dialog_prize.findViewById(R.id.prize2);
    	   		TextView s_prize3= (TextView) dialog_prize.findViewById(R.id.prize3);
    	   		TextView s_prize4= (TextView) dialog_prize.findViewById(R.id.prize4);
    	   		s_prize1.setText(prize1);
    	   		s_prize2.setText(prize2);
    	   		s_prize3.setText(prize3);
    	   		s_prize4.setText(prize4);
    	   		
    	   			
    		   }
    		});
       
       sports_add.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		   database.open();
    		   Cursor c=database.getRegEvents();
				ArrayList a=new ArrayList();
				int k=0;
				if(c.moveToFirst())
				{
					do
					{
				a.add(c.getString(0));		
					}while(c.moveToNext());
				}
				String[] regevents=(String[]) a.toArray(new String[a.size()]);
				for(int i=0;i<a.size();i++)
				{
					if(regevents[i].equalsIgnoreCase(sports_name.getText().toString()))
					{
						k=1;
						Toast.makeText(getApplicationContext(), "Already added to myevents", Toast.LENGTH_SHORT).show();
						
					}
				}
				
				String s=sports_name.getText().toString();
				System.out.println(s);
				database.insertContact(s);
				database.close();
				if(k==0)
					Toast.makeText(getApplicationContext(), "Added to myevents...", Toast.LENGTH_SHORT).show();
					
    	   			
    		   }
    		});
         
       sports_contacts.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		   Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:9566811287"));
				startActivity(callIntent);
				
    		//dialog_contact.show();   	
    		   }
    		});
       
       final DBAdapter6 map_database=new DBAdapter6(this);
       sdir.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		   map_database.open();
				System.out.println(venue);
				Cursor d=map_database.getAllContacts(venue);
				String latitude="";
				String longitude="";
				if(d.moveToFirst())
				{
				do
				{
				System.out.println(d.getString(0));
			 longitude=d.getString(1);
			 latitude=d.getString(2);
				System.out.println(longitude + latitude);
				
				}while(d.moveToNext());
				}
				map_database.close();
				Intent myIntent = new Intent(Sports.this,
   					LocationActivity.class);
				Bundle b=new Bundle();
				b.putString("lat", latitude);
				b.putString("lon", longitude);
				myIntent.putExtras(b);
			   Sports.this.startActivity(myIntent);
   	
    			
    		   }
    		});
       
     
       


	}
	
	private class SpecialAdapter extends BaseAdapter {
    	//Defining the background color of rows. The row will alternate between green light and green dark.
    	private int[] colors = new int[] { 0xAAf6ffc8, 0xAA538d00 };
    	private LayoutInflater mInflater;

    	//The variable that will hold our text data to be tied to list.
    	private String[] data;
          private String[] data2;
    	public SpecialAdapter(Context context, String[] items,String[] items2) {
    	    mInflater = LayoutInflater.from(context);
    	    this.data = items;
    	    this.data2=items2;
    	}

    	@Override
    	public int getCount() {
    	    return data.length;
    	   
    	}

    	@Override
    	public Object getItem(int position) {
    	    return position;
    	}

    	@Override
    	public long getItemId(int position) {
    	    return position;
    	}

    	//A view to hold each row in the list
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent) {

    	// A ViewHolder keeps references to children views to avoid unneccessary calls
    	// to findViewById() on each row.
    	ViewHolder holder;

    	if (convertView == null) {
    	    convertView = mInflater.inflate(R.layout.contacts_dialog, null);

    	    holder = new ViewHolder();
    	    holder.text = (TextView) convertView.findViewById(R.id.events_headline);
    	    holder.text2 =(TextView)convertView.findViewById(R.id.events_subline);
    	    
    	    convertView.setTag(holder);
    	} else {
    	    holder = (ViewHolder) convertView.getTag();
    	}
    	
    	    // Bind the data efficiently with the holder.
    	    holder.text.setText(data[position]);
    	    holder.text2.setText(data2[position]);

    	    //Set the background color depending of  odd/even colorPos result
    	    int colorPos = position % colors.length;
    	 //   convertView.setBackgroundColor(colors[colorPos]);

    	   return convertView;
    	}
    	}
	   private class PhoneCallListener extends PhoneStateListener {

			private boolean isPhoneCalling = false;

			String LOG_TAG = "LOGGING 123";

			@Override
			public void onCallStateChanged(int state, String incomingNumber) {

				if (TelephonyManager.CALL_STATE_RINGING == state) {
					// phone ringing
					Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
				}

				if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
					// active
					Log.i(LOG_TAG, "OFFHOOK");

					isPhoneCalling = true;
				}

				if (TelephonyManager.CALL_STATE_IDLE == state) {
					// run when class initial and phone call ended, need detect flag
					// from CALL_STATE_OFFHOOK
					Log.i(LOG_TAG, "IDLE");

					if (isPhoneCalling) {

						/*Log.i(LOG_TAG, "restart app");

						// restart app
						Intent i = getBaseContext().getPackageManager()
								.getLaunchIntentForPackage(
										getBaseContext().getPackageName());
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);*/

						isPhoneCalling = false;
					}

				}
			}
		}



}
