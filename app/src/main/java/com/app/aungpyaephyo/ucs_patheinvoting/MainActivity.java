package com.app.aungpyaephyo.ucs_patheinvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref= null;

    private Button boys,girls,login;
    //qr code scanner object
    private IntentIntegrator qrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        myDbAdapter db=new myDbAdapter(this);
        boys=findViewById(R.id.boys);
        girls=findViewById(R.id.girls);
        login=findViewById(R.id.login);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref=getSharedPreferences("com.app.aungpyaephyo.ucs_patheinvoting",MODE_PRIVATE);

        if (pref.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            Toast.makeText(this,"first time",Toast.LENGTH_LONG).show();
            for(int i=1;i<100;i++) {
               db.insertData("1CST_" + i);
            }
            Toast.makeText(this,"data inserted",Toast.LENGTH_LONG).show();
            // using the following line to edit/commit prefs
            pref.edit().putBoolean("firstrun", false).commit();

        }
        else{
            Toast.makeText(this,"not first times",Toast.LENGTH_LONG).show();
        }


   //     Toast.makeText(this,db.getData(),Toast.LENGTH_LONG).show();
   //     Log.i("data",db.getData("CST_2"));
        //intializing scan object
        qrScan = new IntentIntegrator(this);

    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        myDbAdapter db = new myDbAdapter(this);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    // textViewName.setText(obj.getString("name"));
                    // textViewAddress.setText(obj.getString("address"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    if(db.getData(result.getContents()).equals(result.getContents()))
                    {
                        Intent intent=new Intent(this,VoteActivity.class);
                        startActivity(intent);
                        this.finish();
                    }

                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void btnClick(View view) {
        //initiating the qr code scan
        switch (view.getId()) {
            case R.id.login:
                qrScan.initiateScan();
                break;
            case R.id.boys: {

                myDbAdapter db = new myDbAdapter(this);
                Toast.makeText(this, db.getData(), Toast.LENGTH_LONG).show();
            }
            break;
            case R.id.girls: {
                myDbAdapter db = new myDbAdapter(this);

                Toast.makeText(this, db.getData("1CST_49"), Toast.LENGTH_LONG).show();

            }
            break;
        }


    }
    protected void onResume() {
        super.onResume();

    }
    }

