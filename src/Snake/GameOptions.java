package Snake;

import javax.swing.*;

public class GameOptions {


    private int SCREEN_HEIGHT;
    private int SCREEN_WIDTH;
    private int SNAKE_SIZE;
    private int[][] positionX;
    private int[][] positionY;
    private int[][] directionX;
    private int[][] directionY;
    private int snake_length, x, y, step_x, step_y, foodX, foodY;
    private boolean Start;

    private JPanel playGround;
    private JPanel gameObjects;

    public GameOptions() {

    }

    public JPanel getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(JPanel gameObjects) {
        this.gameObjects = gameObjects;
    }

    public JPanel getPlayGround() {
        return playGround;
    }

    public void setPlayGround(JPanel playGround) {
        this.playGround = playGround;
    }

    public boolean isStart() {
        return Start;
    }

    public void setStart(boolean start) {
        Start = start;
    }

    public void setPositionX(int[][] positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int[][] positionY) {
        this.positionY = positionY;
    }

    public void setDirectionX(int[][] directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(int[][] directionY) {
        this.directionY = directionY;
    }

    public int getSnake_length() {
        return snake_length;
    }

    public void setSnake_length(int snake_length) {
        this.snake_length = snake_length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep_x() {
        return step_x;
    }

    public void setStep_x(int step_x) {
        this.step_x = step_x;
    }

    public int getStep_y() {
        return step_y;
    }

    public void setStep_y(int step_y) {
        this.step_y = step_y;
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }

    public int getSIZE_X(){
        return getSCREEN_WIDTH()/getSNAKE_SIZE();
    }

    public int getSIZE_Y(){
        return getSCREEN_HEIGHT()/getSNAKE_SIZE();
    }

    public int[][] getPositionX() {
        return positionX;
    }

    public int[][] getPositionY() {
        return positionY;
    }

    public int[][] getDirectionX() {
        return directionX;
    }

    public int[][] getDirectionY() {
        return directionY;
    }

    public void setSCREEN_HEIGHT(int SCREEN_HEIGHT) {
        this.SCREEN_HEIGHT = SCREEN_HEIGHT;
    }

    public void setSCREEN_WIDTH(int SCREEN_WIDTH) {
        this.SCREEN_WIDTH = SCREEN_WIDTH;
    }

    public void setSNAKE_SIZE(int SNAKE_SIZE) {
        this.SNAKE_SIZE = SNAKE_SIZE;
    }

    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public int getSNAKE_SIZE() {
        return SNAKE_SIZE;
    }
}
