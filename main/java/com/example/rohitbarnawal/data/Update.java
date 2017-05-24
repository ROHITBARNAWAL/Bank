package com.example.rohitbarnawal.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    SQLiteDatabase db;
    EditText e,e1,e2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        e = (EditText)findViewById(R.id.editText4);
        e1 = (EditText)findViewById(R.id.editText5);
        e2 = (EditText)findViewById(R.id.editText6);
        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button3);
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
        b1.setOnClickListener(new View.OnClickListener() {
            Integer i,i1;
            String s1,s2,s;
            @Override
            public void onClick(View v) {
                try
                {
                    s = e.getText().toString();
                    i = Integer.parseInt(s);
                    s2= e2.getText().toString();
                    i1 = Integer.parseInt(s2);
               // ContentValues values= new ContentValues();

                    //db.execSQL(UPDATE bank, "id,type,bal" + "VALUES(i,s1,i1)","where id = i",null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Are you sure?");

                    alertDialogBuilder.setPositiveButton("yes",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db.execSQL("UPDATE bank SET id='"+i+"',type='"+s1+"',bal='"+i1+"' WHERE id = '"+i+"'");
                            Toast.makeText(Update.this,"Updated.....",Toast.LENGTH_LONG).show();
                         /*   Toast.makeText(context, "yes", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, Main2Activity.class);
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
                catch(Exception e)
                {
                    System.out.print("Error..................");
                    Toast.makeText(Update.this,"Error.....",Toast.LENGTH_LONG).show();
                }
                e.setText("");
                e1.setText("");
                e2.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(context,database.class);
                startActivity(i3);
            }
        });
    }
}
// myDB.update(TableName, "(Field1, Field2, Field3)" + " VALUES ('Bob', 19, 'Male')", "where _id = 1", null);
//db.execSQL("UPDATE student SET name='"+editName.getText()+"',marks='"+
//editMarks.getText()+"' WHERE rollno='"+editRollno.getText()+"'");
