package com.example.testinggridlinear;

public class PuzzleManager {
    Puzzle puzzle;
    public PuzzleManager(Puzzle puzzle){
        this.puzzle = puzzle;
        this.puzzle.setPuzzleManager(this);
    }

    public void initPuzzle(){

    }

}
