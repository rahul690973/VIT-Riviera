package vit.riviera;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Description extends Activity
{
	String desc,rule1,rule2,rule3;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        Bundle bundle=getIntent().getExtras();
        String culturalnames=bundle.getString("culturalname");
        System.out.println(culturalnames);
        TextView t=(TextView)findViewById(R.id.event_desc_name);
        Typeface face1=Typeface.createFromAsset(getAssets(),"fonts/VeryChristmess.ttf");
        Typeface face2=Typeface.createFromAsset(getAssets(),"fonts/Titania.ttf");
        Typeface face3=Typeface.createFromAsset(getAssets(),"fonts/aescrawl.ttf");
        Typeface face4=Typeface.createFromAsset(getAssets(),"fonts/ashcanbb_reg.ttf");
          
        t.setTypeface(face1);
        t.setText(culturalnames);
        TextView aa=(TextView)findViewById(R.id.aa);
        TextView bb=(TextView)findViewById(R.id.bb);
        aa.setTypeface(face4);
        bb.setTypeface(face4); 
        
        LinearLayout l1=(LinearLayout)findViewById(R.id.descriptionofevents);
        LinearLayout l2=(LinearLayout)findViewById(R.id.rulesofevents);
       DBAdapter database=new DBAdapter(this);
        database.open();
        Cursor c=database.getrules(culturalnames);
        if(c.moveToFirst())
        {
        	do
        	{
        	desc=c.getString(0);
        	rule1=c.getString(1);
        	rule2=c.getString(2);
        	rule3=c.getString(3);
        	}while(c.moveToNext());
        }
        
        TextView d1=new TextView(this);
        TextView r1=new TextView(this);
        TextView r2=new TextView(this);
        TextView r3=new TextView(this);
        d1.setTextColor(Color.WHITE);
        r1.setTextColor(Color.WHITE);
        r2.setTextColor(Color.WHITE);
        r3.setTextColor(Color.WHITE);
   /*     d1.setTextColor(Color.BLACK);
        r1.setTextColor(Color.BLACK);
        r2.setTextColor(Color.BLACK);
        r3.setTextColor(Color.BLACK);*/
        
        d1.setTextSize(20);
        r1.setTextSize(20);
        r2.setTextSize(20);
        r3.setTextSize(20);
        
       d1.setText(desc);
       r1.setText(rule1);
       r2.setText(rule2);
       r3.setText(rule3);
       d1.setTypeface(face4);
       r1.setTypeface(face4);
       r2.setTypeface(face4);
       r3.setTypeface(face4);
       
       l1.addView(d1);
       l2.addView(r1);
       l2.addView(r2);
       l2.addView(r3);
       database.close();
        
	}
}
