package com.javarush.task.task35.task3513;

import java.awt.*;

/**
 * класс описывающий одну плитку
 */
public class Tile {
    int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    /**
     * @return клетка пустая если ее значение 0
     */
    public boolean isEmpty() {
        return this.value == 0 ? true : false;
    }

    /**
     * @return цвет текста плитки в зависимости от значения
     */
    public Color getFontColor() {
        if (value < 16) {
            return new Color(0x776e65);
        } else {
            return new Color(0xf9f6f2);
        }
    }

    /**
     * @return цвет плитки в зависимости от значения
     */
    public Color getTileColor() {
        Color tileColor = null;
        switch (this.value) {
            case 0:
                tileColor = new Color(0xcdc1b4);
                break;
            case 2:
                tileColor = new Color(0xeee4da);
                break;
            case 4:
                tileColor = new Color(0xede0c8);
                break;
            case 8:
                tileColor = new Color(0xf2b179);
                break;
            case 16:
                tileColor = new Color(0xf59563);
                break;
            case 32:
                tileColor = new Color(0xf67c5f);
                break;
            case 64:
                tileColor = new Color(0xf65e3b);
                break;
            case 128:
                tileColor = new Color(0xedcf72);
                break;
            case 256:
                tileColor = new Color(0xedcc61);
                break;
            case 512:
                tileColor = new Color(0xedc850);
                break;
            case 1024:
                tileColor = new Color(0xedc53f);
                break;
            case 2048:
                tileColor = new Color(0xedc22e);
                break;
            default:
                tileColor = new Color(0xff0000);
                break;
        }
        return tileColor;
    }
}
