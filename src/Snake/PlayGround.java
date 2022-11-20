package Snake;

import Snake.UI.Menu;

import javax.swing.*;
import java.awt.*;

public class PlayGround {

    JPanel playGround;
    GameOptions gO;
    public PlayGround(GameOptions gO){
        playGround = new JPanel();
        this.gO = gO;
        playGround.setPreferredSize(new Dimension(gO.getSCREEN_WIDTH(), gO.getSCREEN_HEIGHT()));
        playGround.setBackground(Color.LIGHT_GRAY);
        playGround.setFocusable(true);
        playGround.setLayout(null);

        gO.setPlayGround(playGround);
        /* передаем компонент jpanel в GameOptions тк нам нужно будет передавать его в другие классы
        но эти классы достаточно далеко поэтому так будет проще
        */
        playGround.add(new Menu(gO)); // добавляем класс меню
    }

    public JPanel getPlayGround() {
        return playGround;
    }

}
