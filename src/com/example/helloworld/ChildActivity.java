package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
		Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
			String input = extras.getString("input");
			TextView tv = (TextView) this.findViewById(R.id.tvEnteredText);
			tv.setText(input);
		}
		
		Button btnClose = (Button)this.findViewById(R.id.btnClose);
		btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		finish();
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child, menu);
		return true;
	}

}
