package com.example.tresenraya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameLocal extends Activity {
    ImageView casilla11, casilla12, casilla13, casilla21, casilla22,
            casilla23, casilla31, casilla32, casilla33, back, backPopUp, retryPopUp;
    ImageView[] casillas = {casilla11, casilla12, casilla13,
            casilla21, casilla22, casilla23,
            casilla31, casilla32, casilla33};
    int[] casillasId = {R.id.casilla11, R.id.casilla12, R.id.casilla13,
            R.id.casilla21, R.id.casilla22, R.id.casilla23,
            R.id.casilla31, R.id.casilla32, R.id.casilla33};
    private final String[][] tablero = new String[3][3];
    TextView turnos, victoria;

    private final String VALUE_X = String.valueOf(R.drawable.x);
    private final String VALUE_O = String.valueOf(R.drawable.o);
    int turno = 0;
    int x, y = 0;

    @Override
    protected void onCreate(Bundle onSavedInstance){
        super.onCreate(onSavedInstance);
        setContentView(R.layout.game_layout);
        turnos = (TextView) findViewById(R.id.turnos);
        back = (ImageView) findViewById(R.id.backButton);
        backPopUp = (ImageView) findViewById(R.id.backPopUp);
        retryPopUp = (ImageView) findViewById(R.id.retryPopUp);

        backPopUp.setOnClickListener(view -> {
            startActivity(new Intent(GameLocal.this, Online.class));
        });
        retryPopUp.setOnClickListener(view -> {
            finish();
            startActivity(getIntent());
        });
        back.setOnClickListener(view -> {
            startActivity(new Intent(GameLocal.this, Online.class));
        });

        for (int i = 0; i < casillas.length; i++){
            casillas[i] = (ImageView) findViewById(casillasId[i]);
        }
        setup();

        for (int i = 0; i < 9; i++){
            int pos = i;
            int altura = y;
            int base = x;
            casillas[i].setOnClickListener(view -> {
                if (turno % 2 == 0) {
                    casillas[pos].setImageResource(R.drawable.x);
                    casillas[pos].setTag(String.valueOf(R.drawable.x));
                    tablero[base][altura] = String.valueOf(casillas[pos].getTag());
                    turnos.setText("P2 TURN");
                }
                else {
                    casillas[pos].setImageResource(R.drawable.o);
                    casillas[pos].setTag(String.valueOf(R.drawable.o));
                    tablero[base][altura] = String.valueOf(casillas[pos].getTag());
                    turnos.setText("P1 TURN");
                }
                casillas[pos].setClickable(false);
                turno++;
                if (turno >= 5) matchCheck();
            });
            y++;
            if (y == 3){
                y = 0;
                x++;
            }
        }
    }

    private void setup(){
        int button = 0;
        for (int i = 0; i < 3; i++){
            for (int x = 0; x < 3; x++){
                tablero[i][x] = " ";
                button++;
            }
        }
    }
    private void matchCheck(){
        int resultX, resultO;
        resultX = checkX();
        resultO = checkO();

        if (resultX == 3 && resultO == 3) {
            victoria = (TextView) findViewById(R.id.textWin);
            victoria.setText("DRAW");
            end();
        }
        else if (resultX == 1) {
            victoria = (TextView) findViewById(R.id.textWin);
            victoria.setText("P1 WINS");
            end();
        }
        else if (resultO == 2) {
            victoria = (TextView) findViewById(R.id.textWin);
            victoria.setText("P2 WINS");
            end();
        }
    }
    private void end(){
        for (ImageView i : casillas){
            i.setClickable(false);
        }
        LinearLayout victory = (LinearLayout) findViewById(R.id.victory);
        victory.setVisibility(View.VISIBLE);
    }
    private int checkX(){
        if (tablero[0][0].equals(VALUE_X) && tablero[0][1].equals(VALUE_X) && tablero[0][2].equals(VALUE_X)){
            return 1;
        }
        else if (tablero[1][0].equals(VALUE_X) && tablero[1][1].equals(VALUE_X) && tablero[1][2].equals(VALUE_X)) {
            return 1;
        }
        else if (tablero[2][0].equals(VALUE_X) && tablero[2][1].equals(VALUE_X) && tablero[2][2].equals(VALUE_X)) {
            return 1;
        }
        else if (tablero[0][0].equals(VALUE_X) && tablero[1][0].equals(VALUE_X) && tablero[2][0].equals(VALUE_X)) {
            return 1;
        }
        else if (tablero[0][1].equals(VALUE_X) && tablero[1][1].equals(VALUE_X) && tablero[2][1].equals(VALUE_X)) {
            return 1;
        }
        else if (tablero[0][2].equals(VALUE_X) && tablero[1][2].equals(VALUE_X) && tablero[2][2].equals(VALUE_X)) {
            return 1;
        }
        else if (tablero[0][0].equals(VALUE_X) && tablero[1][1].equals(VALUE_X) && tablero[2][2].equals(VALUE_X)) {
            return 1;
        }
        else if (tablero[2][0].equals(VALUE_X) && tablero[1][1].equals(VALUE_X) && tablero[0][2].equals(VALUE_X)) {
            return 1;
        }
        if (turno == 8){
            return 3;
        }
        return 0;
    }
    private int checkO(){
        if (tablero[0][0].equals(VALUE_O) && tablero[0][1].equals(VALUE_O) && tablero[0][2].equals(VALUE_O)){
            return 2;
        }
        else if (tablero[1][0].equals(VALUE_O) && tablero[1][1].equals(VALUE_O) && tablero[1][2].equals(VALUE_O)) {
            return 2;
        }
        else if (tablero[2][0].equals(VALUE_O) && tablero[2][1].equals(VALUE_O) && tablero[2][2].equals(VALUE_O)) {
            return 2;
        }
        else if (tablero[0][0].equals(VALUE_O) && tablero[1][0].equals(VALUE_O) && tablero[2][0].equals(VALUE_O)) {
            return 2;
        }
        else if (tablero[0][1].equals(VALUE_O) && tablero[1][1].equals(VALUE_O) && tablero[2][1].equals(VALUE_O)) {
            return 2;
        }
        else if (tablero[0][2].equals(VALUE_O) && tablero[1][2].equals(VALUE_O) && tablero[2][2].equals(VALUE_O)) {
            return 2;
        }
        else if (tablero[0][0].equals(VALUE_O) && tablero[1][1].equals(VALUE_O) && tablero[2][2].equals(VALUE_O)) {
            return 2;
        }
        else if (tablero[2][0].equals(VALUE_O) && tablero[1][1].equals(VALUE_O) && tablero[0][2].equals(VALUE_O)) {
            return 2;
        }
        if (turno == 8){
            return 3;
        }
        return 0;
    }
}
