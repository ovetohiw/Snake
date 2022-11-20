package Snake.Objects.Food;

import Snake.GameOptions;
public class FoodFactory { // класс для поределения типа Food
    public Food getFood(FoodType type, GameOptions gO){
        Food food = null;
        switch (type){
            case RED:{
                food = new RedFood(gO);
                break;
            }
            case ORANGE:{
                food = new OrangeFood(gO);
                break;
            }
            case PURPLE:{
                food = new PurpleFood(gO);
                break;
            }
        }
        return food;
    }
}
