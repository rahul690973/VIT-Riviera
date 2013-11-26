package vit.riviera;

//package com.map;



import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

public class MapActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
      final  String longitude_dest="79.15915";
      final  String latitude_dest="12.97345";
      final String longitude_source="79.15909";
        final String latitude_source="12.97387";
        final String latEiffelTower = "12.973958";
       final String lngEiffelTower = "79.159091";
        
      //  Button b1=(Button)findViewById(R.id.button1);
       final WebView myWebView = (WebView) findViewById(R.id.webview);
       WebSettings webSettings = myWebView.getSettings();
       webSettings.setJavaScriptEnabled(true);
        
       // b1.setOnClickListener(new ImageButton.OnClickListener() {
	     //   public void onClick(View v)
	      //  {
	        	
	        	//Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr="+latitude_source+","+longitude_source+"&daddr="+latitude_dest+","+longitude_dest));
	        	//
	        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=15&size=200x200&sensor=false"));
	        	myWebView.loadUrl("http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=20&size=1400x1600&sensor=true");
	           // startActivity(i);
	            
	       // } 
	   // }); 
        
       
		
    }
    
    
}