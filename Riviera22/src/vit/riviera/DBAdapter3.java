
package vit.riviera;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter3 
{
	public static final String KEY_EVENT="Event";
	public static final String KEY_VENUE = "Venue";
	public static final String KEY_DATE = "Date";
	public static final String KEY_TIME = "Time";
	public static final String KEY_DESCRIPTION ="Description";
	public static final String KEY_TEAMSIZE ="Teamsize";
	public static final String KEY_REGFEES = "Regfees";
	public static final String KEY_PRIZE1 = "Prize1";
	public static final String KEY_PRIZE2 = "Prize2";
	public static final String KEY_PRIZE3 = "Prize3";
	public static final String KEY_PRIZE4 = "Prize4";
	public static final String KEY_NAME = "Name";
	public static final String KEY_CONTACT = "Contact";
	private static final String TAG = "DBAdapter";
	private static final String DATABASE_NAME = "Sports_data";
	private static final String DATABASE_TABLE = "Sport_Information";
	
	private static final int DATABASE_VERSION = 1;
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter3(Context ctx)
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
	
	public static final String DATABASE_CREATE="Create Table Sport_Information(Event varchar2(50), Venue varchar2(100)," +
			"Date varchar2(50), Time varchar2(50) ,Regfees varchar2(20), Description varchar2(2000),Teamsize varchar2(10),Prize1 varchar2(20)," +
			"Prize2 varchar2(20), Prize3 varchar2(20),Prize4 varchar2(20), Name varchar2(20),Contact varchar2(20)" +
			")";
		
	//public static final String DATABASE_Query1="insert into Details values("anshul","","","","","","","","","","","","","","","","","");";

	
	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
	System.out.println("in oncreate outer");	
	try {
		db.execSQL(DATABASE_CREATE);
		
		System.out.println("In oncreate inner");
	
			} catch (SQLException e) {
	e.printStackTrace();
	}
	global.sports_i=1;
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
	
	
	public  void insertContact(String event,String venue,String date,
			String time, String description, String teamsize, 
			String regfees,String prize1,String prize2,
			String prize3,String prize4, String name,String contact)
	{
		
	ContentValues initialValues = new ContentValues();
	initialValues.put(KEY_EVENT, event);
	initialValues.put(KEY_VENUE, venue);
	initialValues.put(KEY_DATE, date);
	initialValues.put(KEY_TIME, time);
	initialValues.put(KEY_REGFEES, regfees);
	initialValues.put(KEY_DESCRIPTION, description);
	initialValues.put(KEY_TEAMSIZE,teamsize);
	
	initialValues.put(KEY_PRIZE1, prize1);
	initialValues.put(KEY_PRIZE2, prize2);
	initialValues.put(KEY_PRIZE3, prize3);
	initialValues.put(KEY_PRIZE4, prize4);
	
	initialValues.put(KEY_NAME, name);
	initialValues.put(KEY_CONTACT, contact);
	
	 db.insert(DATABASE_TABLE, null, initialValues);
	}
	public DBAdapter3 open() throws SQLException
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
	public Cursor check(String user_category)
	{
	
		String q="Select Event from Sport_Information where Event = ?";
		return db.rawQuery(q, new String[]{user_category});
		
	}

	public Cursor getAllInfo_Sports(String user_category)
	{
	
		String q="Select * from Sport_Information where Event = ?";
		return db.rawQuery(q, new String[]{user_category});
		
	}
	 
}
