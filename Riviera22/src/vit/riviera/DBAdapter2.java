
package vit.riviera;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter2 
{
	private static final String TAG = "DBAdapter";
	private static final String DATABASE_NAME = "REG_Events";
	private static final String DATABASE_TABLE = "Registered_Events";
	private static final int DATABASE_VERSION = 1;
	private static final String Reg_Events="events";
	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public DBAdapter2(Context ctx)
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
	
	public static final String DATABASE_CREATE="Create Table Registered_Events(events varchar2(100) primary key not null)";
		
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
	global.myevents_i=1;
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
	
	
	public  void insertContact(String event)
	{
		
	ContentValues initialValues = new ContentValues();
	initialValues.put(Reg_Events, event);
	
	 db.insert(DATABASE_TABLE, null, initialValues);
	 global.check_i=1;
	// Toast.makeText(getApplicationContext(), "Added to My Events", Toast.LENGTH_SHORT).show();
	// Toast.makeText(getContext(), "inserted", Toast.LENGTH_SHORT).show();
	 System.out.println("Inserted");
	}
	public DBAdapter2 open() throws SQLException
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
		public boolean updateContact(long rowId, String name, String email)
	{
		ContentValues args = new ContentValues();
		args.put(name, email);
		return false;
		
	}
	public Cursor getRegEvents()
	{
	
		String q="Select * from Registered_Events" ;
		return db.rawQuery(q, null);
		
	}
	 
}
