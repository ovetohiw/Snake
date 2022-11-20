package Snake.Objects;


import Snake.GameOptions;
import Snake.UI.Menu;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class DrawSnake extends JLabel { // класс с рисованием змейки

    GameOptions gO;
    public DrawSnake(GameOptions gO){
        this.gO = gO;
        this.setSize(gO.getSCREEN_WIDTH(), gO.getSCREEN_HEIGHT());
        this.setVisible(gO.isStart());
        this.setLayout(null);
        prepareGame();          // подготовка всем переменных для старта
    }

    private void prepareGame() {
        int SIZE_X = gO.getSIZE_X();
        int SIZE_Y = gO.getSIZE_Y();
        int[][] temp_positionX = new int[SIZE_Y][SIZE_X];
        int[][] temp_positionY = new int[SIZE_Y][SIZE_X];
        int[][] temp_DirectionX = new int[SIZE_Y][SIZE_X];
        int[][] temp_DirectionY = new int[SIZE_Y][SIZE_X];
        int SNAKE_SIZE = gO.getSNAKE_SIZE();
        int poY = gO.getSCREEN_HEIGHT() / SNAKE_SIZE;
        int poX = gO.getSCREEN_WIDTH() / SNAKE_SIZE;
        for (int i = 0; i < poY; i++) {
            for (int j = 0; j < poX; j++) {
                temp_positionX[i][j] = j * SNAKE_SIZE;      // заполняем массив координатами для y
                temp_positionY[i][j] = i * SNAKE_SIZE;      // заполняем массив координатами для x
                temp_DirectionX[i][j] = 0;                  // массив для координации хвоста для x
                temp_DirectionY[i][j] = 0;                  // массив для координации хвоста для y
            }
        }
        gO.setPositionX(temp_positionX);
        gO.setPositionY(temp_positionY);
        gO.setDirectionX(temp_DirectionX);
        gO.setDirectionY(temp_DirectionY);
        gO.setSnake_length(4);
        gO.setStep_x(0);
        gO.setStep_y(-1);
        gO.setX((gO.getSCREEN_WIDTH() / gO.getSNAKE_SIZE()) / 2);     // задаем начальные коордиаты змейки по x
        gO.setY((gO.getSCREEN_HEIGHT() / gO.getSNAKE_SIZE()) / 2);    // задаем начальные координаты змейки по y
    }

    @Override
    public void paint(Graphics g) {   // класс отрисовки
        super.paint(g);
        moveSnake();
        drawSnake(g);
        try {
            int DELAY = 200;
            TimeUnit.MILLISECONDS.sleep(DELAY);  // интервал между следующей итерацией
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }

    private void moveSnake() {              // метод изменяющий положение головы змеи и записывающий ее след

        gO.setX((gO.getX() + gO.getStep_x()));
        gO.setY((gO.getY() + gO.getStep_y()));

        try {
            int[][] temp_DirectionX = gO.getDirectionX();
            int[][] temp_DirectionY = gO.getDirectionY();
            temp_DirectionX[gO.getY()][gO.getX()] = gO.getStep_x(); // следы змеи по x
            temp_DirectionY[gO.getY()][gO.getX()] = gO.getStep_y(); // след змеи по y
            gO.setDirectionX(temp_DirectionX);
            gO.setDirectionY(temp_DirectionY);
        } catch (ArrayIndexOutOfBoundsException e) {
            resetSnake();                                           // если след выходит за массив то game over
        }
    }

    private void drawSnake(Graphics g) {        // логика рисования змеи
        int posY = gO.getY();
        int posX = gO.getX();
        int temp_posY;
        int temp_posX;
        int SNAKE_SIZE = gO.getSNAKE_SIZE();
        int[][] temp_positionX = gO.getPositionX();
        int[][] temp_positionY = gO.getPositionY();
        int[][] temp_directionX = gO.getDirectionX();
        int[][] temp_directionY = gO.getDirectionY();
        g.setColor(Color.GRAY);
        for (int i = 0; i < gO.getSnake_length(); i++) {
            g.fillRect(temp_positionX[posY][posX], temp_positionY[posY][posX], SNAKE_SIZE, SNAKE_SIZE);   // рисуем первый элемент
            temp_posY = posY;                           // вспомогательные переменные
            temp_posX = posX;
            posY -= temp_directionY[temp_posY][temp_posX]; // из массива достаем след змейки и вычитаем его из первого/предыдущего элемента
            posX -= temp_directionX[temp_posY][temp_posX];
            if(gO.getX() == posX && gO.getY() == posY){    // если змейка сталкивается сама с собой game over
                resetSnake();
            }
            if(gO.getSnake_length() == (gO.getSCREEN_WIDTH()/gO.getSNAKE_SIZE() * gO.getSCREEN_HEIGHT()/gO.getSNAKE_SIZE())){
                resetSnake();           // если змейка полностью заняла поле win
            }
            if(i == gO.getSnake_length()-1){                // очищаем массивы с следом змейки
                temp_directionY[temp_posY][temp_posX] = 0;
                temp_directionX[temp_posY][temp_posX] = 0;
                gO.setDirectionX(temp_directionX);
                gO.setDirectionY(temp_directionY);
            }
        }
    }

    public void resetSnake(){ // при выполнении метода сравниваем значения с файла и переписываем Record
        String length;
        try {
            length = String.valueOf(Files.readString(Path.of("Record")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int record = Integer.parseInt(length);
        if((gO.getSnake_length()-4) > record) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Record",false));
                writer.write(String.valueOf(gO.getSnake_length()-4));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            gO.setStart(false);
            gO.getPlayGround().removeAll();
            gO.getPlayGround().revalidate();
            gO.getPlayGround().repaint();
            gO.getPlayGround().add(new Menu(gO));           // выходим в меню
            prepareGame();
    }
}
