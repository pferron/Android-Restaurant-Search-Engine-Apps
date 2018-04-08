package com.example.restaurantsearchengine;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		final String RESTAURANT_NAMES_EXTRA = "com.example.restaurantsearchengine._RESTAURANT_NAMES_EXTRA";
		final String RESTAURANT_ADDRESS_EXTRA = "com.example.restaurantsearchengine._RESTAURANT_ADDRESS_EXTRA";
		final String RESTAURANT_WEBLINK_EXTRA = "com.example.restaurantsearchengine._RESTAURANT_WEBLINK_EXTRA";
		final String RESTAURANT = "com.example.restaurantsearchengine._RESTAURANT";
		
		final String TYPEFOOD = "com.example.restaurantsearchengine._CATEGORY";
		final String USSTATE = "com.example.restaurantsearchengine._STATE";
		final String USCITY = "com.example.restaurantsearchengine._CITY";
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<String> myArraySpinnerState = new ArrayList<String>();
		List<String> myArraySpinnerFoodCategory = new ArrayList<String>();
		final List<String> myArraySpinnerCity = new ArrayList<String>();
		
		final Spinner spinnerState = (Spinner) findViewById(R.id.spinner2);
		final Spinner spinnerFoodCategory = (Spinner) findViewById(R.id.spinner1);
		final Spinner spinnerCity = (Spinner) findViewById(R.id.spinner3);
		
		final TextView labelCity = (TextView)findViewById(R.id.textView3);
		
		ImageButton ib = (ImageButton) findViewById(R.id.searchbutton);
		
		ImageButton logout = (ImageButton) findViewById(R.id.logout);
		
				
		/*try{ 
			DBAdapter db = new DBAdapter(this);
            db.open();
            
                        
			// Chicago - American
			db.insertRestaurant("Atwood","American","1 West Washington St.","Chicago","60602","IL","http://www.atwoodrestaurant.com/");
			db.insertRestaurant("Wildfire","American","159 West Erie St.","Chicago","60654","IL","http://wildfirerestaurant.com/chicago/");
			db.insertRestaurant("The Marq","American","60 West Adams St.","Chicago","60603","IL","http://www.themarqchicago.com/");
			db.insertRestaurant("Seven Lions","American","130 S. Michigan Ave","Chicago","60603","IL","http://sevenlionschicago.com/");
			db.insertRestaurant("Rudy Bar & Grille","American","69 E. Madison St.","Chicago","60603","IL","http://rudysbarandgrillechicago.com/");
			db.insertRestaurant("The Gage","American","24 South Michigan Ave","Chicago","60603","IL","http://www.thegagechicago.com/");
			db.insertRestaurant("Park Grill Chicago","American","11 North Michigan Ave","Chicago","60602","IL","http://www.parkgrillchicago.com/");
			db.insertRestaurant("Rivers","American","10 & 30 South Wacker Drive","Chicago","60606","IL","http://riversrestaurant.com/");
			db.insertRestaurant("Randolph Tavern","American","188 West Randolph","Chicago","60601","IL","http://www.randolphtavern.com/");
			db.insertRestaurant("Tradition","American","160 N Franklin St.","Chicago","60654","IL","http://www.traditionchicago.com/");
			db.insertRestaurant("State and Lake Chicago Tavern","American","201 N State St.","Chicago","60601","IL","http://stateandlakechicago.com/");
			db.insertRestaurant("South Water Kitchen","American","225 N. Wabash Ave","Chicago","60601","IL","http://www.southwaterkitchen.com/");
			db.insertRestaurant("Emerald Loop Bar and Grill","American","216 N Wabash","Chicago","60601","IL","http://www.emeraldloop.com/Emerald_Loop");
			db.insertRestaurant("Sweetwater Tavern and Grille","American","225 N. Michigan Ave","Chicago","60601","IL","http://www.sweetwatertavernandgrille.com/");
			db.insertRestaurant("Tortoise Club","American","350 N State St","Chicago","60654","IL","http://tortoiseclub.com/");
			db.insertRestaurant("River Roast","American","315 N LaSalle Blvd","Chicago","60654","IL","http://riverroastchicago.com/");
			db.insertRestaurant("Untitled","American","111 West Kinzie","Chicago","60654","IL","http://untitledsupperclub.com/");
			db.insertRestaurant("John Barleycorn","American","149 W Kinzie St.","Chicago","60654","IL","http://www.johnbarleycorn.com/#!home-rivernoth/mainPage");
			db.insertRestaurant("Sepia","American","123 North Jefferson St.","Chicago","60661","IL","http://www.sepiachicago.com/");
			db.insertRestaurant("Bin 36","American","161 N. Jefferson St.","Chicago","60661","IL","http://www.bin36.com/");
			db.insertRestaurant("HUB 51","American","51 W. Hubbard","Chicago","60654","IL","http://www.hub51chicago.com/");
			db.insertRestaurant("Kinzie Chophouse","American","400 N. Wells St.","Chicago","60610","IL","http://www.kinziechophouse.com/");
			db.insertRestaurant("Bottlefork","American","441 North Clark St.","Chicago","60654","IL","http://bottlefork.com/");
			db.insertRestaurant("Bull and Bear","American","431 N Wells St.","Chicago","60654","IL","http://www.bullbearbar.com/");
			
			
			// Chicago - French
			db.insertRestaurant("Les Nomades","French","222 E Ontario","Chicago","60611","IL","http://www.lesnomades.net/");
			db.insertRestaurant("Mon Ami Gabi","French","2300 N. Lincoln Park West","Chicago","60614","IL","http://www.monamigabi.com/home/");
			db.insertRestaurant("Everest Restaurant","French","440 South La Salle St.","Chicago","60605","IL","http://www.everestrestaurant.com");
			db.insertRestaurant("Chez Joel Bistro Francais","French","1119 W Taylor St.","Chicago","60607","IL","http://www.chezjoelbistro.com");
			db.insertRestaurant("La Sardine","French","111 N Carpenter St.","Chicago","60607","IL","http://www.lasardine.com/");
			db.insertRestaurant("Everest","French","440 South LaSalle St.","Chicago","60605","IL","http://www.everestrestaurant.com/index.html");
			db.insertRestaurant("Cochon Volant","French","100 W Monroe","Chicago","60603","IL","http://www.cochonvolantchicago.com/");
			db.insertRestaurant("Brasserie by LM","French","800 S. Michigan Ave","Chicago","60605","IL","http://brasseriebylm.com/");
			db.insertRestaurant("Paris Club Bistro and Bar","French","59 W. Hubbard St.","Chicago","60654","IL","http://parisclubbistroandbar.com/");
			db.insertRestaurant("Brindille","French","534 N. Clark St.","Chicago","60607","IL","http://brindille-chicago.com/");
			db.insertRestaurant("Cyrano’s Farm Kitchen","French","546 N Wells","Chicago","60654","IL","http://www.cyranosfarmkitchen.com/");
			db.insertRestaurant("Bistro Voltaire","French","226 West Chicago Ave","Chicago","60654","IL","http://bistrovoltaire.com/");
			db.insertRestaurant("TETE Charcuterie","French","1114 W Randolph St","Chicago","60607","IL","http://tetechicago.com/");
			db.insertRestaurant("Kiki Bistro","French","900 N. Franklin St.","Chicago","60610","IL","http://www.kikisbistro.com/");
			db.insertRestaurant("Bistrot Zinc","French","1131 N. State St.","Chicago","60610","IL","http://www.bistrotzinc.com/");
			db.insertRestaurant("Bistrot Margot","French","1437 N. Wells","Chicago","60610","IL","http://www.bistrotmargot.com/");
			db.insertRestaurant("Chez Moi","French","2100 N Halsted St.","Chicago","60614","IL","http://www.chezmoichicago.com/");
			db.insertRestaurant("Bistro Campagne","French","4518 N Lincoln Ave","Chicago","60625","IL","http://www.bistrocampagne.com/");
			
			
			
			// Chicago - Italian
			db.insertRestaurant("Sofi Restaurant","Italian","616 South Dearborn","Chicago","60605","IL","http://www.sofirestaurantandbar.com/");
			db.insertRestaurant("Acanto","Italian","18 South Michigan","Chicago","60603","IL","http://www.acantochicago.com/");
			db.insertRestaurant("The Florentine","Italian","151 West Adams St.","Chicago","60604","IL","http://www.e2hospitality.com/florentine-chicago/");
			db.insertRestaurant("Vivere","Italian","71 W Monroe St.","Chicago","60603","IL","http://www.italianvillage-chicago.com/vivere/");
			db.insertRestaurant("Lockwood Restaurant and Bar","Italian","17 E. Monroe St.","Chicago","60603","IL","http://www.lockwoodrestaurant.com/");
			db.insertRestaurant("Tutto Italiano Ristorante","Italian","501 S Wells St.","Chicago","60607","IL","http://tuttostogo.com/");
			db.insertRestaurant("a tavola","Italian","2148 W Chicago Ave","Chicago","60622","IL","http://www.atavolachi.com/");
			db.insertRestaurant("A10 Hyde Park","Italian","1462 E. 53rd St.","Chicago","60615","IL","http://a10hydepark.com/");
			db.insertRestaurant("Anna Maria Pasteria","Italian","4400 N. Clark","Chicago","60640","IL","http://www.annamariapasteria.com/");
			db.insertRestaurant("Anteprima","Italian","5316 N Clark St.","Chicago","60640","IL","http://anteprimachicago.net/");
			db.insertRestaurant("Bacchanalia","Italian","2413 S. Oakley Ave","Chicago","60608","IL","http://www.bacchanaliainchicago.com/");
			db.insertRestaurant("Balena","Italian","1633 N Halsted St","Chicago","60610","IL","http://balenachicago.com/");
			db.insertRestaurant("Bella Notte","Italian","1374 W Grand Ave","Chicago","60642","IL","http://www.bellanottechicago.com/");
			db.insertRestaurant("Café Bionda","Italian","1924 S State St","Chicago","60616","IL","http://www.cafebionda.com/");
			db.insertRestaurant("Cafe Spiaggia","Italian","980 North Michigan Ave","Chicago","60611","IL","http://www.spiaggiarestaurant.com/");
			db.insertRestaurant("Ceres Table","Italian","3124 N Broadway St.","Chicago","60657","IL","http://www.cerestable.com/");
			db.insertRestaurant("Charlatan","Italian","1329 W. Chicago","Chicago","60622","IL","http://www.charlatanchicago.com/");
			db.insertRestaurant("Ciao Amore Ristorante","Italian","1134 W 18th St.","Chicago","60608","IL","http://www.ciaoamoreristorante.com/");
			db.insertRestaurant("Cocello","Italian","354 West Hubbard St.","Chicago","60654","IL","http://cocello.com/");
			
			
			// Chicago - Mexican
			
			// Evanston - French
			db.insertRestaurant("Bistro Bordeaux","French","618 Church St.","Evanston","60201","IL","http://www.lebistrobordeaux.com/");
			
			// New York - Indian 
			db.insertRestaurant("Benares","Indian","45 Murray St","New York","10007","NY","http://www.benaresnyc.com/");
			
			
			// Houston - Japanese
			db.insertRestaurant("Benihana","Japanese","1318 Louisiana St.","Houston","77002","TX","http://www.benihana.com/");
			
			// Houston - Mexican
			db.insertRestaurant("El Big Bad","Mexican","419 Travis St.","Houston","77002","TX","http://elbigbad.com/");
			
			// Houston - French
			db.insertRestaurant("Artisans Restaurant","French","3201 Louisiana St.","Houston","77002","TX","http://artisansrestaurant.com/");
			
			
			// Los Angeles - American
			db.insertRestaurant("Redbird","American","114 E 2nd St.","Los Angeles","90012","CA","http://redbird.la/");
			db.insertRestaurant("Justice - Urban Tavern","American","120 South Los Angeles St.","Los Angeles","90012","CA","http://www.justicela.com/");
			
			// Los Angeles - Mexican
			db.insertRestaurant("B.S. Taqueria","Mexican","514 W 7th St.","Los Angeles","90014","CA","http://www.bstaqueria.com/");
			db.insertRestaurant("Pez Cantina","Mexican","401 S. Grand Ave","Los Angeles","90071","CA","http://www.pezcantina.com/");
			
			// Los Angeles - Japanese
			db.insertRestaurant("Takami Sushi & Robata Restaurant","Japanese","811 Wilshire Boulevard","Los Angeles","90017","CA","http://www.takamisushi.com/");
			db.insertRestaurant("Izakaya Fu-Ga","Japanese","111 South San Pedro St.","Los Angeles","90012","CA","http://izakayafu-ga.com/");
			
			// San Diego - Sushi
			db.insertRestaurant("RA Sushi Bar Restaurant","Sushi","474 Broadway","San Diego","92101","CA","http://www.rasushi.com/san-diego");
			
			// San Diego - Cajun
			db.insertRestaurant("Crab Hut","Cajun","1007 5th Ave","San Diego","92101","CA","http://www.crabhutrestaurant.com/");
			
			// San Diego - Persian
			db.insertRestaurant("Bandar Restaurant","Persian","845 4th Ave","San Diego","92101","CA","http://www.bandarrestaurant.com/");
      
            db.close();
            } catch (Exception e){
            	e.printStackTrace();
            }*/
		
		try {
			DBAdapter db = new DBAdapter(this);
        	db.open();
        	Cursor c = db.getState();
	       	 if (c.moveToFirst())
	       	 {
	       		myArraySpinnerState.add("");
	       		 do {
	       			 	myArraySpinnerState.add(c.getString(0));
	       			 	
	       		 } while (c.moveToNext());
	        	}
        	db.close();
        } catch(SQLException | java.sql.SQLException e){
        	e.printStackTrace();
        }
		
	    ArrayAdapter<String> spinnerArrayAdapterState = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myArraySpinnerState);
	    spinnerArrayAdapterState.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
	    spinnerState.setAdapter(spinnerArrayAdapterState);
	    
	    try {
			DBAdapter db = new DBAdapter(this);
        	db.open();
        	Cursor c = db.getFoodCategory();
	       	 if (c.moveToFirst())
	       	 {
	       		myArraySpinnerFoodCategory.add("");
	       		 do {
	       			 	myArraySpinnerFoodCategory.add(c.getString(0));
	       			 	
	       		 } while (c.moveToNext());
	        	}
        	db.close();
	        } catch(SQLException | java.sql.SQLException e){
	        	e.printStackTrace();
	        }
			
		    ArrayAdapter<String> spinnerArrayAdapterFoodCategory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myArraySpinnerFoodCategory);
		    spinnerArrayAdapterFoodCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		    spinnerFoodCategory.setAdapter(spinnerArrayAdapterFoodCategory);
	    
		    final int iCurrentSelection = spinnerState.getSelectedItemPosition();
		    final DBAdapter db = new DBAdapter(this);
		    
		    final ArrayAdapter<String> spinnerArrayAdapterCity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, myArraySpinnerCity);
			spinnerArrayAdapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		    		    
		    		    
		    spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    	@Override
				public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
		    		if (iCurrentSelection != i){
		    			
		    			try {
		    				//spinnerCityLayout.setVisibility(View.VISIBLE);
		    				spinnerArrayAdapterCity.clear();
		    				String[] arguments = new String[1];
		    				arguments[0] = spinnerState.getSelectedItem().toString();
		    	        	db.open();
		    	        	Cursor c = db.getCity(arguments);
		    		       	 if (c.moveToFirst())
		    		       	 {
		    		       		 myArraySpinnerCity.add("");
		    		       		 
		    		       		 do {
		    		       			 	myArraySpinnerCity.add(c.getString(0));
		    		       			 	
		    		       		 } while (c.moveToNext());
		    		        	}
		    	        	db.close();
			    	        } catch(SQLException | java.sql.SQLException e){
			    	        	e.printStackTrace();
			    	        }
		    			
		    			spinnerArrayAdapterCity.notifyDataSetChanged();
		    			spinnerCity.setAdapter(spinnerArrayAdapterCity);
		    				    			
		    		}
		        	
				} 
		
		        public void onNothingSelected(AdapterView<?> adapterView) {
		            return;
		        }
				
		    }); 
		    
		    logout.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	Intent intentlogout = new Intent(MainActivity.this, LoginActivity.class); 		
    	       		startActivity(intentlogout);
		        	
		        }
		    }); 
		    
		    ib.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	
		        	String category = spinnerFoodCategory.getSelectedItem().toString();
	    			String state = spinnerState.getSelectedItem().toString();
    				    			
	    			if (!category.equals(""))
	    			{
	    				if (!state.equals(""))
	    				{	    			
	    					String city = spinnerCity.getSelectedItem().toString();
	    					
	    					if (spinnerState.isSelected() && !city.equals(""))
	        				{

	    					
					    	    try {
						    			db.open();
						    			
						    			String typefood = spinnerFoodCategory.getSelectedItem().toString();
						    			String usstate = spinnerState.getSelectedItem().toString();
						    			String uscity = spinnerCity.getSelectedItem().toString();
						    			
						    			Cursor c = db.getInfoRestaurant(spinnerFoodCategory.getSelectedItem().toString(), 
						    											spinnerState.getSelectedItem().toString(),
						    											spinnerCity.getSelectedItem().toString());
						    	       	if (c.moveToFirst())
						    	       	{
						    	       		ArrayList<String> listRestaurantNames = new ArrayList<String>();
						    	       		ArrayList<String> listRestaurantAddress = new ArrayList<String>();
						    	       		ArrayList<String> listRestaurantWebLink = new ArrayList<String>();
						    	       		
						    	       		do {				    	       				
						    	       			 	listRestaurantNames.add(c.getString(1));
						    	       			    listRestaurantAddress.add(c.getString(3));
						    	       			    listRestaurantWebLink.add(c.getString(7));
						    	       			    
						    	       		   } while (c.moveToNext());
						    	       		
	  	       			    	       	    Intent intentListRestaurant = new Intent(MainActivity.this, ListRestaurantsActivity.class);
						    	       		intentListRestaurant.putStringArrayListExtra("RESTAURANT_NAMES_EXTRA", listRestaurantNames);
						    	       		intentListRestaurant.putStringArrayListExtra("RESTAURANT_ADDRESS_EXTRA", listRestaurantAddress);
						    	       		intentListRestaurant.putStringArrayListExtra("RESTAURANT_WEBLINK_EXTRA", listRestaurantWebLink);
						    	       		intentListRestaurant.putExtra("TYPEFOOD", typefood);
						    	       		intentListRestaurant.putExtra("USCITY", uscity);
						    	       		
						    	       		startActivity(intentListRestaurant);
						    	        }
						    	       	else
						    	       		Message(3);
						    	       	
						            	db.close();
					    	         } 
					    	            catch(SQLException | java.sql.SQLException e){
					    	        	e.printStackTrace();
					    	         }
	        				}
					    	    else
					    	    	Message(2);
		    			}
	    				else
	    					Message(1);
	    			}
	    			else
	    				Message(0);
    			
	    		 }
 				
		    });
		   
	}
	
	public void DisplayTest(Cursor c)
    {
    Toast.makeText(this, "Restaurant: " + c.getString(1), Toast.LENGTH_LONG).show();
    //Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }
	
	public void Message(int errorNum)
    {
		switch(errorNum)
		{
			case 0:
				Toast.makeText(this, "Please, select a category", Toast.LENGTH_LONG).show();
				break;
			case 1:
				Toast.makeText(this, "Please, select a state", Toast.LENGTH_LONG).show();
				break;
			case 2:
				Toast.makeText(this, "Please, select a city", Toast.LENGTH_LONG).show();
				break;
			case 3:
				Toast.makeText(this, "No restaurant for the selected criteria", Toast.LENGTH_LONG).show();
		}
    }
	
	@Override
	protected void onResume() {
		super.onResume();
		
		final Spinner spinnerState = (Spinner) findViewById(R.id.spinner2);
		final Spinner spinnerFoodCategory = (Spinner) findViewById(R.id.spinner1);
		final Spinner spinnerCity = (Spinner) findViewById(R.id.spinner3);
		List<String> myArraySpinnerCity = new ArrayList<String>();
		
		ImageButton ib = (ImageButton) findViewById(R.id.searchbutton);
		
		spinnerState.setSelection(0);
		spinnerFoodCategory.setSelection(0);
		spinnerCity.setSelection(0);
				
		final DBAdapter db = new DBAdapter(this);
		
	    ib.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	
	        	String category = spinnerFoodCategory.getSelectedItem().toString();
    			String state = spinnerState.getSelectedItem().toString();			
				    			
    			if (!category.equals(""))
    			{
    				if (!state.equals(""))
    				{
    					String city = spinnerCity.getSelectedItem().toString();
    					
    					if (!city.equals(""))
        				{
    					
				    	    try {
					    			db.open();
					    			
					    			String typefood = spinnerFoodCategory.getSelectedItem().toString();
					    			String usstate = spinnerState.getSelectedItem().toString();
					    			String uscity = spinnerCity.getSelectedItem().toString();
					    			
					    			Cursor c = db.getInfoRestaurant(spinnerFoodCategory.getSelectedItem().toString(), 
					    											spinnerState.getSelectedItem().toString(),
					    											spinnerCity.getSelectedItem().toString());
					    	       	if (c.moveToFirst())
					    	       	{
					    	       		ArrayList<String> listRestaurantNames = new ArrayList<String>();
					    	       		ArrayList<String> listRestaurantAddress = new ArrayList<String>();
					    	       		ArrayList<String> listRestaurantWebLink = new ArrayList<String>();
					    	       		
					    	       		do {				    	       				
					    	       			 	listRestaurantNames.add(c.getString(1));
					    	       			    listRestaurantAddress.add(c.getString(3));
					    	       			    listRestaurantWebLink.add(c.getString(7));
					    	       			    
					    	       		   } while (c.moveToNext());
					    	       		
		       			    	       	Intent intentListRestaurant = new Intent(MainActivity.this, ListRestaurantsActivity.class);
					    	       		intentListRestaurant.putStringArrayListExtra("RESTAURANT_NAMES_EXTRA", listRestaurantNames);
					    	       		intentListRestaurant.putStringArrayListExtra("RESTAURANT_ADDRESS_EXTRA", listRestaurantAddress);
					    	       		intentListRestaurant.putStringArrayListExtra("RESTAURANT_WEBLINK_EXTRA", listRestaurantWebLink);
					    	       		intentListRestaurant.putExtra("TYPEFOOD", typefood);
					    	       		intentListRestaurant.putExtra("USCITY", uscity);
					    	       		
					    	       		startActivity(intentListRestaurant);
					    	        }
					    	       	else
					    	       		Message(3);
					    	       	
					            	db.close();
				    	         } 
				    	            catch(SQLException | java.sql.SQLException e){
				    	        	e.printStackTrace();
				    	         }
			    			
		    			}
    					else 
    						Message(2);
    				}	
    				else
    					Message(1);
    			}
    			else
    				Message(0);
			
    		 }
				
	    });
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
