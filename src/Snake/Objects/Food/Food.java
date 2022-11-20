package Snake.Objects.Food;

import Snake.GameOptions;
import Snake.Objects.ProduceFood;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Food extends JLabel { // абстрактный класс для Food

    protected ArrayList<Integer> listX;
    protected ArrayList<Integer> listY;
    protected GameOptions gO;

    public Food(GameOptions gO) {
        this.gO = gO;
        this.setSize(gO.getSCREEN_WIDTH(), gO.getSCREEN_HEIGHT());
        this.setVisible(gO.isStart());
        this.setLayout(null);
        listX = new ArrayList<>();
        listY = new ArrayList<>();
    }

    protected void checkRules() {
        if (gO.getX() == gO.getFoodX() && gO.getY() == gO.getFoodY()) {     // если змейка съела еду то добавляем к длине зиейки и спавним новый Food
            gO.getGameObjects().remove(this);
            gO.getGameObjects().revalidate();
            gO.getGameObjects().repaint();
            gO.getGameObjects().add(new ProduceFood().produceFood(gO));
            gO.setSnake_length(gO.getSnake_length() + 1);
        }
    }

    protected abstract void takeEmptySpace(int[][] directionX, int[][] directionY);

    protected abstract void drawFood(Graphics g);

    protected abstract int randPosFood(ArrayList<Integer> value);
}
