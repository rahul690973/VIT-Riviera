package vit.riviera;

import java.util.ArrayList;


import vit.riviera.EventInfo.ViewHolder;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Workshop extends Activity
{ 
	String name,venue,date,time,regfees,desc1,desc2,name1,contact1,name2,contact2;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workshop);
        Bundle bundle=getIntent().getExtras();
        String workshopname=bundle.getString("workshopname");
        final TextView workshop_name=(TextView)findViewById(R.id.workshop_name);
        TextView workshop_venue=(TextView)findViewById(R.id.workshop_venue);
        TextView workshop_date=(TextView)findViewById(R.id.workshop_date);
        TextView workshop_time=(TextView)findViewById(R.id.workshop_time);
        TextView workshop_regfees=(TextView)findViewById(R.id.workshop_regfees);
        Button workshop_contacts=(Button)findViewById(R.id.workshop_contacts);
        Button workshop_add=(Button)findViewById(R.id.workshop_add);
        Typeface face1=Typeface.createFromAsset(getAssets(),"fonts/VeryChristmess.ttf");
        Typeface face2=Typeface.createFromAsset(getAssets(),"fonts/Titania.ttf");
        Typeface face3=Typeface.createFromAsset(getAssets(),"fonts/ashcanbb_reg.ttf");
   	 PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,
				PhoneStateListener.LISTEN_CALL_STATE);


       
          workshop_name.setText(workshopname);
          workshop_name.setTypeface(face1);
          final DBAdapter2 database=new DBAdapter2(this);
        DBAdapter4 workshop_database=new DBAdapter4(this);
        workshop_database.open();
        Cursor c=workshop_database.getAllContacts(workshopname);
        if(c.moveToFirst())
        {
        	do
        	{
        	venue=c.getString(1);
        	date=c.getString(2);
        	time=c.getString(3);
        	regfees=c.getString(4);
        	desc1=c.getString(5);
        	desc2=c.getString(6);
        	name1=c.getString(7);
        	contact1=c.getString(8);
        	name2=c.getString(9);
        	contact2=c.getString(10);
        	}while(c.moveToNext());
        }
        if(venue.equalsIgnoreCase(""))
        	venue="-";
        
        if(date.equalsIgnoreCase(""))
        	date="-";
        
        if(time.equalsIgnoreCase(""))
        	time="-";
      
        workshop_database.close();
        workshop_venue.append(venue);
        workshop_date.append(date);
        workshop_time.append(time);
        
        System.out.println(contact1);
        System.out.println(contact2);
        System.out.println("cont");
        TextView workshop_description1=new TextView(this);
        TextView workshop_description2=new TextView(this);
        LinearLayout workshop_description=(LinearLayout)findViewById(R.id.workshop_description);
        workshop_description1.setText(desc1);
        workshop_description2.setText(desc2);
        workshop_description1.setTypeface(face3);
        workshop_description2.setTypeface(face3);
        workshop_description1.setTextColor(Color.BLACK);
        workshop_description2.setTextColor(Color.BLACK);
        workshop_description1.setTextSize(20);
        workshop_description2.setTextSize(20);
        
        workshop_description.addView(workshop_description1);
        workshop_description.addView(workshop_description2);
        
        final Dialog dialog_contacts=new Dialog(this);
        dialog_contacts.setContentView(R.layout.contacts);
        dialog_contacts.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final String[] contact_name=new String[]{name1,name2};
        final String[] contact_number=new String[]{contact1,contact2};
        
        
     
           //  String[] events_contact=(String[]) contact.toArray(new String[contact.size()]);
        ListView contactslist=(ListView)dialog_contacts.findViewById(R.id.contactslist);
     //   ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,contact);
        SpecialAdapter adapter = new SpecialAdapter(this, contact_name,contact_number);
         
        contactslist.setAdapter(adapter);
        contactslist.setItemsCanFocus(false);
        contactslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				/*ListView lv=(ListView)arg0;
				Weather tv= (Weather) arg0.getItemAtPosition(arg2);
				String s=tv.title;
				System.out.println(s);*/
				System.out.println("inside click");
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"+contact_name[arg2]));
				startActivity(callIntent);
				
				/*Intent myIntent = new Intent(List.this,
						EventInfo.class);
				Bundle bundle=new Bundle();
				bundle.putString("culturalname", s);
				myIntent.putExtras(bundle);
					List.this.startActivity(myIntent);*/

				
				
			}
		});

        workshop_contacts.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v)
 			{
 		dialog_contacts.show();
 			
 			}
 		});

        workshop_add.setOnClickListener(new View.OnClickListener() {
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
					if(regevents[i].equalsIgnoreCase(workshop_name.getText().toString()))
					{
						k=1;
						Toast.makeText(getApplicationContext(), "Added to myevents...", Toast.LENGTH_SHORT).show();
						
					}
				}
				
				String s=workshop_name.getText().toString();
				System.out.println(s);
				database.insertContact(s);
				database.close();
				if(k==0)
					Toast.makeText(getApplicationContext(), "Already added to myevents", Toast.LENGTH_SHORT).show();
					
   	
 			}
 		});

        
        
	}
	 static class ViewHolder {
	        TextView text;
	        TextView text2;
	        
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
