package vit.riviera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Division1 extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division1);
        ImageButton division1_cultural=(ImageButton)findViewById(R.id.division1_cultural);
        ImageButton division1_sports=(ImageButton)findViewById(R.id.division1_sports);
        ImageButton division1_workshop=(ImageButton)findViewById(R.id.division1_workshop);
        
        
   	 division1_cultural.setOnClickListener(new View.OnClickListener() {
   			public void onClick(View v)
   			{
   		System.out.println("anshul");
   				Intent myIntent = new Intent(Division1.this,
   				Division2.class);

   					Division1.this.startActivity(myIntent);

   			}
   		});
   	 
   	 division1_sports.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Division1.this,
				Sports_display.class);

					Division1.this.startActivity(myIntent);

			}
		});
   	 
   	 division1_workshop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
		
				Intent myIntent = new Intent(Division1.this,
				Workshop_display.class);

					Division1.this.startActivity(myIntent);

			}
		});




	}
}
