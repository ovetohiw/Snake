package Snake.Objects;

import Snake.GameOptions;

import javax.swing.*;
import java.awt.*;

public class DrawGrid extends JLabel{  // в этом классе просто рисуем сетку для змейки

    GameOptions gO;
    public DrawGrid(GameOptions gO) {
        this.gO = gO;
        this.setSize(gO.getSCREEN_WIDTH(), gO.getSCREEN_HEIGHT());
        this.setVisible(gO.isStart());
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawGrid(g);
    }

    public void drawGrid(Graphics g) {
        int SNAKE_SIZE = gO.getSNAKE_SIZE();
        int w = gO.getSCREEN_WIDTH();
        int h = gO.getSCREEN_HEIGHT();
        int dw = w / SNAKE_SIZE;
        int dh = h / SNAKE_SIZE;
        g.setColor(Color.BLACK);
        for (int i = 0; i < dw; i++) {
            g.drawLine(i * SNAKE_SIZE, 0, i * SNAKE_SIZE, h);
            for (int j = 0; j < dh; j++) {
                g.drawLine(0, j * SNAKE_SIZE, w, j * SNAKE_SIZE);
            }
        }
    }
}
