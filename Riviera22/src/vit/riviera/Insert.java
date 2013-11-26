package vit.riviera;

import android.app.Activity;

public class Insert extends Activity
{
public void insertdetails()
{
	System.out.println("IN insert method");
	DBAdapter db2=new DBAdapter(this);
	db2.open();
	//db2.insertContact("Frisk Factor", "venue", "date", "timefrom", "timeto", "category", "description1", "description2", "description3", "regfees", "rule1", "rule2", "rule3", "prize1", "prize2", "prize3", "contact1", "contact2", "more");

	/*db.insertContact("Style Check", "venue", "date", "timefrom", "timeto", "category", "description1", "description2", "description3", "regfees", "rule1", "rule2", "rule3", "prize1", "prize2", "prize3", "contact1", "contact2", "more");
*/}
 

}
