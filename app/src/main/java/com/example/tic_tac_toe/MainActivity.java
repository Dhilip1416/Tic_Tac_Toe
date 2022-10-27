package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button start;
    AlertDialog.Builder builder;
    EditText pl1,pl2;
    TextView tv1,tv2;
    public static String firstplayer ,secondplayer;
        @SuppressLint({"MissingInflatedId", "SetTextI18n"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            start = findViewById(R.id.bt1);
            tv1=findViewById(R.id.tv4);
            tv2=findViewById(R.id.tv5);
            pl1=findViewById(R.id.et1);
            pl2=findViewById(R.id.et2);

            builder = new AlertDialog.Builder(this);
            start.setOnClickListener(v -> {
                    try {
                        firstplayer = pl1.getText().toString().trim();
                        secondplayer = pl2.getText().toString().trim();
                        Log.d("First player",firstplayer);
                        if(firstplayer.equals("") || secondplayer.equals("")) {

                            Toast.makeText(this, "Enter the Player name", Toast.LENGTH_SHORT).show();
                        }else {
                            builder.setIcon(R.drawable.star);
                            builder.setMessage("Start the Game " + firstplayer + " && " + secondplayer)
                                    .setCancelable(false)
                                    .setPositiveButton("Yes",(dialog, id) -> {
                                        openMainActivity2();
                                    })
                                    .setNegativeButton("No", (dialog, id) -> dialog.cancel());

                            AlertDialog alert = builder.create();
                            alert.show();

                                              }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Enter the Player name", Toast.LENGTH_SHORT).show();
                    }

                });
        }

    private void openMainActivity2() {
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
    }
}
