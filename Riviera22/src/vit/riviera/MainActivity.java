package vit.riviera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
    DBAdapter database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       ImageButton main_aboutus=(ImageButton)findViewById(R.id.main_aboutus);
       ImageButton main_information=(ImageButton)findViewById(R.id.main_information);
       ImageButton main_click=(ImageButton)findViewById(R.id.main_click);
        
       main_click.setOnClickListener(new View.OnClickListener() {
	   public void onClick(View v)
			{
		/*   database.open();
		   Cursor c=database.getAllContacts("Rock on");
		  
		   if(c.moveToFirst())
		   {
			   do
			   {
				   String s=c.getString(0);
				   System.out.println(s);
			   }while(c.moveToNext());
		   }
		   database.close();*/
		 Intent myIntent = new Intent(MainActivity.this,
					Homepage.class);
		   MainActivity.this.startActivity(myIntent);
		   }
		});
       
       
       main_information.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		/*   database.open();
    		   Cursor c=database.getAllContacts("Rock on");
    		  
    		   if(c.moveToFirst())
    		   {
    			   do
    			   {
    				   String s=c.getString(0);
    				   System.out.println(s);
    			   }while(c.moveToNext());
    		   }
    		   database.close();*/
    		 Intent myIntent = new Intent(MainActivity.this,
    					sponsor.class);
    		   MainActivity.this.startActivity(myIntent);
    		   }
    		});
       
       main_aboutus.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v)
    			{
    		/*   database.open();
    		   Cursor c=database.getAllContacts("Rock on");
    		  
    		   if(c.moveToFirst())
    		   {
    			   do
    			   {
    				   String s=c.getString(0);
    				   System.out.println(s);
    			   }while(c.moveToNext());
    		   }
    		   database.close();*/
    		 Intent myIntent = new Intent(MainActivity.this,
    					aboutus.class);
    		   MainActivity.this.startActivity(myIntent);
    		   }
    		});

       
       System.out.println("before");
       System.out.println(global.i);
       
       database=new DBAdapter(this);
       database.open(); 
       System.out.println("after");
       System.out.println(global.i);
       if(global.i==1)
       {
    	   System.out.println("in main");
    	   database.insertContact("Style Check", "Anna Auditorium", "08 Feb 2013", "9 am - 1 pm", "Premium Events", "With designers whose creativity stands to redefine fashion and models whose elegance and confidence knows no limits, Style Check is poised to give a Carte Blanche to the evolution of fashion. If you are an artist whose designs simply dazzle and amaze or you are a model whose confidence is equally simmered with your elegance Be a part of this revolution.","250", "A team per college is allowed to participate. A maximum of 15 members per team.", "Teams are free to be innovative and creative in terms of music, clothes, accessories and props, which should strongly reflect the theme which they wish to portray.", "    Only on the completion of Round 1, Round2 will start ; in the same order of teams thus giving teams sufficient time to prepare themselves.", "", "", "", "Heena Sharma", "9566812769", "", "","Anna Auditorium");   
    	   
    	    database.insertContact("Riviera's Got Talent", "Anna Auditorium", "08 Feb 2013", "1 pm - 4pm", "Premium Events", "Vellore Institute of Technology presents Riviera’s Got Talent for the very first time. The kind of talent that can be showcased includes: Singers, Musicians, Magicians, Dancers, Folk Acts, Impressionists, Stand-Up Comedy,Impersonation and Illusion.", "" , "Partcipation can be individual/group(no upper limit on the number of members in each group", "All participants will be given 3 minutes(max) for the first round performance", "The participants who get shortlisted for the second/final round will have to present an act which is different from the act performed by them in the first round.", "", "", "", "Abhinav Kishore","09894530977", "Vikram Prakash", "08122934389","Anna Auditorium");
    	    
    	   database.insertContact("Streets", "BasketBall Court", "08 Feb 2013", "1 pm - 5 pm", "Premium Events", "Kill the Beat! B-boying and Street dancing was created and developed as part of Hip-hop culture among African Americans and Latino youths in New York City. It consists of four primary elements: toprock, downrock, power moves and freezes. B-boying is gaining popularity among the youth in India and this Riviera, we bring it to VIT. So, put on your kicks and Kill the Beat..", "200", "Min/Max participants on Stage/Team: 4-10 members", "In the first round,all the teams need to give a showcase(i.e performance) for 3 mins.", "Round 2(knockout stage) : This round will be a crew vs crew battle between the selected teams.Fixtures will be decided on the spot.", "", "", "", "Yashwardhan Agrawal", "9566812558 ", "Anup Ray", "7845771494 ","BasketBall Court");
    	   
    	   database.insertContact("Role Play", "Chenna Reddy Auditorium", "08 Feb 2013", " 9 am - 5 pm", "Premium Events","This is an event in which teams from several other colleges will stage their plays and compete against each other. VIT dramatics club will stage a host performance but will not compete for the first prize, though we will be competing for the best actor. Both original as well as adapted scripts would be accepted. There is a prize for the best actor. A theme would be provided to the teams before hand around which their play has to revolve.", "", "The plays cannot be longer than 40 minutes", "The cast can have a maximum of 10 members.", "The teams will have to carry their own props and costumes.","", "", "", "Shivam Pal", "7708244661", "Payal Varma", "8940313506","Main Building");
    	   
    	   database.insertContact("Acoustic Vibes", "Greeno", "07 Feb 2013", "9 am - 5 pm", "Premium Events", "Acoustic Vibes is an event characterized by the mellow sounds of acoustic music. A competition for bands from VIT as well as external COLLEGES ONLY- entries are to be sent in via mail (videos of recorded performances, or studio recordings) and the best of them go through to the competition. Send us your link(youtube or any other video service) in a mail to vitmusicclub@gmail.com. With subject Acoustic Vibes 2013.", "100", "Solo performances are NOT allowed.", "Bands must have a minimum of 3 members and a maximum of 7 members", "Bands cannot use electric guitars, distortion or double bass pedals for drums.", "", "", "", "Avnish Bagchi", "9765138602", "Parth Bhatt", "7639679675","Greeno");
    	   
    	   database.insertContact("Raaga Reggae", "Greeno", "08 Feb 2013", "9 am - 5 pm", "Premium Events", "Raaga Reggae is a competition for folk, Indian, regional or even fusion based music . A competition for bands from VIT as well as external collges - entries are to be sent-in via mail (videos of recorded performances, or studio recordings) and the best of them go through to the competition. Send us your link(youtube or any other video service) in a mail to vitmusicclub@gmail.com with the subject as Raaga Reggae 2013.", "100", "Minimum 2 members in a band. Solo performances are not allowed", "A maximum of 20 minutes given to each performance. (15 mins+5 mins for soundcheck)","Bands must register the names of band members and songs to be performed before they enter the competition.","", "", "", "Bimal Thankachan", "07639811650", "Parth Bhatt", "07639679675","Greeno");
    	   
    	   database.insertContact("Resonance", "Greeno", "06 Feb 2013", "11 am - 5 pm", "Premium Events", "Resonance is an event characterized by the mellow sounds of acoustic music. A competition for bands from VIT as well as external COLLEGES ONLY- entries are to be sent in via mail (videos of recorded performances, or studio recordings) and the best of them go through to the competition. Send us your link(youtube or any other video service) in a mail to vitmusicclub@gmail.com. With subject Acoustic Vibes 2013.", "100", "Bands must have a minimum of 3 members and a maximum of 7 members.", "Bands must register the names of band members and the songs to be performed before they enter the competition.", "Bands cannot use electric guitars, distortion or double bass pedals for drums.", "", "", "", "Avnish Bagchi", "9765138602", "Parth Bhatt", "7639679675","Greeno");
    	   
    	   database.insertContact("Frisk Factor", "Anna Auditorim", "07 Feb 2013", "9 am - 1 pm", "Premium Events", "Two categories thematic and non-thematic. Teams registering for frisk factor should first mail a YOUTUBE link of their recent dance performance(3-5min) with the name of their team leader and the other members in the team to vit.rivieradance13@gmail.com. Last date for submission 2nd Feb 2013 by 6 pm evening. ", "250", "Min of 8 and max of 25 members per team", "Teams shortlisted for prelims should submit their prelims(3 min) and final track(7 min) 1 hr before the event in a cd in mp3 format and do keep a backup.", "Name of the team leader, phone number and college name should be written on the cd.", "", "", "", "Printo Prajeev", "9566814625 ", "Tapaswi Kancherla", "09894774158","Anna Auditorium");
    	   
    	   database.insertContact("International Submit for Sports Development", "Kamraj Auditorium", "06 Feb 2013", "9 am - 5 pm", "Premium Events", "The Debate Society, VIT brings you the opportunity of a lifetime. Come be a part of the largest Cultural Fest and unite under the spirit of the globe: Sports. Participants will represent sports associations, clubs, teams and players and voice their opinions on the most debatable issues in sports. We aim to come up with policies for the implementation of FFP . Addressing the most burning issues of the Sporting World: We bring you the platform to endeavour to bring change, to express your opinions, to empower Young India. ", "100", "The participants will be assigned portfolios as heads of associations, federations, teams, and players from different sports from around the world.", "Under the presence of a panel which will regulate the flow of discussion, a policy-oriented debate will be undertaken. ", "The Participants will be expected to come up with a written solution through majority approval on the issue at hand.","", "","", "Payal Varma", "8940313506 ", "Tushar Agrawal", "8148255773","Technology Tower");
    	   
    	   database.insertContact("Riviera Super Singer", "Anna Auditorium", "09 Feb 2013", "1 pm - 5 pm", "Premium EVents", " It is a singing competition where singers are judged based on their vocal range, skill and style. It is for Internal and External College students only. ", "80", "The participants must perform in English or Hindi only. ", " Participants will have to perform a maximum of 2 songs.", "30 participants in the first round(only internal participants), 10 will go to the final round. ","", "","", "Parth Bhatt", "7639679695 ", "Avnish Bagchi", "7639679675","Anna Auditorium");
    	   
    	  
    	   database.insertContact("Dream World Film Festival", "Hexagon 209", "9th Feb 2013", "9am - 5pm", "Premium Events", " Welcome to the Dream World Film Festival Come and show us, the world through your eyes...", "", "Maximum length of the movie should be 10 mins (600 seconds); not a single more second is allowed.", "A student's short film competition. Its a team event. (Team of maximum 20 can make a short film ", "","", "","", "Prasanna K", "09159127365", "Shiji Mathew Zacharia ", "09092479045 ","Greeno");
    	  
    	  
    	   database.insertContact("Sync Up", "Greeno", "9th Feb 2013", "1pm - 5pm", "Got the Moves", "  Each team is required to perform for not more than TWO MIN on a music track of their choice. Any style of dance can be adopted by the teams. Teams should ensure that they put up an act with no lifts and minimal contact. Shortlisted teams will perform in the second round of the event. ", "200", "Teams should submit their tracks separately for both the rounds 2 hr before the event in a cd in mp3 format only", " ", "","", "","", "Ankita Rai", "09159814879  ", "Barani", "8754182377","Greeno");
    	   
    	   database.insertContact("Born From a Doom box", "Greeno", "9th Feb 2013", "9am - 1pm", "Got the Moves", " Solo Dance Competition", "200", "Ethical and appropriate dressing. ", "Properties (Props) allowed in the first round. ", "Each round to be well within the time limits","", "","", "Karan Gulati", "8870653321 ", "Drishya V Nair", "08098069509","Greeno");
    	   
    	  
    	  
    	  database.insertContact("Lumiere", "CDMM 301", "8th Feb 2013", "1pm - 5pm", "Brush it Up", "This is a team event, which has two members per team. A random movie theme will be given on the spot, according to which the members will have to design a movie poster. The movie must be pre-existing but the poster has to be an original design.", "100", "The poster design has to be original. However, the movie must be known", " Only materials provided should be used.", "","", "","", "Kartika Venugopal", "8870530836", "Kritika Kedarinath", "7639811660","CDMM");
    	  database.insertContact("Junkyard Picasso", "CDMM 301", "6th Feb 2013", "9am - 1pm", "Brush it Up", " unkyard Picasso as the name suggests is built upon the idea of creating something artistic or useful out of junk. ", "150", " Participants do not need to bring any material of their own. ", "  The basic requirements such as fevicol, tape, scissors etc. will be provided", "The theme and instructions will be given on the spot","", "","", "Sanchit Aggarwal", "9626397816", "Priyanshi Pandey", "9566762692","Greeno");
    	  database.insertContact("Reflecto", "CDMM 302", "8th Feb 2013", "9am - 1pm", "Brush it Up", " Reflecto is an opportunity for people to liquify their thoughts. To put their artistic skills to test as to how can they relate reflections on mere water with the real world", "100", "Single participant entry", "No refund will be given incase of withdrawal  ", "Receipt to be presented before the event (Compulsory). ","", "","", "Ginni Malik", "9597363809", "Altaf Mohammed", "9597095813","CDMM");
    	  database.insertContact("Face Jam", "Foodys", "6th Feb 2013", "1pm - 5pm", "Brush it Up", "Join us for a day of crazy face art. No experience is needed, just the desire to be creative. This event is all about you, and your love for creating art. Face painting can be messy, but fun, for both the artist and the person being painted. Take the plunge, and be adventurous! Just make sure you follow the theme", "100", " Teams should not exceed the time limit. ", "  External help should not be taken. (Friends or internet) ", " Points will be awarded for creativity and neatness","", "","", "Rishikesh Duarah", "7639591841", "Tanya Jain", "8870512288","Foodys");
    	   database.insertContact("Toon Out", "CDMM 301", "7th Feb 2013", "9am - 1pm", "Brush it up", "This Riviera, we present to you TOON –OUT, an event like never before to bring out your creativity on a large platform. Show us your cartooning style as we give you a model to work with. Use your skills on paper and cartoon a balloon to win exciting prizes.  ", "100", "The model assigned to the team should be depicted with facial expressions properly.", " A maximum of 3 hours will be given to complete the 2 rounds.", "Every team will be given only 2 balloons, and in case if the balloon bursts, no extras will be provided and the points for that round will not be awarded.","", "","", "Ramani Venkatesh", "7639591864", "Sadhana Muthu Kumar", "9791485911","CDMM");
    	  database.insertContact("Story on a Cup", "CDMM 303", "7th Feb 2013", "1pm  - 5pm", "Brush it Up", " Its your time to unleash the story teller in you and take the judges on a roller coaster ride of emotions. If you think you have the intellect to frame a story from scratches and then ‘cupify’ it then this is the event for you!", "100", "Participants are given only 3 paper cups of different size each.", "Once written the story cannot be changed. ", "There should be proper continuation of the story portrayed on the cup.","", "","", "Soham Sarkar", "9597362513", "Sharayu Karkare", "9092116407","CDMM");
    	  
    	  
    	  
    	  database.insertContact("Adaraho", "Chenna Reddy Auditorium", "7th Feb 2013", "9am - 1pm", "WordsWorth", "In this event the first round is for the Selection of 6 teams with three members among all the participants. ", "", "", " ", "","", "","", "Ch Hanish", "08124265606", "Moningi Vivek", "08870652565","Main Building");
    	  database.insertContact("Antakshari", "Chenna Reddy Auditorium", "7th Feb 2013", "1pm - 5pm", "WordsWorth", "The event includes the normal anthyakshari competition. There are different rounds in the competition in which the teams are given hints and are asked to sing the songs. The rounds include giving a word and asking the song, asking the movie name and the music director’s name by playing the song, giving a situation and asking the song. ", "", "", " ", "","", "","", "A.L.Soundaraya", "08807244402", "M.Sowghandhi", "08903748678","Main Building");
    	  database.insertContact("Dumb Charades", "TT 311", "7th Feb 2013", "1pm - 5pm", "WordsWorth", " You may look like a fool doing it, you cant make a sound, you may have to overcome surprise rules and challenges, but if all that dont bother you then step right up and take your team to glory in the age-old game of charades!", "200", "3 Members per Team. ", "Participants will be given 1 minute time to guess as many as they can from the different categories.  ", "","", "","", "Priyanka N", "09677392969", "Swati Kothari", "08870517922","Technology Tower");
    	  database.insertContact("Creative Writing", "TT 513", "6th Feb 2013", "9am - 1pm", "WordsWorth", "Create false history with true mystery, make school children stand in a straight circle, look at London and walk towards Tokyo, save India from its honest politicians, write Hundred Shades of Grey. The above may seem like a tall (dis)order but if you are up to the challenge of doing it with Rajinis Gangnam Style, and the panache of Rushdie in no rush to die, then this is the place to be. ", "", "Each participant gets one entry sheet.", "Participants can submit their sheets on either of the first two days ", "","", "","", "R. Siddharth", "09677090433", "Balaji", "09176807222","Technology Tower");
    	  database.insertContact("J.A.M", "Ambedkar Auditorium", "7th & 9th Feb 2013", "9am - 1pm", "WordsWorth", " A dash of common sense, a dollop of logic, a sprinkle of factual knowledge and Morgan Freemans skilled oratory - put that all together and.. thats exactly what we DONT want. Step into the Queens shoes and speak like youve never spoken before on crazy, wacky topics. One stutter, a moment of pause, a flicker of the hand and you forfeit your chance. So grab the mike, speak your mind, and enthral the audience with your eloquence as the clock ticks.", "	The objective of the panellists is to talk for 60 seconds without repetition, hesitation or deviation", "", " ", "","", "","", "Tuhin Tiwari ", "08122795668", "Asra Yousuf", "09597370449","Technology Tower");
    	  database.insertContact("Tamil Debate", "Ambedkar Auditorium", "th Feb 2013", "9am - 5pm", "WordsWorth", " This is the event which helps your tongue to conquer the whole crowd as a Emperor. Remember! Third world war is gonna be fought with tongue.", "", "", " ", "","", "","", "Giri Prasath", "08870844123", "Karthick", "09715783783","Technology Tower");
    	  database.insertContact("Pic'aboo", "TT 311", "8th Feb 2013", "9am - 1pm", "WordsWorth", " Your voices are a gift from the Gods (except for a certain Mr. Bieber), but what happens when we take it away from you? You have to visually communicate to dominate. Dazzle us with your prowess in an amalgamation of the classic board game with the most engaging of word games. Pictionary + Taboo = PicAboo", "", "3 Members per Team", " ", "","", "","", "Adithya Suri", "09790910940", "Gnyanesh Trivedi", "08940314043","Technology Tower");
    	 database.insertContact("Clueless", "Sjt 108", "8th Feb 2013", "1pm - 5pm", "WordsWorth", " 2 member per team. 3 Rounds – Equations of Punctuation, Grammar Nazi, Alpha-Omega of English", "", "", " ", "","", "","", "R Siddharth", "09677090433", "Arjun Sabari", "08056211711","Silver Jubilee Tower");
    	 database.insertContact("Shipwreck", "TT 311 & 312", "6th Feb 2013", "9am - 5pm", "WordsWorth", " The Titanic is sinking. The waters are rising. But you are no Jack Dawson who gets to die saving his lady love. You have ONE chance to survive, ONE chance to impersonate a world famous personality and save yourself from the sinking ship.", "200", "", " ", "","", "","", "Arjun Sabari", "08056211711", "Amogh Umesh", "09840198371","Technology Tower");
    	  database.insertContact("Stand up Comedy", "Kamraj Auditorium", "7th Feb 2013", "1pm -5pm", "WordsWorth", "Is sarcasm your area of expertise? Are you the one in your group who has a witty reply to anything and everything? Do you have the ability to deliver quickfires and light up the whole crowd? Then you have come to the right place. The best part is, the audience will be amongst the judges. Sarcasm, humor and wit are the three things that youwill be marked on.  ", "", "It is an individual competition.", "Limited entries based on first come first serve basis. ", "","", "","", "Vijay Ramesh", "08870544773", "Akhil Nair", "07845515400","Technology Tower");
    	  
    	  
    	  database.insertContact("Radio Jockey", "Ambedkar Auditorium", "7th Feb 2013", "1pm - 5pm", "WordsWorth", "Friends, Romans, Countrymen! We come to you bearing both good and bad news. The good news is, your voice will be heard across the country. The bad news is, you will not be seen. But fear not. Your arsenal of sharp wit, charming voice and endearing personality is all thats needed to conquer. The listeners will lend you their ears, but can you be the voice they want to hear? ", "", "", " ", "","", "","", "Vijay Ramesh", "08870544773", "Aarav Vijay Sahu", "07200789231","Technology Tower");
    	 
    	 
    	  database.insertContact("Rangam", "TT Gallery1", "8th Feb 2013", "1pm - 5pm", "WordsWorth", "This Event tests the Acting skills of the participants in which we play a Scene from the movie and the participants have to enact the Scene along with their team mates as the characters in the Scene. It consists of various Rounds where the participants completely show their communication skills along with their Acting Skills. The best teams among the Participants are selected as the Winners. ", "", "", " ", "","", "","", "B.Saketh Reddy", "09159814879  ", "Barani", "08098069509","Greeno");
    	  database.insertContact("Sabse Bada Khiladi", "BasketBall Court", "9th Feb 2013", "1pm - 5pm", "WordsWorth", " The event testing the participants on various skills including listening, observation, physical, mental etc. The event goes through a series of taxing rounds to get the best among the rest!!", "", "The participation will be individual.", " The event will consist of FOUR rounds", "Use of profanities is strictly prohibited.","", "","", "Kuvar Arun Singh ", "08124440602", "Anand", "07639811712","BasketBall Court");
    	  
    	  database.insertContact("What I Perceive", "Ambedkar Auditorium", "6th & 9th Feb 2013", "9am - 1pm", "Wordsworth", " This event is to unleash the optimism and creativity of the participant. See the things with your special way of vision to express them beyond imagination. Express more and impress most.", "", "Here there will be two rounds where as preliminary round the students will be given a picture and they have to explain their perceptions about it.", " ", "","", "","", "Suresh ", "09043456894", "Nandha Kumar", "09095762171","Technology Tower");
    	  database.insertContact("Tamil Poetry ", "Rajaji Hall", "6th Feb 2013", "9am - 1pm", "WordWworth", "This Event tests the Poetry skills of the Participants as we give an on spot topic.  ", "", "", " ", "","", "","", "Chikkam Raviteja", "0965502215", "A.Jayadeep", "09494209705","Main Building");
    	  
    	  database.insertContact("Chitram O Vichitram", "Chenna Reddy Auditorium", "9th Feb 2013", "1pm - 5pm", "WordsWorth", " There are a lot of things which can be done using photos. In this event we give the photos of prominent personalities in Telugu and ask questions based on those pictures. This includes different rounds like how the team members can take the clues from pictures, how can they identify the edited pictures.", "", "", " ", "","", "","", "G. Alekhya", "09500851238", "K Jahnavi", "09894342620","Main Buidling");
    	  
    	   database.insertContact("Potpourri", "TT Galery 2", "7th Feb 2013", "9am - 1pm", "WordsWorth", " Use your word power, artistic and acting skills to show you are the master of all. Calling all wordsmiths, actors, artists, movie freaks for the ultimate showdown.", "", "", " ", "","", "","", "Amogh Umesh", "09840198371", "Aarav Vijay", "07200789231","Technology Tower");
    	   
    	  database.insertContact("Bluff Master", "TT Gallery2 ", "7th Feb 2013", "1pm - 5pm", "WordsWorth", " The event is a replica of the TV Show BLUFFMASTER screened on STAR ONE . It tests the bluffing abilities of the participants. It includes a prelims written paper . The stage round comprises of the same format as the show.", "", "The event will consist of two rounds: Prelims and Finals.", "Each team will consist of TWO members. ", "The first round will be an aptitude round.","", "","", "Nikhil Mittal ", "08870546055", "Vibhutesh", "8903310610","Technology Tower");
    	  
    	  
    	  database.insertContact("Sur Sargam", "Chenna Reddy Auditorium", "6th Feb 2013", "1pm - 5pm", "WordsWorth", " The event tests the songs and musical knowledge of the participants. It includes a prelims having written paper about bollywood knowledge. The stage round comprises of various audio visual rounds to make it a entertaining event.", "", "The event will consist of two rounds: Prelims and Finals.", " Each team will consist of THREE members.", "","", "","", "Ankit Upadhyay", "07639567282", "Surabhi Jha", "08870522360","Main Building");


    	  database.insertContact("Hindi Debate", "Rajaji Hall", "7th Feb 2013", "9am - 1pm", "WordsWorth", " The event is about testing the debating abilities of the participants. For a given topic the participants can debate and defend their perspective being for or against the topic.", "", "The event will consist of two rounds: Prelims and Finals.", " For prelims the participation will be individual.", "The participant will have to speak for 2 minutes either for or against a single topic.","", "","", "Amit Pandey", "08124367877", "Sagar Jounkani", "08124444058","Main Building");
    	  
    	  
    	   database.insertContact("Barfi", "TT 311 & 312", "8th Feb 2013", "1pm - 5pm", "WordsWorth", " The event is typical Dumb C where the teams have to mime and guess the mimes to gain points and advance to subsequent rounds.", "", "The event will consist of two rounds: Prelims and Finals.", "Each team will consist of THREE members. ", "The teams selected from the first round will participate in the Final round.","", "","", "Pinku Yadav ", "09171836922", "Pratibha Sahu", "09790491357","Technology Tower");
    	  database.insertContact("What's the good word", "Hexagon 209", "6th Feb 2013", "1pm - 5pm", "WordsWorth", " Anagram the hell out of those alphabets, spell the living daylights out of those words, wrap your heads around rebuses, spoonerisms, puns, portmanteaus and more! If you can dribble English like Messi can the ball, time the words like Dravid, wrestle out answers like Sushil Kumar, then this event will be a piece of cake.", "", "", " ", "","", "","", "Sanjay Rakesh", "09566169776", "", "","Hexagon");
    	  
    	  database.insertContact("Bolvachan", "CDMM 203 & 204", "8th Feb 2013", "9am - 1pm", "WordsWorth","", "The event tests the speaking skills of the participants in various areas like extempore, JAM, shipwrecks. ", "The participation will be individual.", "The event will consist of three rounds.", "The topics for the first round will be given on spot. ", "","", "", "Shambhavi Sinha", "08870539361", "Kuvar Arun Singh", "08124440602","CDMM");
    	 database.insertContact("Wanna be RJ/VJ", "TT Gallery 2", "6th Feb 2013", "9am - 5pm", "WordsWorth", " This event is to unleash the talent of participants as Radio Jockey and Video Jockey. You can rock over the stage by your script delivery, stage performance and anchoring skills.", "", "This will be having Five to six rounds.", " For Internal & External preliminary rounds will be there to shortlist", "","", "","", "Divhagar", "09629971111", "Gayathri ", "08056201827","Technology Tower");

    	 database.insertContact("Kryptography", "MB 112 & 113", "6th Feb 2013", "1pm - 5pm", "WordsWorth", " Come, join this roller coaster ride of mind-boggling codes. Solve each level of increasingly complex puzzles and beat the timer to reach the ultimate zenith of decoding!", "", "Participation in teams of 2 or 3 members. ", " ", "","", "","", "Devvrat Nayyar", "08870689005", "Nayamat Bal", "08870689005","Main Building");
    	 
    	 database.insertContact("Rangoli", "Sjt Building", "7th Feb 2013", "9am - 1pm", "Fun Arena", " A simple, conventional but strongly creative event which takes us back to our roots. Sketch your creativity yet colorful.", "", "Traditional Kolam has to be drawn by participants and the best will win the prize", " ", "","", "","", "Sharmila", "07845853396", "Deepak Kumar", "09626128857","Sjt Building");
    	 
    	 database.insertContact("Save the Town", "Sjt 107 & 108", "9th Feb 2013", "9am - 5pm", "Fun Arena", " The event tests the participants logic, quick response and skills to be active enough to bring the bomb before it is blasted.", "50", "All the information and clues will be declared on the day of the event.", " ", "","", "","", "Shruti Arya", "08940309194", "Sadhana Vashisht ", "09626413284","Sjt Building");
    	 
    	 
    	  
    	  
    	  database.insertContact("The Game of Life", "VolleyBall Court2", "7th Feb 2013", "9am - 5pm", "Fun Arena", " The game will be played on a life size board with a large spinning wheel and the participants will have to traverse the entire pathway of the arcade board in order to finish the game", "50", "Every session shall be for a maximum time of 120mins ", "	Every session shall have 6 participants ", "The top 4 participants shall have to play a FINALE to run for the cup of The Game Of LIF","", "","", "Richie Roy", "08940506637", "Nitali Mittal ", "09597364700","Volley Court");
    	   database.insertContact("Jumanji 4.0", "BasketBall Court", "8th Feb 2013", "9am - 1pm", "Fun Arena", " Jumanji 4.0 is an amalgam of exciting adventure involving series of tasks, deciphering ancient codes and much more ", "100", "", " ", "","", "","", "Ankita Sachan", "08870551709", "Nikhil Stephen", "08870539480","BasketBall Court");
    	 database.insertContact("Weirdo", "BasketBall Court", "6th andd 7th Feb 2013", "9am - 1pm", "Fun Arena", "Weirdo is back and we are prepared to unleash the insanity within YOU, yes you, our tasks have been designed to kick up your ledger instincts and rest assured your opponents will be haywires in their own rights. ", "50", "While avoiding lasers, a participant is allowed to come in contact with the laser a maximum of 3 counts.", "The participant has to carefully checkmate the Challenger in two moves. Failing to do so will result in disqualification.  ", "","", "","", "Isha Singh ", "09585444073", "Vyom Mathur", "09597367930","Technology Tower");
    	   database.insertContact("Legends of the Hidden Temple", "TT 504, 505 & 523", "8th Feb 2013", "9am - 5pm", "Fun Arena", " The event is a replica of a popular TV show that aired in Nickelodeon channel during the early 90s. It is centered around a Temple which contains hidden treasures", "100", "", " ", "","", "","", "Ankita Rai", "09159814879  ", "Barani", "08098069509","Greeno");
    	   
    	   
    	   database.insertContact("Temple Run Reverse", "Woodstock", "6th & 7th Feb 2013", "9 am- 5pm", "Fun Arena", " Collect money in the form of coins throughout the arena but be ready to watch out demonic monkeys waiting to devour you. ", "50", " Participants falling 3 times or more in the run will be eliminated", "Each obstacle has a value and if the particants touch the obstacle, that value will be deducted. ", "","", "","", "Aman Lamba", "09626397474", "Mohit Garg", "08870511310","Woodstock");
    	  
    	  
    	   database.insertContact("The Outlaw Creed", "TT 302,303,304", "7th Feb 2013", "9 am - 5 pm", "Fun Arena", "This event is based on the popular PC game, The Assassins Creed. Here the participating teams get to step into the shoes of a heir to a medieval bandit and need to solve clues and puzzles based on two map networks ", "100", " 	15 minutes is given in each room. Teams are allowed to take notes in a paper format given beforehand.", " An additional 30 minutes is given after the two rooms and they have to return the form to the event coordinators at the given time", "","", "","", "Himamshu", "7200788404", "Anirudh", "9597369098","Technology Tower");
    	   
    	   database.insertContact("Rush Hour", "BasketBall Court", "6th & 7th Feb 2013", "9 am - 5 pm", "Fun Arena", "This event is basically to test the logical skills and IQ of the participants. It will have an arena with a number of blocks placed randomly. ", "50", " ", " ", "","", "","", "Damini", "09566820095", "Uma Balakrishnan", "08124881120","BasketBall Court");
    	   
    	   database.insertContact("Human Foosball", "Throwball Court", "6th ,7th, 8th and 9th Feb 2013", "9 am - 5 pm", "Fun Arena", "Foosball, this popular table sport when takes human form we reinvent the game to call it Human Foosball. This event will test the coordination and teamwork of people given the restrictions in this unique game of body and the mind ", "50", " ", " ", "","", "","", "Abhishek Kumar", "8870907804", "Nikhil Soni ", "09626401878","ThrowBall Court");
    	   database.insertContact("Bhag Dk Bose", "Volleyball Court", "7th Feb 2013", "9 am - 5 pm", "Fun Arena", " ", "50", " ", " ", "","", "","", "", "", "", "","");
    	   database.insertContact("Prison Break", "Woodstock", "8th & 9th Feb 2013", "9 am - 5 pm", "Fun Arena", " This is your chance to put yourself in the shoe of a prisoner and to experience the adventurous escape of a prisoner. Come and free yourself from the most confusing and challenging prison of Riviera 2013. ", "50", "  Participants must register as an individual", "Decision of the co-ordinators shall be final.  ", "","", "","", "Abhrajit Kar", "09597518006", "Isha Walia", "08870539426","Woodstock");
    	   
    	   database.insertContact("Jaanbaaz Mission", "Woodstock", "6th & 7th Feb 2013", "9 am - 5 pm", "Fun Arena", "  The event Jaanbaaz Mission 2.0 sits at the apex of amateur obstacle courses. All you have to do is register for a nominal fee, turn up at the day of the event in attire that allows extensive physical labour, navigate the obstacle course as fast as you can and well, you’ll be going back with a heavier pocket", "50", "Each day 2 rounds will be conducted to finalize the result. ", "Participants have to qualify to reach the next level ", "","", "","", "Rahul Kumar", "07418645081", "Pawar Harish", "08695954486","");
    	   
    	   
    	   
    	   
    	   database.insertContact("Dorikinode Dora", "Amphi Theatre TT", "7th Feb 2013", "9 am - 5pm", "Fun Arena", "The team comprises of a minimum of two and a maximum of three members. We give the team members to perform certain activities like collecting some articles in the given stipulated time. They have to perform the task and the team which performs the task in the best manner gets the points and they are promoted to the next round to perform the next task.  ", "10", " ", " ", "","", "","", "Mandela Harika", "09092056849", "Geddam Mohan", "09994498856","Technology Tower");
    	   database.insertContact("Pirates of Riviera", "Rocket Court", "7th Feb 2013", "9 am - 5pm", "Fun Arena", "  Ahoy young lads an lassies. We'd be very pleased that ye weighed anchor on the Pirates of Riviera page today. We hope ye have yer swords ready and yer wits sharpened for the most exciting event this Riviera", "150", "Participants must register in teams of 2 to 3 each. ", " Decision of the co-ordinators shall be final in all aspects.", "","", "","", "Ramya Mure", "09597370856", "Nishant Gupta ", "7598848490","RocketCourt");
    	   database.insertContact("Battlefield" ,"Woodstock", "8th Feb 2013", "9 am - 5pm", "Fun Arena", "  It is an Informal Funtertaing event comprising of several hurdles which will give you a glimpse of The adventurous world….If you are into Shooting, Climbing, Crawling and other Breath taking tasks…", "100", " ", " ", "","", "","", "Mayuri Jain ", "09597362787", "Syed Ahmed", "09566816828","Woodstock");
    	   database.insertContact("Balloon Fight", "Woodstock", "9th Feb 2013", "9 am - 5pm", "Fun Arena", "  A combat to triumph, balloons as weapons! This Riviera, dunk in this fun-filled event. Fetch your squad and get ready to have some fun! What more..? You can earn huge chunks of money! ", "10", " ", " ", "","", "","", "Suprabhat Thakkar", "08015121101 ", "Kanhaiya Bhardwaj ", "09597368199","Woodstock");
    	   database.insertContact("Wartotle","VolleyBall Court", "8th & 9th Feb 2013", "9 am - 5pm", "Fun Arena", "Relive the joys of Holi with the twist of survival. Sign up for awesome aqua fun. Exhilarate you senses by aiming and dodging your opponents. Douse your enemies with streaks of water and claim victory.   ", "100", "There will be three rounds and they will be carried out over two days ", " Each round will be of 1 minute and 30 seconds", "Only a big water splash on the opposing player will be considered a ’kill shot’. ","", "","", "Aditya Khandelwal ", "09094832231", "VVM Dileep", "095973770227","VolleyBall Court");
    	   database.insertContact("Beg, Borrow, Steal", "Amphi Theatre TT", "9th Feb 2013", "9 am - 5pm", "Fun Arena", " In this event We give the participants random and wild items that we want. And it's up to them to use whatever jugaad they can and to procure those items in time. The team that comes up with all the items on the list first, wins.  ", "", " No hard and fast rule as such, the participants have to take care that they don’t literally steal from people; they can take and return the stuff to people once they are done showing us the items.", "They can’t take other teams items. ", "They have to personally show all the items in the list to one of the volunteer.","", "","", "Vrinda Malik ", "09597369204", "Ipsita Prakash ", "09751291455","Technology Tower");
    	   database.insertContact("Quidditch", "Woodstock", "8th & 9th Feb 2013", "9 am - 5pm", "Fun Arena", " Quidditch is an ode to J.K.Rowling’s wildly popular fictional sport. Two teams! Six players each! Three Chasers race through the field and attempt to shoot the quaffle past the opposition keeper into the ring as many times as you can.  ", "50", " Only the Chasers are allowed to handle and score points using the quaffle.", " Only the designated Beaters will be given control of the team Bludger", "","", "","", "Nupur Khera", "08148748747", "Mohit Aggarwal ", "098870580030","Woodstock");
    	   
    	   database.insertContact("Buzzer Quiz", "TT Gallery 2", "8th Feb 2013", "1 pm - 5pm", "Inquizitive", " Are you the kind who is fast and sharp and craves for an adrenaline rush ? Are you the one out there to tell the World , I’m better than you at this shit ! I’ll say it before you know it ! Then yes, register for this event before the seats run out. UNLEASH THE BEAST WITHIN YOU. BECOME THE BUZZER BEATER ", "50", "Teams of 2 ", "35 questions in 30 minutes for your Prelims (Written)", "Top 6 teams in the prelims qualify for the finals","", "","", "Aravind R", "09787687797", "", "","Technology Tower");
    	   database.insertContact("Spent Quiz", "TT Gallery 2", "8th Feb 2013", "9 am - 1 pm", "Inquizitive", " Remember all those times you were yelled at for watching too much TV or too many movies, or for spending endless hours watching matches, this is your moment to gloat. The ultimate quiz on Sports and Entertainment. ", "50", "Upto 3 members per team. ", " Cross college teams allowed. ", "","", "","", "Nikhil Ramesh", "9790024039", "Aditya Rajan", "9840032084","Technology Tower");
    	   database.insertContact("India Quiz", "TT Gallery 1", "9th Feb 2013", "9 am - 1 pm", "Inquizitive", " The India Quiz is about anything and everything related to India and aims to celebrateits culture, diversity, geography, politics, and various other aspects. Think you know our Motherland?  ", "", "Upto 3 members per team.  ", "Cross college teams allowed.  ", "Use of electronic gadgets is prohibited during the quiz.","", "","", "Aditya Ramanan", "9962555742", "Tarun Ruchandani", "9159805911","Technology Tower");
    	   database.insertContact("Travel and Living Quiz", "TT 311", "7th Feb 2013", "9 am - 1 pm", "Inquizitive", " This quiz aims to take the participants through a journey around the world through interesting questions. The questions will be ranging from various cultures, lifestyles, geographies, places and travel. ", "", " Upto 2 members per team. ", "Cross college teams allowed.  ", "A preliminary round consisting of 25 questions, with in built tie breaker questions.","", "","", "Tarun Ruchandani", "9159805911", "Ayushman Ojaswi", "9952113853","Technology Tower");
    	   database.insertContact("Riviera General Quiz", "TT Gallery 2", "9th Feb 2013", "11 am - 5 pm", "Inquizitive", " If you think you know it all, then this is your chance to show it off. The quiz covers just about everything under the sun (and a few above it). Come and put your wits against the best in the business. Rest assured, VIT Quiz Club will be sure to deliver one of the best quizzes you've ever attended. ", "", " Upto 3 members per team. ", "Cross college teams allowed.  ", "Use of electronic gadgets is prohibited during the quiz","", "","", "Tarun Ruchandani", "9159805911", "Saurabh Menon", "9025304553","Technology Tower");
    	  
    	  
    	  
    	  
    	   database.insertContact("U-DJ", "CDMM-203", "7th & 8th Feb 2013", "9 am - 1pm", "Mixed Bag", "Introduction to the remixing software: A tutorial session will be conducted for the participants, to have basic knowledge on the remixing software. ", "50", "Team: 2 members per team (max)  ", "Participants should bring their fully charged laptops, headphones and pen drives.", "","", "","", "Umang Jalan ", "09597369615", "Ashka", "08903112971","CDMM");
    	   database.insertContact("Caption it", "TT 434", "9th Feb 2013", "9 am - 5pm", "Mixed Bag", "This is an individual event wherein the participant has to respond to a particular pictorial situation in a comical manner i.e. he/she has to fill the dialog box for a particular character depicted in the picture and also caption a meme or a troll character.", "50", "Participants will be provided with 5 random situations for which they have to reply within 30 min.  ", "Participants will be provided with 1 hour to form a story or a joke from the variety of situations", "","", "","", "Ujjwal Singh", "08940309232", "Akshay", "08015145499","Technology Tower");
    	   database.insertContact("Break the Ice", "CDMM-203", "6th Feb 2013", "1 pm - 5pm", "Mixed Bag", " It is a fun filled event which will break the ice between two strangers.", "50", "The decision of the co-ordinators is final.  ", "The participants are not allowed to request the co-ordinators to pair them with team member they wish to perform the task with.", "","", "","", "Saloni Sharma", "09626377356", "Aishwarya Nandini", "07845186550","CDMM");
    	  database.insertContact("B Quizzed", "Hexagon-209", "6th Feb 2013", "9 am - 1pm", "Mixed Bag", " The quiz comprises of various rounds on recognizing how observant and sharp one is. ", "50", "Decision of the judges are final  ", "All teams must adhere to the time limit given to them in each round, NO EXTRA time shall be given.", "","", "","", "Richie Roy", "08940506637", "Shruti Arya", "8940309194","Hexagon");
    	   database.insertContact("Global Village", "BasketBall Court", "7th Feb 2013", "9 am - 5pm", "Mixed Bag", " Global Village - An urban festival, in which the inhabitants of the VIT would have a closer look at the different cultures of the world, will be able to talk with representatives of various countries.", "50", " ", "", "","", "","", "Abhinaya C", "08870522849", "Janet Jo Mathew", "09791968693","Hexagon");
    	   database.insertContact("Takeshi's Castle", "Hexagon 121", "7th, 8th & 9th  Feb 2013", "9 am - 5pm", "Mixed Bag", "  Welcome to our own Honeycomb maze, which will consist of various hurdles and blockages. Hold your breath, rush through the maze", "100", "The participant has to complete the event in the specified time limit ", "If the participant does not complete the event in specified he/she will be disqualified", "","", "","", "Abhijeet Singh", "09751296004 ", "Saachi Adalakha", "08695812728","Hexagon");
    	   database.insertContact("Idiot Box", "Hexagon 209", " 8th Feb 2013", "9 am - 5pm", "Mixed Bag", " For all those TV-SERIES addicts out there who enjoy the ADRENALINE RUSH of The Vampire Diaries, the THRILL of Supernaturals, the HUMOUR in FRIENDS , the Dark Passenger DEXTER.etc, this is an event that u dont wanna miss. ", "50", "	Participants should participate in teams of 2.  ", " Decision of the co-ordinators shall be final.", "","", "","", "Abhinaya C", "08870522849", "Janet Jo Mathew", "09791968693","Hexagon");
    	   
    	   
    	   
    	   database.insertContact("Logo Quiz", "Hexagon 209 & 214", "7th  Feb 2013", "1 pmm -  5pm", "Mixed Bag", "Based on the popular android app this event tests the Brand Awareness and ability to recognize logos of various organisations and sports teams.  ", "100", " Registrations in team of two.", "Teams will be given an opportunity to select an area of interest like sports, organisations, etc and will have to recognise the logos", "","", "","", "Yogender Prabhu", "07845683607", "Amith Kaushal", "09597380924","Hexagon");
    	   database.insertContact("Master Chef Riviera", "Foodsy", "8th & 9th Feb 2013", "9 am - 5pm", "Mixed Bag", "The event is split up between two categories- Day 1 shall see you battle in the best Snacks, Chaat and Salads category and Day 2 will delight you with the sweet taste of Desserts. ", "100", "The dishes will be judged mainly based on taste, presentation and uniqueness. ", "All chefs will be given access to basic ingredients and a stipulated time period in which they are supposed to prepare the dishes.", "","", "","", "Suchitra Chandar", "09566820306", "Nishant Gupta ", "07598848490","Foodys");
    	   database.insertContact("Splice Dice", "Hexagon 124", "6th & 7th Feb 2013", "9 am - 5pm", "Mixed Bag", "Take a break from your routine life and race back to your childhood! Grab a partner and escape into a game wherein your destiny will be decided by the roll of a dice. ", "100", " It is a time based event. The participants will have to move through the frame within the specified time.", "If the time taken by the contestant exceeds the limit, he/she will be considered disqualified.", "","", "","", "Shubham Shrivastava ", "07845853378", "Shubham Gupta ", "8682820502 ","Hexagon");
    	   database.insertContact("Agent-X", "Kamraj Auditorium", "7th Feb 2013", "9 am - 1pm", "Mixed Bag", "The event is basically based upon cryptography but at the same time there is no prerequisite such as the participant should be well versed with the concepts of cryptography ", "100", " The team who files the report with the correct keyword and the name of AGENT X wins the competition. ", "Maximum time for the participants to submit the report is 3 hours", "They are allowed to call their Boss and Agent Smith only once.","", "","", "Jaswinder Singh", "07845778889", "Nikhil Soni", "09626401878","Technology Tower");
    	   database.insertContact("Suits", "CDMM-301, 302", "9th Feb 2013", "9 am - 5pm", "Mixed Bag", "This is a team based event and 2 members per team are allowed.  ", "100", "Any sort of malpractice shall lead to immediate disqualification ", "The decision of the judges will be final", "","", "","", "Prafull Agarwal ", "07639811566", "Vibhore K", "07667696541","CDMM");
    	    
   
       global.i=0;
       }
    database.close();
    
    DBAdapter6 map_database=new DBAdapter6(this);
    map_database.open();
    if(global.map_i==1)
    {
    map_database.insertContact("Sjt Building", "79.163519", "12.971133");
    map_database.insertContact("Technology Tower", "79.159264", "12.9970599");
    map_database.insertContact("Hexagon", "79.157685", "12.969316");
    map_database.insertContact("Main Building", "79.163519", "12.969381");
    map_database.insertContact("Anna Auditorium", "79.155663", "12.970254");
    map_database.insertContact("Woodstock", "79.157151", "12.968359");
    map_database.insertContact("Greeno", "79.158326", "12.969504");
    map_database.insertContact("Foodys", "79.158286", "12.968974");
    map_database.insertContact("BasketBall Court", "79.158447", "12.970403");
    map_database.insertContact("Throwball Court", "79.158447", "12.970403");
    map_database.insertContact("VolleyBall Court", "79.156365", "12.970568");
    map_database.insertContact("CDMM", "79.154815", "12.96923");
    map_database.insertContact("Rocket Point", "79.159264", "12.9970599");
    map_database.insertContact("Outdoor Stadium", "79.160037", "12.976036");
    map_database.insertContact("Indoor Stadium", "79.159139", "12.972225");
    map_database.insertContact("Tennis Courts", "79.156365", "12.970568");
    map_database.insertContact("Table Tennis", "79.156365", "12.970568");
    map_database.insertContact("Swimming Pools", "79.160772", "12.974449");
    global.map_i=0;
    }
    map_database.close();
    
    
   DBAdapter7 status_database=new DBAdapter7(this);
    status_database.open();
    if(global.status_i==1)
    {
    status_database.insertContact("Resonance", "N", "Y", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Style Check", "N", "N", "N", "N", "Y", "N", "N", "N");
    status_database.insertContact("Riviera's Got Talent", "N", "N", "N", "Y", "N", "Y", "N", "N");
    status_database.insertContact("Streets", "N", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("Role Play", "N", "N", "N", "N", "Y", "Y", "N", "N");
    status_database.insertContact("Acoustic Vibes", "N", "N", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Raaga Reggae", "N", "N", "N", "N", "Y", "Y", "N", "N");
    status_database.insertContact("Frisk Factor", "N", "N", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("International Submit for Sports Development", "Y", "Y", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Riviera Super Singer", "N", "N", "N", "N", "N", "N", "N", "Y");
    status_database.insertContact("Dream World Film Festival", "N", "N", "N", "N", "Y", "Y", "Y", "Y");
    status_database.insertContact("Sync Up", "N", "N", "N", "N", "N", "N", "N", "Y");
    status_database.insertContact("Born From a Doom box", "N", "N", "N", "N", "N", "N", "Y", "N");
    status_database.insertContact("Lumiere", "N", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("Junkyard Picasso", "Y", "N", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Reflecto", "N", "N", "N", "N", "Y", "N", "N", "N");
    status_database.insertContact("Face Jam", "N", "Y", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Toon Out", "N", "N", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("Story on a Cup", "N", "N", "N", "Y", "N", "N", "N", "N");
    status_database.insertContact("Adaraho", "N", "N", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("Antakshari", "N", "N", "N", "Y", "N", "N", "Y", "N");
    status_database.insertContact("Dumb Charades", "N", "N", "N", "Y", "N", "N", "N", "N");
    status_database.insertContact("Creative Writing", "Y", "N", "N", "N", "N", "N", "N", "N");
   
    
    status_database.insertContact("J.A.M", "N", "N", "Y", "N", "N", "N", "Y", "N");
    status_database.insertContact("Tamil Debate", "N", "N", "N", "N", "Y", "Y", "N", "N");
    status_database.insertContact("Pic'aboo", "N", "N", "N", "N", "Y", "N", "N", "N");
    status_database.insertContact("Clueless", "N", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("Shipwreck", "Y", "N", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Stand up Comedy", "N", "N", "N", "Y", "N", "N", "N", "N");
    status_database.insertContact("Radio Jockey", "N", "N", "N", "Y", "N", "N", "N", "N");
    status_database.insertContact("Rangam", "N", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("Sabse Bada Khiladi", "N", "N", "N", "N", "N", "N", "N", "Y");
    status_database.insertContact("What I Perceive", "Y", "N", "N", "N", "N", "N", "N", "Y");
    status_database.insertContact("Tamil Poetry", "Y", "N", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Chitram O Vichitram", "N", "N", "N", "N", "N", "N", "N", "Y");
    status_database.insertContact("Potpourri", "N", "N", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("Bluff Master", "N", "N", "N", "Y", "N", "N", "N", "N");
    status_database.insertContact("Sur Sargam", "N", "2", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Hindi Debate", "N", "N", "Y", "N", "N", "N", "Y", "N");
    status_database.insertContact("Barfi", "N", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("What's the good word", "N", "Y", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Bolvachan", "N", "N", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Wanna be RJ/VJ", "N", "N", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Kryptography", "N", "Y", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Rangoli", "N", "N", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("Save the Town", "N", "N", "N", "N", "N", "N", "Y", "Y");
    status_database.insertContact("The Game of Life", "N", "N", "Y", "Y", "Y", "Y", "N", "N");
    status_database.insertContact("Jumanji 4.0", "N", "N", "N", "N", "Y", "N", "Y", "Y");
    status_database.insertContact("Weirdo", "N", "Y", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("Legends of the Hidden Temple", "N", "N", "N", "N", "Y", "Y", "Y", "Y");
    status_database.insertContact("Temple Run Reverse", "N", "N", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("The Outlaw Creed", "N", "N", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Rush Hour", "Y", "Y", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Human Foosball", "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y");
    status_database.insertContact("Bhag Dk Bose", "Y", "Y", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Prison Break", "N", "N", "N", "N", "Y", "Y", "Y", "Y");
    status_database.insertContact("Jaanbaaz Mission", "Y", "Y", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Dorikinode Dora", "N", "N", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Pirates of Riviera", "N", "N", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Battlefield", "N", "N", "N", "N", "Y", "Y", "N", "N");
    status_database.insertContact("Balloon Fight", "N", "N", "N", "N", "N", "N", "Y", "Y");
    status_database.insertContact("Wartotle", "N", "N", "N", "N", "Y", "Y", "Y", "Y");
    status_database.insertContact("Beg, Borrow, Steal", "N", "N", "N", "N", "N", "N", "Y", "Y");
    status_database.insertContact("Quidditch", "N", "N", "N", "N", "Y", "Y", "Y", "Y");
    status_database.insertContact("Buzzer Quiz", "N", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("Spent Quiz", "N", "N", "N", "N", "Y", "N", "N", "N");
    status_database.insertContact("India Quiz", "N", "N", "N", "N", "N", "N", "Y", "N");
    status_database.insertContact("Travel and Living Quiz", "N", "N", "Y", "N", "N", "N", "N", "N");
    status_database.insertContact("Riviera General Quiz", "N", "N", "N", "N", "N", "N", "Y", "Y");
    status_database.insertContact("U-DJ", "Y", "N", "N", "N", "N", "Y", "N", "N");
    status_database.insertContact("Caption it", "N", "N", "N", "N", "N", "N", "Y", "Y");
    status_database.insertContact("Break the Ice", "N", "Y", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("B Quizzed", "Y", "N", "N", "N", "N", "N", "N", "N");
    status_database.insertContact("Global Village", "N", "N", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Takeshi's Castle", "N", "N", "Y", "Y", "Y", "Y", "Y", "Y");
    status_database.insertContact("Idiot Box", "N", "N", "N", "N", "Y", "Y", "N", "N");
    status_database.insertContact("Logo Quiz", "N", "N", "N", "Y", "N", "N", "N", "N");
    status_database.insertContact("Master Chef Riviera", "N", "N", "N", "N", "Y", "Y", "Y", "Y");
    status_database.insertContact("Splice Dice", "Y", "Y", "Y", "Y", "N", "N", "N", "N");
    status_database.insertContact("Agent-X", "N", "N", "Y", "N", "N", "N", "N", "N");
     status_database.insertContact("Suits", "N", "N", "N", "N", "N", "N", "Y", "Y");
    global.status_i=0;
    }
    
    status_database.close();
    
    
       // insertfunction();
    }
   

    
    public void CopyDB(InputStream inputStream, OutputStream outputStream) throws IOException
    {
    	System.out.println("in copydb");
    	byte[] buffer=new byte[1024];
    	int length;
    	while((length=inputStream.read(buffer))>0)
    			{
    		outputStream.write(buffer,0,length);
    			}
    	inputStream.close();
    	outputStream.close();
    }
    
 
}
