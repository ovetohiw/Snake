package Snake;

import Snake.Objects.DrawGrid;
import Snake.Objects.DrawSnake;
import Snake.Objects.ProduceFood;

import javax.swing.*;
import java.awt.*;

public class GameObjects {

    JPanel gameObjects;
    GameOptions gO;
    ProduceFood produceFood;
    public GameObjects(GameOptions gO) {         // в данном классе создаем все объекты необходимые для игрыы
        this.gO = gO;
        gameObjects = new JPanel();
        produceFood = new ProduceFood();    // объявляем и инициализируем объект ProduceFood для создания еды
        gameObjects.setSize(gO.getSCREEN_WIDTH(),gO.getSCREEN_HEIGHT());
        gameObjects.setVisible(true);
        gameObjects.setLayout(null);
        gameObjects.setBackground(Color.LIGHT_GRAY);
        gameObjects.add(new DrawGrid(gO));
        gameObjects.add(new DrawSnake(gO));
        gameObjects.add(produceFood.produceFood(gO));  // добавляем Factory для еды
        gO.setGameObjects(gameObjects);                // сохраняем объект в GameOptions для дальнейшей передачи
    }

    public JPanel getGameObjects() {
        return gameObjects;
    }
}
