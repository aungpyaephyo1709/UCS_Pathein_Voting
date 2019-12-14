package com.app.aungpyaephyo.ucs_patheinvoting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button vote;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        imageView = findViewById(R.id.image);

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
                }
            });
        }

        public void addItemsOnSpinner () {

            List<String> list = Arrays.asList("Choose your King", "Aung Pyae Phyo", "Zay Min Paing", "Kaung Khant Paing");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.activity_vote, list);
            dataAdapter.setDropDownViewResource(R.layout.activity_vote);
            spinner.setAdapter(dataAdapter);
        }

    }