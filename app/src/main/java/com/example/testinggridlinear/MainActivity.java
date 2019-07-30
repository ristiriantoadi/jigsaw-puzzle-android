package com.example.testinggridlinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements WinListener{
    Button button11,button12,button13,button21,button22,button23,
    button31,button32,button33,firstButtonClicked,secondButtonClicked;
    int firstPieceRow,secondPieceRow,firstPieceColumn,secondPieceColumn;
    boolean button11Clicked,button12Clicked,button13Clicked,
            button21Clicked,button22Clicked,button23Clicked,
            button31Clicked,button32Clicked,button33Clicked,firstPieceChosen;
    Puzzle puzzle;
    //PuzzleManager puzzleManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPuzzle();

//        button11 = findViewById(R.id.button_1_1);
//        button12 = findViewById(R.id.button_1_2);
//        button13 = findViewById(R.id.button_1_3);
//
//        button21 = findViewById(R.id.button_2_1);
//        button22 = findViewById(R.id.button_2_2);
//        button23 = findViewById(R.id.button_2_3);
//
//        button31 = findViewById(R.id.button_3_1);
//        button32 = findViewById(R.id.button_3_2);
//        button33 = findViewById(R.id.button_3_3);
//
//        button11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button11);
//            }
//        });
//
//        button12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button12);
//            }
//        });
//
//        button13.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button13);
//            }
//        });
//
//        button21.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button21);
//            }
//        });
//
//        button22.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button22);
//            }
//        });
//
//        button23.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button23);
//            }
//        });
//
//
//        button31.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button31);
//            }
//        });
//
//        button32.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button32);
//            }
//        });
//
//        button33.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButtonClicked(button33);
//                if(firstPieceChosen)
//                    Log.d("first_piece_chosen","true");
//                else Log.d("first_piece_chosen","false");
//
//                Log.d("first_piece_row",""+firstPieceRow);
//                Log.d("first_piece_column",""+firstPieceColumn);
//            }
//        });

    }

    private void onButtonClicked(Button button){
        if(firstPieceChosen){
            if(firstButtonClicked == button){
                firstPieceChosen = false;
                firstPieceRow=-1;
                firstPieceColumn=-1;
                firstButtonClicked=null;

                if(button == button11){
                    button11.setBackgroundResource(R.drawable.row_0_col_0_black_border);
                    button11Clicked=false;
                }
                else if(button == button12){
                    button12.setBackgroundResource(R.drawable.row_0_col_1_black_border);
                    button12Clicked=false;
                }
                else if(button == button13){
                    button13.setBackgroundResource(R.drawable.row_0_col_2_black_border);
                    button13Clicked=false;
                }
                else if(button == button21){
                        button21.setBackgroundResource(R.drawable.row_1_col_0_black_border);
                        button21Clicked=false;
                }
                else if(button == button22){
                        button22.setBackgroundResource(R.drawable.row_1_col_1_black_border);
                        button22Clicked=false;
                }
                else if(button == button23){
                        button23.setBackgroundResource(R.drawable.row_1_col_2_black_border);
                        button23Clicked=false;
                }
                else if(button == button31){
                        button31.setBackgroundResource(R.drawable.row_2_col_0_black_border);
                        button31Clicked=false;
                }
                else if(button == button32){
                        button32.setBackgroundResource(R.drawable.row_2_col_1_black_border);
                        button32Clicked=false;
                }
                else if(button == button33){
                        button33.setBackgroundResource(R.drawable.row_2_col_2_black_border);
                        button33Clicked=false;
                }
            }else{
                if(button11 == button){
                    secondPieceRow = 1;
                    secondPieceColumn = 1;
                    secondButtonClicked = button;
                    button11.setBackgroundResource(R.drawable.row_0_col_0_black_border);
                    button11Clicked=false;
                }
                else if(button12 == button){
                    secondPieceRow = 1;
                    secondPieceColumn = 2;
                    secondButtonClicked = button;
                    button12.setBackgroundResource(R.drawable.row_0_col_1_black_border);
                    button12Clicked=false;
                }
                else if(button13 == button){
                    secondPieceRow = 1;
                    secondPieceColumn = 3;
                    secondButtonClicked = button;
                    button13.setBackgroundResource(R.drawable.row_0_col_2_black_border);
                    button13Clicked=false;
                }
                else if(button21 == button){
                    secondPieceRow = 2;
                    secondPieceColumn = 1;
                    secondButtonClicked = button;
                    button21.setBackgroundResource(R.drawable.row_1_col_0_black_border);
                    button21Clicked=false;
                }
                else if(button22 == button){
                    secondPieceRow = 2;
                    secondPieceColumn = 2;
                    secondButtonClicked = button;
                    button22.setBackgroundResource(R.drawable.row_1_col_1_black_border);
                    button22Clicked=false;
                }
                else if(button23 == button){
                    secondPieceRow = 2;
                    secondPieceColumn = 3;
                    secondButtonClicked = button;
                    button23.setBackgroundResource(R.drawable.row_1_col_2_black_border);
                    button23Clicked=false;
                }
                else if(button31 == button){
                    secondPieceRow = 3;
                    secondPieceColumn = 1;
                    secondButtonClicked = button;
                    button31.setBackgroundResource(R.drawable.row_2_col_0_black_border);
                    button31Clicked=false;
                }
                else if(button32 == button){
                    secondPieceRow = 3;
                    secondPieceColumn = 2;
                    secondButtonClicked = button;
                    button32.setBackgroundResource(R.drawable.row_2_col_1_black_border);
                    button32Clicked=false;
                }
                else if(button33 == button){
                    secondPieceRow = 3;
                    secondPieceColumn = 3;
                    secondButtonClicked = button;
                    button33.setBackgroundResource(R.drawable.row_2_col_2_black_border);
                    button33Clicked=false;
                }

                swap();
                secondPieceRow=-1;
                secondPieceColumn=-1;
                firstPieceRow=-1;
                firstPieceColumn=-1;
                firstPieceChosen=false;

                if(firstButtonClicked == button11){
                    //button11Clicked
                    button11.setBackgroundResource(R.drawable.row_0_col_0_black_border);
                    button11Clicked=false;
                }
                else if(firstButtonClicked == button12){
                    button12.setBackgroundResource(R.drawable.row_0_col_1_black_border);
                    button12Clicked=false;
                }
                else if(firstButtonClicked == button13){
                    button13.setBackgroundResource(R.drawable.row_0_col_2_black_border);
                    button13Clicked=false;
                }
                else if(firstButtonClicked == button21){
                    button21.setBackgroundResource(R.drawable.row_1_col_0_black_border);
                    button21Clicked=false;
                }
                else if(firstButtonClicked == button22){
                    button22.setBackgroundResource(R.drawable.row_1_col_1_black_border);
                    button22Clicked=false;
                }
                else if(firstButtonClicked == button23){
                    button23.setBackgroundResource(R.drawable.row_1_col_2_black_border);
                    button23Clicked=false;
                }
                else if(firstButtonClicked == button31){
                    button31.setBackgroundResource(R.drawable.row_2_col_0_black_border);
                    button31Clicked=false;
                }
                else if(firstButtonClicked == button32){
                    button32.setBackgroundResource(R.drawable.row_2_col_1_black_border);
                    button32Clicked=false;
                }
                else if(firstButtonClicked == button33){
                    button33.setBackgroundResource(R.drawable.row_2_col_1_black_border);
                    button33Clicked=false;
                }
                firstButtonClicked=null;
                secondButtonClicked=null;
            }
        }else{
            if(button == button11){
                if(button11Clicked){//pas puzzle piece yg sama diklik double
                    button11.setBackgroundResource(R.drawable.row_0_col_0_black_border);
                    button11Clicked=false;
                }else{
                    button11.setBackgroundResource(R.drawable.row_0_col_0_yellow_border);
                    button11Clicked=true;
                    firstPieceColumn=1;
                    firstPieceRow=1;
                    firstPieceChosen=true;

                    firstButtonClicked=button11;
                }
            }
            else if(button == button12){
                if(button12Clicked){//pas puzzle piece yg sama diklik double
                    button12.setBackgroundResource(R.drawable.row_0_col_1_black_border);
                    button12Clicked=false;
                }else{
                    button12.setBackgroundResource(R.drawable.row_0_col_1_yellow_border);
                    button12Clicked=true;
                    firstPieceRow=1;
                    firstPieceColumn=2;

                    firstPieceChosen=true;

                    firstButtonClicked=button12;

                }
            }
            else if(button == button13){
                if(button13Clicked){//pas puzzle piece yg sama diklik double
                    button13.setBackgroundResource(R.drawable.row_0_col_2_black_border);
                    button13Clicked=false;
                }else{
                    button13.setBackgroundResource(R.drawable.row_0_col_2_yellow_border);
                    button13Clicked=true;
                    firstPieceRow=1;
                    firstPieceColumn=3;

                    firstPieceChosen=true;

                    firstButtonClicked=button13;
                }
            }
            else if(button == button21){
                if(button21Clicked){//pas puzzle piece yg sama diklik double
                    button21.setBackgroundResource(R.drawable.row_1_col_0_black_border);
                    button21Clicked=false;
                }else{
                    button21.setBackgroundResource(R.drawable.row_1_col_0_yellow_border);
                    button21Clicked=true;
                    firstPieceRow=2;
                    firstPieceColumn=1;

                    firstPieceChosen=true;

                    firstButtonClicked=button21;
                }
            }
            else if(button == button22){
                if(button22Clicked){//pas puzzle piece yg sama diklik double
                    button22.setBackgroundResource(R.drawable.row_1_col_1_black_border);
                    button22Clicked=false;
                }else{
                    button22.setBackgroundResource(R.drawable.row_1_col_1_yellow_border);
                    button22Clicked=true;
                    firstPieceRow=2;
                    firstPieceColumn=2;

                    firstPieceChosen=true;


                    firstButtonClicked=button22;
                }
            }
            else if(button == button23){
                if(button23Clicked){//pas puzzle piece yg sama diklik double
                    button23.setBackgroundResource(R.drawable.row_1_col_2_black_border);
                    button23Clicked=false;
                }else{
                    button23.setBackgroundResource(R.drawable.row_1_col_2_yellow_border);
                    button23Clicked=true;
                    firstPieceRow=2;
                    firstPieceColumn=3;

                    firstPieceChosen=true;


                    firstButtonClicked=button23;
                }
            }
            else if(button == button31){
                if(button31Clicked){//pas puzzle piece yg sama diklik double
                    button31.setBackgroundResource(R.drawable.row_2_col_0_black_border);
                    button31Clicked=false;
                }else{
                    button31.setBackgroundResource(R.drawable.row_2_col_0_yellow_border);
                    button31Clicked=true;
                    firstPieceRow=3;
                    firstPieceColumn=1;

                    firstPieceChosen=true;

                    firstButtonClicked=button31;
                }
            }
            else if(button == button32){
                if(button32Clicked){//pas puzzle piece yg sama diklik double
                    button32.setBackgroundResource(R.drawable.row_2_col_1_black_border);
                    button32Clicked=false;
                }else{
                    button32.setBackgroundResource(R.drawable.row_2_col_1_yellow_border);
                    button32Clicked=true;
                    firstPieceRow=3;
                    firstPieceColumn=2;

                    firstPieceChosen=true;

                    firstButtonClicked=button32;
                }
            }
            else if(button == button33){
                if(button33Clicked){//pas puzzle piece yg sama diklik double
                    button33.setBackgroundResource(R.drawable.row_2_col_2_black_border);
                    button33Clicked=false;
                }else{
                    button33.setBackgroundResource(R.drawable.row_2_col_2_yellow_border);
                    button33Clicked=true;
                    firstPieceRow=3;
                    firstPieceColumn=3;

                    firstPieceChosen=true;

                    firstButtonClicked=button33;
                }
            }
        }
    }

    private void swap(){
        //swap it
        String text = "Swapping "+firstPieceRow+""+firstPieceColumn+" and "+secondPieceRow+""+secondPieceColumn;
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        int temp = firstPieceRow;
        firstPieceRow = firstPieceColumn;
        firstPieceColumn = temp;

        temp = secondPieceRow;
        secondPieceRow = secondPieceColumn;
        secondPieceColumn = temp;

        if(firstPieceRow == 1 && firstPieceColumn == 1){
            firstButtonClicked.setBackgroundResource(R.drawable.row_0_col_0_black_border);
        }
        else if(firstPieceRow == 1 && firstPieceColumn == 2){
            firstButtonClicked.setBackgroundResource(R.drawable.row_0_col_1_black_border);
        }
        else if(firstPieceRow == 1 && firstPieceColumn == 3){
            firstButtonClicked.setBackgroundResource(R.drawable.row_0_col_2_black_border);
        }
        else if(firstPieceRow == 2 && firstPieceColumn == 1){
            firstButtonClicked.setBackgroundResource(R.drawable.row_1_col_0_black_border);
        }
        else if(firstPieceRow == 2 && firstPieceColumn == 2){
            firstButtonClicked.setBackgroundResource(R.drawable.row_1_col_1_black_border);
        }
        else if(firstPieceRow == 2 && firstPieceColumn == 3){
            firstButtonClicked.setBackgroundResource(R.drawable.row_1_col_2_black_border);
        }
        else if(firstPieceRow == 3 && firstPieceColumn == 1){
            firstButtonClicked.setBackgroundResource(R.drawable.row_2_col_0_black_border);
        }
        else if(firstPieceRow == 3 && firstPieceColumn == 2){
            firstButtonClicked.setBackgroundResource(R.drawable.row_2_col_1_black_border);
        }
        else if(firstPieceRow == 3 && firstPieceColumn == 3){
            firstButtonClicked.setBackgroundResource(R.drawable.row_2_col_2_black_border);
        }



        if(secondPieceRow == 1 && secondPieceColumn == 1){
            secondButtonClicked.setBackgroundResource(R.drawable.row_0_col_0_black_border);
        }
        else if(secondPieceRow == 1 && secondPieceColumn == 2){
            secondButtonClicked.setBackgroundResource(R.drawable.row_0_col_1_black_border);
        }
        else if(secondPieceRow == 1 && secondPieceColumn == 3){
            secondButtonClicked.setBackgroundResource(R.drawable.row_0_col_2_black_border);
        }
        else if(secondPieceRow == 2 && secondPieceColumn == 1){
            secondButtonClicked.setBackgroundResource(R.drawable.row_1_col_0_black_border);
        }
        else if(secondPieceRow == 2 && secondPieceColumn == 2){
            secondButtonClicked.setBackgroundResource(R.drawable.row_1_col_1_black_border);
        }
        else if(secondPieceRow == 2 && secondPieceColumn == 3){
            secondButtonClicked.setBackgroundResource(R.drawable.row_1_col_2_black_border);
        }
        else if(secondPieceRow == 3 && secondPieceColumn == 1){
            secondButtonClicked.setBackgroundResource(R.drawable.row_2_col_0_black_border);
        }
        else if(secondPieceRow == 3 && secondPieceColumn == 2){
            secondButtonClicked.setBackgroundResource(R.drawable.row_2_col_1_black_border);
        }
        else if(secondPieceRow == 3 && secondPieceColumn == 3){
            secondButtonClicked.setBackgroundResource(R.drawable.row_2_col_2_black_border);
        }
    }

    private void initPuzzle(){
        PuzzlePiece [][] puzzlePieces = new PuzzlePiece[3][3];
        puzzlePieces[0][0] = new PuzzlePiece(0,0,R.drawable.row_0_col_0_black_border,R.drawable.row_0_col_0_yellow_border,
                (Button)findViewById(R.id.button_0_0));
        puzzlePieces[0][1] = new PuzzlePiece(0,1,R.drawable.row_0_col_1_black_border,R.drawable.row_0_col_1_yellow_border,
                (Button)findViewById(R.id.button_0_1));
        puzzlePieces[0][2] = new PuzzlePiece(0,2,
                R.drawable.row_0_col_2_black_border,R.drawable.row_0_col_2_yellow_border,
                (Button)findViewById(R.id.button_0_2));
        puzzlePieces[1][0] = new PuzzlePiece(1,0,
                R.drawable.row_1_col_0_black_border,
                R.drawable.row_1_col_0_yellow_border,(Button)findViewById(R.id.button_1_0));
        puzzlePieces[1][1] = new PuzzlePiece(1,1,
                R.drawable.row_1_col_1_black_border,
                R.drawable.row_1_col_1_yellow_border,(Button)findViewById(R.id.button_1_1));
        puzzlePieces[1][2] = new PuzzlePiece(1,2,
                R.drawable.row_1_col_2_black_border,
                R.drawable.row_1_col_2_yellow_border,(Button)findViewById(R.id.button_1_2));
        puzzlePieces[2][0] = new PuzzlePiece(2,0,
                R.drawable.row_2_col_0_black_border,
                R.drawable.row_2_col_0_yellow_border,(Button)findViewById(R.id.button_2_0));
        puzzlePieces[2][1] = new PuzzlePiece(2,1,
                R.drawable.row_2_col_1_black_border,
                R.drawable.row_2_col_1_yellow_border,(Button)findViewById(R.id.button_2_1));
        puzzlePieces[2][2] = new PuzzlePiece(2,2,
                R.drawable.row_2_col_2_black_border,
                R.drawable.row_2_col_2_yellow_border,(Button)findViewById(R.id.button_2_2));
        puzzle = new Puzzle(puzzlePieces);
        puzzle.setWinListener(this);


    }

    @Override
    public void onWin() {
        Toast.makeText(getApplicationContext(),"You win!!!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,InfoClass.class);
        startActivity(intent);
    }
}
