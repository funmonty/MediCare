package com.example.gsdharmesh.medicare;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;
import android.app.Dialog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.DataOutputStream;



public class MainActivity extends AppCompatActivity {


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button doc = (Button) findViewById(R.id.doclogin);
        Button pat = (Button) findViewById(R.id.patlogin);

        final EditText username;
        username = (EditText) findViewById(R.id.et_email);
        final String user=username.getText().toString();

        final EditText passwd;
        passwd = (EditText) findViewById(R.id.et_pass);
        final String passw=passwd.getText().toString();


        final Button reg = (Button) findViewById(R.id.reg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent INT=new Intent(MainActivity.this,register.class);
                startActivity(INT);
            }
        });

        pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent INT=new Intent(MainActivity.this,homePatient.class);
                startActivity(INT);

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
