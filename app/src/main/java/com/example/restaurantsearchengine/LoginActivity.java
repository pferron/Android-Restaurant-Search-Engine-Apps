package com.example.restaurantsearchengine;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	private EditText  username=null;
	   private EditText  password=null;
	   private TextView attempts;
	   private Button login;
	   int counter = 3;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_login);
	      username = (EditText)findViewById(R.id.editText1);
	      password = (EditText)findViewById(R.id.editText2);
	      //attempts = (TextView)findViewById(R.id.textView5);
	      //attempts.setText(Integer.toString(counter));
	      //login = (Button)findViewById(R.id.button1);
	      ImageButton login = (ImageButton) findViewById(R.id.button1);
	      
	      /*DBAdapter db = new DBAdapter(this);
	      try{
	          db.open();
	          db.insertUser("karyn","vanderwarren");
	          db.insertUser("lucy","ferron");
	          db.insertUser("roxanne","ferron");
	          db.insertUser("philippe","ferron");
	          db.insertUser("Lucy","Ferron");
	          db.close();
	      } catch (Exception e){
          	e.printStackTrace();
          }*/
	   }

	   public void login(View view)
	   {
		  DBAdapter db = new DBAdapter(this);
		  if (!username.getText().toString().equals(""))
		  {
			  if (!password.getText().toString().equals(""))
			  {
					  try{
						  	  db.open();
						      if(db.getUser(username.getText().toString(), password.getText().toString()))	  
						    	  
							      {
						    	  	  Message(2);
								      
								      Intent intent = new Intent(this, MainActivity.class);     		
								      startActivity(intent);
								   }	
							   else
								   {
									  Message(3);
								   }
						      db.close();
						  } 
						  catch (Exception e)
						  {
							          	e.printStackTrace();
						  }
			  	}
		      else Message(0);
		  }
		  else Message(1);    	  
	   }
	   
	  public void Message(int errorNum)
	    {
			switch(errorNum)
			{
				case 0:
					Toast.makeText(this, "Please, enter a password", Toast.LENGTH_LONG).show();
					break;
				case 1:
					Toast.makeText(this, "Please, enter a username", Toast.LENGTH_LONG).show();
					break;
				case 2:
					Toast.makeText(this, "Authentification Verifed", Toast.LENGTH_LONG).show();
					break;
				case 3:
					Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show();
			}
	    }
		  
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }

}


