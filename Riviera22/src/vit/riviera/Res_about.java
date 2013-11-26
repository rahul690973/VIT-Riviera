package vit.riviera;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Res_about extends Activity {
		
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.res_about);
	        TextView r_name=(TextView)findViewById(R.id.r_name);
	        TextView r_loc=(TextView)findViewById(R.id.r_loc);
	        TextView r_spc=(TextView)findViewById(R.id.r_spc);
	        Bundle bundle=new Bundle();
	        bundle=getIntent().getExtras();
	        String name=bundle.getString("name");
	        String loc=bundle.getString("loc");
	        String spc=bundle.getString("spc");
	    	
		}	
}
