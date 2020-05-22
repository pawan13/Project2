package com.example.pawansiwakoti.project2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class NewGameActivity extends AppCompatActivity implements View.OnClickListener{

        private Button[][] buttons = new Button[3][3];
        private Boolean playerXTurn = true;

        TextView Winner;
        TextView HighScore;
        TextView Playerxname;
        TextView Playeroname;
        Button Quit;
        Button Reset;
        Button GameHistory;

        private int roundCount;
        private int playerXPoints;
        private int playerOPoints;

        private TextView textViewPlayerX;
        private TextView textViewPlayerO;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_game);
            textViewPlayerX = findViewById(R.id.txtplayerx);
            textViewPlayerO = findViewById(R.id.txtplayero);
            Winner = (TextView)findViewById(R.id.txtwinner);
            HighScore =(TextView)findViewById(R.id.textView3);
            Playerxname = (TextView)findViewById(R.id.playerXname);
            Playeroname = (TextView)findViewById(R.id.playeroname);
            GameHistory = (Button)findViewById(R.id.btnGameHis_);
            GameHistory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences settings = getSharedPreferences("MyGameHistory", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    String History = Winner.getText().toString();
                    editor.putString("History", History);
                    editor.apply();

                    Intent GHistory = new Intent (getApplicationContext(), GameHistory.class);
                    startActivity(GHistory);
                    finish();
                }
            });


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String buttonID = "button_" + i + j;
                    int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    buttons[i][j] = findViewById(resID);
                    buttons[i][j].setOnClickListener(this);
                }

            }

            Reset = findViewById(R.id.btnReset);
            Reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetGame();
                }
            });
            Quit = (Button)findViewById(R.id.btnquit);
            Quit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences settings = getSharedPreferences("MyHighScore", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    String highscore = HighScore.getText().toString();
                    editor.putString("highScore", highscore);
                    editor.apply();

                    Intent score = new Intent(getApplicationContext(), HighScore.class);
                    startActivity(score);
                    finish();
                }
            });
     }


        void loadpreference(){
            SharedPreferences settings = getSharedPreferences("MySharedPreferenceFile", 0);
            String playerXName,playerOName;
            playerXName = settings.getString("editTextContent", "");
            playerOName = settings.getString("editTextContent1", "");
                Playerxname.setText("The PlayerX is " + playerXName);
                Playeroname.setText("The PlayerO is " + playerOName);
            return;

        }
        @Override
        protected void onStart(){
            super.onStart();
            loadpreference();
        }


      @Override
        public void onClick(View v) {
            if (!((Button) v).getText().toString().equals("")) {
                return;
            }

          if (playerXTurn) {
              ((Button) v).setText("X");
          }
          else{
              ((Button) v).setText("O");
          }
          roundCount++;

          if (checkForWin()) {
              if (playerXTurn) {
                  playerXWins();
                  Winner.setText("PlayerX has Won");
              } else {
                  playerOWins();
                  Winner.setText("PlayerO has Won");
              }
          } else if (roundCount == 9) {
              draw();
          } else {
              playerXTurn = !playerXTurn;
          }


      }

        private boolean checkForWin() {
            String[][] box = new String[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    box[i][j] = buttons[i][j].getText().toString();
                }
            }
            for (int i = 0; i < 3; i++) {
                if (box[i][0].equals(box[i][1]) && box[i][0].equals(box[i][2]) &&
                        !box[i][0].equals("")) {
                    return true;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (box[0][i].equals(box[1][i]) && box[0][i].equals(box[2][i]) &&
                        !box[0][i].equals("")) {
                    return true;
                }
            }
            if (box[0][0].equals(box[1][1]) && box[0][0].equals(box[2][2]) &&
                    !box[0][0].equals("")) {
                return true;
            }
            if (box[0][2].equals(box[1][1]) && box[0][2].equals(box[2][0]) &&
                    !box[0][2].equals("")) {
                return true;
            }
            return false;
        }


        private void playerXWins() {
            playerXPoints++;
            Toast.makeText(this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            updatePointsText();
            highestpoint();
            resetBoard();
        }

        private void playerOWins() {
            playerOPoints++;
            Toast.makeText(this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            updatePointsText();
            highestpoint();
            resetBoard();
        }

        private void draw() {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            resetBoard();
        }

        private void updatePointsText() {
            textViewPlayerX.setText( "PlayerX: "+ playerXPoints);
            textViewPlayerO.setText("PlayerO: " + playerOPoints);
        }

        private void resetBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setText("");
                }
            }
            roundCount = 0;
            playerXTurn = true;
        }
        public void highestpoint(){
            if (playerXPoints > playerOPoints){
                HighScore.setText("PlayerX has high score" + playerXPoints );
            }
            else if(playerXPoints == playerOPoints) {
                HighScore.setText("Score is draw" + playerXPoints  );
            }else {
                HighScore.setText("PlayerO has high score" + playerOPoints );
            }
        }


        private void resetGame() {
            playerXPoints = 0;
            playerOPoints = 0;
            updatePointsText();
            resetBoard();
            HighScore.setText("who has high Score?");
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putInt("roundCount", roundCount);
            outState.putInt("playerXPoints", playerXPoints);
            outState.putInt("playerOPoints", playerOPoints);
            outState.putBoolean("playerXTurn", playerXTurn);

        }

        @Override
        protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
            roundCount = savedInstanceState.getInt("roundCount");
            playerXPoints = savedInstanceState.getInt("playerXPoints");
            playerOPoints = savedInstanceState.getInt("playerOPoints");
            playerXTurn = savedInstanceState.getBoolean("playerXTurn");
        }
    }





