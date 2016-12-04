package com.example.a1216qdf.senseofsecurity;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SosBellActivity extends AppCompatActivity {

    private ImageView animationIV;
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_bell);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        animationIV = (ImageView) findViewById(R.id.sosbell);
        animationIV.setImageResource(R.drawable.anim);
        animationDrawable = (AnimationDrawable) animationIV.getDrawable();
        animationDrawable.start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        animationDrawable.stop();
    }
}
