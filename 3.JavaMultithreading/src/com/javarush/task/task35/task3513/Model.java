package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * модль поля
 * FIELD_WIDTH размер поля
 * gameTiles массив плиток поля
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int maxTile = 0;
    int score = 0;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;


    /**
     * автоход
     */
    public void autoMove() {
        PriorityQueue<MoveEfficiency> pQueue = new PriorityQueue(4, Collections.reverseOrder());

        pQueue.offer(getMoveEfficiency(this::left));
        pQueue.offer(getMoveEfficiency(this::right));
        pQueue.offer(getMoveEfficiency(this::up));
        pQueue.offer(getMoveEfficiency(this::down));

        pQueue.poll().getMove().move();


    }

    /**
     * @param move входной параметр
     * @return возвращает объект типа MoveEfficiency описывающий эффективность переданного хода
     */
    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = null;
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move, this);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move, this);
        }
        rollback();
        return moveEfficiency;
    }

    /**
     * @return будет возвращать true, в случае, если вес плиток в массиве gameTiles
     * отличается от веса плиток в верхнем массиве стека previousStates
     */
    public boolean hasBoardChanged() {
        Tile[][] stacktiles = previousStates.peek();
        int a = getWeightOfTiles(gameTiles);
        int b = getWeightOfTiles(stacktiles);
        return a != b;
    }

    /**
     * @param tiles входной массив плиток
     * @return возвращает вес всех плиток
     */
    private int getWeightOfTiles(Tile[][] tiles) {
        int weight = 0;
        for (int y = 0; y < FIELD_WIDTH; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                weight += tiles[y][x].value;
            }
        }
        return weight;
    }

    /**
     * сохраняет текущее состояние игры
     *
     * @param tiles текущее состояние поля
     */
    private void saveState(Tile[][] tiles) {
        Tile[][] newtiles = getTilesArray();
        copyValuesOfTiles(tiles, newtiles);
        previousStates.push(newtiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    /**
     * @return возвращает новый массив плиток
     */
    private Tile[][] getTilesArray() {
        Tile[][] newtiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int y = 0; y < FIELD_WIDTH; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                newtiles[y][x] = new Tile();
            }
        }
        return newtiles;
    }

    /**
     * копирает значение плиток из одного массива в другой
     *
     * @param from исходный массив
     * @param to   конечный массив
     */
    private void copyValuesOfTiles(Tile[][] from, Tile[][] to) {
        for (int y = 0; y < FIELD_WIDTH; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                to[y][x].value = from[y][x].value;
            }
        }
    }

    /**
     * возвращает предыдущее состояние игры
     */
    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            this.gameTiles = previousStates.pop();
            this.score = previousScores.pop();
        }
    }

    public static int getFieldWidth() {
        return FIELD_WIDTH;
    }

    /**
     * @return возвращает массив плиток
     */
    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    /**
     * @return есть ли возможность сделать хоть какой-то ход
     */
    public boolean canMove() {
        boolean canMove = false;
        if (getEmptyTiles().size() > 0) {
            canMove = true;
        }
        for (int y = 0; y < FIELD_WIDTH; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                if (canTileMerge(x, y)) {
                    canMove = true;
                }
            }
        }

        return canMove;
    }

    /**
     * @param x координата x проверяемой плитки
     * @param y координата x проверяемой плитки
     * @return естьли рядом с текущей плиткой соседняя для объединения
     */
    public boolean canTileMerge(int x, int y) {
        if (x < 0 || x >= FIELD_WIDTH || y < 0 || y >= FIELD_WIDTH) {
            return false;
        }

        boolean canTileMerge = false;
        if (x - 1 >= 0 && gameTiles[y][x].value == gameTiles[y][x - 1].value) {
            canTileMerge = true;
        }
        if (x + 1 < FIELD_WIDTH && gameTiles[y][x].value == gameTiles[y][x + 1].value) {
            canTileMerge = true;
        }
        if (y - 1 >= 0 && gameTiles[y][x].value == gameTiles[y - 1][x].value) {
            canTileMerge = true;
        }
        if (y + 1 < FIELD_WIDTH && gameTiles[y][x].value == gameTiles[y + 1][x].value) {
            canTileMerge = true;
        }

        return canTileMerge;
    }

    public Model() {
        resetGameTiles();
    }

    /**
     * сдвиг всего поля влево и объединение
     * также добавляет новую плитку если поле помянялось
     * isChanged  - поле удалось сдвинуть влево
     */
    void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) { // не менять на ленивый ИЛИ
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
        isSaveNeeded = true;
    }

    /**
     * аналог {@link #left}) но right
     */
    void right() {
        saveState(gameTiles);
        rotateMatrix(gameTiles);
        rotateMatrix(gameTiles);
        left();
        rotateMatrix(gameTiles);
        rotateMatrix(gameTiles);
    }

    /**
     * аналог {@link #left}) но up
     */
    void up() {
        saveState(gameTiles);
        rotateMatrix(gameTiles);
        left();
        rotateMatrix(gameTiles);
        rotateMatrix(gameTiles);
        rotateMatrix(gameTiles);
    }

    /**
     * аналог {@link #left}) но down
     */
    void down() {
        saveState(gameTiles);
        rotateMatrix(gameTiles);
        rotateMatrix(gameTiles);
        rotateMatrix(gameTiles);
        left();
        rotateMatrix(gameTiles);
    }

    /**
     * поворот матрицы на 90 градусов
     *
     * @param mat матрица которую крутим
     */
    // An Inplace function to rotate a N x N matrix
    // by 90 degrees in anti-clockwise direction
    static void rotateMatrix(Tile mat[][]) {
        int N = FIELD_WIDTH;
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N - x - 1; y++) {
                // store current cell in temp variable
                Tile temp = mat[x][y];

                // move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // move values from bottom to right
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

                // move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    /**
     * сжатие плиток влево в строке
     * isChanged  - изменялся ли массив
     *
     * @param tiles строка плиток
     */
    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length - 1; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    Tile temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    /**
     * объединение плиток влево в строке
     * isChanged  - изменялся ли массив
     *
     * @param tiles строка плиток
     */
    private boolean mergeTiles(Tile[] tiles) {
        int i = 0;
        boolean isChanged = false;
        while (i < tiles.length - 1) {
            if (tiles[i].value != 0 && tiles[i].value == tiles[i + 1].value) {
                tiles[i].value = tiles[i].value * 2;
                tiles[i + 1].value = 0;
                score += tiles[i].value;
                maxTile = maxTile < tiles[i].value ? tiles[i].value : maxTile;
                i++;
                isChanged = true;
            }
            i++;
        }
        if (isChanged) {
            compressTiles(tiles);
        }
        return isChanged;
    }

    /**
     * @return список пустых клеток на поле
     */
    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int y = 0; y < FIELD_WIDTH; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                if (gameTiles[y][x].value == 0) {
                    tiles.add(gameTiles[y][x]);
                }
            }
        }
        return tiles;
    }

    /**
     * добавление случайной плитки на поле
     */
    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            Tile tile = emptyTiles.get(((int) (Math.random() * emptyTiles.size())));
            tile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    /**
     * сброс игры к стандартным начальным значениям
     */
    void resetGameTiles() {
        for (int y = 0; y < FIELD_WIDTH; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                gameTiles[y][x] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    /**
     * совершает случайных од на поле
     */
    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }
}
