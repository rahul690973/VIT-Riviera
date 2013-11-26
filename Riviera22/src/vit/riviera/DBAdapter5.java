
package vit.riviera;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter5 
{
	public static final String KEY_RESTAURANT="Restaurant_name";
	public static final String KEY_LOCATION = "Location";
	public static final String KEY_DESCRIPTION ="Description";
	public static final String KEY_STARS = "Stars";
	public static final String KEY_ISAC = "Ac";
	public static final String KEY_CATEGORY = "Category";

	
	private static final String TAG = "DBAdapter5";
	private static final String DATABASE_NAME = "Restaurantss";
	private static final String DATABASE_TABLE = "Restaurant_Information";
	private static final int DATABASE_VERSION = 1;
	
	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter5(Context ctx)
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
	
	public static final String DATABASE_CREATE="Create table Restaurant_Information( Restaurant_name varchar2(50), " +
			"Location varchar2(200), Description varchar2(200), Stars varchar2(10), Ac varchar2(20), Category varchar2(50));";
		
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
	global.restaurant_i=1;
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
	
	
	public  void insertContact(String Restaurant_name,String location, String description,
			String stars,   String ac,String category)
	{
		
	ContentValues initialValues = new ContentValues();
	initialValues.put(KEY_RESTAURANT, Restaurant_name);
	initialValues.put(KEY_LOCATION, location);
	initialValues.put(KEY_STARS, stars);
	initialValues.put(KEY_ISAC, ac);
	initialValues.put(KEY_CATEGORY, category);
	initialValues.put(KEY_DESCRIPTION, description);

	
	 db.insert(DATABASE_TABLE, null, initialValues);
	}
	public DBAdapter5 open() throws SQLException
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
	public Cursor getbyCategory(String user_category)
	{
	
		String q="Select * from Restaurant_Information where category = ?";
		return db.rawQuery(q, new String[]{user_category});
		
	}
	
	public Cursor getbyName(String user_name)
	{
	
		String q="Select * from Restaurant_Information where Restaurant_name= ?";
		return db.rawQuery(q, new String[]{user_name});
		
	}
	 
}
