package demo1;

public class S extends Tetromino{
    public S(){
        cells[0] = new Cell(0,4,Tetris.I);
        cells[1] = new Cell(0,5,Tetris.I);
        cells[2] = new Cell(1,3,Tetris.I);
        cells[3] = new Cell(1,4,Tetris.I);
        //共计两种旋转状态
        states = new State[2];
        //初始化两种状态的初始化坐标
        states[0] = new State(0,0,0,1,1,-1,1,0);
        states[1] = new State(0,0,1,0,-1,-1,0,-1);
    }
}
