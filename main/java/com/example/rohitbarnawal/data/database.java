package com.example.rohitbarnawal.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class database extends AppCompatActivity {

    Button create, del, view, update;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        final Animation animaTrsnslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);



        Button btnTranslate = (Button) findViewById(R.id.create);
        Button btnAlpha = (Button) findViewById(R.id.view);
        Button btnScale = (Button) findViewById(R.id.update);
        Button btndel = (Button) findViewById(R.id.del);

        final Context context = this;
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animaTrsnslate);


                Intent i = new Intent(context, Create.class);
                startActivity(i);
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animaTrsnslate);
                Intent i = new Intent(context, Delete.class);
                startActivity(i);
            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animaTrsnslate);
                Intent i = new Intent(context, Viewacc.class);
                startActivity(i);
            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animaTrsnslate);
                    Intent i = new Intent(context, Update.class);
                startActivity(i);
            }
        });

    }

    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        //finish();
      //  System.exit(0);

    }
}
