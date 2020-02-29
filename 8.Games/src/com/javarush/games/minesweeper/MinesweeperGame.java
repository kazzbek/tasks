package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 2;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                gameField[j][i] = new GameObject(i, j, getRandomNumber(10) == 0);
                if (gameField[j][i].isMine) countMinesOnField++;
                setCellColor(gameField[j][i].x, gameField[j][i].y, Color.ORANGE);
                setCellValue(i,j,"");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject field) {
        List<GameObject> list = new ArrayList<>();
        for (int i = field.y - 1; i < field.y + 2; i++) {
            for (int j = field.x - 1; j < field.x + 2; j++) {
                if (i >= 0 && i < SIDE &&
                        j >= 0 && j < SIDE &&
                        (i != field.y || j != field.x)) {
                    list.add(gameField[i][j]);
                }
            }
        }
        return list;
    }

    private void countNeighbors(GameObject field) {
        List<GameObject> list = getNeighbors(field);
        int count = 0;
        for (GameObject o : list) {
            if (o.isMine)
                count++;
        }
        field.countMineNeighbors = count;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[j][i].isMine)
                    countNeighbors(gameField[j][i]);
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped){
            restart();
            return;
        }

        if (!(x >= 0 && x < SIDE && y >= 0 && y < SIDE)) return;
        openTile(x, y);
    }

    private void openTile(int x, int y) {
        if (isGameStopped || gameField[y][x].isFlag || gameField[y][x].isOpen) return;
        if (gameField[y][x].isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            if(countClosedTiles == SIDE*SIDE){restart(); openTile(x,y); return; }//первый ход не мина
            gameOver();
        } else {
            if (gameField[y][x].countMineNeighbors != 0)
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            else
                setCellValue(x, y, "");
            setCellColor(x, y, Color.GREEN);

            score+=5;
            setScore(score);
        }
        gameField[y][x].isOpen = true;
        if (gameField[y][x].isFlag) {
            gameField[y][x].isFlag = false;
            countFlags++;
        }
        countClosedTiles--;

        if (countClosedTiles == countMinesOnField && !gameField[y][x].isMine)
            win();

        if (gameField[y][x].countMineNeighbors == 0 && !gameField[y][x].isMine) {
            List<GameObject> list = getNeighbors(gameField[y][x]);
            for (GameObject o : list) {
                if (!o.isOpen && !o.isMine)
                    openTile(o.x, o.y);
            }
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void markTile(int x, int y) {
        if (!gameField[y][x].isOpen && !isGameStopped) {

            if (!gameField[y][x].isFlag) {
                if (countFlags > 0) {
                    setCellValue(x, y, FLAG);
                    setCellColor(x, y, Color.YELLOW);
                    gameField[y][x].isFlag = true;
                    countFlags--;
                }
            } else {
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
                gameField[y][x].isFlag = false;
                countFlags++;
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.ALICEBLUE, "GAME OVER", Color.RED, 50);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.ALICEBLUE, "YOU WIN ):", Color.GREEN, 50);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();
    }


}


