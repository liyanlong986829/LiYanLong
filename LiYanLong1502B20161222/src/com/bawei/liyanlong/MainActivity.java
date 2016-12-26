package com.bawei.liyanlong;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView im=(ImageView) findViewById(R.id.im);
		Preferences();
		Animation animation=AnimationUtils.loadAnimation(this, R.anim.translate_imageview);
	    im.startAnimation(animation);
	    im.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(MainActivity.this, MyFragment_Activity.class));
			   sp.edit().putBoolean("b", true).commit();
			   finish();
			}
		});
	}
	private void Preferences() {
		if(sp==null){
			sp=getSharedPreferences("sp", MODE_PRIVATE);
			boolean boolean1 = sp.getBoolean("b", false);
			if(boolean1==true){
				startActivity(new Intent(this, MyFragment_Activity.class));
				finish();
			}
		}
	}

}
