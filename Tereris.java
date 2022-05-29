

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Tertris1 extends JFrame {

    public void initWindow() {
        //设置窗口大小
        this.setSize(600,850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //设置标题
        this.setTitle("我的俄罗斯方块游戏");
    }

    public Tertris1() {
        initWindow();
    }

    public static void main(String[] args) {
        Tertris tertris = new Tertris();
    }

}
public class Tereris {
}

class Tertris extends JFrame{
    //游戏的行数26,列数12
    private static final int game_x = 26;
    private static final int game_y = 12;
    //文本域数组
    JTextArea[][] text;
    //二维数组
    int[][] data;

    public void initWindow() {
        //设置窗口大小
        this.setSize(600,850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //设置标题
        this.setTitle("我的俄罗斯方块游戏");
    }

    //初始化游戏界面
    public void initGamePanel() {
        JPanel game_main = new JPanel();
        game_main.setLayout(new GridLayout(game_x,game_y,1,1));
        //初始化面板
        //添加到窗口中
    }

    public Tertris() {
        text = new JTextArea[game_x][game_y];
        data = new int[game_x][game_y];
        initWindow();
    }

    public static void main(String[] args) {
        Tertris tertris = new Tertris();
    }

}
