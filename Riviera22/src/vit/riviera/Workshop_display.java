package vit.riviera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Workshop_display extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("1");
        setContentView(R.layout.workshop_display);
        String[] workshop_name=new String[]{"DJing & Music","Soft Skills","Speak Up!" ,"Fashion Photography", "Actor Training and Voice Modulation","Craft Bizarre","Pottery, Clay, Molding, TerraCotta and Jewellary","Hip Hop",
        		"FreeStyle","Metal Art & Coffee Painting","Micro Art"};
        
 ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,workshop_name);
 System.out.println("1");
        
       ListView listView1 = (ListView)findViewById(R.id.workshop_display_listview);
         
       final View header = (View)getLayoutInflater().inflate(R.layout.workshop_header, null);
      listView1.addHeaderView(header);
       
      System.out.println("1");
       
    
       listView1.setAdapter(adapter);
        listView1.setItemsCanFocus(false);
        System.out.println("1");
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(arg1==header)
				{
					
				}
				else
				{
				ListView lv=(ListView)arg0;
				String tv= (String) arg0.getItemAtPosition(arg2);
				
				System.out.println(tv);
				
				Intent myIntent = new Intent(Workshop_display.this,
					Workshop.class);
					Bundle bundle=new Bundle();
					bundle.putString("workshopname", tv);
					myIntent.putExtras(bundle);
					Workshop_display.this.startActivity(myIntent);

				}
				
			}
		});
 DBAdapter4 database=new DBAdapter4(this);
 database.open();
 if(global.workshop_i==1)
 {
	 
	 database.insertContact("DJing & Music", "", "8th-9th Feb 2013", "", "This workshop is intended to equip aspiring DJs/Producers to get started with the right material in a short span of time with guidance from the right artists in the underground scene. It is also interesting to note that commercial Production and DJing courses in metropolitan cities cost over Rs 1 Lakh. This is a unique opportunity for students to get started with a very small fraction of the price", "description2", "500", "Rithesh Kumar", "9486071641", "Karthik Kannan", "99400948570");
	 
	  database.insertContact("Soft Skills", "Chenna Reddy Auditorium", "9th Feb 2013", "9:30 am - 1:00pm", "This workshop will enhance an individual's interactions, performance and career prospects. Soft Skills are behavioural competencies. Also known as Interpersonal Skills, or people skills, they include proficiencies such as communication skills, conflict resolution and negotiation, personal effectiveness, creative problem solving, strategic thinking, team building, influencing skills and selling skills,", "This workshop provides the participants an orientation-cum-practice on how to bring to light the unseen talent and strengthen their soft skills. By taking part in practical oriented sessions and exercises throughout the workshop, participants will progressively learn techniques and tips to show their soft skills.", "100", "S.Kumar", "9655552525", "", "");
	  
	 database.insertContact("Speak Up!", "Dr. Ambedkar Auditorium", "1st Feb 2013", "1:45 pm - 6pm", "The workshop will focus on public speaking, how to conduct yourself while communicating and most importantly how to build arguments. An Overwhelming number of formats of debate are followed internationally; but the yardstick by which a debaters abilities are gauged by the world, is his prowess at Parliamentary Debate (PD). This form of competitive, extemporaneous debate stresses rigorous argumentation, logical analysis, quick thinking, breadth of knowledge, and rhetorical ability.", "", "100", "Jitin Kohli", "8870652524", "Damini Agrawal", "9566820095");
	 

	 database.insertContact("Fashion Photography", "MB 210", "6th Feb 2013", "1pm - 5pm", "Fashion is in the sky, in the street; fashion has to do with ideas, the way we live, what is happening. “Fashion is a form of ugliness so intolerable that we have to alter it every six months said a famous designer. This workshop will teach you how to immortalise styles, capture the essence of fashion from behind the lens.", "Rahul Dev is a Chennai based fashion photographer. (https://www.facebook.com/rahuldev). He is a treasure trove of talent. He has a professional full time experience of more than 10 years. Do not miss the chance of being a part of the workshop and learn the tricks of the trade.", "350", "Balaji", "9944477739", "Sai Vignesh", "9176234787");
	 

	database.insertContact("Actor Training and Voice Modulation", "CDMM", "9th Feb 2013", "9 am - 1pm", "The workshop is intended to hone theatre skills of upcoming dramatists at the college level. This workshop also intends to introduce beginners to the art of theatre. The workshop intends to focus on core areas of acting as well as touch on the finer points of direction and stage management.", "", "regfees", "Ashwini Duraiswamy", "88708388300", "Chiraj Panjwani", "9597874465");

	database.insertContact("Craft Bizarre", "", "3rd-4th Feb 2013", "", "Ever seen one of those beautiful and intricately done lampshades and exquisite wall decorations and wondered if they could be yours? Well, not only you can have it, but you can make one as well!", "For the first time in Riviera, Apical Crafts brings to you an exclusive and fun-filled workshop 'Craft Bizarre' on paper quilling and paper lamp making. Apical Crafts is the world’s largest specialty retailer of arts, crafts, framing, floral, wall décor, and seasonal merchandise for the hobbyist and do-it-yourself home decorator. Starting right from the scratch with the basics of paper cutting to basic quilling shapes to going on to making beautiful embellishments, this workshop has it all.", "10000", "Varun Chawla", "9944500764", "Garima Tayal", "8056028881");


	database.insertContact("Pottery, Clay, Molding, TerraCotta and Jewellary", "Foodys", "6th-9th Feb 2013", "9am - 5pm", "This is a one-on-one experience with our professional potter who will demystify the craft with hands on experience. Mr. Pavan Kumar is a specialist in pottery, murals and sculptures. He runs an institution in Bangalore known as Gopni. The material used for Pottery is Natural Clay and is completely harmless.", "Hand building, throwing on the potter's wheel, glazing and fire will be done on the site. Also painting of the pots and jewels will be demonstrated. All materials will be provided by us. Students can take back the things they make in the workshop.", "150", "Gitanjali", "name1", "", "");



	database.insertContact("Hip Hop", "", "8th Feb 2013", "9 am - 5 pm", "This workshop is for all those aspiring b-boys and b-girls who haven't yet had the chance to build on their b-boying skills and all those interested in various forms of hip-hop like top-rocking, housing, popping and more!! And the workshop isn't only for dancers. Even people who are putting on their dance shoes for the first time can gel in equally.", "The workshop will be held in 2 batches of 2 hours each. The first hour will include basic top-rocking, down-rocking and a few power moves for even the beginners to show off. The second hour will be for styles like housing. But the seats for each session are limited. So hurry up, join us and learn some of the craziest moves in the quickest ways.", "", "", "", "", "");





	database.insertContact("FreeStyle", "", "6th Feb 2013", "9 am - 5 pm", "This workshop will be taken by Mr.Anjan Sivakumar, the dancer responsible for bringing the Hip Hop Championship to India. He set up Choreo Culture, a complete dance academy in the UK a few years back with the help of Omar Paloma, the director of Hip Hop International, United Kingdom", "The workshop will be held in 1 batch of 2 hours. The first hour will include basic Hip-hop styles. The second hour will be for styles defining chivalry and grace i.e. Ballroom salsa. But the seats for each session are limited. Waste no time; join us to become the master of the dance floo", "", "", "", "", "");


	database.insertContact("Metal Art & Coffee Painting", "TT 434 and 434A", "6th - 7th Feb 2013", "10 am - 4 pm", "The workshop is to impart a learning of two different and new forms of painting namely metal art and coffee painting. Metal art is a carved and emboss form of art where the engraving on the metal is the key prospect in the painting. The look of the painting is basically through the shine and paint contrasts. Coffee Painting is something that uses the simple coffee and its different shade in darkness to make a painting like no other.", "", "350", "Akash Agrawal", "9952657423", "", "");


	database.insertContact("Micro Art", "TT Gallery 1", "6th-7th Feb 2013", "10 am - 4 pm", "Akash Kumar Gupta, a 23 year old Guinness record holder has mastered the realms of micro art but how do you know we aren't exaggerating? Because he has written the Geeta on a wristwatch and the Ramayana on a finger ring! And he’s going to share his rare talent with us.", "", "200", "Archana Golla", "8870977378", "Srujanaya Rameneni", "9566233889");
global.workshop_i=0;
	 
	 
	 
 }	
 database.close();
 }
    
}
