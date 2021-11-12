package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLionParameterized {

    @Mock
    Feline feline;

    private final String sexType;
    private final boolean expected;

    public TestLionParameterized(String sexType, boolean expected) {
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
    public void doesHaveManeReturnsManeAvailability() throws Exception {
        Lion lion = new Lion(sexType, feline);
        boolean actualMane = lion.doesHaveMane();
        assertEquals("Метод doesHaveMane вернул не корректное значение", expected, actualMane);
    }

}
