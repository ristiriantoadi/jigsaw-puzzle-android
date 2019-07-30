package com.example.testinggridlinear;

import java.util.Random;

public class Puzzle {
    PuzzlePiece [][] puzzlePieces = new PuzzlePiece[3][3];
    PuzzleManager puzzleManager;
    PuzzlePiece firstPieceSelected,secondPieceSelected;
    WinListener winListener;

    public WinListener getWinListener() {
        return winListener;
    }

    public void setWinListener(WinListener winListener) {
        this.winListener = winListener;
    }

    public PuzzleManager getPuzzleManager() {
        return puzzleManager;
    }

    public void setPuzzleManager(PuzzleManager puzzleManager) {
        this.puzzleManager = puzzleManager;
    }

    public Puzzle(PuzzlePiece[][] puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
        for(int y = 0;y<3;y++){
            for(int x=0;x<3;x++){
                this.puzzlePieces[x][y].setPuzzle(this);
            }
        }

        scramble();

    }

    private void scramble(){
        Random random  = new Random();
        for(int y=0;y<3;y++){
            for(int x=0;x<3;x++){
                int scrambledRowPosition = random.nextInt(3);
                int scrambledColumnPosition = random.nextInt(3);
                swap(puzzlePieces[x][y],puzzlePieces[scrambledColumnPosition][scrambledRowPosition]);
            }
        }
    }


    public void pieceDeselected(PuzzlePiece puzzlePiece){
        if(puzzlePiece == firstPieceSelected){
            firstPieceSelected=null;
        }else{
            secondPieceSelected = null;
        }
    }

    public void pieceSelected(PuzzlePiece puzzlePiece){
        if(firstPieceSelected == null){
            firstPieceSelected = puzzlePiece;
            return;
        }else{
            secondPieceSelected = puzzlePiece;
            swap(firstPieceSelected,secondPieceSelected);
            if(isWin()){
                winListener.onWin();
            }
        }
    }
    private void swap(PuzzlePiece firstPieceSelected,PuzzlePiece secondPieceSelected){
        //swap row and column position
        int firstPieceRowPosition = firstPieceSelected.getCurrentRow();
        int firstPieceColumnPosition = firstPieceSelected.getCurrentColumn();
        int secondPieceRowPosition = secondPieceSelected.getCurrentRow();
        int secondPieceColumnPosition = secondPieceSelected.getCurrentColumn();
        firstPieceSelected.setCurrentRow(secondPieceRowPosition);
        firstPieceSelected.setCurrentColumn(secondPieceColumnPosition);
        secondPieceSelected.setCurrentRow(firstPieceRowPosition);
        secondPieceSelected.setCurrentColumn(firstPieceColumnPosition);

        //swap image-non-selected
        int firstPieceImage = firstPieceSelected.getImagePiece();
        int secondPieceImage = secondPieceSelected.getImagePiece();
        firstPieceSelected.setImagePiece(secondPieceImage);
        secondPieceSelected.setImagePiece(firstPieceImage);

        //swap image-selected
        int firstPieceImageSelected = firstPieceSelected.getImagePieceSelected();
        int secondPieceImageSelected  = secondPieceSelected.getImagePieceSelected();
        firstPieceSelected.setImagePieceSelected(secondPieceImageSelected);
        secondPieceSelected.setImagePieceSelected(firstPieceImageSelected);

        //deselect null
        firstPieceSelected.setClicked(false);
        secondPieceSelected.setClicked(false);
        firstPieceSelected=null;
        secondPieceSelected=null;
        this.firstPieceSelected=null;
        this.secondPieceSelected=null;
    }

    private boolean isWin(){
        boolean win=true;
        for(int y = 0;y<3;y++){
            for (int x = 0;x<3;x++){
                int actualRowPosition = puzzlePieces[x][y].getActualRow();
                int actualColumnPosition = puzzlePieces[x][y].getActualColumn();

                int currentRowPosition = puzzlePieces[x][y].getCurrentRow();
                int currentColumnPoition = puzzlePieces[x][y].getCurrentColumn();

                if(actualRowPosition != currentRowPosition){
                    win=false;
                    return win;
                }
                if(actualColumnPosition != currentColumnPoition){
                    win=false;
                    return win;
                }
            }
        }
        return win;
    }
}
