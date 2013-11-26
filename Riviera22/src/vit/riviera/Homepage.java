package vit.riviera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Homepage extends Activity
{
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.homepage);
	
	 
	 ImageButton homepage_events=(ImageButton)findViewById(R.id.homepage_events);
	 ImageButton homepage_reg_events=(ImageButton)findViewById(R.id.homepage_reg_events);
	 ImageButton homepage_proshows=(ImageButton)findViewById(R.id.homepage_proshows);
	 ImageButton homepage_restaurants=(ImageButton)findViewById(R.id.homepage_restaurants);
	 ImageButton homepage_vit=(ImageButton)findViewById(R.id.homepage_vit);
	 ImageButton homepage_contacts=(ImageButton)findViewById(R.id.homepage_contacts);
			 
	 homepage_proshows.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Homepage.this,
			proshows.class);

					Homepage.this.startActivity(myIntent);

			}
		});
 homepage_contacts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Homepage.this,
				contactprson.class);

					Homepage.this.startActivity(myIntent);

			}
		});
	 homepage_reg_events.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Homepage.this,
				RegisteredEvents.class);

					Homepage.this.startActivity(myIntent);

			}
		});
	 homepage_events.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Homepage.this,
				Division1.class);

					Homepage.this.startActivity(myIntent);

			}
		});
 homepage_vit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Homepage.this,
				vitmap.class);

					Homepage.this.startActivity(myIntent);

			}
		});
	 homepage_restaurants.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Homepage.this,
				Restaurant.class);

					Homepage.this.startActivity(myIntent);

			}
		});




	 }
	   
}
