package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnDialog = (Button)this.findViewById(R.id.btnDialog);
		btnDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	launchDialog();
            }
        });
		
		Button btnActivity = (Button)this.findViewById(R.id.btnActivity);
		btnActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		launchActivity();   		
            }
        });
	}

	public void launchDialog() {
		EditText etInput = (EditText)this.findViewById(R.id.etAnswer);
		String message = etInput.getText().toString();
		AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
		adb.setTitle(R.string.lblDialogTitle);
		adb.setMessage(message);
		adb.setPositiveButton(R.string.lblOK, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
			}
		});
		adb.setIcon(R.drawable.ic_launcher);
		AlertDialog ad = adb.create();
		ad.show();
	}
	
	public void launchActivity() {
		EditText etInput = (EditText)this.findViewById(R.id.etAnswer);
		String message = etInput.getText().toString();
		Intent intent = new Intent().setClass(getApplicationContext(), ChildActivity.class);
		intent.putExtra("input", message);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
