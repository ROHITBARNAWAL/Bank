package com.example.rohitbarnawal.data;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends Activity {
    Button b;
    EditText e;
    SQLiteDatabase db;
    SQLiteOpenHelper d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        b=(Button)findViewById(R.id.bdel);
        e=(EditText)findViewById(R.id.acciddel);
        final Context context=this;
        try
        {
            db=openOrCreateDatabase("Banking1",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }
        catch(SQLiteException e)
        {
            e.printStackTrace();
            System.out.print("ERROR.............");
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Are you sure?");

                alertDialogBuilder.setPositiveButton("yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String t=(e.getText().toString());
                        try
                        {
                            String d="DELETE FROM bank WHERE id="+t;
                            db.execSQL(d);
                        }
                        catch(Exception e)
                        {
                            System.out.print("Error..................");
                        }

                        e.setText("");
                        Toast.makeText(Delete.this, "Deleted...",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(context,database.class);
                        startActivity(i);
                      /*  Toast.makeText(context, "yes", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(context,database.class);
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
    }
}