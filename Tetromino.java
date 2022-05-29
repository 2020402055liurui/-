package demo1;

import java.util.concurrent.Callable;

/*
编写四方格父类
属性：Cell数组用于创建4个小方块
方法：左移一格，右移一格，下落一格；变形（暂不考虑）
 */
public class Tetromino {
    private Cell[] cells = new Cell[4];

    //编写左移方法
    public void moveLeft() {
        for (Cell cell : cells) {
            cell.left();
        }
    }

    //编写右移方法
    public void moveRight() {
        for (Cell cell : cells) {
            cell.right();
        }
    }
    //编写下落方法
    public void softDrop() {
        for (Cell cell : cells) {
            cell.drop();
        }
    }

}

