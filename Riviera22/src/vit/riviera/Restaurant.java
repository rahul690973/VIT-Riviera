package vit.riviera;


import java.util.ArrayList;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Restaurant extends Activity
{
	 Cursor c;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);
        final DBAdapter5 database;
        database=new DBAdapter5(this);
        TextView finedine =(TextView)findViewById(R.id.finedine);
        TextView snacks =(TextView)findViewById(R.id.snacks);
        TextView steamy_non_veg =(TextView)findViewById(R.id.steamy_non_veg);
        TextView cafeteria =(TextView)findViewById(R.id.cafetaria);
        TextView dhabas =(TextView)findViewById(R.id.dhabas);
        
        
       
        Typeface font = Typeface.createFromAsset(getAssets(), "JudasPriest.ttf");
        
        finedine.setTypeface(font); 
        snacks.setTypeface(font); 
        dhabas.setTypeface(font); 
        cafeteria.setTypeface(font); 
        steamy_non_veg.setTypeface(font); 
        database.open(); 
        
       finedine.setOnClickListener(new View.OnClickListener() {
     	   public void onClick(View v)
     			{
     		   database.open();
     		   ArrayList<String> a =new ArrayList<String>();
     		  ArrayList<String> b=new ArrayList<String>();
     		  ArrayList<String> d=new ArrayList<String>();
     		  ArrayList<String> e=new ArrayList<String>();
     		  ArrayList<String> f=new ArrayList<String>();
       		
     		  c=database.getbyCategory("FineDine") ;
     		  if(c.moveToFirst())
     		  {
     			  do
     			  {
     				  String x=c.getString(0);
     				  String y=c.getString(3);
     				  String z=c.getString(4);
     				  String u=c.getString(1);
     				  String w=c.getString(2);
     				  System.out.println(x);
     				  System.out.println(y);
     				  a.add(x);
     				  b.add(y);
     				  d.add(z);
     				  e.add(u);
     				  f.add(w);
     				  
     			  }while(c.moveToNext());
     		  }
     		  database.close();
     		 Intent myIntent = new Intent(Restaurant.this,
 					Restaurant_List.class);
     		 Bundle bundle=new Bundle();
     		 String[] restaurant_names=a.toArray(new String[a.size()]);
     		 bundle.putStringArray("restaurant_names", restaurant_names);
     		 String[] restaurant_stars=b.toArray(new String[b.size()]);
     		 bundle.putStringArray("restaurant_stars", restaurant_stars);
     		 String[] restaurant_ac=d.toArray(new String[d.size()]);
     		 bundle.putStringArray("restaurant_ac", restaurant_ac);
     		 
     		 
     		String[] restaurant_loc=e.toArray(new String[b.size()]);
    		 bundle.putStringArray("restaurant_loc", restaurant_loc);
    		 String[] restaurant_spc=f.toArray(new String[d.size()]);
    		 bundle.putStringArray("restaurant_spc", restaurant_spc);
    		 
     		 myIntent.putExtras(bundle);
 		   Restaurant.this.startActivity(myIntent);
 	
     		   }
     		});
       
       snacks.setOnClickListener(new View.OnClickListener() {
     	   public void onClick(View v)
     			{
     		   database.open();
     		   ArrayList<String> a =new ArrayList<String>();
     		  ArrayList<String> b=new ArrayList<String>();
     		  ArrayList<String> d=new ArrayList<String>();
     		  ArrayList<String> e=new ArrayList<String>();
     		  ArrayList<String> f=new ArrayList<String>();
       		
     		  c=database.getbyCategory("Snacks") ;
     		  if(c.moveToFirst())
     		  {
     			  do
     			  {
     				  String x=c.getString(0);
     				  String y=c.getString(3);
     				  String z=c.getString(4);
     				  String u=c.getString(1);
     				  String w=c.getString(2);
     				  System.out.println(x);
     				  System.out.println(y);
     				  a.add(x);
     				  b.add(y);
     				  d.add(z);
     				  e.add(u);
     				  f.add(w);
     				  
     			  }while(c.moveToNext());
     		  }
     		  database.close();
     		 Intent myIntent = new Intent(Restaurant.this,
 					Restaurant_List.class);
     		 Bundle bundle=new Bundle();
     		 String[] restaurant_names=a.toArray(new String[a.size()]);
     		 bundle.putStringArray("restaurant_names", restaurant_names);
     		 String[] restaurant_stars=b.toArray(new String[b.size()]);
     		 bundle.putStringArray("restaurant_stars", restaurant_stars);
     		 String[] restaurant_ac=d.toArray(new String[d.size()]);
     		 bundle.putStringArray("restaurant_ac", restaurant_ac);
     		 
     		 
     		String[] restaurant_loc=e.toArray(new String[b.size()]);
    		 bundle.putStringArray("restaurant_loc", restaurant_loc);
    		 String[] restaurant_spc=f.toArray(new String[d.size()]);
    		 bundle.putStringArray("restaurant_spc", restaurant_spc);
    		 
     		 myIntent.putExtras(bundle);
 		   Restaurant.this.startActivity(myIntent);
 	
    
     		 		   }
     		});
    
      steamy_non_veg.setOnClickListener(new View.OnClickListener() {
     	   public void onClick(View v)
     			{
     		   database.open();
     		   ArrayList<String> a =new ArrayList<String>();
     		  ArrayList<String> b=new ArrayList<String>();
     		  ArrayList<String> d=new ArrayList<String>();
     		  ArrayList<String> e=new ArrayList<String>();
     		  ArrayList<String> f=new ArrayList<String>();
       		
     		  c=database.getbyCategory("Steamy Non Veg") ;
     		  if(c.moveToFirst())
     		  {
     			  do
     			  {
     				  String x=c.getString(0);
     				  String y=c.getString(3);
     				  String z=c.getString(4);
     				  String u=c.getString(1);
     				  String w=c.getString(2);
     				  System.out.println(x);
     				  System.out.println(y);
     				  a.add(x);
     				  b.add(y);
     				  d.add(z);
     				  e.add(u);
     				  f.add(w);
     				  
     			  }while(c.moveToNext());
     		  }
     		  database.close();
     		 Intent myIntent = new Intent(Restaurant.this,
 					Restaurant_List.class);
     		 Bundle bundle=new Bundle();
     		 String[] restaurant_names=a.toArray(new String[a.size()]);
     		 bundle.putStringArray("restaurant_names", restaurant_names);
     		 String[] restaurant_stars=b.toArray(new String[b.size()]);
     		 bundle.putStringArray("restaurant_stars", restaurant_stars);
     		 String[] restaurant_ac=d.toArray(new String[d.size()]);
     		 bundle.putStringArray("restaurant_ac", restaurant_ac);
     		 
     		 
     		String[] restaurant_loc=e.toArray(new String[b.size()]);
    		 bundle.putStringArray("restaurant_loc", restaurant_loc);
    		 String[] restaurant_spc=f.toArray(new String[d.size()]);
    		 bundle.putStringArray("restaurant_spc", restaurant_spc);
    		 
     		 myIntent.putExtras(bundle);
 		   Restaurant.this.startActivity(myIntent);
 	
    
     	 		   }
     		});
    
       cafeteria.setOnClickListener(new View.OnClickListener() {
     	   public void onClick(View v)
     			{
     		   database.open();
     		   ArrayList<String> a =new ArrayList<String>();
     		  ArrayList<String> b=new ArrayList<String>();
     		  ArrayList<String> d=new ArrayList<String>();
     		  ArrayList<String> e=new ArrayList<String>();
     		  ArrayList<String> f=new ArrayList<String>();
       		
     		  c=database.getbyCategory("Cafeteria") ;
     		  if(c.moveToFirst())
     		  {
     			  do
     			  {
     				  String x=c.getString(0);
     				  String y=c.getString(3);
     				  String z=c.getString(4);
     				  String u=c.getString(1);
     				  String w=c.getString(2);
     				  System.out.println(x);
     				  System.out.println(y);
     				  a.add(x);
     				  b.add(y);
     				  d.add(z);
     				  e.add(u);
     				  f.add(w);
     				  
     			  }while(c.moveToNext());
     		  }
     		  database.close();
     		 Intent myIntent = new Intent(Restaurant.this,
 					Restaurant_List.class);
     		 Bundle bundle=new Bundle();
     		 String[] restaurant_names=a.toArray(new String[a.size()]);
     		 bundle.putStringArray("restaurant_names", restaurant_names);
     		 String[] restaurant_stars=b.toArray(new String[b.size()]);
     		 bundle.putStringArray("restaurant_stars", restaurant_stars);
     		 String[] restaurant_ac=d.toArray(new String[d.size()]);
     		 bundle.putStringArray("restaurant_ac", restaurant_ac);
     		 
     		 
     		String[] restaurant_loc=e.toArray(new String[b.size()]);
    		 bundle.putStringArray("restaurant_loc", restaurant_loc);
    		 String[] restaurant_spc=f.toArray(new String[d.size()]);
    		 bundle.putStringArray("restaurant_spc", restaurant_spc);
    		 
     		 myIntent.putExtras(bundle);
 		   Restaurant.this.startActivity(myIntent);
 	
     		   }
     		});
    
       
       
       dhabas.setOnClickListener(new View.OnClickListener() {
     	   public void onClick(View v)
     			{
     		   database.open();
     		   ArrayList<String> a =new ArrayList<String>();
     		  ArrayList<String> b=new ArrayList<String>();
     		  ArrayList<String> d=new ArrayList<String>();
     		  ArrayList<String> e=new ArrayList<String>();
     		  ArrayList<String> f=new ArrayList<String>();
       		
     		  c=database.getbyCategory("Dhaba") ;
     		  if(c.moveToFirst())
     		  {
     			  do
     			  {
     				  String x=c.getString(0);
     				  String y=c.getString(3);
     				  String z=c.getString(4);
     				  String u=c.getString(1);
     				  String w=c.getString(2);
     				  System.out.println(x);
     				  System.out.println(y);
     				  a.add(x);
     				  b.add(y);
     				  d.add(z);
     				  e.add(u);
     				  f.add(w);
     				  
     			  }while(c.moveToNext());
     		  }
     		  database.close();
     		 Intent myIntent = new Intent(Restaurant.this,
 					Restaurant_List.class);
     		 Bundle bundle=new Bundle();
     		 String[] restaurant_names=a.toArray(new String[a.size()]);
     		 bundle.putStringArray("restaurant_names", restaurant_names);
     		 String[] restaurant_stars=b.toArray(new String[b.size()]);
     		 bundle.putStringArray("restaurant_stars", restaurant_stars);
     		 String[] restaurant_ac=d.toArray(new String[d.size()]);
     		 bundle.putStringArray("restaurant_ac", restaurant_ac);
     		 
     		 
     		String[] restaurant_loc=e.toArray(new String[b.size()]);
    		 bundle.putStringArray("restaurant_loc", restaurant_loc);
    		 String[] restaurant_spc=f.toArray(new String[d.size()]);
    		 bundle.putStringArray("restaurant_spc", restaurant_spc);
    		 
     		 myIntent.putExtras(bundle);
 		   Restaurant.this.startActivity(myIntent);
 	
     		   }
     		});
    
            
         
        
        if(global.restaurant_i==1)
        {
     	   System.out.println("In new database");
     database.insertContact("Vit Food Court", "Near Technology Tower, Vit Campus", "Food is excellent. Awesome place to hang out. Must try for its special flavour and dishes", "4","Ac" , "FineDine");
      database.insertContact("China Valley", "Opposite Vit, Near 3rd Gate", "Excellent place to dine for the chicken lovers. Chicken lollypop is a must try", "4", "Non Ac","Steamy Non Veg");   
        database.insertContact("Cafe Coffee Day", "1 km from VIT", "As you know a lot can happen over a coffee ", "5", "Ac", "Cafeteria");
       database.insertContact("Flo Cafe", "Opposite Vit University,Near Gaurang Mall", "Good ambience and food but expensive ", "5", "Ac", "Cafeteria");
       database.insertContact("Olive Kitchen", "1 km from VIT, Near CCD", "Food is very good and hygenic. Must try Banana lassi and Palak Dal", "4","Ac" ,"FineDine");
       database.insertContact("Sjt Canteen", "Sjt Buiding, VIT Campus", "A good place for both the vegetarians and non-vegetarians. The food has got a lot of variety", "4","Ac", "FineDine");
       database.insertContact("Amalas", "Opposite the Main Gate of Vit University", "Must try for the Chinese and Italians cuisines. Must visit for cheese omelet and chocolate pancake", "4", "Ac", "Snacks");
       database.insertContact("Andhra Spice", "Outside Main Gate of Vit University", "Super Biryani and Starters", "4", "Non Ac", "Steamy Non Veg");
       database.insertContact("Apna Dhaba","Near Main Gate of Vit University" , "Eat as much food as you like. Tastes like home.", "4", "Non Ac", "Dhaba");
       database.insertContact("Bihari Dhaba","Opposite Gate No 1  of Vit University" , "Eat as much food as you like. Tastes like home.", "4", "Non Ac", "Steam Non Veg");
       database.insertContact("Saleem Dhaba", "Opposite Gate No 3, Vit University", "Egg items are a must try and the chicken is also good", "3","Non Ac", "Steamy Non Veg");
        database.insertContact("Bihari Dhaba","Opposite Gate No 1  of Vit University" , "Eat as much food as you like. Tastes like home.", "4", "Non Ac", "Dhaba");
       database.insertContact("Punjabi Dhaba","In Cmc" , "Eat as much food as you like. Tastes like home.", "4", "Non Ac", "Dhaba");
       database.insertContact("Lalit Vihar", "Near C.M.C Hospital", "Excellent for the vegetarians only", "4", "Ac", "FineDine");
       database.insertContact("Hotel Riverview", "Near New Bustand, Vellore. Approx 6 kms from VIT", "Excellent for the non Vegetarians. Starters are awesome", "5", "Ac", "FineDine");
       database.insertContact("Hundreds Heritage", "Gandhinagar. Approx 3.2 km from Vit", "The food is very delicious and dont forget to try melon shake", "5", "Ac", "FineDine");
       database.insertContact("Surabhi Internationals", "Officers Lane, Vellore. Approx 10 km from Vit", "The food is too awesome but a little costly", "5", "Ac", "FineDine");
       database.insertContact("Grt Regency", "Near New Bus Stand. Approx 6 km from Vit", "The food is very delicious and dont forget to try melon shake", "5", "Ac", "FineDine");
       database.insertContact("The Daring Residency", "Officers Lane", "The food is very delicious here and dont miss starters" ,"5","Ac", "FineDine");
       database.insertContact("Chick in","Approx 1 km from Vit University Campus. Near CCD" ,"Excellent chicken and combo packs", "4", "Ac", "Snacks");
       database.insertContact("Limra","Near Gate No 2 , Allmart " ,"Awesome place for snacks. Must try the cheesesticks and rolls", "4", "Ac", "Snacks");
       database.insertContact("Big Chick","Opposite Gate No 3 of Vit University" ,"Excellent chicken and combo packs", "4", "Ac", "Snacks");
       database.insertContact("Quick Bites", "Approx 400 metres from Vit University", "Really good food. Services extremely fast", "4", "Ac", "Snacks");
       database.insertContact("Crisp & Cream", "Just opposite of Main Gate, Vit University", "Quite good for ice creams and pastries", "3", "Ac", "Snacks");
       database.insertContact("Dhaba Express", "100 metres from Main Gate, Vit University", "The food is awesome and quite good for the vegetarians", "3", "Non Ac", "Dhaba");
       database.insertContact("Saleem Dhaba", "Opposite Gate No 3, Vit University", "Egg items are a must try and the chicken is also good", "3","Non Ac", "Dhaba");
     database.insertContact("Sicily", "Near Gate No 2, Opposite Almart", "Awesome wood fried Pizza in Vellore. Good services.","3", "Ac", "Snacks");
   database.insertContact("Hot Eggs", "Opposite Gate No 2, Vit University", "Moderator cost and nice egg items", "3","Non Ac", "Snacks");
       database.insertContact("IceBerg Cafe", "Opposite Gate No  3 of Vit University", "Awesome place for drinks and ice creams", "4", "Non Ac", "Cafeteria");
       database.insertContact("Amul IceCream Parlour", "Gandhinagar, 2 km from Vit University","Variety of ice creams and shakes", "4","Ac", "Cafeteria");
       global.restaurant_i=0;
        }
     database.close();

	}
	
}
