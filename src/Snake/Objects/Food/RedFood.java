package Snake.Objects.Food;

import Snake.GameOptions;
import Snake.Objects.ProduceFood;

import java.awt.*;
import java.util.ArrayList;

public class RedFood extends Food {
    public RedFood(GameOptions gO) {
        super(gO);
        takeEmptySpace(gO.getDirectionX(), gO.getDirectionY());  // ищем пустые клеточки для спавна Food
        if(listX.isEmpty() || listY.isEmpty()){                 // если места нет то спавним другую еду
            gO.getGameObjects().remove(this);
            gO.getGameObjects().revalidate();
            gO.getGameObjects().repaint();
            gO.getGameObjects().add(new ProduceFood().produceFood(gO));
        }
        int index = randPosFood(listX);
        gO.setFoodX(listX.get(index));              // получеам координаты x и y для еды
        gO.setFoodY(listY.get(index));
        listX.clear();                              // очищаем листы перед следующей едой
        listY.clear();
    }                                               // последующие объекты Food создаются аналогично

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawFood(g);
    }

    @Override
    public void drawFood(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(gO.getPositionX()[gO.getFoodY()][gO.getFoodX()], gO.getPositionY()[gO.getFoodY()][gO.getFoodX()],
                gO.getSNAKE_SIZE(), gO.getSNAKE_SIZE());
        checkRules();
    }

    @Override
    protected void takeEmptySpace(int[][] directionX, int[][] directionY) {
        for (int i = 0; i < directionY.length; i++) {
            for (int j = 0; j < directionX.length; j++) {
                if(directionX[i][j] == 0 && directionY[i][j] == 0){
                    if(j > i) {
                        listX.add(j);
                        listY.add(i);
                    }
                }
            }
        }
    }

    @Override
    protected int randPosFood(ArrayList<Integer> value) {
        return ((int) (Math.random() * value.size()));
    }
}
