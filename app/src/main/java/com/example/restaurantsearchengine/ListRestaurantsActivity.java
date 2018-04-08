package com.example.restaurantsearchengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

//public class ListRestaurantsActivity extends ListActivity {
public class ListRestaurantsActivity extends Activity{
    private TextView text;
    //private ListView restaurantsListView;
    //private List<String> listValues;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurants);
        
        getActionBar().setHomeButtonEnabled(true);

        final Cursor myCursor;
        //final ListAdapter myAdapter;
        final ListView restaurantsListView;
        
        text = (TextView) findViewById(R.id.mainText);
        restaurantsListView = (ListView) findViewById(R.id.listview);
        
        Bundle bundle = getIntent().getExtras();             
        ArrayList<String> listRestaurantNames = bundle.getStringArrayList("RESTAURANT_NAMES_EXTRA");    
        ArrayList<String> listRestaurantAdress = bundle.getStringArrayList("RESTAURANT_ADDRESS_EXTRA");
        String typefood = bundle.getString("TYPEFOOD");
        String uscity = bundle.getString("USCITY");
        text.setText("List of " + typefood + " Restaurants at " + uscity );
               
        ArrayList<HashMap<String, String>> data = 
                new ArrayList<HashMap<String, String>>();
        //for (Restaurant restaurant : restaurants) {
        for (int i=0; i<listRestaurantNames.size();i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("restaurantName", listRestaurantNames.get(i));
            map.put("restaurantAddress", listRestaurantAdress.get(i));
            //map.put("restaurantName", restaurant.getName());
            //map.put("restaurantAddress", restaurant.getAddress());
            data.add(map);
        }
        
        // create the resource, from, and to variables 
        int resource = R.layout.activity_restaurant;
        String[] from = {"restaurantName", "restaurantAddress"};
        int[] to = {R.id.listText, R.id.listAddress};
        
        // create and set the adapter
        MySimpleAdapter myAdapter = 
                new MySimpleAdapter(this, data, resource, from, to);
        
        restaurantsListView.setAdapter(myAdapter);
        
        // listener for the first one 
        restaurantsListView.setOnItemClickListener(new OnItemClickListener() {
	        @Override
	        public void onItemClick(AdapterView<?> parent, View v, 
	                int position, long id) {
	
	    		Bundle bundle = getIntent().getExtras();             
	            ArrayList<String> listRestaurantWebLink = bundle.getStringArrayList("RESTAURANT_WEBLINK_EXTRA");
	            
	            // get the intent
	            Intent intent = getIntent();
	            
	            // get the Uri for the link
	            Uri viewUri = Uri.parse(listRestaurantWebLink.get(position));
	            
	            // create the intent and start it
	            Intent viewIntent = new Intent(Intent.ACTION_VIEW, viewUri); 
	
	            startActivity(viewIntent);
	        }
        });
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		
		switch (item.getItemId()) {
	    case android.R.id.home:
	      // ProjectsActivity is my 'home' activity
	    	Intent intent = new Intent(ListRestaurantsActivity.this,MainActivity.class );
	    	startActivity(intent);
	      return true;
		}
		return (super.onOptionsItemSelected(item));
	}
	
}