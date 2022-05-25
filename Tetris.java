package demo1;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaParam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tetris extends JPanel {
    //声明正在下落的方块
    private Tetromino currentOne = Tetromino.randomOne();
    //声明将要下落的方块
    private Tetromino nextOne = Tetromino.randomOne();
    //声明游戏主区域
    private Cell[][] wall = new Cell[18][9];
    //声明单元格的值为49像素
    private static final int CELL_SIZE = 49;

    //声明游戏分数池
    int[] scores_pool={0,1,2,5,10};
    //声明当前获得游戏总分
    private int totalScore = 0;
    //声明已消除的行数
    private int totalLine = 0;

    //声明游戏三种状态：游戏中、暂停、休息结束
    public static final int PLAYING = 0;
    public static final int PAUSE = 1;
    public static final int GAMEOVER = 2;
    //声明变量存放当前的状态的值
    private int game_state = 2;
    //声明一格数组，用来显示游戏状态
    String[] show_state ={"开始","暂停","GaveOver!"};


    public static BufferedImage I;
    public static BufferedImage J;
    public static BufferedImage L;
    public static BufferedImage O;
    public static BufferedImage S;
    public static BufferedImage T;
    public static BufferedImage Z;
    public static BufferedImage backIamge;

    static {
        try {
            backIamge = ImageIO.read(new File("src/images/background.png"));
            I = ImageIO.read(new File("src/images/A.png"));
            J = ImageIO.read(new File("src/images/A.png"));
            L = ImageIO.read(new File("src/images/A.png"));
            O = ImageIO.read(new File("src/images/A.png"));
            S = ImageIO.read(new File("src/images/A.png"));
            T = ImageIO.read(new File("src/images/A.png"));
            Z = ImageIO.read(new File("src/images/A.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backIamge,0,0,null);
        //平移坐标轴
        g.translate(38,30);
        //绘制游戏主区域
        paintWall(g);
        //绘制正在下落的四方格
        paintCurrentOne(g);
        //绘制将要下落的四方格
        paintNextOne(g);
        //绘制消除行数和比分
        paintScore(g);
        //绘制游戏当前的状态
        paintState(g);
    }
    //创建消行方法
    public void destroyLine(){
        int line = 0;
        Cell[] cells = currentOne.cells;
        for (Cell cell : cells){
            int row = cell.getRow();
            //判断当前行是否已满
            if (isFullLine(row)){
                line++;
                for (int i = 0; i > 0  ; i--) {

                }
            }
        }
    }
    //判断当前行是否已满
    public boolean isFullLine(int row){
        Cell[] cells = wall[row];
        for (Cell cell : cells){
            if (cell == null){
                return false;
            }
        }
        return true;
    }
    //判断游戏是否结束
    public boolean isGameOver(){
        Cell[] cells = nextOne.cells;
        for (Cell cell:cells){
            int row = cell.getRow();
            int col = cell.getCol();
            if (wall[row][col] != null){
                return true;
            }
        }
        return false;
    }

    private void paintState(Graphics g) {
        if (game_state == PLAYING){
            g.drawString(show_state[0],550,640);
        }else if (game_state == PAUSE){
            g.drawString(show_state[1],550,640);
        }else if (game_state == GAMEOVER){
            g.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,50));
            g.setColor(Color.red);
            g.drawString(show_state[2],110,400);
        }
    }

    private void paintScore(Graphics g) {
        g.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,50));
        g.drawString("比分："+ totalLine , 500,280);
        g.drawString("消除行："+totalLine,500,450);

    }

    private void paintNextOne(Graphics g) {
        Cell[] cells = nextOne.cells;
        for (Cell cell : cells){
            int x = cell.getCol() * CELL_SIZE+380;
            int y = cell.getRow() * CELL_SIZE+40;
            g.drawImage(cell.getImage(),x,y,null);
        }
    }

    /**
     *
     * @param g 这是传过来的画笔
     *   遍历图形的每一个小方块的位置。x，y
     */
    private void paintCurrentOne(Graphics g) {
        Cell[] cells = currentOne.cells;
        for (Cell cell : cells){
            int x = cell.getCol() * CELL_SIZE;
            int y = cell.getRow() * CELL_SIZE;
            g.drawImage(cell.getImage(),x,y,null);
        }
    }


    private void paintWall(Graphics g) {
        for (int i = 0; i <wall.length ; i++) {
            for (int j = 0; j <wall[i].length ; j++) {
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;
                Cell cell = wall[i][j];
                if (cell == null){
                    g.drawRect(x,y,CELL_SIZE,CELL_SIZE);
                }else {
                    g.drawImage(cell.getImage(),x,y,null);
                }
            }
        }
    }
  //判断游戏是否出界
    public boolean outOfBounds(){
        Cell[] cells = currentOne.cells;
        for (Cell cell : cells){
            int col = cell.getCol();
            int row = cell.getRow();
            if (row < 0 || row > wall.length-1 || col < 0 || col > wall[0].length){
                return true;
            }
        }
        return false;
    }
    //判断方块是否重合
    public boolean coincide(){
        Cell[] cells = currentOne.cells;
        for (Cell cell : cells){
            int row = cell.getRow();
            int col = cell.getCol();
            if (wall[row][col] != null){
                return true;
            }
        }
        return false;
    }
    //按键一次四方格左移一次
    public void moveLeftAction(){
        currentOne.moveLeft();
        if (outOfBounds() || coincide()){
            currentOne.moveRight();
        }
    }
    //按键一次四方格右移一次
    public void moveRightAction(){
        currentOne.moveRight();
        //判断死否越界
        if (outOfBounds() || coincide()){
            currentOne.moveLeft();
        }
    }
    public static void main(String[] args) {
        //创建一个窗口对象
        JFrame frame = new JFrame("俄罗斯方块");
        //创建游戏界面
        Tetris panel = new Tetris();
        //将面板嵌入进窗口中
        frame.add(panel);
        //设置可见
        frame.setVisible(true);
        //设置窗口大小
        frame.setSize(850,990);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置关闭窗口时程序终止
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
