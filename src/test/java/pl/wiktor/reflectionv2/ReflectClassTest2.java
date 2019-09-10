package pl.wiktor.reflectionv2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectClassTest2 {


    @Test
    void simpleTest() throws Exception {

        Class<?> newClass = Class.forName("pl.wiktor.reflectionv2.ReflectClass");

        Constructor<?>[] constructorList = newClass.getDeclaredConstructors();

        Constructor<?> constructor1 = newClass.getDeclaredConstructor();
        constructor1.setAccessible(true);
//        System.out.println(constructor1.toString());

        Constructor<?> constructor2 = newClass.getDeclaredConstructor(String.class);
//        System.out.println(constructor2.toString());

        Constructor<?> constructor3 = newClass.getDeclaredConstructor(int.class);
//        System.out.println(constructor3.toString());

        ReflectClass reflect = (ReflectClass) constructor1.newInstance();
        reflect.printText();


        // EXPECTED
        reflect.setText("CHUJ!");


        Field filed = newClass.getDeclaredField("text");
        filed.setAccessible(true);

        String chuj = filed.get(reflect).toString();


        System.out.println(chuj);


        assertEquals("CHUJ!", filed.get(reflect).toString());






    }
}
