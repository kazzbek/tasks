package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;
    private Model model;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move, Model model) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
        this.model = model;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency that) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == that) return EQUAL;



        if (this.numberOfEmptyTiles > that.numberOfEmptyTiles) return AFTER;
        if (this.numberOfEmptyTiles < that.numberOfEmptyTiles) return BEFORE;

        if (this.score > that.score) return AFTER;
        if (this.score < that.score) return BEFORE;

        if (this.countOfMerge() > that.countOfMerge()) return AFTER;
        if (this.countOfMerge() < that.countOfMerge()) return BEFORE;

        return EQUAL;
    }

    private int countOfMerge(){
        int N = model.getGameTiles().length;
        int count =0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (model.canTileMerge(x, y)) {
                    count++;
                }
            }
        }
        return count;
    }
}
