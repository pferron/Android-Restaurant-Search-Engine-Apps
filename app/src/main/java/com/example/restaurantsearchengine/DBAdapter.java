package com.example.restaurantsearchengine;

import java.sql.SQLException;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
public static final String KEY_ROWID="_id";
public static final String KEY_NAME="name";
public static final String KEY_CATEGORY="category";
public static final String KEY_ADDRESS="address";
public static final String KEY_CITY="city";
public static final String KEY_ZIP="zip";
public static final String KEY_STATE="state";
public static final String KEY_WEBLINK="weblink";

public static final String KEY_USERNAME="username";
public static final String KEY_PASSWORD="password";

private static final String TAG="DBAdapter";
private static final String DATABASE_NAME="MyDB";
private static final String DATABASE_TABLE="restaurants";

private static final String DATABASE_TABLE1="users";


private static final int DATABASE_VERSION=1;
/*private static final String DATABASE_CREATE=
	"create table restaurants(_id integer primary key autoincrement, "
	+ "name text not null, category text not null, address text not null, city text not null, zip text not null, state text not null, "
	+ "weblink text not null);";*/
private static final String DATABASE_CREATE=
"create table restaurants(_id integer primary key autoincrement, "
+ "name text not null, category text not null, address text not null, city text not null, zip text not null, state text not null, "
+ "weblink text not null);";
private static final String DATABASE1_CREATE= "create table users(_id integer primary key autoincrement, "
+ "username text not null, password text not null);";

private final Context context;
private DatabaseHelper DBHelper;
private SQLiteDatabase db;

		public DBAdapter(Context ctx)
		{
			this.context = ctx;
			DBHelper = new DatabaseHelper(context);
		}

		private static class DatabaseHelper extends SQLiteOpenHelper
		{
		DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db)
		{
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (Exception e){
				e.printStackTrace();
			}
			
			try {
				db.execSQL(DATABASE1_CREATE);
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
			+ newVersion + ", which will destroy al old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			
			onCreate(db);
		}
	}	
		
		public DBAdapter open() throws SQLException
		{
			db = DBHelper.getWritableDatabase();
			return this;
		}

		public void close()
		{
			DBHelper.close();
		}

		public long insertRestaurant(String name, String category, String address, String city, String zip, String state, String weblink)
		{
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_CATEGORY, category);
		initialValues.put(KEY_ADDRESS, address);
		initialValues.put(KEY_CITY, city);
		initialValues.put(KEY_ZIP, zip);
		initialValues.put(KEY_STATE, state);
		initialValues.put(KEY_WEBLINK, weblink);
		return db.insert(DATABASE_TABLE, null, initialValues);
		}
		
		public long insertUser(String username, String password)
		{
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_USERNAME, username);
		initialValues.put(KEY_PASSWORD, password);
		return db.insert(DATABASE_TABLE1, null, initialValues);
		}
		
		public Cursor getState() throws SQLException
		{
			return db.query(true, DATABASE_TABLE, new String[] {KEY_STATE}, null, null, KEY_STATE, null, null, null);
		}
		
		public Cursor getFoodCategory() throws SQLException
		{
			return db.query(true, DATABASE_TABLE, new String[] {KEY_CATEGORY}, null, null, KEY_CATEGORY, null, null, null);
		}
		
		public Cursor getCity(String[] args) throws SQLException
		{
			return db.query(true, DATABASE_TABLE, new String[] {KEY_CITY}, "state = ?", args, KEY_CITY, null, null, null);
		}
		
		public Cursor getInfoRestaurant(String category, String state, String city) throws SQLException {
			 
			Restaurant restaurant = new Restaurant();
			
			Cursor mCursor =
			db.query(DATABASE_TABLE, new String[] {KEY_ROWID,
			KEY_NAME, KEY_CATEGORY, KEY_ADDRESS, KEY_CITY, KEY_ZIP, KEY_STATE, KEY_WEBLINK}, 
										KEY_CATEGORY+"= '" +category + "' and " + KEY_STATE+ "= '" + state + "' and " + KEY_CITY+"= '" + city + "'", null,
			null, null, KEY_NAME, null);
			 
				/*if (mCursor.moveToFirst())
				{
					restaurant.setName(mCursor.getString(mCursor.getColumnIndex(KEY_NAME)));
					restaurant.setCategory(mCursor.getString(mCursor.getColumnIndex(KEY_CATEGORY)));
				}*/
			
			return mCursor;
		}
		
		public boolean getUser(String username, String password) throws SQLException {
			 
			boolean found = false;
			Cursor mCursor =
					db.query(true,DATABASE_TABLE1, new String[] {KEY_ROWID,KEY_USERNAME,KEY_PASSWORD},KEY_USERNAME +"= '"+ username +"' and "
			+ KEY_PASSWORD +"= '"+ password +"'", null, null, null, null, null);
			
			//Cursor mCursor =
			//		db.query(true,DATABASE_TABLE1, new String[] {KEY_ROWID,KEY_USERNAME,KEY_PASSWORD},KEY_USERNAME +"='"+ username+"'", null, null, null, null, null);
			 
				if (mCursor.moveToFirst())
					return true;

				return found;
		}

}
