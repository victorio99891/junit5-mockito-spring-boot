package pl.wiktor.reflection;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionTest {


    @Test
    void simpleTest() throws Exception {

        Class<?> mockClass = Class.forName("pl.wiktor.reflection.Tricky");

        Constructor<?> constructor = mockClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        Field field = mockClass.getDeclaredField("text");
        field.setAccessible(true);

        Object obj = constructor.newInstance("Test");

        assertEquals("Test", field.get(obj));

    }


    @Test
    void anotherSimpleTest() throws Exception {

        Class<?> mockClass = Class.forName("pl.wiktor.reflection.AnotherOne");

        Object obj = mockClass.newInstance();

        ((AnotherOne) obj).setName("Wiktor");

        Field field = mockClass.getDeclaredField("name");
        field.setAccessible(true);

        assertEquals("Wiktor", field.get(obj));


    }


}
