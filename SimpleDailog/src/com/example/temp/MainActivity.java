package com.example.temp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int DIALOG_ALERT = 10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		showDialog(DIALOG_ALERT);
	}

	
	@Override
	protected Dialog onCreateDialog(int id) {
	  switch (id) {
	    case DIALOG_ALERT:
	    	
	    	
	    // Create out AlterDialog
	    Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Warning");
	    builder.setMessage("This will end the activity");
	    builder.setCancelable(true);
	    builder.setPositiveButton("I agree", new OkOnClickListener());
	    builder.setNegativeButton("No, no", new CancelOnClickListener());
	    
	    AlertDialog dialog = builder.create();
	    dialog.show();
	    
	    
	   }
	  return super.onCreateDialog(id);
	}
	
	private final class CancelOnClickListener implements
	  DialogInterface.OnClickListener {
	  public void onClick(DialogInterface dialog, int which) {
	  Toast.makeText(getApplicationContext(), "Activity will continue",
	    Toast.LENGTH_LONG).show();
	  }
	}

	private final class OkOnClickListener implements
	    DialogInterface.OnClickListener {
	  public void onClick(DialogInterface dialog, int which) {
		  MainActivity.this.finish();
	  }
	} 
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.main_actilvity_menu, menu);
		menu.add("Donate");
		menu.add("Support");
		menu.add("The Rock Team members");
		
		MenuItem item = menu.getItem(0);
		item.setIcon(R.drawable.ic_launcher);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==0){
			
			Toast.makeText(this,"Thanks for comming", Toast.LENGTH_SHORT).show();
		}
		return super.onOptionsItemSelected(item);
	}

}
