package demo1;

public class Z extends Tetromino{
    public Z(){
        cells[0] = new Cell(1,4,Tetris.Z);
        cells[1] = new Cell(0,3,Tetris.Z);
        cells[2] = new Cell(0,4,Tetris.Z);
        cells[3] = new Cell(1,6,Tetris.Z);
        //共计两种旋转状态
        states = new State[2];
        //初始化两种状态的初始化坐标
        states[0] = new State(1,0,0,-1,0,0,1,1);
        states[1] = new State(0,0,-1,1,0,1,1,0);

    }
}
