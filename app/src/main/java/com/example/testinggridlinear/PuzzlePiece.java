package com.example.testinggridlinear;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PuzzlePiece implements View.OnClickListener {
    int currentRow,currentColumn,actualRow,actualColumn;
    int imagePieceSelected,imagePiece;
    Button button;
    boolean clicked;
    Puzzle puzzle;

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public PuzzlePiece(int actualRow, int actualColumn, final int imagePiece, final int imagePieceSelected, final Button button) {
        this.currentRow = actualRow;
        this.currentColumn = actualColumn;
        this.actualRow = actualRow;
        this.actualColumn = actualColumn;
        this.imagePiece = imagePiece;
        this.imagePieceSelected = imagePieceSelected;
        this.button = button;
        button.setBackgroundResource(imagePiece);
        button.setOnClickListener(this);

    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getImagePieceSelected() {
        return imagePieceSelected;
    }

    public void setImagePieceSelected(int imagePieceSelected) {
        this.imagePieceSelected = imagePieceSelected;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getActualRow() {
        return actualRow;
    }

    public void setActualRow(int actualRow) {
        this.actualRow = actualRow;
    }

    public int getActualColumn() {
        return actualColumn;
    }

    public void setActualColumn(int actualColumn) {
        this.actualColumn = actualColumn;
    }

    public int getImagePiece() {
        return imagePiece;
    }

    public void setImagePiece(int imagePiece) {

        this.imagePiece = imagePiece;
        button.setBackgroundResource(this.imagePiece);
    }

    @Override
    public void onClick(View v) {
        if(clicked){
            button.setBackgroundResource(imagePiece);
            clicked = false;
            puzzle.pieceDeselected(PuzzlePiece.this);
        }else{
            button.setBackgroundResource(imagePieceSelected);
            clicked = true;
            puzzle.pieceSelected(PuzzlePiece.this);
        }
    }
}
