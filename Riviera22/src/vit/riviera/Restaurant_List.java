package vit.riviera;

import vit.riviera.EventInfo;


import vit.riviera.List;

import vit.riviera.Res_about;
import vit.riviera.Weather;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Restaurant_List extends Activity {
	
	
	
	String[] items = { "Test text 1", "Test text 2", "Test text 3", "Test text 4", "Test text 5", "Test text 6" };
    /** Called when the activity is first created. */
	 String[] restaurant_names;
	 String[] restaurant_stars;
	 String[] restaurant_ac;
	 String[] restaurant_loc;
	 String[] restaurant_spc;
	 ListView list;
	 TextView l,s;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);
        Bundle b=getIntent().getExtras();
        restaurant_names=b.getStringArray("restaurant_names");
         restaurant_stars=b.getStringArray("restaurant_stars");
        restaurant_ac=b.getStringArray("restaurant_ac");
        restaurant_loc=b.getStringArray("restaurant_loc");
        restaurant_spc=b.getStringArray("restaurant_spc");
        System.out.println(restaurant_loc[0]);
        System.out.println(restaurant_spc[0]);

        System.out.println("in subcategory");
        System.out.println(restaurant_stars[0]);
        
          list = (ListView) findViewById(R.id.listview_restaurant);

        SpecialAdapter adapter = new SpecialAdapter(this, restaurant_names);
        list.setAdapter(adapter);
        list.setItemsCanFocus(false);
        final Dialog resto=new Dialog(this);
       resto.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        list.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View view, int position,
                    long id) {
            	System.out.println("e");
            	System.out.println(restaurant_names[position]);
            	resto.setContentView(R.layout.res);
            	
            	l=(TextView)resto.findViewById(R.id.loc);
            	s=(TextView)resto.findViewById(R.id.spe);
            	l.setText(restaurant_loc[position]);
            	s.setText(restaurant_spc[position]);
            	resto.show();
                         }
        });
		
        
        
        
        
    }
    
    static class ViewHolder {
        TextView text;
        ImageView im;
        TextView tv;
        LinearLayout l;
        TableLayout t;
    }
    
    
    private class SpecialAdapter extends BaseAdapter {
    	//Defining the background color of rows. The row will alternate between green light and green dark.
    	//private int[] colors = new int[] { 0xAAf6ffc8, 0xAA538d00 };
    	private LayoutInflater mInflater;

    	//The variable that will hold our text data to be tied to list.
    	private String[] data;

    	public SpecialAdapter(Context context, String[] items) {
    	    mInflater = LayoutInflater.from(context);
    	    this.data = items;
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
    	    convertView = mInflater.inflate(R.layout.restaurant_row, null);

    	    holder = new ViewHolder();
    	    holder.text = (TextView) convertView.findViewById(R.id.headline);
    	    holder.im = (ImageView) convertView.findViewById(R.id.twit);
    	    holder.tv=(TextView)convertView.findViewById(R.id.ac_nac);
    	    holder.l=(LinearLayout) convertView.findViewById(R.id.linear);
    	    holder.t=(TableLayout) convertView.findViewById(R.id.tableLayout1);
    	    convertView.setTag(holder);
    	} else {
    	    holder = (ViewHolder) convertView.getTag();
    	}
    	
    	    // Bind the data efficiently with the holder.
    	  holder.l.setBackgroundColor(R.drawable.moss_green);
    	 holder.t.setBackgroundColor(R.drawable.moss_green);
    	  
    	  
      	  
    	    holder.text.setText(data[position]);
    	    holder.tv.setText(restaurant_ac[position]);
    	    if(restaurant_stars[position].equalsIgnoreCase("5"))
    	    {
    	    	holder.im.setImageResource(R.drawable.fvstar);
    	    }
    	    else if(restaurant_stars[position].equalsIgnoreCase("4"))
    	    {
    	    	holder.im.setImageResource(R.drawable.fstar);
    	    }
    	    else if(restaurant_stars[position].equalsIgnoreCase("3"))
    	    {
    	    	holder.im.setImageResource(R.drawable.tstar);
    	    }
    	    

    	    //Set the background color depending of  odd/even colorPos result
    	    //int colorPos = position % colors.length;
    	 //   convertView.setBackgroundColor(colors[colorPos]);

    	   return convertView;
    	}
    	}
}