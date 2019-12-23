package com.app.aungpyaephyo.ucs_patheinvoting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class VoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button vote;
    ImageView imageView;
    String type="";
    String select="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        imageView = findViewById(R.id.image);

        Bundle bundle=getIntent().getExtras();
        type=bundle.getString("type");
        select=bundle.getString("select");

        addItemsOnSpinner();

        addListenerOnButton();

        addListenerOnSpinnerItemSelection();

    }


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        switch (parent.getItemAtPosition(pos).toString()) {
            case "Zay Min Paing":
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : Zmp" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                break;
            case "Aung Pyae Phyo":
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : APP" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();

                Glide.with(this).load(R.drawable.cu_icon).fitCenter().into(imageView);
                break;
            case "Kaung Khant Paing":
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : KKP" + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = findViewById(R.id.name);
        spinner.setOnItemSelectedListener(this);

    }
        // get the selected dropdown list value
        public void addListenerOnButton () {
            vote = findViewById(R.id.vote);
            vote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(VoteActivity.this,
                            "OnClickListener : " +
                                    "\nVote  : " + spinner.getSelectedItem(),
                            Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(VoteActivity.this,VoteActivity.class);
                    intent.putExtra("type","queen");
                    intent.putExtra("select",spinner.getSelectedItem()+"");
                    startActivity(intent);

                }
            });
        }

        public void addItemsOnSpinner () {
            List<String> list=Arrays.asList();
        spinner=findViewById(R.id.name);
        if(type.equals("king")){
            list = Arrays.asList("Choose your "+type, "Aung Pyae Phyo", "Zay Min Paing", "Kaung Khant Paing");
            if(!select.equals("null")){
                list.remove(select);
            }
        }
        else
        {
            list=Arrays.asList("Choose your "+type,"ma ma ","su su");

        }
         ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);
        }

}