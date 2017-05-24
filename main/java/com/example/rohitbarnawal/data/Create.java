package com.example.rohitbarnawal.data;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohitbarnawal.data.database;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Create extends Activity {
    Button b;
    EditText t1;
    EditText t2;
    EditText t3;
    SQLiteDatabase db;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        t1 = (EditText) findViewById(R.id.t1);
        t2 = (EditText) findViewById(R.id.t2);
        t3 = (EditText) findViewById(R.id.t3);
        final Context context = this;
        try {
            db = openOrCreateDatabase("Banking1", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            db.execSQL("CREATE TABLE bank (id integer PRIMARY KEY, type text, bal integer)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        b.setOnClickListener(new View.OnClickListener() {
            ContentValues values = new ContentValues();
            @Override
            public void onClick(View v) {

                String s = t1.getText().toString();
                String s1 = t2.getText().toString();
                String s2 = t3.getText().toString();
                //db.execSQL("INSERT INTO log VALUES (s)");


                values.put("id", s);
                values.put("type", s1);
                values.put("bal", s2);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Are you sure ?");

                alertDialogBuilder.setPositiveButton("yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if ((db.insert("bank", null, values)) != -1) {
                            Toast.makeText(Create.this, "Inserted...", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Create.this, "Error...", Toast.LENGTH_LONG).show();
                        }
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        Intent i = new Intent(context, database.class);
                        startActivity(i);

                  /*      Toast.makeText(context, "yes", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(context, database.class);
                        startActivity(i); */
                    }

                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }

                );
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Create Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.rohitbarnawal.data/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Create Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.rohitbarnawal.data/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
