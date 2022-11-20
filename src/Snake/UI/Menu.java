package Snake.UI;

import Snake.GameObjects;
import Snake.GameOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Menu extends JPanel implements ActionListener {

    GameOptions gO;
    JButton new_game;
    JButton exit;

    public Menu(GameOptions gO) {               // в данном классе создаем кнопки New Game и Exit. Также jlabel с рекрдом
        if (!gO.isStart()) {
            this.gO = gO;
            this.setSize(gO.getSCREEN_WIDTH(), gO.getSCREEN_HEIGHT());
            this.setBackground(Color.LIGHT_GRAY);
            this.setFocusable(false);
            this.setLayout(null);
            this.setVisible(true);

            JLabel pane = new JLabel();        // jlabel с рекордом
            pane.setBounds(gO.getSCREEN_WIDTH() / 2 - 25, gO.getSCREEN_HEIGHT() / 2 - 200, 200, 50);

            String text;
            try {
                text = Files.readString(Path.of("Record"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            pane.setText("Record: " + text);  // считаываем номер из файла с рекордом и добавляем
            pane.setVisible(true);

            new_game = new JButton("New Game");  // создаем кнопку New Game
            new_game.setBounds(gO.getSCREEN_WIDTH() / 2 - 100, gO.getSCREEN_HEIGHT() / 2 - 100, 200, 50);
            new_game.addActionListener(this);
            new_game.setVisible(true);

            exit = new JButton("Exit");    // создаем кнопку Exit
            exit.setBounds(gO.getSCREEN_WIDTH() / 2 - 100, gO.getSCREEN_HEIGHT() / 2, 200, 50);
            exit.addActionListener(this);
            exit.setVisible(true);

            this.add(pane);
            this.add(new_game);     // добавляем все компоненты
            this.add(exit);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new_game) {          // при нажатии копки New Game будем удалять объект Menu и на его место добавлять GameObjects
            gO.setStart(true);
            gO.getPlayGround().removeAll();
            gO.getPlayGround().revalidate();
            gO.getPlayGround().repaint();
            gO.getPlayGround().add(new GameObjects(gO).getGameObjects());
        }
        if (e.getSource() == exit) {            // при нажатии Exit закрываем окно
            System.exit(0);
        }
    }
}
