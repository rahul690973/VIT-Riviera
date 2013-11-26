package vit.riviera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.app.Activity;

public class WeatherAdapter extends ArrayAdapter<Weather>{

    Context context; 
    int layoutResourceId;    
    Weather data[] = null;
    boolean bool[]=null;
    
    public WeatherAdapter(Context context, int layoutResourceId, Weather[] data,boolean[] b) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.bool=b;
        System.out.println("Hh");
        for(int i=0;i<b.length;i++)
        	System.out.println(b[i]);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new WeatherHolder();
          //  holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.chk=(RadioButton)row.findViewById(R.id.radio);
            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }
        
        Weather weather = data[position];
        holder.txtTitle.setText(weather.title);
       if(bool[position]==true)
        holder.chk.setChecked(true);
       else
    	   holder.chk.setChecked(false);
        //holder.imgIcon.setImageResource(weather.icon);
        
        return row;
    }
    
    static class WeatherHolder
    {
        //ImageView imgIcon;
        TextView txtTitle;
        RadioButton chk;
    }
}
