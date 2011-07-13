package org.MemoryAndroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Main extends Activity implements OnClickListener{
	View play;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		play=findViewById(R.id.menubutton);
		play.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		Intent game=new Intent(this, Game.class);
		startActivity(game);
		
	}

	
}
