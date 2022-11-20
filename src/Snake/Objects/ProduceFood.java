package Snake.Objects;

import Snake.GameOptions;
import Snake.Objects.Food.Food;
import Snake.Objects.Food.FoodFactory;
import Snake.Objects.Food.FoodType;

import java.util.Random;

public class ProduceFood {
    FoodFactory factory;
    Random random;
    FoodType type;

    public Food produceFood(GameOptions gO){      // в данном классе просто рандомим объект из фактори для добавления в GameObjects
        random = new Random();
        factory = new FoodFactory();
        type = FoodType.values()[random.nextInt(FoodType.values().length)];
        return factory.getFood(type, gO);
    }
}
