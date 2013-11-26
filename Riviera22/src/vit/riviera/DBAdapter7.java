
package vit.riviera;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter7 
{
	public static final String KEY_EVENT="Event";
	public static final String KEY_SLOT1="Slot1";
	public static final String KEY_SLOT2="Slot2";
	public static final String KEY_SLOT3="Slot3";
	public static final String KEY_SLOT4="Slot4";
	public static final String KEY_SLOT5="Slot5";
	public static final String KEY_SLOT6="Slot6";
	public static final String KEY_SLOT7="Slot7";
	public static final String KEY_SLOT8="Slot8";
	
	
	
	
	
	
	private static final String TAG = "DBAdapter";
	private static final String DATABASE_NAME = "Status_databases";
	private static final String DATABASE_TABLE = "Status_Information";
	private static final int DATABASE_VERSION = 1;
	
	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter7(Context ctx)
	{
		System.out.println("in Context");
	this.context = ctx;
	DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
	DatabaseHelper(Context context)
	{
		
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
	System.out.println("IN DataHelper");
	}
	
	public static final String DATABASE_CREATE="Create Table Status_Information(Event varchar2(100), Slot1 varchar2(5)," +
			"Slot2 varchar2(5),Slot3 varchar2(5),Slot4 varchar2(5),Slot5 varchar2(5),Slot6 varchar2(5),Slot7 varchar2(5), Slot8 varchar2(5))";
		
	//public static final String DATABASE_Query1="insert into Details values("anshul","","","","","","","","","","","","","","","","","");";

	
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
	System.out.println("in oncreate outer");	
	try {
		db.execSQL(DATABASE_CREATE);
		
		System.out.println("In oncreate inner");
	
		/*ContentValues initialValues = new ContentValues();
		initialValues.put("Event", "anshul");
		initialValues.put("Venue", "rahul");
      db.insert(DATABASE_TABLE, null, initialValues);*/
	/*	System.out.println("Before insert");*/
	/*Insert a=new Insert();
		a.insertdetails();*/
		
		//DBAdapter db=new DBAdapter(this);
		//db.open();
		//db.insert(table, nullColumnHack, values)
	/*	db.insertContact("Frisk Factor", "venue", "date", "timefrom", "timeto", "category", "description1", "description2", "description3", "regfees", "rule1", "rule2", "rule3", "prize1", "prize2", "prize3", "contact1", "contact2", "more");

		db.insertContact("Style Check", "venue", "date", "timefrom", "timeto", "category", "description1", "description2", "description3", "regfees", "rule1", "rule2", "rule3", "prize1", "prize2", "prize3", "contact1", "contact2", "more");
*/
	} catch (SQLException e) {
	e.printStackTrace();
	}
	global.status_i=1;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		System.out.println("in onupgrade");
	Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
	+ newVersion + ", which will destroy all old data");
	db.execSQL("DROP TABLE IF EXISTS contacts");
	
	
	onCreate(db);
	}
	}
	
	
	public  void insertContact(String event,String slot1,String slot2,String slot3,String slot4,String slot5,String slot6,String slot7,String slot8)
	{
		
	ContentValues initialValues = new ContentValues();
	initialValues.put(KEY_EVENT, event);
	
		initialValues.put(KEY_SLOT1, slot1);
		initialValues.put(KEY_SLOT2, slot2);
		initialValues.put(KEY_SLOT3, slot3);
		initialValues.put(KEY_SLOT4, slot4);
		initialValues.put(KEY_SLOT5, slot5);
		initialValues.put(KEY_SLOT6, slot6);
		initialValues.put(KEY_SLOT7, slot7);
		initialValues.put(KEY_SLOT8, slot8);
	
	 db.insert(DATABASE_TABLE, null, initialValues);
	}
	public DBAdapter7 open() throws SQLException
	{
		System.out.println("Get Writable Database");
	db = DBHelper.getWritableDatabase();
	return this;
	}
	
	//---closes the database---
	public void close()
	{
		System.out.println("In close");
	DBHelper.close();
	}
	/*public boolean deleteContact(long rowId)
	{
	return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}*/
	//---retrieves all the contacts---
	/*public Cursor getAllContacts()
	{
	//return db.query(DATABASE_TABLE, new String[] { KEY_SLOT,KEY_ROWID,
		//	KEY_SUBJECT,KEY_FACULTY,KEY_FACULTYID,KEY_STUDENT,KEY_REGISTRATION,KEY_DATE1,KEY_DATE2,KEY_DATE3,KEY_DATE4,KEY_DATE5,KEY_DATE6,KEY_DATE7,KEY_DATE8,KEY_DATE9,KEY_DATE10,KEY_DATE11,KEY_DATE12,KEY_DATE13,KEY_DATE14,KEY_DATE15,KEY_DATE16,KEY_DATE17,KEY_DATE18,KEY_DATE19,KEY_DATE20,KEY_DATE21,KEY_DATE22,KEY_DATE23,KEY_DATE24,KEY_DATE25,KEY_DATE26,KEY_DATE27,KEY_DATE28,KEY_DATE29,KEY_DATE30}, null, null, null, null, null);
	/*return db.query(DATABASE_TABLE, new String[] {KEY_PASSWORD,KEY_ROWID, KEY_SLOT,KEY_SUBJECT,
			KEY_FACULTY,KEY_FACULTYID,KEY_STUDENT,KEY_REGISTRATION,KEY_DATE1,KEY_DATE2,
			KEY_DATE3,KEY_DATE4,KEY_DATE5,KEY_DATE6,KEY_DATE7,KEY_DATE8,KEY_DATE9,
			KEY_DATE10,KEY_DATE11,KEY_DATE12,KEY_DATE13,KEY_DATE14,KEY_DATE15,KEY_DATE16,
			KEY_DATE17,KEY_DATE18,KEY_DATE19,KEY_DATE20,KEY_DATE21,KEY_DATE22,KEY_DATE23,
			KEY_DATE24,KEY_DATE25,KEY_DATE26,KEY_DATE27,KEY_DATE28,KEY_DATE29,KEY_DATE30,KEY_MESSAGE}, null, null, null, null, null);
	*/
	
	//}*/
	
	//---retrieves a particular contact---
	/*public Cursor getContact(long rowId) throws SQLException
	{
	Cursor mCursor =
	db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
	KEY_NAME, KEY_EMAIL}, KEY_ROWID + "=" + rowId, null,
	null, null, null, null);
	if (mCursor != null) {
	mCursor.moveToFirst();
	}
	return mCursor;
	}*/
	public boolean updateContact(long rowId, String name, String email)
	{
		ContentValues args = new ContentValues();
		args.put(name, email);
		return false;
		
	}
	public Cursor getslot1()
	{
		System.out.println("in adapter");
	
	
		String q="Select * from Status_Information where Slot1 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	
	public Cursor getslot2()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot2 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	public Cursor getslot3()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot3 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	public Cursor getslot4()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot4 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	public Cursor getslot5()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot5 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	public Cursor getslot6()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot6 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	public Cursor getslot7()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot7 = 'Y'";
		return db.rawQuery(q, null);
		
	}
	public Cursor getslot8()
	{
		System.out.println("in adapter");
	
	
		String q="Select Event from Status_Information where Slot8 = 'Y'";
		return db.rawQuery(q, null);
		
	}

	
	
	
	
	
	
	
	
	
	
		 
}
