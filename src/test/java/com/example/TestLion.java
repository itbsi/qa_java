package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLion {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    private final String sexType;
    private final boolean expected;

    public TestLion(String sexType, boolean expected) {
        this.sexType = sexType;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getMane() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getKittensReturnsLionKittensCount() throws Exception {
        Lion lion = new Lion(sexType, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittensCount = lion.getKittens();
        assertEquals("Метод getKittens вернул не корректное значение", 1, kittensCount);
    }

    @Test
    public void doesHaveManeReturnsManeAvailability() throws Exception {
        Lion lion = new Lion(sexType, feline);
        boolean actualMane = lion.doesHaveMane();
        assertEquals("Метод doesHaveMane вернул не корректное значение", expected, actualMane);
    }

    @Test
    public void getFoodReturnsLionPredatorFood() throws Exception {
        Lion lion = new Lion(sexType, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
