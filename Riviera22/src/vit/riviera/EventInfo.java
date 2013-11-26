package vit.riviera;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;





import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.app.DialogFragment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;





public class EventInfo extends Activity
{
	
	private TextView mLatLng;
    private TextView mAddress;
    private Button mFineProviderButton;
    private Button mBothProviderButton;
    private LocationManager mLocationManager;
    private Handler mHandler;
    private boolean mGeocoderAvailable;
    private boolean mUseFine;
    private boolean mUseBoth;
    String lati;
    String longi;

    // Keys for maintaining UI states after rotation.
    private static final String KEY_FINE = "use_fine";
    private static final String KEY_BOTH = "use_both";
    // UI handler codes.
    private static final int UPDATE_ADDRESS = 1;
    private static final int UPDATE_LATLNG = 2;

    private static final int TEN_SECONDS = 10000;
    private static final int TEN_METERS = 10;
    private static final int TWO_MINUTES = 1000 * 60 * 2;
    String longitude_dest;
    String latitude_dest;
	String s1,s2,s3,response,culturalnames,building;
	Dialog dialog2;
	TextView text1,text2,text3;
	String name,venue,date,time,fees,name1,contact1,name2,contact2,prize1,prize2,prize3;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventinfo);
        System.out.println("1");
        
        

      /*  Button b1=(Button)findViewById(R.id.button1);
        // Restore apps state (if exists) after rotation.
        if (savedInstanceState != null) {
            mUseFine = savedInstanceState.getBoolean(KEY_FINE);
            mUseBoth = savedInstanceState.getBoolean(KEY_BOTH);
        } else {
            mUseFine = false;
            mUseBoth = false;
        }
       // mLatLng = (TextView) findViewById(R.id.latlng);
       // mAddress = (TextView) findViewById(R.id.address);
        // Receive location updates from the fine location provider (gps) only.
      //  mFineProviderButton = (Button) findViewById(R.id.provider_fine);
        // Receive location updates from both the fine (gps) and coarse (network) location
        // providers.
        mBothProviderButton = (Button) findViewById(R.id.direction);
        
      b1.setOnClickListener(new ImageButton.OnClickListener() {
	       public void onClick(View v)
	       {
	        	
	        	Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr="+lati+","+longi+"&daddr="+latitude_dest+","+longitude_dest));
	        	//
	        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=15&size=200x200&sensor=false"));
	        	//myWebView.loadUrl("http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=20&size=1400x1600&sensor=true");
	            startActivity(i);
	            
	        } 
	    }); 
       

        // The isPresent() helper method is only available on Gingerbread or above.
        mGeocoderAvailable =
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;// && Geocoder.isPresent();

        // Handler for updating text fields on the UI like the lat/long and address.
        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE_ADDRESS:
                        mAddress.setText((String) msg.obj);
                        break;
                    case UPDATE_LATLNG:
                    	System.out.println((String)msg.obj);
                        mLatLng.setText((String) msg.obj);
                        break;
                }
            }
        };
        // Get a reference to the LocationManager object.
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);*/
                Bundle bundle=getIntent().getExtras();
       culturalnames=bundle.getString("culturalname");
        final TextView events_name=(TextView)findViewById(R.id.events_name);
        TextView events_venue=(TextView)findViewById(R.id.events_venue);
        TextView events_date=(TextView)findViewById(R.id.events_date);
        TextView events_time=(TextView)findViewById(R.id.events_time);
        TextView events_fees=(TextView)findViewById(R.id.events_fees);
        Button events_contacts=(Button)findViewById(R.id.events_contacts);
        Button events_winner=(Button)findViewById(R.id.events_winner);
        Button events_prize=(Button)findViewById(R.id.events_prize);
        Button events_rules=(Button)findViewById(R.id.events_about);
        Button events_direction=(Button)findViewById(R.id.events_direction);
        Typeface face1=Typeface.createFromAsset(getAssets(),"fonts/VeryChristmess.ttf");
        events_name.setTypeface(face1);
        Typeface face4=Typeface.createFromAsset(getAssets(),"fonts/ashcanbb_reg.ttf");
        
        
        dialog2 = new Dialog(this);
    	dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog2.setContentView(R.layout.winners);
        dialog2.setTitle("Winners...");
        
        text1 = (TextView) dialog2.findViewById(R.id.event_prize1);
         text2 = (TextView) dialog2.findViewById(R.id.event_prize2);
       text3 = (TextView) dialog2.findViewById(R.id.event_prize3);
        
        
        System.out.println("1");
        
        DBAdapter events_database=new DBAdapter(this);
        events_database.open();
        Cursor c=events_database.getAllContacts2(culturalnames);
        if(c.moveToFirst())
        {
        	do
        	{
       venue=c.getString(1);
       date=c.getString(2);
       time=c.getString(3);
       fees=c.getString(4);
       name1=c.getString(13);
       contact1=c.getString(14);
       name2=c.getString(15);
       contact2=c.getString(16);
       building=c.getString(17);
       prize1=c.getString(10);
       prize2=c.getString(11);
       prize3=c.getString(12);
       
       
        	}while(c.moveToNext());
        }
        events_database.close();
        System.out.println("nmes");
        System.out.println(name1);
        events_name.append(culturalnames);
        events_venue.append(venue);
        events_date.append(date);
        events_time.append(time);
        events_fees.append(fees);
        System.out.println("1");
        
 final Button events_add=(Button)findViewById(R.id.events_add);
       		final DBAdapter2 database=new DBAdapter2(this);
       events_add.setOnClickListener(new View.OnClickListener() {
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
 					if(regevents[i].equalsIgnoreCase(events_name.getText().toString()))
 					{
 						k=1;
 						Toast.makeText(getApplicationContext(), "Already added to myevents", Toast.LENGTH_SHORT).show();
 						
 					}
 				}
 				String s=events_name.getText().toString();
 				System.out.println(s);
 				database.insertContact(s);
 				if(k==0)
 					Toast.makeText(getApplicationContext(), "Added to myevents...", Toast.LENGTH_SHORT).show();
						
 				database.close();
 		
 			}
 		});
       
       events_rules.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				 Intent myIntent = new Intent(EventInfo.this,
	    					Description.class);
				 Bundle bundle=new Bundle();
				 bundle.putString("culturalname", culturalnames);
				 myIntent.putExtras(bundle);
	    		   EventInfo.this.startActivity(myIntent);
	    	
				}
		});
       
       final Dialog dialog=new Dialog(this);
       dialog.setContentView(R.layout.contacts);
       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
       String[] contact_name=new String[]{name1,name2};
       final String[] contact_number=new String[]{contact1,contact2};
       ListView contactslist=(ListView)dialog.findViewById(R.id.contactslist);
       SpecialAdapter adapter = new SpecialAdapter(this, contact_name,contact_number);
        
       contactslist.setAdapter(adapter);
       contactslist.setItemsCanFocus(true);
  	 PhoneCallListener phoneListener = new PhoneCallListener();
		TelephonyManager telephonyManager = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener,
				PhoneStateListener.LISTEN_CALL_STATE);

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
				callIntent.setData(Uri.parse("tel:"+contact_number[arg2]));
				startActivity(callIntent);
				
				/*Intent myIntent = new Intent(List.this,
						EventInfo.class);
				Bundle bundle=new Bundle();
				bundle.putString("culturalname", s);
				myIntent.putExtras(bundle);
					List.this.startActivity(myIntent);*/

				
				
			}
		});

       events_contacts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				dialog.show();
			}
		});
       
       
       events_winner.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				  if(haveNetworkConnection()==false) 
			      {
			    	  Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
			    	  Log.d("rahul","internet");
			      }
				  else
				 new query2().execute();
					
				}
		});
       final Dialog prize_dialog=new Dialog(this);
       prize_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
       
       events_prize.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				
				 prize_dialog.setContentView(R.layout.prize);
			prize_dialog.show();	
			TextView e_prize1=(TextView)prize_dialog.findViewById(R.id.event_prize1);
			TextView e_prize2=(TextView)prize_dialog.findViewById(R.id.event_prize2);
			TextView e_prize3=(TextView)prize_dialog.findViewById(R.id.event_prize3);
			if(prize1.equalsIgnoreCase(""))
			{
				prize1="NA";
			}
			
			e_prize1.setText(prize1);
			
			if(prize2.equalsIgnoreCase(""))
			{
				prize2="NA";
			}
			
			e_prize2.setText(prize2);
		
			if(prize3.equalsIgnoreCase(""))
			{
				prize3="NA";
			}
			
			e_prize3.setText(prize3);
		
			}
		});
       
     /*   */
       
   
      /*final Dialog dialog_priz=new Dialog(this);
       dialog_priz.setContentView(R.layout.prize);
      */

       
       final DBAdapter6 map_database=new DBAdapter6(this);
       
        
      events_direction.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				map_database.open();
				System.out.println(venue);
				Cursor d=map_database.getAllContacts(building);
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
				Intent myIntent = new Intent(EventInfo.this,
    					LocationActivity.class);
				Bundle b=new Bundle();
				b.putString("lat", latitude);
				b.putString("lon", longitude);
				myIntent.putExtras(b);
			   EventInfo.this.startActivity(myIntent);
    	
				
			}
		});
       
      
             
     
       System.out.println("1");

        
      

        
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
	    

	    
	    class query2 extends AsyncTask<String, String, Void>
		 {
		 	
		 	
		 private ProgressDialog progressDialog = new ProgressDialog(EventInfo.this);
		     InputStream is = null ;
		     String result = "";
		     protected void onPreExecute() {
		        progressDialog.setMessage("Fetching...");
		        progressDialog.show();
		        progressDialog.setOnCancelListener(new OnCancelListener() {
		 	public void onCancel(DialogInterface arg0) {
		 		query2.this.cancel(true);
		 	   }
		 	});
		      }
		        @Override
		 	protected Void doInBackground(String... params) {
		 	  String url_select = "http://adgvit.in.previewdns.com/cond.php";
		         System.out.println("hello");
		 	  HttpClient httpClient = new DefaultHttpClient();
		 	  HttpPost httpPost = new HttpPost(url_select);
		 	  

		           ArrayList<NameValuePair> nameValuePairs3 = new ArrayList<NameValuePair>();
		       
		          nameValuePairs3.add(new BasicNameValuePair("user",culturalnames));
		           System.out.println("hello2");

		       
		 	    try {
		 			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs3));

		 		HttpResponse httpResponse = httpClient.execute(httpPost);
		 		 ResponseHandler<String> responseHandler = new BasicResponseHandler();
		 		response = httpClient.execute(httpPost, responseHandler);
		 		Log.d("rahul",response);
		   System.out.println(response);
		 		HttpEntity httpEntity = httpResponse.getEntity();
		 		System.out.println(response);
		 		//read content
		 		is =  httpEntity.getContent();
		 		System.out.println(response);
		 		//httpClient.getConnectionManager().shutdown();
		 		} catch (Exception e) {

		 		Log.e("log_tag", "Error in http connection "+e.toString());
		 		}
		 
		 			return null;

		 		}
		 	
		 		

		 	
		 protected void onPostExecute(Void v) {

			 try{
				 progressDialog.dismiss();
				 System.out.println("hi");
			   JSONArray jArray = new JSONArray(response);
			   System.out.println("hi there");
			    JSONObject json_data=null;
	           System.out.println("no");
	         
	         for(int i=0;i<jArray.length();i++)
	         {
	        	 System.out.println("yes");
	          json_data=jArray.getJSONObject(i);
	          s1=json_data.getString("winone");
	          s2=json_data.getString("wintwo");
	          s3=json_data.getString("winthr");
	          
	         }
	         
	         
	    if(s1.equals("") && s2.equalsIgnoreCase("") && s3.equalsIgnoreCase(""))
	    {
	Toast.makeText(getApplicationContext(), "Not declared yet..", Toast.LENGTH_SHORT).show();    	
	    }
	    else
	    {
	     	
text1.setText(s1);
text2.setText(s2);
text3.setText(s3);

dialog2.show();
	    }
	 		
	 		
	 		
	 		

	 		
	 		
	 		
	 		
	 		


	 		
			 }
			catch(JSONException e){
	             Log.e("log_tag", "Error parsing data "+e.toString());
	     }
		 	
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
   
	    
	    private boolean haveNetworkConnection() {
	        boolean haveConnectedWifi = false;
	        boolean haveConnectedMobile = false;

	        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
	        for (NetworkInfo ni : netInfo) {
	            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
	                if (ni.isConnected())
	                    haveConnectedWifi = true;
	            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
	                if (ni.isConnected())
	                    haveConnectedMobile = true;
	        }
	        return haveConnectedWifi || haveConnectedMobile;
	    }
	    
	    
	    
	  
}
