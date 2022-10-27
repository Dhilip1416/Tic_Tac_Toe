package com.example.tic_tac_toe;

import static com.example.tic_tac_toe.MainActivity.firstplayer;
import static com.example.tic_tac_toe.MainActivity.secondplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tac,tac1;

        boolean stg = true;
        
        int currentplayer = 0;
        int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

        int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}};
        public static int counter = 0;

        @SuppressLint("SetTextI18n")
        public void playerTap(View view) {
            ImageView img = (ImageView) view;
            int tappedImage = Integer.parseInt(img.getTag().toString());
            if (!stg) {
                gameReset(view);
            }
            if (gameState[tappedImage] == 2) {
                counter++;
                Log.d("counter:", String.valueOf(counter));
                if (counter == 9) {
                    stg = false;
//                    TextView status = findViewById(R.id.status);
//                    status.setText("Draw");
//                    counter = 0;


                }
                gameState[tappedImage] = currentplayer;
                img.setTranslationY(-1000f);

                if (currentplayer == 0) {
                    img.setImageResource(R.drawable.x);
                    currentplayer = 1;
                    TextView status = findViewById(R.id.status);

                    status.setText(secondplayer+" - Tap to play");
                } else {
                    img.setImageResource(R.drawable.o
                    );
                    currentplayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText(firstplayer+" - Tap to play");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            int flag = 0;
            for (int[] winPosition : winPositions) {
                if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                        gameState[winPosition[1]] == gameState[winPosition[2]] &&
                        gameState[winPosition[0]] != 2) {
                    flag = 1;
                    String winnerStr = null;

                    stg = false;
                    if (gameState[winPosition[0]] == 0) {
                        winnerStr = firstplayer +"  Won ";
                        counter = 0;
                    } else if(gameState[winPosition[0]] != 0){
                        winnerStr = secondplayer +"  Won ";
                        counter = 0;
                    }else {
                        counter = 0;
                        TextView status = findViewById(R.id.status);
                        status.setText("Draw");
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                }
            }
            if (counter == 9 && flag == 0) {
                TextView status = findViewById(R.id.status);
                status.setText("Draw");
                counter = 0;
            }
        }

        @SuppressLint("SetTextI18n")
        public void gameReset(View view) {
            stg = true;
            currentplayer = 0;
            for (int i = 0; i < gameState.length; i++) {
                gameState[i] = 2;
            }
            ((ImageView) findViewById(R.id.img0)).setImageResource(0);
            ((ImageView) findViewById(R.id.img1)).setImageResource(0);
            ((ImageView) findViewById(R.id.img2)).setImageResource(0);
            ((ImageView) findViewById(R.id.img3)).setImageResource(0);
            ((ImageView) findViewById(R.id.img4)).setImageResource(0);
            ((ImageView) findViewById(R.id.img5)).setImageResource(0);
            ((ImageView) findViewById(R.id.img6)).setImageResource(0);
            ((ImageView) findViewById(R.id.img7)).setImageResource(0);
            ((ImageView) findViewById(R.id.img8)).setImageResource(0);

            TextView status = findViewById(R.id.status);
            status.setText(firstplayer+" - Tap to play");
        }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tac = findViewById(R.id.playerone);
        tac1 = findViewById(R.id.playertwo);

        tac.setText(firstplayer +" choose X");
        tac1.setText(secondplayer+" choose O");
    }
}