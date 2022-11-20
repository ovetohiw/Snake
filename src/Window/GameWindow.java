package Window;

import Snake.Controller;
import Snake.GameOptions;
import Snake.PlayGround;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameWindow {

    GameOptions gO;                                         // объявляем класс со всеми переменными
    public GameWindow() {                                   // создаем главное окно
        JFrame window = new JFrame("Snake");
        gO = new GameOptions();
        gO.setSCREEN_WIDTH(500);                            // задаем переменные ширины, высоты окна и размер змейки
        gO.setSCREEN_HEIGHT(500);
        gO.setSNAKE_SIZE(50);
        gO.setStart(false);                                 // ставим переменную Start на false
        Controller controller = new Controller(gO);         // создаем контроллер для змейки
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.setFocusable(true);
        window.addKeyListener(controller);                  // добавляем контроллер на jframe
        window.setLocation(0, 0);
        window.add(new PlayGround(gO).getPlayGround());     // добавляем на jframe компонент jpanel
        window.pack();                                      // упаковываем jframe по минимально необходимым размерам
    }
}
