package Snake.Objects.Food;

import Snake.GameOptions;
import Snake.Objects.ProduceFood;

import java.awt.*;
import java.util.ArrayList;

public class OrangeFood extends Food {


    public OrangeFood(GameOptions gO) {
        super(gO);
        takeEmptySpace(gO.getDirectionX(), gO.getDirectionY());
        if(listX.isEmpty() || listY.isEmpty()){
            gO.getGameObjects().remove(this);
            gO.getGameObjects().revalidate();
            gO.getGameObjects().repaint();
            gO.getGameObjects().add(new ProduceFood().produceFood(gO));
        }
        int index = randPosFood(listX);
        gO.setFoodX(listX.get(index));
        gO.setFoodY(listY.get(index));
        listX.clear();
        listY.clear();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawFood(g);
    }

    @Override
    public void drawFood(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(gO.getPositionX()[gO.getFoodY()][gO.getFoodX()], gO.getPositionY()[gO.getFoodY()][gO.getFoodX()],
                gO.getSNAKE_SIZE(), gO.getSNAKE_SIZE());

        checkRules();
    }

    @Override
    protected void takeEmptySpace(int[][] directionX, int[][] directionY) {
        for (int i = 0; i < directionY.length; i++) {
            for (int j = 0; j < directionX.length; j++) {
                if(directionX[i][j] == 0 && directionY[i][j] == 0){
                    if(i > j) {
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
