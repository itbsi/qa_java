package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestCat  {

    @Test
    public void getSoundReturnsCatMeow() {
        Cat cat = new Cat(new Feline());
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("Метод getSound вернул не корректное значение", expectedSound, actualSound);
    }

    @Test
    public void getFoodReturnsCatPredatorFood() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        assertEquals("Метод getFood вернул не корректное значение", expectedFood, actualFood);
    }

}
