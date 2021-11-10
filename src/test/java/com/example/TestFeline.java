package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestFeline {

    Feline feline = new Feline();

    @Test
    public void getFoodReturnsFelinePredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Метод getFood вернул не корректное значение", expectedFood, actualFood);
    }

    @Test
    public void getFamilyReturnsFelineFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Метод getFamily вернул не корректное значение", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnsFelineKittensCount() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals("Метод getKittens вернул не корректное значение", expectedKittensCount, actualKittensCount);
    }

}
