package vit.riviera;
 
import java.util.ArrayList;



import java.util.ArrayList;



import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;
import android.widget.Toast;
 
public class contactprson extends Activity implements OnChildClickListener{
 
	private ArrayList<String> groups;
	GestureLibrary mLibrary;
	private ArrayList<ArrayList<ArrayList<String>>> childs;
	String tag="evevnts";
 String LOGTAG="EVENTS";
 Dialog dialog1,dialog2,dialog3;
 
 OnChildClickListener my;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.cont);
        ExpandableListView l = (ExpandableListView) findViewById(R.id.Exp);
 
        loadData();
 
        myExpandableAdapter adapter = new myExpandableAdapter(this, groups, childs);
		l.setAdapter(adapter);
		
		
		 PhoneCallListener phoneListener = new PhoneCallListener();
			TelephonyManager telephonyManager = (TelephonyManager) this
					.getSystemService(Context.TELEPHONY_SERVICE);
			telephonyManager.listen(phoneListener,
					PhoneStateListener.LISTEN_CALL_STATE);
		
		 
		 
		// mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
	        
        /* if (!mLibrary.load()) {
      
           finish();
      
         }*/
      
       
      
        

		l.setOnChildClickListener(this);
		//elv=getExpandableListView();
		
		
		/*l.setOnChildClickListener(new OnChildClickListener() {

	        public boolean onChildClick(ExpandableListView parent, View v,
	                int groupPosition, int childPosition, long id) {
	            Log.d(tag,Integer.toString(childPosition));
	           // v.setBackgroundColor(0x000000);
	            return false;
	        }
	    });*/
		
	
		
    }
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Log.i("Test",Integer.toString(childPosition));
        Log.i("test",Integer.toString(groupPosition));
        
        if(childPosition==0 && groupPosition==0)
        {
        	//Log.i("yes","it works");
        	//Toast.makeText(getApplicationContext(), "hi rahul",Toast.LENGTH_SHORT);
             // dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
             // final Dialog dialog = new Dialog(this, R.style.FullHeightDialog);
      		//dialog1.setContentView(R.layout.dialog);
      		//dialog1.show();
      		
        	
        }
        
        if(childPosition==0 && groupPosition==1)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566814676"));
			startActivity(callIntent);
             
      		
        	
        }
        
        
        if(childPosition==1 && groupPosition==1)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9159385292"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==2 && groupPosition==1)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9952866121"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==2)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566812530"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==1 && groupPosition==2)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566812347"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==3)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9597737780"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==4)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9487303774"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==1 && groupPosition==4)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9159814713"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==5)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9092636101"));
			startActivity(callIntent);
             
      		
        	
        }
        
        if(childPosition==0 && groupPosition==6)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566809467"));
			startActivity(callIntent);
             
      		
        	
        }
        
        if(childPosition==0 && groupPosition==7)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566812462"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==8)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:8220665553"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==1 && groupPosition==8)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9940917471"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==9)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9597870266"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==10)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9442757110"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==1 && groupPosition==10)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566811345"));
			startActivity(callIntent);
             
      		
        	
        }
        
        if(childPosition==0 && groupPosition==11)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9159814911"));
			startActivity(callIntent);
             
      		
        	
        }
        
        if(childPosition==0 && groupPosition==12)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566812462"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==1 && groupPosition==12)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9597737780"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==13)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9655281690"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==1 && groupPosition==13)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9884401614"));
			startActivity(callIntent);
             
      		
        	
        }
        if(childPosition==0 && groupPosition==14)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566811218"));
			startActivity(callIntent);
             
      		
        	
        }
        
        if(childPosition==1 && groupPosition==14)
        {
        	Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:9566811287"));
			startActivity(callIntent);
             
      		
        	
        }
        
        
        return false;
    }
    
    
            
        
 
    public class myExpandableAdapter extends BaseExpandableListAdapter {
 
    	private ArrayList<String> groups;
 
        private ArrayList<ArrayList<ArrayList<String>>> children;
 
    	private Context context;
 
    	public myExpandableAdapter(Context context, ArrayList<String> groups, ArrayList<ArrayList<ArrayList<String>>> children) {
            this.context = context;
            this.groups = groups;
            this.children = childs;
        }
 
 
    	@Override
        public boolean areAllItemsEnabled()
        {
            return true;
        }
 
 
        @Override
        public ArrayList<String> getChild(int groupPosition, int childPosition) {
            return children.get(groupPosition).get(childPosition);
        }
 
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }
 
 
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,View convertView, ViewGroup parent) {
 
        	String child = (String) ((ArrayList<String>)getChild(groupPosition, childPosition)).get(0);
 
            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.cont2, null);
            }
 
           TextView childtxt = (TextView) convertView.findViewById(R.id.TextViewChild01);
           
         
            
           
 
            childtxt.setText(child);
            Typeface face1=Typeface.createFromAsset(getAssets(),"fonts/nevis.ttf");
            childtxt.setTypeface(face1);
           
           /* childtxt.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                   Log.d(tag,"button push");
                }
            });   */   
            
            
 
            return convertView;
           
    		
        }
        
       // setOnChildClickListener(myOnChildClick);
      /* OnChildClickListener my= new OnChildClickListener() {

	        @Override
	        public boolean onChildClick(ExpandableListView l, View convertView, int groupPosition, int childPosition,
	                long arg4) {
	        	
	        	Log.d(tag,Integer.toString(groupPosition));
	            // TODO Auto-generated method stub
	            return true;
	        }

	    };*/
 
        @Override
        public int getChildrenCount(int groupPosition) {
            return children.get(groupPosition).size();
        }
 
        @Override
        public String getGroup(int groupPosition) {
            return groups.get(groupPosition);
        }
 
        @Override
        public int getGroupCount() {
            return groups.size();
        }
 
        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }
 
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
 
        	String group = (String) getGroup(groupPosition);
 
        	if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.cont1, null);
            }
 
            TextView grouptxt = (TextView) convertView.findViewById(R.id.TextViewGroup);
            
           
 
            grouptxt.setText(group);
            Typeface face=Typeface.createFromAsset(getAssets(),"fonts/nevis.ttf");
            grouptxt.setTypeface(face);
            grouptxt.setTextSize(25);
            grouptxt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
               Log.d(tag,"button push");
            }
        });    
 
            return convertView;
        }
 
        @Override
        public boolean hasStableIds() {
            return true;
        }
 
        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }
 
    }
 
    private void loadData(){
    	groups= new ArrayList<String>();
    	childs= new ArrayList<ArrayList<ArrayList<String>>>();
 
    	groups.add("Convener");
        groups.add("Proshows");
        groups.add("culturals n events");
        groups.add("Design n edit");
        groups.add("Gen.Enquiry");
        groups.add("Guestcare(studnts)");
        groups.add("Hall arrngmnts");
        groups.add("Printing");
        groups.add("Marketing");
        groups.add("Purchase");
        groups.add("Reception n rgstration");
        groups.add("Sales");
        groups.add("spcl guestcare");
        groups.add("sports");
        groups.add("sponsor n stall");
        
    	
    
 
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(0).add(new ArrayList<String>());
        childs.get(0).get(0).add("Prof. Amit Mahindrakar");
       // childs.get(0).add(new ArrayList<String>());
       /* childs.get(0).get(1).add("Held");
        childs.get(0).add(new ArrayList<String>());
        childs.get(0).get(2).add("Remaining");
        childs.get(0).add(new ArrayList<String>());
        childs.get(0).get(3).add("Attended");
        childs.get(0).add(new ArrayList<String>());
        childs.get(0).get(4).add("Missed");*/
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(1).add(new ArrayList<String>());
        childs.get(1).get(0).add("Krishna Gupta");
        childs.get(1).add(new ArrayList<String>());
        childs.get(1).get(1).add("Sadhna Sinha");
        childs.get(1).add(new ArrayList<String>());
        childs.get(1).get(2).add("Senthil Kumar");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(2).add(new ArrayList<String>());
       
        childs.get(2).get(0).add("Sainand Angampally");
        childs.get(2).add(new ArrayList<String>());
        childs.get(2).get(1).add("Shobhika Mathur");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(3).add(new ArrayList<String>());
        childs.get(3).get(0).add("Varun Ramani");
        
        childs.add(new ArrayList<ArrayList<String>>());//hall
        childs.get(4).add(new ArrayList<String>());
        childs.get(4).get(0).add("Annie Monica");
        childs.get(4).add(new ArrayList<String>());
        childs.get(4).get(1).add("Dharmika Chaudhary");
        
        
        childs.add(new ArrayList<ArrayList<String>>());//print
        childs.get(5).add(new ArrayList<String>());
        childs.get(5).get(0).add("Aditya Raj");
        
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(6).add(new ArrayList<String>());
        childs.get(6).get(0).add("Gembali Swaroop");
        
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(7).add(new ArrayList<String>());
        childs.get(7).get(0).add("Ashutosh Agarwal");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(8).add(new ArrayList<String>());
        childs.get(8).get(0).add("Ayaz Mahmood");
        childs.get(8).add(new ArrayList<String>());
        childs.get(8).get(1).add("Smit Pandey ");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(9).add(new ArrayList<String>());
        childs.get(9).get(0).add("Karthik. S");
        
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(10).add(new ArrayList<String>());
        childs.get(10).get(0).add("Alban Prashanth");
        childs.get(10).add(new ArrayList<String>());
        childs.get(10).get(1).add("Nithin Katragadda");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(11).add(new ArrayList<String>());
        childs.get(11).get(0).add("Bonala Sai Sharan");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(12).add(new ArrayList<String>());
        childs.get(12).get(0).add("Ashutosh Agarwal");
        childs.get(12).add(new ArrayList<String>());
        childs.get(12).get(1).add("Varun Ramani");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(13).add(new ArrayList<String>());
        childs.get(13).get(0).add("Garishma Keyal");
        childs.get(13).add(new ArrayList<String>());
        childs.get(13).get(1).add("Neal Manjeshwar");
        
        childs.add(new ArrayList<ArrayList<String>>());
        childs.get(14).add(new ArrayList<String>());
        childs.get(14).get(0).add("Mohan Prashanth ");
        childs.get(14).add(new ArrayList<String>());
        childs.get(14).get(1).add("Sashi Kumar");
        
        
       
        
       
        
       /* myExpandableAdapter m=new myExpandableAdapter(this,groups,childs);
        ArrayList<String> s=m.getChild(0, 1);
        
        for(int i=0;i<s.size();i++)
        {
        	Toast.makeText(getApplicationContext(), s.get(i), Toast.LENGTH_SHORT).show();
        	Log.d(tag,s.get(i));
        }*/
       
 
       
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
